import React from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ValidationRule } from "../../common/station-x";
import { SXBoolean, SXInput, SXLocalizedInput } from "../../form/sxform";
import LocalizedInput from "@clayui/localized-input";
import { BooleanParameter } from "../../parameter/parameter";

class SXDSBuilderBasicPropertiesPanel extends React.Component {
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

		this.paramNameProps = {
			paramName: ParamProperty.PARAM_NAME,
			required: true,
			label: Util.translate("parameter-name"),
			placeholder: Util.translate("code-name-of-the-parameter"),
			tooltip: Util.translate("code-name-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("parameter-name"),
			value: props.parameter.paramName ?? "",
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
		};
		this.versionProps = {
			paramName: ParamProperty.VERSION,
			required: true,
			label: Util.translate("version"),
			placeholder: Util.translate("version-of-the-parameter"),
			tooltip: Util.translate("version-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("version"),
			value: props.parameter.paramVersion ?? "1.0.0",
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
		};
		this.displayNameProps = {
			paramName: ParamProperty.DISPLAY_NAME,
			required: true,
			label: Util.translate("display-name"),
			languageId: props.languageId,
			availableLanguageIds: props.availableLanguageIds,
			placeholder: Util.translate("display-name-of-the-parameter"),
			tooltip: Util.translate("display-name-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("display-name"),
			value: props.parameter.displayName ?? {},
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
		};
		this.definitionProps = {
			paramName: ParamProperty.DEFINITION,
			label: Util.translate("definition"),
			languageId: props.languageId,
			availableLanguageIds: props.availableLanguageIds,
			multipleLine: true,
			placeholder: Util.translate("definition-of-the-parameter"),
			tooltip: Util.translate("definition-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("definition"),
			value: props.parameter.definition ?? {},
			validation: {
				max: {
					value: 512,
					message: Util.translate("too-long")
				}
			}
		};
		this.showDefinitionProps = {
			paramName: ParamProperty.SHOW_DEFINITION,
			viewType: BooleanParameter.ViewTypes.CHECKBOX,
			label: Util.translate("show-definition"),
			tooltip: Util.translate("show-definition-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("show-definition"),
			value: props.parameter.showDefinition
		};
		this.tooltipProps = {
			paramName: ParamProperty.TOOLTIP,
			label: Util.translate("tooltip"),
			languageId: props.languageId,
			availableLanguageIds: props.availableLanguageIds,
			placeholder: Util.translate("tooltip-of-the-parameter"),
			tooltip: Util.translate("tooltip-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("tooltip"),
			value: props.parameter.tooltip ?? {}
		};
		this.synonymsProps = {
			paramName: ParamProperty.SYNONYMS,
			label: Util.translate("synonyms"),
			placeholder: Util.translate("synonyms-of-the-parameter"),
			tooltip: Util.translate("synonyms-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("synonyms"),
			value: props.parameter.synonyms ?? ""
		};

		console.log("SXDSBuilderBasicPropertiesPanel: ", props);
	}

	render() {
		console.log("SXDSBuilderBasicPropertiesPanel: ", this.state.parameter);
		const events = {
			fire: [
				{
					target: this.dsbuilderId,
					event: Event.SX_FIELD_VALUE_CHANGED
				}
			]
		};
		return (
			<>
				<SXInput
					namespace={this.namespace}
					{...this.paramNameProps}
					events={events}
					spritemap={this.spritemap}
				/>
				<SXInput
					namespace={this.namespace}
					{...this.versionProps}
					events={events}
					spritemap={this.spritemap}
				/>
				<SXLocalizedInput
					namespace={this.namespace}
					{...this.displayNameProps}
					events={events}
					spritemap={this.spritemap}
				/>
				<SXLocalizedInput
					namespace={this.namespace}
					{...this.definitionProps}
					events={events}
					style={{ marginBottom: "5px" }}
					spritemap={this.spritemap}
				/>
				<SXBoolean
					namespace={this.namespace}
					{...this.showDefinitionProps}
					events={events}
					style={{ marginBottom: "15px" }}
					spritemap={this.spritemap}
				/>
				<SXLocalizedInput
					namespace={this.namespace}
					{...this.tooltipProps}
					events={events}
					spritemap={this.spritemap}
				/>
				<SXInput
					namespace={this.namespace}
					{...this.synonymsProps}
					events={events}
					spritemap={this.spritemap}
				/>
			</>
		);
	}
}

export default SXDSBuilderBasicPropertiesPanel;
