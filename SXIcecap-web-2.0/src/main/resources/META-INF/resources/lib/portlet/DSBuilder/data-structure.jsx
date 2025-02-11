import React from "react";
import { Constant, ParamType } from "../../common/station-x";
import { Parameter } from "../../parameter/parameter";

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

	static parse(fields) {
		return fields.map((field) => {
			return Parameter.createParameter(field.paramType, field);
		});
	}

	static loadData(parameters, data) {
		if (Util.isEmpty(parameters) || !(parameters instanceof Array)) return;

		parameters.forEach((param) => {
			param.loadData(data);
		});
	}

	static findFormField(fields, fieldName, fieldVersion) {
		let found = null;

		fields.every((field) => {
			if (field.equalTo(fieldName, fieldVersion)) {
				found = field;
				return Constant.STOP_EVERY;
			}
			return Constant.CONTINUE_EVERY;
		});

		return found;
	}

	static setFormData(fields, parentId, paramId, value) {
		let parameter = null;

		if (Util.isEmpty(parentId)) {
			parameter = DataStructure.findFormField(fields, paramId.name, paramId.version);
		} else {
			let parentParam = DataStructure.findFormField(fields, parentId.name, parentId.version);
			if (Util.isEmpty(parentParam)) return;

			parameter = DataStructure.findFormField(parentParam.members, paramId.name, paramId.version);
		}

		if (Util.isEmpty(parameter)) return;

		parameter.setValue(value);
	}

	static setFormError(fields, parentId, paramId, error) {
		let parameter = null;

		if (Util.isEmpty(parentId)) {
			parameter = DataStructure.findFormField(fields, paramId.name, paramId.version);
		} else {
			let parentParam = DataStructure.findFormField(fields, parentId.name, parentId.version);
			if (Util.isEmpty(parentParam)) return;

			parameter = DataStructure.findFormField(parentParam.members, paramId.name, paramId.version);
		}

		if (Util.isEmpty(parameter)) return;

		parameter.setError(error);
	}

	static checkFormDataErrors(fields) {
		let error = "";

		fields.every((field) => {
			if (field.isAssembly()) {
				error = DataStructure.checkFormDataErrors(fields.members);
				if (error) {
					return Constant.STOP_EVERY;
				}
			} else {
				if (field.hasError()) {
					error = field.error;
					return Constant.STOP_EVERY;
				}
			}

			return Constant.CONTINUE_EVERY;
		});

		return error;
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
	 * @param {*} parameters
	 * @param {*} name
	 * @param {*} version
	 * @returns
	 */
	getParameter(name, version) {
		function search(parameters) {
			let retrieved = null;
			params.every((param) => {
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

				return CONTINUE_EVERY;
			});

			return retrieved;
		}

		return search(this.parameters);
	}

	getParameters(groupId) {
		if (Util.isEmpty(groupId)) {
			return this.parameters;
		} else {
			let param = this.getParameter(this.parameters, groupId.name, groupId.version);
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
			this.parameters.push(DataStructure.createParameter(paramJSONObj.paramType, paramJSONObj));
		});

		this.enableInputStatus = json.enableInputStatus ?? this.enableInputStatus;
		this.enableGoTo = json.enableGoTo ?? this.enableGoTo;
		this.hierarchicalData = json.hierarchicalData ?? this.hierarchicalData;
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

	render() {
		return <></>;
	}
}
