import React, { useCallback, useEffect, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType, ValidationRule } from "../../common/station-x";
import SXFormField from "../../form/sxform";

const SXDSBuilderBasicPropertiesPanel = ({
	namespace,
	dsbuilderId,
	propertyPanelId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	parameter,
	spritemap
}) => {
	console.log("SXDSBuilderBasicPropertiesPanel: ", parameter);
	const [fields, setFields] = useState([]);

	useLayoutEffect(() => {
		setFields([
			{
				paramType: ParamType.STRING,
				paramName: ParamProperty.PARAM_NAME,
				required: true,
				label: Util.translate("parameter-name"),
				placeholder: Util.translate("code-name-of-the-parameter"),
				tooltip: Util.translate("code-name-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("parameter-name"),
				initValue: parameter.paramName ?? "",
				validation: {
					required: {
						value: true,
						message: Util.translate("Parameter name is required")
					},
					pattern: {
						value: ValidationRule.VARIABLE,
						message: Util.translate("invalid-parameter-name")
					},
					min: {
						value: 8,
						message: Util.translate("too-short")
					},
					max: {
						value: 32,
						message: Util.translate("too-long")
					}
				}
			},
			{
				paramType: ParamType.STRING,
				paramName: ParamProperty.VERSION,
				required: true,
				label: Util.translate("version"),
				placeholder: Util.translate("version-of-the-parameter"),
				tooltip: Util.translate("version-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("version"),
				initValue: parameter.paramVersion ?? "1.0.0",
				validation: {
					required: {
						value: true,
						message: Util.translate("Parameter version is required")
					},
					pattern: {
						value: ValidationRule.VERSION,
						message: Util.translate("invalid-parameter-version")
					}
				}
			},
			{
				paramType: ParamType.LOCALIZED_STRING,
				paramName: ParamProperty.DISPLAY_NAME,
				required: true,
				label: Util.translate("display-name"),
				languageId: languageId,
				availableLanguageIds: availableLanguageIds,
				placeholder: Util.translate("display-name-of-the-parameter"),
				tooltip: Util.translate("display-name-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("display-name"),
				initValue: parameter.displayName ?? {},
				validation: {
					required: {
						value: true,
						message: Util.translate("display-name-is-required")
					},
					min: {
						value: 2,
						message: Util.translate("too-short")
					},
					max: {
						value: 32,
						message: Util.translate("too-long")
					}
				}
			},
			{
				paramType: ParamType.LOCALIZED_STRING,
				paramName: ParamProperty.DEFINITION,
				label: Util.translate("definition"),
				languageId: languageId,
				availableLanguageIds: availableLanguageIds,
				multipleLine: true,
				placeholder: Util.translate("definition-of-the-parameter"),
				tooltip: Util.translate("definition-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("definition"),
				initValue: parameter.definition ?? {}
			},
			{
				paramType: ParamType.LOCALIZED_STRING,
				paramName: ParamProperty.TOOLTIP,
				label: Util.translate("tooltip"),
				languageId: languageId,
				availableLanguageIds: availableLanguageIds,
				placeholder: Util.translate("tooltip-of-the-parameter"),
				tooltip: Util.translate("tooltip-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("tooltip"),
				initValue: parameter.tooltip ?? {}
			},
			{
				paramType: ParamType.STRING,
				paramName: ParamProperty.SYNONYMS,
				label: Util.translate("synonyms"),
				placeholder: Util.translate("synonyms-of-the-parameter"),
				tooltip: Util.translate("synonyms-of-the-parameter-tooltip"),
				ariaLabel: Util.translate("synonyms"),
				initValue: parameter.synonyms ?? ""
			}
		]);
	}, [parameter]);

	console.log("SXDSBuilderBasicPropertiesPanel fields: ", fields);
	return (
		<div>
			{fields.map((field) => {
				let events = {
					fire: [
						{
							target: dsbuilderId,
							event: Event.SX_FIELD_VALUE_CHANGED
						}
					]
				};

				if (field.paramName === ParamProperty.DISPLAY_NAME || field.paramName === ParamProperty.TOOLTIP) {
					events.fire.push({
						target: previewCanvasId,
						event: Event.SX_PARAM_PROPERTY_CHANGED
					});
				}

				return (
					<SXFormField
						key={field.paramName + "_" + field.paramVersion}
						namespace={namespace}
						properties={field}
						events={events}
						spritemap={spritemap}
					/>
				);
			})}
		</div>
	);
};

export default SXDSBuilderBasicPropertiesPanel;
