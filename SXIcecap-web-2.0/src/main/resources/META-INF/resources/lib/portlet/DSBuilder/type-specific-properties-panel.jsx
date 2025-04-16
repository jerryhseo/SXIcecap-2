import React from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import SXFormField, { SXLabel } from "../../form/sxform";
import { BooleanParameter, SelectParameter } from "../../parameter/parameter";
import { ClayButtonWithIcon } from "@clayui/button";
import { Button, Icon } from "@clayui/core";
import DropDown from "@clayui/drop-down";
import LocalizedInput from "@clayui/localized-input";
import Form, { ClayInput } from "@clayui/form";
import { SXModalDialog } from "../../modal/sxmodal";

class SXSelectOptionBuilder extends React.Component {
	constructor(props) {
		super(props);

		this.locales = this.props.availableLanguageIds.map((locale) => ({
			label: locale,
			symbol: locale.toLowerCase()
		}));

		this.selectedOption = {};
		let selectedOptionIndex = -1;
		if (Util.isNotEmpty(this.props.parameter.options)) {
			this.selectedOption = this.props.parameter.getOption(0);
			selectedOptionIndex = 0;
		}

		this.state = {
			selectedOptionLocale: this.locales.filter((locale) => locale.label === this.props.languageId)[0],
			selectedOptionIndex: selectedOptionIndex,
			refresh: false,
			duplicatedValueState: false
		};
	}

	handleNewOption() {
		this.selectedOption = {};

		this.setState({
			selectedOptionIndex: -1
		});
	}

	fireFieldValueChangedEvent() {
		Event.fire(Event.SX_FIELD_VALUE_CHANGED, this.props.namespace, this.props.namespace, {
			paramName: ParamProperty.OPTIONS,
			paramVersion: "1.0.0",
			target: this.props.dsbuilderId,
			value: this.props.parameter.options
		});
	}

	handleAddOption() {
		const duplicated = this.props.parameter.options.filter((option) => {
			return option.value === this.selectedOption.value;
		});

		if (duplicated.length > 0) {
			this.setState({
				duplicatedValueState: true
			});

			return;
		}

		const optionLength = this.props.parameter.addOption(this.selectedOption);

		this.fireFieldValueChangedEvent();

		this.setState({
			selectedOptionIndex: optionLength - 1
		});
	}

	switchOptions(index1, index2) {
		this.props.parameter.switchOptions(index1, index2);

		this.fireFieldValueChangedEvent();
	}

	moveUpOption(index) {
		this.setState({
			selectedOptionIndex: this.props.parameter.moveUpOption(index)
		});
	}

	moveDownOption(index) {
		this.setState({
			selectedOptionIndex: this.props.parameter.moveDownOption(index)
		});
	}

	removeOption(index) {
		let optionCount = this.props.parameter.removeOption(index);
		let selectedOptionIndex = index === optionCount ? optionCount - 1 : index;
		this.selectedOption = this.props.parameter.getOption(selectedOptionIndex);

		this.fireFieldValueChangedEvent();

		this.setState({
			selectedOptionIndex: selectedOptionIndex
		});
	}

	handleOptionSelected(index) {
		this.selectedOption = this.props.parameter.getOption(index);

		this.setState({
			selectedOptionIndex: index
		});
	}

	handleOptionLabelChanged(translations) {
		this.selectedOption.label = translations;

		if (this.state.selectedOptionIndex > -1) {
			this.fireFieldValueChangedEvent();
		}

		this.setState({ refresh: !this.state.refresh });
	}

	handleOptionValueChanged(val) {
		this.selectedOption.value = val;

		if (this.state.selectedOptionIndex > -1) {
			this.fireFieldValueChangedEvent();
		}

		this.setState({ refresh: !this.state.refresh });
	}

	render() {
		console.log("SXSelectOptionBuilder parameter: ", this.selectedOption, this.state.selectedOptionIndex);

		return (
			<>
				<div
					style={{
						fontWeight: "600",
						fontSize: "0.875rem",
						textShadow: "0px 1px 3px rgba(0, 0, 0, 0.5)",
						borderBottom: "4px solid #efefef",
						marginBottom: "15px"
					}}
				>
					{"Option Builder"}
				</div>
				<div style={{ display: "inline-flex", marginBottom: "5px", alignItems: "center", flexWrap: "wrap" }}>
					<SXLabel
						label={Util.translate("options")}
						forHtml=""
						required={true}
						style={{
							fontWeight: "600",
							fontSize: "0.875rem"
						}}
						spritemap={this.props.spritemap}
					/>
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
						style={{ marginLeft: "auto" }}
					/>
				</div>
				<div className="sx-option-preview">
					{this.props.parameter.options.map((option, index) => {
						let actionItems = [{ id: "delete", name: Util.translate("delete") }];
						if (index > 0) {
							actionItems.push({ id: "up", name: Util.translate("moveUp") });
						}
						if (index < this.props.parameter.options.length - 1) {
							actionItems.push({ id: "down", name: Util.translate("moveDown") });
						}

						return (
							<div
								key={option.value}
								className={
									option.value === this.selectedOption.value
										? "sx-option-preview-row sx-option-focused"
										: "sx-option-preview-row"
								}
								onClick={(e) => {
									e.stopPropagation();

									this.handleOptionSelected(index);
								}}
							>
								<div
									className="sx-option-preview-cell"
									style={{ width: "50%" }}
								>
									{option.label[this.props.languageId]}
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
									<DropDown
										trigger={
											<ClayButtonWithIcon
												aria-label="Actions"
												symbol="ellipsis-v"
												title="Actions"
												displayType={"secondary"}
												size="sm"
												borderless="true"
												spritemap={this.props.spritemap}
											/>
										}
									>
										<DropDown.ItemList items={actionItems}>
											{(action) => (
												<DropDown.Item
													key={Util.randomKey()}
													onClick={(e) => {
														e.stopPropagation();

														switch (action.id) {
															case "delete": {
																this.removeOption(index);
																break;
															}
															case "up": {
																this.moveUpOption(index);
																break;
															}
															case "down": {
																this.moveDownOption(index);
																break;
															}
														}
													}}
												>
													{action.name}
												</DropDown.Item>
											)}
										</DropDown.ItemList>
									</DropDown>
								</div>
							</div>
						);
					})}
				</div>
				<Button.Group
					spaced
					style={{
						background: "#f5f5f5",
						padding: "10px 5px",
						justifyContent: "center",
						marginBottom: "5px",
						marginTop: "5px"
					}}
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
				</Button.Group>
				<LocalizedInput
					id={this.props.namespace + "label"}
					locales={this.locales}
					label={Util.translate("option-label")}
					onSelectedLocaleChange={(locale) => {
						this.setState({ selectedOptionLocale: locale });
					}}
					onTranslationsChange={(translations) => this.handleOptionLabelChanged(translations)}
					selectedLocale={this.state.selectedOptionLocale}
					translations={this.selectedOption.label ?? {}}
					spritemap={this.props.spritemap}
				/>

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

class SXDSBuilderTypeSpecificPanel extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.languageId;
		this.availableLanguageIds = props.availableLanguageIds;
		this.spritemap = props.spritemap;

		this.state = {
			parameter: props.parameter,
			refresh: false
		};

		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = Event.pickUpDataPacket(
				e,
				this.namespace,
				this.propertyPanelId,
				ParamProperty.VIEW_TYPE,
				"1.0.0"
			);

			if (Util.isEmpty(dataPacket)) {
				return;
			}

			console.log("SXDSBuilderTypeSpecificPanel SX_FIELD_VALUE_CHANGED: ", dataPacket, this.state.parameter);
			this.setState({ refresh: !this.state.refresh });
		});
	}

	render() {
		let events = {
			fire: [
				{
					target: this.dsbuilderId,
					event: Event.SX_FIELD_VALUE_CHANGED
				}
			]
		};

		switch (this.state.parameter.paramType) {
			case ParamType.LOCALIZED_STRING:
			case ParamType.STRING: {
				return (
					<>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.LOCALIZED_STRING,
								paramName: ParamProperty.PLACEHOLDER,
								languageId: this.languageId,
								availableLanguageIds: this.availableLanguageIds,
								paramVersion: "1.0.0",
								label: Util.translate("placeholder"),
								tooltip: Util.translate("placeholder-tooltip"),
								placeholder: Util.translate("placeholder"),
								value: this.state.parameter.placeholder
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.MULTIPLE_LINE,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("multiple-line"),
								tooltip: Util.translate("multiple-line-tooltip"),
								value: this.state.parameter.multipleLine
							}}
							events={events}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.NUMERIC: {
				return (
					<>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.IS_INTEGER,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("integer"),
								tooltip: Util.translate("integer-tooltip"),
								value: this.state.parameter.isInteger
							}}
							events={events}
							spritemap={this.spritemap}
							style={{ marginBottom: "15px" }}
						/>
						{!this.state.parameter.isInteger && (
							<SXFormField
								namespace={this.namespace}
								properties={{
									paramType: ParamType.NUMERIC,
									paramName: ParamProperty.DECIMAL_PLACES,
									paramVersion: "1.0.0",
									label: Util.translate("decimal-places"),
									tooltip: Util.translate("decimal-places-tooltip"),
									isInteger: true,
									languageId: this.languageId,
									value: this.state.parameter.decimalPlaces ?? ""
								}}
								events={events}
								spritemap={this.spritemap}
							/>
						)}
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.STRING,
								paramName: ParamProperty.UNIT,
								paramVersion: "1.0.0",
								label: Util.translate("unit"),
								tooltip: Util.translate("unit-tooltip"),
								languageId: this.languageId,
								value: this.state.parameter.unit
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.BOOLEAN,
								paramName: ParamProperty.UNCERTAINTY,
								paramVersion: "1.0.0",
								viewType: BooleanParameter.ViewTypes.CHECKBOX,
								label: Util.translate("uncertainty"),
								tooltip: Util.translate("uncertainty-tooltip"),
								value: this.state.parameter.uncertainty
							}}
							events={events}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.SELECT: {
				console.log("SXTypeSpecific Select: ", this.state.parameter, this.state.parameter.viewType);
				return (
					<>
						<SXFormField
							namespace={this.namespace}
							properties={{
								paramType: ParamType.SELECT,
								paramName: ParamProperty.VIEW_TYPE,
								paramVersion: "1.0.0",
								viewType: SelectParameter.ViewTypes.RADIO,
								label: Util.translate("view-type"),
								tooltip: Util.translate("select-view-type-tooltip"),
								options: [
									{
										label: "Dropdown",
										value: SelectParameter.ViewTypes.DROPDOWN
									},
									{
										label: "Radio",
										value: SelectParameter.ViewTypes.RADIO
									},
									{
										label: "Checkbox",
										value: SelectParameter.ViewTypes.CHECKBOX
									},
									{
										label: "Listbox",
										value: SelectParameter.ViewTypes.LISTBOX
									}
								],
								optionsPerRow: 2,
								value: this.state.parameter.viewType ?? SelectParameter.ViewTypes.DROPDOWN
							}}
							events={events}
							spritemap={this.spritemap}
						/>
						{(this.state.parameter.viewType === SelectParameter.ViewTypes.RADIO ||
							this.state.parameter.viewType === SelectParameter.ViewTypes.CHECKBOX) && (
							<SXFormField
								namespace={this.namespace}
								properties={{
									paramType: ParamType.NUMERIC,
									paramName: ParamProperty.OPTIONS_PER_ROW,
									paramVersion: "1.0.0",
									label: Util.translate("options-per-row"),
									tooltip: Util.translate("options-per-row-tooltip"),
									isInteger: true,
									languageId: this.languageId,
									value: this.state.parameter.optionsPerRow ?? ""
								}}
								events={events}
								spritemap={this.spritemap}
							/>
						)}
						<SXSelectOptionBuilder
							key={Util.randomKey()}
							namespace={this.namespace}
							dsbuilderId={this.dsbuilderId}
							propertyPanelId={this.propertyPanelId}
							previewCanvasId={this.previewCanvasId}
							options={this.state.parameter.options}
							languageId={this.languageId}
							availableLanguageIds={this.availableLanguageIds}
							parameter={this.state.parameter}
							spritemap={this.spritemap}
						/>
					</>
				);
			}
			case ParamType.BOOLEAN: {
				const fields = [
					{
						paramType: ParamType.SELECT,
						paramName: ParamProperty.VIEW_TYPE,
						paramVersion: "1.0.0",
						viewType: SelectParameter.ViewTypes.RADIO,
						label: Util.translate("view-type"),
						options: [
							{
								label: "Checkbox",
								value: BooleanParameter.ViewTypes.CHECKBOX
							},
							{
								label: "Toggle",
								value: BooleanParameter.ViewTypes.TOGGLE
							},
							{
								label: "Dropdown",
								value: BooleanParameter.ViewTypes.DROPDOWN
							},
							{
								label: "Radio",
								value: BooleanParameter.ViewTypes.RADIO
							}
						],
						optionsPerRow: 2,
						languageId: this.languageId,
						tooltip: Util.translate("view-type-tooltip"),
						value: this.state.parameter.viewType ?? BooleanParameter.ViewTypes.CHECKBOX
					},
					{
						paramType: ParamType.LOCALIZED_STRING,
						paramName: ParamProperty.TRUE_LABEL,
						label: Util.translate("true-label"),
						paramVersion: "1.0.0",
						languageId: this.languageId,
						availableLanguageIds: this.availableLanguageIds,
						placeholder: Util.translate("label-for-true-option"),
						tooltip: Util.translate("label-for-true-option-tooltip"),
						value: this.state.parameter.getTrueLabel(this.availableLanguageIds)
					},
					{
						paramType: ParamType.LOCALIZED_STRING,
						paramName: ParamProperty.FALSE_LABEL,
						label: Util.translate("false-label"),
						paramVersion: "1.0.0",
						languageId: this.languageId,
						availableLanguageIds: this.availableLanguageIds,
						placeholder: Util.translate("label-for-false-option"),
						tooltip: Util.translate("label-for-false-option-tooltip"),
						value: this.state.parameter.getFalseLabel(this.availableLanguageIds)
					}
				];

				console.log(
					"this.state.parameter.trueLabel: ",
					this.state.parameter.getTrueLabel(this.availableLanguageIds)
				);
				console.log(
					"this.state.parameter.falseLabel: ",
					this.state.parameter.getFalseLabel(this.availableLanguageIds)
				);

				return (
					<div>
						{fields.map((field) => {
							return (
								<SXFormField
									key={Util.randomKey()}
									namespace={this.namespace}
									properties={field}
									events={events}
									spritemap={this.spritemap}
								/>
							);
						})}
					</div>
				);
			}
		}

		return <div>{"Step 2 to define a parameter."}</div>;
	}
}

export default SXDSBuilderTypeSpecificPanel;
