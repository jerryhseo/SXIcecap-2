import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../stationx/util";
import Form, { ClayInput, ClayRadio, ClayRadioGroup, ClaySelectWithOption } from "@clayui/form";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import SXDSBuilderBasicPropertiesPanel from "./basic-properties-panel";
import SXDSBuilderTypeSpecificPanel from "./type-specific-properties-panel";
import SXDSBuilderOptionPropertiesPanel from "./option-properties-panel";
import SXDSBuilderValidationPanel from "./validation-builder-panel";
import { Event, ParamProperty, ParamType } from "../../stationx/station-x";
import { SXLabel, SXSelect } from "../../stationx/form";
import { GroupParameter, Parameter, SelectParameter } from "../../stationx/parameter";
import Button from "@clayui/button";
import { SXModalDialog } from "../../stationx/modal";

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
			selected: this.getOption(
				this.workingParam.parentName ? this.workingParam.parentName : GroupParameter.ROOT_GROUP
			)
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
			{
				label: Util.translate("top-level"),
				paramName: GroupParameter.ROOT_GROUP,
				paramVersion: Parameter.DEFAULT_VERSION
			},
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
		return this.options.filter((option) => option.paramName === paramName)[0];
	}

	handleGroupSelected(option) {
		const srcGroup = this.dataStructure.findParameter({
			paramName: this.workingParam.parentName,
			paramVersion: this.workingParam.parentVersion,
			descendant: true
		});
		const targetGroup = this.dataStructure.findParameter({
			paramName: option.paramName,
			paramVersion: option.paramVersion,
			descendant: true
		});

		this.dataStructure.moveParameterGroup(this.workingParam, srcGroup, targetGroup);

		this.setState({ selected: option });
	}

	render() {
		if (this.optionType === "radio") {
			return (
				<div style={{ width: "100%" }}>
					{Util.convertArrayToRows(this.options, 2).map((row, index) => (
						<div
							key={index}
							style={{ width: "100%", display: "inline-flex", gap: "1.5rem" }}
						>
							{row.map((option) => {
								//console.log("option: ", option);
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

		this.formId = this.formIds.propertyPanelId;
	}

	selectGroupHandler = (e) => {
		if (e.dataPacket.targetPortlet !== this.namespace || e.dataPacket.targetFormId !== this.formId) {
			return;
		}

		this.setState({ openSelectGroupModal: true });
	};

	refreshPropertyPanelHandler = (e) => {
		if (e.dataPacket.targetPortlet !== this.namespace || e.dataPacket.targetFormId !== this.formId) {
			return;
		}

		this.workingParam = e.dataPacket.workingParam;

		this.setState({ paramType: this.workingParam.paramType });
	};

	componentDidMount() {
		//console.log("componentDidMount: SXDSBuilderPropertiesPanel");

		Event.on(Event.SX_SELECT_GROUP, this.selectGroupHandler);
		Event.on(Event.SX_REFRESH_PROPERTY_PANEL, this.refreshPropertyPanelHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_SELECT_GROUP, this.selectGroupHandler);
		Event.detach(Event.SX_REFRESH_PROPERTY_PANEL, this.refreshPropertyPanelHandler);
	}

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
						key={this.workingParam.key}
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
						key={this.workingParam.key}
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
						key={this.workingParam.key}
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
						key={this.workingParam.key}
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
		//console.log("SXDSBuilderPropertiesPanel rendered");
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
					<div style={{ paddingLeft: "10px" }}>
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
							style={{ paddingLeft: "10px" }}
							spritemap={this.spritemap}
						/>
					</div>
				</Form.Group>
				{this.workingParam.displayType !== Parameter.DisplayTypes.GRID_CELL && (
					<Form.Group style={{ marginBottom: "1.5rem" }}>
						<SXLabel
							label={Util.translate("group")}
							forHtml={this.namespace + ParamProperty.GROUP}
							required={true}
							tooltip={Util.translate("group-tooltip")}
							spritemap={this.spritemap}
						/>
						<ClayInput.Group style={{ paddingLeft: "10px" }}>
							<ClayInput.GroupItem
								prepend
								style={{ padding: "5px", backgroundColor: "#effccf", justifyContent: "center" }}
							>
								{this.state.group ?? Util.translate("root")}
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
				)}
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
				<div style={{ maxHeight: "700px", overflowY: "auto", overflowX: "hidden" }}>
					{this.renderPanelContent()}
				</div>
			</>
		);
	}
}

export default SXDSBuilderPropertiesPanel;
