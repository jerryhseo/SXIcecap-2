import React from "react";
import { Text } from "@clayui/core";
import ClayButton from "@clayui/button";
import { SXButtonWithIcon, SXLabeledText } from "../../form/sxform";
import { Util } from "../../common/util";
import {
	EditStatus,
	LoadingStatus,
	Event,
	DataTypeProperty,
	ValidationRule,
	ResourceIds,
	PortletKeys,
	WindowState,
	ViewTypes,
	Constant,
	ErrorClass,
	ParamType
} from "../../common/station-x";
import { DualListParameter, GroupParameter, Parameter, StringParameter } from "../../parameter/parameter";
import { SXModalDialog } from "../../modal/sxmodal";

export const DataTypeInfo = ({ title, abstract, items, colsPerRow = 1 }) => {
	let sectionContent;

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
		<div className="form-group sheet">
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
			dataTypeNameDuplicated: false,
			editStatus: props.portletParameters.params.dataTypeId > 0 ? EditStatus.UPDATE : EditStatus.ADD
		};

		this.fields = [];

		this.parameterCode = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: DataTypeProperty.NAME,
				displayName: Util.getTranslationObject(this.languageId, "parameter-code"),
				required: true,
				viewType: ViewTypes.NORMAL,
				placeholder: Util.getTranslationObject(this.languageId, "code-name"),
				tooltip: Util.getTranslationObject(this.languageId, "code-name-tooltip"),
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "this-field-is-required")
					},
					pattern: {
						value: ValidationRule.VARIABLE,
						message: Util.getTranslationObject(this.languageId, "invalid-data-type-name")
					},
					min: {
						value: 3,
						message: Util.getTranslationObject(this.languageId, "should-be-at-least-x")
					},
					max: {
						value: 32,
						message: Util.getTranslationObject(this.languageId, "should-be-shorter-than-x")
					}
				}
			}
		);

		const versionPlaceholder = {};
		versionPlaceholder[this.languageId] = "1.0.0";
		this.parameterVersion = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: DataTypeProperty.VERSION,
				displayName: Util.getTranslationObject(this.languageId, "version"),
				required: true,
				placeholder: versionPlaceholder,
				tooltip: Util.getTranslationObject(this.languageId, "version-tooltip"),
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "this-field-is-required")
					},
					pattern: {
						value: ValidationRule.VERSION,
						message: Util.getTranslationObject(this.languageId, "invalid-version-format")
					},
					min: {
						value: 6,
						message: Util.getTranslationObject(this.languageId, "should-be-at-least-x")
					},
					max: {
						value: 12,
						message: Util.getTranslationObject(this.languageId, "should-be-shorter-than-x")
					}
				},
				defaultValue: "1.0.0"
			}
		);

		const versionExt = {};
		versionExt[this.languageId] = "ext";
		this.extension = new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
			paramName: DataTypeProperty.EXTENSION,
			displayName: Util.getTranslationObject(this.languageId, "extension"),
			required: true,
			placeholder: versionExt,
			tooltip: Util.getTranslationObject(this.languageId, "extension"),
			validation: {
				required: {
					value: true,
					message: Util.getTranslationObject(this.languageId, "this-field-is-required")
				},
				pattern: {
					value: ValidationRule.EXTENSION,
					message: Util.getTranslationObject(this.languageId, "invalid-extension")
				},
				min: {
					value: 2,
					message: Util.getTranslationObject(this.languageId, "should-be-at-least-x")
				},
				max: {
					value: 16,
					message: Util.getTranslationObject(this.languageId, "should-be-shorter-than-x")
				}
			}
		});

		this.displayName = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: DataTypeProperty.DISPLAY_NAME,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "display-name"),
				required: true,
				placeholder: Util.getTranslationObject(this.languageId, "display-name"),
				tooltip: Util.getTranslationObject(this.languageId, "display-name-tooltip"),
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "this-field-is-required")
					},
					min: {
						value: 3,
						message: Util.getTranslationObject(this.languageId, "should-be-at-least-x")
					},
					max: {
						value: 64,
						message: Util.getTranslationObject(this.languageId, "should-be-shorter-than-x")
					}
				}
			}
		);

		this.description = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: DataTypeProperty.DESCRIPTION,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "description"),
				placeholder: Util.getTranslationObject(this.languageId, "description"),
				tooltip: Util.getTranslationObject(this.languageId, "description-tooltip"),
				multipleLine: true
			}
		);

		this.tooltip = new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
			paramName: DataTypeProperty.TOOLTIP,
			localized: true,
			displayName: Util.getTranslationObject(this.languageId, "tooltip"),
			placeholder: Util.getTranslationObject(this.languageId, "tooltip"),
			tooltip: Util.getTranslationObject(this.languageId, "tooltip-tooltip"),
			validation: {
				max: {
					value: 64,
					message: Util.getTranslationObject(this.languageId, "should-be-shorter-than-x")
				}
			}
		});

		this.visualizers = new DualListParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: DataTypeProperty.VISUALIZERS,
				displayName: Util.getTranslationObject(this.languageId, "associated-visualizers"),
				required: true,
				tooltip: Util.getTranslationObject(this.languageId, "associated-visualizers-tooltip"),
				viewType: DualListParameter.ViewTypes.HORIZONTAL,
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "this-field-is-required")
					}
				},
				options: []
			}
		);

		this.groupParameter = new GroupParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: "basicProps",
				paramVersion: "1.0.0",
				viewType: GroupParameter.ViewTypes.ARRANGEMENT,
				members: [this.parameterCode, this.parameterVersion, this.extension],
				membersPerRow: 3
			}
		);

		this.fields.push(this.groupParameter);
		this.fields.push(this.displayName);
		this.fields.push(this.description);
		this.fields.push(this.tooltip);
		this.fields.push(this.visualizers);
	}

	componentDidMount() {
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
					console.log("data type loaded: ", result);
					for (const fieldName in result.dataType) {
						const field = this.getField(this.fields, fieldName);

						this.visualizers.options = result.visualizers.map((item) => ({
							label: item.displayName,
							value: item.value
						}));

						if (field) {
							field.setValue({ value: result.dataType[fieldName] });

							field.dirty = false;
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
					this.visualizers.options = result.map((item) => ({
						label: item.displayName,
						value: item.value
					}));

					this.setState({ loadingStatus: LoadingStatus.COMPLETE });
				},
				errorFunc: (err) => {
					this.loadingFailMessage = "Error while loading visualizers: ";
					this.setState({ loadingStatus: LoadingStatus.FAIL });
				}
			});
		}

		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (event) => {
			const dataPacket = Event.pickUpDataPacket(event, this.namespace, this.formId);

			if (!dataPacket) {
				return;
			}

			if (dataPacket.paramName === DataTypeProperty.NAME) {
				if (Util.isNotEmpty(this.parameterCode.value)) {
					Util.ajax({
						namespace: this.namespace,
						baseResourceURL: this.baseResourceURL,
						resourceId: ResourceIds.CHECK_DATATYPE_NAME_UNIQUE,
						type: "post",
						dataType: "json",
						params: {
							parameterCode: this.parameterCode.value
						},
						successFunc: (result) => {
							if (!result) {
								this.parameterCode.errorClass = ErrorClass.ERROR;
								this.parameterCode.errorMessage = Util.translate("parameter-code-duplicated");

								this.setState({ dataTypeNameDuplicated: true });
							}
						},
						errorFunc: (err) => {
							this.loadingFailMessage = "Error while loading visualizers: ";
							this.setState({ loadingStatus: LoadingStatus.FAIL });
						}
					});
				}
			}
		});
	}

	componentDidUpdate(prevProps, prevState) {}

	getField(fields, fieldName) {
		let found = null;

		fields.every((field) => {
			if (field.isGroup) {
				found = this.getField(field.members, fieldName);

				if (found) {
					return Constant.STOP_EVERY;
				}
			} else if (field.paramName === fieldName) {
				found = field;
				return Constant.STOP_EVERY;
			}

			return Constant.CONTINUE_EVERY;
		});

		return found;
	}

	handleMoveToExplorer(e) {
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

	collectFormValues() {
		let formValues = {};

		this.fields.forEach((field) => {
			const data = field.toData();

			if (Util.isNotEmpty(data)) {
				formValues = { ...formValues, ...data };
			}
		});

		console.log("DataTypeEditor.formValues: ", formValues);
		return formValues;
	}

	validateFormValues(fields) {
		let errorParam;
		fields.every((field) => {
			if (field.isGroup) {
				errorParam = this.validateFormValues(field.members);
			} else {
				if (field.hasError()) {
					console.log("validation failed: ", field);
					errorParam = field;
				}
			}

			return errorParam ? Constant.STOP_EVERY : Constant.CONTINUE_EVERY;
		});

		return errorParam;
	}

	handleBtnSaveClick(e) {
		let errorParam = this.validateFormValues(this.fields);

		if (errorParam) {
			console.log("An Error found: ", errorParam);

			errorParam.fireFocus();

			return;
		}

		const saveResourceId =
			this.state.editStatus === EditStatus.UPDATE ? ResourceIds.UPDATE_DATATYPE : ResourceIds.ADD_DATATYPE;

		const formValues = this.collectFormValues();

		console.log("handleBtnSaveClick: ", JSON.stringify(formValues, null, 4), this.fields);

		const params = {
			dataTypeId: this.state.dataTypeId,
			formData: JSON.stringify(formValues)
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
		this.parameterVersion.value = "";

		this.parameterCode.disabled = true;
		this.extension.disabled = true;

		this.setState({
			dataTypeId: 0,
			editStatus: EditStatus.ADD
		});
	}

	handleBtnCopyDataTypeClick() {
		this.parameterCode.value = "";
		this.parameterVersion.value = "1.0.0";
		this.extension.value = "";

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
		this.parameterCode.clearValue();
		this.parameterVersion.clearValue();
		this.extension.clearValue();
		this.displayName.clearValue();
		this.description.clearValue();
		this.tooltip.clearValue();

		this.visualizers.clearValue();

		this.forceUpdate();
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

			return (
				<>
					<div className="form-group">
						<Text size={6}>
							{this.state.editStatus === EditStatus.UPDATE
								? Util.translate("edit-datatype")
								: Util.translate("add-datatype")}
						</Text>
						<SXButtonWithIcon
							id={this.namespace + "btnMoveToExplorer"}
							label={Util.translate("datatype-list")}
							symbol="list"
							displayType="link"
							style={{ float: "right" }}
							size="lg"
							onClick={(e) => this.handleMoveToExplorer(e)}
							spritemap={this.spritemap}
						/>
					</div>
					{this.state.dataTypeId > 0 && (
						<div className="form-group">
							<SXLabeledText
								label={Util.translate("datatype-id")}
								text={this.state.dataTypeId}
								viewType="INLINE_ATTACH"
							/>
						</div>
					)}
					{this.fields.map((field) =>
						field.render({
							spritemap: this.spritemap
						})
					)}

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
					{this.state.dataTypeNameDuplicated && (
						<SXModalDialog
							header={Util.translate("error")}
							body={Util.translate("datatype-name-duplicated") + ": " + this.parameterCode.getValue()}
							buttons={[
								{
									label: Util.translate("ok"),
									onClick: (e) => {
										this.setState({
											dataTypeNameDuplicated: false
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
