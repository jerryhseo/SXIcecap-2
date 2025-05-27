import React from "react";
import { Constant, ParamType, ValidationKeys } from "../../common/station-x";
import { Parameter } from "../../parameter/parameter";
import { Util } from "../../common/util";
import ClayForm from "@clayui/form";
import ClayAutocomplete, { Autocomplete } from "@clayui/autocomplete";
import ClayAutocompleteInput from "@clayui/autocomplete/lib/Input";
import ClayAutocompleteDropDown from "@clayui/autocomplete/lib/DropDown";
import ClayDropDownItemList from "@clayui/drop-down/lib/ItemList";
import ClayDropDownItem from "@clayui/drop-down/lib/Item";
import { SXAutoComplete, SXPreviewRow } from "../../form/sxform";
import { createRoot } from "react-dom/client";

export class DataStructure {
	static GotoBasis = {
		PARAM_NAME: "paramName",
		DISPLAY_NAME: "displayName"
	};

	#key = Util.randomKey();
	#namespace = "";
	#formId = "";
	#languageId;
	#availableLanguageIds;
	#paramDelimiter = ";";
	#paramDelimiterPosition = "end";
	#paramValueDelimiter = "=";
	#matrixBracketType = "[]";
	#matrixElementDelimiter = " ";
	#commentChar = "#";
	#parameters = [];
	#enableInputStatus = false;
	#enableGoTo = false;
	#hierarchicalData = false;

	static parse(fields) {
		return fields.map((field) => {
			return Parameter.createParameter(field.paramType, field);
		});
	}

	static toStructuredData(fields) {
		let json = {};

		fields.forEach((field) => {
			const value = field.getOutput();
			if (Util.isNotEmpty(value)) {
				json = { ...json, ...value };
			}
		});

		console.log("toStructuredData: ", fields, json);
		return json;
	}

	constructor(namespace, formId, languageId, availableLanguageIds, json) {
		this.#namespace = namespace;
		this.#formId = formId;
		this.#languageId = languageId;
		this.#availableLanguageIds = availableLanguageIds;

		if (json) {
			this.parse(json);
		}
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
	get paramDelimiter() {
		return this.#paramDelimiter;
	}
	get paramDelimiterPosition() {
		return this.#paramDelimiterPosition;
	}
	get paramValueDelimiter() {
		return this.#paramValueDelimiter;
	}
	get matrixBracketType() {
		return this.#matrixBracketType;
	}
	get matrixElementDelimiter() {
		return this.#matrixElementDelimiter;
	}
	get commentChar() {
		return this.#commentChar;
	}
	get parameters() {
		return this.#parameters;
	}
	get enableInputStatus() {
		return this.#enableInputStatus;
	}
	get enableGoTo() {
		return this.#enableGoTo;
	}
	get hierarchicalData() {
		return this.#hierarchicalData;
	}

	set paramDelimiter(val) {
		this.#paramDelimiter = val;
	}
	set namespace(val) {
		this.#namespace = val;
	}
	set formId(val) {
		this.#formId = val;
	}
	set paramDelimiterPosition(val) {
		this.#paramDelimiterPosition = val;
	}
	set paramValueDelimiter(val) {
		this.#paramValueDelimiter = val;
	}
	set matrixBracketType(val) {
		this.#matrixBracketType = val;
	}
	set matrixElementDelimiter(val) {
		this.#matrixElementDelimiter = val;
	}
	set commentChar(val) {
		this.#commentChar = val;
	}
	set parameters(val) {
		this.#parameters = val;
	}
	set enableInputStatus(val) {
		this.#enableInputStatus = val;
	}
	set enableGoTo(val) {
		this.#enableGoTo = val;
	}
	set hierarchicalData(val) {
		this.#hierarchicalData = val;
	}

	refreshKey() {
		this.#key = Util.randomKey();
	}

	loadParameterValues(values) {
		if (Util.isEmpty(this.parameters)) return;

		this.parameters.forEach((param) => {
			const value = values[param.paramName];
			if (Util.isNotEmpty(value)) {
				param.loadData(value);
			}
		});
	}

	findParameter(paramName, paramVersion) {
		function getParam(params, name, version) {
			let found = null;

			params.every((field) => {
				if (field.equalTo(name, version)) {
					found = field;
					return Constant.STOP_EVERY;
				}

				if (field.isAssembly()) {
					found = getParam(field.members, field.paramName, field.paramVersion);
					if (found) {
						return Constant.STOP_EVERY;
					}
				}

				return Constant.CONTINUE_EVERY;
			});

			return found;
		}

		return getParam(this.parameters, paramName, paramVersion);
	}

	setParameterValue(paramName, paramVersion, value) {
		let parameter = this.findFormField(paramName, paramVersion);

		if (parameter === null || parameter === undefined) return;

		parameter.setValue(value);
	}

	clearParameterValues() {
		this.parameters.forEach((field) => {
			if (field.isAssembly()) {
				this.clearParameterValues(field.members);
			} else {
				field.clearValue();
			}
		});
		console.log("clearParameterValues: ", this.parameters);
	}

	setParameterError(paramName, paramVersion, error) {
		let parameter = this.findFormField(paramName, paramVersion);

		if (parameter === null || parameter === undefined) return;

		parameter.setError(error);
	}

	clearParameterError(paramName, paramVersion) {
		const parameter = this.findParameter(paramName, paramVersion);
		if (parameter === null || parameter === undefined) return;

		parameter.clearError();

		console.log("clearFormFieldError: ", parameter);
	}

	checkParameterErrors() {
		function checkParamErrors(params) {
			let error;

			params.every((field) => {
				if (field.isAssembly()) {
					error = checkParamErrors(field.members);
					if (Util.isNotEmpty(error)) {
						return Constant.STOP_EVERY;
					}
				} else {
					if (field.hasError()) {
						error = {
							fieldName: field.paramName,
							fieldVersion: field.paramVersion,
							parentId: field.parent,
							message: field.error
						};

						return Constant.STOP_EVERY;
					} else if (field.required && !field.hasValue()) {
						error = {
							fieldName: field.paramName,
							fieldVersion: field.paramVersion,
							parentId: field.parent,
							message: field.validation.required.message
						};
						return Constant.STOP_EVERY;
					}
				}

				return Constant.CONTINUE_EVERY;
			});

			return error;
		}

		return checkParamErrors(this.parameters);
	}

	addParameter(parameter) {
		console.log("addParameter order: " + parameter.order, this.parameters.length);
		if (Util.isEmpty(parameter.order) || parameter.order < 1) {
			parameter.order = this.parameters.length + 1;
		}

		this.parameters.push(parameter);

		this.refreshKey();
	}

	removeParameter() {
		this.refreshKey();
	}

	getParameterByOrder(groupId, order) {
		let retrieved = null;

		this.parameters.every((param) => {
			if (param.order === order) {
				retrieved = param;
				return Constant.STOP_EVERY;
			}
			return Constant.CONTINUE_EVERY;
		});

		return retrieved;
	}

	countParameters() {
		return this.parameters.length;
	}

	/**
	 *
	 * @param {*} name
	 * @param {*} version
	 * @returns
	 */
	getParameter(name, version) {
		function search(parameters) {
			let retrieved = null;
			parameters.every((param) => {
				if (param.equalTo(name, version)) {
					retrieved = param;
					return Constant.STOP_EVERY;
				}

				if (param.isAssembly()) {
					retrieved = search(param.members);

					if (Util.isNotEmpty(retrieved)) {
						return Constant.STOP_EVERY;
					}
				}

				return Constant.CONTINUE_EVERY;
			});

			return retrieved;
		}

		return search(this.parameters);
	}

	getDescendantParameters(groupId) {
		let groupParam;
		if (Util.isNotEmpty(groupId)) {
			groupParam = this.getParameter(groupId.name, groupId.version);
		}

		if (Util.isEmpty(groupParam)) {
			return this.parameters.filter((param) => Util.isEmpty(param.parent));
		} else {
			let param = this.getParameter(groupId.name, groupId.version);
			return param.members;
		}
	}

	getSiblingParameters(paramName, paramVersion, selfInclude = false) {
		const parameter = this.getParameter(paramName, paramVersion);
		const siblings = this.getChildParameters(parameter.groupId);

		if (selfInclude) {
			return siblings;
		} else {
			return siblings.filter((param) => param.paramName !== paramName || param.paramVersion !== paramVersion);
		}
	}

	getChildParameters(groupId) {
		if (Util.isEmpty(groupId)) {
			return this.parameters;
		} else {
			const groupParam = this.getParameter(groupId.name, groupId.version);

			return groupParam.members;
		}
	}
	countTotalFields(group) {
		let inputCount = 0;
		const members = !!group ? group.members : this.parameters;

		members.forEach((param) => {
			if (param.isAssembly()) {
				inputCount += this.countTotalFields(param);
			} else {
				inputCount++;
			}
		});

		return inputCount;
	}

	countFilledFields(group) {
		let inputCount = 0;
		const members = !!group ? group.members : this.parameters;

		members.forEach((param) => {
			if (param.isAssembly()) {
				inputCount += this.countFilledFields(param);
			} else {
				if (param.hasValue()) {
					inputCount++;
				}
			}
		});

		return inputCount;
	}

	getGotoAutoCompleteItems(rootGroup, basis = DataStructure.GotoBasis.PARAM_NAME) {
		const parameters = !!rootGroup ? rootGroup.members : this.parameters;
		let items = [];

		parameters.forEach((param) => {
			if (param.isAssembly()) {
				items = items.concat(this.getGotoAutoCompleteItems(param, basis));
			}

			basis === DataStructure.GotoBasis.PARAM_NAME
				? items.push({ name: param.paramName, version: param.paramVersion })
				: items.push({ name: param.getDisplayName(this.languageId), version: param.paramVersion });
		});

		console.log("getGotoAutoCompleteItems: ", rootGroup, basis, items);
		return items;
	}

	focusParameter(paramName, paramVersion) {
		this.parameters.forEach((param) => {
			const focused = param.paramName === paramName && param.paramVersion === paramVersion;
			if (param.focused !== focused) {
				param.refreshKey();
				param.focused = focused;
			}
		});

		this.refreshKey();
	}

	parse(json) {
		this.paramDelimiter = json.paramDelimiter ?? this.paramDelimiter;
		this.paramDelimiterPosition = json.paramDelimiterPosition ?? this.paramDelimiterPosition;
		this.paramValueDelimiter = json.paramValueDelimiter ?? this.paramValueDelimiter;
		this.matrixBracketType = json.matrixBracketType ?? this.matrixBracketType;
		this.matrixElementDelimiter = json.matrixElementDelimiter ?? this.matrixElementDelimiter;
		this.commentChar = json.commentChar ?? this.commentChar;

		json.parameters.forEach((paramJSONObj) => {
			this.parameters.push(
				Parameter.createParameter(
					this.namespace,
					this.formId,
					this.languageId,
					this.availableLanguageIds,
					paramJSONObj.paramType,
					paramJSONObj
				)
			);
		});

		this.enableInputStatus = json.enableInputStatus ?? false;
		this.enableGoTo = json.enableGoTo ?? false;
	}

	toJSON() {
		let json = {};

		if (this.paramDelimiter !== ";") json.paramDelimiter = this.paramDelimiter;
		if (this.paramDelimiterPosition !== "end") json.paramDelimiterPosition = this.paramDelimiterPosition;
		if (this.paramValueDelimiter !== "=") json.paramValueDelimiter = this.paramValueDelimiter;
		if (this.matrixBracketType !== "[]") json.matrixBracketType = this.matrixBracketType;
		if (this.matrixElementDelimiter !== " ") json.matrixElementDelimiter = this.matrixElementDelimiter;
		if (this.commentChar !== "#") json.commentChar = this.commentChar;

		json.parameters = this.parameters.map((parameter) => parameter.toJSON());

		if (this.enableInputStatus) json.enableInputStatus = this.enableInputStatus;
		if (this.enableGoTo) json.enableGoTo = this.enableGoTo;

		return json;
	}

	renderPreview(dsbuilderId, propertyPanelId, previewCanvasId, className, style, spritemap, workingParamOrder) {
		return (
			<div id={previewCanvasId}>
				{this.parameters.map((parameter, i) => {
					console.log("parameter: ", parameter, parameter.hasValue());
					return (
						<SXPreviewRow
							key={parameter.key}
							dsbuilderId={dsbuilderId}
							propertyPanelId={propertyPanelId}
							previewCanvasId={previewCanvasId}
							parameter={parameter}
							focus={i + 1 === workingParamOrder ? true : false}
							spritemap={spritemap}
							inputStatus={this.enableInputStatus}
						/>
					);
				})}
			</div>
		);
	}

	render(canvasId, events, className, style, spritemap) {
		return (
			<>
				<div id={canvasId}>
					{this.parameters.map((parameter) =>
						parameter.render(
							this.namespace,
							this.languageId,
							this.availableLanguageIds,
							null,
							null,
							events,
							className,
							style,
							spritemap,
							this.enableInputStatus
						)
					)}
				</div>
			</>
		);
	}
}
