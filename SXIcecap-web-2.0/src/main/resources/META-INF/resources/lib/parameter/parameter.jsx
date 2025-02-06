import React from "react";
import { Constant, DisplayType, ParamType } from "../common/station-x";
import { Util } from "../common/util";
import SXFormField, { SXInput, SXLocalizedInput } from "../form/sxform";

export class Parameter {
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
	#synonyms = [];
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

	#parameterRef = null;
	#pdf = null;

	#validation = {};
	#displayType = DisplayType.NORMAL;
	#events = {
		fire: [],
		on: []
	};

	#value;

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
	get parameterRef() {
		return this.#parameterRef;
	}
	get pdf() {
		return this.#pdf;
	}
	get validation() {
		return this.#validation;
	}
	get displayType() {
		return this.#displayType;
	}
	get active() {
		return this.#active;
	}
	get value() {
		return this.#value;
	}
	get events() {
		return this.#events;
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
	set parameterRef(val) {
		this.#parameterRef = val;
	}
	set pdf(val) {
		this.#pdf = val;
	}
	set validation(val) {
		this.#validation = val;
	}
	set displayType(val) {
		this.#displayType = val;
	}
	set active(val) {
		this.#active = val;
	}
	set value(val) {
		this.#value = val;
	}
	set events(val) {
		this.#events = val;
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

	addEvent(event, fire) {
		if (fire) {
			this.events.fire.push(event);
		} else {
			this.events.on.push(event);
		}
	}

	equalTo(name, version) {
		return name === this.paramName && version === this.paramVersion;
	}

	isMemberOf(name, version) {
		return name === this.parent.name && version === this.parent.version;
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

	parse(json) {
		for (const key in json) {
			this[key] = json[key];
		}
	}

	toJSON() {
		return {
			paramType: this.paramType,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			displayName: this.displayName,
			abstractKey: this.abstractKey,
			searchable: this.searchable,
			downloadable: this.downloadable,
			synonyms: this.synonyms,
			required: this.required,
			disabled: this.disabled,
			definition: this.definition,
			tooltip: this.tooltip,
			order: this.order,
			defaultValue: this.defaultValue,
			parent: this.parent,
			parameterId: this.parameterId,
			active: this.active,
			standard: this.standard,
			status: this.status,
			state: this.state,
			parameterRef: this.parameterRef,
			pdf: this.pdf,
			validation: this.validation,
			displayType: this.displayType
		};
	}

	toProperties(languageId) {
		return {
			paramType: this.paramType,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			displayName: this.getDisplayName(languageId),
			abstractKey: this.abstractKey,
			searchable: this.searchable,
			downloadable: this.downloadable,
			synonyms: this.synonyms,
			required: this.required,
			disabled: this.disabled,
			definition: this.getDefinition(languageId),
			tooltip: this.getTooltip(languageId),
			order: this.order,
			defaultValue: this.defaultValue,
			parent: this.parent,
			parameterId: this.parameterId,
			active: this.active,
			standard: this.standard,
			status: this.status,
			state: this.state,
			parameterRef: this.parameterRef,
			pdf: this.pdf,
			validation: this.validation,
			displayType: this.displayType
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

	constructor(json) {
		super(ParamType.STRING);

		if (!Util.isEmpty(json)) {
			this.parse(json);
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

	getValue() {
		return this.value;
	}

	setValue(value) {
		this.value = value;
	}

	hasValue() {
		return !Util.isEmpty(this.value);
	}

	parse(json) {
		super.parse(json);

		this.localized = json.localized;
		this.minLength = json.minLength;
		this.maxLength = json.maxLength;
		this.multiLine = json.multiLine;
	}

	toJSON() {
		let json = super.toJSON();

		json.localized = this.localized;
		json.minLength = this.minLength;
		json.maxLength = this.maxLength;
		json.multiLine = this.multiLine;

		return json;
	}

	tpProperties(languageId) {
		let json = super.toProperties(languageId);

		json.localized = this.localized;
		json.minLength = this.minLength;
		json.maxLength = this.maxLength;
		json.multiLine = this.multiLine;
		json.value = this.value;

		return json;
	}

	render(namespace, formId, languageId, tagId, tagName, className, style, spritemap) {
		return (
			<SXFormField
				namespace={namespace}
				formId={formId}
				properties={{
					...this.toProperties(),
					tagId: tagId ?? this.paramName,
					tagName: tagName ?? this.paramName,
					label: this.getDisplayName(languageId)
				}}
				className={className}
				style={style}
				spritemap={spritemap}
			/>
		);
	}
}

/**
 * 02. Numeric
 * 		for <SXNumeric/>
 */
export class NumericParameter extends Parameter {
	#min;
	#max;
	#uncertainty = false;
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
	get uncertainty() {
		return this.#uncertainty;
	}
	get minBoundary() {
		return this.#minBoundary;
	}
	get maxBoundary() {
		return this.#maxBoundary;
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
	set uncertainty(val) {
		this.#uncertainty = val;
	}
	set minBoundary(val) {
		this.#minBoundary = val;
	}
	set maxBoundary(val) {
		this.#maxBoundary = val;
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

		this.min = json.min;
		this.max = json.max;
		this.minBoundary = json.minBoundary;
		this.maxBoundary = json.maxBoundary;
		this.uncertainty = json.uncertainty;
		this.isInteger = json.isInteger;
	}

	toJSON() {
		let json = super.toJSON();

		json.min = this.min;
		json.max = this.max;
		json.minBoundary = this.minBoundary;
		json.maxBoundary = this.maxBoundary;
		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;

		return json;
	}

	render() {}
}

/**
 * 03. Select
 * 		for <SXSelectList/>
 * 			<SXRadioGroup/> if viewType is radio
 */
export class SelectParameter extends Parameter {
	#viewType = "dropdown";
	#options = {};
	#multiple = false;

	constructor(json) {
		super(ParamType.SELECT);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}
	}

	get viewType() {
		return this.#viewType;
	}
	get options() {
		return this.#options;
	}
	get multiple() {
		return this.#multiple;
	}

	set viewType(val) {
		this.#viewType = val;
	}
	set options(val) {
		this.#options = val;
	}
	set multiple(val) {
		this.#multiple = val;
	}

	hasValue() {
		return !Util.isEmpty(this.value);
	}

	parse(json) {
		super.parse(json);
		this.viewType = json.viewType;
		this.options = json.options;
		this.multiple = json.multiple;
	}

	toJSON() {
		let json = super.toJSON();

		json.viewType = this.viewType;
		json.options = this.options;
		json.multiple = this.multiple;

		return json;
	}

	render() {}
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
		this.rightOptions = val;
	}

	hasValue() {
		return !Util.isEmpty(this.value);
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

	render() {}
}

/**
 * 06. Boolean
 *
 */
export class BooleanParameter extends SelectParameter {
	#trueLabel = {};
	#falseLabel = {};

	constructor(json) {
		super(BooleanParameter);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = "radio";
		}
	}

	get trueLabel() {
		return this.#trueLabel;
	}
	get falseLabel() {
		return this.#falseLabel;
	}

	set trueLabel(val) {
		this.#trueLabel = val;
	}
	set falseLabel(val) {
		this.#falseLabel = val;
	}

	hasValue() {
		return !Util.isEmpty(this.value);
	}

	setValue(val) {
		this.value = Util.isEmpty(val) ? undefined : Boolean(val);
	}

	parse(json) {
		super.parse(json);

		this.trueLabel = json.trueLabel;
		this.falseLabel = json.falseLabel;
	}

	toJSON() {
		let json = super.toJSON();

		json.trueLabel = this.trueLabel;
		json.falseLabel = this.falseLabel;

		return json;
	}

	render() {}
}

/**
 * 07. Matrix
 *
 */
export class MatrixParameter extends Parameter {
	#rowCount = 3;
	#colCount = 3;
	#delimiter = " ";
	#bracket = "[";

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
		this.bracket = json.bracket;
		this.delimiter = json.delimiter;
	}

	toJSON() {
		let json = super.toJSON();

		json.rowCount = this.rowCount;
		json.colCount = this.colCount;
		json.bracket = this.bracket;
		json.delimiter = this.delimiter;

		return json;
	}

	render() {}
}

/**
 * 08. File
 *
 */
export class FileParameter extends Parameter {
	#files;

	constructor(json) {
		super(json);
	}

	get files() {
		return this.#files;
	}

	set files(val) {
		this.#files = val;
	}

	parse() {}

	toJSON() {}

	render() {}
}

/**
 * 09. Address
 *
 */
export class AddressParameter extends Parameter {
	#zipcode;
	#street;
	#address;

	constructor(json) {
		super(json);
	}

	get zipcode() {
		return this.#zipcode;
	}
	get street() {
		return this.#street;
	}
	get address() {
		return this.#address;
	}

	set zipcode(val) {
		this.#zipcode = val;
	}
	set street(val) {
		this.#street = val;
	}
	set address(val) {
		this.#address = val;
	}

	parse() {}

	toJSON() {}

	render() {}
}

/**
 * 10. Date
 *
 */
export class DateParameter extends Parameter {
	#date;
	#enableTime = true;

	constructor(json) {
		super(json);
	}

	get date() {
		return this.#date;
	}
	get enableTime() {
		return this.#enableTime;
	}

	set date(val) {
		this.#date = val;
	}
	set enableTime(val) {
		this.#enableTime = val;
	}

	parse() {}

	toJSON() {}

	render() {}
}

/**
 * 11. Phone
 *
 */
export class PhoneParameter extends Parameter {
	#countryNo;
	#areaNo;
	#stationNo;
	#personalNo;
	#enableCountryNo;

	constructor(json) {
		super(json);
	}

	get countryNo() {
		return this.#countryNo;
	}
	get areaNo() {
		return this.#areaNo;
	}
	get stationNo() {
		return this.#stationNo;
	}
	get personalNo() {
		return this.#personalNo;
	}
	get enableCountryNo() {
		return this.#enableCountryNo;
	}

	set countryNo(val) {
		this.#countryNo = val;
	}
	set areaNo(val) {
		this.#areaNo = val;
	}
	set stationNo(val) {
		this.#stationNo = val;
	}
	set personalNo(val) {
		this.#personalNo = val;
	}
	set enableCountryNo(val) {
		this.#enableCountryNo = val;
	}

	parse() {}

	toJSON() {}

	render() {}
}

/**
 * 12. EMail
 *
 */
export class EMailParameter extends Parameter {
	#emailId;
	#serverName;
	#serverList = ["gmail.com", "daum.net", "naver.com"];

	constructor(json) {
		super(json);
	}

	get emailId() {
		return this.#emailId;
	}
	get serverName() {
		return this.#serverName;
	}

	set emailId(val) {
		this.#emailId = val;
	}
	set serverName(val) {
		this.#serverName = val;
	}

	parse() {}

	toJSON() {}

	render() {}
}

/**
 * 13. Group
 *
 */
export class GroupParameter extends Parameter {
	static ViewTypes = {
		HORIZONTAL_LIST: "horizontalList",
		HORIZONTAL_PANEL: "horizontalPanel",
		VERTICAL_LIST: "verticalList",
		VERTICAL_PANEL: "verticalPanel"
	};

	#members = [];
	#viewType = GroupParameter.ViewTypes.VERTICAL_PANEL;

	constructor(json) {
		super(ParamType.GROUP);

		if (json) {
			this.parse(json);
		}
	}

	get members() {
		return this.#members;
	}
	get viewType() {
		return this.#viewType;
	}

	set members(val) {
		this.#members = val;
	}
	set viewType(val) {
		this.#viewType = val;
	}

	addMember(member) {
		if (!member.order) {
			member.order = this.member.length;
		}

		this.members[member.order] = member;
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

	parse(json) {
		super.parse(json);

		this.viewType = json.viewType;

		if (!Util.isEmpty(json.members)) {
			json.members.forEach((member) => {
				this.addMember(Parameter.createParameter(member.paramType, member));
			});
		}
	}

	toJSON() {
		let json = super.toJSON();

		if (!Util.isEmpty(this.members)) {
		}
	}

	render() {}
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

	render() {}
}
