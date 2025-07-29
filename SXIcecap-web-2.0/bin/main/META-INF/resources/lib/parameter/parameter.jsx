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
	SXGrid,
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
	static ColumnReadyTypes = [
		ParamType.STRING,
		ParamType.NUMERIC,
		ParamType.BOOLEAN,
		ParamType.SELECT,
		ParamType.EMAIL,
		ParamType.ADDRESS,
		ParamType.DATE,
		ParamType.FILE
	];

	static DisplayTypes = {
		FORM_FIELD: "formField",
		INLINE: "inline",
		SHARED_OPTION_CELL: "sharedOptionCell",
		SHARED_LABEL_CELL: "sharedLabelCell",
		GRID_CELL: "gridCell"
	};

	static DEFAULT_VERSION = "1.0.0";

	static createParameter(namespace, formId, languageId, availableLanguageIds, paramType, json) {
		switch (paramType) {
			case ParamType.STRING: {
				return new StringParameter(namespace, formId, languageId, availableLanguageIds, json);
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
			case ParamType.GRID: {
				return new GridParameter(namespace, formId, languageId, availableLanguageIds, json);
			}

			/*
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

	#key = Util.randomKey();
	#namespace;
	#formId;
	#languageId;
	#availableLanguageIds;
	#dirty = false;
	#focused = false;
	#error = {};

	#paramType;
	#paramName = "";
	#paramVersion = Parameter.DEFAULT_VERSION;
	#displayName = {};
	#displayType = Parameter.DisplayTypes.FORM_FIELD;
	#viewType;
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
	#parent = {
		name: GroupParameter.ROOT_GROUP,
		version: Parameter.DEFAULT_VERSION
	};
	#parameterId = 0;
	#standard = false;
	#status = 0;
	#state = 0;
	#active = true;
	#referenceFile = { fileId: 0, fileType: "pdf" };

	#validation = {};
	#style = {};

	#value;

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
	get viewType() {
		return this.#viewType;
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
	get parentName() {
		return this.parent.name;
	}
	get parentVersion() {
		return this.parent.version;
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
	get validation() {
		return this.#validation;
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
	get cssWidth() {
		if (this.style) {
			return this.style.width;
		}
	}

	get rowCount() {
		if (this.displayType !== Parameter.DisplayTypes.GRID_CELL) {
			return;
		}

		return this.value.length;
	}

	get totalFieldsCount() {
		return 1;
	}
	get valuedFieldsCount() {
		return this.hasValue() ? 1 : 0;
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
	set viewType(val) {
		this.#viewType = val;
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
	set parentName(val) {
		this.parent = {
			name: val,
			version: this.parent.version
		};
	}
	set parentVersion(val) {
		this.parent = {
			name: this.parent.name,
			version: val
		};
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
	set validation(val) {
		this.#validation = val;
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
	set cssWidth(val) {
		if (!this.style) {
			this.style = {};
		}

		this.#style.width = val;
	}

	refreshKey() {
		this.#key = Util.randomKey();

		return this.#key;
	}

	setDirty() {
		this.dirty = true;
		this.refreshKey();
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
		if (version) {
			return name === this.paramName && version === this.paramVersion;
		} else {
			return name === this.paramName;
		}
	}

	isMemberOf(assembly) {
		return assembly.name === this.parentName && assembly.version === this.parentVersion;
	}

	get isGroup() {
		return this.paramType === ParamType.GROUP;
	}

	postfixParameterCode(postfix) {
		this.paramName += "_" + postfix;
		this.paramVersion = Parameter.DEFAULT_VERSION;
	}

	copy() {
		const copied = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			this.paramType,
			JSON.parse(JSON.stringify(this))
		);

		copied.postfixParameterCode("copied");

		return copied;
	}

	focus(paramName, paramVersion) {
		const focus = this.equalTo(paramName, paramVersion);

		if (this.focused !== focus) {
			this.focused = focus;

			this.refreshKey();

			return true;
		}
		return false;
	}

	isRendered() {
		return this.order > 0;
	}

	isValueFilled() {}

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
		return this.isGridCell(cellIndex) ? this.tagId + "_" + cellIndex : this.tagId;
	}

	addStyle(style) {
		this.style = { ...this.style, ...style };
	}

	removeStyle(property) {
		delete this.#style[property];
	}

	hasError() {
		return this.error.errorClass === ErrorClass.ERROR || this.error.errorClass === ErrorClass.WARNING;
	}

	clearError() {
		this.error = {};
	}

	checkIntegrity() {
		if (Util.isEmpty(this.paramName)) {
			this.error = {
				message: Util.translate("parameter-name-is-missing"),
				errorClass: ErrorClass.ERROR
			};

			this.dirty = true;

			return false;
		}

		if (Util.isEmpty(this.paramVersion)) {
			this.error = {
				message: Util.translate("parameter-version-is-missing"),
				errorClass: ErrorClass.ERROR
			};

			this.dirty = true;
			return false;
		}

		if (Util.isEmpty(this.displayName)) {
			this.error = {
				message: Util.translate("display-name-is-missing"),
				errorClass: ErrorClass.ERROR
			};

			this.dirty = true;
			return false;
		}

		return true;
	}

	checkValidationEnabled(section) {
		return !!(this.validation && this.validation[section]);
	}

	enableValidation(section, enable) {
		if (enable) {
			switch (section) {
				case ValidationKeys.REQUIRED: {
					this.validation.required = {
						value: true
					};
					break;
				}
				case ValidationKeys.CUSTOM: {
					this.validation.custom = 'function(value){\n return {\nmessage:"",\nerrorClass:"has-error"};\n}';
					break;
				}
				default: {
					this.validation[section] = {};
				}
			}
		} else {
			delete this.validation[section];
		}
	}

	toggleValidationSection(section) {
		return this.enableValidation(section, !this.checkValidationEnabled(section));
	}

	getValidationValue(section, valueProp, locale) {
		if (this.checkValidationEnabled(section)) {
			switch (valueProp) {
				case "message": {
					if (locale) {
						return this.validation[section].message ? this.validation[section].message[locale] : "";
					} else {
						return this.validation[section].message ?? {};
					}
				}
				case "value":
				case "boundary": {
					return this.validation[section][valueProp];
				}
				default: {
					return this.validation[section];
				}
			}
		}
	}
	setValidationValue(section, valueProp, value, locale) {
		if (this.checkValidationEnabled(section)) {
			switch (valueProp) {
				case "message": {
					if (Util.isEmpty(this.validation[section].message)) {
						this.validation[section].message = {};
					}

					if (Util.isNotEmpty(value)) {
						if (locale) {
							this.validation[section].message[locale] = value;
						} else {
							this.validation[section].message = value;
						}
					} else {
						if (locale) {
							delete this.validation[section].message[locale];
						} else {
							delete this.validation[section].message;
						}
					}

					break;
				}
				case "value":
				case "boundary": {
					if (Util.isNotEmpty(value)) {
						this.validation[section][valueProp] = value;
					} else {
						delete this.validation[section][valueProp];
					}
					break;
				}
				default: {
					if (Util.isNotEmpty(value)) {
						this.validation[section] = value;
					} else {
						delete this.validation[section];
					}
				}
			}
		}
	}

	convertToSelectItem() {
		return {
			label: this.displayName,
			value: this.paramName
		};
	}

	/**
	 *
	 * @param {Integer} cellIndex
	 * @returns
	 *     If cellIndex is larger than or equal to 0, it means the value type is array
	 *     so that the function returns indexed cell value.
	 */
	getValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			if (!this.value) {
				this.value = [];
			}

			return this.value[cellIndex];
		} else {
			return this.value;
		}
	}

	setValue({ value, cellIndex = null, validate = false }) {
		if (this.isGridCell(cellIndex)) {
			if (!this.value) {
				this.value = [];
			}

			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}

		if (validate) {
			this.setDirty();
			this.validate(cellIndex);
		}
	}

	hasValue(cellIndex) {
		if (!this.value) {
			return false;
		}

		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	initValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.setValue({ value: this.defaultValue ?? null, cellIndex: cellIndex });
		} else {
			this.setValue({ value: this.defaultValue ?? null });
		}
	}

	clearValue(cellIndex) {
		this.initValue(cellIndex);
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
		if (this.displayType === Parameter.DisplayTypes.GRID_CELL) {
			Event.fire(Event.SX_REFRESH_PREVIEW, this.namespace, this.namespace, {
				targetFormId: this.formId,
				paramName: this.parent.name,
				paramVersion: this.parent.version,
				cellIndex: cellIndex
			});
		} else {
			Event.fire(Event.SX_REFRESH_PREVIEW, this.namespace, this.namespace, {
				targetFormId: this.formId,
				paramName: this.paramName,
				paramVersion: this.paramVersion,
				cellIndex: cellIndex
			});
		}
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

	fireSelectGroup(targetForm) {
		Event.fire(Event.SX_SELECT_GROUP, this.namespace, this.namespace, {
			targetFormId: targetForm
		});
	}

	fireCopy(targetForm) {
		Event.fire(Event.SX_COPY_PARAMETER, this.namespace, this.namespace, {
			targetFormId: targetForm
		});
	}

	fireDelete(targetForm) {
		Event.fire(Event.SX_DELETE_PARAMETER, this.namespace, this.namespace, {
			targetFormId: targetForm
		});
	}

	fireMoveUp(targetForm) {
		Event.fire(Event.SX_MOVE_PARAMETER_UP, this.namespace, this.namespace, {
			targetFormId: targetForm,
			parameter: this
		});
	}

	fireMoveDown(targetForm) {
		Event.fire(Event.SX_MOVE_PARAMETER_DOWN, this.namespace, this.namespace, {
			targetFormId: targetForm,
			parameter: this
		});
	}

	fireParameterSelected(targetForm) {
		Event.fire(Event.SX_PARAMETER_SELECTED, this.namespace, this.namespace, {
			targetFormId: targetForm,
			parameter: this
		});
	}

	parse(json) {
		for (const key in json) {
			this[key] = json[key];
		}
	}

	toData() {
		if (this.hasValue()) {
			let data = {};

			data[this.paramName] = this.value;

			return data;
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
			parent: this.parent,
			tagId: this.paramName,
			tagName: this.paramName,
			label: this.getDisplayName(this.languageId),
			definition: this.getDefinition(this.languageId),
			showDefinition: this.showDefinition,
			required: this.required,
			disabled: this.disabled,
			tooltip: this.getTooltip(this.languageId),
			referenceFile: this.referenceFile,
			validation: this.validation,
			order: this.order,
			languageId: this.languageId,
			availableLanguageIds: this.availableLanguageIds,
			focused: this.focused
		};
	}

	renderLabel({ forHtml = this.tagId, spritemap, inputStatus = false, languageId = this.languageId, style = {} }) {
		style.color = inputStatus && !this.hasValue() ? "#ff80b3" : "black";
		style.marginBottom = "0.3rem";
		style.fontSize = "0.825rem";
		style.fontWeight = "600";

		return (
			<div
				key={this.key}
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
			</div>
		);
	}

	getPrefix(languageId = this.languageId) {
		return this.prefix[languageId];
	}

	getPostfix(languageId = this.languageId) {
		return this.postfix[languageId];
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

	renderPreview({
		dsbuilderId,
		propertyPanelId,
		previewCanvasId,
		className = "",
		style = {},
		spritemap,
		inputStatus,
		position
	}) {
		return (
			<SXPreviewRow
				key={this.key}
				dsbuilderId={dsbuilderId}
				propertyPanelId={propertyPanelId}
				previewCanvasId={previewCanvasId}
				parameter={this}
				spritemap={spritemap}
				inputStatus={inputStatus}
				position={position}
				className={className}
				style={style}
			/>
		);
	}

	renderField({ className = "", style = {}, spritemap, inputStatus }) {
		return (
			<SXFormField
				key={this.key}
				parameter={this}
				spritemap={spritemap}
				inputStatus={inputStatus}
				className={className}
				style={style}
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
	#localized = false;
	#placeholder = {};
	#prefix = {};
	#postfix = {};

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.STRING);

		if (Util.isNotEmpty(json)) {
			this.parse(json);
		}

		if (!this.hasValue()) {
			this.initValue();
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
	get localized() {
		return this.#localized;
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
	set localized(val) {
		this.#localized = val;
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
		const value = super.getValue(cellIndex);

		return this.localized ? value ?? {} : value ?? "";
	}

	initValue(cellIndex) {
		this.setValue({ value: this.defaultValue ?? (this.localized ? {} : ""), cellIndex: cellIndex });
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

		if (this.isGridCell(cellIndex)) {
			if (!this.value) {
				this.value = [];
			}

			if (!this.value[cellIndex]) {
				this.value[cellIndex] = {};
			}

			this.value[cellIndex][languageId] = translation;
		} else {
			if (!this.value) {
				this.value = {};
			}

			this.value[languageId] = translation;
		}
	}

	validate(cellIndex) {
		let value = this.getValue(cellIndex);

		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.PATTERN: {
					const regExpr = new RegExp(this.validation.pattern.value);

					if (this.localized) {
						for (const locale in value) {
							if (!regExpr.test(value[locale])) {
								this.error = {
									message: this.getValidationValue(validationType, "message", this.languageId),
									errorClass: ErrorClass.ERROR
								};

								return;
							}
						}
					} else {
						if (!regExpr.test(value)) {
							this.error = {
								message: this.getValidationValue(validationType, "message", this.languageId),
								errorClass: ErrorClass.ERROR
							};

							return;
						}
					}

					break;
				}
				case ValidationKeys.MIN_LENGTH: {
					if (this.localized) {
						for (const locale in value) {
							if (value[locale].length < this.validation.minLength.value) {
								this.error = {
									message: this.getValidationValue(validationType, "message", this.languageId),
									errorClass: ErrorClass.ERROR
								};

								return;
							}
						}
					} else {
						if (value.length < this.validation.minLength.value) {
							this.error = {
								message: this.getValidationValue(validationType, "message", this.languageId),
								errorClass: ErrorClass.ERROR
							};

							return;
						}
					}

					break;
				}
				case ValidationKeys.MAX_LENGTH: {
					if (this.localized) {
						for (const locale in value) {
							if (value[locale].length > this.validation.maxLength.value) {
								this.error = {
									message: this.getValidationValue(validationType, "message", this.languageId),
									errorClass: ErrorClass.ERROR
								};

								return;
							}
						}
					} else {
						if (value.length > this.validation.maxLength.value) {
							this.error = {
								message: this.getValidationValue(validationType, "message", this.languageId),
								errorClass: ErrorClass.ERROR
							};

							return;
						}
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(value);

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	getTranslations(cellIndex) {
		return cellIndex >= 0 ? this.value[cellIndex] ?? {} : this.value;
	}

	parse(json) {
		super.parse(json);

		this.minLength = json.minLength ?? 1;
		this.maxLength = json.maxLength ?? 72;
		this.multipleLine = json.multipleLine ?? false;
		this.localized = json.localized ?? false;
		this.placeholder = json.placeholder ?? "";
	}

	toJSON() {
		let json = super.toJSON();

		if (this.minLength > 1) json.minLength = this.minLength;
		if (this.maxLength !== 72) json.maxLength = this.maxLength;
		if (this.multipleLine === true) json.multipleLine = this.multipleLine;
		if (this.localized === true) json.localized = this.localized;
		if (Util.isNotEmpty(this.placeholder)) json.placeholder = this.placeholder;

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.placeholder = this.getPlaceholder(this.languageId);
		json.multipleLine = this.multipleLine;
		json.localized = this.localized;
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

	#prefix = {};
	#postfix = {};

	#min;
	#max;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.NUMERIC);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}

		if (!this.hasValue()) {
			this.initValue();
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
	get prefix() {
		return this.#prefix;
	}
	get postfix() {
		return this.#postfix;
	}
	get min() {
		return this.#min;
	}
	get max() {
		return this.#max;
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
		this.value.uncertainty = val;
	}
	set valueValue(val) {
		this.value.value = val;
	}
	set prefix(val) {
		this.#prefix = val;
	}
	set postfix(val) {
		this.#postfix = val;
	}
	set min(val) {
		this.#min = val;
	}
	set max(val) {
		this.#max = val;
	}

	getValue(cellIndex) {
		let value = super.getValue(cellIndex);

		if (Util.isEmpty(value)) {
			value = this.uncertainty ? {} : "";
		}

		return value;
	}

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? (this.uncertainty ? {} : ""), cellIndex: cellIndex });
	}

	clearValue(cellIndex) {
		this.initValue(cellIndex);
	}

	getValueUncertainty(cellIndex) {
		const value = this.getValue(cellIndex);

		return this.isGridCell(cellIndex) ? this.value[cellIndex].uncertainty : this.value.uncertainty;
	}

	getValueValue(cellIndex) {
		return this.isGridCell(cellIndex) ? this.value[cellIndex].value : this.value.value;
	}

	setValueUncertainty(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			if (!this.value) {
				this.value = [];
			}

			if (!this.value[cellIndex]) {
				this.value[cellIndex] = {};
			}
			this.value[cellIndex].uncertainty = value;
		} else {
			if (!this.value) {
				this.value = {};
			}
			this.value.uncertainty = value;
		}

		this.validate(cellIndex);
	}

	setValueValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			if (!this.value) {
				this.value = [];
			}

			if (!this.value[cellIndex]) {
				this.value[cellIndex] = {};
			}
			this.value[cellIndex].value = value;
		} else {
			if (!this.value) {
				this.value = {};
			}

			this.value.value = value;
		}

		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		if (!this.value) {
			return false;
		}

		let value = this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
		if (Util.isEmpty(value)) {
			return false;
		}

		return value.uncertainty ? Util.isNotEmpty(value.value) : Util.isNotEmpty(value);
	}

	validate(cellIndex) {
		const valueObj = this.getValue(cellIndex);
		const value = this.uncertainty ? valueObj.value : valueObj;
		const uncertainty = this.uncertainty ? valueObj.uncertainty : 0;

		if (isNaN(value)) {
			this.error = {
				message: Util.translate("only-numbers-allowed-for-this-field"),
				errorClass: ErrorClass.ERROR
			};
		}

		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.NORMAL_MIN: {
					if (this.validation.normalMin.boundary && value - uncertainty < this.validation.normalMin.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.WARNING
						};
					} else if (value - uncertainty <= this.validation.normalMin.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.WARNING
						};

						return;
					}

					break;
				}
				case ValidationKeys.NORMAL_MAX: {
					if (this.validation.normalMax.boundary && value + uncertainty > this.validation.normalMax.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.WARNING
						};

						return;
					} else if (value + uncertainty >= this.validation.normalMax.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.WARNING
						};

						return;
					}

					break;
				}
				case ValidationKeys.MIN: {
					if (this.validation.min.boundary && value - uncertainty < this.validation.min.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					} else if (value - uncertainty <= this.validation.min.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.MAX: {
					if (this.validation.max.boundary && value + uncertainty > this.validation.max.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					} else if (value + uncertainty >= this.validation.max.value) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(value);

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	toNumber() {
		if (!this.hasValue()) {
			return;
		}

		if (this.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.uncertainty
				? this.value.map((val) => ({ value: Number(val.value), uncertainty: Number(val.uncertainty) }))
				: this.value.map((val) => Number(val));
		} else {
			return this.uncertainty
				? { value: Number(this.valueValue), uncertainty: Number(this.valueUncertainty) }
				: Number(this.value);
		}
	}

	parse(json) {
		super.parse(json);

		if (json.uncertainty) this.uncertainty = json.uncertainty;
		if (json.isInteger) {
			this.isInteger = json.isInteger;
			this.decimalPlaces = undefined;
		} else if (json.decimalPlaces) {
			this.decimalPlaces = json.decimalPlaces;
		}
		if (json.prefix) this.prefix = json.prefix;
		if (json.postfix) this.postfix = json.postfix;
		if (Util.isNotEmpty(json.min)) this.min = json.min;
		if (Util.isNotEmpty(json.max)) this.max = json.max;
	}

	toJSON() {
		let json = super.toJSON();

		if (this.uncertainty === true) json.uncertainty = this.uncertainty;
		if (this.isInteger === true) json.isInteger = this.isInteger;
		if (this.decimalPlaces !== 2) json.decimalPlaces = this.decimalPlaces;
		if (this.unit) json.unit = this.unit;
		if (Util.isNotEmpty(this.prefix)) json.prefix = this.prefix;
		if (Util.isNotEmpty(this.postfix)) json.postfix = this.postfix;
		if (Util.isNotEmpty(this.min)) json.min = this.min;
		if (Util.isNotEmpty(this.max)) json.max = this.max;

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;
		json.unit = this.unit;
		json.prefix = this.prefix;
		json.postfix = this.postfix;
		json.min = this.min;
		json.max = this.max;
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

		if (!this.viewType) {
			this.viewType = SelectParameter.ViewTypes.DROPDOWN;
		}

		if (!this.hasValue()) {
			this.initValue();
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
			this.viewType === SelectParameter.ViewTypes.CHECKBOX || this.viewType === SelectParameter.ViewTypes.LISTBOX
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

	copyOption(index) {
		const insertPlace = index + 1;
		const newOption = { ...this.getOption(index), value: "" };
		this.options = [...this.options.slice(0, insertPlace), newOption, ...this.options.slice(insertPlace)];

		this.refreshKey();
		return insertPlace;
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

	initValue(cellIndex) {
		let value = this.defaultValue;
		if (this.isMultiple()) {
			value = this.defaultValue ?? [];
		}

		super.setValue({ value: value, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	parse(json) {
		super.parse(json);
		this.options = json.options ?? [];

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
	#options = [];
	#viewType = DualListParameter.ViewTypes.HORIZONTAL;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.DUALLIST);

		if (!Util.isEmpty(json)) {
			this.parse(json);
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = DualListParameter.ViewTypes.HORIZONTAL;
		}

		if (!this.hasValue()) {
			this.initValue();
		}
	}

	get leftOptions() {
		return this.value;
	}
	get options() {
		return this.#options;
	}
	get viewType() {
		return this.#viewType;
	}
	get rightOptions() {
		return this.#options.filter((option) => this.value.notIncludedInValues(option.value));
	}

	set leftOptions(val) {
		this.value = val;
	}
	set options(val) {
		this.#options = val;
	}
	set viewType(val) {
		this.#viewType = val;
	}

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? [], cellIndex: cellIndex });
	}

	setValue({ value, cellIndex }) {
		const values = value.map((option) => option.value);
		super.setValue({
			value: this.options.filter((option) => values.includes(option.value)),
			cellIndex: cellIndex
		});
	}

	getLeftOptions(cellIndex) {
		const value = this.getValue(cellIndex) ?? [];
		//const value = this.getValue(cellIndex).map((val) => ({ displayName: val.displayName, value: val.id })) ?? [];

		return value.map((option) => ({
			key: option.value,
			label: option.label[this.languageId],
			value: option.value
		}));
	}

	getRightOptions() {
		return this.options
			.filter((option) => this.notIncludedInValues(option.value))
			.map((option) => ({
				key: option.value,
				label: option.label[this.languageId],
				value: option.value
			}));
	}

	addValue(val) {
		this.value.push(val);
	}

	includedInValues(value, cellIndex) {
		const values = this.getValue(cellIndex);

		const result = this.value.filter((val) => val.value === value);
		return result.length > 0;
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

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		let json = super.toJSON();

		json.options = this.options;
		json.viewType = this.viewType;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.viewType = this.viewType;
		json.leftOptions = this.leftOptions;
		json.options = this.options;

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
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = BooleanParameter.ViewTypes.CHECKBOX;
		}

		if (Util.isEmpty(this.options)) {
			const falseOption = {
				label: {},
				value: false
			};
			falseOption.label[this.languageId] = Util.translate("no");
			const trueOption = {
				label: {},
				value: false
			};
			trueOption.label[this.languageId] = Util.translate("yes");

			this.options = [falseOption, trueOption];
		}

		if (!this.hasValue()) {
			this.initValue();
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
	get allowUnsetValue() {
		return (
			this.viewType === BooleanParameter.ViewTypes.RADIO || this.viewType === BooleanParameter.ViewTypes.DROPDOWN
		);
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

	initValue(cellIndex) {
		let defaultValue = this.defaultValue;
		if (
			this.viewType === BooleanParameter.ViewTypes.CHECKBOX ||
			this.viewType === BooleanParameter.ViewTypes.TOGGLE
		) {
			defaultValue = this.defaultValue ?? false;
		}

		super.setValue({ value: defaultValue, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
	}

	parse(json) {
		super.parse(json);
	}

	toJSON() {
		return super.toJSON();
	}

	toProperties(tagId, tagName) {
		let properties = super.toProperties(tagId, tagName);

		properties.trueLabel = this.getTrueLabel(this.languageId);
		properties.falseLabel = this.getFalseLabel(this.languageId);

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

		if (!this.hasValue()) {
			this.initValue();
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

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? [], cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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

		if (!this.hasValue()) {
			this.initValue();
		}
	}

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? [], cellIndex: cellIndex });
	}

	getFiles(cellIndex) {
		return this.getValue(cellIndex);
	}

	setFiles(val, cellIndex) {
		this.setValue(val, cellIndex);
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = AddressParameter.ViewTypes.BLOCK;
		}

		if (!this.hasValue()) {
			this.initValue();
		}
	}

	getValue(cellIndex) {
		const value = super.getValue(cellIndex);

		return !value ? {} : value;
	}

	getZipcode(cellIndex) {
		const value = this.getValue(cellIndex);

		return Util.isEmpty(value.zipcode) ? "" : value.zipcode;
	}
	getStreet(cellIndex) {
		const value = this.getValue(cellIndex);

		return Util.isEmpty(value.street) ? "" : value.street;
	}
	getAddress(cellIndex) {
		const value = this.getValue(cellIndex);

		return Util.isEmpty(value.address) ? "" : value.address;
	}

	setZipcode(val, cellIndex) {
		super.setValue({
			value: {
				zipcode: val,
				street: this.getStreet(cellIndex),
				address: this.getAddress(cellIndex)
			},
			cellIndex: cellIndex,
			validate: true
		});
	}
	setStreet(val, cellIndex) {
		super.setValue({
			value: {
				zipcode: this.getZipcode(cellIndex),
				street: val,
				address: this.getAddress(cellIndex)
			},
			cellIndex: cellIndex,
			validate: true
		});
	}
	setAddress(val, cellIndex) {
		super.setValue({
			value: {
				zipcode: this.getZipcode(cellIndex),
				street: this.getStreet(cellIndex),
				address: val
			},
			cellIndex: cellIndex,
			validate: true
		});
	}

	getFullAddress(cellIndex) {
		return this.getZipcode(cellIndex) + ", " + this.getStreet(cellIndex) + ", " + this.getAddress(cellIndex);
	}

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? {}, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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

		if (!this.hasValue()) {
			this.initValue();
		}

		this.dirty = false;
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

	initValue(cellIndex) {
		const startYear = this.startYear ?? "1970";

		const defaultValue = this.defaultValue ?? this.enableTime ? startYear + "-01-01 00:00" : startYear + "-01-01";

		super.setValue({ value: defaultValue, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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

		if (!this.hasValue()) {
			this.initValue();
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

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? {}, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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

		if (!this.hasValue()) {
			this.initValue();
		}

		/*
		this.validation.pattern = {
			value: "^[a-z][a-zA-Z0-9._%+-]+@[a-z][a-zA-Z0-9.-]+.[a-zA-Z]{2,}$",
			message:Util.getTranslationObject(this.languageId, "wrong-email-pattern"),
			errorClass: ErrorClass.ERROR
		};
		*/
	}

	getEmailId(cellIndex) {
		const value = super.getValue(cellIndex);

		if (Util.isEmpty(value)) {
			return "";
		} else {
			return this.value.emailId;
		}
	}

	getServerName(cellIndex) {
		const value = super.getValue(cellIndex);

		if (Util.isEmpty(value)) {
			return "";
		} else {
			return this.value.serverName;
		}
	}

	setEmailId(value, cellIndex) {
		const serverName = this.getServerName(cellIndex);
		super.setValue({ emailId: value, serverName: serverName }, cellIndex);

		this.setDirty();
	}
	setServerName(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].serverName = value;
		} else {
			this.value.serverName = value;
		}

		this.setDirty();
	}

	getEmailAddress(cellIndex) {
		const value = super.getValue(cellIndex);
		if (Util.isEmpty(value)) {
			return "";
		} else {
			return value.emailId + "@" + value.serverName;
		}
	}

	checkValidEmail(cellIndex) {
		const value = this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	initValue(cellIndex) {
		super.setValue({ value: this.defaultValue ?? {}, cellIndex: cellIndex });
	}

	validate(cellIndex) {
		for (const validationType in this.validation) {
			switch (validationType) {
				case ValidationKeys.REQUIRED: {
					if (this.validation.required.value && !this.hasValue(cellIndex)) {
						this.error = {
							message: this.getValidationValue(validationType, "message", this.languageId),
							errorClass: ErrorClass.ERROR
						};

						return;
					}

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.error = this.validation.custom(this.getValue(cellIndex));

					if (this.hasError()) {
						return;
					}
				}
			}
		}

		this.error = {
			message: "",
			errorClass: ErrorClass.SUCCESS
		};
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
	static ROOT_GROUP = "__root__";

	static ViewTypes = {
		ARRANGEMENT: "arrangement", // Just for arrangement for all members
		PANEL: "panel"
	};

	#members = [];
	#membersPerRow = 1;
	#expanded = false;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.GROUP);

		if (json) {
			this.parse(json);
		}

		if (Util.isEmpty(this.viewType)) {
			this.viewType = GroupParameter.ViewTypes.PANEL;
		}
	}

	get members() {
		return this.#members;
	}
	get firstMember() {
		return this.members.length > 0 ? this.members[0] : null;
	}
	get lastMember() {
		return this.members.length > 0 ? this.members[this.members.length - 1] : null;
	}

	get membersPerRow() {
		return this.#membersPerRow;
	}
	get expanded() {
		return this.#expanded;
	}
	get totalFieldsCount() {
		let totalFields = 0;
		this.members.forEach((field) => {
			totalFields += field.totalFieldsCount;
		});

		return totalFields;
	}
	get valuedFieldsCount() {
		let valuedFields = 0;
		this.members.forEach((field) => {
			valuedFields += field.valuedFieldsCount;
		});

		return valuedFields;
	}

	get showMembersPerRow() {
		return (
			this.viewType === GroupParameter.ViewTypes.ARRANGEMENT || this.viewType === GroupParameter.ViewTypes.PANEL
		);
	}

	set members(val) {
		this.#members = val;
	}
	set membersPerRow(val) {
		this.#membersPerRow = val;
	}
	set expanded(val) {
		this.#expanded = val;
	}

	get paramName() {
		return super.paramName;
	}
	set paramName(val) {
		super.paramName = val;

		this.updateMemberParents();
	}
	get paramVersion() {
		return super.paramVersion;
	}
	set paramVersion(val) {
		super.paramVersion = val;

		this.updateMemberParents();
	}

	updateMemberParents() {
		this.#members.forEach((member) => (member.parent = { name: this.paramName, version: this.paramVersion }));
	}

	setMemberOrders() {
		this.members.forEach((member, index) => (member.order = index + 1));
	}

	addMember(member, memOrder = this.members.length) {
		switch (this.viewType) {
			case GroupParameter.ViewTypes.ARRANGEMENT:
			case GroupParameter.ViewTypes.PANEL: {
				member.displayType = Parameter.DisplayTypes.FORM_FIELD;
				break;
			}
		}

		member.parent = { name: this.paramName, version: this.paramVersion };

		member.order = this.members.length + 1;
		this.members.push(member);
		console.log("Group addMember: ", this.members);
	}

	insertMember(param, memOrder) {
		if (this.members.length === 0 || memOrder === this.members.length) {
			this.members.push(param);
		} else if (memOrder === 0) {
			this.#members.unshift(param);
		} else {
			this.members.splice(memOrder, 0, param);
		}
		this.refreshKey();

		this.setMemberOrders();
	}

	isMember(paramName, paramVersion) {
		let isMember = false;

		this.members.every((member) => {
			if (member.equalTo(paramName, paramVersion)) {
				isMember = true;

				return Constant.STOP_EVERY;
			}

			return Constant.CONTINUE_EVERY;
		});

		return isMember;
	}

	setMemberOrders() {
		this.members.forEach((member, index) => (member.order = index + 1));
	}

	removeMember({ paramName, paramVersion = Parameter.DEFAULT_VERSION }) {
		let removed;

		this.members = this.members.filter((member) => {
			let skipped;

			if (member.equalTo(paramName, paramVersion)) {
				removed = skipped = member;
			} else if (member.isGroup) {
				skipped = member.removeMember({ paramName: paramName, paramVersion: paramVersion });
				if (skipped) {
					removed = skipped;
				}
			}

			return skipped ? Constant.FILTER_SKIP : Constant.FILTER_ADD;
		});

		this.setMemberOrders();

		return removed;
	}

	findParameter({ paramName, paramVersion = Parameter.DEFAULT_VERSION, descendant = true }) {
		if (this.equalTo(paramName, paramVersion)) {
			return this;
		}

		let found = null;

		this.members.every((field) => {
			if (field.equalTo(paramName, paramVersion)) {
				found = field;
			} else if (descendant && field.isGroup) {
				found = field.findParameter({
					paramName: paramName,
					paramVersion: paramVersion,
					descendant: descendant
				});
			}

			return found ? Constant.STOP_EVERY : Constant.CONTINUE_EVERY;
		});

		return found;
	}

	moveParameterUp(paramOrder) {
		const srcIndex = paramOrder - 1;
		const targetIndex = srcIndex - 1;
		const targetParam = this.members[targetIndex];
		this.members[targetIndex] = this.members[srcIndex];
		this.members[targetIndex].refreshKey();
		this.members[srcIndex] = targetParam;
		this.members[srcIndex].refreshKey();

		this.setMemberOrders();
	}

	moveParameterDown(paramOrder) {
		const srcIndex = paramOrder - 1;
		const targetIndex = srcIndex + 1;
		const targetParam = this.members[targetIndex];
		this.members[targetIndex] = this.members[srcIndex];
		this.members[srcIndex] = targetParam;

		this.setMemberOrders();
	}

	postfixParameterCode(postfix) {
		this.paramName += "_" + postfix;
		this.paramVersion = Parameter.DEFAULT_VERSION;

		this.members.forEach((member, index) => member.postfixParameterCode(postfix + "_" + index));
	}

	getMemberPosition(member) {
		if (this.members.length === 1 && member.order === 1) {
			return "deadEnd";
		} else if (member.order === 1) {
			return "start";
		} else if (member.order === this.members.length) {
			return "end";
		}

		return "middle";
	}

	copy() {
		const copied = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			this.paramType,
			JSON.parse(JSON.stringify(this))
		);

		copied.postfixParameterCode("copied");

		return copied;
	}

	countParameters() {
		return this.members.length;
	}

	focus(paramName, paramVersion) {
		this.focused = this.equalTo(paramName, paramVersion);

		this.members.forEach((param) => {
			param.focus(paramName, paramVersion);
		});
	}

	loadData(data) {
		this.members.forEach((member) => {
			const value = data[member.paramName];
			if (Util.isNotEmpty(value)) {
				member.loadData(value);
			}
		});
	}

	parse(json) {
		super.parse(json);

		this.viewType = this.viewType ?? GroupParameter.ViewTypes.PANEL;
		this.membersPerRow = json.membersPerRow ?? 1;
		this.expanded = json.expanded ?? false;

		if (Util.isNotEmpty(json.members)) {
			this.members = json.members.map((member) => {
				return Parameter.createParameter(
					this.namespace,
					this.formId,
					this.languageId,
					this.availableLanguageIds,
					member.paramType,
					member
				);
			});
		}
	}

	toData() {
		let output = {};
		this.members.forEach((member) => {
			const data = member.toData();

			if (Util.isNotEmpty(data)) {
				output = { ...output, ...data };
			}
		});

		if (this.viewType === GroupParameter.ViewTypes.ARRANGEMENT) {
			return output;
		} else {
			let groupOutput = {};
			groupOutput[this.paramName] = output;

			return groupOutput;
		}
	}

	toJSON() {
		let json = super.toJSON();

		if (this.viewType !== GroupParameter.ViewTypes.PANEL) json.viewType = this.viewType;
		if (this.membersPerRow > 1) json.membersPerRow = this.membersPerRow;
		if (this.expanded) json.expanded = this.expanded;

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
		json.fieldsPerRow = this.membersPerRow;
		json.expanded = this.expanded;

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
		preview = false,
		dsbuilderId,
		propertyPanelId,
		previewCanvasId,
		cellIndex
	}) {
		return (
			<SXGroup
				key={this.key}
				parameter={this}
				formId={this.formId}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
				preview={preview}
				dsbuilderId={dsbuilderId}
				propertyPanelId={propertyPanelId}
				previewCanvasId={previewCanvasId}
			/>
		);
	}
}

/**
 * 14. Grid
 *
 */
export class GridParameter extends Parameter {
	#columns = [];
	#rowCount = 0;

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		super(namespace, formId, languageId, availableLanguageIds, ParamType.GRID);

		if (json) {
			this.parse(json);
		}
	}

	get columns() {
		return this.#columns;
	}
	get firstColumn() {
		return this.columns.length > 0 ? this.columns[0] : null;
	}
	get lastColumn() {
		return this.columns.length > 0 ? this.columns[this.columns.length - 1] : null;
	}
	get rowCount() {
		return this.#rowCount;
	}
	get columnCount() {
		return this.#columns.length;
	}

	get totalFieldsCount() {
		let totalFields = 0;
		this.columns.forEach((column) => {
			totalFields += column.totalFieldsCount;
		});

		return totalFields;
	}
	get valuedFieldsCount() {
		let valuedFields = 0;
		this.columns.forEach((column) => {
			valuedFields += column.valuedFieldsCount;
		});

		return valuedFields;
	}

	set columns(val) {
		this.#columns = val;
	}
	set rowCount(val) {
		this.#rowCount = val;
	}

	get paramName() {
		return super.paramName;
	}
	set paramName(val) {
		super.paramName = val;

		this.updateColumnParents();
	}
	get paramVersion() {
		return super.paramVersion;
	}
	set paramVersion(val) {
		super.paramVersion = val;

		this.updateColumnParents();
	}

	updateColumnParents() {
		this.#columns.forEach((column) => (column.parent = { name: this.paramName, version: this.paramVersion }));
	}

	setColumnOrders() {
		this.columns.forEach((column, index) => (column.order = index + 1));
	}

	addColumn(column) {
		column.parent = { name: this.paramName, version: this.paramVersion };
		column.displayType = Parameter.DisplayTypes.GRID_CELL;

		column.order = this.columnCount + 1;
		this.columns.push(column);

		this.dirty = true;
		this.refreshKey();
	}

	insertColumn(column, colOrder) {
		if (this.columns.length === 0 || colOrder === this.columns.length) {
			this.columns.push(column);
		} else if (colOrder === 0) {
			this.#columns.unshift(column);
		} else {
			this.columns.splice(colOrder, 0, column);
		}

		this.setColumnOrders();

		this.dirty = true;
		this.refreshKey();
	}

	isColumn(colName, colVersion) {
		let isColumn = false;

		this.columns.every((column) => {
			if (column.equalTo(colName, colVersion)) {
				isColumn = true;

				return Constant.STOP_EVERY;
			}

			return Constant.CONTINUE_EVERY;
		});

		return isColumn;
	}

	removeColumn({ colName, colVersion = Parameter.DEFAULT_VERSION }) {
		let removed;

		this.columns = this.columns.filter((column) => {
			if (column.equalTo(colName, colVersion)) {
				removed = column;
			}

			return removed ? Constant.FILTER_SKIP : Constant.FILTER_ADD;
		});

		this.setColumnOrders();

		this.dirty = true;
		this.refreshKey();

		return removed;
	}

	/**
	 * Deletes a column from the grid.
	 *
	 * @param {integer} colIndex: 1 to column count
	 */
	deleteColumn(colIndex) {
		this.columns.splice(colIndex - 1, 1);

		this.dirty = true;
		this.refreshKey();
	}

	findColumn({ colName, colVersion = Parameter.DEFAULT_VERSION }) {
		let found = null;

		this.columns.every((column) => {
			if (column.equalTo(colName, colVersion)) {
				found = column;
			}

			return found ? Constant.STOP_EVERY : Constant.CONTINUE_EVERY;
		});

		return found;
	}

	moveColumnLeft(colOrder) {
		const srcIndex = colOrder - 1;
		const targetIndex = srcIndex - 1;
		const targetParam = this.columns[targetIndex];
		this.columns[targetIndex] = this.columns[srcIndex];
		this.columns[targetIndex].refreshKey();
		this.columns[srcIndex] = targetParam;
		this.columns[srcIndex].refreshKey();

		this.setColumnOrders();

		this.dirty = true;
		this.refreshKey();
	}

	moveColumnRight(colOrder) {
		const srcIndex = colOrder - 1;
		const targetIndex = srcIndex + 1;
		const targetParam = this.columns[targetIndex];
		this.columns[targetIndex] = this.columns[srcIndex];
		this.columns[srcIndex] = targetParam;

		this.setColumnOrders();

		this.dirty = true;
		this.refreshKey();
	}

	insertRow(rowIndex) {
		this.columns.forEach((column) => {
			column.value.splice(rowIndex, 0, null);

			column.refreshKey();
		});

		this.rowCount++;

		this.dirty = true;
		this.refreshKey();
	}

	copyRow(rowIndex) {
		const copyedIndex = rowIndex + 1;

		this.columns.forEach((column) => {
			column.value.splice(copyedIndex, 0, null);

			column.setValue({ value: column.getValue(rowIndex), cellIndex: copyedIndex });
			column.refreshKey();
		});

		this.rowCount++;

		this.dirty = true;
		this.refreshKey();
	}

	deleteRow(rowIndex) {
		this.columns.forEach((column) => {
			column.value.splice(rowIndex, 1);
			column.refreshKey();
		});

		if (this.rowCount > 1) {
			this.rowCount--;
		}

		this.dirty = true;
		this.refreshKey();
	}

	moveUpRow(rowIndex) {
		const prevIndex = rowIndex - 1;

		this.columns.forEach((column) => {
			const prevValue = column.getValue(prevIndex);
			const targetValue = column.getValue(rowIndex);

			column.setValue({ value: prevValue, cellIndex: rowIndex });
			column.setValue({ value: targetValue, cellIndex: prevIndex });

			column.refreshKey();
		});

		this.dirty = true;
		this.refreshKey();
	}

	moveDownRow(rowIndex) {
		const nextIndex = rowIndex + 1;

		this.columns.forEach((column) => {
			const nextValue = column.getValue(nextIndex);
			const targetValue = column.getValue(rowIndex);

			column.setValue({ value: nextValue, cellIndex: rowIndex });
			column.setValue({ value: targetValue, cellIndex: nextIndex });

			column.refreshKey();
		});

		this.dirty = true;
		this.refreshKey();
	}

	postfixParameterCode(postfix) {
		this.paramName += "_" + postfix;
		this.paramVersion = Parameter.DEFAULT_VERSION;

		this.columns.forEach((column, index) => column.postfixParameterCode(postfix + "_" + index));
	}

	getColumnPosition(column) {
		if (this.columns.length === 1 && column.order === 1) {
			return "deadEnd";
		} else if (column.order === 1) {
			return "start";
		} else if (column.order === this.columns.length) {
			return "end";
		}

		return "middle";
	}

	copy() {
		const copied = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			this.paramType,
			JSON.parse(JSON.stringify(this))
		);

		copied.postfixParameterCode("copied");

		return copied;
	}

	fireColumnSelected(colName, targetForm) {
		let colFound;

		this.columns.every((column) => {
			if (column.paramName === colName) {
				colFound = column;

				return Constant.STOP_EVERY;
			}

			return Constant.CONTINUE_EVERY;
		});

		if (colFound) {
			colFound.fireParameterSelected(targetForm);
		}
	}

	loadData(data) {
		this.columns.forEach((column) => {
			const value = data[column.paramName];
			if (Util.isNotEmpty(value)) {
				column.loadData(value);
			}
		});
	}

	parse(json) {
		super.parse(json);

		this.rowCount = json.rowCount;

		if (Util.isNotEmpty(json.columns)) {
			this.columns = json.columns.map((column) => {
				return Parameter.createParameter(
					this.namespace,
					this.formId,
					this.languageId,
					this.availableLanguageIds,
					column.paramType,
					column
				);
			});
		}
	}

	toData() {
		let output = {};
		this.columns.forEach((column) => {
			const data = column.toData();

			if (Util.isNotEmpty(data)) {
				output = { ...output, ...data };
			}
		});

		let gridOutput = {};
		gridOutput[this.paramName] = output;

		return gridOutput;
	}

	toJSON() {
		let json = super.toJSON();

		json.rowCount = this.rowCount;

		let jsonColumns = [];
		this.columns.forEach((column) => {
			jsonColumns.push(column.toJSON());
		});

		json.columns = jsonColumns;

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.tagId = tagId;
		json.tagName = tagName;

		json.rowCount = this.rowCount;

		json.columns = this.columns.map((column) => {
			return column.toProperties(column.paramName, column.paramName);
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
		preview = false,
		dsbuilderId,
		propertyPanelId,
		previewCanvasId,
		cellIndex
	}) {
		return (
			<SXGrid
				key={this.key}
				parameter={this}
				formId={this.formId}
				events={events}
				className={className}
				style={style}
				spritemap={spritemap}
				inputStatus={inputStatus}
				displayType={displayType}
				viewType={viewType}
				cellIndex={cellIndex}
				preview={preview}
				dsbuilderId={dsbuilderId}
				propertyPanelId={propertyPanelId}
				previewCanvasId={previewCanvasId}
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
