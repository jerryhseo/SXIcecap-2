import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import SXFormField from "../../form/sxform";
import { BooleanParameter, SelectParameter } from "../../parameter/parameter";

class SXDSBuilderTypeSpecificPanel extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.languageId;
		this.availableLanguageIds = props.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.state = {
			parameter: props.parameter
		};

		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {});
	}

	render() {
		let events = {
			fire: [
				{
					target: this.dsbuilderId,
					event: Event.SX_FIELD_VALUE_CHANGED
				}
			]
		};

		switch (this.state.parameter.paramType) {
			case ParamType.LOCALIZED_STRING:
			case ParamType.STRING: {
				return (
					<>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.LOCALIZED_STRING,
								paramName: ParamProperty.PLACEHOLDER,
								languageId: this.languageId,
								availableLanguageIds: this.availableLanguageIds,
								paramVersion: "1.0.0",
								label: Util.translate("placeholder"),
								tooltip: Util.translate("placeholder-tooltip"),
								placeholder: Util.translate("placeholder"),
								value: this.state.parameter.placeholder
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.MULTIPLE_LINE,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("multiple-line"),
								tooltip: Util.translate("multiple-line-tooltip"),
								value: this.state.parameter.multipleLine
							}}
							events={events}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.NUMERIC: {
				return (
					<>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.IS_INTEGER,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("integer"),
								tooltip: Util.translate("integer-tooltip"),
								value: this.state.parameter.isInteger
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						{!this.state.parameter.isInteger && (
							<SXFormField
								namespace={this.namespace}
								properties={{
									paramType: ParamType.NUMERIC,
									paramName: ParamProperty.decimalPlaces,
									paramVersion: "1.0.0",
									label: Util.translate("decimal-places"),
									tooltip: Util.translate("decimal-places-tooltip"),
									isInteger: true,
									languageId: this.languageId,
									value: this.state.parameter.decimalPlaces ?? ""
								}}
								events={events}
								spritemap={this.spritemap}
							/>
						)}
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.STRING,
								paramName: ParamProperty.UNIT,
								paramVersion: "1.0.0",
								label: Util.translate("unit"),
								tooltip: Util.translate("unit-tooltip"),
								languageId: this.languageId,
								value: this.state.parameter.unit
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.UNCERTAINTY,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("uncertainty"),
								tooltip: Util.translate("uncertainty-tooltip"),
								value: this.state.parameter.uncertainty
							}}
							events={events}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.SELECT: {
				events.on = [
					{
						target: this.dsbuilderId,
						event: Event.SX_PARAM_VALUE_CHANGED
					}
				];

				return (
					<>
						<SXFormField
							namespace={this.namespace}
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
								value: SelectParameter.ViewTypes.DROPDOWN
							}}
							events={events}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.BOOLEAN: {
				const fields = [
					{
						paramType: ParamType.LOCALIZED_STRING,
						paramName: ParamProperty.TRUE_LABEL,
						label: Util.translate("true-label"),
						paramVersion: "1.0.0",
						languageId: this.languageId,
						availableLanguageIds: this.availableLanguageIds,
						placeholder: Util.translate("label-for-true-option"),
						tooltip: Util.translate("label-for-true-option-tooltip")
					},
					{
						paramType: ParamType.LOCALIZED_STRING,
						paramName: ParamProperty.FALSE_LABEL,
						label: Util.translate("false-label"),
						paramVersion: "1.0.0",
						languageId: this.languageId,
						availableLanguageIds: this.availableLanguageIds,
						placeholder: Util.translate("label-for-false-option"),
						tooltip: Util.translate("label-for-false-option-tooltip")
					}
				];

				return (
					<div>
						{fields.map((field) => {
							return (
								<SXFormField
									namespace={this.namespace}
									properties={field}
									events={events}
									spritemap={this.spritemap}
								/>
							);
						})}
					</div>
				);
			}
		}

		return <div>{"Step 2 to define a parameter."}</div>;
	}
}

export default SXDSBuilderTypeSpecificPanel;
