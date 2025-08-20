import React from "react";
import { Constant, ParamType } from "../../stationx/station-x";
import { GroupParameter } from "../../stationx/parameter";
import { Util } from "../../stationx/util";

export class DataStructure extends GroupParameter {
	static ViewTypes = {
		BAREBONE: "barebone"
	};

	static GotoBasis = {
		PARAM_NAME: "paramName",
		DISPLAY_NAME: "displayName"
	};

	#dataStructureId = 0;
	#paramDelimiter = ";";
	#paramDelimiterPosition = "end";
	#paramValueDelimiter = "=";
	#enableInputStatus = false;
	#enableGoTo = false;
	#hierarchicalData = false;

	constructor(namespace, formId, languageId, availableLanguageIds, paramType = ParamType.GROUP) {
		super(namespace, formId, languageId, availableLanguageIds, paramType);
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
	get enableInputStatus() {
		return this.#enableInputStatus;
	}
	get enableGoTo() {
		return this.#enableGoTo;
	}
	get hierarchicalData() {
		return this.#hierarchicalData;
	}
	get dataStructureId() {
		return this.#dataStructureId;
	}
	get dataStructureName() {
		return this.paramName;
	}
	get dataStructureVersion() {
		return this.paramVersion;
	}
	get description() {
		return this.definition;
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
	set enableInputStatus(val) {
		this.#enableInputStatus = val;
	}
	set enableGoTo(val) {
		this.#enableGoTo = val;
	}
	set hierarchicalData(val) {
		this.#hierarchicalData = val;
	}
	set dataStructureId(val) {
		this.#dataStructureId = val;
	}
	set dataStructureName(val) {
		this.paramName = val;
	}
	set dataStructureVersion(val) {
		this.paramVersion = val;
	}
	set description(val) {
		this.definition = val;
	}

	initProperties(json) {
		this.parse(json);
	}

	checkDuplicateParam(param) {
		let duplicated = false;

		this.members.every((member) => {
			if (param !== member) {
				duplicated = member.checkDuplicateParam(param);
			}

			return duplicated ? Constant.STOP_EVERY : Constant.CONTINUE_EVERY;
		});

		return duplicated;
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
			(param) => param.isGroup && (param.paramName !== paramName || param.paramVersion !== paramVersion)
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

	getGroups({ paramName, paramVersion }) {
		let groups = [];

		const pickUpGroup = (params) => {
			params.forEach((param) => {
				if (param.isGroup) {
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

	getGotoAutoCompleteItems(rootGroup, basis = DataStructure.GotoBasis.PARAM_NAME) {
		const members = !!rootGroup ? rootGroup.members : this.members;
		let items = [];

		members.forEach((param) => {
			if (param.isGroup) {
				items = items.concat(this.getGotoAutoCompleteItems(param, basis));
			}

			basis === DataStructure.GotoBasis.PARAM_NAME
				? items.push({ name: param.paramName, version: param.paramVersion })
				: items.push({ name: param.getDisplayName(this.languageId), version: param.paramVersion });
		});

		console.log("getGotoAutoCompleteItems: ", rootGroup, basis, items);
		return items;
	}

	toData() {}

	parse(json = {}) {
		super.parse(json);

		this.viewType = DataStructure.ViewTypes.BAREBONE;
		this.parent = {};

		this.paramDelimiter = json.paramDelimiter ?? ";";
		this.paramDelimiterPosition = json.paramDelimiterPosition ?? "end";
		this.paramValueDelimiter = json.paramValueDelimiter ?? "=";

		this.dataStructureId = json.dataStructureId;
		this.enableInputStatus = json.enableInputStatus ?? false;
		this.enableGoTo = json.enableGoTo ?? false;
	}

	toJSON() {
		let json = super.toJSON();

		if (this.paramDelimiter !== ";") json.paramDelimiter = this.paramDelimiter;
		if (this.paramDelimiterPosition !== "end") json.paramDelimiterPosition = this.paramDelimiterPosition;
		if (this.paramValueDelimiter !== "=") json.paramValueDelimiter = this.paramValueDelimiter;

		json.dataStructureId = this.dataStructureId;
		if (this.enableInputStatus) json.enableInputStatus = this.enableInputStatus;
		if (this.enableGoTo) json.enableGoTo = this.enableGoTo;

		return json;
	}

	renderPreview({ dsbuilderId, propertyPanelId, previewCanvasId, className, style, spritemap }) {
		return (
			<>
				{this.members.map((parameter) => {
					parameter.inputStatus = this.enableInputStatus;
					parameter.position = this.getMemberPosition(parameter);

					return parameter.renderPreview({
						dsbuilderId: dsbuilderId,
						propertyPanelId: propertyPanelId,
						previewCanvasId: previewCanvasId,
						className: className,
						style: style,
						spritemap: spritemap
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
