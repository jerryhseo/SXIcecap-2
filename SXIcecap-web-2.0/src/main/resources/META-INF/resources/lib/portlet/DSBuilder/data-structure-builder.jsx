import React from "react";
import { ClayToggle } from "@clayui/form";
import { DataTypeProperty, Event, LoadingStatus, ParamProperty, ParamType, ResourceIds } from "../../common/station-x";
import { Util } from "../../common/util";
import { DataStructure } from "./data-structure";
import { DataTypeInfo } from "../DTEditor/datatype-editor";
import { Parameter } from "../../parameter/parameter";
import { Button, Icon } from "@clayui/core";
import { ClayButtonWithIcon } from "@clayui/button";
import SXDSBuilderPropertiesPanel from "./properties-panel";
import SXDataStructurePreviewer from "./preview-panel";
import { SXModalDialog } from "../../modal/sxmodal";
import { UnderConstruction } from "../../common/common";

class DataStructureBuilder extends React.Component {
	rerenderProperties = [
		ParamProperty.DISPLAY_NAME,
		ParamProperty.REQUIRED,
		ParamProperty.TOOLTIP,
		ParamProperty.DEFINITION,
		ParamProperty.SHOW_DEFINITION,
		ParamProperty.LABEL_POSITION,
		ParamProperty.VIEW_TYPE,
		ParamProperty.DISABLED,
		ParamProperty.READ_ONLY,
		ParamProperty.VALIDATION,
		ParamProperty.PLACEHOLDER,
		ParamProperty.MULTIPLE_LINE,
		ParamProperty.TRUE_LABEL,
		ParamProperty.FALSE_LABEL,
		ParamProperty.UNIT,
		ParamProperty.UNCERTAINTY,
		ParamProperty.OPTIONS,
		ParamProperty.OPTIONS_PER_ROW
	];

	propertyPanelStyles = {
		display: "grid",
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px",
		width: "35%"
	};
	buttonPanelStyles = {
		display: "grid",
		backgroundColor: "#f2f7c6",
		borderTop: "2px solid #CDCED9",
		borderBottom: "2px solid #CDCED9",
		borderLeft: "none",
		borderRight: "none",
		padding: ".75rem 5px",
		justifyContent: "center",
		width: "60px"
	};
	previewPanelStyles = {
		display: "grid",
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px",
		width: "60%"
	};

	constructor(props) {
		super(props);

		this.namespace = props.portletParameters.namespace;
		this.baseRenderURL = props.portletParameters.baseRenderURL;
		this.baseResourceURL = props.portletParameters.baseResourceURL;
		this.languageId = props.portletParameters.languageId;
		this.availableLanguageIds = props.portletParameters.availableLanguageIds;
		this.permissions = props.portletParameters.permissions;
		this.spritemap = props.portletParameters.spritemapPath;

		this.workbenchURL = props.portletParameters.params.workbenchURL;
		this.workbenchId = props.portletParameters.params.workbenchId;
		this.workbenchNamespace = props.portletParameters.params.workbenchNamespace;

		this.dsbuilderId = this.namespace + "dataStructureBuilder";
		this.propertyPanelId = this.namespace + "propertyPanel";
		this.previewCanvasId = this.namespace + "previewCanvas";

		this.saveResult = "";

		this.loadingFailMessage = "";
		this.state = {
			paramType: ParamType.STRING,
			workingParam: null,
			loadingStatus: LoadingStatus.PENDING,
			dataTypeId: props.portletParameters.params.dataTypeId,
			dataType: {},
			dataStructure: new DataStructure(
				this.namespace,
				this.previewCanvasId,
				this.languageId,
				this.availableLanguageIds
			),
			confirmDlgState: false,
			confirmDlgBody: "",
			paramOrder: 0,
			underConstruction: false
		};

		this.dirty = false;

		this.attachEvents();
		this.loadDataStructure();
	}

	attachEvents() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) return;

			this.dirty = true;

			this.state.workingParam.clearError();
			this.state.workingParam[dataPacket.paramName] = dataPacket.value;

			console.log("DataStructureBuilder SX_FIELD_VALUE_CHANGED RECEIVED: ", dataPacket, this.state.workingParam);
			if (this.rerenderProperties.includes(dataPacket.paramName)) {
				let property;
				let value;
				switch (dataPacket.paramName) {
					case ParamProperty.DISPLAY_NAME: {
						property = ParamProperty.LABEL;
						value = this.state.workingParam.displayName[this.languageId];

						break;
					}
					case ParamProperty.TOOLTIP:
					case ParamProperty.DEFINITION:
					case ParamProperty.PLACEHOLDER: {
						property = dataPacket.paramName;
						value = this.state.workingParam[dataPacket.paramName][this.languageId];

						break;
					}
					case ParamProperty.VALIDATION: {
						property = dataPacket.paramName;
						value = this.state.workingParam[dataPacket.paramName];

						Event.fire(Event.SX_PARAM_PROPERTY_CHANGED, this.namespace, this.namespace, {
							target: this.previewCanvasId,
							paramName: this.state.workingParam.paramName,
							paramVersion: this.state.workingParam.paramVersion,
							property: ParamProperty.REQUIRED,
							value: value.required ? value.required.value : false
						});
						break;
					}
					case ParamProperty.OPTIONS: {
						property = dataPacket.paramName;
						value = this.state.workingParam.options.map((option) => ({
							label: option.label[this.languageId],
							value: option.value
						}));

						break;
					}
					case ParamProperty.VIEW_TYPE: {
						property = dataPacket.paramName;
						value = this.state.workingParam[dataPacket.paramName];

						Event.fire(Event.SX_FIELD_VALUE_CHANGED, this.namespace, this.namespace, {
							target: this.propertyPanelId,
							paramName: ParamProperty.VIEW_TYPE,
							paramVersion: "1.0.0",
							value: value
						});
						break;
					}
					default: {
						property = dataPacket.paramName;
						value = this.state.workingParam[dataPacket.paramName];

						break;
					}
				}

				this.state.workingParam.refreshKey();
				console.log("send SX_PARAM_PROPERTY_CHANGED");
				Event.fire(Event.SX_PARAM_PROPERTY_CHANGED, this.namespace, this.namespace, {
					target: this.previewCanvasId,
					paramName: this.state.workingParam.paramName,
					paramVersion: this.state.workingParam.paramVersion,
					property: property,
					value: value
				});
			}
		});

		Event.on(Event.SX_FORM_FIELD_FAILED, (e) => {
			const dataPacket = Event.pickUpNamesapceDataPacket(e, this.namespace);
			if (Util.isEmpty(dataPacket)) return;

			this.state.workingParam.setError(dataPacket.error);
			console.log("DataStructureBuilder SX_FORM_FIELD_FAILED RECEIVED: ", e, this.state.workingParam);
		});

		Event.on(Event.SX_PARAMETER_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) return;

			this.setState({
				workingParam: Parameter.createParameter(
					this.namespace,
					this.previewCanvasId,
					this.languageId,
					this.availableLanguageIds,
					dataPacket.parameter.paramType,
					dataPacket.parameter.toJSON()
				)
			});
		});

		Event.on(Event.SX_PARAMETER_SELECTED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) {
				console.log("SX_PARAMETER_SELECTED rejected: ", dataPacket);
				return;
			}

			const selectedParam = this.state.dataStructure.getParameter(dataPacket.paramName, dataPacket.paramVersion);
			if (selectedParam === this.state.workingParam) {
				return;
			}

			this.setState({
				workingParam: selectedParam
			});

			console.log("SX_PARAMETER_SELECTED received: ", dataPacket);

			Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				parameter: selectedParam
			});
		});

		Event.on(Event.SX_PARAM_TYPE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) return;

			if (
				dataPacket.paramType !== ParamType.STRING &&
				dataPacket.paramType !== ParamType.LOCALIZED_STRING &&
				dataPacket.paramType !== ParamType.NUMERIC &&
				dataPacket.paramType !== ParamType.BOOLEAN &&
				dataPacket.paramType !== ParamType.SELECT
			) {
				this.setState({ underConstruction: true });
				return;
			}

			const newParam = Parameter.createParameter(
				this.namespace,
				this.previewCanvasId,
				this.languageId,
				this.availableLanguageIds,
				dataPacket.paramType
			);
			this.setState({ workingParam: newParam });

			Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				parameter: newParam
			});

			Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, {
				target: this.previewCanvasId
			});
		});
	}

	loadDataStructure() {
		console.log("Load data structure....");
		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.LOAD_DATA_STRUCTURE,
			params: {
				dataTypeId: this.state.dataTypeId
			},
			successFunc: (result) => {
				console.log("Load data structure result: ", result, Util.isNotEmpty(result.dataStructure));
				let dataStructure = Util.isNotEmpty(result.dataStructure)
					? new DataStructure(
							this.namespace,
							this.previewCanvasId,
							this.languageId,
							this.availableLanguageIds,
							result.dataStructure
					  )
					: new DataStructure(
							this.namespace,
							this.previewCanvasId,
							this.languageId,
							this.availableLanguageIds
					  );

				this.setState({
					dataType: result.dataType,
					dataStructure: dataStructure,
					workingParam:
						dataStructure.parameters.length > 0
							? dataStructure.parameters[0]
							: Parameter.createParameter(
									this.namespace,
									this.previewCanvasId,
									this.languageId,
									this.availableLanguageIds,
									ParamType.STRING
							  ),
					loadingStatus: LoadingStatus.COMPLETE
				});
			},
			errorFunc: (err) => {
				this.loadingFailMessage = "Failed to load data type: " + this.state.dataTypeId;
				this.setState({ loadingStatus: LoadingStatus.FAIL });
			}
		});
	}

	handleEnableInputStatusChange(e) {
		this.setState({ underConstruction: true });
		/*
		this.state.dataStructure.enableInputStatus = e.target.checked;

		Event.fire(Event.SX_ENABLE_INPUT_STATUS, this.namespace, this.namespace, {
			target: this.previewCanvasId,
			enable: this.state.dataStructure.enableInputStatus
		});
		*/
	}

	handleEnableGotoChange(e) {
		this.setState({ underConstruction: true });
		/*
		this.state.dataStructure.enableGoto = e.target.checked;

		Event.fire(Event.SX_ENABLE_GOTO, this.namespace, this.namespace, {
			target: this.previewCanvasId,
			parameter: this.state.dataStructure.enableGoto
		});
		*/
	}

	handleNewParameter() {
		console.log("handleNewParameter: ");
		const newParam = Parameter.createParameter(
			this.namespace,
			this.previewCanvasId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.STRING
		);
		this.setState({ workingParam: newParam });

		Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
			target: this.propertyPanelId,
			parameter: newParam
		});

		Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, {
			target: this.previewCanvasId,
			focus: false
		});
	}

	handleSaveDataStructure = () => {
		console.log(JSON.stringify(this.state.dataStructure.toJSON(), null, 4));

		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.UPDATE_DATA_STRUCTURE,
			params: {
				dataTypeId: this.state.dataTypeId,
				dataStructure: JSON.stringify(this.state.dataStructure.toJSON())
			},
			successFunc: (result) => {
				this.setState({
					confirmDlgState: true,
					confirmDlgBody: <h4>{"Data structure is saved successfully as " + result.dataTypeId}</h4>,
					dirty: false
				});
			},
			errorFunc: (err) => {
				this.setState({ loadingStatus: LoadingStatus.FAIL });
			}
		});
	};

	handleAddParameter() {
		const noError = this.validateParameter();

		if (noError) {
			this.state.dataStructure.addParameter(this.state.workingParam);

			console.log("workingParam.order: ", this.state.workingParam.order);
			this.setState({ paramOrder: this.state.workingParam.order });

			Event.fire(Event.SX_FOCUS, this.namespace, this.namespace, {
				target: this.previewCanvasId,
				paramName: this.state.workingParam.paramName,
				paramVersion: this.state.workingParam.paramVersion
			});
		}
	}

	validateParameter() {
		if (Util.isEmpty(this.state.workingParam.paramName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				paramName: "paramName",
				paramVersion: "1.0.0",
				error: "Parameter name is required"
			});
			alert("Error: Parameter name is required");
			return false;
		}

		if (Util.isEmpty(this.state.workingParam.displayName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				paramName: "displayName",
				paramVersion: "1.0.0",
				error: "Display name is required"
			});
			alert("Error: Display name is required");
			return false;
		}

		if (this.state.workingParam.hasError()) {
			alert("Error: " + this.state.workingParam.getError());
			return false;
		}

		return true;
	}

	render() {
		if (this.state.loadingStatus === LoadingStatus.PENDING) {
			return <h3>Loading....</h3>;
		} else if (this.state.loadingStatus === LoadingStatus.FAIL) {
			return <h3>{this.loadingFailMessage}</h3>;
		}

		console.log("workingParam: ", this.state.loadingStatus, this.state.workingParam);
		console.log("dataStructure: ", this.state.dataStructure);

		return (
			<>
				<DataTypeInfo
					title={this.state.dataType.displayName}
					abstract={this.state.dataType.description}
					items={[
						{
							label: Util.translate("id"),
							text: this.state.dataType[DataTypeProperty.ID]
						},
						{
							label: Util.translate("name"),
							text: this.state.dataType[DataTypeProperty.NAME]
						},
						{
							label: Util.translate("version"),
							text: this.state.dataType[DataTypeProperty.VERSION]
						},
						{
							label: Util.translate("extension"),
							text: this.state.dataType[DataTypeProperty.EXTENSION]
						}
					]}
					colsPerRow={2}
				/>
				<div style={{ display: "inline-flex", width: "100%" }}>
					<div className="autofit-col autofit-col-expand">
						<ClayToggle
							label={Util.translate("enable-input-status")}
							value={false}
							onChange={(e) => this.handleEnableInputStatusChange(e)}
							sizing="md"
							style={{ width: "30%" }}
						/>
					</div>
					<div className="autofit-col autofit-col-expand">
						<ClayToggle
							label={Util.translate("enable-goto")}
							value={false}
							onChange={(e) => this.handleEnableGotoChange(e)}
							sizing="md"
							style={{ width: "30%" }}
						/>
					</div>
				</div>

				<div
					style={{
						display: "flex",
						paddingLeft: "0",
						paddingRight: "0",
						width: "100%",
						marginBottom: "20px"
					}}
				>
					<div style={this.propertyPanelStyles}>
						<Button.Group
							spaced
							style={{
								background: "rgba(247, 237, 171, 0.8)",
								padding: "10px 5px",
								justifyContent: "center",
								marginBottom: "20px"
							}}
						>
							<ClayButtonWithIcon
								aria-label={Util.translate("new")}
								symbol="plus"
								title={Util.translate("new")}
								spritemap={this.spritemap}
								size="sm"
								onClick={() => {
									this.handleNewParameter();
								}}
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("duplicate")}
								symbol="copy"
								title={Util.translate("duplicate")}
								spritemap={this.spritemap}
								displayType="secondary"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("delete")}
								symbol="trash"
								title={Util.translate("delete")}
								spritemap={this.spritemap}
								displayType="danger"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("import")}
								symbol="import"
								title={Util.translate("import")}
								spritemap={this.spritemap}
								displayType="secondary"
								size="sm"
								className="float-right"
							/>
						</Button.Group>

						<SXDSBuilderPropertiesPanel
							key={this.state.workingParam.key}
							namespace={this.namespace}
							dsbuilderId={this.dsbuilderId}
							propertyPanelId={this.propertyPanelId}
							previewCanvasId={this.previewCanvasId}
							languageId={this.languageId}
							availableLanguageIds={this.availableLanguageIds}
							parameter={this.state.workingParam}
							spritemap={this.spritemap}
						/>
					</div>
					<div style={this.buttonPanelStyles}>
						<div
							style={{
								backgroundColor: "#f7edab",
								background: "rgba(247, 237, 171, 0.8)",
								padding: "10px 5px",
								justifyContent: "center",
								justifySelf: "center",
								alignItems: "center",
								alignSelf: "center",
								marginBottom: "20px",
								flexDirection: "column",
								columnGap: "1rem",
								flexWrap: "wrap",
								position: "relative"
							}}
						>
							<ClayButtonWithIcon
								aria-label="Move up"
								title="Move up"
								symbol="caret-top"
								onClick={() => {}}
								borderless
								size="md"
								disabled={this.state.workingParam.order > 0}
								spritemap={this.spritemap}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Add"
								title="Add"
								symbol="caret-right"
								onClick={() => {
									this.handleAddParameter();
								}}
								displayType="secondary"
								size="md"
								disabled={this.state.workingParam.order > 0}
								spritemap={this.spritemap}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Move down"
								title="Move down"
								symbol="caret-bottom"
								onClick={() => {}}
								borderless
								size="md"
								disabled={this.state.workingParam.order > 0}
								spritemap={this.spritemap}
							></ClayButtonWithIcon>
						</div>
					</div>
					<div style={this.previewPanelStyles}>
						<SXDataStructurePreviewer
							key={this.state.dataStructure.key}
							namespace={this.namespace}
							dsbuilderId={this.dsbuilderId}
							propertyPanelId={this.propertyPanelId}
							previewCanvasId={this.previewCanvasId}
							languageId={this.languageId}
							availableLanguageIds={this.availableLanguageIds}
							dataStructure={this.state.dataStructure}
							spritemap={this.spritemap}
							workingParamOrder={this.state.workingParam.order}
						/>
					</div>
				</div>
				<Button.Group spaced>
					<Button
						displayType="primary"
						onClick={this.handleSaveDataStructure}
						title={Util.translate("save-data-structure")}
					>
						<Icon
							symbol="disk"
							spritemap={this.spritemap}
							style={{ marginRight: "5px" }}
						/>
						{Util.translate("save")}
					</Button>
					<Button
						displayType="warning"
						onClick={() => {}}
						title={Util.translate("delete-data-structure")}
					>
						<Icon
							symbol="trash"
							spritemap={this.spritemap}
							style={{ marginRight: "5px" }}
						/>
						{Util.translate("delete")}
					</Button>
				</Button.Group>
				{this.state.confirmDlgState && (
					<SXModalDialog
						header="Success"
						body={this.state.confirmDlgBody}
						buttons={[
							{
								onClick: () => {
									this.setState({ confirmDlgState: false });
								},
								label: Util.translate("ok"),
								displayType: "primary"
							}
						]}
						status="info"
						spritemap={this.spritemap}
					/>
				)}
				{this.state.underConstruction && (
					<SXModalDialog
						header={Util.translate("sorry")}
						body={<UnderConstruction />}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: () => {
									this.setState({ underConstruction: false });
								}
							}
						]}
					/>
				)}
			</>
		);
	}
}

export default DataStructureBuilder;
