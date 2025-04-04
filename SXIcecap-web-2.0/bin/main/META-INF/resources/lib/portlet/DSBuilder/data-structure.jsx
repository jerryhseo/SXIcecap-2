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
	#key = Util.randomKey();
	#namespace = "";
	#formId = "";
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

	constructor(namespace, formId, json) {
		this.#namespace = namespace;
		this.#formId = formId;

		if (json) {
			this.parse(namespace, formId, json);
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

		this.#key = Util.randomKey();
	}

	removeParameter() {
		this.#key = Util.randomKey();
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

	getMemberParameters(groupId) {
		if (Util.isEmpty(groupId)) {
			return this.parameters;
		} else {
			let param = this.getParameter(groupId.name, groupId.version);
			return param.members;
		}
	}

	parse(namespace, formId, json) {
		this.paramDelimiter = json.paramDelimiter ?? this.paramDelimiter;
		this.paramDelimiterPosition = json.paramDelimiterPosition ?? this.paramDelimiterPosition;
		this.paramValueDelimiter = json.paramValueDelimiter ?? this.paramValueDelimiter;
		this.matrixBracketType = json.matrixBracketType ?? this.matrixBracketType;
		this.matrixElementDelimiter = json.matrixElementDelimiter ?? this.matrixElementDelimiter;
		this.commentChar = json.commentChar ?? this.commentChar;

		json.parameters.forEach((paramJSONObj) => {
			this.parameters.push(Parameter.createParameter(namespace, formId, paramJSONObj.paramType, paramJSONObj));
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

	renderPreview(
		namespace, //
		dsbuilderId,
		propertyPanelId,
		previewCanvasId,
		languageId,
		availableLanguageIds,
		className,
		style,
		spritemap,
		workingParamOrder
	) {
		let goTo;
		this.enableGoTo = true;
		const items = ["Apple", "Banana", "Orange", "Pineapple", "Strawberry"];
		const value = "";
		if (this.enableGoTo) {
			goTo = (
				<SXAutoComplete
					key={this.key}
					namespace={namespace}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}

		return (
			<>
				{/*goTo*/}
				<div id={previewCanvasId}>
					{this.parameters.map((parameter, i) => {
						console.log("parameter: ", parameter);
						return (
							<SXPreviewRow
								key={parameter.key}
								namespace={namespace}
								dsbuilderId={dsbuilderId}
								propertyPanelId={propertyPanelId}
								previewCanvasId={previewCanvasId}
								languageId={languageId}
								availableLanguageIds={availableLanguageIds}
								parameter={parameter}
								focus={i + 1 === workingParamOrder ? true : false}
								spritemap={spritemap}
							/>
						);
					})}
				</div>
			</>
		);
	}

	render(namespace, canvasId, languageId, availableLanguageIds, events, className, style, spritemap) {
		let goTo;
		this.enableGoTo = true;
		const items = ["Apple", "Banana", "Orange", "Pineapple", "Strawberry"];
		const value = "";
		if (this.enableGoTo) {
			goTo = (
				<SXAutoComplete
					key={this.key}
					namespace={namespace}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}
		return (
			<>
				{/*goTo*/}
				<div
					id={canvasId}
					style={{ zIndex: "-10" }}
				>
					{this.parameters.map((parameter) =>
						parameter.render(
							namespace,
							languageId,
							availableLanguageIds,
							tagId,
							tagName,
							events,
							className,
							style,
							spritemap
						)
					)}
				</div>
			</>
		);
	}
}
