import React from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ValidationRule } from "../../common/station-x";
import { SXBoolean, SXInput, SXLocalizedInput } from "../../form/sxform";
import LocalizedInput from "@clayui/localized-input";
import { BooleanParameter, Parameter, StringParameter } from "../../parameter/parameter";

class SXDSBuilderBasicPropertiesPanel extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.workingParam.namespace;
		this.formIds = props.formIds;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;
		this.spritemap = props.spritemap;

		this.fields = {
			paramName: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.PARAM_NAME,
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
			),
			paramVersion: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.VERSION,
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
			),
			displayName: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.DISPLAY_NAME,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "display-name"),
					placeholder: Util.getTranslationObject(this.languageId, "display-name-of-the-parameter"),
					tooltip: Util.getTranslationObject(this.languageId, "display-name-of-the-parameter-tooltip"),
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
					value: this.workingParam.displayName ?? {}
				}
			),
			definition: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
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
			),
			showDefinition: new BooleanParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.SHOW_DEFINITION,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "show-definition"),
					tooltip: Util.getTranslationObject(this.languageId, "show-definition-of-the-parameter-tooltip"),
					value: this.workingParam.showDefinition
				}
			),
			tooltip: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
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
			),
			synonyms: new StringParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.SYNONYMS,
					displayName: Util.getTranslationObject(this.languageId, "synonyms"),
					placeholder: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter"),
					tooltip: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter-tooltip"),
					value: this.workingParam.synonyms
				}
			)
		};

		console.log("SXDSBuilderBasicPropertiesPanel: ", props);
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (
				dataPacket.targetPortlet !== this.namespace ||
				dataPacket.targetFormId !== this.formIds.basicPropertiesFormId
			)
				return;

			console.log(
				"SXDSBuilderBasicPropertiesPanel SX_FIELD_VALUE_CHANGED RECEIVED: ",
				dataPacket,
				this.dataStructure,
				this.workingParam
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();
			/*
			if (
				this.workingParam.isGroup &&
				(dataPacket.paramName === ParamProperty.PARAM_NAME ||
					dataPacket.paramName === ParamProperty.PARAM_VERSION)
			) {
				this.workingParam.updateMemberParents();
			}
				*/

			if (this.workingParam.isRendered()) {
				if (this.workingParam.displayType === Parameter.DisplayTypes.GRID_CELL) {
					const gridParam = this.dataStructure.findParameter({
						paramName: this.workingParam.parent.name,
						paramVersion: this.workingParam.parent.version,
						descendant: true
					});

					gridParam.fireRefreshPreview();
				} else {
					this.workingParam.fireRefreshPreview();
				}
			}
		});
	}

	render() {
		console.log("SXDSBuilderBasicPropertiesPanel: ", this.workingParam);
		const fields = Object.values(this.fields);

		return (
			<>
				{fields.map((field) =>
					field.renderField({
						spritemap: this.spritemap
					})
				)}
			</>
		);
	}
}

export default SXDSBuilderBasicPropertiesPanel;
