import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import Form, { ClayInput, ClayRadio, ClayRadioGroup, ClaySelectWithOption } from "@clayui/form";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import SXDSBuilderBasicPropertiesPanel from "./basic-properties-panel";
import SXDSBuilderTypeSpecificPanel from "./type-specific-properties-panel";
import SXDSBuilderOptionPropertiesPanel from "./option-properties-panel";
import SXDSBuilderValidationPanel from "./validation-builder-panel";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import { SXLabel, SXSelect } from "../../form/sxform";
import { SelectParameter } from "../../parameter/parameter";
import Button from "@clayui/button";
import { SXModalDialog } from "../../modal/sxmodal";

class GroupSelectorBody extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.workingParam.namespace;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;
		this.optionType = props.optionType ?? "radio";
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.options = this.convertGroupsToOptions();

		this.state = {
			selected: this.getOption(this.workingParam.parentName ? this.workingParam.parentName : "__top__")
		};
	}

	/**
	 * Gets groups as select options in the data structure parameters except of the working group parameter.
	 * "Top Level Group" should be added as first option.
	 *
	 * @param {{paramName: String, paramVersion:String}} param0
	 * @returns
	 */
	convertGroupsToOptions() {
		return [
			{ label: Util.translate("top-level"), paramName: "__top__", paramVersion: "" },
			...this.dataStructure
				.getGroups({
					paramName: this.workingParam.paramName,
					paramVersion: this.workingParam.paramVersion
				})
				.map((group) => ({
					label: group.label,
					paramName: group.paramName,
					paramVersion: group.paramVersion
				}))
		];
	}

	getOption(paramName) {
		console.log("getOption: ", this.options, "[" + paramName + "]");
		return this.options.filter((option) => option.paramName === paramName)[0];
	}

	handleGroupSelected(option) {
		console.log("handleGroupSelected: ", option);
		const srcGroup = Util.isEmpty(this.workingParam.parent)
			? this.dataStructure
			: this.dataStructure.findParameter(this.workingParam.parentName, this.workingParam.parentVersion);
		const targetGroup =
			option.paramName === "__top__"
				? this.dataStructure
				: this.dataStructure.findParameter(option.paramName, option.paramVersion);

		this.dataStructure.moveParameterGroup(this.workingParam, srcGroup, targetGroup);

		this.setState({ selected: option });
	}

	render() {
		console.log("GroupSelectorBody: ", this.options, this.state.selected, this.workingParam);
		if (this.optionType === "radio") {
			return (
				<div style={{ width: "100%" }}>
					{Util.convertArrayToRows(this.options, 2).map((row, index) => (
						<div
							key={index}
							style={{ width: "100%", display: "inline-flex", gap: "1.5rem" }}
						>
							{row.map((option) => {
								console.log("option: ", option);
								return (
									<ClayRadio
										key={Util.randomKey()}
										name={this.namespace + "group"}
										label={option.label}
										value={option.paramName}
										defaultChecked={option.paramName === this.state.selected.paramName}
										onChange={(e) => {
											e.stopPropagation();
											this.handleGroupSelected(option);
										}}
									/>
								);
							})}
						</div>
					))}
				</div>
			);
		}
	}
}

class SXDSBuilderPropertiesPanel extends React.Component {
	panelSteps = [
		{
			title: Util.translate("basic")
		},
		{
			title: Util.translate("type-specific")
		},
		{
			title: Util.translate("options")
		},
		{
			title: Util.translate("validation")
		}
	];

	constructor(props) {
		super(props);

		this.namespace = props.workingParam.namespace;
		this.formIds = props.formIds;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.dataStructure = props.dataStructure;
		this.workingParam = props.workingParam;

		this.state = {
			panelStep: 0,
			paramType: this.workingParam.paramType,
			openSelectGroupModal: false
		};

		console.log("SXDSBuilderPropertiesPanel.constructor: ", this.workingParam);
	}

	componentDidMount() {}

	handlePanelStepChange(step) {
		this.setState({ panelStep: step });
	}

	handleParamTypeSelect(value) {
		this.setState({ paramType: value });

		Event.fire(Event.SX_PARAM_TYPE_CHANGED, this.namespace, this.namespace, {
			targetFormId: this.formIds.dsbuilderId,
			paramType: value
		});
	}

	handleSelectGroup() {
		this.setState({ openSelectGroupModal: true });
	}

	renderPanelContent() {
		switch (this.state.panelStep) {
			case 0: {
				return (
					<SXDSBuilderBasicPropertiesPanel
						formIds={this.formIds}
						dataStructure={this.dataStructure}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case 1: {
				return (
					<SXDSBuilderTypeSpecificPanel
						formIds={this.formIds}
						dataStructure={this.dataStructure}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case 2: {
				return (
					<SXDSBuilderOptionPropertiesPanel
						formIds={this.formIds}
						dataStructure={this.dataStructure}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case 3: {
				return (
					<SXDSBuilderValidationPanel
						formIds={this.formIds}
						dataStructure={this.dataStructure}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
		}
	}

	render() {
		return (
			<>
				<Form.Group className="form-group-sm">
					<SXLabel
						label={Util.translate("parameter-type")}
						forHtml={this.namespace + ParamProperty.PARAM_TYPE}
						required={true}
						tooltip={Util.translate("parameter-type-tooltip")}
						spritemap={this.spritemap}
					/>
					<ClaySelectWithOption
						aria-label={Util.translate("parameter-type")}
						id={this.namespace + ParamProperty.PARAM_TYPE}
						options={Object.keys(ParamType).map((key) => ({
							label: ParamType[key],
							value: ParamType[key]
						}))}
						value={this.state.paramType}
						onChange={(e) => {
							this.handleParamTypeSelect(e.target.value);
						}}
						disabled={this.workingParam.order > 0}
						spritemap={this.spritemap}
					/>
				</Form.Group>
				<Form.Group style={{ marginBottom: "1.5rem" }}>
					<SXLabel
						label={Util.translate("group")}
						forHtml={this.namespace + ParamProperty.GROUP}
						required={true}
						tooltip={Util.translate("group-tooltip")}
						spritemap={this.spritemap}
					/>
					<ClayInput.Group style={{ paddingLeft: "1.0rem" }}>
						<ClayInput.GroupItem
							prepend
							style={{ padding: "5px", backgroundColor: "#effccf", justifyContent: "center" }}
						>
							{this.state.group ?? Util.translate("top-level")}
						</ClayInput.GroupItem>
						<ClayInput.GroupItem
							append
							shrink
						>
							<Button
								displayType="secondary"
								onClick={() => this.handleSelectGroup()}
								size="sm"
							>
								{Util.translate("select-group")}
							</Button>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				</Form.Group>
				{this.state.openSelectGroupModal && (
					<SXModalDialog
						header={Util.translate("select-group")}
						body={
							<GroupSelectorBody
								namespace={this.namespace}
								formIds={this.formIds}
								dataStructure={this.dataStructure}
								workingParam={this.workingParam}
								optionType="radio"
								spritemap={this.spritemap}
							/>
						}
						buttons={[
							{
								onClick: () => {
									this.setState({ openSelectGroupModal: false });

									Event.fire(Event.SX_REFRESH_FORM, this.namespace, this.namespace, {
										targetFormId: this.formIds.previewCanvasId
									});
								},
								label: Util.translate("ok"),
								displayType: "primary"
							}
						]}
						status="info"
						disableAutoClose="false"
						spritemap={this.spritemap}
					/>
				)}
				<ClayMultiStepNav style={{ paddingTop: "1.5rem", border: "2px solid #a9aaab" }}>
					{this.panelSteps.map(({ subTitle, title }, i) => {
						let panelStep = this.state.panelStep < 0 ? 0 : this.state.panelStep;
						const complete = i < this.state.panelStep;

						return (
							<ClayMultiStepNav.Item
								active={panelStep === i}
								expand={i + 1 !== this.panelSteps.length}
								key={i}
								state={complete ? "complete" : undefined}
							>
								<ClayMultiStepNav.Title>{title}</ClayMultiStepNav.Title>
								<ClayMultiStepNav.Divider />
								<ClayMultiStepNav.Indicator
									complete={complete}
									label={i + 1}
									onClick={() => this.handlePanelStepChange(i)}
									subTitle={subTitle}
								/>
							</ClayMultiStepNav.Item>
						);
					})}
				</ClayMultiStepNav>
				{this.renderPanelContent()}
			</>
		);
	}
}

export default SXDSBuilderPropertiesPanel;
