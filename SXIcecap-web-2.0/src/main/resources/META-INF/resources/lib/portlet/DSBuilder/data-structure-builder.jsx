import React, { createContext, useReducer, useContext, useState, useRef, useLayoutEffect } from "react";
import ClayForm, { ClayInput, ClaySelect } from "@clayui/form";
import ClayIcon from "@clayui/icon";
import ClayLayout from "@clayui/layout";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import {
	DataStructureProperty,
	DataTypeProperty,
	Event,
	LoadingStatus,
	ParamProperty,
	ParamType,
	ResourceIds
} from "../../common/station-x";
import ClayButtonGroup from "@clayui/button/lib/Group";
import { Util } from "../../common/util";
import SXFormField from "../../form/sxform";
import SXDSBuilderPropertiesPanel from "./properties-panel";
import { DataStructure } from "./data-structure";
import { DataTypeInfo } from "../DTEditor/datatype-editor";
import { StringParameter } from "../../parameter/parameter";

const DataStructureBuilder = ({ portletParameters }) => {
	console.log("DataStructureBuilder", portletParameters);
	const { namespace, baseRenderURL, baseResourceURL, languageId, availableLanguageIds, permissions, spritemapPath } =
		portletParameters;
	const { workbenchURL, workbenchId, workbenchNamespace, dataTypeId } = portletParameters.params;

	const [paramTypeState, setParamTypeState] = useState("");
	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);

	const parameterRef = useRef(null);
	const paramErrorsRef = useRef({});
	const dataTypeRef = useRef(null);
	const dataStructureRef = useRef(null);

	const propertyPanelId = namespace + "propertyPanel";
	const previewPanelId = namespace + "previewPanel";

	useLayoutEffect(() => {
		Event.on(Event.SX_FORM_FIELD_CHANGED, (e) => {
			console.log("++DataStructureBuilder SX_FORM_FIELD_CHANGED RECEIVED: ", e);
			const { dataPacket } = e;
			if (
				!Event.validateMine(dataPacket, {
					namespace: namespace
				})
			) {
				return;
			}

			if (dataPacket.fieldName === ParamProperty.PARAM_TYPE) {
				setParamTypeState(dataPacket.value);
			}

			paramRef.current[dataPacket.fieldName] = dataPacket.value;

			delete paramErrorsRef.current[dataPacket.fieldName];

			console.log("paramRef: ", paramRef, paramErrorsRef);
		});

		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.LOAD_DATA_STRUCTURE,
			params: {
				dataTypeId: dataTypeId
			},
			successFunc: (result) => {
				console.log("result: ", result);
				dataTypeRef.current = result.dataType;
				dataStructureRef.current = result.dataStructure ? result.dataStructure : new DataStructure();

				console.log("DataStructureBuilder dataType: ", dataTypeRef.current);
				console.log("DataStructureBuilder dataStructure: ", dataStructureRef.current);

				const firstParam = dataStructureRef.current.getParameterByOrder(dataStructureRef.current.parameters, 1);
				parameterRef.current = firstParam ? firstParam : new StringParameter();

				setParamTypeState(parameterRef.current.paramType);
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

	const handleParamTypeSelect = (value) => {
		console.log("handleParamTypeSelect: ", value);
		setParamTypeState(value);
		dataStructureRef;
	};

	if (loadingStatus === LoadingStatus.PENDING) {
		return <h3>Loading....</h3>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h3>Loading data structure failed...</h3>;
	}

	const renderCount = useRef(0);
	renderCount.current++;
	console.log("DataStructureBuilder renderCount: " + renderCount.current);

	return (
		<>
			<DataTypeInfo
				title={dataTypeRef.current.displayName[languageId]}
				abstract={dataTypeRef.current.description[languageId]}
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

			{/*<DataStructureOptions />*/}
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
						<SXDSBuilderPropertiesPanel
							namespace
							formId={propertyPanelId}
							paramType={paramTypeState}
							languageId={languageId}
							availableLanguageIds={availableLanguageIds.split(",")}
							parameters={dataStructureRef.current.parameters}
							parameter={parameterRef.current}
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
								onClick={() => {}}
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
						<ClayInput defaultValue={"section 2"}></ClayInput>
					</ClayLayout.ContentCol>
				</ClayLayout.Row>
			</ClayLayout.Container>
		</>
	);
};

export default DataStructureBuilder;
