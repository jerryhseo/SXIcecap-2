import React from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ValidationRule } from "../../common/station-x";
import { SXBoolean, SXInput, SXLocalizedInput } from "../../form/sxform";
import LocalizedInput from "@clayui/localized-input";
import { BooleanParameter, StringParameter } from "../../parameter/parameter";

class SXDSBuilderBasicPropertiesPanel extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.workingParam.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;
		this.spritemap = props.spritemap;

		this.basicPropertiesFormId = this.namespace + "basicPropertiesForm";

		this.fieldParamName = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.PARAM_NAME,
				required: true,
				displayName: Util.getTranslationObject(this.languageId, "parameter-name"),
				placeholder: Util.getTranslationObject(this.languageId, "code-name-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "code-name-of-the-parameter-tooltip"),
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "this-field-is-required")
					},
					pattern: {
						value: ValidationRule.VARIABLE,
						message: Util.getTranslationObject(this.languageId, "invalid-parameter-name")
					},
					min: {
						value: 8,
						message: Util.getTranslationObject(this.languageId, "too-short")
					},
					max: {
						value: 32,
						message: Util.getTranslationObject(this.languageId, "too-long")
					}
				},
				value: this.workingParam.paramName
			}
		);
		this.fieldParamVersion = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.VERSION,
				required: true,
				displayName: Util.getTranslationObject(this.languageId, "version"),
				placeholder: Util.getTranslationObject(this.languageId, "version-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "version-of-the-parameter-tooltip"),
				defaultValue: "1.0.0",
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "Parameter version is required")
					},
					pattern: {
						value: ValidationRule.VERSION,
						message: Util.getTranslationObject(this.languageId, "invalid-parameter-version")
					}
				},
				value: this.workingParam.paramVersion
			}
		);
		this.fieldDisplayName = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.DISPLAY_NAME,
				localized: true,
				required: true,
				displayName: Util.getTranslationObject(this.languageId, "display-name"),
				placeholder: Util.getTranslationObject(this.languageId, "display-name-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "display-name-of-the-parameter-tooltip"),
				value: this.workingParam.displayName ?? {},
				validation: {
					required: {
						value: true,
						message: Util.getTranslationObject(this.languageId, "display-name-is-required")
					},
					min: {
						value: 2,
						message: Util.getTranslationObject(this.languageId, "too-short")
					},
					max: {
						value: 32,
						message: Util.getTranslationObject(this.languageId, "too-long")
					}
				},
				value: this.workingParam.displayName
			}
		);
		this.fieldDefinition = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.DEFINITION,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "definition"),
				multipleLine: true,
				placeholder: Util.getTranslationObject(this.languageId, "definition-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "definition-of-the-parameter-tooltip"),
				validation: {
					max: {
						value: 512,
						message: Util.getTranslationObject(this.languageId, "too-long")
					}
				},
				value: this.workingParam.definition
			}
		);
		this.fieldShowDefinition = new BooleanParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.SHOW_DEFINITION,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "show-definition"),
				tooltip: Util.getTranslationObject(this.languageId, "show-definition-of-the-parameter-tooltip"),
				value: this.workingParam.showDefinition
			}
		);
		this.fieldTooltip = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.TOOLTIP,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "tooltip-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "tooltip-of-the-parameter-tooltip"),
				value: this.workingParam.tooltip
			}
		);
		this.fieldSynonyms = new StringParameter(
			this.namespace,
			this.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.SYNONYMS,
				displayName: Util.getTranslationObject(this.languageId, "synonyms"),
				placeholder: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter"),
				tooltip: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter-tooltip"),
				value: this.workingParam.synonyms
			}
		);

		this.fields = [
			this.fieldParamName,
			this.fieldParamVersion,
			this.fieldDisplayName,
			this.fieldDefinition,
			this.fieldShowDefinition,
			this.fieldTooltip,
			this.fieldSynonyms
		];

		console.log("SXDSBuilderBasicPropertiesPanel: ", props);
	}

	componentDidMount() {
		console.log("Mounted SXDSBuilderBasicPropertiesPanel");
		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.basicPropertiesFormId)
				return;

			this.dataStructure.dirty = true;

			this.workingParam.clearError();
			this.workingParam[dataPacket.paramName] = dataPacket.value;

			console.log("DataStructureBuilder SX_FIELD_VALUE_CHANGED RECEIVED: ", dataPacket, this.workingParam);

			this.workingParam.fireRefreshPreview();
		});
	}

	render() {
		console.log("SXDSBuilderBasicPropertiesPanel: ", this.workingParam);
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
				{this.fields.map((field) =>
					field.render({
						spritemap: this.spritemap,
						inputStatus: this.dataStructure.inputStatus
					})
				)}
			</>
		);
	}
}

export default SXDSBuilderBasicPropertiesPanel;
