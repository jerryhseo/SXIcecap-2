import React from "react";
import { Util } from "../../stationx/util";
import { ErrorClass, Event, ParamProperty, ParamType, ValidationRule } from "../../stationx/station-x";
import { SXBoolean, SXInput, SXLocalizedInput } from "../../stationx/form";
import LocalizedInput from "@clayui/localized-input";
import { BooleanParameter, Parameter, StringParameter } from "../../stationx/parameter";
import { SXModalDialog } from "../../stationx/modal";

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

		this.state = {
			paramNameDuplicatedErrorDlg: false
		};

		this.fields = {
			paramName: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
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
			paramVersion: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.PARAM_VERSION,
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
			displayName: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
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
			definition: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
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
			showDefinition: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.SHOW_DEFINITION,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "show-definition"),
					tooltip: Util.getTranslationObject(this.languageId, "show-definition-of-the-parameter-tooltip"),
					value: this.workingParam.showDefinition
				}
			),
			tooltip: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.TOOLTIP,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "tooltip-of-the-parameter"),
					tooltip: Util.getTranslationObject(this.languageId, "tooltip-of-the-parameter-tooltip"),
					value: this.workingParam.tooltip
				}
			),
			synonyms: Parameter.createParameter(
				this.namespace,
				this.formIds.basicPropertiesFormId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.SYNONYMS,
					displayName: Util.getTranslationObject(this.languageId, "synonyms"),
					placeholder: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter"),
					tooltip: Util.getTranslationObject(this.languageId, "synonyms-of-the-parameter-tooltip"),
					value: this.workingParam.synonyms
				}
			)
		};

		//console.log("SXDSBuilderBasicPropertiesPanel: ", props);
	}

	valueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (
			dataPacket.targetPortlet !== this.namespace ||
			dataPacket.targetFormId !== this.formIds.basicPropertiesFormId
		) {
			/*
			console.log(
				"REJECTED - SXDSBuilderBasicPropertiesPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.dataStructure,
				this.workingParam,
				dataPacket.parameter
			);
			*/
			return;
		}

		/*
		console.log(
			"RECEIVED - SXDSBuilderBasicPropertiesPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.dataStructure,
			this.workingParam,
			dataPacket.parameter
		);
		*/

		this.workingParam[dataPacket.paramName] = dataPacket.parameter.getValue();

		/*
			if (
				(this.workingParam.paramType === paramType.GROUP || this.workingParam.paramType === paramType.GRID) &&
				(dataPacket.paramName === ParamProperty.PARAM_NAME ||
					dataPacket.paramName === ParamProperty.PARAM_VERSION)
			) {
				this.workingParam.updateMemberParents();
			}
				*/

		if (dataPacket.paramName === ParamProperty.PARAM_NAME) {
			if (this.dataStructure.checkDuplicateParam(this.workingParam)) {
				this.fields.paramName.errorClass = ErrorClass.ERROR;
				this.fields.paramName.errorMessage = Util.translate("parameter-name-must-be-unique");
				this.fields.paramName.dirty = true;
				this.fields.paramName.refreshKey();

				this.setState({ paramNameDuplicatedErrorDlg: true });
				return;
			}
		}

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
	};

	componentDidMount() {
		//console.log("componentDidMount: SXDSBuilderBasicPropertiesPanel");

		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.valueChangedHandler);
		//Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, valueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.valueChangedHandler);
	}

	render() {
		//console.log("SXDSBuilderBasicPropertiesPanel: ", this.workingParam);
		const fields = Object.values(this.fields);

		return (
			<>
				{fields.map((field) =>
					field.renderField({
						spritemap: this.spritemap
					})
				)}
				{this.state.paramNameDuplicatedErrorDlg && (
					<SXModalDialog
						header="Error"
						body={Util.translate("parameter-name-must-be-unique")}
						buttons={[
							{
								onClick: () => {
									this.setState({ paramNameDuplicatedErrorDlg: false });
								},
								label: Util.translate("ok"),
								displayType: "primary"
							}
						]}
						status="info"
						spritemap={this.spritemap}
					/>
				)}
			</>
		);
	}
}

export default SXDSBuilderBasicPropertiesPanel;
