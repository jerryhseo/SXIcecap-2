import React from "react";
import { Util } from "../../stationx/util";
import { Event, ParamProperty, ParamType } from "../../stationx/station-x";
import SXFormField, { SXDualListBox, SXInput, SXLabel } from "../../stationx/form";
import {
	AddressParameter,
	BooleanParameter,
	GroupParameter,
	Parameter,
	SelectParameter
} from "../../stationx/parameter";
import { ClayButtonWithIcon } from "@clayui/button";
import { Body, Button, Cell, Head, Icon, Table } from "@clayui/core";
import Form, { ClayInput, ClaySelectWithOption } from "@clayui/form";
import { SXModalDialog } from "../../stationx/modal";
import SXActionDropdown from "../../stationx/dropdown";

class SXGroupBuilder extends React.Component {
	constructor(props) {
		super(props);

		this.groupParam = props.groupParam;

		this.namespace = this.groupParam.namespace;
		this.languageId = this.groupParam.languageId;
		this.availableLanguageIds = this.groupParam.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.availableParamTypes = props.availableParamTypes;
		this.memberDisplayType = props.memberDisplayType;

		this.formId = this.namespace + "groupBuilder";

		this.state = {
			selectedMember: this.groupParam.getMember(0)
		};

		this.memberReadyTypes = [
			{
				label: Util.translate("select-to-add-member"),
				value: ""
			},
			...this.availableParamTypes.map((paramType) => ({
				label: paramType,
				value: paramType
			}))
		];

		this.fieldMemberCode = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.STRING,
			{
				paramName: "memberCode",
				displayName: Util.getTranslationObject(this.languageId, "member-code"),
				tooltip: Util.getTranslationObject(this.languageId, "member-code-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "code-name-for-member"),
				value: this.state.selectedMember ? this.state.selectedMember.paramName : ""
			}
		);
		this.fieldMemberDisplayName = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.STRING,
			{
				paramName: "memberDisplayName",
				displayName: Util.getTranslationObject(this.languageId, "display-name"),
				tooltip: Util.getTranslationObject(this.languageId, "display-name-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "translation-for-display-name"),
				localized: true,
				value: this.state.selectedMember ? this.state.selectedMember.displayName : {}
			}
		);

		this.copyMember = this.copyMember.bind(this);
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace) {
			return;
		} else {
			if (dataPacket.targetFormId === this.formId) {
				/*
				console.log(
					"SXGroupBuilder SX_FIELD_VALUE_CHANGED: ",
					dataPacket,
					this.state.selectedMember,
					this.fieldMemberCode,
					this.fieldMemberDisplayName
				);
				*/

				switch (dataPacket.paramName) {
					case "memberCode": {
						this.state.selectedMember.paramName = this.fieldMemberCode.getValue();

						break;
					}
					case "memberDisplayName": {
						this.state.selectedMember.displayName = this.fieldMemberDisplayName.getValue();

						break;
					}
				}
			} else if (dataPacket.targetFormId === this.groupParam.tagName) {
			} else {
				return;
			}
		}

		if (this.groupParam.isRendered()) {
			this.groupParam.fireRefreshPreview();
		}

		this.forceUpdate();
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	moveMemberUp = (member) => {
		this.groupParam.moveMemberUp(member.order);

		this.groupParam.fireRefreshPreview();

		this.forceUpdate();
	};

	moveMemberDown = (member) => {
		this.groupParam.moveMemberDown(member.order);

		this.groupParam.fireRefreshPreview();

		this.forceUpdate();
	};

	removeMember = (member) => {
		let memberCount = this.groupParam.removeMember({ paramName: member.paramName });

		const firstMember = memberCount > 0 ? this.groupParam.members[0] : null;

		this.setState({ selectedMember: firstMember });

		this.groupParam.fireRefreshPreview();

		this.forceUpdate();
	};

	copyMember(member) {
		let copied = this.groupParam.copyMember({ memOrder: member.order - 1 });
		this.groupParam.fireRefreshPreview();

		this.setState({ selectedMember: copied });
	}

	handleMemberSelected(member) {
		this.setState({ selectedMember: member });
	}

	handleMemberTypeSelect(memberType) {
		if (!memberType) {
			return;
		}

		const member = Parameter.createParameter(
			this.namespace,
			this.groupParam.tagName,
			this.languageId,
			this.availableLanguageIds,
			memberType,
			{
				paramName: "member_" + Util.randomKey(8),
				displayType: this.memberDisplayType
			}
		);

		this.groupParam.addMember(member);

		member.displayName = Util.getTranslationObject(
			this.languageId,
			"member_" + member.order.toString().padStart(2, "0")
		);

		this.groupParam.fireRefreshPreview();

		this.setState({ selectedMember: member });
	}

	render() {
		if (this.state.selectedMember) {
			this.fieldMemberCode.setValue({ value: this.state.selectedMember.paramName });
			this.fieldMemberCode.refreshKey();
			this.fieldMemberDisplayName.setValue({ value: this.state.selectedMember.displayName });
			this.fieldMemberDisplayName.refreshKey();
		}

		return (
			<>
				<div className="sx-option-builder-title">{Util.translate("group-builder")}</div>
				<Form.Group className="form-group-sm">
					<SXLabel
						label={Util.translate("add-member")}
						forHtml={this.namespace + "memberType"}
						tooltip={Util.translate("add-member-tooltip")}
						spritemap={this.spritemap}
					/>
					<div style={{ paddingLeft: "10px" }}>
						<ClaySelectWithOption
							aria-label={Util.translate("member-type")}
							id={this.namespace + "memberType"}
							options={this.memberReadyTypes}
							value={this.state.selectedMember ? this.state.selectedMember.paramType : ""}
							onChange={(e) => {
								this.handleMemberTypeSelect(e.target.value);
							}}
							style={{ paddingLeft: "10px" }}
							spritemap={this.spritemap}
						/>
					</div>
				</Form.Group>
				{this.groupParam.memberCount > 0 && (
					<>
						{this.fieldMemberCode.renderField({ spritemap: this.spritemap })}
						{this.fieldMemberDisplayName.renderField({ spritemap: this.spritemap })}
					</>
				)}
				<div className="sx-option-builder-label">
					<SXLabel
						label={Util.translate("members")}
						forHtml=""
						required={true}
						style={{
							fontWeight: "600",
							fontSize: "0.875rem"
						}}
						spritemap={this.spritemap}
					/>
				</div>
				<div
					className="sx-table"
					style={{ marginLeft: "10px" }}
				>
					<div>
						{this.groupParam.members.map((member, index) => {
							let actionItems = [
								{ id: "copy", name: Util.translate("copy"), symbol: "copy", action: this.copyMember },
								{
									id: "delete",
									name: Util.translate("delete"),
									symbol: "times",
									action: this.removeMember
								}
							];
							if (member.order > 1) {
								actionItems.push({
									id: "up",
									name: Util.translate("move-up"),
									symbol: "caret-top",
									action: this.moveMemberUp
								});
							}
							if (member.order < this.groupParam.memberCount) {
								actionItems.push({
									id: "down",
									name: Util.translate("move-down"),
									symbol: "caret-bottom",
									action: this.moveMemberDown
								});
							}

							let className = "autofit-row";
							if (member === this.state.selectedMember) {
								className += " sx-option-focused";
							}

							return (
								<div
									key={member.paramName}
									className={className}
									onClick={(e) => {
										this.handleMemberSelected(member);
									}}
								>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "2rem" }}
									>
										{member.order}
									</div>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "4rem" }}
									>
										{member.paramType}
									</div>
									<div className="autofit-col autofit-col-expand sx-table-cell">{member.label}</div>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "auto" }}
									>
										<SXActionDropdown
											key={this.groupParam.memberCount - index}
											namespace={this.namespace}
											actionItems={actionItems}
											dataKey={member}
											symbol="ellipsis-v"
											spritemap={this.spritemap}
										/>
									</div>
								</div>
							);
						})}
					</div>
				</div>
			</>
		);
	}
}

class SXSelectOptionBuilder extends React.Component {
	constructor(props) {
		super(props);

		this.workingParam = props.workingParam;

		this.namespace = this.workingParam.namespace;
		this.formIds = props.formIds;
		this.languageId = this.workingParam.languageId;
		this.availableLanguageIds = this.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.locales = this.availableLanguageIds.map((locale) => ({
			label: locale,
			symbol: locale.toLowerCase()
		}));

		this.state = {
			selectedOption: this.workingParam.getOption(0) ?? {},
			optionValueDuplicated: false
		};

		this.formId = this.namespace + "selectOptionBuilder";
		this.fieldOptionLabel = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.STRING,
			{
				paramName: "optionLabel",
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "option-label"),
				placeholder: Util.getTranslationObject(this.languageId, "label-for-the-option"),
				value: this.state.selectedOption.label
			}
		);
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = Event.pickUpDataPacket(e, this.namespace, this.formId, "optionLabel");

		if (!dataPacket) {
			return;
		}

		//console.log("SXSelectOptionBuilder SX_FIELD_VALUE_CHANGED: ", dataPacket);

		this.state.selectedOption.label = this.fieldOptionLabel.getValue();
		this.forceUpdate();
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	handleNewOption() {
		this.fieldOptionLabel.setValue({ value: {} });
		this.fieldOptionLabel.refreshKey();

		this.setState({
			selectedOption: {}
		});
	}

	handleAddOption() {
		const optionLength = this.workingParam.addOption(this.state.selectedOption);
		if (optionLength.length === 0) {
			return;
		}

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	}

	copyOption = (index) => {
		this.setState({
			selectedOption: this.workingParam.copyOption(index)
		});

		this.workingParam.fireRefreshPreview();
	};

	moveOptionUp = (index) => {
		this.workingParam.moveOptionUp(index);

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	};

	moveOptionDown = (index) => {
		this.workingParam.moveOptionDown(index);

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	};

	removeOption = (index) => {
		let optionCount = this.workingParam.removeOption(index);
		this.fieldOptionLabel.setValue({ value: {} });
		this.fieldOptionLabel.refreshKey();

		this.setState({
			selectedOption: {}
		});

		this.workingParam.fireRefreshPreview();
	};

	handleOptionSelected(option) {
		this.fieldOptionLabel.setValue({ value: option.label });
		this.fieldOptionLabel.refreshKey();

		this.setState({
			selectedOption: option
		});
	}

	handleOptionValueChanged(val) {
		const duplicate = this.workingParam.checkDuplicatedOptionValue(val);
		if (duplicate) {
			this.setState({ optionValueDuplicated: true });

			return;
		}

		this.state.selectedOption.value = val;

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	}

	render() {
		this.fieldOptionLabel.setValue({ value: this.state.selectedOption.label });
		this.fieldOptionLabel.refreshKey();

		return (
			<>
				<div className="sx-option-builder-title">{Util.translate("option-builder")}</div>
				<div className="sx-option-builder-label">
					<SXLabel
						label={Util.translate("options")}
						forHtml=""
						required={true}
						style={{
							fontWeight: "600",
							fontSize: "0.875rem"
						}}
						spritemap={this.spritemap}
					/>
				</div>
				<div className="sx-option-preview">
					{this.workingParam.options.map((option, index) => {
						let actionItems = [
							{
								id: "copy", //
								name: Util.translate("copy"),
								symbol: "copy",
								action: this.copyOption
							},
							{
								id: "delete", //
								name: Util.translate("delete"),
								symbol: "times",
								action: this.removeOption
							}
						];
						if (index > 0) {
							actionItems.push({
								id: "up",
								name: Util.translate("moveUp"),
								symbol: "order-arrow-up",
								action: this.moveOptionUp
							});
						}
						if (index < this.workingParam.options.length - 1) {
							actionItems.push({
								id: "down",
								name: Util.translate("moveDown"),
								symbol: "order-arrow-down",
								action: this.moveOptionDown
							});
						}

						return (
							<div
								key={option.value}
								aria-hidden="undefined"
								className={
									option === this.state.selectedOption
										? "sx-option-preview-row sx-option-focused"
										: "sx-option-preview-row"
								}
								onClick={(e) => {
									this.handleOptionSelected(option);
								}}
							>
								<div
									className="sx-option-preview-cell"
									style={{ width: "50%" }}
								>
									{option.label[this.languageId]}
								</div>
								<div
									className="sx-option-preview-cell"
									style={{ minWidth: "40%" }}
								>
									{option.value}
								</div>
								<div
									className="sx-option-preview-cell"
									style={{ width: "auto" }}
								>
									<SXActionDropdown
										key={this.workingParam.options.length - index}
										namespace={this.namespace}
										actionItems={actionItems}
										dataKey={index}
										symbol="ellipsis-v"
										spritemap={this.spritemap}
									/>
								</div>
							</div>
						);
					})}
				</div>
				<Button.Group
					spaced
					className="sx-option-builder-btn-group"
				>
					<Button
						aria-label={Util.translate("add-option")}
						displayType="secondary"
						size="sm"
						onClick={(e) => {
							e.stopPropagation();
							this.handleAddOption();
						}}
						title={Util.translate("add-option")}
						disabled={Util.isNotEmpty(this.state.selectedOption)}
					>
						<Icon
							symbol="caret-top"
							spritemap={this.props.spritemap}
						/>
					</Button>
					<ClayButtonWithIcon
						aria-label={Util.translate("new-option")}
						size="sm"
						symbol="plus"
						title={Util.translate("new-option")}
						onClick={(e) => {
							e.stopPropagation();
							this.handleNewOption();
						}}
						spritemap={this.props.spritemap}
						style={{ leftMargin: "auto" }}
					/>
				</Button.Group>

				{this.fieldOptionLabel.renderField({
					spritemap: this.spritemap
				})}

				<Form.Group>
					<SXLabel
						label={Util.translate("option-value")}
						spritemap={this.props.spritemap}
					/>
					<ClayInput
						key={Util.randomKey()}
						placeholder={Util.translate("option-value")}
						defaultValue={this.state.selectedOption.value ?? ""}
						onBlur={(e) => {
							e.stopPropagation();
							this.handleOptionValueChanged(e.target.value);
						}}
					/>
				</Form.Group>
				{this.state.optionValueDuplicated && (
					<SXModalDialog
						header={Util.translate("error")}
						body={Util.translate("option-value-is-already-exist-try-another-value")}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: (e) => {
									this.setState({ optionValueDuplicated: false });
								},
								displayType: "secondary"
							}
						]}
					/>
				)}
			</>
		);
	}
}

class SXStringTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.workingParam = props.workingParam;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "stringTypeOptionForm";

		this.fields = {
			placeholder: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.PLACEHOLDER,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "placeholder"),
					tooltip: Util.getTranslationObject(this.languageId, "placeholder-tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "placeholder"),
					value: this.workingParam.placeholder
				}
			),

			multipleLine: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.MULTIPLE_LINE,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "multiple-line"),
					tooltip: Util.getTranslationObject(this.languageId, "multiple-line-tooltip"),
					defalutValue: false,
					value: this.workingParam.multipleLine
				}
			),

			localized: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.LOCALIZED,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "localized"),
					tooltip: Util.getTranslationObject(this.languageId, "localized-tooltip"),
					defalutValue: false,
					value: this.workingParam.localized
				}
			),
			prefix: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.PREFIX,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "prefix"),
					tooltip: Util.getTranslationObject(this.languageId, "prefix-tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "prefix"),
					value: this.workingParam.prefix
				}
			),
			postfix: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.POSTFIX,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "postfix"),
					tooltip: Util.getTranslationObject(this.languageId, "postfix-tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "postfix"),
					value: this.workingParam.postfix
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		//("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ", dataPacket, this.workingParam);

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		const fields = Object.values(this.fields);

		return <>{fields.map((field) => field.renderField({ spritemap: this.spritemap }))}</>;
	}
}

class SXNumericTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.state = {
			isInteger: this.workingParam.isInteger
		};

		this.formId = this.workingParam.namespace + "numericTypeOptionForm";

		this.fields = {
			isInteger: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.IS_INTEGER,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "integer"),
					tooltip: Util.getTranslationObject(this.languageId, "integer-tooltip"),
					value: this.workingParam.isInteger
				}
			),

			uncertainty: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.UNCERTAINTY,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "uncertainty"),
					tooltip: Util.getTranslationObject(this.languageId, "uncertainty-tooltip"),
					value: this.workingParam.uncertainty
				}
			),

			decimalPlaces: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.NUMERIC,
				{
					paramName: ParamProperty.DECIMAL_PLACES,
					isInteger: true,
					displayName: Util.getTranslationObject(this.languageId, "decimal-places"),
					tooltip: Util.getTranslationObject(this.languageId, "decimal-places-tooltip"),
					value: this.workingParam.decimalPlaces
				}
			),

			unit: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.UNIT,
					displayName: Util.getTranslationObject(this.languageId, "unit"),
					tooltip: Util.getTranslationObject(this.languageId, "unit-tooltip"),
					value: this.workingParam.unit
				}
			),
			prefix: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.PREFIX,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "prefix"),
					tooltip: Util.getTranslationObject(this.languageId, "prefix-tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "prefix"),
					value: this.workingParam.prefix
				}
			),
			postfix: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.POSTFIX,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "postfix"),
					tooltip: Util.getTranslationObject(this.languageId, "postfix-tooltip"),
					placeholder: Util.getTranslationObject(this.languageId, "postfix"),
					value: this.workingParam.postfix
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		//console.log("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ", dataPacket, this.workingParam);

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (dataPacket.paramName === ParamProperty.IS_INTEGER) {
			this.setState({ isInteger: this.workingParam.isInteger });
		}

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		const fields = Object.values(this.fields);

		return (
			<>
				{fields.map((field) => {
					if (field.paramName === ParamProperty.DECIMAL_PLACES && !this.state.isInteger) {
						return field.renderField({ spritemap: this.spritemap });
					} else if (field.paramName !== ParamProperty.DECIMAL_PLACES) {
						return field.renderField({ spritemap: this.spritemap });
					}
				})}
			</>
		);
	}
}

class SXSelectTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "selectTypeOptionForm";

		const viewTypes = [
			{
				label: Util.getTranslationObject(this.languageId, "Dropdown"),
				value: SelectParameter.ViewTypes.DROPDOWN
			},
			{
				label: Util.getTranslationObject(this.languageId, "Radio"),
				value: SelectParameter.ViewTypes.RADIO
			},
			{
				label: Util.getTranslationObject(this.languageId, "Checkbox"),
				value: SelectParameter.ViewTypes.CHECKBOX
			}
		];

		if (this.workingParam.displayType !== Parameter.DisplayTypes.GRID_CELL) {
			viewTypes.push({
				label: Util.getTranslationObject(this.languageId, "Listbox"),
				value: SelectParameter.ViewTypes.LISTBOX
			});
		}

		this.fields = {
			viewType: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.SELECT,
				{
					paramName: ParamProperty.VIEW_TYPE,
					viewType: SelectParameter.ViewTypes.RADIO,
					options: viewTypes,
					optionsPerRow: 2,
					displayName: Util.getTranslationObject(this.languageId, "view-type"),
					tooltip: Util.getTranslationObject(this.languageId, "select-view-type-tooltip"),
					value: this.workingParam.viewType ?? SelectParameter.ViewTypes.DROPDOWN,
					validation: {
						required: {
							value: true,
							message: Util.getTranslationObject(this.languageId, "this-field-is-required")
						}
					}
				}
			),
			optionsPerRow: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.NUMERIC,
				{
					paramName: ParamProperty.OPTIONS_PER_ROW,
					isInteger: true,
					displayName: Util.getTranslationObject(this.languageId, "options-per-row"),
					tooltip: Util.getTranslationObject(this.languageId, "options-per-row-tooltip"),
					defaultValue: 0,
					value: this.workingParam.optionsPerRow,
					min: "0",
					max: this.workingParam.optionCount.toString()
				}
			)
		};
	}

	displayOptionsPerRow() {
		return (
			this.workingParam.viewType === BooleanParameter.ViewTypes.CHECKBOX ||
			this.workingParam.viewType === BooleanParameter.ViewTypes.RADIO
		);
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fields[dataPacket.paramName],
			this.fields[dataPacket.paramName].getValue()
		);
		*/

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();
		//this.workingParam.initValue();

		this.forceUpdate();

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		return (
			<>
				{this.fields.viewType.renderField({ spritemap: this.spritemap })}
				{this.displayOptionsPerRow() &&
					this.fields.optionsPerRow.renderField({
						spritemap: this.spritemap
					})}
				<SXSelectOptionBuilder
					namespace={this.namespace}
					formIds={this.formIds}
					workingParam={this.workingParam}
					spritemap={this.spritemap}
				/>
			</>
		);
	}
}

class SXBooleanTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "booleanTypeOptionForm";

		this.fields = {
			viewType: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.SELECT,
				{
					paramName: ParamProperty.VIEW_TYPE,
					viewType: SelectParameter.ViewTypes.RADIO,
					options: [
						{
							label: Util.getTranslationObject(this.languageId, "Checkbox"),
							value: BooleanParameter.ViewTypes.CHECKBOX
						},
						{
							label: Util.getTranslationObject(this.languageId, "Toggle"),
							value: BooleanParameter.ViewTypes.TOGGLE
						},
						{
							label: Util.getTranslationObject(this.languageId, "Dropdown"),
							value: BooleanParameter.ViewTypes.DROPDOWN
						},
						{
							label: Util.getTranslationObject(this.languageId, "Radio"),
							value: BooleanParameter.ViewTypes.RADIO
						}
					],
					optionsPerRow: 2,
					displayName: Util.getTranslationObject(this.languageId, "view-type"),
					tooltip: Util.getTranslationObject(this.languageId, "select-view-type-tooltip"),
					value: this.workingParam.viewType ?? SelectParameter.ViewTypes.CHECKBOX,
					validation: {
						required: {
							value: true,
							message: Util.getTranslationObject(this.languageId, "this-field-is-required")
						}
					}
				}
			),
			trueLabel: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.TRUE_LABEL,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "true-label"),
					placeholder: Util.getTranslationObject(this.languageId, "label-for-true-option"),
					tooltip: Util.getTranslationObject(this.languageId, "label-for-true-option-tooltip"),
					value: this.workingParam.trueLabel
				}
			),

			falseLabel: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.STRING,
				{
					paramName: ParamProperty.FALSE_LABEL,
					localized: true,
					displayName: Util.getTranslationObject(this.languageId, "false-label"),
					placeholder: Util.getTranslationObject(this.languageId, "label-for-false-option"),
					tooltip: Util.getTranslationObject(this.languageId, "label-for-false-option-tooltip"),
					value: this.workingParam.falseLabel
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fields[dataPacket.paramName].getValue()
		);
		*/

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		return (
			<>
				{this.fields.viewType.renderField({ spritemap: this.spritemap })}
				{this.fields.trueLabel.renderField({ spritemap: this.spritemap })}
				{this.fields.falseLabel.renderField({ spritemap: this.spritemap })}
			</>
		);
	}
}

class SXPhoneTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "phoneTypeOptionForm";

		this.fields = {
			enableCountryNo: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.ENABLE_COUNTRY_NO,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "enable-country-no"),
					tooltip: Util.getTranslationObject(this.languageId, "enable-country-no-tooltip"),
					defaultValue: false,
					value: this.workingParam.enableCountryNo
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fields[dataPacket.paramName].getValue()
		);
		*/

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		return <>{this.fields.enableCountryNo.renderField({ spritemap: this.spritemap })}</>;
	}
}

class SXAddressTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "addressTypeOptionForm";

		this.fields = {
			viewType: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.SELECT,
				{
					paramName: ParamProperty.VIEW_TYPE,
					viewType: SelectParameter.ViewTypes.RADIO,
					displayName: Util.getTranslationObject(this.languageId, "view-type"),
					options: [
						{
							label: Util.getTranslationObject(this.languageId, "Block"),
							value: AddressParameter.ViewTypes.BLOCK
						},
						{
							label: Util.getTranslationObject(this.languageId, "In Line"),
							value: AddressParameter.ViewTypes.INLINE
						},
						{
							label: Util.getTranslationObject(this.languageId, "One Line"),
							value: AddressParameter.ViewTypes.ONE_LINE
						}
					],
					tooltip: Util.getTranslationObject(this.languageId, "view-type-tooltip"),
					defaultValue: AddressParameter.ViewTypes.BLOCK,
					value: this.workingParam.viewType
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fields[dataPacket.paramName].getValue()
		);
		*/

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		return <>{this.fields.viewType.renderField({ spritemap: this.spritemap })}</>;
	}
}

class SXDateTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "dateTypeOptionForm";

		this.fields = {
			enableTime: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.BOOLEAN,
				{
					paramName: ParamProperty.ENABLE_TIME,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "enable-time"),
					tooltip: Util.getTranslationObject(this.languageId, "enable-time-tooltip"),
					defaultValue: false,
					value: this.workingParam.enableTime
				}
			),
			startYear: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.NUMERIC,
				{
					paramName: ParamProperty.START_YEAR,
					displayName: Util.getTranslationObject(this.languageId, "start-year"),
					isInteger: true,
					tooltip: Util.getTranslationObject(this.languageId, "start-year-tooltip"),
					defaultValue: "1970",
					value: this.workingParam.startYear
				}
			),
			endYear: Parameter.createParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				ParamType.NUMERIC,
				{
					paramName: ParamProperty.END_YEAR,
					displayName: Util.getTranslationObject(this.languageId, "end-year"),
					isInteger: true,
					tooltip: Util.getTranslationObject(this.languageId, "end-year-tooltip"),
					value: this.workingParam.endYear
				}
			)
		};
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fields[dataPacket.paramName].getValue()
		);
		*/

		this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

		if (this.workingParam.isRendered()) {
			this.workingParam.initValue();
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		return (
			<>
				{this.fields.enableTime.renderField({ spritemap: this.spritemap })}
				{this.fields.startYear.renderField({ spritemap: this.spritemap })}
				{this.fields.endYear.renderField({ spritemap: this.spritemap })}
			</>
		);
	}
}

class SXGroupTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.dataStructure = props.dataStructure;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "groupTypeOptionForm";

		this.availableMemberTypes = Object.keys(ParamType).map((key) => ParamType[key]);

		this.fieldViewType = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.SELECT,
			{
				paramName: ParamProperty.VIEW_TYPE,
				viewType: SelectParameter.ViewTypes.RADIO,
				displayName: Util.getTranslationObject(this.languageId, "view-type"),
				options: [
					{
						label: Util.getTranslationObject(this.languageId, "Arrangement"),
						value: GroupParameter.ViewTypes.ARRANGEMENT
					},
					{
						label: Util.getTranslationObject(this.languageId, "Panel"),
						value: GroupParameter.ViewTypes.PANEL
					},
					{
						label: Util.getTranslationObject(this.languageId, "Table"),
						value: GroupParameter.ViewTypes.TABLE
					}
				],
				optionsPerRow: 2,
				tooltip: Util.getTranslationObject(this.languageId, "view-type-tooltip"),
				defaultValue: AddressParameter.ViewTypes.PANEL,
				value: this.workingParam.viewType
			}
		);

		this.fieldMembersPerRow = Parameter.createParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.NUMERIC,
			{
				paramName: ParamProperty.MEMBERS_PER_ROW,
				isInteger: true,
				displayName: Util.getTranslationObject(this.languageId, "members-per-row"),
				tooltip: Util.getTranslationObject(this.languageId, "members-per-row-tooltip"),
				defaultValue: 1,
				value: this.workingParam.membersPerRow
			}
		);

		this.fieldExpanded = Parameter.createParameter(
			this.namespace,
			this.formIds.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			ParamType.BOOLEAN,
			{
				paramName: ParamProperty.EXPANDED,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "expanded"),
				tooltip: Util.getTranslationObject(this.languageId, "expanded-tooltip"),
				value: this.workingParam.showDefinition
			}
		);
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			return;
		}

		/*
		console.log(
			"SXGroupTypeOptionForm SX_FIELD_VALUE_CHANGED: ",
			dataPacket,
			this.workingParam,
			this.fieldMembersPerRow.getValue()
		);
		*/

		switch (dataPacket.paramName) {
			case ParamProperty.VIEW_TYPE: {
				this.workingParam.viewType = this.fieldViewType.getValue();
				break;
			}
			case ParamProperty.MEMBERS_PER_ROW: {
				this.workingParam.membersPerRow = this.fieldMembersPerRow.getValue();
				break;
			}
			case ParamProperty.EXPANDED: {
				this.workingParam.expanded = this.fieldExpanded.getValue();
				break;
			}
		}

		if (this.workingParam.isRendered()) {
			this.workingParam.fireRefreshPreview();
		}
	};

	componentDidMount() {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	render() {
		let memberDisplayType = Parameter.DisplayTypes.FORM_FIELD;

		if (this.workingParam.viewType === GroupParameter.ViewTypes.TABLE) {
			memberDisplayType = Parameter.DisplayTypes.TABLE_ROW;
		}

		return (
			<>
				{this.fieldViewType.renderField({ spritemap: this.spritemap })}
				{this.workingParam.showMembersPerRow &&
					this.fieldMembersPerRow.renderField({ spritemap: this.spritemap })}
				{this.fieldExpanded.renderField({ spritemap: this.spritemap })}
				<SXGroupBuilder
					groupParam={this.workingParam}
					spritemap={this.spritemap}
					availableParamTypes={this.availableMemberTypes}
					memberDisplayType={memberDisplayType}
				/>
			</>
		);
	}
}

class SXGridTypeOptionForm extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.workingParam = props.workingParam;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.formId = this.workingParam.namespace + "gridTypeOptionForm";

		this.availableColumnTypes = [
			ParamType.STRING,
			ParamType.NUMERIC,
			ParamType.BOOLEAN,
			ParamType.SELECT,
			ParamType.ADDRESS,
			ParamType.FILE,
			ParamType.DATE,
			ParamType.EMAIL
		];
	}

	render() {
		return (
			<SXGroupBuilder
				groupParam={this.workingParam}
				spritemap={this.spritemap}
				availableParamTypes={this.availableColumnTypes}
				memberDisplayType={Parameter.DisplayTypes.GRID_CELL}
			/>
		);
	}
}

class SXDSBuilderTypeSpecificPanel extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;
	}

	componentDidMount() {}

	render() {
		switch (this.workingParam.paramType) {
			case ParamType.LOCALIZED_STRING:
			case ParamType.STRING: {
				return (
					<SXStringTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.NUMERIC: {
				return (
					<SXNumericTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.SELECT: {
				return (
					<SXSelectTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.BOOLEAN: {
				return (
					<SXBooleanTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.PHONE: {
				return (
					<SXPhoneTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.ADDRESS: {
				return (
					<SXAddressTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.DATE: {
				return (
					<SXDateTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.GROUP: {
				return (
					<SXGroupTypeOptionForm
						formIds={this.formIds}
						dataStructure={this.dataStructure}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.GRID: {
				return (
					<SXGridTypeOptionForm
						formIds={this.formIds}
						workingParam={this.workingParam}
						spritemap={this.spritemap}
					/>
				);
			}
		}

		return <div>{"No specified properties for this parameter type."}</div>;
	}
}

export default SXDSBuilderTypeSpecificPanel;
