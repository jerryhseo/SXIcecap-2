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
	#members = [];
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
	get members() {
		return this.#members;
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
	set members(val) {
		this.#members = val;
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
		if (Util.isEmpty(this.members)) return;

		this.members.forEach((param) => {
			const value = values[param.paramName];
			if (Util.isNotEmpty(value)) {
				param.loadData(value);
			}
		});
	}

	findParameter(paramName, paramVersion) {
		const getParam = (params) => {
			let found = null;

			params.every((field) => {
				if (field.equalTo(paramName, paramVersion)) {
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
		};

		return getParam(this.members);
	}

	setParameterValue(paramName, paramVersion, value) {
		let parameter = this.findFormField(paramName, paramVersion);

		if (parameter === null || parameter === undefined) return;

		parameter.setValue(value);
	}

	clearParameterValues() {
		this.members.forEach((field) => {
			if (field.isAssembly()) {
				this.clearParameterValues(field.members);
			} else {
				field.clearValue();
			}
		});
		console.log("clearParameterValues: ", this.members);
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

		return checkParamErrors(this.members);
	}

	setMemberOrders() {
		this.members.forEach((member, index) => (member.order = index + 1));
	}

	addMember(parameter) {
		parameter.displayType = Parameter.DisplayTypes.FORM_FIELD;
		parameter.refreshKey();
		this.members.push(parameter);

		parameter.parent = {};
		this.setMemberOrders();
		this.refreshKey();
	}

	removeMember({ paramName, paramVersion }) {
		let removed;
		let remained = [];
		this.members.forEach((param) => {
			if (param.equalTo(paramName, paramVersion)) {
				removed = param;
			} else {
				remained.push(param);
			}
		});

		this.members = remained;

		this.setMemberOrders();

		return removed;
	}

	getParameterByOrder(groupId, order) {
		let retrieved = null;

		this.members.every((param) => {
			if (param.order === order) {
				retrieved = param;
				return Constant.STOP_EVERY;
			}
			return Constant.CONTINUE_EVERY;
		});

		return retrieved;
	}

	countParameters() {
		return this.members.length;
	}

	/**
	 *
	 * @param {*} name
	 * @param {*} version
	 * @returns
	 */
	getParameter(name, version) {
		function search(members) {
			let retrieved = null;
			members.every((param) => {
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

		return search(this.members);
	}

	getDescendantParameters(groupId) {
		let groupParam;
		if (Util.isNotEmpty(groupId)) {
			groupParam = this.getParameter(groupId.name, groupId.version);
		}

		if (Util.isEmpty(groupParam)) {
			return this.members.filter((param) => Util.isEmpty(param.parent));
		} else {
			let param = this.getParameter(groupId.name, groupId.version);
			return param.members;
		}
	}

	getSiblingParameters({ groupName = "", groupVersion = "", paramName, paramVersion }) {
		let siblings;

		if (!groupName) {
			siblings = this.members;
		} else {
			const group = this.findParameter(groupName, groupVersion);
			siblings = group.members;
		}

		return siblings.filter((param) => !(param.paramName === paramName && param.paramVersion === paramVersion));
	}

	getSiblingGroups({ groupName = "", groupVersion = "", paramName, paramVersion }) {
		let siblings;

		if (!groupName) {
			siblings = this.members;
		} else {
			const group = this.findParameter(groupName, groupVersion);
			siblings = group.members;
		}

		return siblings.filter(
			(param) => param.isAssembly() && (param.paramName !== paramName || param.paramVersion !== paramVersion)
		);
	}

	getChildParameters({ paramName, paramVersion }) {
		if (Util.isEmpty(paramName)) {
			return this.members;
		} else {
			const groupParam = this.getParameter(paramName, paramVersion);

			return groupParam.members;
		}
	}

	getSiblingParamsAsSelectItems({ groupName = "", groupVersion = "", paramName, paramVersion }) {
		const siblings = this.getSiblingParameters({
			groupName: groupName,
			groupVersion: groupVersion,
			paramName: paramName,
			paramVersion: paramVersion
		});

		return siblings.map((param) => param.convertToSelectItem());
	}

	getSiblingGroupsAsSelectItems({ groupName = "", groupVersion = "", paramName, paramVersion }) {
		const param = this.getParameter(paramName, paramVersion);

		const siblings = this.getSiblingGroups({
			groupName: groupName,
			groupVersion: groupVersion,
			paramName: paramName,
			paramVersion: paramVersion
		});

		return siblings.map((param) => param.convertToSelectItem());
	}

	getGroupsAsSelectItems({ paramName, paramVersion }) {
		let groups = [];

		const pickUpGroup = (params) => {
			params.forEach((param) => {
				if (param.isAssembly()) {
					if (param.paramName !== paramName || param.paramVersion !== paramVersion) {
						groups.push({ label: param.label, value: param.paramName });
					}

					pickUpGroup(param.members);
				}
			});
		};

		pickUpGroup(this.members);

		console.log("picked groups: ", groups);
		return groups;
	}

	getGroups({ paramName, paramVersion }) {
		let groups = [];

		const pickUpGroup = (params) => {
			params.forEach((param) => {
				if (param.isAssembly()) {
					if (!param.equalTo(paramName, paramVersion)) {
						groups.push(param);
					}

					pickUpGroup(param.members);
				}
			});
		};

		pickUpGroup(this.members);

		return groups;
	}

	moveParameterGroup(param, srcGroup, targetGroup) {
		console.log("moveParameterGroup: ", param, srcGroup, targetGroup);
		targetGroup.addMember(srcGroup.removeMember({ paramName: param.paramName, paramVersion: param.paramVersion }));
	}

	countTotalFields(group) {
		let inputCount = 0;
		const members = !!group ? group.members : this.members;

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
		const members = !!group ? group.members : this.members;

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
		const members = !!rootGroup ? rootGroup.members : this.members;
		let items = [];

		members.forEach((param) => {
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

	focusParameter(params, paramName, paramVersion) {
		params.forEach((param) => {
			const focused = param.paramName === paramName && param.paramVersion === paramVersion;
			if (param.focused !== focused) {
				param.focused = focused;
				param.refreshKey();
			}

			if (param.isAssembly()) {
				this.focusParameter(param.members, paramName, paramVersion);
			}
		});

		this.refreshKey();
	}

	parse(json) {
		this.paramDelimiter = json.paramDelimiter ?? this.paramDelimiter;
		this.paramDelimiterPosition = json.paramDelimiterPosition ?? this.paramDelimiterPosition;
		this.paramValueDelimiter = json.paramValueDelimiter ?? this.paramValueDelimiter;

		json.members.forEach((paramJSONObj) => {
			this.members.push(
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

		json.members = this.members.map((parameter) => parameter.toJSON());

		if (this.enableInputStatus) json.enableInputStatus = this.enableInputStatus;
		if (this.enableGoTo) json.enableGoTo = this.enableGoTo;

		return json;
	}

	renderPreview({ dsbuilderId, propertyPanelId, previewCanvasId, className, style, spritemap }) {
		return (
			<>
				{this.members.map((parameter) => {
					let position = "middle";
					if (parameter.order === 1) {
						position = "start";
					} else if (parameter.order === this.countParameters()) {
						position = "end";
					}
					return parameter.renderPreview({
						dsbuilderId: dsbuilderId,
						propertyPanelId: propertyPanelId,
						previewCanvasId: previewCanvasId,
						className: className,
						style: style,
						spritemap: spritemap,
						inputStatus: this.enableInputStatus,
						position: position
					});
				})}
			</>
		);
	}

	render({ canvasId, events, className, style, spritemap }) {
		return (
			<div id={canvasId}>
				{this.members.map((parameter) =>
					parameter.render({
						events: events,
						className: className,
						style: style,
						spritemap: spritemap,
						inputStatus: this.enableInputStatus
					})
				)}
			</div>
		);
	}
}
