import React, { useState, useLayoutEffect, useRef, useContext } from "react";
import { Text } from "@clayui/core";
import ClayButton from "@clayui/button";
import { ClayIconSpriteContext } from "@clayui/icon";
import ClayForm, { Form } from "@clayui/form";
import { Context } from "@clayui/modal";
import SXFormField, {
	SXButtonWithIcon,
	SXLabeledText,
	validateForm,
	SelectDisplayStyle,
	SXGroup,
	SXLocalizedInput,
	SXDualListBox
} from "../../form/sxform";
import { Util } from "../../common/util";
import {
	EditStatus,
	LoadingStatus,
	Event,
	DataTypeProperty,
	ParamType,
	DisplayType,
	ValidationRule,
	ResourceIds,
	PortletKeys,
	WindowState,
	ViewTypes
} from "../../common/station-x";
import { DataStructure } from "../DSBuilder/data-structure";
import { DualListParameter, GroupParameter, Parameter, StringParameter } from "../../parameter/parameter";
import { SXModalDialog } from "../../modal/sxmodal";

export const DataTypeInfo = ({ title, abstract, items, colsPerRow = 1 }) => {
	let sectionContent;

	console.log("DataTypeInfo items: ", items);

	if (colsPerRow === 1) {
		sectionContent = items.map((item, index) => (
			<div
				class="form-group-item"
				key={index}
			>
				<SXLabeledText
					label={item.label}
					text={item.text}
				/>
			</div>
		));
	} else if (colsPerRow > 1) {
		let rows = Util.convertArrayToRows(items, colsPerRow);

		console.log("DataTypeInfo: rows ", rows);

		sectionContent = rows.map((row, rowIndex) => (
			<div
				key={rowIndex}
				className="form-group-autofit"
				style={{ marginBottom: "5px" }}
			>
				{row.map((col, colIndex) => (
					<div
						key={(rowIndex + 1) * (colIndex + 1)}
						className="form-group-item"
						style={{ marginBottom: "0" }}
					>
						<SXLabeledText
							label={col.label}
							text={col.text}
							viewType="INLINE_ATTACH"
						/>
					</div>
				))}
			</div>
		));
	}

	return (
		<div className="form-group sheet sheet-lg">
			<div
				className="sheet-header"
				style={{ marginBottom: "20px" }}
			>
				<h3
					className="sheet-title"
					style={{ marginBottom: "10px" }}
				>
					{title}
				</h3>
				<div
					className="sheet-text"
					style={{ marginBottom: "5px" }}
				>
					{abstract}
				</div>
			</div>
			<div
				className="sheet-section"
				style={{ marginBottom: "1rem" }}
			>
				{sectionContent}
			</div>
		</div>
	);
};

class DataTypeEditor extends React.Component {
	constructor(props) {
		super(props);

		console.log("DataTypeEditor: ", props);
		this.namespace = props.portletParameters.namespace;
		this.baseResourceURL = props.portletParameters.baseResourceURL;
		this.spritemap = props.portletParameters.spritemapPath;
		this.languageId = props.portletParameters.languageId;
		this.availableLanguageIds = props.portletParameters.availableLanguageIds;

		this.workbenchURL = props.portletParameters.params.workbenchURL;
		this.workbenchId = props.portletParameters.params.workbenchId;
		this.workbenchNamespace = props.portletParameters.params.workbenchNamespace;

		this.formId = this.namespace + "dataTypeEditor";
		this.formValues = {
			dataTypeVersion: "1.0.0"
		};

		this.formErrors = {};

		this.dirty = false;

		this.loadingFailMessage = "";
		this.state = {
			dataTypeId: props.portletParameters.params.dataTypeId,
			loadingStatus: LoadingStatus.PENDING,
			deleteConfirmDlgStatus: false,
			deleteSuccessDlgStatus: false,
			deleteErrorDlgStatus: false,
			deleteSuccessDlgStatus: false,
			saveSuccessDlgStatus: false,
			editStatus: props.portletParameters.params.dataTypeId > 0 ? EditStatus.UPDATE : EditStatus.ADD
		};

		this.nameProps = {
			paramName: DataTypeProperty.NAME,
			paramType: ParamType.STRING,
			label: Util.translate("parameter-code"),
			required: true,
			viewType: ViewTypes.NORMAL,
			placeholder: Util.translate("code-name"),
			tooltip: Util.translate("code-name-tooltip"),
			languageId: this.languageId,
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.NAME} is required`
				},
				pattern: {
					value: ValidationRule.VARIABLE,
					message: "Invalid data type name"
				},
				min: {
					value: 3,
					message: "Should be at least 3"
				},
				max: {
					value: 32,
					message: "Should be shorter than 33"
				}
			},
			value: ""
		};
		this.versionProps = {
			paramName: DataTypeProperty.VERSION,
			paramType: ParamType.STRING,
			label: Util.translate("version"),
			required: true,
			placeholder: "1.0.0",
			tooltip: Util.translate("version-tooltip"),
			languageId: this.languageId,
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.VERSION} is required`
				},
				pattern: {
					value: ValidationRule.VERSION,
					message: "Invalid data type version"
				}
			},
			value: "1.0.0"
		};
		this.extensionProps = {
			paramName: DataTypeProperty.EXTENSION,
			paramType: ParamType.STRING,
			label: Util.translate("extension"),
			required: true,
			placeholder: Util.translate("ext"),
			tooltip: Util.translate("extension-tooltip"),
			languageId: this.languageId,
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.EXTENSION}-is-required`
				},
				pattern: {
					value: ValidationRule.EXTENSION,
					message: "Invalid data type extension"
				},
				min: {
					value: 2,
					message: "Should be at least 2"
				},
				max: {
					value: 16,
					message: "Should be shorter than 17"
				}
			}
		};
		this.displayNameProps = {
			paramName: DataTypeProperty.DISPLAY_NAME,
			paramType: ParamType.LOCALIZED_STRING,
			label: Util.translate("display-name"),
			required: true,
			placeholder: Util.translate("display-name"),
			tooltip: Util.translate("display-name-tooltip"),
			languageId: this.languageId,
			availableLanguageIds: this.availableLanguageIds,
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.DISPLAY_NAME}-is-required`
				},
				min: {
					value: 3,
					message: "Must longer than 3"
				},
				max: {
					value: 64,
					message: "Must shorter than 64"
				}
			}
		};
		this.descriptionProps = {
			paramName: DataTypeProperty.DESCRIPTION,
			paramType: ParamType.LOCALIZED_STRING,
			label: Util.translate("description"),
			placeholder: Util.translate("description"),
			tooltip: Util.translate("description-tooltip"),
			multipleLine: true,
			languageId: this.languageId,
			availableLanguageIds: this.availableLanguageIds
		};
		this.tooltipProps = {
			paramName: DataTypeProperty.TOOLTIP,
			paramType: ParamType.LOCALIZED_STRING,
			label: Util.translate("tooltip"),
			placeholder: Util.translate("tooltip"),
			tooltip: Util.translate("tooltip-tooltip"),
			languageId: this.languageId,
			availableLanguageIds: this.availableLanguageIds,
			validation: {
				max: {
					value: 64,
					message: "Should be shorter than 65 bytes"
				}
			}
		};
		this.visualizersProps = {
			paramName: DataTypeProperty.VISUALIZERS,
			paramType: ParamType.DUALLIST,
			label: Util.translate("associated-visualizers"),
			required: true,
			tooltip: Util.translate("associated-visualizers-tooltip"),
			viewType: DualListParameter.ViewTypes.HORIZONTAL,
			languageId: this.languageId,
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.VISUALIZERS}-is-required`
				}
			},
			leftOptions: [],
			rightOptions: []
		};

		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			console.log("SX_FIELD_VALUE_CHANGED RECEIVED: ", e);
			const { dataPacket } = e;
			if (dataPacket.targetPortlet !== this.namespace) return;

			const { paramName, paramVersion, value } = dataPacket;

			this.formValues[paramName] = value;
			delete this.formErrors[paramName];
		});

		Event.on(Event.SX_FORM_FIELD_FAILED, (e) => {
			console.log("SX_FORM_FIELD_FAILED RECEIVED: ", e);
			const dataPacket = Event.pickUpNamesapceDataPacket(e, this.namespace);
			if (Util.isEmpty(dataPacket)) return;

			const { paramName, paramVersion, error } = dataPacket;
			this.formErrors[paramName] = error;
		});

		//Loading dataType

		if (this.state.dataTypeId > 0) {
			Util.ajax({
				namespace: this.namespace,
				baseResourceURL: this.baseResourceURL,
				resourceId: ResourceIds.LOAD_DATATYPE,
				type: "post",
				dataType: "json",
				params: {
					dataTypeId: this.state.dataTypeId
				},
				successFunc: (result) => {
					for (const paramName in result.dataType) {
						this.formValues[paramName] = result.dataType[paramName];

						switch (paramName) {
							case DataTypeProperty.NAME: {
								this.nameProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.VERSION: {
								this.versionProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.EXTENSION: {
								this.extensionProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.DISPLAY_NAME: {
								this.displayNameProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.DESCRIPTION: {
								this.descriptionProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.TOOLTIP: {
								this.tooltipProps.value = this.formValues[paramName];
								break;
							}
							case DataTypeProperty.VISUALIZERS: {
								this.visualizersProps.value = this.formValues[paramName];
								this.visualizersProps.leftOptions = result.dataType.visualizers.map((item) => ({
									...item,
									key: item.id
								}));
								this.visualizersProps.rightOptions = result.visualizers.map((item) => ({
									label: item.displayName[this.languageId],
									id: item.id,
									key: item.id,
									value: item.id.toString()
								}));
								break;
							}
						}
					}

					this.setState({ loadingStatus: LoadingStatus.COMPLETE });
				},
				errorFunc: (err) => {
					this.loadingFailMessage = "Error while loading data type: " + this.state.dataTypeId;
					this.setState({ loadingStatus: LoadingStatus.FAIL });
				}
			});
		} else {
			Util.ajax({
				namespace: this.namespace,
				baseResourceURL: this.baseResourceURL,
				resourceId: ResourceIds.LOAD_AVAILABLE_VISUALIZERS,
				type: "post",
				dataType: "json",
				successFunc: (result) => {
					this.visualizersProps.rightOptions = result.map((item) => ({
						label: item.displayName[this.languageId],
						id: item.id,
						key: item.id,
						value: item.id.toString()
					}));

					this.setState({ loadingStatus: LoadingStatus.COMPLETE });
				},
				errorFunc: (err) => {
					this.loadingFailMessage = "Error while loading visualizers: ";
					this.setState({ loadingStatus: LoadingStatus.FAIL });
				}
			});
		}
	}

	handleMoveToExplorer(e) {
		console.log("redirectTo: ", this.workbenchId);
		Util.redirectTo(
			this.workbenchURL,
			{
				namespace: this.workbenchNamespace,
				portletId: this.workbenchId,
				windowState: WindowState.NORMAL
			},
			{
				workingPortletName: PortletKeys.DATATYPE_EXPLORER,
				params: JSON.stringify({
					dataTypeId: this.state.dataTypeId
				})
			}
		);
	}

	validateFormValues() {
		if (Util.isEmpty(this.formValues.dataTypeName)) {
			return {
				fieldName: DataTypeProperty.NAME,
				fieldVersion: "1.0.0",
				message: DataTypeProperty.NAME + " is required"
			};
		}
		if (Util.isEmpty(this.formValues.dataTypeVersion)) {
			return {
				fieldName: DataTypeProperty.VERSION,
				fieldVersion: "1.0.0",
				message: DataTypeProperty.VERSION + " is required"
			};
		}
		if (Util.isEmpty(this.formValues.extension)) {
			return {
				fieldName: DataTypeProperty.EXTENSION,
				fieldVersion: "1.0.0",
				message: DataTypeProperty.EXTENSION + " is required"
			};
		}
		if (Util.isEmpty(this.formValues.displayName)) {
			return {
				fieldName: DataTypeProperty.DISPLAY_NAME,
				fieldVersion: "1.0.0",
				message: DataTypeProperty.DISPLAY_NAME + " is required"
			};
		}
		if (Util.isEmpty(this.formValues.visualizers)) {
			return {
				fieldName: DataTypeProperty.VISUALIZERS,
				fieldVersion: "1.0.0",
				message: DataTypeProperty.VISUALIZERS + " is required"
			};
		}
	}

	handleBtnSaveClick(e) {
		const checkError = this.validateFormValues();

		if (Util.isNotEmpty(checkError)) {
			console.log("checkError: ", this.formErrors);
			Event.fire(Event.SX_PARAM_ERROR_FOUND, this.namespace, this.namespace, {
				target: this.formId,
				paramName: checkError.fieldName,
				paramVersion: checkError.fieldVersion,
				error: checkError.message
			});
			return;
		}

		const saveResourceId =
			this.state.editStatus === EditStatus.UPDATE ? ResourceIds.UPDATE_DATATYPE : ResourceIds.ADD_DATATYPE;

		console.log("handleBtnSaveClick: ", JSON.stringify(this.formValues, null, 4));
		const params = {
			dataTypeId: this.state.dataTypeId,
			formData: JSON.stringify(this.formValues)
		};

		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: saveResourceId,
			type: "post",
			dataType: "json",
			params: params,
			successFunc: (result) => {
				console.log("data: ", result);

				const newState = { saveSuccessDlgStatus: true };

				if (!this.state.dataTypeId) {
					newState.dataTypeId = result.dataTypeId;
				}

				this.setState(newState);
			},
			errorFunc: (a, b, c, d) => {
				console.log("ERROR: ", a, b, c, d);
			}
		});
	}

	handleBtnUpgradeDataTypeClick() {
		this.formValues[DataTypeProperty.VERSION] = "";
		this.versionProps.value = "";

		this.nameProps.disabled = true;
		this.extensionProps.disabled = true;

		this.setState({
			dataTypeId: 0,
			editStatus: EditStatus.ADD
		});
	}

	handleBtnCopyDataTypeClick() {
		this.formValues[DataTypeProperty.NAME] = "";
		this.nameProps.value = "";
		this.formValues[DataTypeProperty.VERSION] = "1.0.0";
		this.versionProps.value = "1.0.0";
		this.formValues[DataTypeProperty.EXTENSION] = "";
		this.extensionProps.value = "";

		this.setState({ dataTypeId: 0, editStatus: EditStatus.ADD });
	}

	handleBtnEditDataStructureClick() {
		console.log("redirectTo: ", this.workbenchId);
		Util.redirectTo(
			this.workbenchURL,
			{
				namespace: this.workbenchNamespace,
				portletId: this.workbenchId,
				windowState: WindowState.NORMAL
			},
			{
				workingPortletName: PortletKeys.DATA_STRUCTURE_BUILDER,
				params: JSON.stringify({
					dataTypeId: this.state.dataTypeId
				})
			}
		);
	}

	handleBtnDeleteClick(e) {
		this.setState({ deleteConfirmDlgStatus: true });
	}

	clearForm() {
		this.formValues = {};
		this.formErrors = {};

		this.nameProps.value = "";
		this.versionProps.value = "1.0.0";
		this.extensionProps.value = "";
		this.displayNameProps.value = {};
		this.descriptionProps.value = {};
		this.tooltipProps.value = {};

		this.visualizersProps.value = [];
	}

	proceedDelete() {
		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.DELETE_DATATYPE,
			params: {
				dataTypeId: this.state.dataTypeId
			},
			successFunc: (result) => {
				this.clearForm();

				this.setState({ deleteSuccessDlgStatus: true });
			},
			errorFunc: (err) => {
				console.log("error: ", err);
				this.setState({ deleteErrorDlgStatus: true });
			}
		});
	}

	render() {
		if (this.state.loadingStatus === LoadingStatus.PENDING) {
			return <h1>Loading......</h1>;
		} else if (this.state.loadingStatus === LoadingStatus.FAIL) {
			return <h1>Data Loading Failed......</h1>;
		} else if (this.state.loadingStatus === LoadingStatus.COMPLETE) {
			const saveButtonLabel = Util.translate(this.state.editStatus === EditStatus.UPDATE ? "update" : "create");

			const header = (
				<div className="form-group">
					<Text size={6}>
						{this.state.editStatus === EditStatus.UPDATE
							? Util.translate("edit-datatype")
							: Util.translate("add-datatype")}
					</Text>
					<SXButtonWithIcon
						id={this.namespace + "btnMoveToExplorer"}
						label={Util.translate("datatype-list")}
						symbol={"list"}
						displayType={"link"}
						style={{ float: "right" }}
						size="lg"
						onClick={(e) => this.handleMoveToExplorer(e)}
						spritemap={this.spritemap}
					/>
				</div>
			);

			const events = {
				fire: [
					{
						traget: this.formId,
						event: Event.SX_FIELD_VALUE_CHANGED
					}
				],
				on: [
					{
						target: this.formId,
						event: Event.SX_PARAM_ERROR_FOUND
					}
				]
			};
			return (
				<>
					{header}
					{this.state.dataTypeId > 0 && (
						<div className="form-group">
							<SXLabeledText
								label={Util.translate("datatype-id")}
								text={this.state.dataTypeId}
								viewType="INLINE_ATTACH"
							/>
						</div>
					)}
					<ClayForm id={this.formId}>
						<SXGroup
							namespace={this.namespace}
							events={events}
							paramName="basicProps"
							members={[this.nameProps, this.versionProps, this.extensionProps]}
							membersPerRow={3}
							spritemap={this.spritemap}
						/>
						<SXLocalizedInput
							key={Util.randomKey()}
							namespace={this.namespace}
							events={events}
							{...this.displayNameProps}
							spritemap={this.spritemap}
						/>
						<SXLocalizedInput
							key={Util.randomKey()}
							namespace={this.namespace}
							events={events}
							{...this.descriptionProps}
							spritemap={this.spritemap}
						/>
						<SXLocalizedInput
							key={Util.randomKey()}
							namespace={this.namespace}
							events={events}
							{...this.tooltipProps}
							spritemap={this.spritemap}
						/>
						<SXDualListBox
							key={Util.randomKey()}
							namespace={this.namespace}
							events={events}
							{...this.visualizersProps}
							spritemap={this.spritemap}
						/>
					</ClayForm>
					<div className="sx-row">
						<ClayButton.Group spaced>
							<SXButtonWithIcon
								type="button"
								id={Util.namespace(this.namespace, "btnSave")}
								label={saveButtonLabel}
								symbol={"disk"}
								onClick={(e) => this.handleBtnSaveClick(e)}
								spritemap={this.spritemap}
							/>
							{this.state.editStatus === EditStatus.UPDATE ? (
								<>
									<SXButtonWithIcon
										id={this.namespace + "btnUpgradeDataType"}
										label={Util.translate("upgrade")}
										symbol={"file-template"}
										displayType={"secondary"}
										onClick={(e) => this.handleBtnUpgradeDataTypeClick(e)}
										spritemap={this.spritemap}
									/>
									<SXButtonWithIcon
										id={this.namespace + "btnCopyDataType"}
										label={Util.translate("copy")}
										symbol={"file-template"}
										displayType={"secondary"}
										onClick={() => this.handleBtnCopyDataTypeClick()}
										spritemap={this.spritemap}
									/>
									<SXButtonWithIcon
										id={this.namespace + "btnEditDataStructure"}
										label={Util.translate("edit-data-structure")}
										symbol={"file-template"}
										displayType={"secondary"}
										onClick={(e) => this.handleBtnEditDataStructureClick(e)}
										spritemap={this.spritemap}
									/>
									<SXButtonWithIcon
										id={this.namespace + "btnDelete"}
										label={Util.translate("delete")}
										symbol={"trash"}
										displayType={"warning"}
										onClick={(e) => this.handleBtnDeleteClick(e)}
										spritemap={this.spritemap}
									/>
								</>
							) : undefined}
						</ClayButton.Group>
					</div>
					{this.state.saveSuccessDlgStatus && (
						<SXModalDialog
							header={Util.translate("save-success")}
							body={"Save success: " + this.state.dataTypeId}
							buttons={[
								{
									label: Util.translate("ok"),
									onClick: () => {
										this.setState({ saveSuccessDlgStatus: false });
									}
								}
							]}
						/>
					)}
					{this.state.deleteConfirmDlgStatus && (
						<SXModalDialog
							header={Util.translate("warning")}
							body={Util.translate("this-is-not-recoverable-are-you-sure-delete-the-data-type")}
							buttons={[
								{
									label: Util.translate("confirm"),
									onClick: (e) => {
										this.proceedDelete();
										this.setState({ deleteConfirmDlgStatus: false });
									},
									displayType: "secondary"
								},
								{
									label: Util.translate("cancel"),
									onClick: (e) => {
										this.setState({ deleteConfirmDlgStatus: false });
									}
								}
							]}
						/>
					)}
					{this.state.deleteSuccessDlgStatus && (
						<SXModalDialog
							header={Util.translate("delete-success")}
							body={Util.translate("delete-success") + ": " + this.state.dataTypeId}
							buttons={[
								{
									label: Util.translate("ok"),
									onClick: (e) => {
										this.setState({
											deleteSuccessDlgStatus: false,
											dataTypeId: 0
										});
									}
								}
							]}
						/>
					)}
					{this.state.deleteErrorDlgStatus && (
						<SXModalDialog
							header={Util.translate("delete-failed")}
							body={Util.translate("delete-failed") + ": " + this.state.dataTypeId}
							buttons={[
								{
									label: Util.translate("ok"),
									onClick: (e) => {
										this.setState({
											deleteErrorDlgStatus: false
										});
									}
								}
							]}
						/>
					)}
				</>
			);
		}
	}
}

export default DataTypeEditor;
