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
	static GridCellableTypes = [
		ParamType.STRING,
		ParamType.NUMERIC,
		ParamType.BOOLEAN,
		ParamType.SELECT,
		ParamType.EMAIL,
		ParamType.ADDRESS,
		ParamType.PHONE,
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

	#namespace;
	#formId;
	#languageId;
	#availableLanguageIds;
	#paramType;
	#paramName = "";
	#paramVersion = "1.0.0";
	#displayName = {};
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
		return Util.isEmpty(this.parent) ? "" : this.parent.name;
	}
	get parentVersion() {
		return Util.isEmpty(this.parent) ? "" : this.parent.version;
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
		const version = Util.isEmpty(this.parent) ? "" : this.parent.version ?? "";

		this.parent = {
			name: val,
			version: version
		};
	}
	set parentVersion(val) {
		const name = Util.isEmpty(this.parent) ? "" : this.parent.name ?? "";

		this.parent = {
			name: name,
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
		if (version) {
			return name === this.paramName && version === (this.paramVersion ? this.paramVersion : "1.0.0");
		} else {
			return name === this.paramName;
		}
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
		return this.order > 0;
	}

	isActive() {
		return !!this.active;
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
			targetFormId: targetForm
		});
	}

	fireMoveDown(targetForm) {
		Event.fire(Event.SX_MOVE_PARAMETER_DOWN, this.namespace, this.namespace, {
			targetFormId: targetForm
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

	renderLabel({ forHtml = this.tagId, spritemap, inputStatus = false, languageId = this.languageId, style = {} }) {
		style.color = inputStatus && !this.hasValue() ? "#ff80b3" : "black";

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
		console.log("Parameter renderPreview: ", dsbuilderId);
		return (
			<SXPreviewRow
				key={this.paramName}
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
		if (this.isGridCell(cellIndex)) {
			return this.localized ? this.value[cellIndex] ?? {} : this.value[cellIndex] ?? "";
		} else {
			return this.localized ? this.value ?? {} : this.value ?? "";
		}
	}

	initValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? this.localized ? {} : "";
		} else {
			this.value = this.defaultValue ?? (this.localized ? {} : "");
		}
	}

	setValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
		}

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
	}

	clearValue(cellIndex) {
		this.initValue(cellIndex);
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	initValue(cellIndex) {
		if (Util.isNotEmpty(this.defaultValue)) {
			this.setValue(this.defaultValue, cellIndex);
		} else {
			this.setValue(this.uncertainty ? {} : null, cellIndex);
		}
	}

	setValueUncertainty(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].uncertainty = value;
		} else {
			this.value.uncertainty = value;
		}

		this.validate(cellIndex);
	}

	setValueValue(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].value = value;
		} else {
			this.value.value = value;
		}

		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
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
	}

	toJSON() {
		let json = super.toJSON();

		if (this.uncertainty === true) json.uncertainty = this.uncertainty;
		if (this.isInteger === true) json.isInteger = this.isInteger;
		if (this.decimalPlaces !== 2) json.decimalPlaces = this.decimalPlaces;
		if (this.unit) json.unit = this.unit;
		if (Util.isNotEmpty(this.prefix)) json.prefix = this.prefix;
		if (Util.isNotEmpty(this.postfix)) json.postfix = this.postfix;

		return json;
	}

	toProperties(tagId, tagName) {
		let json = super.toProperties();

		json.uncertainty = this.uncertainty;
		json.isInteger = this.isInteger;
		json.unit = this.unit;
		json.prefix = this.prefix;
		json.postfix = this.postfix;
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

		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = value;
		} else {
			this.value = value;
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? [];
		} else {
			this.value = this.defaultValue ?? [];
		}
	}

	/**
	 * If index is larger than or equal to 0, it means the value type is array
	 *     so that the function returns indexed cell value.
	 * @param {Integer} cellIndex
	 * @returns
	 *	String array of values
	 */
	getValue(cellIndex) {
		return this.displayType === Parameter.DisplayTypes.GRID_CELL ? this.value[cellIndex] ?? [] : this.value;
	}

	setValue(options, cellIndex) {
		const values = options.map((option) => option.value);
		if (this.isGridCell()) {
			this.value[cellIndex] = this.options.filter((option) => values.includes(option.value));
		} else {
			this.value = this.options.filter((option) => values.includes(option.value));
		}

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return cellIndex >= 0 ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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

		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = defaultValue;
		} else {
			this.value = defaultValue;
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? [];
		} else {
			this.value = this.defaultValue ?? [];
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? [];
		} else {
			this.value = this.defaultValue ?? [];
		}
	}

	getFiles(cellIndex) {
		return this.getValue(cellIndex);
	}

	setFiles(val, cellIndex) {
		this.setValue(val, cellIndex);
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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

	initValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? {};
		} else {
			this.value = this.defaultValue ?? {};
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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

		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] =
				this.defaultValue ?? this.enableTime ? startYear + "-01-01 00:00" : startYear + "-01-01";
		} else {
			this.value = this.defaultValue ?? this.enableTime ? startYear + "-01-01 00:00" : startYear + "-01-01";
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? {};
		} else {
			this.value = this.defaultValue ?? {};
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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

		this.dirty = true;
	}
	setServerName(value, cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex].serverName = value;
		} else {
			this.value.serverName = value;
		}

		this.dirty = true;
	}

	getEmailAddress(cellIndex) {
		if (this.isGridCell(this.cellIndex)) {
			return this.getEmailId(this.cellIndex) + "@" + this.getServerName(this.cellIndex);
		}
	}

	checkValidEmail(cellIndex) {
		const value = this.isGridCell(cellIndex) ? this.value[cellIndex] : this.value;
	}

	initValue(cellIndex) {
		if (this.isGridCell(cellIndex)) {
			this.value[cellIndex] = this.defaultValue ?? {};
		} else {
			this.value = this.defaultValue ?? {};
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

		this.dirty = true;
		this.validate(cellIndex);
	}

	hasValue(cellIndex) {
		return this.isGridCell(cellIndex) ? Util.isNotEmpty(this.value[cellIndex]) : Util.isNotEmpty(this.value);
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
	static ViewTypes = {
		ARRANGEMENT: "arrangement", // Just for arrangement for all members
		PANEL: "panel", // Normal display as form fields
		GRID: "grid", // Excel-like display
		SHARED_OPTION_TABLE: "sharedOptionTable", // All members has same options
		SHARED_LABEL_TABLE: "sharedLabelTable" // All members has same group which has same parameter type members
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
	get membersPerRow() {
		return this.#membersPerRow;
	}
	get expanded() {
		return this.#expanded;
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

	get showMembersPerRow() {
		return (
			this.viewType === GroupParameter.ViewTypes.ARRANGEMENT || this.viewType === GroupParameter.ViewTypes.PANEL
		);
	}

	setMemberOrders() {
		this.members.forEach((member, index) => (member.order = index + 1));
	}

	addMember(member) {
		switch (this.viewType) {
			case GroupParameter.ViewTypes.ARRANGEMENT:
			case GroupParameter.ViewTypes.PANEL: {
				member.displayType = Parameter.DisplayTypes.FORM_FIELD;
				break;
			}
			case GroupParameter.ViewTypes.GRID: {
				member.displayType = Parameter.DisplayTypes.GRID_CELL;
				break;
			}
			case GroupParameter.ViewTypes.SHARED_OPTION_TABLE: {
				member.displayType = Parameter.DisplayTypes.SHARED_OPTION_CELL;
				break;
			}
			case GroupParameter.ViewTypes.SHARED_LABEL_TABLE: {
				member.displayType = Parameter.DisplayTypes.SHARED_LABEL_CELL;
				break;
			}
		}

		member.parent = { name: this.paramName, version: this.paramVersion };

		this.members.push(member);

		this.setMemberOrders();

		console.log("Group addMember: ", this.members);
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

	removeMember({ paramName, paramVersion }) {
		let removed;

		this.members = this.members.filter((member) => {
			if (member.equalTo(paramName, paramVersion)) {
				removed = member;
				return Constant.FILTER_SKIP;
			} else if (member.isAssembly()) {
				removed = member.removeMember();
				if (removed) {
					return Constant.FILTER_SKIP;
				}
			}

			return Constant.FILTER_ADD;
		});

		this.setMemberOrders();

		console.log("Group removeMember: ", removed, paramName, paramVersion);
		return removed;
	}

	collectValues() {
		let output = {};
		this.members.forEach((member) => {
			output = { ...output, ...member.getOutput() };
		});

		if (this.isDecorative()) {
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

	parse(json) {
		super.parse(json);

		this.viewType = this.viewType ?? GroupParameter.ViewTypes.VERTICAL_PANEL;
		this.membersPerRow = json.membersPerRow ?? 1;
		this.expanded = json.expanded ?? false;

		if (Util.isNotEmpty(json.members)) {
			this.members = json.members.map((member) => {
				return Parameter.createParameter(member.paramType, member);
			});
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
