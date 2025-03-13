import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import Form, { ClaySelectWithOption } from "@clayui/form";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import SXDSBuilderBasicPropertiesPanel from "./basic-properties-panel";
import SXDSBuilderTypeSpecificPanel from "./type-specific-properties-panel";
import SXDSBuilderOptionPropertiesPanel from "./option-properties-panel";
import SXDSBuilderValidationPanel from "./validation-builder-panel";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import { SXLabel } from "../../form/sxform";
import { Parameter } from "../../parameter/parameter";

const SXDSBuilderPropertiesPanel = ({
	namespace, //
	dsbuilderId,
	propertyPanelId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	parameter,
	spritemap
}) => {
	console.log("SXDSBuilderPropertiesPanel: ", parameter);
	const [panelStepState, setPanelStepState] = useState(0);
	const [render, forceRender] = useState(true);
	const [parameterState, setParameterState] = useState(parameter);

	const stepsRef = useRef([
		{
			title: Util.translate("basic")
		},
		{
			title: Util.translate("type-specific")
		},
		{
			title: Util.translate("options")
		},
		{
			title: Util.translate("validation")
		}
	]);

	let panelContent;
	switch (panelStepState) {
		case 0: {
			panelContent = (
				<SXDSBuilderBasicPropertiesPanel
					namespace={namespace}
					dsbuilderId={dsbuilderId}
					propertyPanelId={propertyPanelId}
					previewCanvasId={previewCanvasId}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					parameter={parameterState}
					spritemap={spritemap}
				/>
			);
			break;
		}
		case 1: {
			panelContent = (
				<SXDSBuilderTypeSpecificPanel
					namespace={namespace}
					dsbuilderId={dsbuilderId}
					propertyPanelId={propertyPanelId}
					previewCanvasId={previewCanvasId}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					parameter={parameterState}
					spritemap={spritemap}
				/>
			);
			break;
		}
		case 2: {
			panelContent = (
				<SXDSBuilderOptionPropertiesPanel
					namespace={namespace}
					dsbuilderId={dsbuilderId}
					propertyPanelId={propertyPanelId}
					previewCanvasId={previewCanvasId}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					parameter={parameterState}
					spritemap={spritemap}
				/>
			);
			break;
		}
		case 3: {
			panelContent = (
				<SXDSBuilderValidationPanel
					namespace={namespace}
					dsbuilderId={dsbuilderId}
					propertyPanelId={propertyPanelId}
					previewCanvasId={previewCanvasId}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					parameter={parameterState}
					spritemap={spritemap}
				/>
			);
			break;
		}
	}

	useLayoutEffect(() => {
		Event.on(Event.SX_PARAMETER_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== namespace || dataPacket.target !== propertyPanelId) return;

			console.log("SX_PARAMETER_CHANGED received: ", dataPacket);
			setParameterState(dataPacket.parameter);
			setPanelStepState(0);
		});
	}, []);

	const handlePanelStepChange = (step) => {
		setPanelStepState(step);
	};

	const handleParamTypeSelect = (e) => {
		console.log("handleParamTypeSelect: ", e);
		Event.fire(Event.SX_PARAM_TYPE_CHANGED, namespace, namespace, {
			target: dsbuilderId,
			paramType: e.target.value
		});
	};

	const renderCount = useRef(0);
	renderCount.current++;
	console.log("SXDSBuilderPropertiesPanel renderCount: " + renderCount.current);

	return (
		<>
			<Form.Group className="form-group-sm">
				<SXLabel
					label={Util.translate("parameter-type")}
					forHtml={namespace + ParamProperty.PARAM_TYPE}
					required={true}
					tooltip={Util.translate("parameter-type-tooltip")}
					spritemap={spritemap}
					style={{ marginRight: "20px" }}
				/>
				<ClaySelectWithOption
					aria-label={Util.translate("parameter-type")}
					id={namespace + ParamProperty.PARAM_TYPE}
					options={Object.keys(ParamType).map((key) => ({
						label: ParamType[key],
						value: ParamType[key]
					}))}
					value={parameterState.paramType}
					onChange={handleParamTypeSelect}
					spritemap={spritemap}
				/>
			</Form.Group>
			<ClayMultiStepNav>
				{stepsRef.current.map(({ subTitle, title }, i) => {
					const complete = i < panelStepState;

					return (
						<ClayMultiStepNav.Item
							active={panelStepState === i}
							expand={i + 1 !== stepsRef.current.length}
							key={i}
							state={complete ? "complete" : undefined}
						>
							<ClayMultiStepNav.Title>{title}</ClayMultiStepNav.Title>
							<ClayMultiStepNav.Divider />
							<ClayMultiStepNav.Indicator
								complete={complete}
								label={i + 1}
								onClick={() => handlePanelStepChange(i)}
								subTitle={subTitle}
							/>
						</ClayMultiStepNav.Item>
					);
				})}
			</ClayMultiStepNav>
			{panelContent}
		</>
	);
};

export default SXDSBuilderPropertiesPanel;
