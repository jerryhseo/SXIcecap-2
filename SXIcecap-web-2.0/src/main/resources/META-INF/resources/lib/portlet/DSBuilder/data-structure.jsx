import React from "react";
import { Constant, ParamType } from "../../common/station-x";
import {
	AddressParameter,
	BooleanParameter,
	DateParameter,
	DualListParameter,
	FileParameter,
	GroupParameter,
	MatrixParameter,
	NumericParameter,
	PhoneParameter,
	SelectGroupParameter,
	SelectParameter,
	StringParameter
} from "../../parameter/parameter";

export class DataStructure {
	#paramDelimiter = ";";
	#paramDelimiterPosition = "end";
	#paramValueDelimiter = "=";
	#matrixBracketType = "[]";
	#matrixElementDelimiter = " ";
	#commentChar = "#";
	#parameters = [];
	#enableInputStatus = "";
	#enableGoTo = false;

	static getGroupMembers(groupId, flat = true) {}

	constructor(json) {}

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

	getParameterByOrder(parentId, order) {
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

	getParameterByName(parameters, name) {
		return parameters[name];
	}

	getParameterByNameVersion(parameters, name, version) {
		return parameters[paramName];
	}

	getMemberParameters(groupId) {}

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
	}

	toJSON() {
		let json = {};

		json.paramDelimiter = this.paramDelimiter;
		json.paramDelimiterPosition = this.paramDelimiterPosition;
		json.paramValueDelimiter = this.paramValueDelimiter;
		json.matrixBracketType = this.matrixBracketType;
		json.matrixElementDelimiter = this.matrixElementDelimiter;
		json.commentChar = this.commentChar;

		json.parameters = this.parameters.map((parameter) => parameter.toJSON());

		json.enableInputStatus = json.enableInputStatus;
		json.enableGoTo = this.enableGoTo;

		return json;
	}

	render() {
		return <></>;
	}
}
