import React from "react";
import { Constant, ViewTypes, ParamType } from "../common/station-x";
import { Util } from "../common/util";
import SXFormField, { SXInput, SXLocalizedInput } from "../form/sxform";

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

	static createParameter(paramType, json) {
		switch (paramType) {
			case ParamType.STRING: {
				return new StringParameter(json);
			}
			case ParamType.NUMERIC: {
				return new NumericParameter(json);
			}
			case ParamType.BOOLEAN: {
				return new BooleanParameter(json);
			}
			case ParamType.SELECT: {
				return new SelectParameter(json);
			}
			case ParamType.DUALLIST: {
				return new DualListParameter(json);
			}
			case ParamType.MATRIX: {
				return new MatrixParameter(json);
			}
			case ParamType.FILE: {
				return new FileParameter(json);
			}
			case ParamType.ADDRESS: {
				return new AddressParameter(json);
			}
			case ParamType.DATE: {
				return new DateParameter(json);
			}
			case ParamType.PHONE: {
				return new PhoneParameter(json);
			}
			case ParamType.GROUP: {
				return new GroupParameter(json);
			}
			case ParamType.SELECT_GROUP: {
				return new SelectGroupParameter(json);
			}
			/*
			case ParamType.GRID: {
				return new GridParameter(json);
			}
			case ParamType.TABLE: {
				return new TableParameter(json);
			}
			case ParamType.CALCULATOR: {
				return new CalculatorParameter(json);
			}
			case ParamType.REFERENCE: {
				return new ReferenceParameter(json);
			}
			case ParamType.LINKER: {
				return new LinkerParameter(json);
			}
			case ParamType.IMAGE: {
				return new ImageParameter(json);
			}
			case ParamType.COMMENT: {
				return new CommentParameter(json);
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

	#paramType;
	#paramName = "";
	#paramVersion = "1.0.0";
	#displayName = {};
	#abstractKey = false;
	#searchable = true;
	#downloadable = true;
	#synonyms = "";
	#required = false;
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
	#namespace;

	#value;
	#error;

	constructor(paramType) {
		this.#paramType = paramType;
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
		return this.#required;
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
		this.#required = val;
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

		if (this.defaultValue && !this.hasValue()) {
			this.value = this.defaultValue;
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
		if (Util.isNotEmpty(this.validation)) json.validation = this.validation;
		if (this.readOnly) json.readOnly = this.readOnly;
		if (this.abstractKey) json.abstractKey = this.abstractKey;
		if (this.required) json.required = this.required;
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
			initValue: this.hasValue() ? this.value : this.defaultValue,
			validation: this.validation,
			readOnly: this.readOnly
		};
	}
}

/**
 * 01. String
 * 		for <SXInput/> or <SXLocalizedInput/> if localized is true.
 */
export class StringParameter extends Parameter {
	#localized = false;
	#minLength = 1;
	#maxLength = 72;
	#multiLine = false;
	#placeholder = {};

	constructor(json) {
		super(ParamType.STRING);

		if (Util.isNotEmpty(json)) {
			this.parse(json);
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = StringParameter.ViewTypes.REGULAR;
		}
	}

	get localized() {
		return this.#localized;
	}
	get minLength() {
		return this.#minLength;
	}
	get maxLength() {
		return this.#maxLength;
	}
	get multiLine() {
		return this.#multiLine;
	}
	get placeholder() {
		return this.#placeholder;
	}

	set localized(val) {
		this.#localized = val;
	}
	set minLength(val) {
		this.#minLength = val;
	}
	set maxLength(val) {
		this.#maxLength = val;
	}
	set multiLine(val) {
		this.#multiLine = val;
	}
	set placeholder(val) {
		this.#placeholder = val;
	}

	getPlaceholder(languageId) {
		return this.placeholder[languageId];
	}

	parse(json) {
		super.parse(json);

		this.localized = json.localized ?? false;
		this.minLength = json.minLength ?? 1;
		this.maxLength = json.maxLength ?? 72;
		this.multiLine = json.multiLine ?? false;
		this.placeholder = json.placeholder ?? "";
	}

	toJSON() {
		let json = super.toJSON();

		if (this.localized === true) json.localized = this.localized;
		if (this.minLength > 1) json.minLength = this.minLength;
		if (this.maxLength !== 72) json.maxLength = this.maxLength;
		if (this.mutilLine === true) json.multiLine = this.multiLine;
		if (Util.isNotEmpty(this.placeholder)) json.placeholder = this.placeholder;

		return json;
	}

	toProperties(languageId, availableLanguageIds, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.localized = this.localized;
		json.placeholder = this.getPlaceholder(languageId);
		json.multiLine = this.multiLine;
		json.initValue = this.hasValue() ? this.value : this.defaultValue;

		if (this.localized) {
			json.languageId = languageId;
			json.availableLanguageIds = availableLanguageIds;
		}

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, availableLanguageIds, tagId, tagName);

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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
 * 02. Numeric
 * 		for <SXNumeric/>
 */
export class NumericParameter extends Parameter {
	#min = null;
	#max = null;
	#validMin;
	#validMax;
	#uncertainty = false;
	#validMinBoundary = false;
	#validMaxBoundary = false;
	#minBoundary = false;
	#maxBoundary = false;
	#isInteger = false;

	constructor(json) {
		super(ParamType.NUMERIC);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}
	}

	get min() {
		return this.#min;
	}
	get max() {
		return this.#max;
	}
	get validMin() {
		return this.#validMin;
	}
	get validMax() {
		return this.#validMax;
	}
	get uncertainty() {
		return this.#uncertainty;
	}
	get minBoundary() {
		return this.#minBoundary;
	}
	get maxBoundary() {
		return this.#maxBoundary;
	}
	get validMinBoundary() {
		return this.#validMinBoundary;
	}
	get validMaxBoundary() {
		return this.#validMaxBoundary;
	}
	get isInteger() {
		return this.#isInteger;
	}

	set min(val) {
		this.#min = val;
	}
	set max(val) {
		this.#max = val;
	}
	set validMin(val) {
		this.#validMin = val;
	}
	set validMax(val) {
		this.#validMax = val;
	}
	set uncertainty(val) {
		this.#uncertainty = val;
	}
	set minBoundary(val) {
		this.#minBoundary = val;
	}
	set maxBoundary(val) {
		this.#maxBoundary = val;
	}
	set validMinBoundary(val) {
		this.#validMinBoundary = val;
	}
	set validMaxBoundary(val) {
		this.#validMaxBoundary = val;
	}
	set isInteger(val) {
		this.#isInteger = val;
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

		if (Util.isNotEmpty(json.min)) this.min = json.min;
		if (Util.isNotEmpty(json.max)) this.max = json.max;
		if (Util.isNotEmpty(json.validMin)) this.validMin = json.validMin;
		if (Util.isNotEmpty(json.validMax)) this.validMax = json.validMax;
		if (Util.isNotEmpty(json.minBoundary)) this.minBoundary = json.minBoundary;
		if (Util.isNotEmpty(json.maxBoundary)) this.maxBoundary = json.maxBoundary;
		if (Util.isNotEmpty(json.validMinBoundary)) this.validMinBoundary = json.validMinBoundary;
		if (Util.isNotEmpty(json.validMaxBoundary)) this.validMaxBoundary = json.validMaxBoundary;
		if (Util.isNotEmpty(json.uncertainty)) this.uncertainty = json.uncertainty;
		if (json.isInteger === true) this.isInteger = json.isInteger;
	}

	toJSON() {
		let json = super.toJSON();

		if (Util.isNotEmpty(this.min)) json.min = this.min;
		if (Util.isNotEmpty(this.max)) json.max = this.max;
		if (Util.isNotEmpty(this.validMin)) json.validMin = this.validMin;
		if (Util.isNotEmpty(this.validMax)) json.validMax = this.validMax;
		if (this.minBoundary === true) json.minBoundary = this.minBoundary;
		if (this.maxBoundary === true) json.maxBoundary = this.maxBoundary;
		if (this.validMinBoundary === true) json.validMinBoundary = this.validMinBoundary;
		if (this.validMaxBoundary === true) json.validMaxBoundary = this.validMaxBoundary;
		if (this.uncertainty === true) json.uncertainty = this.uncertainty;
		if (this.isInteger === true) json.isInteger = this.isInteger;

		return json;
	}

	toProperties(languageId, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.min = this.min;
		json.max = this.max;
		json.minBoundary = this.minBoundary;
		json.maxBoundary = this.maxBoundary;
		json.validMin = this.validMin;
		json.validMax = this.validMax;
		json.validMinBoundary = this.validMinBoundary;
		json.validMaxBoundary = this.validMaxBoundary;
		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;
		json.initValue = this.defaultValue;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, tagId, tagName);

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	constructor(json) {
		super(ParamType.SELECT);

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

	toProperties(languageId, tagId, tagName) {
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
		const properties = this.toProperties(languageId, tagId, tagName);

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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
	#rightOptions;

	constructor(json) {
		super(ParamType.DUALLIST);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = "checkbox";
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

	toProperties(languageId) {
		let json = super.toProperties(languageId);

		return json;
	}

	toProperties(languageId, tagId, tagName) {
		let json = super.toProperties(languageId);

		json.viewType = this.viewType;
		json.leftOptions = this.leftOptions;
		json.rightOptions = this.rightOptions;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, tagId, tagName);

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	constructor(json) {
		super(json);

		this.paramType = ParamType.BOOLEAN;

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = BooleanParameter.ViewTypes.CHECKBOX;
		}
	}

	get trueLabel() {
		return this.options[1];
	}
	get falseLabel() {
		return this.options[0];
	}

	set trueLabel(val) {
		this.options[1] = val;
	}
	set falseLabel(val) {
		this.options[0] = val;
	}

	getTrueLabel(languageId) {
		return this.option[1][languageId];
	}

	getFalseLabel(languageId) {
		return this.option[0][languageId];
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

	toProperties(languageId) {
		return super.toProperties(languageId);
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId, tagId, tagName) {
		let properties = super.toProperties(languageId);

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		properties.rowCount = json.rowCount;
		properties.colCount = json.colCount;
		properties.bracket = json.bracket ?? "[]";
		properties.delimiter = json.delimiter ?? " ";

		return properties;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId, tagId, tagName);

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId) {
		return super.toProperties(languageId);
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId) {
		return super.toProperties(languageId);
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId) {
		let json = super.toProperties(languageId);

		json.enableTime = this.enableTime;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId) {
		let json = super.toProperties(languageId);

		json.enableCountryNo = this.enableCountryNo;

		return json;
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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

	toProperties(languageId) {
		return super.toProperties(languageId);
	}

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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
		let jsonMembers = [];
		this.members.forEach((member) => {
			jsonMembers.push(member.toProperties(languageId));
		});

		json.members = this.members.map((member) => member.toProperties(languageId));

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
				namespace={namespace}
				key={this.paramName}
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

	render(namespace, languageId, availableLanguageIds, tagId, tagName, events, className, style, spritemap) {
		const properties = this.toProperties(languageId);
		properties.languageId = languageId;
		properties.availableLanguageIds = availableLanguageIds;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		this.renderImage = (
			<SXFormField
				namespace={namespace}
				key={this.paramName}
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
