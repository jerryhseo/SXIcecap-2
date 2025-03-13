import { ParamProperty, ValidationRule, ViewTypes } from "../../common/station-x";
import { GroupParameter } from "../../parameter/parameter";

export const basicPropertyFields = [
	{
		paramName: ParamProperty.NAME,
		paramType: ParamType.STRING,
		displayName: Util.translate("name"),
		required: true,
		placeholder: Util.translate("code-name-of-the-parameter"),
		tooltip: Util.translate("parameter-name-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},
		validation: {
			required: {
				value: true,
				message: `${ParamProperty.NAME} is required`
			},
			pattern: {
				value: ValidationRule.VARIABLE,
				message: "Invalid data type name"
			},
			min: {
				value: 3,
				message: "Should be at least 3"
			},
			max: {
				value: 32,
				message: "Should be shorter than 33"
			}
		},
		order: 1
	},
	{
		paramName: ParamProperty.VERSION,
		paramType: ParamType.STRING,
		displayName: Util.translate("parameter-version"),
		required: true,
		placeholder: Util.translate("version-of-the-paramameter"),
		tooltip: Util.translate("parameter-version-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},
		validation: {
			required: {
				value: true,
				message: `${ParamProperty.VERSION} is required`
			},
			pattern: {
				value: ValidationRule.VERSION,
				message: "Invalid parameter version"
			}
		},
		order: 2
	},
	{
		paramName: ParamProperty.DISPLAY_NAME,
		paramType: ParamType.STRING,
		displayName: Util.translate("parameter-display-name"),
		required: true,
		localized: true,
		languageId: languageId,
		availableLanguageIds: availableLanguageIds.split(","),
		placeholder: Util.translate("display-name-of-the-parameter"),
		tooltip: Util.translate("parameter-display-name-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},
		validation: {
			required: {
				value: true,
				message: `${ParamProperty.DISPLAY_NAME}-is-required`
			},
			pattern: {
				value: ValidationRule.NO_SPECIAL_CHARACTERS,
				message: "Invalid display name"
			},
			min: {
				value: 8,
				message: "Should be at least 8"
			},
			max: {
				value: 72,
				message: "Should be shorter than 72"
			}
		},
		order: 3
	},
	{
		paramName: ParamProperty.DEFINITION,
		paramType: ParamType.STRING,
		displayName: Util.translate("definition"),
		localized: true,
		languageId: languageId,
		availableLanguageIds: availableLanguageIds.split(","),
		placeholder: Util.translate("definition-of-the-parameter"),
		tooltip: Util.translate("parameter-definition-tooltip"),
		multiLine: true,
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},
		order: 4
	},
	{
		paramName: DataTypeProperty.TOOLTIP,
		paramType: ParamType.STRING,
		displayName: Util.translate("tooltip"),
		required: false,
		localized: true,
		languageId: languageId,
		availableLanguageIds: availableLanguageIds.split(","),
		placeholder: Util.translate("tooltip-of-the-parameter"),
		tooltip: Util.translate("parameter-tooltip-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},

		validation: {
			max: {
				value: 72,
				message: Util.translate("input-field-is-too-long")
			}
		},
		order: 5
	}
].sort((a, b) => a.order - b.order);

export const optionalPropertyFields = [
	{
		paramName: ParamProperty.SEARCHABLE,
		paramType: ParamType.BOOLEAN,
		viewType: "checkbox",
		displayName: Util.translate("searchable"),
		tooltip: Util.translate("searchable-tooltip"),
		DEFAULT_VALUE: true,
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED]
		},
		order: 1
	},
	{
		paramName: ParamProperty.DOWNLOADABLE,
		paramType: ParamType.BOOLEAN,
		viewType: "checkbox",
		displayName: Util.translate("downloadable"),
		tooltip: Util.translate("downloadable-tooltip"),
		DEFAULT_VALUE: true,
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED]
		},
		order: 2
	},
	{
		paramName: ParamProperty.ABSTRACT_KEY,
		paramType: ParamType.BOOLEAN,
		viewType: "checkbox",
		displayName: Util.translate("abstractKey"),
		tooltip: Util.translate("abstract-key-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED]
		},
		order: 3
	},
	{
		paramName: ParamProperty.DEFAULT_VALUE,
		paramType: ParamType.STRING,
		displayName: Util.translate("default-value"),
		tooltip: Util.translate("default-value-tooltip"),
		events: {
			fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
		},
		order: 4
	}
];

const minLengthValidationFormFields = {
	paramName: ParamProperty.MIN_LENGTH,
	paramType: ParamType.GROUP,
	viewType: GroupParameter.ViewTypes.LIST,
	displayName: Util.translate("min-length"),
	tooltip: Util.translate("min-length-property-tooltip"),
	children: [
		{
			paramName: "minLengthValue",
			paramType: ParamType.NUMERIC,
			isInteger: true,
			displayName: Util.translate("min-length"),
			tooltip: Util.translate("min-length-property-tooltip"),
			defaultValue: 1,
			events: {
				fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
			},
			order: 1
		},
		{
			paramName: "minLengthMessage",
			paramType: ParamType.STRING,
			displayName: Util.translate("message"),
			tooltip: Util.translate("message-property-tooltip"),
			defaultValue: "min-length-is-too-short",
			events: {
				fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
			},
			order: 2
		}
	]
};

const maxLengthValidationFormFields = {
	paramName: ParamProperty.MAX_LENGTH,
	paramType: ParamType.GROUP,
	viewType: GroupParameter.ViewTypes.LIST,
	displayName: Util.translate("max-length"),
	tooltip: Util.translate("max-length-property-tooltip"),
	children: [
		{
			paramName: "maxLengthValue",
			paramType: ParamType.NUMERIC,
			isInteger: true,
			displayName: Util.translate("max-length"),
			tooltip: Util.translate("max-length-property-tooltip"),
			defaultValue: 72,
			events: {
				fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
			}
		},
		{
			paramName: "maxLengthMessage",
			paramType: ParamType.STRING,
			displayName: Util.translate("message"),
			tooltip: Util.translate("message-property-tooltip"),
			defaultValue: "max-length-is-too-short",
			events: {
				fire: [Event.SX_FORM_FIELD_CHANGED, Event.SX_PARAM_PROPERTY_CHANGED]
			}
		}
	],
	order: 2
};

const patternValidationFormFields = {
	paramName: ParamProperty.PATTERN,
	paramType: ParamType.STRING,
	displayName: Util.translate("pattern"),
	tooltip: Util.translate("pattern-property-tooltip")
};

const validationValidationFormFields = {
	paramName: ParamProperty.VALIDATION,
	paramType: ParamType.STRING,
	multiLine: true,
	displayName: Util.translate("validation"),
	tooltip: Util.translate("validation-property-tooltip")
};

export const paramTypePropertyFields = {
	String: [
		{
			paramName: ParamProperty.VALIDATION_RULE,
			paramType: ParamType.GROUP,
			viewType: GroupParameter.ViewTypes.LIST, // or panel
			displayName: Util.translate("validation-rule"),
			tooltip: Util.translate("validation-rule-property-tooltip"),
			children: [
				{
					paramName: ParamProperty.VALIDATION_RULE,
					paramType: ParamType.GROUP,
					viewType: GroupParameter.ViewTypes.LIST, // or panel
					displayName: Util.translate("validation-rule"),
					tooltip: Util.translate("validation-rule-property-tooltip"),
					children: [
						minLengthValidationFormFields,
						maxLengthValidationFormFields,
						patternValidationFormFields,
						validationValidationFormFields
					]
				}
			]
		}
	]
};
