import React, { useState, useRef, useLayoutEffect, useContext } from "react";
import { ClayInput, ClayToggle } from "@clayui/form";
import ClayLayout from "@clayui/layout";
import { DataTypeProperty, Event, LoadingStatus, ParamProperty, ParamType, ResourceIds } from "../../common/station-x";
import ClayButtonGroup from "@clayui/button/lib/Group";
import { Util } from "../../common/util";
import { DataStructure } from "./data-structure";
import { DataTypeInfo } from "../DTEditor/datatype-editor";
import { Parameter } from "../../parameter/parameter";
import { Body, Cell, Head, Row, Table, Button, Icon } from "@clayui/core";
import DropDown from "@clayui/drop-down";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import LocalizedInput from "@clayui/localized-input";
import SXDSBuilderPropertiesPanel from "./properties-panel";
import SXDataStructurePreviewer from "./preview-panel";
import { Context } from "@clayui/modal";
import { SXInput } from "../../form/sxform";

const SelectOptionBuilder = ({ namespace, formId, options = [], languageId, availableLanguageIds, spritemap }) => {
	const [optionsState, setOptionsState] = useState(options);
	const builderFormId = namespace + "optionBuilder";

	useLayoutEffect(() => {}, []);

	return (
		<>
			<Table>
				<Head
					items={[
						{
							id: "1",
							name: Util.translate("label")
						},
						{
							id: "2",
							name: Util.translate("value")
						},
						{
							id: "3",
							name: Util.translate("actions")
						}
					]}
				>
					{(column) => <Cell key={column.id}>{column.name}</Cell>}
				</Head>
				<Body
					items={optionsState}
					onItemsChange={(e) => {
						console.log("onItemsChange: ", e);
					}}
				>
					{(row) => (
						<Row>
							<Cell>{row.label[languageId]}</Cell>
							<Cell>{row.value}</Cell>
							<Cell>
								<DropDown
									trigger={
										<ClayButtonWithIcon
											aria-label="Actions"
											symbol="ellipsis-v"
											title="Actions"
										/>
									}
								>
									<DropDown.ItemList
										items={[
											{ name: Util.translate("delete") },
											{ name: Util.translate("moveUp") },
											{ name: Util.translate("moveDown") }
										]}
									>
										{(action) => <DropDown.Item key={action.name}>{action.name}</DropDown.Item>}
									</DropDown.ItemList>
								</DropDown>
							</Cell>
						</Row>
					)}
				</Body>
			</Table>

			<div>{Util.translate("label")}</div>
			<LocalizedInput
				id={namespace + "label"}
				locales={availableLanguageIds.map((locale) => ({ label: locale, symbol: locale.toLowerCase() }))}
			/>
		</>
	);
};

const DataStructureBuilder = ({ portletParameters }) => {
	const { namespace, baseRenderURL, baseResourceURL, languageId, availableLanguageIds, permissions, spritemapPath } =
		portletParameters;
	const { workbenchURL, workbenchId, workbenchNamespace, dataTypeId } = portletParameters.params;
	const [paramTypeState, setParamTypeState] = useState(ParamType.STRING);

	const workingParamRef = useRef(Parameter.createParameter(ParamType.STRING));
	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);

	const dataTypeRef = useRef(null);
	const dataStructureRef = useRef(null);
	const [dirty, setDirty] = useState(false);

	const [confirmDlg, dispatchConfirmDlg] = useContext(Context);

	const rerenderProperties = [
		ParamProperty.DISPLAY_NAME,
		ParamProperty.REQUIRED,
		ParamProperty.TOOLTIP,
		ParamProperty.LABEL_POSITION,
		ParamProperty.DISABLED,
		ParamProperty.READ_ONLY,
		ParamProperty.VALIDATION,
		ParamProperty.PLACEHOLDER,
		ParamProperty.MULTIPLE_LINE,
		ParamProperty.TRUE_LABEL,
		ParamProperty.FALSE_LABEL
	];

	const dsbuilderId = namespace + "dataStructureBuilder";
	const propertyPanelId = namespace + "propertyPanel";
	const previewCanvasId = namespace + "previewCanvas";

	/*!SECTION
		Attach event handlers only once when the conponent is rendered.
	*/
	useLayoutEffect(() => {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== namespace || dataPacket.target !== dsbuilderId) return;

			if (dataPacket.paramName === ParamProperty.DISABLED && dataPacket.value === true) {
				workingParamRef.current.readOnly = false;
				Event.fire(Event.SX_PARAM_VALUE_CHANGED, namespace, namespace, {
					target: dsbuilderId,
					paramName: ParamProperty.READ_ONLY,
					paramVersion: "1.0.0",
					property: ParamProperty.VALUE,
					value: workingParamRef.current.readOnly
				});
			} else if (dataPacket.paramName === ParamProperty.READ_ONLY && dataPacket.value === true) {
				workingParamRef.current.disabled = false;
				Event.fire(Event.SX_PARAM_VALUE_CHANGED, namespace, namespace, {
					target: dsbuilderId,
					paramName: ParamProperty.DISABLED,
					paramVersion: "1.0.0",
					property: ParamProperty.VALUE,
					value: workingParamRef.current.disabled
				});
			}

			if (dataPacket.paramName === ParamProperty.VALIDATION) {
				if (
					Util.isNotEmpty(dataPacket.value.required) &&
					workingParamRef.current.required !== dataPacket.value.required.value
				) {
					workingParamRef.current.required = dataPacket.value.required.value;
					dataPacket.paramName = ParamProperty.REQUIRED;
				}
			} else {
				workingParamRef.current[dataPacket.paramName] = dataPacket.value;
			}
			workingParamRef.current.clearError();
			setDirty(true);

			console.log("DataStructureBuilder SX_FIELD_VALUE_CHANGED RECEIVED: ", e, workingParamRef.current);
			if (rerenderProperties.includes(dataPacket.paramName)) {
				let property;
				let value;
				switch (dataPacket.paramName) {
					case ParamProperty.DISPLAY_NAME: {
						property = ParamProperty.LABEL;
						value = workingParamRef.current.displayName[languageId];

						break;
					}
					case ParamProperty.TOOLTIP:
					case ParamProperty.PLACEHOLDER: {
						property = dataPacket.paramName;
						value = workingParamRef.current[dataPacket.paramName][languageId];

						break;
					}
					/*
					case ParamProperty.REQUIRED: {
						property = dataPacket.paramName;
						value = workingParamRef.current.required;

						break;
					}
						*/
					default: {
						property = dataPacket.paramName;
						value = workingParamRef.current[dataPacket.paramName];

						break;
					}
				}

				Event.fire(Event.SX_PARAM_PROPERTY_CHANGED, namespace, namespace, {
					target: previewCanvasId,
					paramName: workingParamRef.current.paramName,
					paramVersion: workingParamRef.current.paramVersion,
					property: property,
					value: value
				});
			}
		});

		Event.on(Event.SX_FORM_FIELD_FAILED, (e) => {
			const dataPacket = Event.pickUpNamesapceDataPacket(e, namespace);
			if (Util.isEmpty(dataPacket)) return;

			workingParamRef.current.setError(dataPacket.error);
			console.log("DataStructureBuilder SX_FORM_FIELD_FAILED RECEIVED: ", e, workingParamRef.current);
		});

		Event.on(Event.SX_PARAMETER_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== namespace || dataPacket.target !== dsbuilderId) return;

			workingParamRef.current = dataPacket.parameter;
		});

		Event.on(Event.SX_PARAMETER_SELECTED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== namespace || dataPacket.target !== dsbuilderId) {
				console.log("SX_PARAMETER_SELECTED rejected: ", dataPacket);
				return;
			}

			workingParamRef.current = dataStructureRef.current.getParameter(
				dataPacket.paramName,
				dataPacket.paramVersion
			);

			console.log("SX_PARAMETER_SELECTED received: ", dataPacket, workingParamRef.current);

			Event.fire(Event.SX_PARAMETER_CHANGED, namespace, namespace, {
				target: propertyPanelId,
				parameter: workingParamRef.current
			});
		});

		Event.on(Event.SX_PARAM_TYPE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== namespace || dataPacket.target !== dsbuilderId) return;

			workingParamRef.current = Parameter.createParameter(dataPacket.paramType);

			Event.fire(Event.SX_PARAMETER_CHANGED, namespace, namespace, {
				target: propertyPanelId,
				parameter: workingParamRef.current
			});
		});
	}, []);

	useLayoutEffect(() => {
		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.LOAD_DATA_STRUCTURE,
			params: {
				dataTypeId: dataTypeId
			},
			successFunc: (result) => {
				dataTypeRef.current = result.dataType;
				let dataStructure = Util.isNotEmpty(result.dataStructure)
					? new DataStructure(result.dataStructure)
					: new DataStructure();

				dataStructureRef.current = dataStructure;

				setLoadingStatus(LoadingStatus.COMPLETE);
			},
			errorFunc: (err) => {
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	}, [dataTypeId]);

	const propertyPanelStyles = {
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px",
		width: "40%"
	};
	const buttonPanelStyles = {
		backgroundColor: "#f2f7c6",
		borderTop: "2px solid #CDCED9",
		borderBottom: "2px solid #CDCED9",
		borderLeft: "none",
		borderRight: "none",
		padding: ".75rem 5px",
		justifyContent: "center"
	};
	const previewPanelStyles = {
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px"
	};

	const handleVersionChange = (e) => {
		dataStructureRef.current.version = e.target.value;
	};

	const handleEnableInputStatusChange = (e) => {
		dataStructureRef.current.enableInputStatus = e.target.checked;

		Event.fire(Event.SX_ENABLE_INPUT_STATUS, namespace, namespace, {
			target: propertyPanelId,
			enable: dataStructureRef.current.enableInputStatus
		});
	};
	const handleEnableGotoChange = (e) => {
		dataStructureRef.current.enableGoto = e.target.checked;

		Event.fire(Event.SX_ENABLE_GOTO, namespace, namespace, {
			target: propertyPanelId,
			parameter: dataStructureRef.current.enableGoto
		});
	};

	const handleNewParameter = () => {
		console.log("handleNewParameter: ");
		workingParamRef.current = Parameter.createParameter(ParamType.STRING);

		Event.fire(Event.SX_PARAMETER_CHANGED, namespace, namespace, {
			target: propertyPanelId,
			parameter: workingParamRef.current
		});

		Event.fire(Event.SX_FOCUS, namespace, namespace, { target: previewCanvasId, focus: false });
	};

	const handleSaveDataStructure = () => {
		console.log(JSON.stringify(dataStructureRef.current.toJSON(), null, 4));

		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.UPDATE_DATA_STRUCTURE,
			params: {
				dataTypeId: dataTypeRef.current.dataTypeId,
				version: dataStructureRef.current.version,
				dataStructure: JSON.stringify(dataStructureRef.current.toJSON())
			},
			successFunc: (result) => {
				dispatchConfirmDlg({
					payload: {
						body: <h4>{"Data structure is saved successfully as " + result.dataStructureId}</h4>,
						footer: [
							<ClayButton
								onClick={(e) => {
									confirmDlg.onClose(e);
								}}
								displayType="secondary"
							>
								{Util.translate("ok")}
							</ClayButton>
						],
						header: Util.translate("success"),
						size: "sm"
					},
					type: "OPEN"
				});

				setDirty(false);
			},
			errorFunc: (err) => {
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	};

	function validateParameter() {
		if (Util.isEmpty(workingParamRef.current.paramName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, namespace, namespace, {
				target: propertyPanelId,
				paramName: "paramName",
				paramVersion: "1.0.0",
				error: "Parameter name is required"
			});
			alert("Error: Parameter name is required");
			return false;
		}

		if (Util.isEmpty(workingParamRef.current.displayName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, namespace, namespace, {
				target: propertyPanelId,
				paramName: "displayName",
				paramVersion: "1.0.0",
				error: "Display name is required"
			});
			alert("Error: Display name is required");
			return false;
		}

		if (workingParamRef.current.hasError()) {
			alert("Error: " + workingParamRef.getError());
			return false;
		}

		return true;
	}

	const renderCount = useRef(0);
	renderCount.current++;
	console.log("DataStructureBuilder renderCount: " + renderCount.current);

	if (loadingStatus === LoadingStatus.PENDING) {
		return <h3>Loading....</h3>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h3>Loading data structure failed...</h3>;
	}

	console.log("workingParamRef.current: ", workingParamRef.current);
	const handleAddParameter = () => {
		const noError = validateParameter();

		if (noError) {
			dataStructureRef.current.addParameter(workingParamRef.current);

			Event.fire(Event.SX_PARAMETERS_CHANGED, namespace, namespace, {
				target: previewCanvasId,
				dataStructure: dataStructureRef.current.toJSON()
			});
		}
	};

	return (
		<>
			<DataTypeInfo
				title={dataTypeRef.current.displayName}
				abstract={dataTypeRef.current.description}
				items={[
					{
						label: Util.translate("id"),
						text: dataTypeRef.current[DataTypeProperty.ID]
					},
					{
						label: Util.translate("name"),
						text: dataTypeRef.current[DataTypeProperty.NAME]
					},
					{
						label: Util.translate("version"),
						text: dataTypeRef.current[DataTypeProperty.VERSION]
					},
					{
						label: Util.translate("extension"),
						text: dataTypeRef.current[DataTypeProperty.EXTENSION]
					}
				]}
				colsPerRow={2}
			/>
			<div style={{ display: "inline-flex", width: "100%" }}>
				<div
					className="autofit-col autofit-col-expand"
					style={{ width: "20%" }}
				>
					<div className="autofit-row ">
						<label
							htmlFor={namespace + "version"}
							style={{
								display: "inline-block",
								width: "fit-content",
								alignSelf: "center",
								marginRight: "10px"
							}}
						>
							{Util.translate("version")}
						</label>
						<ClayInput
							id={namespace + "version"}
							defaultValue={dataStructureRef.current.version}
							onChange={handleVersionChange}
							type="text"
							style={{ display: "inline-block", width: "50%" }}
						/>
					</div>
				</div>
				<div className="autofit-col autofit-col-expand">
					<ClayToggle
						label={Util.translate("enable-input-status")}
						value={false}
						onChange={handleEnableInputStatusChange}
						sizing="sm"
						style={{ width: "30%" }}
					/>
				</div>
				<div className="autofit-col autofit-col-expand">
					<ClayToggle
						label={Util.translate("enable-goto")}
						value={false}
						onChange={handleEnableGotoChange}
						sizing="sm"
						style={{ width: "30%" }}
					/>
				</div>
			</div>

			<ClayLayout.Container
				fluid={true}
				view
				style={{
					paddingLeft: "0",
					paddingRight: "0"
				}}
			>
				<ClayLayout.Row justify="start">
					<ClayLayout.ContentCol
						size={5}
						style={propertyPanelStyles}
					>
						<Button.Group
							spaced
							style={{
								backgroundColor: "#f7edab",
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
								spritemap={spritemapPath}
								size="sm"
								onClick={handleNewParameter}
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("duplicate")}
								symbol="copy"
								title={Util.translate("duplicate")}
								spritemap={spritemapPath}
								displayType="secondary"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("delete")}
								symbol="trash"
								title={Util.translate("delete")}
								spritemap={spritemapPath}
								displayType="danger"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("import")}
								symbol="import"
								title={Util.translate("import")}
								spritemap={spritemapPath}
								displayType="secondary"
								size="sm"
								className="float-right"
							/>
						</Button.Group>

						<SXDSBuilderPropertiesPanel
							namespace={namespace}
							dsbuilderId={dsbuilderId}
							propertyPanelId={propertyPanelId}
							previewCanvasId={previewCanvasId}
							languageId={languageId}
							availableLanguageIds={availableLanguageIds}
							parameter={workingParamRef.current}
							spritemap={spritemapPath}
						/>
					</ClayLayout.ContentCol>
					<ClayLayout.ContentCol style={buttonPanelStyles}>
						<ClayButtonGroup
							spaced={true}
							vertical={true}
						>
							<ClayButtonWithIcon
								aria-label="Move up"
								title="Move up"
								symbol="caret-top"
								onClick={() => {}}
								borderless
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Add"
								title="Add"
								symbol="caret-right"
								onClick={handleAddParameter}
								displayType="secondary"
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Move down"
								title="Move down"
								symbol="caret-bottom"
								onClick={() => {}}
								borderless
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
						</ClayButtonGroup>
					</ClayLayout.ContentCol>
					<ClayLayout.ContentCol
						expand={true}
						style={previewPanelStyles}
					>
						<SXDataStructurePreviewer
							namespace={namespace}
							dsbuilderId={dsbuilderId}
							propertyPanelId={propertyPanelId}
							previewCanvasId={previewCanvasId}
							languageId={languageId}
							availableLanguageIds={availableLanguageIds}
							dataStructure={dataStructureRef.current}
							spritemap={spritemapPath}
						/>
					</ClayLayout.ContentCol>
				</ClayLayout.Row>
			</ClayLayout.Container>
			<Button.Group spaced>
				<Button
					displayType="primary"
					onClick={handleSaveDataStructure}
					title={Util.translate("save-data-structure")}
					disabled={!dirty}
				>
					<Icon
						symbol="disk"
						spritemap={spritemapPath}
						style={{ marginRight: "5px" }}
					/>
					{Util.translate("save")}
				</Button>
				<Button
					displayType="secondary"
					onClick={() => {}}
					title={Util.translate("copy-data-structure")}
				>
					<Icon
						symbol="copy"
						spritemap={spritemapPath}
						style={{ marginRight: "5px" }}
					/>
					{Util.translate("duplicate")}
				</Button>
				<Button
					displayType="warning"
					onClick={() => {}}
					title={Util.translate("delete-data-structure")}
				>
					<Icon
						symbol="trash"
						spritemap={spritemapPath}
						style={{ marginRight: "5px" }}
					/>
					{Util.translate("delete")}
				</Button>
			</Button.Group>
		</>
	);
};

export default DataStructureBuilder;
