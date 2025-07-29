import React, { useLayoutEffect } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import SXFormField, { SXDualListBox, SXInput, SXLabel } from "../../form/sxform";
import {
	AddressParameter,
	BooleanParameter,
	DualListParameter,
	GroupParameter,
	NumericParameter,
	Parameter,
	SelectParameter,
	StringParameter
} from "../../parameter/parameter";
import { ClayButtonWithIcon } from "@clayui/button";
import { Body, Button, Cell, Head, Icon, Table } from "@clayui/core";
import DropDown from "@clayui/drop-down";
import LocalizedInput from "@clayui/localized-input";
import Form, { ClayInput, ClaySelectWithOption } from "@clayui/form";
import { SXModalDialog } from "../../modal/sxmodal";
import { Row } from "@clayui/core/lib/table/Row";
import SXDropdown from "../../modal/sxdropdown";

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

		this.selectedOption = {};
		let selectedOptionIndex = -1;
		if (Util.isNotEmpty(this.workingParam.options)) {
			this.selectedOption = this.workingParam.getOption(0);
			selectedOptionIndex = 0;
		}

		this.state = {
			selectedOptionIndex: selectedOptionIndex,
			duplicatedValueState: false
		};

		this.formId = this.namespace + "selectOptionBuilder";
		this.fieldOptionLabel = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: "optionLabel",
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "option-label"),
				placeholder: Util.getTranslationObject(this.languageId, "label-for-the-option"),
				value: this.selectedOption.label
			}
		);

		this.activeDropdown = false;
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = Event.pickUpDataPacket(e, this.namespace, this.formId, "optionLabel");

			if (!dataPacket) {
				return;
			}

			console.log("SXSelectOptionBuilder SX_FIELD_VALUE_CHANGED: ", dataPacket);

			this.selectedOption.label = this.fieldOptionLabel.getValue();
			this.forceUpdate();
		});

		Event.uniqueOn(Event.SX_POP_ACTION_CLICKED, (e) => {
			const dataPacket = e.dataPacket;

			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			const rowIndex = dataPacket.targetData;

			switch (dataPacket.actionId) {
				case "copy": {
					this.copyOption(rowIndex);
					break;
				}
				case "delete": {
					this.removeOption(rowIndex);
					break;
				}
				case "up": {
					this.moveUpOption(rowIndex);
					break;
				}
				case "down": {
					this.moveDownOption(rowIndex);
					break;
				}
			}

			this.activeDropdown = false;
		});

		Event.uniqueOn(Event.SX_POP_ACTION_CLICKED, (e) => {
			const dataPacket = e.dataPacket;

			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			this.activeDropdown = dataPacket.activeDropdown;
		});
	}

	handleNewOption() {
		this.selectedOption = {};
		this.fieldOptionLabel.setValue({ value: {} });
		this.fieldOptionLabel.refreshKey();

		this.setState({
			selectedOptionIndex: -1
		});
	}

	handleAddOption() {
		const duplicated = this.workingParam.options.filter((option) => {
			return option.value === this.selectedOption.value;
		});

		if (duplicated.length > 0) {
			this.setState({
				duplicatedValueState: true
			});

			return;
		}

		const optionLength = this.workingParam.addOption(this.selectedOption);

		this.workingParam.fireRefreshPreview();

		this.setState({
			selectedOptionIndex: optionLength - 1
		});
	}

	copyOption(index) {
		this.setState({
			selectedOptionIndex: this.workingParam.copyOption(index)
		});

		this.workingParam.fireRefreshPreview();
	}

	moveUpOption(index) {
		this.setState({
			selectedOptionIndex: this.workingParam.moveUpOption(index)
		});

		this.workingParam.fireRefreshPreview();
	}

	moveDownOption(index) {
		this.setState({
			selectedOptionIndex: this.workingParam.moveDownOption(index)
		});

		this.workingParam.fireRefreshPreview();
	}

	removeOption(index) {
		let optionCount = this.workingParam.removeOption(index);
		let selectedOptionIndex = index === optionCount ? optionCount - 1 : index;
		this.selectedOption = this.workingParam.getOption(selectedOptionIndex);

		this.setState({
			selectedOptionIndex: selectedOptionIndex
		});

		this.workingParam.fireRefreshPreview();
	}

	handleOptionSelected(index) {
		this.selectedOption = this.workingParam.getOption(index);
		this.fieldOptionLabel.setValue({ value: this.selectedOption.label });
		this.fieldOptionLabel.refreshKey();

		this.setState({
			selectedOptionIndex: index
		});
	}

	handleOptionValueChanged(val) {
		this.selectedOption.value = val;

		if (this.state.selectedOptionIndex > -1) {
			this.workingParam.fireRefreshPreview();
		}

		this.forceUpdate();
	}

	render() {
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
							{ id: "copy", name: Util.translate("copy"), symbol: "copy" },
							{ id: "delete", name: Util.translate("delete"), symbol: "times" }
						];
						if (index > 0) {
							actionItems.push({ id: "up", name: Util.translate("moveUp"), symbol: "order-arrow-up" });
						}
						if (index < this.workingParam.options.length - 1) {
							actionItems.push({
								id: "down",
								name: Util.translate("moveDown"),
								symbol: "order-arrow-down"
							});
						}

						return (
							<div
								key={index}
								aria-hidden="undefined"
								className={
									option.value === this.selectedOption.value
										? "sx-option-preview-row sx-option-focused"
										: "sx-option-preview-row"
								}
								onClick={(e) => {
									//e.stopPropagation();

									this.handleOptionSelected(index);
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
									<SXDropdown
										key={this.workingParam.options.length - index}
										namespace={this.namespace}
										formId={this.formId}
										items={actionItems}
										targetData={index}
										symbol="ellipsis-v"
										activeDropdown={option === this.selectedOption && this.activeDropdown}
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
						disabled={this.state.selectedOptionIndex > -1}
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
						forHtml={this.props.namespace + "_" + "optionValue"}
						spritemap={this.props.spritemap}
					/>
					<ClayInput
						key={Util.randomKey()}
						id={this.props.namespace + "_" + "optionValue"}
						placeholder={Util.translate("option-value")}
						defaultValue={this.selectedOption.value ?? ""}
						onBlur={(e) => {
							e.stopPropagation();
							this.handleOptionValueChanged(e.target.value);
						}}
					/>
				</Form.Group>
				{this.state.duplicatedValueState && (
					<SXModalDialog
						header={Util.translate("error")}
						body={Util.translate("option-value-is-already-exist-try-another-value")}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: (e) => {
									this.setState({ duplicatedValueState: false });
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

class SXGroupBuilder extends React.Component {
	constructor(props) {
		super(props);

		this.dataStructure = props.dataStructure;
		this.workingParam = props.workingParam;
		this.namespace = this.workingParam.namespace;
		this.languageId = this.workingParam.languageId;
		this.availableLanguageIds = this.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.selectableTypes = props.selectableTypes ?? [];

		this.state = {
			showSelector: false
		};

		this.formId = this.namespace + "groupBuilder";
	}

	componentDidMount() {}

	handleSelectChange(param) {
		if (this.workingParam.isMember(param.paramName, param.paramVersion)) {
			this.workingParam.removeMember(paramName, paramVersion);
		} else {
			this.workingParam.addMember(param);
		}
	}

	render() {
		return (
			<SXDualListBox
				parameter={
					new DualListParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
						paramName: ParamProperty.MEMBERS,
						displayName: Util.getTranslationObject(this.languageId, "members"),
						required: true,
						tooltip: Util.getTranslationObject(this.languageId, "members-tooltip"),
						viewType: DualListParameter.ViewTypes.HORIZONTAL,
						validation: {
							required: {
								value: true,
								message: Util.getTranslationObject(this.languageId, "this-field-is-required")
							}
						},
						options: []
					})
				}
			/>
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
			placeholder: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.PLACEHOLDER,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "placeholder"),
				tooltip: Util.getTranslationObject(this.languageId, "placeholder-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "placeholder"),
				value: this.workingParam.placeholder
			}),

			multipleLine: new BooleanParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.MULTIPLE_LINE,
					viewType: BooleanParameter.ViewTypes.CHECKBOX,
					displayName: Util.getTranslationObject(this.languageId, "multiple-line"),
					tooltip: Util.getTranslationObject(this.languageId, "multiple-line-tooltip"),
					defalutValue: false,
					value: this.workingParam.multipleLine
				}
			),

			localized: new BooleanParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.LOCALIZED,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "localized"),
				tooltip: Util.getTranslationObject(this.languageId, "localized-tooltip"),
				defalutValue: false,
				value: this.workingParam.localized
			}),
			prefix: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.PREFIX,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "prefix"),
				tooltip: Util.getTranslationObject(this.languageId, "prefix-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "prefix"),
				value: this.workingParam.prefix
			}),
			postfix: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.POSTFIX,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "postfix"),
				tooltip: Util.getTranslationObject(this.languageId, "postfix-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "postfix"),
				value: this.workingParam.postfix
			})
		};
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ", dataPacket, this.workingParam);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			isInteger: new BooleanParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.IS_INTEGER,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "integer"),
				tooltip: Util.getTranslationObject(this.languageId, "integer-tooltip"),
				value: this.workingParam.isInteger
			}),

			uncertainty: new BooleanParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.UNCERTAINTY,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "uncertainty"),
				tooltip: Util.getTranslationObject(this.languageId, "uncertainty-tooltip"),
				value: this.workingParam.uncertainty
			}),

			decimalPlaces: new NumericParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.DECIMAL_PLACES,
					isInteger: true,
					displayName: Util.getTranslationObject(this.languageId, "decimal-places"),
					tooltip: Util.getTranslationObject(this.languageId, "decimal-places-tooltip"),
					value: this.workingParam.decimalPlaces
				}
			),

			unit: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.UNIT,
				displayName: Util.getTranslationObject(this.languageId, "unit"),
				tooltip: Util.getTranslationObject(this.languageId, "unit-tooltip"),
				value: this.workingParam.unit
			}),
			prefix: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.PREFIX,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "prefix"),
				tooltip: Util.getTranslationObject(this.languageId, "prefix-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "prefix"),
				value: this.workingParam.prefix
			}),
			postfix: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.POSTFIX,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "postfix"),
				tooltip: Util.getTranslationObject(this.languageId, "postfix-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "postfix"),
				value: this.workingParam.postfix
			})
		};
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			console.log("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED------: ", dataPacket, this.workingParam);
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ", dataPacket, this.workingParam);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (dataPacket.paramName === ParamProperty.IS_INTEGER) {
				this.setState({ isInteger: this.workingParam.isInteger });
			}

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			viewType: new SelectParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.VIEW_TYPE,
				viewType: BooleanParameter.ViewTypes.RADIO,
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
			}),
			optionsPerRow: new NumericParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
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

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fields[dataPacket.paramName],
				this.fields[dataPacket.paramName].getValue()
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();
			//this.workingParam.initValue();

			this.forceUpdate();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			viewType: new SelectParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
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
			}),
			trueLabel: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.TRUE_LABEL,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "true-label"),
				placeholder: Util.getTranslationObject(this.languageId, "label-for-true-option"),
				tooltip: Util.getTranslationObject(this.languageId, "label-for-true-option-tooltip"),
				value: this.workingParam.trueLabel
			}),

			falseLabel: new StringParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.FALSE_LABEL,
				localized: true,
				displayName: Util.getTranslationObject(this.languageId, "false-label"),
				placeholder: Util.getTranslationObject(this.languageId, "label-for-false-option"),
				tooltip: Util.getTranslationObject(this.languageId, "label-for-false-option-tooltip"),
				value: this.workingParam.falseLabel
			})
		};
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fields[dataPacket.paramName].getValue()
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			enableCountryNo: new BooleanParameter(
				this.namespace,
				this.formId,
				this.languageId,
				this.availableLanguageIds,
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

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fields[dataPacket.paramName].getValue()
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			viewType: new SelectParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
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
			})
		};
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fields[dataPacket.paramName].getValue()
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
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
			enableTime: new BooleanParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.ENABLE_TIME,
				viewType: BooleanParameter.ViewTypes.TOGGLE,
				displayName: Util.getTranslationObject(this.languageId, "enable-time"),
				tooltip: Util.getTranslationObject(this.languageId, "enable-time-tooltip"),
				defaultValue: false,
				value: this.workingParam.enableTime
			}),
			startYear: new NumericParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.START_YEAR,
				displayName: Util.getTranslationObject(this.languageId, "start-year"),
				isInteger: true,
				tooltip: Util.getTranslationObject(this.languageId, "start-year-tooltip"),
				defaultValue: "1970",
				value: this.workingParam.startYear
			}),
			endYear: new NumericParameter(this.namespace, this.formId, this.languageId, this.availableLanguageIds, {
				paramName: ParamProperty.END_YEAR,
				displayName: Util.getTranslationObject(this.languageId, "end-year"),
				isInteger: true,
				tooltip: Util.getTranslationObject(this.languageId, "end-year-tooltip"),
				value: this.workingParam.endYear
			})
		};
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fields[dataPacket.paramName].getValue()
			);

			this.workingParam[dataPacket.paramName] = this.fields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.initValue();
				this.workingParam.fireRefreshPreview();
			}
		});
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

		this.fieldViewType = new SelectParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
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
					}
				],
				optionsPerRow: 2,
				tooltip: Util.getTranslationObject(this.languageId, "view-type-tooltip"),
				defaultValue: AddressParameter.ViewTypes.PANEL,
				value: this.workingParam.viewType
			}
		);

		this.fieldMembersPerRow = new NumericParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.MEMBERS_PER_ROW,
				isInteger: true,
				displayName: Util.getTranslationObject(this.languageId, "members-per-row"),
				tooltip: Util.getTranslationObject(this.languageId, "members-per-row-tooltip"),
				defaultValue: 1,
				value: this.workingParam.membersPerRow
			}
		);

		this.fieldExpanded = new BooleanParameter(
			this.namespace,
			this.formIds.basicPropertiesFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: ParamProperty.EXPANDED,
				viewType: BooleanParameter.ViewTypes.CHECKBOX,
				displayName: Util.getTranslationObject(this.languageId, "expanded"),
				tooltip: Util.getTranslationObject(this.languageId, "expanded-tooltip"),
				value: this.workingParam.showDefinition
			}
		);
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXGroupTypeOptionForm SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.workingParam,
				this.fieldMembersPerRow.getValue()
			);

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
					this.workingParam.expanded = this.fieldMembersPerRow.getValue();
					break;
				}
			}

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
	}

	render() {
		return (
			<>
				{this.fieldViewType.renderField({ spritemap: this.spritemap })}
				{this.workingParam.showMembersPerRow &&
					this.fieldMembersPerRow.renderField({ spritemap: this.spritemap })}
				{this.fieldExpanded.renderField({ spritemap: this.spritemap })}
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

		this.state = {
			selectedColumn: this.workingParam.columns[0]
		};
		this.activeDropdown = false;

		this.paramNameFileds = {};
		this.displayNameFileds = {};

		this.columnReadyTypes = [
			{
				label: Util.translate("select-to-add-column"),
				value: ""
			},
			...Object.keys(Parameter.ColumnReadyTypes).map((key) => ({
				label: Parameter.ColumnReadyTypes[key],
				value: Parameter.ColumnReadyTypes[key]
			}))
		];

		this.fieldColumnCode = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: "columnCode",
				displayName: Util.getTranslationObject(this.languageId, "column-code"),
				tooltip: Util.getTranslationObject(this.languageId, "column-code-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "code-name-for-column"),
				value: this.state.selectedColumn ? this.state.selectedColumn.paramName : ""
			}
		);
		this.fieldColumnDisplayName = new StringParameter(
			this.namespace,
			this.formId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: "columnDisplayName",
				displayName: Util.getTranslationObject(this.languageId, "display-name"),
				tooltip: Util.getTranslationObject(this.languageId, "display-name-tooltip"),
				placeholder: Util.getTranslationObject(this.languageId, "translation-for-display-name"),
				localized: true,
				value: this.state.selectedColumn ? this.state.selectedColumn.displayName : {}
			}
		);
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			console.log(
				"SXGridTypeOptionForm SX_FIELD_VALUE_CHANGED: ",
				dataPacket,
				this.state.selectedColumn,
				this.fieldColumnCode,
				this.fieldColumnDisplayName
			);

			switch (dataPacket.paramName) {
				case "columnCode": {
					this.state.selectedColumn.paramName = this.fieldColumnCode.getValue();

					break;
				}
				case "columnDisplayName": {
					this.state.selectedColumn.displayName = this.fieldColumnDisplayName.getValue();

					break;
				}
			}

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}

			this.forceUpdate();
		});

		Event.uniqueOn(Event.SX_POP_ACTION_CLICKED, (e) => {
			const dataPacket = e.dataPacket;

			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			switch (dataPacket.actionId) {
				case "copy": {
					this.copyColumn(dataPacket.targetData);
					break;
				}
				case "delete": {
					this.removeColumn(dataPacket.targetData);
					break;
				}
				case "left": {
					this.moveColumnLeft(dataPacket.targetData);
					break;
				}
				case "right": {
					this.moveColumnRight(dataPacket.targetData);
					break;
				}
			}

			this.activeDropdown = false;
		});

		Event.uniqueOn(Event.SX_POP_BUTTON_CLICKED, (e) => {
			const dataPacket = e.dataPacket;

			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
				return;
			}

			//this.handleColumnSelected(dataPacket.targetData);

			this.activeDropdown = dataPacket.activeDropdown;
		});
	}

	moveColumnLeft(column) {
		this.workingParam.moveColumnLeft(column.order);

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	}

	moveColumnRight(column) {
		this.workingParam.moveColumnRight(column.order);

		this.workingParam.fireRefreshPreview();

		this.forceUpdate();
	}

	removeColumn(column) {
		let columnCount = this.workingParam.removeColumn({ colName: column.paramName });

		const firstColumn = columnCount > 0 ? this.workingParam.columns[0] : null;
		this.setState({
			selectedColumn: firstColumn
		});

		if (firstColumn) {
			this.fieldColumnCode.setValue({ value: firstColumn.paramName });
			this.fieldColumnDisplayName.setValue({ value: firstColumn.displayName });
		}

		this.workingParam.fireRefreshPreview();
	}

	copyColumn(column) {
		let copied = column.copy();

		this.workingParam.insertColumn(copied, column.order);

		this.setState({
			selectedColumn: copied
		});

		this.fieldColumnCode.setValue({ value: copied.paramName });
		this.fieldColumnDisplayName.setValue({ value: copied.displayName });

		this.workingParam.fireRefreshPreview();
	}

	handleColumnSelected(column) {
		this.fieldColumnCode.setValue({ value: column.paramName });
		this.fieldColumnDisplayName.setValue({ value: column.displayName });
		this.fieldColumnCode.refreshKey();
		this.fieldColumnDisplayName.refreshKey();

		this.setState({ selectedColumn: column });
	}

	handleColumnTypeSelect(columnType) {
		const column = new Parameter.createParameter(
			this.namespace,
			this.workingParam.formId,
			this.languageId,
			this.availableLanguageIds,
			columnType,
			{
				paramName: "column_" + Util.randomKey(8)
			}
		);

		this.workingParam.addColumn(column);

		column.displayName = Util.getTranslationObject(
			this.languageId,
			"column_" + column.order.toString().padStart(2, "0")
		);
		column.value = [];

		this.workingParam.fireRefreshPreview();

		this.fieldColumnCode.setValue({ value: column.paramName });
		this.fieldColumnCode.refreshKey();
		this.fieldColumnDisplayName.setValue({ value: column.displayName });
		this.fieldColumnDisplayName.refreshKey();

		this.setState({
			selectedColumn: column
		});
	}

	render() {
		return (
			<>
				<Form.Group className="form-group-sm">
					<SXLabel
						label={Util.translate("add-column")}
						forHtml={this.namespace + "columnType"}
						tooltip={Util.translate("add-column-tooltip")}
						spritemap={this.spritemap}
					/>
					<div style={{ paddingLeft: "10px" }}>
						<ClaySelectWithOption
							aria-label={Util.translate("column-type")}
							id={this.namespace + "columnType"}
							options={this.columnReadyTypes}
							value={this.state.selectedColumn ? this.state.selectedColumn.paramType : ""}
							onChange={(e) => {
								this.handleColumnTypeSelect(e.target.value);
							}}
							style={{ paddingLeft: "10px" }}
							spritemap={this.spritemap}
						/>
					</div>
				</Form.Group>
				{this.workingParam.columnCount > 0 && (
					<>
						{this.fieldColumnCode.renderField({ spritemap: this.spritemap })}
						{this.fieldColumnDisplayName.renderField({ spritemap: this.spritemap })}
					</>
				)}
				<div className="sx-option-builder-label">
					<SXLabel
						label={Util.translate("columns")}
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
						{this.workingParam.columns.map((column, index) => {
							let actionItems = [
								{ id: "copy", name: Util.translate("copy"), symbol: "copy" },
								{ id: "delete", name: Util.translate("delete"), symbol: "times" }
							];
							if (column.order > 1) {
								actionItems.push({
									id: "left",
									name: Util.translate("move-left"),
									symbol: "caret-left"
								});
							}
							if (column.order < this.workingParam.columnCount) {
								actionItems.push({
									id: "right",
									name: Util.translate("move-right"),
									symbol: "caret-right"
								});
							}

							let className = "autofit-row";
							if (column === this.state.selectedColumn) {
								className += " sx-option-focused";
							}

							return (
								<div
									key={column.paramName}
									className={className}
									onClick={(e) => {
										this.handleColumnSelected(column);
									}}
								>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "2rem" }}
									>
										{column.order}
									</div>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "4rem" }}
									>
										{column.paramType}
									</div>
									<div className="autofit-col autofit-col-expand sx-table-cell">{column.label}</div>
									<div
										className="autofit-col sx-table-cell"
										style={{ width: "auto" }}
									>
										<SXDropdown
											key={this.workingParam.columnCount - index}
											namespace={this.namespace}
											formId={this.formId}
											items={actionItems}
											targetData={column}
											symbol="ellipsis-v"
											activeDropdown={column === this.state.selectedColumn && this.activeDropdown}
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
