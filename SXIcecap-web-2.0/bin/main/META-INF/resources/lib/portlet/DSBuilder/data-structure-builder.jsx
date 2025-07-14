import React from "react";
import { ClayToggle } from "@clayui/form";
import { DataTypeProperty, Event, LoadingStatus, ParamProperty, ParamType, ResourceIds } from "../../common/station-x";
import { Util } from "../../common/util";
import { DataStructure } from "./data-structure";
import { DataTypeInfo } from "../DTEditor/datatype-editor";
import { GroupParameter, Parameter } from "../../parameter/parameter";
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
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px",
		width: "60%",
		overflowY: "auto"
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

		this.dataTypeId = props.portletParameters.params.dataTypeId;
		this.editPhase = this.dataTypeId > 0 ? "update" : "create";
		this.dataType = {};
		this.dataStructure = new DataStructure(
			this.namespace,
			this.previewCanvasId,
			this.languageId,
			this.availableLanguageIds
		);
		this.dataStructure.dirty = false;

		this.formIds = {
			dsbuilderId: this.namespace + "dataStructureBuilder",
			propertyPanelId: this.namespace + "propertyPanel",
			basicPropertiesFormId: this.namespace + "basicPropertiesForm",
			typeOptionsFormId: this.namespace + "typeOptionsForm",
			optionsFormId: this.namespace + "optionsForm",
			validationFormId: this.namespace + "validationForm",
			previewCanvasId: this.namespace + "previewCanvas"
		};

		this.saveResult = "";

		this.loadingFailMessage = "";
		(this.workingParam = null),
			(this.state = {
				paramType: ParamType.STRING,
				loadingStatus: LoadingStatus.PENDING,
				confirmDlgState: false,
				confirmParamDeleteDlg: false,
				confirmDlgBody: "",
				underConstruction: false
			});
	}

	componentDidMount() {
		this.loadDataStructure();

		Event.on(Event.SX_PARAMETER_SELECTED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.dsbuilderId) {
				console.log("SX_PARAMETER_SELECTED rejected: ", dataPacket);
				return;
			}

			const selectedParam = this.dataStructure.findParameter({
				paramName: dataPacket.paramName,
				paramVersion: dataPacket.paramVersion,
				descendant: true
			});
			console.log("SX_PARAMETER_SELECTED: ", dataPacket, selectedParam, this.workingParam);
			if (selectedParam === this.workingParam) {
				return;
			}

			this.workingParam.focused = false;
			this.workingParam.fireRefreshPreview();

			//this.dataStructure.focus(dataPacket.paramName, dataPacket.paramVersion);

			this.workingParam = selectedParam;

			this.fireRefreshPropertyPanel();
		});

		Event.on(Event.SX_PARAM_TYPE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			console.log("SX_PARAM_TYPE_CHANGED: ", dataPacket);
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.dsbuilderId)
				return;

			if (
				dataPacket.paramType === ParamType.MATRIX ||
				dataPacket.paramType === ParamType.DUALLIST ||
				dataPacket.paramType === ParamType.CALCULATOR ||
				dataPacket.paramType === ParamType.IMAGE ||
				dataPacket.paramType === ParamType.LINKER ||
				dataPacket.paramType === ParamType.REFERENCE
			) {
				this.setState({ underConstruction: true });
				return;
			}
			console.log("SX_PARAM_TYPE_CHANGED>>>>: ", dataPacket);

			this.workingParam = Parameter.createParameter(
				this.namespace,
				this.formIds.previewCanvasId,
				this.languageId,
				this.availableLanguageIds,
				dataPacket.paramType
			);

			this.fireRefreshPropertyPanel();
		});

		Event.on(Event.SX_COPY_PARAMETER, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.dsbuilderId)
				return;

			const copied = this.workingParam.copy();
			this.workingParam.focused = false;
			this.workingParam.refreshKey();
			copied.focused = true;
			copied.refreshKey();

			const group = this.dataStructure.findParameter({
				paramName: copied.parentName,
				paramVersion: copied.paramVersion,
				descendant: true
			});

			console.log("SX_COPY_PARAMETER group: ", group, this.workingParam, copied);
			group.insertMember(copied, this.workingParam.order);

			this.workingParam = copied;

			this.fireRefreshPropertyPanel();
			this.forceUpdate();
		});

		Event.on(Event.SX_DELETE_PARAMETER, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.dsbuilderId)
				return;

			this.setState({
				confirmParamDeleteDlg: true,
				confirmDlgBody: (
					<div>
						{Util.translate("are-you-sure-delete-the-parameter") +
							': "' +
							this.workingParam.paramName +
							'"?'}
					</div>
				)
			});
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
				this.dataType = result.dataType;

				if (Util.isNotEmpty(result.dataStructure)) {
					this.dataStructure = new DataStructure(
						this.namespace,
						this.formIds.previewCanvasId,
						this.languageId,
						this.availableLanguageIds,
						result.dataStructure
					);
					this.editPhase = "update";
				} else {
					this.dataStructure = new DataStructure(
						this.namespace,
						this.formIds.previewCanvasId,
						this.languageId,
						this.availableLanguageIds
					);
					this.editPhase = "create";
				}

				const workingParam =
					this.dataStructure.members.length > 0
						? this.dataStructure.members[0]
						: Parameter.createParameter(
								this.namespace,
								this.formIds.previewCanvasId,
								this.languageId,
								this.availableLanguageIds,
								ParamType.STRING
						  );

				if (workingParam.isRendered()) {
					workingParam.focused = true;
				}

				this.workingParam = workingParam;
				this.setState({
					loadingStatus: LoadingStatus.COMPLETE
				});
			},
			errorFunc: (err) => {
				this.loadingFailMessage = "Failed to load data type: " + this.dataTypeId;
				this.setState({ loadingStatus: LoadingStatus.FAIL });
			}
		});
	}

	fireRefreshPropertyPanel() {
		Event.fire(Event.SX_REFRESH_PROPERTY_PANEL, this.namespace, this.namespace, {
			targetFormId: this.formIds.propertyPanelId,
			workingParam: this.workingParam
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
		this.workingParam = Parameter.createParameter(
			this.namespace,
			this.formIds.previewCanvasId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.STRING
		);

		this.dataStructure.focus();

		this.forceUpdate();
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
		if (this.workingParam.checkIntegrity()) {
			this.dataStructure.addMember(this.workingParam);
			this.dataStructure.focus(this.workingParam.paramName, this.workingParam.paramVersion);
		} else {
			console.log("checkIntegrity fail: ", this.workingParam);
		}

		this.forceUpdate();
	}

	render() {
		if (this.state.loadingStatus === LoadingStatus.PENDING) {
			return <h3>Loading....</h3>;
		} else if (this.state.loadingStatus === LoadingStatus.FAIL) {
			return <h3>{this.loadingFailMessage}</h3>;
		}

		console.log("DataStructureBuilder render: ", this.dataStructure, this.workingParam);

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
							key={this.workingParam.key}
							formIds={this.formIds}
							workingParam={this.workingParam}
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
								disabled={this.workingParam.isRendered()}
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
								disabled={this.workingParam.isRendered()}
								spritemap={this.spritemap}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Move down"
								title="Move down"
								symbol="caret-bottom"
								onClick={() => {}}
								borderless
								size="md"
								disabled={this.workingParam.isRendered()}
								spritemap={this.spritemap}
							></ClayButtonWithIcon>
						</div>
					</div>
					<div style={this.previewPanelStyles}>
						<SXDataStructurePreviewer
							key={this.dataStructure.members.length}
							formIds={this.formIds}
							dataStructure={this.dataStructure}
							spritemap={this.spritemap}
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
					{this.editPhase === "update" && (
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
					)}
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
				{this.state.confirmParamDeleteDlg && (
					<SXModalDialog
						header={Util.translate("delete-parameter")}
						body={this.state.confirmDlgBody}
						buttons={[
							{
								onClick: () => {
									const group = this.dataStructure.findParameter({
										paramName: this.workingParam.parentName,
										paramVersion: this.workingParam.parentVersion,
										descendant: true
									});

									group.removeMember({
										paramName: this.workingParam.paramName,
										paramVersion: this.workingParam.paramVersion
									});

									const workingParam =
										group.firstMember ??
										(group.paramName === GroupParameter.ROOT_GROUP
											? Parameter.createParameter(
													this.namespace,
													this.formIds.dsbuilderId,
													this.languageId,
													this.availableLanguageIds,
													ParamType.STRING
											  )
											: group);
									workingParam.focused = workingParam.isRendered() ? true : false;

									this.workingParam = workingParam;
									this.setState({ confirmParamDeleteDlg: false });
								},
								label: Util.translate("ok"),
								displayType: "primary"
							},
							{
								onClick: () => {
									this.setState({ confirmParamDeleteDlg: false });
								},
								label: Util.translate("cancel"),
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
