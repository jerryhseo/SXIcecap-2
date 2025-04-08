import React from "react";
import { Constant, ViewTypes, ParamType, ValidationKeys, ErrorClass, Event } from "../common/station-x";
import { Util } from "../common/util";
import SXFormField, { SXInput, SXLocalizedInput, SXPreviewRow } from "../form/sxform";

export class Translations {
	constructor(json) {
		if (json) {
			this.parse(json);
		}
	}

	addTranslation(key, translation) {
		this[key] = translation;
	}

	removeTranslation(key) {
		delete this[key];
	}

	parse(json) {
		for (const key in json) {
			this[key] = json[key];
		}
	}

	toJSON() {
		return { ...this };
	}
}

export class SelectOption {
	label = new Translations();
	value;

	constructor(json) {}
}

export class ParamId {}

export class Parameter {
	static ViewTypes = {
		REQULAR_LABEL: "regularLabel",
		INLINE_LABEL: "inlineLabel",
		ROW: "row",
		COLUMN: "column",
		CELL: "cell"
	};

	static LabelPosition = {
		UPPER_LEFT: "upperLeft",
		UPPER_RIGHT: "upperRight",
		INLINE_LEFT: "inlineLeft",
		INLINE_RIGHT: "inlineRight",
		BOTTOM_LEFT: "bottomLeft",
		BOTTOM_RIGHT: "bottomRight",
		NONE: "none"
	};

	static createParameter(namespace, formId, paramType, json) {
		switch (paramType) {
			case ParamType.STRING: {
				return new StringParameter(namespace, formId, json);
			}
			case ParamType.LOCALIZED_STRING: {
				return new LocalizedStringParameter(namespace, formId, json);
			}
			case ParamType.NUMERIC: {
				return new NumericParameter(namespace, formId, json);
			}
			case ParamType.BOOLEAN: {
				return new BooleanParameter(namespace, formId, json);
			}
			case ParamType.SELECT: {
				return new SelectParameter(namespace, formId, json);
			}
			case ParamType.DUALLIST: {
				return new DualListParameter(namespace, formId, json);
			}
			case ParamType.MATRIX: {
				return new MatrixParameter(namespace, formId, json);
			}
			case ParamType.FILE: {
				return new FileParameter(namespace, formId, json);
			}
			case ParamType.ADDRESS: {
				return new AddressParameter(namespace, formId, json);
			}
			case ParamType.DATE: {
				return new DateParameter(namespace, formId, json);
			}
			case ParamType.PHONE: {
				return new PhoneParameter(namespace, formId, json);
			}
			case ParamType.GROUP: {
				return new GroupParameter(namespace, formId, json);
			}
			case ParamType.SELECT_GROUP: {
				return new SelectGroupParameter(namespace, formId, json);
			}
			/*
			case ParamType.GRID: {
				return new GridParameter(namespace, formId, json);
			}
			case ParamType.TABLE: {
				return new TableParameter(namespace, formId, json);
			}
			case ParamType.CALCULATOR: {
				return new CalculatorParameter(namespace, formId, json);
			}
			case ParamType.REFERENCE: {
				return new ReferenceParameter(namespace, formId, json);
			}
			case ParamType.LINKER: {
				return new LinkerParameter(namespace, formId, json);
			}
			case ParamType.IMAGE: {
				return new ImageParameter(namespace, formId, json);
			}
			case ParamType.COMMENT: {
				return new CommentParameter(namespace, formId, json);
			}
				*/
		}
	}

	static getLocalized(localizationObj, languageId) {
		return localizationObj[languageId];
	}
	static addLocalized(localizationObj, languageId, translation) {
		return (localizationObj[languageId] = translation);
	}
	static removeLocalized(localizationObj, languageId) {
		delete localizationObj[languageId];

		return localizationObj;
	}

	static checkValidationEnabled(validation, section) {
		return !!(validation && validation[section]);
	}

	static enableValidation(validation, section, enable) {
		if (enable) {
			switch (section) {
				case ValidationKeys.REQUIRED: {
					validation.required = {
						value: true
					};
					break;
				}
				case ValidationKeys.CUSTOM: {
					validation.custom = 'function(value){\n return {\nmessage:"",\nerrorClass:"has-error"};\n}';
					break;
				}
				default: {
					validation[section] = {};
				}
			}
		} else {
			delete validation[section];
		}
	}

	static toggleValidationSection(validation, section) {
		Parameter.enableValidation(validation, section, !Parameter.checkValidationEnabled(validation, section));
	}

	static getValidationValue(validation, section, valueProp, locale) {
		if (Parameter.checkValidationEnabled(validation, section)) {
			switch (valueProp) {
				case "message": {
					if (locale) {
						return validation[section].message ? validation[section].message[locale] : "";
					} else {
						return validation[section].message;
					}
				}
				case "value":
				case "boundary": {
					return validation[section][valueProp];
				}
				default: {
					return validation[section];
				}
			}
		}
	}
	static setValidationValue(validation, section, valueProp, value, locale) {
		if (Parameter.checkValidationEnabled(validation, section)) {
			switch (valueProp) {
				case "message": {
					if (Util.isEmpty(validation[section].message)) {
						validation[section].message = {};
					}

					if (Util.isNotEmpty(value)) {
						if (locale) {
							validation[section].message[locale] = value;
						} else {
							validation[section].message = value;
						}
					} else {
						if (locale) {
							delete validation[section].message[locale];
						} else {
							delete validation[section].message;
						}
					}

					break;
				}
				case "value":
				case "boundary": {
					if (Util.isNotEmpty(value)) {
						validation[section][valueProp] = value;
					} else {
						delete validation[section][valueProp];
					}
					break;
				}
				default: {
					if (Util.isNotEmpty(value)) {
						validation[section] = value;
					} else {
						delete validation[section];
					}
				}
			}
		}
	}

	static validateValue(fieldType, validation, value, languageId) {
		console.log("validation: ", fieldType, value, validation, languageId);
		switch (fieldType) {
			case ParamType.NUMERIC: {
				if (value === NaN) {
					return {
						message: Util.translate("only-numbers-allowed-for-this-field"),
						errorClass: ErrorClass.ERROR
					};
				}
			}
		}

		for (const validationType in validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (validation.required.value && Util.isEmpty(value)) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.PATTERN: {
					const regExpr = new RegExp(validation.pattern.value);

					if (!regExpr.test(value)) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.MIN_LENGTH: {
					if (value.length < validation.minLength.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.MAX_LENGTH: {
					if (value.length > validation.maxLength.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.NORMAL_MIN: {
					if (validation.normalMin.boundary && value < validation.normalMin.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.WARNING
						};
					} else if (value <= validation.normalMin.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.WARNING
						};
					}

					break;
				}
				case ValidationKeys.NORMAL_MAX: {
					if (validation.normalMax.boundary && value > validation.normalMax.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.WARNING
						};
					} else if (value >= validation.normalMax.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.WARNING
						};
					}

					break;
				}
				case ValidationKeys.MIN: {
					if (validation.min.boundary && value < validation.min.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					} else if (value <= validation.min.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.MAX: {
					if (validation.max.boundary && value > validation.max.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					} else if (value >= validation.max.value) {
						return {
							message: Parameter.getValidationValue(validation, validationType, "message", languageId),
							errorClass: ErrorClass.ERROR
						};
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					return validation.custom(value);
				}
			}
		}

		return {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	#namespace;
	#formId;
	#paramType;
	#paramName = "";
	#paramVersion = "1.0.0";
	#displayName = {};
	#abstractKey = false;
	#searchable = true;
	#downloadable = true;
	#synonyms = "";
	#disabled = false;
	#definition = {};
	#tooltip = {};
	#order = 0;
	#defaultValue = null;
	#parent = null;
	#parameterId = 0;
	#standard = false;
	#status = 0;
	#state = 0;
	#active = true;
	#readOnly = false;
	#labelPosition = Parameter.LabelPosition.UPPER_LEFT;

	#validation = {};
	#renderImage = null;
	#pdf = null;

	#value;
	#error;

	#key = Util.randomKey();
	#dirty = false;

	constructor(namespace, formId, paramType) {
		this.#namespace = namespace;
		this.#formId = formId;
		this.#paramType = paramType;

		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const { targetPortlet, target, paramName, paramVersion, value } = e.dataPacket;

			if (
				targetPortlet !== this.#namespace ||
				target !== this.#formId ||
				paramName !== this.paramName ||
				paramVersion !== this.paramVersion
			) {
				return;
			}

			console.log(
				"StringParameter received SX_FIELD_VALUE_CHANGED: ",
				e.dataPacket,
				this,
				this.paramType,
				targetPortlet,
				target,
				paramName,
				paramVersion
			);

			this.value = value;
		});
	}

	get key() {
		return this.#key;
	}
	get namespace() {
		return this.#namespace;
	}
	get formId() {
		return this.#formId;
	}
	get paramType() {
		return this.#paramType;
	}
	get paramName() {
		return this.#paramName;
	}
	get paramVersion() {
		return this.#paramVersion;
	}
	get displayName() {
		return this.#displayName;
	}
	get abstractKey() {
		return this.#abstractKey;
	}
	get searchable() {
		return this.#searchable;
	}
	get downloadable() {
		return this.#downloadable;
	}
	get synonyms() {
		return this.#synonyms;
	}
	get required() {
		return (
			Util.isNotEmpty(this.validation) &&
			Util.isNotEmpty(this.validation.required) &&
			this.validation.required.value
		);
	}
	get requiredMessege() {
		if (Util.isNotEmpty(this.validation) && Util.isNotEmpty(this.validation.required)) {
			return this.validation.required.message ? this.validation.required.message : "";
		} else {
			return "";
		}
	}
	get disabled() {
		return this.#disabled;
	}
	get definition() {
		return this.#definition;
	}
	get tooltip() {
		return this.#tooltip;
	}
	get order() {
		return this.#order;
	}
	get defaultValue() {
		return this.#defaultValue;
	}
	get parent() {
		return this.#parent;
	}
	get parameterId() {
		return this.#parameterId;
	}
	get standard() {
		return this.#standard;
	}
	get status() {
		return this.#status;
	}
	get state() {
		return this.#state;
	}
	get renderImage() {
		return this.#renderImage;
	}
	get pdf() {
		return this.#pdf;
	}
	get validation() {
		return this.#validation;
	}
	get readOnly() {
		return this.#readOnly;
	}
	get active() {
		return this.#active;
	}
	get value() {
		return this.#value;
	}
	get error() {
		return this.#error;
	}
	get labelPosition() {
		return this.#labelPosition;
	}
	get dirty() {
		return this.#dirty;
	}

	set namespace(val) {
		this.#namespace = val;
	}
	set formId(val) {
		this.#formId = val;
	}
	set paramType(val) {
		this.#paramType = val;
	}
	set paramName(val) {
		this.#paramName = val;
	}
	set paramVersion(val) {
		this.#paramVersion = val;
	}
	set displayName(val) {
		this.#displayName = val;
	}
	set abstractKey(val) {
		this.#abstractKey = val;
	}
	set searchable(val) {
		this.#searchable = val;
	}
	set downloadable(val) {
		this.#downloadable = val;
	}
	set synonyms(val) {
		this.#synonyms = val;
	}
	set required(val) {
		if (!val && Util.isNotEmpty(this.#validation)) {
			delete this.#validation.required;
		} else if (!this.#validation) {
			this.validation = {
				required: {
					value: val
				}
			};
		} else {
			this.#validation.required = {
				value: val
			};
		}
	}

	set disabled(val) {
		this.#disabled = val;
	}
	set definition(val) {
		this.#definition = val;
	}
	set tooltip(val) {
		this.#tooltip = val;
	}
	set order(val) {
		this.#order = val;
	}
	set defaultValue(val) {
		this.#defaultValue = val;
	}
	set parent(val) {
		this.#parent = val;
	}
	set parameterId(val) {
		this.#parameterId = val;
	}
	set standard(val) {
		this.#standard = val;
	}
	set status(val) {
		this.#status = val;
	}
	set state(val) {
		this.#state = val;
	}
	set renderImage(val) {
		this.#renderImage = val;
	}
	set pdf(val) {
		this.#pdf = val;
	}
	set validation(val) {
		this.#validation = val;
	}
	set readOnly(val) {
		this.#readOnly = val;
	}
	set active(val) {
		this.#active = val;
	}
	set value(val) {
		this.#value = val;
	}
	set error(val) {
		this.#error = val;
	}
	set labelPosition(val) {
		this.#labelPosition = val;
	}
	set dirty(val) {
		this.#dirty = val;
	}

	setRequiredMessage(msg) {
		this.#validation.required.message = msg;
	}

	setParent(parentName, parentVersion) {
		this.parent = {
			name: parentName,
			version: parentVersion
		};
	}

	getDisplayName(languageId) {
		return this.displayName[languageId];
	}
	addDisplayName(languageId, translation) {
		this.displayName = Parameter.addLocalized(this.displayName, languageId, translation);
	}
	removeDisplayName(languageId) {
		this.displayName = Parameter.removeLocalized(this.displayName, languageId);
	}

	getDefinition(languageId) {
		return this.definition[languageId];
	}
	addDefinition(languageId, translation) {
		this.definition = Parameter.addLocalized(this.definition, languageId, translation);
	}
	removeDefinition(languageId) {
		this.definition = Parameter.removeLocalized(this.definition, languageId);
	}

	getTooltip(languageId) {
		return this.tooltip[languageId];
	}
	addTooltip(languageId, translation) {
		this.tooltip = Parameter.addLocalized(this.tooltip, languageId, translation);
	}
	removeTooltip(languageId) {
		this.tooltip = Parameter.removeLocalized(this.tooltip, languageId);
	}

	equalTo(name, version) {
		return name === this.paramName && version === this.paramVersion;
	}

	isMemberOf(assembly) {
		return assembly.name === this.parent.name && assembly.version === this.parent.version;
	}

	isAssembly() {
		return (
			this.paramType === ParamType.GROUP ||
			this.paramType === ParamType.GRID ||
			this.paramType === ParamType.SELECT_GROUP ||
			this.paramType === ParamType.TABLE
		);
	}

	hasValue() {
		return Util.isNotEmpty(this.value);
	}

	getValue() {
		return this.value;
	}

	setValue(value) {
		this.value = value;
	}

	hasError() {
		return Util.isNotEmpty(this.error);
	}

	setError(val) {
		this.error = val;
	}

	clearError() {
		this.error = "";
	}

	isRendered() {
		return !!this.renderImage;
	}

	isActive() {
		return !!this.active;
	}

	getOutput() {
		let out = {};

		if (this.hasValue()) {
			out[this.paramName] = this.value;
		}

		return out;
	}

	loadData(data) {
		this.value = data;
	}

	/**
	 *
	 * @param {*} event
	 */
	removeEvent(event, fire) {
		if (fire) {
			this.events.fire = this.events.fire.filter((e) => e !== event);
		} else {
			this.events.on = this.events.on.filter((e) => e !== event);
		}
	}

	validate(key = "") {}

	parse(json) {
		for (const key in json) {
			this[key] = json[key];
		}
	}

	toJSON() {
		let json = new Object();

		if (Util.isNotEmpty(this.paramType)) json.paramType = this.paramType;
		if (Util.isNotEmpty(this.paramName)) json.paramName = this.paramName;
		if (Util.isNotEmpty(this.paramVersion)) json.paramVersion = this.paramVersion;
		if (Util.isNotEmpty(this.displayName)) json.displayName = this.displayName;
		if (Util.isNotEmpty(this.definition)) json.definition = this.definition;
		if (Util.isNotEmpty(this.tooltip)) json.tooltip = this.tooltip;
		if (Util.isNotEmpty(this.synonyms)) json.synonyms = this.synonyms;
		if (Util.isNotEmpty(this.defaultValue)) json.defaultValue = this.defaultValue;
		if (Util.isNotEmpty(this.parent)) json.parent = this.parent;
		if (Util.isNotEmpty(this.validation)) json.validation = this.validation;
		if (Util.isNotEmpty(this.value)) json.value = this.value;
		if (this.readOnly) json.readOnly = this.readOnly;
		if (this.abstractKey) json.abstractKey = this.abstractKey;
		if (this.disabled) json.disabled = this.disabled;
		if (this.standard) json.standard = this.standard;
		if (!this.searchable) json.searchable = this.searchable;
		if (!this.downloadable) json.downloadable = this.downloadable;
		if (!this.active) json.active = this.active;
		if (this.order > 0) json.order = this.order;
		if (this.id > 0) json.id = this.id;
		if (this.status > 0) json.status = this.status;
		if (this.state > 0) json.state = this.state;

		return json;
	}

	toProperties(languageId) {
		return {
			key: this.key,
			paramType: this.paramType,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			parentId: this.parent,
			tagId: this.paramName,
			tagName: this.paramName,
			label: this.getDisplayName(languageId),
			labelPosition: this.labelPosition,
			required: this.required,
			disabled: this.disabled,
			tooltip: this.getTooltip(languageId),
			validation: this.validation,
			readOnly: this.readOnly,
			index: this.order,
			languageId: languageId
		};
	}
}

/**
 * 01. String
 * 		for <SXInput/> or <SXLocalizedInput/> if localized is true.
 */
export class StringParameter extends Parameter {
	#minLength = 1;
	#maxLength = 72;
	#multipleLine = false;
	#placeholder = {};

	constructor(namespace, formId, json) {
		super(namespace, formId, ParamType.STRING);

		if (Util.isNotEmpty(json)) {
			this.parse(json);
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = StringParameter.ViewTypes.REGULAR;
		}
	}

	get minLength() {
		return this.#minLength;
	}
	get maxLength() {
		return this.#maxLength;
	}
	get multipleLine() {
		return this.#multipleLine;
	}
	get placeholder() {
		return this.#placeholder;
	}

	set minLength(val) {
		this.#minLength = val;
	}
	set maxLength(val) {
		this.#maxLength = val;
	}
	set multipleLine(val) {
		this.#multipleLine = val;
	}
	set placeholder(val) {
		this.#placeholder = val;
	}

	getPlaceholder(languageId) {
		return this.placeholder[languageId];
	}

	parse(json) {
		super.parse(json);

		this.minLength = json.minLength ?? 1;
		this.maxLength = json.maxLength ?? 72;
		this.multipleLine = json.multipleLine ?? false;
		this.placeholder = json.placeholder ?? "";
	}

	toJSON() {
		let json = super.toJSON();

		if (this.minLength > 1) json.minLength = this.minLength;
		if (this.maxLength !== 72) json.maxLength = this.maxLength;
		if (this.mutilLine === true) json.multipleLine = this.multipleLine;
		if (Util.isNotEmpty(this.placeholder)) json.placeholder = this.placeholder;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.placeholder = this.getPlaceholder(languageId);
		json.multipleLine = this.multipleLine;
		json.value = this.hasValue() ? this.value : this.defaultValue;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;

		return json;
	}

	renderPreviewRow(
		namespace, //
		propertyPanelId,
		previewCanvasId,
		languageId,
		availableLanguageIds,
		tagId,
		tagName,
		events,
		className,
		style,
		spritemap
	) {
		if (!this.isRendered()) {
			const content = this.render(
				namespace,
				languageId,
				availableLanguageIds,
				tagId,
				tagName,
				events,
				className,
				style,
				spritemap
			);

			this.renderImage = (
				<SXPreviewRow
					propertyPanelId={propertyPanelId}
					previewCanvasId={previewCanvasId}
					content={content}
					spritemap={spritemap}
				/>
			);
		}

		return this.renderImage;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

export class LocalizedStringParameter extends StringParameter {
	constructor(namespace, formId, json) {
		super(namespace, formId, json);

		this.paramType = ParamType.LOCALIZED_STRING;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId, availableLanguageIds, tagId, tagName);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		return json;
	}
}

/**
 * 02. Numeric
 * 		for <SXNumeric/>
 */
export class NumericParameter extends Parameter {
	#decimalPlaces = 1;
	#uncertainty = false;
	#isInteger = false;
	#unit = "";

	constructor(namespace, formId, json) {
		super(namespace, formId, ParamType.NUMERIC);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}
	}

	get uncertainty() {
		return this.#uncertainty;
	}
	get decimalPlaces() {
		return this.#decimalPlaces;
	}
	get isInteger() {
		return this.#isInteger;
	}
	get unit() {
		return this.#unit;
	}

	set uncertainty(val) {
		this.#uncertainty = val;
	}
	set decimalPlaces(val) {
		this.#decimalPlaces = val;
	}
	set isInteger(val) {
		this.#isInteger = val;
	}
	set unit(val) {
		this.#unit = val;
	}

	hasValue() {
		if (this.uncertainty) {
			if (Util.isEmpty(this.value) || Util.isEmpty(this.value.value)) return false;
		} else {
			if (Util.isEmpty(this.value)) return false;
		}

		return true;
	}

	setValue(value, uncertainty) {
		const numVal = Number(value);
		const numUncertainty = Util.isEmpty(uncertainty) ? undefined : Number(uncertainty);

		this.value = this.uncertainty
			? {
					vakue: numVal,
					uncertainty: numUncertainty
			  }
			: (this.value = numVal);
	}

	parse(json) {
		super.parse(json);

		if (json.uncertainty) this.uncertainty = json.uncertainty;
		if (json.isInteger) {
			this.isInteger = json.isInteger;
			this.decimalPlaces = 0;
		} else if (json.decimalPlaces) {
			this.decimalPlaces = json.decimalPlaces;
		}
	}

	toJSON() {
		let json = super.toJSON();

		if (this.uncertainty === true) json.uncertainty = this.uncertainty;
		if (this.isInteger === true) json.isInteger = this.isInteger;
		if (this.decimalPlaces !== 2) json.decimalPlaces = this.decimalPlaces;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;
		json.value = this.defaultValue;
		if (Util.isNotEmpty(this.decimalPlaces)) {
			json.decimalPlaces = this.decimalPlaces;
		}

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 03. Select
 * 		for <SXSelectList/>
 * 			<SXRadioGroup/> if viewType is radio
 */
export class SelectParameter extends Parameter {
	static ViewTypes = {
		DROPDOWN: "dropdown",
		RADIO: "radio",
		CHECKBOX: "checkbox",
		LISTBOX: "listbox"
	};

	#options = [];
	#multiple = false;
	#optionsPerRow = 0;

	constructor(namespace, formId, json) {
		super(namespace, formId, ParamType.SELECT);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}
	}

	get options() {
		return this.#options;
	}
	get optionsPerRow() {
		return this.#optionsPerRow;
	}
	get multiple() {
		return this.#multiple;
	}

	set options(val) {
		this.#options = val;
	}
	set optionsPerRow(val) {
		this.#optionsPerRow = val;
	}
	set multiple(val) {
		this.#multiple = val;
	}

	parse(json) {
		super.parse(json);
		this.options = json.options ?? [];
		this.multiple = json.multiple ?? false;

		this.viewType = json.viewType ?? SelectParameter.ViewTypes.DROPDOWN;

		if (this.viewType === SelectParameter.ViewTypes.RADIO || this.viewType === SelectParameter.ViewTypes.CHECKBOX) {
			if (json.optionsPerRow > 0) {
				this.optionsPerRow = json.optionsPerRow;
			}
		}
	}

	toJSON() {
		let json = super.toJSON();

		json.viewType = this.viewType;
		if (Util.isNotEmpty(this.options)) json.options = this.options;
		if (this.multiple) json.multiple = this.multiple;

		if (this.viewType === SelectParameter.ViewTypes.RADIO || this.viewType === SelectParameter.ViewTypes.CHECKBOX) {
			if (this.optionsPerRow > 0) {
				json.optionsPerRow = this.optionsPerRow;
			}
		}

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.viewType = this.viewType;
		json.options = this.options;
		json.optionsPerRow = this.optionsPerRow;
		json.multiple = this.multiple;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 04. DualList
 *
 */
export class DualListParameter extends Parameter {
	static ViewTypes = {
		HORIZONTAL: "horizontal",
		VERTICAL: "vertical"
	};
	#rightOptions;

	constructor(namespace, formId, json) {
		super(namespace, formId, ParamType.DUALLIST);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = DualListParameter.ViewTypes.HORIZONTAL;
		}
	}

	get leftOptions() {
		return this.value;
	}
	get rightOptions() {
		return this.#rightOptions;
	}

	set leftOptions(val) {
		this.value = val;
	}
	set rightOptions(val) {
		this.#rightOptions = val;
	}

	addValue(val) {
		if (Util.isEmpty(this.value)) {
			this.value = new Array();
		}

		this.value.push(val);
	}

	removeValue(val) {
		if (Util.isEmpty(this.value)) {
			return;
		}

		this.value = this.value.filter((elem) => elem.value !== val);
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.viewType = this.viewType;
		json.leftOptions = this.leftOptions;
		json.rightOptions = this.rightOptions;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 06. Boolean
 *
 */
export class BooleanParameter extends SelectParameter {
	static ViewTypes = {
		CHECKBOX: "checkbox",
		TOGGLE: "toggle",
		RADIO: "radio",
		DROPDOWN: "dropdown"
	};

	constructor(namespace, formId, json) {
		super(namespace, formId, json);

		this.paramType = ParamType.BOOLEAN;

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = BooleanParameter.ViewTypes.CHECKBOX;
		}

		if (Util.isEmpty(this.options)) {
			this.options = [
				{
					label: {},
					value: false
				},
				{
					label: {},
					value: true
				}
			];
		}
	}

	get trueOption() {
		return this.options[1];
	}
	get trueLabel() {
		return this.trueOption.label;
	}
	get falseOption() {
		return this.options[0];
	}
	get falseLabel() {
		return this.falseOption.label;
	}

	set trueOption(option) {
		this.options[1] = option;
	}
	set trueLabel(label) {
		this.trueOption.label = label;
	}
	set falseOption(option) {
		this.options[0] = option;
	}
	set falseLabel(label) {
		this.falseOption.label = label;
	}

	getTrueLabel(availableLanguageIds) {
		if (Util.isEmpty(this.trueLabel)) {
			let label = {};
			availableLanguageIds.forEach((locale) => {
				label[locale] = Util.translate("yes");
			});
			this.trueLabel = label;
		}

		return this.trueLabel;
	}

	getFalseLabel(availableLanguageIds) {
		if (Util.isEmpty(this.falseLabel)) {
			let label = {};
			availableLanguageIds.forEach((locale) => {
				label[locale] = Util.translate("no");
			});
			this.falseLabel = label;
		}

		return this.falseLabel;
	}

	setValue(val) {
		this.value = Util.isEmpty(val) ? undefined : Boolean(val);
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let properties = super.toProperties(languageId, availableLanguageIds, tagId, tagName);

		properties.trueLabel = this.getTrueLabel(availableLanguageIds)[languageId];
		properties.falseLabel = this.getFalseLabel(availableLanguageIds)[languageId];

		properties.value = this.value ?? !!this.defaultValue;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 07. Matrix
 *
 */
export class MatrixParameter extends Parameter {
	#rowCount = 3;
	#colCount = 3;
	#delimiter = " ";
	#bracket = "[]";

	constructor(json) {
		super(BooleanParameter);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}
	}

	get rowCount() {
		return this.#rowCount;
	}
	get colCount() {
		return this.#colCount;
	}
	get bracket() {
		return this.#bracket;
	}
	get delimiter() {
		return this.#delimiter;
	}

	set rowCount(val) {
		this.#rowCount = val;
	}
	set colCount(val) {
		this.#colCount = val;
	}
	set bracket(val) {
		this.#bracket = val;
	}
	set delimiter(val) {
		this.#delimiter = val;
	}

	parse(json) {
		super.parse(json);

		this.rowCount = json.rowCount;
		this.colCount = json.colCount;
		this.bracket = json.bracket ?? "[]";
		this.delimiter = json.delimiter ?? " ";
	}

	toJSON() {
		let json = super.toJSON();

		json.rowCount = this.rowCount;
		json.colCount = this.colCount;

		if (this.bracket !== "[]") json.bracket = this.bracket;
		if (this.delimiter != " ") json.delimiter = this.delimiter;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let properties = super.toProperties(languageId);

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		properties.rowCount = this.rowCount;
		properties.colCount = this.colCount;
		properties.bracket = this.bracket ?? "[]";
		properties.delimiter = this.delimiter ?? " ";

		return properties;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 08. File
 *
 */
export class FileParameter extends Parameter {
	constructor(json) {
		super(ParamType.FILE);

		if (json) {
			this.parse(json);
		}
	}

	get files() {
		return this.value;
	}

	set files(val) {
		this.value = val;
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 09. Address
 *
 */
export class AddressParameter extends Parameter {
	constructor(json) {
		super(ParamType.ADDRESS);

		if (json) {
			this.parse(json);
		}

		this.value = {};
	}

	get zipcode() {
		return this.value.zipcode;
	}
	get street() {
		return this.value.street;
	}
	get address() {
		return this.value.address;
	}

	set zipcode(val) {
		this.value = { ...this.value, zipcode: val };
	}
	set street(val) {
		this.value = { ...this.value, street: val };
	}
	set address(val) {
		this.value = { ...this.value, address: val };
	}

	getFullAddress() {
		return this.zipcode + ", " + this.street + ", " + this.address;
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 10. Date
 *
 */
export class DateParameter extends Parameter {
	#enableTime = false;

	constructor(json) {
		super(ParamType.DATE);

		if (json) {
			this.parse(json);
		}
	}

	get date() {
		return new Date(this.value);
	}
	get enableTime() {
		return this.#enableTime;
	}

	set date(val) {
		this.value = val.getTime();
	}
	set enableTime(val) {
		this.#enableTime = val;
	}

	parse(json) {
		super.parse(json);

		this.enableTime = json.enableTime ?? false;
	}

	toJSON() {
		let json = super.toJSON();

		if (this.enableTime) json.enableTime = this.enableTime;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		json.enableTime = this.enableTime;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 11. Phone
 *
 */
export class PhoneParameter extends Parameter {
	#enableCountryNo = false;

	constructor(json) {
		super(ParamType.PHONE);

		if (json) {
			this.parse(json);
		}
	}

	get countryNo() {
		return this.value.countryNo;
	}
	get areaNo() {
		return this.value.areaNo;
	}
	get stationNo() {
		return this.value.stationNo;
	}
	get personalNo() {
		return this.value.personalNo;
	}
	get enableCountryNo() {
		return this.#enableCountryNo;
	}

	set countryNo(val) {
		this.value = { ...this.value, countryNo: val };
	}
	set areaNo(val) {
		this.value = { ...this.value, areaNo: val };
	}
	set stationNo(val) {
		this.value = { ...this.value, stationNo: val };
	}
	set personalNo(val) {
		this.value = { ...this.value, personalNo: val };
	}
	set enableCountryNo(val) {
		this.#enableCountryNo = val;
	}

	parse(json) {
		super.parse(json);

		this.enableCountryNo = json.enableCountryNo ?? "";
	}

	toJSON() {
		let json = super.toJSON();

		if (this.enableCountryNo) json.enableCountryNo = this.enableCountryNo;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		json.enableCountryNo = this.enableCountryNo;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 12. EMail
 *
 */
export class EMailParameter extends Parameter {
	static serverList = ["gmail.com", "daum.net", "naver.com"];

	constructor(json) {
		super(json);

		if (json) {
			this.parse(json);
		}
	}

	get emailId() {
		return this.value.emailId;
	}
	get serverName() {
		return this.value.serverName;
	}

	set emailId(val) {
		this.value = { ...this.value, emailId: val };
	}
	set serverName(val) {
		this.value = { ...this.value, serverName: val };
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 13. Group
 *
 */
export class GroupParameter extends Parameter {
	static ViewTypes = {
		HORIZONTAL: "horizontal",
		HORIZONTAL_LIST: "horizontalList",
		HORIZONTAL_PANEL: "horizontalPanel",
		VERTICAL: "vertical",
		VERTICAL_LIST: "verticalList",
		VERTICAL_PANEL: "verticalPanel"
	};

	#members = [];
	#decorative = false;
	#membersPerRow = 1;

	constructor(json) {
		super(ParamType.GROUP);

		if (json) {
			this.parse(json);
		}
	}

	get members() {
		return this.#members;
	}
	get decorative() {
		return this.#decorative;
	}
	get membersPerRow() {
		return this.#membersPerRow;
	}

	set members(val) {
		this.#members = val;
	}
	set decorative(val) {
		this.#decorative = val;
	}
	set membersPerRow(val) {
		this.#membersPerRow = val;
	}

	addMember(member) {
		if (member.order < 1) {
			member.order = this.members.length + 1;
		}

		this.members.push(member);
	}

	removeMember(name, version) {
		let removed;

		this.members = this.members.filter((member) => {
			if (member.equalTo(name, version)) {
				removed = member;
				return Constant.FILTER_SKIP;
			} else if (member.paramType === ParamType.GROUP) {
				removed = member.removeMember();
				if (removed) {
					return Constant.FILTER_SKIP;
				}
			}

			return Constant.FILTER_ADD;
		});

		return removed;
	}

	getOutput() {
		let output = {};
		this.members.forEach((member) => {
			output = { ...output, ...member.getOutput() };
		});

		if (this.decorative) {
			return output;
		} else {
			let groupOutput = {};
			groupOutput[this.paramName] = output;

			return groupOutput;
		}
	}

	loadData(data) {
		this.members.forEach((member) => {
			const value = data[member.paramName];
			if (Util.isNotEmpty(vaue)) {
				member.loadData(values);
			}
		});
	}

	parse(json) {
		super.parse(json);

		this.viewType = this.viewType ?? GroupParameter.ViewTypes.HORIZONTAL_LIST;
		this.decorative = json.decorative ?? false;
		this.membersPerRow = json.membersPerRow ?? 1;

		if (Util.isNotEmpty(json.members)) {
			this.members = json.members.map((member) => {
				return Parameter.createParameter(member.paramType, member);
			});
		}
	}

	toJSON() {
		let json = super.toJSON();

		if (this.viewType !== GroupParameter.ViewTypes.VERTICAL_PANEL) json.viewType = this.viewType;
		if (this.decorative === true) json.decorative = this.decorative;
		if (this.membersPerRow > 1) json.membersPerRow = this.membersPerRow;

		let jsonMembers = [];
		this.members.forEach((member) => {
			jsonMembers.push(member.toJSON());
		});

		json.members = jsonMembers;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.viewType = this.viewType;
		json.decorative = this.decorative;
		json.fieldsPerRow = this.membersPerRow;
		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		json.tagId = tagId;
		json.tagName = tagName;

		json.members = this.members.map((member) =>
			member.toProperties(languageId, availableLanguageIds, tagId, tagName)
		);

		return json;
	}

	render(
		namespace, //
		languageId,
		availableLanguageIds,
		tagId,
		tagName,
		events,
		className,
		style,
		spritemap
	) {
		const properties = this.toProperties(
			languageId, //
			availableLanguageIds,
			tagId,
			tagName
		);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}

/**
 * 14. SelectGroup
 *
 */
export class SelectGroupParameter extends Parameter {
	#children;

	constructor(json) {
		super(json);
	}

	get children() {
		return this.#children;
	}

	set children(val) {
		this.#children = val;
	}

	parse() {}

	toJSON() {}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.languageId = languageId;
		json.availableLanguageIds = availableLanguageIds;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				key={this.key}
				namespace={namespace}
				properties={properties}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);

		return this.renderImage;
	}
}
