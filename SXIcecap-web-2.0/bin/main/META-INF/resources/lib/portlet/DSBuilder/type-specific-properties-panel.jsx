import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import SXFormField from "../../form/sxform";
import { SelectParameter } from "../../parameter/parameter";

const SXDSBuilderTypeSpecificPanel = ({
	namespace,
	dsbuilderId,
	propertyPanelId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	parameter,
	spritemap
}) => {
	let events = {
		fire: [
			{
				target: dsbuilderId,
				event: Event.SX_FIELD_VALUE_CHANGED
			}
		]
	};

	switch (parameter.paramType) {
		case ParamType.LOCALIZED_STRING:
		case ParamType.STRING: {
			return (
				<>
					<SXFormField
						namespace={namespace}
						properties={{
							paramType: ParamType.LOCALIZED_STRING,
							paramName: ParamProperty.PLACEHOLDER,
							languageId: languageId,
							availableLanguageIds: availableLanguageIds,
							paramVersion: "1.0.0",
							label: Util.translate("placeholder"),
							tooltip: Util.translate("placeholder-tooltip"),
							placeholder: Util.translate("placeholder")
						}}
						events={events}
						spritemap={spritemap}
					/>
					<SXFormField
						namespace={namespace}
						properties={{
							paramType: ParamType.BOOLEAN,
							paramName: ParamProperty.MULTIPLE_LINE,
							paramVersion: "1.0.0",
							viewType: SelectParameter.ViewTypes.CHECKBOX,
							label: Util.translate("multiple-line"),
							tooltip: Util.translate("multiple-line-tooltip"),
							trueLabel: Util.translate("multiple-line")
						}}
						events={events}
						spritemap={spritemap}
					/>
				</>
			);
		}
		case ParamType.SELECT: {
			events.on = [
				{
					target: dsbuilderId,
					event: Event.SX_PARAM_VALUE_CHANGED
				}
			];

			return (
				<>
					<SXFormField
						namespace={namespace}
						properties={{
							paramType: ParamType.SELECT,
							paramName: ParamProperty.VIEW_TYPE,
							paramVersion: "1.0.0",
							viewType: SelectParameter.ViewTypes.RADIO,
							label: Util.translate("view-type"),
							tooltip: Util.translate("select-view-type-tooltip"),
							options: [
								{
									label: "Dropdown",
									value: SelectParameter.ViewTypes.DROPDOWN
								},
								{
									label: "Radio",
									value: SelectParameter.ViewTypes.RADIO
								},
								{
									label: "Checkbox",
									value: SelectParameter.ViewTypes.CHECKBOX
								},
								{
									label: "Listbox",
									value: SelectParameter.ViewTypes.LISTBOX
								}
							],
							initValue: SelectParameter.ViewTypes.DROPDOWN
						}}
						events={events}
						spritemap={spritemap}
					/>
				</>
			);
		}
		case ParamType.BOOLEAN: {
			const fields = [
				{
					paramType: ParamType.STRING,
					paramName: ParamProperty.TRUE_LABEL,
					label: Util.translate("true-label"),
					paramVersion: "1.0.0",
					localized: true,
					languageId: languageId,
					availableLanguageIds: availableLanguageIds,
					placeholder: Util.translate("label-for-true-option"),
					tooltip: Util.translate("label-for-true-option-tooltip")
				},
				{
					paramType: ParamType.STRING,
					paramName: ParamProperty.FALSE_LABEL,
					label: Util.translate("false-label"),
					paramVersion: "1.0.0",
					localized: true,
					languageId: languageId,
					availableLanguageIds: availableLanguageIds,
					placeholder: Util.translate("label-for-false-option"),
					tooltip: Util.translate("label-for-false-option-tooltip")
				}
			];

			return (
				<div>
					{fields.map((field) => {
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
		}
	}

	return <div>{"Step 2 to define a parameter."}</div>;
};

export default SXDSBuilderTypeSpecificPanel;
