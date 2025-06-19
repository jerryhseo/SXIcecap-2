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
		ParamProperty.DEFINITION,
		ParamProperty.DISABLED,
		ParamProperty.DISPLAY_NAME,
		ParamProperty.ENABLE_COUNTRY_NO,
		ParamProperty.ENABLE_TIME,
		ParamProperty.END_YEAR,
		ParamProperty.FALSE_LABEL,
		ParamProperty.LABEL_POSITION,
		ParamProperty.MULTIPLE_LINE,
		ParamProperty.OPTIONS,
		ParamProperty.OPTIONS_PER_ROW,
		ParamProperty.PLACEHOLDER,
		ParamProperty.READ_ONLY,
		ParamProperty.REQUIRED,
		ParamProperty.SHOW_DEFINITION,
		ParamProperty.START_YEAR,
		ParamProperty.TOOLTIP,
		ParamProperty.TRUE_LABEL,
		ParamProperty.UNCERTAINTY,
		ParamProperty.UNIT,
		ParamProperty.VALIDATION,
		ParamProperty.VALUE,
		ParamProperty.VIEW_TYPE
	];

	propertyPanelStyles = {
		display: "block",
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

		this.workingParam = null;
		this.dataTypeId = props.portletParameters.params.dataTypeId;
		this.dataType = {};
		(this.dataStructure = new DataStructure(
			this.namespace,
			this.previewCanvasId,
			this.languageId,
			this.availableLanguageIds
		)),
			(this.dataStructure.dirty = false);

		this.dsbuilderId = this.namespace + "dataStructureBuilder";
		this.propertyPanelId = this.namespace + "propertyPanel";
		this.previewCanvasId = this.namespace + "previewCanvas";

		this.saveResult = "";

		this.loadingFailMessage = "";

		this.state = {
			paramType: ParamType.STRING,
			loadingStatus: LoadingStatus.PENDING,
			confirmDlgState: false,
			confirmDlgBody: "",
			underConstruction: false
		};
	}

	componentDidMount() {
		this.loadDataStructure();

		Event.on(Event.SX_PARAMETER_SELECTED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) {
				console.log("SX_PARAMETER_SELECTED rejected: ", dataPacket);
				return;
			}

			const selectedParam = this.dataStructure.findParameter(dataPacket.paramName, dataPacket.paramVersion);
			if (selectedParam === this.state.workingParam) {
				return;
			}

			this.setState({
				workingParam: selectedParam
			});

			this.dataStructure.releaseFocus();
			selectedParam.fireFocus();

			console.log("SX_PARAMETER_SELECTED received: ", dataPacket);

			/*
			Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				parameter: selectedParam
			});
			*/
		});

		Event.on(Event.SX_PARAM_TYPE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.dsbuilderId) return;

			if (
				dataPacket.paramType === ParamType.MATRIX ||
				dataPacket.paramType === ParamType.DUALLIST ||
				dataPacket.paramType === ParamType.CALCULATOR ||
				dataPacket.paramType === ParamType.GRID ||
				dataPacket.paramType === ParamType.IMAGE ||
				dataPacket.paramType === ParamType.LINKER ||
				dataPacket.paramType === ParamType.SELECT_GROUP ||
				dataPacket.paramType === ParamType.REFERENCE ||
				dataPacket.paramType === ParamType.TABLE ||
				dataPacket.paramType === ParamType.COMMENT
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

			/*
			Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
				target: this.propertyPanelId,
				parameter: newParam
			});

			Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, {
				target: this.previewCanvasId
			});
			*/
		});
	}

	loadDataStructure() {
		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.LOAD_DATA_STRUCTURE,
			params: {
				dataTypeId: this.dataTypeId
			},
			successFunc: (result) => {
				this.dataStructure = Util.isNotEmpty(result.dataStructure)
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

				this.dataType = result.dataType;

				this.setState({
					workingParam:
						this.dataStructure.countParameters() > 0
							? this.dataStructure.parameters[0]
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
				this.loadingFailMessage = "Failed to load data type: " + this.dataTypeId;
				this.setState({ loadingStatus: LoadingStatus.FAIL });
			}
		});
	}

	handleEnableInputStatusChange(val) {
		this.dataStructure.enableInputStatus = val;

		this.forceUpdate();
	}

	handleEnableGotoChange(val) {
		this.dataStructure.enableGoTo = val;

		this.forceUpdate();
	}

	handleNewParameter() {
		this.setState({
			workingParam: Parameter.createParameter(
				this.namespace,
				this.previewCanvasId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING
			)
		});

		/*
		Event.fire(Event.SX_PARAMETER_CHANGED, this.namespace, this.namespace, {
			target: this.propertyPanelId,
			parameter: newParam
		});

		Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, {
			target: this.previewCanvasId,
			focus: false
		});
		*/
	}

	handleSaveDataStructure = () => {
		console.log(JSON.stringify(this.dataStructure.toJSON(), null, 4));

		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.UPDATE_DATA_STRUCTURE,
			params: {
				dataTypeId: this.dataTypeId,
				dataStructure: JSON.stringify(this.dataStructure.toJSON())
			},
			successFunc: (result) => {
				this.setState({
					confirmDlgState: true,
					confirmDlgBody: <h4>{"Data structure is saved successfully as " + result.dataTypeId}</h4>
				});

				this.dataStructure.dirty = false;
			},
			errorFunc: (err) => {
				this.setState({ loadingStatus: LoadingStatus.FAIL });
			}
		});
	};

	handleAddParameter() {
		const noError = this.validateParameter();

		if (noError) {
			this.dataStructure.addParameter(this.state.workingParam);
			this.state.workingParam.focused = true;

			this.forceUpdate();
		}
	}

	/*
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
		*/

	render() {
		if (this.state.loadingStatus === LoadingStatus.PENDING) {
			return <h3>Loading....</h3>;
		} else if (this.state.loadingStatus === LoadingStatus.FAIL) {
			return <h3>{this.loadingFailMessage}</h3>;
		}

		console.log("DataStructureBuilder workingParam: ", this.state.loadingStatus, this.state.workingParam);
		console.log("DataStructureBuilder dataStructure: ", this.dataStructure);

		return (
			<>
				<DataTypeInfo
					title={this.dataType.displayName}
					abstract={this.dataType.description}
					items={[
						{
							label: Util.translate("id"),
							text: this.dataType[DataTypeProperty.ID]
						},
						{
							label: Util.translate("name"),
							text: this.dataType[DataTypeProperty.NAME]
						},
						{
							label: Util.translate("version"),
							text: this.dataType[DataTypeProperty.VERSION]
						},
						{
							label: Util.translate("extension"),
							text: this.dataType[DataTypeProperty.EXTENSION]
						}
					]}
					colsPerRow={4}
				/>
				<div style={{ display: "inline-flex", width: "100%" }}>
					<div className="autofit-col autofit-col-expand">
						<ClayToggle
							label={Util.translate("enable-input-status")}
							toggled={this.dataStructure.enableInputStatus}
							onToggle={(val) => this.handleEnableInputStatusChange(val)}
							sizing="md"
							style={{ width: "30%" }}
						/>
					</div>
					<div className="autofit-col autofit-col-expand">
						<ClayToggle
							label={Util.translate("enable-goto")}
							toggled={this.dataStructure.enableGoTo}
							onToggle={(val) => this.handleEnableGotoChange(val)}
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
								marginBottom: "20px",
								width: "100%"
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
							namespace={this.namespace}
							dsbuilderId={this.dsbuilderId}
							propertyPanelId={this.propertyPanelId}
							previewCanvasId={this.previewCanvasId}
							languageId={this.languageId}
							availableLanguageIds={this.availableLanguageIds}
							workingParam={this.state.workingParam}
							dataStructure={this.dataStructure}
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
						{/*
						<SXDataStructurePreviewer
							key={this.state.workingParam.key}
							namespace={this.namespace}
							dsbuilderId={this.dsbuilderId}
							propertyPanelId={this.propertyPanelId}
							previewCanvasId={this.previewCanvasId}
							languageId={this.languageId}
							availableLanguageIds={this.availableLanguageIds}
							dataStructure={this.dataStructure}
							spritemap={this.spritemap}
							workingParamOrder={this.state.workingParam.order}
						/>
					*/}
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
