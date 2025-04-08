import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType, ValidationRule } from "../../common/station-x";
import SXFormField from "../../form/sxform";
import { BooleanParameter, GroupParameter, Parameter, SelectParameter } from "../../parameter/parameter";

const SXDSBuilderOptionPropertiesPanel = ({
	namespace,
	dsbuilderId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	parameter,
	spritemap
}) => {
	const optionPanelId = namespace + "optionPanel";

	const optionFields = [
		{
			paramType: ParamType.GROUP,
			paramName: "groupOptions",
			viewType: GroupParameter.ViewTypes.HORIZONTAL,
			membersPerRow: 2,
			members: [
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.ABSTRACT_KEY,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					labelPosition: Parameter.LabelPosition.INLINE_LEFT,
					label: Util.translate("abstract-key"),
					tooltip: Util.translate("abstract-key-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("abstract-key"),
					value: false
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.DOWNLOADABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					label: Util.translate("downloadable"),
					tooltip: Util.translate("downloadable-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("downloadable"),
					value: true
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.SEARCHABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					label: Util.translate("searchable"),
					tooltip: Util.translate("searchable-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("searchable"),
					value: true
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.DISABLED,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					label: Util.translate("disabled"),
					tooltip: Util.translate("disabled-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("disabled"),
					value: false
				}
			]
		}
	];

	return (
		<>
			<div className="sheet-section">
				<div className="sheet-subtitle">{Util.translate("label-position")}</div>
				<SXFormField
					namespace={namespace}
					properties={{
						paramType: ParamType.SELECT,
						paramName: ParamProperty.LABEL_POSITION,
						paramVersion: "1.0.0",
						viewType: SelectParameter.ViewTypes.RADIO,
						optionsPerRow: 2,
						label: Util.translate("label-position"),
						tooltip: Util.translate("label-position-tooltip"),
						options: [
							{
								label: Util.translate("upper-left"),
								value: Parameter.LabelPosition.UPPER_LEFT
							},
							{
								label: Util.translate("inline-left"),
								value: Parameter.LabelPosition.INLINE_LEFT
							}
							/*
											{
												label: Util.translate("upper-right"),
												value: Parameter.LabelPosition.UPPER_RIGHT
											},
											{
												label: Util.translate("inline-right"),
												value: Parameter.LabelPosition.INLINE_RIGHT
											},
											{
												label: Util.translate("bottom-left"),
												value: Parameter.LabelPosition.BOTTOM_LEFT
											},
											{
												label: Util.translate("bottom-right"),
												value: Parameter.LabelPosition.BOTTOM_RIGHT
											}
											*/
						],
						value: SelectParameter.LabelPosition.UPPER_LEFT
					}}
					events={{
						fire: [
							{
								target: dsbuilderId,
								event: Event.SX_FIELD_VALUE_CHANGED
							}
						]
					}}
					spritemap={spritemap}
				/>
			</div>
			{optionFields.map((field) => {
				return (
					<SXFormField
						key={field.namespace + "_" + field.paramName}
						namespace={namespace}
						properties={field}
						events={{
							fire: [
								{
									target: dsbuilderId,
									event: Event.SX_FIELD_VALUE_CHANGED
								}
							]
						}}
						spritemap={spritemap}
					/>
				);
			})}
		</>
	);
};

export default SXDSBuilderOptionPropertiesPanel;
