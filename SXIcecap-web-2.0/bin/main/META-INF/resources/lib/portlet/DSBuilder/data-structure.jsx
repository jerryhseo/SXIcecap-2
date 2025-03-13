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
	#version = "1.0.0";

	static parse(fields) {
		return fields.map((field) => {
			return Parameter.createParameter(field.paramType, field);
		});
	}

	static loadFormData(parameters, formData) {
		if (Util.isEmpty(parameters) || !(parameters instanceof Array)) return;

		parameters.forEach((param) => {
			const value = formData[param.paramName];
			if (Util.isNotEmpty(value)) {
				param.loadData(value);
			}
		});
	}

	static findFormField(fields, fieldName, fieldVersion) {
		let found = null;

		fields.every((field) => {
			if (field.equalTo(fieldName, fieldVersion)) {
				found = field;
				return Constant.STOP_EVERY;
			}

			if (field.isAssembly()) {
				found = DataStructure.findFormField(field.members, fieldName, fieldVersion);
				if (found) {
					return Constant.STOP_EVERY;
				}
			}

			return Constant.CONTINUE_EVERY;
		});

		return found;
	}

	static setFormData(fields, paramName, paramVersion, value) {
		let parameter = DataStructure.findFormField(fields, paramName, paramVersion);

		if (parameter === null || parameter === undefined) return;

		parameter.setValue(value);
	}

	static setFormError(fields, paramName, paramVersion, error) {
		let parameter = DataStructure.findFormField(fields, paramName, paramVersion);

		if (parameter === null || parameter === undefined) return;

		parameter.setError(error);
	}

	static clearFormFieldError(formFields, paramName, paramVersion) {
		const parameter = DataStructure.findFormField(formFields, paramName, paramVersion);
		if (parameter === null || parameter === undefined) return;

		parameter.setError();

		console.log("clearFormFieldError: ", parameter);
	}

	static checkFormDataErrors(fields) {
		let error = {};

		fields.every((field) => {
			if (field.isAssembly()) {
				error = DataStructure.checkFormDataErrors(field.members);
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

	constructor(json) {
		if (json) {
			this.parse(json);
		}
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
	get version() {
		return this.#version;
	}

	set paramDelimiter(val) {
		this.#paramDelimiter = val;
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
	set version(val) {
		this.#version = val;
	}

	addParameter(parameter) {
		console.log("addParameter order: " + parameter.order, this.parameters.length);
		if (Util.isEmpty(parameter.order) || parameter.order < 1) {
			parameter.order = this.parameters.length + 1;
		}

		this.parameters.push(parameter);
	}

	removeParameter() {}

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

	parse(json) {
		this.paramDelimiter = json.paramDelimiter ?? this.paramDelimiter;
		this.paramDelimiterPosition = json.paramDelimiterPosition ?? this.paramDelimiterPosition;
		this.paramValueDelimiter = json.paramValueDelimiter ?? this.paramValueDelimiter;
		this.matrixBracketType = json.matrixBracketType ?? this.matrixBracketType;
		this.matrixElementDelimiter = json.matrixElementDelimiter ?? this.matrixElementDelimiter;
		this.commentChar = json.commentChar ?? this.commentChar;

		json.parameters.forEach((paramJSONObj) => {
			this.parameters.push(Parameter.createParameter(paramJSONObj.paramType, paramJSONObj));
		});

		this.enableInputStatus = json.enableInputStatus ?? false;
		this.enableGoTo = json.enableGoTo ?? false;
		this.version = json.version ?? "1.0.0";
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

		json.version = this.version;

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
		spritemap
	) {
		let goTo;
		this.enableGoTo = true;
		const items = ["Apple", "Banana", "Orange", "Pineapple", "Strawberry"];
		const value = "";
		if (this.enableGoTo) {
			goTo = (
				<SXAutoComplete
					namespace={namespace}
					languageId={languageId}
					availableLanguageIds={availableLanguageIds}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}

		const parameters = this.parameters;

		return (
			<>
				{/*goTo*/}
				<div id={previewCanvasId}>
					{parameters.map((parameter) => {
						console.log("parameter: ", parameter);
						return (
							<SXPreviewRow
								key={parameter.paramName}
								namespace={namespace}
								dsbuilderId={dsbuilderId}
								propertyPanelId={propertyPanelId}
								previewCanvasId={previewCanvasId}
								languageId={languageId}
								availableLanguageIds={availableLanguageIds}
								parameter={parameter}
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
				<div id={canvasId}>
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
