import React from "react";
import { Constant, ParamType, ValidationKeys, ErrorClass, Event } from "../common/station-x";
import { Util } from "../common/util";
import SXFormField, {
	SXAddress,
	SXBoolean,
	SXDate,
	SXDualListBox,
	SXEMail,
	SXFile,
	SXGroup,
	SXInput,
	SXLabel,
	SXLocalizedInput,
	SXMatrix,
	SXNumeric,
	SXPhone,
	SXPreviewRow,
	SXRequiredMark,
	SXSelect,
	SXSelectGroup,
	SXTooltip
} from "../form/sxform";
import { ClayInput } from "@clayui/form";

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
	static DisplayTypes = {
		FORM_FIELD: "formField",
		INLINE: "inline",
		TABLE_CELL: "tableCell",
		GRID_CELL: "gridCell"
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

	static createParameter(namespace, formId, languageId, availableLanguageIds, paramType, json) {
		switch (paramType) {
			case ParamType.STRING: {
				return new StringParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.LOCALIZED_STRING: {
				return new LocalizedStringParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.NUMERIC: {
				return new NumericParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.BOOLEAN: {
				return new BooleanParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.SELECT: {
				return new SelectParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.DUALLIST: {
				return new DualListParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.MATRIX: {
				return new MatrixParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.FILE: {
				return new FileParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.ADDRESS: {
				return new AddressParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.EMAIL: {
				return new EMailParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.DATE: {
				return new DateParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.PHONE: {
				return new PhoneParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.GROUP: {
				return new GroupParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.SELECT_GROUP: {
				return new SelectGroupParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			/*
			case ParamType.GRID: {
				return new GridParameter(namespace, formId, languageId, availableLanguageIds, json);
				}
			case ParamType.TABLE: {
				return new TableParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.CALCULATOR: {
				return new CalculatorParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.REFERENCE: {
				return new ReferenceParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.LINKER: {
				return new LinkerParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.IMAGE: {
				return new ImageParameter(namespace, formId, languageId, availableLanguageIds, json);
			}
			case ParamType.COMMENT: {
				return new CommentParameter(namespace, formId, languageId, availableLanguageIds, json);
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

		return { ...validation };
	}

	static toggleValidationSection(validation, section) {
		return Parameter.enableValidation(validation, section, !Parameter.checkValidationEnabled(validation, section));
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

	static validate(parameter) {
		parameter.error = Parameter.validateValue(
			parameter.paramType,
			parameter.validation,
			parameter.value,
			parameter.languageId
		);
	}

	static validateValue(fieldType, validation, value, languageId) {
		console.log("validation: ", fieldType, isNaN(value), validation, languageId);
		switch (fieldType) {
			case ParamType.NUMERIC: {
				if (isNaN(value)) {
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
	#languageId;
	#availableLanguageIds;
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
	#showDefinition = false;
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
	#referenceFile = { fileId: 0, fileType: "pdf" };

	#validation = {};
	#style = {};

	#renderImage = null;
	#pdf = null;

	#value;
	#displayType = Parameter.DisplayTypes.FORM_FIELD;
	#error = {};

	#key = Util.randomKey();
	#dirty = false;
	#focused = false;

	constructor(namespace, formId, languageId, availableLanguageIds, paramType) {
		this.#namespace = namespace;
		this.#formId = formId;
		this.#languageId = languageId;
		this.#availableLanguageIds = availableLanguageIds;
		this.#paramType = paramType;
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
	get languageId() {
		return this.#languageId;
	}
	get availableLanguageIds() {
		return this.#availableLanguageIds;
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
	get showDefinition() {
		return this.#showDefinition;
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
	get displayType() {
		return this.#displayType;
	}
	get error() {
		return this.#error;
	}
	get errorMessage() {
		return this.error.message ?? "";
	}
	get errorClass() {
		return this.error.errorClass ?? "";
	}
	get labelPosition() {
		return this.#labelPosition;
	}
	get referenceFile() {
		return this.#referenceFile;
	}
	get dirty() {
		return this.#dirty;
	}
	get focused() {
		return this.#focused;
	}
	get tagId() {
		return this.namespace + this.paramName + "_" + this.paramVersion;
	}
	get tagName() {
		return this.namespace + this.paramName;
	}
	get style() {
		return this.#style;
	}

	get rowCount() {
		if (this.displayType !== Parameter.DisplayTypes.GRID_CELL) {
			return;
		}

		return this.value.length;
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
	set showDefinition(val) {
		this.#showDefinition = val;
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
	set displayType(val) {
		this.#displayType = val;
	}
	set error(val) {
		this.#error = val;
	}
	set errorMessage(message) {
		this.error.message = message;
	}
	set errorClass(className) {
		this.error.errorClass = className;
	}

	set labelPosition(val) {
		this.#labelPosition = val;
	}
	set referenceFile(val) {
		this.#referenceFile = val;
	}
	set dirty(val) {
		this.#dirty = val;
	}
	set focused(val) {
		this.#focused = val;
	}
	set style(val) {
		this.#style = val;
	}

	refreshKey() {
		this.#key = Util.randomKey();

		return this.#key;
	}

	isGridCell(cellIndex) {
		return this.displayType === Parameter.DisplayTypes.GRID_CELL && cellIndex >= 0;
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
		return languageId ? this.displayName[languageId] : this.displayName[this.languageId];
	}
	get label() {
		return this.getDisplayName();
	}
	addDisplayName(languageId, translation) {
		this.displayName = Parameter.addLocalized(this.displayName, languageId, translation);
	}
	removeDisplayName(languageId) {
		this.displayName = Parameter.removeLocalized(this.displayName, languageId);
	}

	getDefinition(languageId) {
		return languageId ? this.definition[languageId] : this.definition[this.languageId];
	}
	addDefinition(languageId, translation) {
		this.definition = Parameter.addLocalized(this.definition, languageId, translation);
	}
	removeDefinition(languageId) {
		this.definition = Parameter.removeLocalized(this.definition, languageId);
	}

	getTooltip(languageId) {
		return languageId ? this.tooltip[languageId] : this.tooltip[this.languageId];
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

	getTagId(cellIndex) {
		return cellIndex >= 0 ? this.tagId + "_" + cellIndex : this.tagId;
	}

	validate(key = "") {}

	addStyle(style) {
		this.style = { ...this.style, ...style };
	}

	removeStyle(property) {
		delete this.#style[property];
	}

	hasError() {
		return this.error.errorClass !== ErrorClass.SUCCESS;
	}

	clearError() {
		this.error = {};
	}

	fireRefresh(cellIndex) {
		Event.fire(Event.SX_REFRESH, this.namespace, this.namespace, {
			targetFormId: this.formId,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			cellIndex: cellIndex
		});
	}

	fireRefreshPreview(cellIndex) {
		Event.fire(Event.SX_REFRESH_PREVIEW, this.namespace, this.namespace, {
			targetFormId: this.formId,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			cellIndex: cellIndex
		});
	}

	fireFocus(cellIndex) {
		Event.fire(Event.SX_FOCUS, this.namespace, this.namespace, {
			targetFormId: this.formId,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			cellIndex: cellIndex
		});
	}

	fireValueChanged(cellIndex) {
		Event.fire(Event.SX_FIELD_VALUE_CHANGED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			cellIndex: cellIndex
		});
	}

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
		if (Util.isNotEmpty(this.defaultValue)) json.defaultValue = this.defaultValue;
		if (Util.isNotEmpty(this.referenceFile)) json.referenceFile = this.referenceFile;
		if (this.readOnly) json.readOnly = this.readOnly;
		if (this.showDefinition) json.showDefinition = this.showDefinition;
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

		json.displayType = this.displayType;

		return json;
	}

	toProperties() {
		return {
			key: this.key,
			paramType: this.paramType,
			paramName: this.paramName,
			paramVersion: this.paramVersion,
			parentId: this.parent,
			tagId: this.paramName,
			tagName: this.paramName,
			label: this.getDisplayName(this.languageId),
			labelPosition: this.labelPosition,
			definition: this.getDefinition(this.languageId),
			showDefinition: this.showDefinition,
			required: this.required,
			disabled: this.disabled,
			tooltip: this.getTooltip(this.languageId),
			referenceFile: this.referenceFile,
			validation: this.validation,
			readOnly: this.readOnly,
			order: this.order,
			languageId: this.languageId,
			availableLanguageIds: this.availableLanguageIds,
			focused: this.focused
		};
	}

	renderLabel({ forHtml, spritemap, inputStatus = false, languageId = this.languageId }) {
		const style =
			inputStatus && !this.hasValue()
				? {
						color: "#ff80b3"
				  }
				: {
						color: "black"
				  };

		return (
			<label
				htmlFor={forHtml}
				className="control-label"
				style={style}
			>
				{this.label}
				{this.required && <SXRequiredMark spritemap={spritemap} />}
				{Util.isNotEmpty(this.tooltip) && (
					<SXTooltip
						tooltip={this.getTooltip()}
						spritemap={spritemap}
					/>
				)}
			</label>
		);
	}

	renderPrefix() {
		if (Util.isNotEmpty(this.prefix)) {
			return (
				<ClayInput.GroupItem
					shrink
					style={{ alignContent: "end", marginLeft: "0.5rem" }}
				>
					{this.getPrefix()}
				</ClayInput.GroupItem>
			);
		}
	}

	renderPostfix() {
		if (Util.isNotEmpty(this.postfix)) {
			return (
				<ClayInput.GroupItem
					shrink
					style={{ alignContent: "end" }}
				>
					{this.getPostfix()}
				</ClayInput.GroupItem>
			);
		}
	}

	renderPreview({ dsbuilderId, propertyPanelId, previewCanvasId, className, style, spritemap }) {
		return (
			<SXPreviewRow
				key={parameter.key}
				dsbuilderId={dsbuilderId}
				propertyPanelId={propertyPanelId}
				previewCanvasId={previewCanvasId}
				parameter={this}
				focus={i + 1 === workingParamOrder ? true : false}
				spritemap={spritemap}
				inputStatus={this.enableInputStatus}
			/>
		);
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
	#prefix = {};
	#postfix = {};

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.STRING);

		if (Util.isNotEmpty(json)) {
			this.parse(json);
		}

		if (this.displayType === Parameter.DisplayTypes.GRID_CELL) {
			if (this.localized) {
				this.value = [{}];
			} else {
				this.value = [""];
			}
		} else {
			if (this.localized) {
				this.value = {};
			} else {
				this.value = "";
			}
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
	get prefix() {
		return this.#prefix;
	}
	get postfix() {
		return this.#postfix;
	}

	get languageFlags() {
		return this.availableLanguageIds.map((lang) => ({
			id: lang,
			name: lang,
			symbol: lang.toLowerCase()
		}));
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
	set prefix(val) {
		this.#prefix = val;
	}
	set postfix(val) {
		this.#postfix = val;
	}

	/**
	 *
	 * @param {Integer} cellIndex
	 * @returns
	 *     If index is larger than or equal to 0, it means the value type is array
	 *     so that the function returns indexed cell value.
	 *     Otherwise, vlaue array is returned when the value type of the parameter is "array",
	 *     and single value when the value type of the parameter is "single".
	 */
	getValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			return this.localized ? this.value[cellIndex] ?? {} : this.value[cellIndex] ?? "";
		} else {
			return this.localized ? this.value[cellIndex] : this.value;
		}
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.localized ? this.defaultValue ?? {} : this.defaultValue ?? "";
		} else {
			this.value = this.localized ? this.defaultValue ?? {} : this.defaultValue ?? "";
		}
	}

	getPlaceholder(languageId) {
		return this.placeholder[languageId];
	}

	getPrefix(languageId) {
		return languageId ?? this.prefix[this.languageId];
	}

	getPostfix(languageId) {
		return languageId ?? this.postfix[this.languageId];
	}

	setPrefix(prefix, languageId) {
		const langKey = languageId ?? this.languageId;

		this.prefix[langKey] = prefix;
	}

	setPostfix(postfix, languageId) {
		const langKey = languageId ?? this.languageId;

		this.postfix[langKey] = postfix;
	}

	getTranslation(languageId, cellIndex) {
		if (!(this.localized && this.hasValue())) {
			return "";
		}

		if (cellIndex >= 0) {
			return this.value[cellIndex] ? this.value[cellIndex][languageId] ?? "" : "";
		} else {
			return this.value[languageId] ?? "";
		}
	}

	setTranslation(languageId, translation, cellIndex) {
		if (!this.localized) {
			return;
		}

		if (cellIndex >= 0) {
			if (!this.value[cellIndex]) {
				this.value[cellIndex] = {};
			}

			this.value[cellIndex][languageId] = translation;
		} else {
			this.value[languageId] = translation;
		}
	}

	getTranslations(cellIndex) {
		return cellIndex >= 0 ? this.value[cellIndex] ?? {} : this.value;
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

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.placeholder = this.getPlaceholder(this.languageId);
		json.multipleLine = this.multipleLine;
		json.value = this.hasValue() ? this.value : this.defaultValue;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;

		return json;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		if (this.localized) {
			return (
				<SXLocalizedInput
					key={this.key}
					parameter={this}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
					inputStatus={inputStatus}
					displayType={displayType}
					viewType={viewType}
					cellIndex={cellIndex}
				/>
			);
		} else {
			return (
				<SXInput
					key={this.key}
					parameter={this}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
					inputStatus={inputStatus}
					displayType={displayType}
					viewType={viewType}
					cellIndex={cellIndex}
				/>
			);
		}
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

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.NUMERIC);

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
	get valueUncertainty() {
		return this.value.uncertainty;
	}
	get valueValue() {
		return this.value.value;
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
	set valueUncertainty(val) {
		this.value.uncertainty = Number(val);
	}
	set valueValue(val) {
		this.value.value = Number(val);
	}

	/**
	 *
	 * @param {Integer} cellIndex
	 * @returns
	 *     If cellIndex is larger than or equal to 0, it means the value type is array
	 *     so that the function returns indexed cell value.
	 */
	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	getValueUncertainty(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].uncertainty : this.value.uncertainty;
	}

	getValueValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].value : this.value.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	setValueUncertainty(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].uncertainty = Number(value);
		} else {
			this.value.uncertainty = Number(value);
		}
	}

	setValueValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].value = Number(value);
		} else {
			this.value.value = Number(value);
		}
	}

	hasValue(cellIndex) {
		let value = this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
		if (Util.isEmpty(value)) {
			return false;
		}

		return value.uncertainty ? Util.isNotEmpty(value.value) : Util.isNotEmpty(value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.uncertainty ? this.defaultValue ?? {} : this.defaultValue;
		} else {
			this.value = this.uncertainty ? this.defaultValue ?? {} : this.defaultValue;
		}
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
		if (this.unit) json.unit = this.unit;

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;
		json.unit = this.unit;
		json.value = this.value ?? this.defaultValue;
		if (Util.isNotEmpty(this.decimalPlaces)) {
			json.decimalPlaces = this.decimalPlaces;
		}

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXNumeric
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
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
	#optionsPerRow = 0;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.SELECT);

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

	get optionCount() {
		return this.#options.length;
	}

	set options(val) {
		this.#options = val;
	}
	set optionsPerRow(val) {
		this.#optionsPerRow = val;
	}

	isMultiple() {
		return (
			this.viewType === SelectParameter.ViewTypes.CHECKBOX ||
			this.viewType === SelectGroupParameter.ViewTypes.LISTBOX
		);
	}

	addOption(option) {
		let duplicated = false;
		this.options.every((opt) => {
			if (opt.value === option.value) {
				duplicated = true;
				return Constant.STOP_EVERY;
			}

			return Constant.CONTINUE_EVERY;
		});

		if (duplicated) {
			return 0;
		}

		this.#options.push(option);

		this.refreshKey();

		return this.options.length;
	}

	getOption(index) {
		return this.options[index];
	}

	removeOption(index) {
		this.#options.splice(index, 1);

		this.refreshKey();
		return this.options.length;
	}

	switchOptions(index1, index2) {
		let elem1 = this.#options[index1];
		this.#options[index1] = this.#options[index2];
		this.#options[index2] = elem1;

		this.refreshKey();
	}

	moveUpOption(index) {
		if (index === 0) {
			return 0;
		}

		this.switchOptions(index - 1, index);

		return index - 1;
	}

	moveDownOption(index) {
		if (index >= this.options.length - 1) {
			return index;
		}

		this.switchOptions(index, index + 1);

		return index + 1;
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue;
		} else {
			this.value = this.defaultValue;
		}
	}

	parse(json) {
		super.parse(json);
		this.options = json.options ?? [];

		this.viewType = json.viewType ?? SelectParameter.ViewTypes.DROPDOWN;

		console.log("SelectParameter parse: ", json.viewType, json.optionsPerRow);
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

		console.log("SelectParameter toJSON: ", this.viewTypw, this.optionsPerRow);
		if (this.viewType === SelectParameter.ViewTypes.RADIO || this.viewType === SelectParameter.ViewTypes.CHECKBOX) {
			if (this.optionsPerRow > 0) {
				json.optionsPerRow = this.optionsPerRow;
			}
		}

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.viewType = this.viewType;
		json.options = this.options.map((option) => ({ label: option.label[this.languageId], value: option.value }));
		json.optionsPerRow = this.optionsPerRow;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return json;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXSelect
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
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
	#rightOptions = [];

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.DUALLIST);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		} else {
			this.viewType = DualListParameter.ViewTypes.HORIZONTAL;
		}

		this.value = [];
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

	setValueByIds(ids) {
		let leftOptions = this.leftOptions.filter((option) => ids.includes(option.id));
		let rightOptions = this.leftOptions.filter((option) => !ids.includes(option.id));

		this.leftOptions = [...leftOptions, ...this.rightOptions.filter((option) => ids.includes(option.id))];
		this.rightOptions = [...rightOptions, ...this.rightOptions.filter((option) => !ids.includes(option.id))];

		this.dirty = true;
	}

	/**
	 *
	 * @param {Integer} cellIndex
	 * @returns
	 *     If index is larger than or equal to 0, it means the value type is array
	 *     so that the function returns indexed cell value.
	 *     Otherwise, vlaue array is returned when the value type of the parameter is "array",
	 *     and single value when the value type of the parameter is "single".
	 */
	getValue(cellIndex) {
		if (this.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.localized ? this.value[cellIndex] ?? {} : this.value[cellIndex] ?? "";
		} else {
			return this.value;
		}
	}

	setValue(value, index) {
		if (this.displayType === Parameter.DisplayTypes.GRID_CELL && index >= 0) {
			this.value[index] = value;
		} else {
			this.value = value;
		}
		console.log("Parameter.setValue(): ", this.displayType, value, index, this.value);
	}

	hasValue(cellIndex) {
		return cellIndex >= 0 ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	addValue(val) {
		this.value.push(val);
	}

	includedInValues(value) {
		if (this.hasValue()) {
			const result = this.value.filter((val) => val.value === value);
			return result.length > 0;
		} else {
			return false;
		}
	}

	notIncludedInValues(value) {
		return !this.includedInValues(value);
	}

	removeValue(val) {
		if (!this.hasValue()) {
			return;
		}

		this.value = this.value.filter((elem) => elem.value !== val);
	}

	clearValue() {
		this.rightOptions.concat(this.leftOptions);

		this.leftOptions = [];
	}

	setRightOptions(options) {
		this.rightOptions = options.filter((option) => this.notIncludedInValues(option.value));
	}

	getValue() {
		return this.value;
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.viewType = this.viewType;
		json.leftOptions = this.leftOptions;
		json.rightOptions = this.rightOptions;

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;

		return json;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXDualListBox
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
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

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, json);

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

	getTrueLabel(languageId) {
		return languageId ? this.trueLabel[languageId] : this.trueLabel[this.languageId];
	}

	getFalseLabel(languageId) {
		return languageId ? this.falseLabel[languageId] : this.falseLabel[this.languageId];
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue;
		} else {
			this.value = this.defaultValue;
		}
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties(tagId, tagName);

		properties.trueLabel = this.getTrueLabel()[this.languageId];
		properties.falseLabel = this.getFalseLabel()[this.languageId];

		properties.value = this.value ?? !!this.defaultValue;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXBoolean
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
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

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, BooleanParameter);

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

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = [];
		} else {
			this.value = [];
		}
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

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		properties.rowCount = this.rowCount;
		properties.colCount = this.colCount;
		properties.bracket = this.bracket ?? "[]";
		properties.delimiter = this.delimiter ?? " ";

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXMatrix
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 08. File
 *
 */
export class FileParameter extends Parameter {
	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.FILE);

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

	addFile(file, cellIndex) {}

	removeFile(fileId, cellIndex) {}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = [];
		} else {
			this.value = [];
		}
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXFile
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 09. Address
 *
 */
export class AddressParameter extends Parameter {
	static ViewTypes = {
		INLINE: "inline",
		BLOCK: "block",
		ONE_LINE: "oneLine"
	};

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.ADDRESS);

		if (json) {
			this.parse(json);
		} else {
			this.value = {};
			this.viewType = AddressParameter.ViewTypes.BLOCK;
		}
	}

	getZipcode(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].zipcode : this.value.zipcode;
	}
	getStreet(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].street : this.value.street;
	}
	getAddress(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].address : this.value.address;
	}

	setZipcode(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].zipcode = val;
		} else {
			this.value.zipcode = val;
		}
	}
	setStreet(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].street = val;
		} else {
			this.value.street = val;
		}
	}
	setAddress(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].address = val;
		} else {
			this.value.address = val;
		}
	}

	getFullAddress(cellIndex) {
		return this.getZipcode(cellIndex) + ", " + this.getStreet(cellIndex) + ", " + this.getAddress(cellIndex);
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = {};
		} else {
			this.value = {};
		}
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXAddress
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 10. Date
 *
 */
export class DateParameter extends Parameter {
	#enableTime = false;
	#startYear = "1970";
	#endYear = new Date().getFullYear().toString();

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.DATE);

		if (json) {
			this.parse(json);
		}
	}
	get enableTime() {
		return this.#enableTime;
	}
	get startYear() {
		return this.#startYear;
	}
	get endYear() {
		return this.#endYear;
	}

	set enableTime(val) {
		this.#enableTime = val;
	}
	set startYear(val) {
		this.#startYear = val;
	}
	set endYear(val) {
		this.#endYear = val;
	}

	getDate(cellIndex) {
		return this.isGridCell(cellIndex) ? new Date(this.value[cellIndex]) : new Date(this.value);
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(date, cellIndex) {
		const dateStr =
			val.getFullYear() +
			"/" +
			String(val.getMonth() + 1).padStart(2, "0") +
			"/" +
			String(val.getDate()).padStart(2, "0");

		const value = this.enableTime
			? dateStr + " " + String(val.getHours()).padStart(2, "0") + ":" + String(val.getHours()).padStart(2, "0")
			: dateStr;

		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		let startDate = "1970/01/01 ";
		if (this.enableTime) {
			startDate += "00:00";
		}

		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = startDate;
		} else {
			this.value = startDate;
		}
	}

	parse(json) {
		super.parse(json);

		this.enableTime = json.enableTime ?? false;
		this.startYear = json.startYear ?? "1970";
		this.endYear = json.endYear ?? new Date().getFullYear().toString();
	}

	toJSON() {
		let json = super.toJSON();

		if (this.enableTime) json.enableTime = this.enableTime;

		json.startYear = this.startYear ?? "1970";
		json.endYear = this.endYear ?? new Date().getFullYear().toString();

		return json;
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		properties.enableTime = this.enableTime;

		properties.startYear = this.startYear;
		properties.endYear = this.endYear;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXDate
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 11. Phone
 *
 */
export class PhoneParameter extends Parameter {
	#enableCountryNo = false;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.PHONE);

		if (json) {
			this.parse(json);
		}
	}

	getCountryNo(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].countryNo : this.value.countryNo;
	}
	getAreaNo(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].areaNo : this.value.areaNo;
	}
	getStationNo(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].stationNo : this.value.stationNo;
	}
	getPersonalNo(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].personal : this.value.personal;
	}
	get enableCountryNo() {
		return this.#enableCountryNo;
	}

	setCountryNo(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].countryNo;
		} else {
			this.value.countryNo = val;
		}
	}
	setAreaNo(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].areaNo;
		} else {
			this.value.areaNo = val;
		}
	}
	setStationNo(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].stationNo;
		} else {
			this.value.stationNo = val;
		}
	}
	setPersonalNo(val, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].personalNo;
		} else {
			this.value.personalNo = val;
		}
	}
	set enableCountryNo(val) {
		this.#enableCountryNo = val;
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? {};
		} else {
			this.value = this.defaultValue ?? {};
		}
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

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		properties.enableCountryNo = this.enableCountryNo;

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXPhone
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 12. EMail
 *
 */
export class EMailParameter extends Parameter {
	static SERVERS = ["gmail.com", "daum.net", "naver.com"];

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.EMAIL);

		if (json) {
			this.parse(json);
		}

		if (Util.isEmpty(this.value)) {
			this.value = {};
		}
	}

	getEmailId(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].emailId : this.value.emailId;
	}
	getServerName(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].serverName : this.value.serverName;
	}

	setEmailId(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].emailId = value;
		} else {
			this.value.emailId = value;
		}
	}
	setServerName(value) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].serverName = value;
		} else {
			this.value.serverName = value;
		}
	}

	getValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? {};
		} else {
			this.value = this.defaultValue ?? {};
		}
	}

	parse(json) {
		super.parse(json);
	}

	toString() {
		return this.value.emailId + "@" + this.value.serverName;
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties();

		if (tagId) properties.tagId = tagId;
		if (tagName) properties.tagName = tagName;

		return properties;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXEMail
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 13. Group
 *
 */
export class GroupParameter extends Parameter {
	static ViewTypes = {
		ARRANGEMENT: "arrangement",
		HORIZONTAL_PANEL: "horizontalPanel",
		VERTICAL_PANEL: "verticalPanel"
	};

	#members = [];
	#decorative = false;
	#membersPerRow = 1;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.GROUP);

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
			if (Util.isNotEmpty(value)) {
				member.loadData(value);
			}
		});
	}

	getValue() {
		let values = {};
		if (this.viewType === GroupParameter.ViewTypes.ARRANGEMENT) {
			this.members.forEach((member) => {
				if (member.hasValue()) {
					values[member.paramName] = member.getValue();
				}
			});
		} else {
			values[this.paramName] = {};
			this.members.forEach((member) => {
				if (member.hasValue()) {
					values[this.paramName][member.paramName] = member.getValue();
				}
			});
		}

		return values;
	}

	parse(json) {
		super.parse(json);

		this.viewType = this.viewType ?? GroupParameter.ViewTypes.VERTICAL_PANEL;
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

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.viewType = this.viewType;
		json.decorative = this.decorative;
		json.fieldsPerRow = this.membersPerRow;

		json.tagId = tagId;
		json.tagName = tagName;

		json.members = this.members.map((member) => {
			return member.toProperties(member.paramName, member.paramName);
		});

		return json;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXGroup
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}

/**
 * 14. SelectGroup
 *
 */
export class SelectGroupParameter extends Parameter {
	#children;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, json);
	}

	get children() {
		return this.#children;
	}

	set children(val) {
		this.#children = val;
	}

	parse() {}

	toJSON() {}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		if (tagId) json.tagId = tagId;
		if (tagName) json.tagName = tagName;
	}

	render({
		events = {},
		className = "",
		style = {},
		spritemap,
		inputStatus,
		displayType = this.displayType,
		viewType = this.viewType,
		cellIndex
	}) {
		return (
			<SXSelectGroup
				key={this.key}
				parameter={this}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
			/>
		);
	}
}
