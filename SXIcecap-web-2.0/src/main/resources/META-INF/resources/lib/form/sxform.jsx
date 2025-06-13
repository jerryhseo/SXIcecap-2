import React, { createRef } from "react";
import { Row, Text } from "@clayui/core";
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClayRadio,
	ClayRadioGroup,
	ClaySelect,
	ClayToggle,
	ClaySelectBox,
	ClaySelectWithOption
} from "@clayui/form";
import DatePicker from "@clayui/date-picker";
import { ClayTooltipProvider } from "@clayui/tooltip";
import Icon from "@clayui/icon";
import Button, { ClayButtonWithIcon } from "@clayui/button";
import DropDown from "@clayui/drop-down";
import ClayLabel from "@clayui/label";
import { Util } from "../common/util";

import {
	ParamType,
	Event,
	ParamProperty,
	ErrorClass,
	ValidationKeys,
	ValidationSectionProperty
} from "../common/station-x";
import {
	AddressParameter,
	BooleanParameter,
	DualListParameter,
	EMailParameter,
	GroupParameter,
	Parameter,
	SelectParameter,
	StringParameter
} from "../parameter/parameter";
import { UnderConstruction } from "../common/common";
import { SXModalDialog } from "../modal/sxmodal";
import Autocomplete from "@clayui/autocomplete";
import Panel from "@clayui/panel";
import Toolbar from "@clayui/toolbar";
import { DataStructure } from "../portlet/DSBuilder/data-structure";

export const SelectDisplayStyle = {
	DUAL_LISTBOX: "DUAL_LISTBOX",
	DROP_LIST: "DROP_LIST",
	CHECKBOX: "CHECKBOX",
	RADIO_BUTTON: "RADIO_BUTTON",
	MULTI_SELECT: "MULTI_SELECT"
};

export const validateFormField = (fieldType, value, validation, languageId) => {
	console.log("validation: ", fieldType, value, validation, languageId);
	for (const validationType in validation) {
		if (validationType === "required") {
			if (validation.required.value && Util.isEmpty(value)) {
				return validation.required.message[languageId];
			}
		}

		if (validationType === "pattern") {
			const regExpr = new RegExp(validation.pattern.value);
			switch (fieldType) {
				case ParamType.LOCALIZED_STRING: {
					for (const key in value) {
						if (value[key] && !regExpr.test(value)) {
							return validation.pattern.message[languageId];
						}
					}
					break;
				}
				case ParamType.STRING: {
					if (!regExpr.test(value)) {
						return validation.pattern.message[languageId];
					}
					break;
				}
			}
		}

		if (validationType === "min") {
			switch (fieldType) {
				case ParamType.LOCALIZED_STRING:
				case ParamType.STRING: {
					if (value.length < validation.min.value) {
						return validation.min.message[languageId];
					}
				}
				case ParamType.NUMERIC:
				case ParamType.INTEGER: {
					if (value < validation.min.value) {
						return validation.min.message[languageId];
					}
				}
			}
		}

		if (validationType === "max") {
			switch (fieldType) {
				case ParamType.LOCALIZED_STRING:
				case ParamType.STRING: {
					if (value.length > validation.max.value) {
						return validation.max.message[languageId];
					}
				}
				case ParamType.NUMERIC:
				case ParamType.INTEGER: {
					if (value > validation.max.value) {
						return validation.max.message[languageId];
					}
				}
			}
		}

		if (validationType === "validate") {
			return validation.validate(value);
		}
	}

	return "";
};

export const validateForm = (formFields, formData, formErrors) => {
	let errorFields = formFields.filter((field) => field.required && Util.isEmptyObject(formData[field.paramName]));

	if (errorFields.length > 0) {
		return {
			fieldName: errorFields[0].paramName,
			message: errorFields[0].paramName + " is required"
		};
	}

	errorFields = formFields.filter((field) => formErrors[field.paramName]);
	if (errorFields.length > 0) {
		return {
			fieldName: errorFields[0].paramName,
			message: errorFields[0].paramName + ": " + formErrors[field.paramName]
		};
	}

	return "";
};

export const SXRequiredMark = ({ spritemap }) => {
	return (
		<sup>
			<Icon
				symbol="asterisk"
				style={{
					fontSize: "0.5rem",
					margin: "0 3px 3px 3px",
					color: "red"
				}}
				spritemap={spritemap}
			/>
		</sup>
	);
};

export const SXTooltip = ({ tooltip, spritemap }) => {
	return (
		<ClayTooltipProvider>
			<span
				data-tooltip-align="top"
				title={tooltip}
				style={{ marginLeft: "3px" }}
			>
				<Icon
					spritemap={spritemap}
					symbol="question-circle-full"
				/>
			</span>
		</ClayTooltipProvider>
	);
};

export const SXLabel = ({ label, forHtml = "", required = false, tooltip = "", style, spritemap }) => {
	return (
		<label
			htmlFor={forHtml}
			className="control-label"
			style={style}
		>
			{label}
			{required ? <SXRequiredMark spritemap={spritemap} /> : undefined}
			{tooltip ? (
				<SXTooltip
					tooltip={tooltip}
					spritemap={spritemap}
				/>
			) : undefined}
		</label>
	);
};

export const SXLabeledText = ({ label, text, viewType = "INLINE_ATTACH" }) => {
	const labelStyle = {
		backgroundColor: "#e7e7ed",
		marginBottom: "5px"
	};

	const textStyle = {
		backgroundColor: "#f1f2f5",
		marginBottom: "5px"
	};

	switch (viewType) {
		case "INLINE_ATTACH": {
			return (
				<ClayInput.Group>
					<ClayInput.GroupItem
						shrink
						prepend
					>
						<ClayInput.GroupText style={labelStyle}>{label}</ClayInput.GroupText>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem append>
						<ClayInput.GroupText
							className="form-group-autofit"
							style={textStyle}
						>
							{text}
						</ClayInput.GroupText>
					</ClayInput.GroupItem>
				</ClayInput.Group>
			);
		}
		case "INLINE_SPACE": {
			return <></>;
		}
		default: {
			return <></>;
		}
	}
};

export const SXAutoComplete = ({ namespace, items, labelPosition, events, spritemap }) => {
	const inputId = namespace + "input";
	const labelPos = Util.isEmpty(labelPosition) ? Parameter.LabelPosition.UPPER_LEFT : labelPosition;

	let groupClass = "form-group";
	let labelClass = "control-label";
	let inputClass = "form-control input-group-inset input-group-inset-after";

	if (labelPos === Parameter.LabelPosition.INLINE_LEFT || labelPos === Parameter.LabelPosition.INLINE_RIGHT) {
		groupClass += " autofit - row";
		labelClass += " autofit-col";
		inputClass += " autofit-col autofit-col-expand";
	}

	return (
		<div className={groupClass}>
			<label htmlFor={inputId}>
				{Util.translate("goto")} className={labelClass}
			</label>
			<div className="input-group">
				<div className="input-group-item">
					<div className="dropdown">
						<input
							className={inputClass}
							id={inputId}
							placeholder="Search for..."
							type="text"
							value="ele"
							onChange={() => {}}
						/>
						<span className="input-group-inset-item input-group-inset-item-after">
							<button
								className="btn btn-unstyled"
								type="submit"
							>
								<Icon
									spritemap={spritemap}
									symbol="search"
								/>
							</button>
							<button
								className="btn btn-unstyled"
								type="button"
							>
								<Icon
									spritemap={spritemap}
									symbol="times"
								/>
							</button>
						</span>
						<ul className="autocomplete-dropdown-menu dropdown-menu show">
							<li>
								<a
									className="dropdown-item"
									href="#1"
								>
									ele<strong>ctric toothbrush</strong>
								</a>
							</li>
							<li>
								<a
									className="dropdown-item"
									href="#1"
								>
									ele<strong>ctric kettle</strong>
								</a>
							</li>
							<li>
								<a
									className="dropdown-item"
									href="#1"
								>
									ele<strong>ctric razor</strong>
								</a>
							</li>
							<li>
								<a
									className="dropdown-item"
									href="#1"
								>
									ele<strong>ctrodes for tents</strong>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	);
};

export class SXDataStatusBar extends React.Component {
	constructor(props) {
		super(props);

		this.dataStructure = props.dataStructure;
		this.namespace = props.namespace;
		this.canvasId = props.canvasId;

		if (this.dataStructure.enableInputStatus) {
			this.totalInputs = props.dataStructure.countTotalFields(null);
			this.inputCount = props.dataStructure.countFilledFields(null);
		}

		this.spritemap = props.spritemap;

		this.state = {
			goToBasis: DataStructure.GotoBasis.PARAM_NAME,
			autoCompleteItems: this.dataStructure.enableGoTo
				? this.dataStructure.getGotoAutoCompleteItems(null, DataStructure.GotoBasis.PARAM_NAME)
				: [],
			goToParam: {}
		};
	}

	goTo() {
		console.log("goTo: ", this.state.goToParam);

		if (Util.isNotEmpty(this.state.goToParam)) {
			Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, {
				target: this.canvasId,
				focus: false
			});
			Event.fire(Event.SX_FOCUS, this.namespace, this.namespace, {
				target: this.canvasId,
				paramName: this.state.goToParam.name,
				paramVersion: this.state.goToParam.version
			});
		}
	}

	handleBasisChanged(val) {
		this.setState({
			goToBasis: val,
			autoCompleteItems: this.dataStructure.getGotoAutoCompleteItems(null, this.state.goToBasis)
		});
	}

	handleGoToParamChanged(val) {
		console.log("handleGoToParamChanged: ", this.state.autoCompleteItems.filter((item) => item.name === val)[0]);
		this.setState({
			goToParam: this.state.autoCompleteItems.filter((item) => item.name === val)[0]
		});
	}

	render() {
		console.log("SXDataStatus: ", this.dataStructure);

		return (
			<div style={{ paddingLeft: "10px", paddingRight: "10px", background: "#d8f2df", marginBottom: "15px" }}>
				<Toolbar>
					<Toolbar.Nav>
						<Toolbar.Item expand>
							{this.dataStructure.enableGoTo && (
								<Toolbar.Section>
									<ClayInput.Group>
										<ClayInput.GroupItem shrink>
											<label className="component-title">{Util.translate("goto")}</label>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem shrink>
											<ClaySelectWithOption
												aria-label="Select Label"
												id="mySelectId"
												options={[
													{ label: Util.translate("parameter-name"), value: false },
													{ label: Util.translate("display-name"), value: true }
												]}
												onChange={(e) => this.handleBasisChanged(e.target.val)}
											/>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											shrink
											prepend
										>
											<ClayButtonWithIcon
												aria-labelledby={Util.translate("goto")}
												symbol="search"
												spritemap={this.spritemap}
												displayType="secondary"
												onClick={(e) => this.goTo()}
											/>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											append
											expand="true"
										>
											<Autocomplete
												aria-labelledby={Util.translate("find-parameter")}
												id=""
												defaultItems={this.state.autoCompleteItems.map((item) => item.name)}
												messages={{
													notFound: "No results found"
												}}
												placeholder={Util.translate("enter-keyword")}
												onBlur={(e) => this.handleGoToParamChanged(e.target.value)}
											>
												{(item) => <Autocomplete.Item key={item}>{item}</Autocomplete.Item>}
											</Autocomplete>
										</ClayInput.GroupItem>
									</ClayInput.Group>
								</Toolbar.Section>
							)}
						</Toolbar.Item>
						{this.dataStructure.enableInputStatus && (
							<Toolbar.Item>
								<Toolbar.Section>
									<ClayInput.Group>
										<ClayInput.GroupItem shrink>
											<ClayInput.GroupText>
												{this.inputCount +
													"/" +
													this.totalInputs +
													"(" +
													((this.inputCount / this.totalInputs) * 100).toFixed(1) +
													"%)"}
											</ClayInput.GroupText>
										</ClayInput.GroupItem>
									</ClayInput.Group>
								</Toolbar.Section>
							</Toolbar.Item>
						)}
						<Toolbar.Item>
							<Toolbar.Section>
								<Button.Group spaced>
									<ClayButtonWithIcon
										title={Util.translate("pdf")}
										aria-labelledby={Util.translate("pdf")}
										displayType="secondary"
										symbol="document-pdf"
										spritemap={this.spritemap}
									/>
									<ClayButtonWithIcon
										title={Util.translate("structured-data-editor")}
										aria-labelledby={Util.translate("structured-data-editor")}
										displayType="secondary"
										symbol="order-form-pencil"
										spritemap={this.spritemap}
									/>
								</Button.Group>
							</Toolbar.Section>
						</Toolbar.Item>
					</Toolbar.Nav>
				</Toolbar>
			</div>
		);
	}
}

export class SXPreviewRow extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.parameter.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.parameter.languageId;
		this.availableLanguageIds = props.parameter.availableLanguageIds;
		this.parameter = props.parameter;
		this.spritemap = props.spritemap;

		this.state = {
			focus: props.focus ?? false,
			rendered: false,
			inputStatus: props.inputStatus ?? false,
			underConstruction: false
		};

		this.events = {
			fire: [
				{
					target: props.previewCanvasId,
					event: Event.SX_FIELD_VALUE_CHANGED
				}
			],
			on: [
				{
					target: props.previewCanvasId,
					event: Event.SX_PARAM_PROPERTY_CHANGED
				},
				{
					target: props.previewCanvasId,
					event: Event.SX_PARAM_ERROR_FOUND
				},
				{
					target: props.previewCanvasId,
					event: Event.SX_PARAM_VALUE_CHANGED
				}
			]
		};

		Event.on(Event.SX_DISTRACT_ALL, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.target !== this.previewCanvasId) {
				return;
			}
			if (!this.state.focus) {
				return;
			}

			this.setState({ focus: false });
		});

		Event.on(Event.SX_FOCUS, (e) => {
			const dataPacket = e.dataPacket;
			if (
				dataPacket.targetPortlet !== this.namespace ||
				dataPacket.target !== this.previewCanvasId ||
				dataPacket.paramName !== this.parameter.paramName ||
				dataPacket.paramVersion !== dataPacket.paramVersion
			) {
				return;
			}

			this.setState({ focus: true });
		});
	}

	handleClick(e) {
		if (this.state.focus) {
			return;
		}

		//Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, { target: this.previewCanvasId });

		this.setState({ focus: true });

		Event.fire(Event.SX_PARAMETER_SELECTED, this.namespace, this.namespace, {
			target: this.dsbuilderId,
			paramName: this.parameter.paramName,
			paramVersion: this.parameter.paramVersion
		});
	}

	render() {
		let className = this.state.focus ? "autofit autofit-row sx-focused" : "autofit autofit-row";

		let style = {};
		if (
			this.parameter.paramType === ParamType.BOOLEAN &&
			(this.parameter.viewType === BooleanParameter.ViewTypes.CHECKBOX ||
				this.parameter.viewType === BooleanParameter.ViewTypes.TOGGLE)
		) {
			style = {
				marginTop: "15px",
				marginBottom: "15px"
			};
		}

		return (
			<>
				<div
					className={className + " sx-preview-row"}
					onClick={(e) => this.handleClick(e)}
				>
					<div
						className="autofit-col autofit-col-expand"
						style={{ marginRight: "10px" }}
					>
						{this.parameter.render(this.events, "", style, this.spritemap, this.state.inputStatus)}
					</div>
					<div
						className="autofit-col autofit-col-shrink"
						style={{ alignSelf: "center" }}
					>
						<DropDown
							trigger={
								<ClayButtonWithIcon
									aria-label="Actions"
									symbol="ellipsis-v"
									title="Actions"
									borderless="true"
									className="btn-secondary"
									spritemap={this.spritemap}
								/>
							}
							menuWidth="shrink"
						>
							<DropDown.ItemList
								items={[
									{ name: Util.translate("delete"), symbol: "times" },
									{ name: Util.translate("move-up"), symbol: "order-arrow-up" },
									{ name: Util.translate("move-down"), symbol: "order-arrow-down" }
								]}
							>
								{(actionItem) => (
									<DropDown.Item
										key={actionItem.name}
										onClick={() => this.setState({ underConstruction: true })}
									>
										<Icon
											spritemap={this.spritemap}
											symbol={actionItem.symbol}
											style={{ marginRight: "5px" }}
										/>
										{actionItem.name}
									</DropDown.Item>
								)}
							</DropDown.ItemList>
						</DropDown>
					</div>
				</div>
				{this.state.underConstruction && (
					<SXModalDialog
						header={Util.translate("sorry")}
						body={<UnderConstruction />}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: () => {
									this.setState({ underConstruction: false });
								}
							}
						]}
					/>
				)}
			</>
		);
	}
}

export const SXControlWrapper = ({ labelPosition, label, control }) => {
	switch (labelPosition) {
		case Parameter.LabelPosition.INLINE_LEFT: {
			return (
				<div style={{ display: "inline-flex", maxWidth: "100%" }}>
					{label}
					{control}
				</div>
			);
		}
		case Parameter.LabelPosition.INLINE_RIGHT: {
			return (
				<div style={{ display: "inline-flex", maxWidth: "100%" }}>
					{control}
					{label}
				</div>
			);
		}
		default: {
			return (
				<>
					{label}
					{control}
				</>
			);
		}
	}
};

export const SXFormFieldFeedback = ({ content, level, symbol, spritemap }) => {
	return (
		<ClayForm.FeedbackGroup>
			<ClayForm.FeedbackItem>
				<ClayForm.FeedbackIndicator
					spritemap={spritemap}
					symbol={symbol}
				/>
				{content}
			</ClayForm.FeedbackItem>
		</ClayForm.FeedbackGroup>
	);
};

/****************************************************
 *  01. The type of Parametrer is String and
 * 		localized property is false
 ****************************************************/
export class SXInput extends React.Component {
	constructor(props) {
		super(props);

		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.parameter = props.parameter;
		this.displayType = props.displayType ?? props.parameter.displayType;
		this.viewType = props.viewType ?? props.parameter.viewType;
		this.cellIndex = this.displayType === Parameter.DisplayTypes.CELL ? props.cellIndex : undefined;
		this.inputStatus = props.inputStatus;

		this.parameter.value = this.parameter.hasValue()
			? this.parameter.getValue(this.cellIndex)
			: this.parameter.defaultValue ?? "";

		this.state = {
			value: this.parameter.getValue(this.cellIndex)
		};

		this.focusRef = null;

		console.log("SXInput constructor: " + this.parameter.paramName);
	}

	componentDidMount() {
		Event.on(Event.SX_REFRESH, (event) => {
			console.log("SX_REFRESH_PARAMETER received: ", event);

			const dataPacket = Event.pickUpDataPacket(
				event,
				this.parameter.namespace,
				this.parameter.formId,
				this.parameter.paramName,
				this.parameter.paramVersion
			);

			if (Util.isEmpty(dataPacket)) {
				return;
			}

			if (Util.isNotEmpty(this.cellIndex)) {
				if (this.cellIndex >= 0 && dataPacket.cellIndex === this.cellIndex) {
					this.forceUpdate();
				}
			} else {
				this.forceUpdate();
			}

			this.focusRef.focus();
		});

		Event.on(Event.SX_FOCUS, (event) => {
			const dataPacket = Event.pickUpDataPacket(
				event,
				this.parameter.namespace,
				this.parameter.formId,
				this.parameter.paramName,
				this.parameter.paramVersion
			);

			if (Util.isEmpty(dataPacket)) {
				return;
			}

			this.focusRef.focus();
		});
	}

	handleChange(value) {
		if (value === this.state.value) {
			return;
		}

		this.parameter.dirty = true;

		this.parameter.error = Parameter.validateValue(
			ParamType.STRING,
			this.parameter.validation,
			value,
			this.parameter.languageId
		);

		this.parameter.setValue(value, this.cellIndex);
		this.setState({ value: value });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	getClayUI() {
		return (
			<ClayInput
				component={this.parameter.multipleLine ? "textarea" : "input"}
				id={this.parameter.getTagId(this.cellIndex)}
				name={this.parameter.tagName}
				placeholder={this.parameter.getPlaceholder(this.parameter.languageId)}
				type="text"
				value={this.state.value}
				disabled={this.parameter.disabled}
				onChange={(e) => this.handleChange(e.target.value)}
				ref={(fr) => (this.focusRef = fr)}
			/>
		);
	}

	renderCell() {
		return this.getClayUI();
	}

	renderFormField() {
		const tagId =
			this.displayType === Parameter.DisplayTypes.CELL
				? this.parameter.tagId + "_" + this.cellIndex
				: this.parameter.tagId;
		const tagName = this.parameter.tagName;

		if (this.parameter.prefix || this.parameter.postfix) {
			return (
				<>
					{this.parameter.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.parameter.getDefinition(this.parameter.languageId)}</pre>
						</div>
					)}
					<ClayInput.Group>
						{this.parameter.renderPrefix()}
						<ClayInput.GroupItem>{this.getClayUI()}</ClayInput.GroupItem>
						{this.parameter.renderPostfix()}
					</ClayInput.Group>
				</>
			);
		} else {
			return this.getClayUI();
		}
	}

	render() {
		const className = this.className + " " + this.parameter.errorClass;

		const style = { ...this.style, ...this.parameter.style };
		style.marginBottom = this.style.marginBottom ?? "15px";

		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return (
				<ClayForm.Group
					className={className}
					style={style}
				>
					<SXControlWrapper
						labelPosition={this.parameter.labelPosition}
						label={this.parameter.renderLabel({
							forHtml: this.parameter.tagId,
							spritemap: this.spritemap,
							inputStatus: this.inputStatus
						})}
						control={this.renderFormField()}
					/>
					{this.parameter.dirty && this.parameter.errorClass !== ErrorClass.SUCCESS && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
				</ClayForm.Group>
			);
		} else if (this.parameter.displayType === Parameter.DisplayTypes.CELL) {
			this.renderCell();
		}
	}
}

/****************************************************
 *  02. The type of Parametrer is String and
 * 		localized property is true
 ****************************************************/
export class SXLocalizedInput extends React.Component {
	constructor(props) {
		super(props);

		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.parameter = props.parameter;
		this.cellIndex = this.parameter.displayType === Parameter.DisplayTypes.CELL ? props.cellIndex : undefined;
		this.inputStatus = props.inputStatus;

		this.state = {
			refresh: false,
			selectedLang: props.parameter.languageId,
			translation: this.parameter.getTranslation(this.parameter.languageId, this.cellIndex)
		};
	}

	componentDidMount() {}

	refresh() {
		this.setState({ refresh: !this.state.refresh });
	}

	handleChange(value) {
		if (this.state.translation === value) {
			return;
		}

		this.parameter.setTranslation(this.state.selectedLang, value, this.cellIndex);
		this.parameter.dirty = true;

		this.parameter.error = Parameter.validateValue(
			ParamType.STRING,
			this.parameter.validation,
			this.parameter.value,
			this.state.selectedLang
		);

		this.parameter.fireValueChanged(this.cellIndex);

		this.setState({
			translation: value
		});
	}

	renderLabel(forHtml) {
		return this.state.labelPosition === Parameter.LabelPosition.NONE ? null : (
			<SXLabel
				key={Util.randomKey()}
				label={this.state.label}
				forHtml={forHtml}
				required={this.state.required}
				tooltip={this.state.tooltip}
				spritemap={this.spritemap}
			/>
		);
	}

	getClayUI() {
		return (
			<ClayInput.Group>
				{this.parameter.renderPrefix()}
				<ClayInput.GroupItem>
					<ClayInput
						component={this.parameter.multipleLine ? "textarea" : "input"}
						type="text"
						id={this.parameter.tagId}
						name={this.parameter.tagName}
						value={this.state.translation}
						placeholder={this.parameter.getPlaceholder(this.state.selectedLang)}
						disabled={this.parameter.disabled}
						onChange={(e) => this.handleChange(e.target.value)}
					/>
				</ClayInput.GroupItem>
				{this.parameter.renderPostfix()}
				<ClayInput.GroupItem shrink>
					<DropDown
						trigger={
							<Button
								displayType="secondary"
								className="btn-monospaced btn-md"
							>
								<Icon
									symbol={this.state.selectedLang.toLowerCase()}
									spritemap={this.spritemap}
								/>
								<span className="btn-section">{this.state.selectedLang}</span>
							</Button>
						}
						closeOnClick={true}
					>
						<DropDown.ItemList items={this.parameter.languageFlags}>
							{(flag) => {
								let displayType, label;
								const translations = this.parameter.getTranslations(this.cellIndex);

								if (translations[flag.name]) {
									displayType = "success";
									label = Util.translate("translated");
								} else {
									displayType = "warning";
									label = Util.translate("not-translated");
								}

								return (
									<DropDown.Item
										key={flag.name}
										onClick={() => {
											this.setState({
												selectedLang: flag.name,
												translation: this.parameter.getTranslation(flag.name)
											});
										}}
										active={this.state.selectedLang === flag.name}
									>
										<Icon
											spritemap={this.spritemap}
											symbol={flag.symbol}
											style={{
												marginRight: "5px"
											}}
										/>
										{flag.name}
										<ClayLabel
											displayType={displayType}
											spritemap={this.spritemap}
											style={{
												float: "right"
											}}
										>
											{label}
										</ClayLabel>
									</DropDown.Item>
								);
							}}
						</DropDown.ItemList>
					</DropDown>
				</ClayInput.GroupItem>
			</ClayInput.Group>
		);
	}

	renderCell() {
		return this.getClayUI();
	}

	renderFormField() {
		return (
			<>
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.definition}</pre>
					</div>
				)}
				{this.getClayUI()}
			</>
		);
	}

	render() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.error.errorClass : "");

		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return (
				<ClayForm.Group
					className={className}
					style={this.style}
				>
					<SXControlWrapper
						displayType={this.parameter.displayType}
						label={this.parameter.renderLabel({
							forHtml: this.parameter.tagId,
							spritemap: this.spritemap,
							inputStatus: this.inputStatus
						})}
						control={<>{this.renderFormField()}</>}
					/>
					{this.parameter.dirty && this.parameter.errorClass !== ErrorClass.SUCCESS && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
				</ClayForm.Group>
			);
		} else if (this.parameter.displayType === Parameter.DisplayTypes.CELL) {
			return this.renderCell();
		}
	}
}

/****************************************************
 *  03. The type of Parametrer is Numeric and
 * 		integer property is false
 ****************************************************/
export class SXNumeric extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.availableLanguageIds = props.availableLanguageIds;
		this.languageId = props.languageId;

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			tooltip: props.tooltip ?? "",
			required: props.required ?? false,
			disabled: props.disabled ?? false,
			uncertainty: props.uncertainty ?? false,
			validation: props.validation ?? {},
			isInteger: props.isInteger ?? false,
			index: props.index ?? 0,
			unit: props.unit ?? "",
			decimalPlaces: props.decimalPlaces ?? "1",
			textValue: "",
			textUncertainty: "",
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		console.log("props.value: ", props.value);
		this.convertValueToText(props.value);

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					console.log("SXNumeric event register: SX_PARAM_PROPERTY_CHANGED");
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						if (dataPacket.property === ParamProperty.VALUE) {
							this.convertValueToText(dataPacket.value);
						} else {
							let stateObj = {};
							stateObj[dataPacket.property] = dataPacket.value;

							this.setState(stateObj);
						}
					});
				}
			});
		}
	}

	convertValueToText(value) {
		if (this.state.uncertainty) {
			if (Util.isNotEmpty(value)) {
				this.state.textValue = Util.isEmpty(value.value) ? "" : value.value.toString();
				this.state.textUncertainty = Util.isEmpty(value.uncertainty) ? "" : value.uncertainty.toString();
			}
		} else {
			this.state.textValue = Util.isEmpty(value) ? "" : value.toString();
		}
	}

	convertTextToValue(textValue, textUncertainty) {
		return this.state.uncertainty
			? {
					value: Util.isNotEmpty(textValue) ? Number(textValue).toFixed(this.state.decimalPlaces) : undefined,
					uncertainty: Util.isNotEmpty(textUncertainty)
						? Number(textUncertainty).toFixed(this.state.decimalPlaces)
						: undefined
			  }
			: Util.isNotEmpty(textValue)
			? Number(textValue).toFixed(this.state.decimalPlaces)
			: undefined;
	}

	handleValueChanged(val) {
		if (this.state.textValue === val) {
			return;
		}

		let error = {};
		let textValue = "";
		let fixedVal;
		if (Util.isNotEmpty(val)) {
			fixedVal = this.state.isInteger ? Math.trunc(Number(val)) : Number(val).toFixed(this.state.decimalPlaces);
			console.log("SXNumeric handleValueChanged: ", this.state.isInteger, fixedVal);

			error = Parameter.validateValue(ParamType.NUMERIC, this.state.validation, fixedVal, this.languageId);

			textValue = fixedVal.toString();
		}

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							targetFormId: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: this.convertTextToValue(
								isNaN(textValue) ? this.state.textValue : textValue,
								this.state.textUncertainty
							),
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					}
				}
			});
		}

		this.dirty = true;

		this.setState((prevState) => {
			return { textValue: isNaN(textValue) ? prevState.textValue : textValue, error: error };
		});
	}

	handleUncertaintyChanged(val) {
		if (val === this.state.textUncertainty) {
			return;
		}

		const fixedVal = this.state.isInteger ? Math.trunc(Number(val)) : Number(val).toFixed(this.state.decimalPlaces);

		let error;
		if (isNaN(fixedVal)) {
			error = { errorClass: ErrorClass.ERROR, message: Util.translate("only-numbers-allowed-for-this-field") };
		} else {
			error = { errorClass: ErrorClass.SUCCESS, message: "" };
		}

		let textUncertainty = fixedVal.toString();

		this.setState((prevState) => {
			return {
				textUncertainty: isNaN(textUncertainty) ? prevState.textUncertainty : textUncertainty,
				error: error
			};
		});

		this.dirty = true;

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: this.convertTextToValue(
								this.state.textValue,
								isNaN(textUncertainty) ? this.state.textUncertainty : textUncertainty
							),
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					}
				}
			});
		}
	}

	renderLabel(forHtml) {
		return this.state.labelPosition === Parameter.LabelPosition.NONE ? null : (
			<SXLabel
				key={Util.randomKey()}
				label={this.state.label}
				forHtml={forHtml}
				required={this.state.required}
				tooltip={this.state.tooltip}
				spritemap={this.spritemap}
			/>
		);
	}

	render() {
		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				<SXControlWrapper
					labelPosition={this.state.labelPosition}
					label={this.renderLabel(tagId)}
					control={
						<>
							{this.state.showDefinition && (
								<div className="sx-param-definition">
									<pre>{this.state.definition}</pre>
								</div>
							)}
							<ClayInput.Group stacked>
								{Parameter.checkValidationEnabled(this.state.validation, ValidationKeys.MIN) && (
									<>
										<ClayInput.GroupItem
											prepend
											shrink
										>
											<ClayInput.GroupText>
												{Parameter.getValidationValue(
													this.state.validation,
													ValidationKeys.MIN,
													ValidationSectionProperty.VALUE
												)}
											</ClayInput.GroupText>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											append
											shrink
										>
											{Parameter.getValidationValue(
												this.state.validation,
												ValidationKeys.MIN,
												ValidationSectionProperty.BOUNDARY
											) ? (
												<ClayInput.GroupText>&#8804;</ClayInput.GroupText>
											) : (
												<ClayInput.GroupText>{"<"}</ClayInput.GroupText>
											)}
										</ClayInput.GroupItem>
									</>
								)}
								<ClayInput.GroupItem append>
									<ClayInput
										type={this.state.isInteger ? "number" : "text"}
										defaultValue={this.state.textValue}
										onBlur={(e) => this.handleValueChanged(e.target.value)}
									/>
								</ClayInput.GroupItem>
								{this.state.unit && (
									<ClayInput.GroupItem
										append
										shrink
									>
										<ClayInput.GroupText>{this.state.unit}</ClayInput.GroupText>
									</ClayInput.GroupItem>
								)}
								{this.state.uncertainty && (
									<>
										<ClayInput.GroupItem
											append
											shrink
										>
											<ClayInput.GroupText>&#177;</ClayInput.GroupText>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											append
											shrink
											style={{ maxWidth: "200px", width: "120px" }}
										>
											<ClayInput
												type={this.state.isInteger ? "number" : "text"}
												defaultValue={this.state.textUncertainty}
												onBlur={(e) => this.handleUncertaintyChanged(e.target.value)}
											/>
										</ClayInput.GroupItem>
									</>
								)}
								{Parameter.checkValidationEnabled(this.state.validation, ValidationKeys.MAX) && (
									<>
										<ClayInput.GroupItem
											append
											shrink
										>
											{Parameter.getValidationValue(
												this.state.validation,
												ValidationKeys.MAX,
												ValidationSectionProperty.BOUNDARY
											) ? (
												<ClayInput.GroupText>&#8804;</ClayInput.GroupText>
											) : (
												<ClayInput.GroupText>{"<"}</ClayInput.GroupText>
											)}
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											append
											shrink
										>
											<ClayInput.GroupText>
												{Parameter.getValidationValue(
													this.state.validation,
													ValidationKeys.MAX,
													ValidationSectionProperty.VALUE
												)}
											</ClayInput.GroupText>
										</ClayInput.GroupItem>
									</>
								)}
							</ClayInput.Group>
						</>
					}
				/>
				{this.dirty &&
					(this.state.error.errorClass === ErrorClass.ERROR ||
						this.state.error.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.state.error.message}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</ClayForm.Group>
		);
	}
}

/****************************************************
 *  04. The type of Parametrer is Numeric and
 * 		integer property is true
 ****************************************************/
export class SXInteger extends React.Component {
	constructor(props) {
		super(props);
	}

	render() {
		return <></>;
	}
}

/****************************************************
 *  05. Boolean
 *
 * - viewTypes: dropdown, radio, toogle
 ****************************************************/
export class SXBoolean extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			trueLabel: props.trueLabel ?? "",
			falseLabel: props.falseLabel ?? "",
			required: props.required ?? false,
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			value: props.value,
			viewType: props.viewType,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						console.log(
							"SXBoolean property changed " + this.state.paramName + ": ",
							dataPacket.property,
							dataPacket.value
						);

						let stateObj = {};
						stateObj[dataPacket.property] = dataPacket.value;

						this.setState(stateObj);
					});
				}
			});
		}
	}

	handleSelect(val) {
		console.log("SXBoolean handleSelect: ", val);
		this.setState({ value: val });

		if (!this.dirty) this.dirty = true;

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, this.namespace, this.namespace, {
						target: event.target,
						value: val,
						paramName: this.state.paramName,
						paramVersion: this.state.paramVersion
					});
				}
			});
		}
	}

	handleOnChange(e) {
		this.setState({ value: !this.state.value });
		if (!this.dirty) this.dirty = true;

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, this.namespace, this.namespace, {
						target: event.target,
						value: !this.state.value,
						paramName: this.state.paramName,
						paramVersion: this.state.paramVersion
					});
				}
			});
		}
	}

	render() {
		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				{this.state.viewType === BooleanParameter.ViewTypes.CHECKBOX && (
					<ClayCheckbox
						id={tagId}
						name={tagName}
						aria-label={this.state.label}
						label={
							<SXLabel
								label={this.state.label}
								forHtml={tagId}
								required={this.state.required}
								tooltip={this.state.tooltip}
								spritemap={this.spritemap}
							/>
						}
						checked={this.state.value}
						onChange={(e) => this.handleOnChange(e)}
						disabled={this.state.disabled}
					/>
				)}
				{this.state.viewType === BooleanParameter.ViewTypes.DROPDOWN && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<ClaySelect
							id={tagId}
							name={tagName}
							defaultValue={this.state.value}
							onSelect={(val) => this.handleSelect(val)}
							disabled={this.state.disabled}
						>
							<ClaySelect.Option
								label={this.state.trueLabel}
								value="true"
							/>
							<ClaySelect.Option
								label={this.state.falseLabel}
								value="false"
							/>
						</ClaySelect>
					</>
				)}
				{this.state.viewType === BooleanParameter.ViewTypes.RADIO && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<ClayRadioGroup
							id={tagId}
							name={tagName}
							value={this.state.value}
							onChange={(val) => this.handleSelect(val)}
							inline
							style={{ marginLeft: "15px" }}
						>
							<ClayRadio
								label={this.state.trueLabel}
								value={true}
								disabled={this.state.disabled}
							/>
							<ClayRadio
								label={this.state.falseLabel}
								value={false}
								disabled={this.state.disabled}
							/>
						</ClayRadioGroup>
					</>
				)}
				{this.state.viewType === BooleanParameter.ViewTypes.TOGGLE && (
					<ClayToggle
						id={tagId}
						name={tagName}
						label={
							<SXLabel
								label={this.state.label}
								forHtml={tagId}
								required={this.state.required}
								tooltip={this.state.tooltip}
								spritemap={this.spritemap}
							/>
						}
						onToggle={(e) => this.handleOnChange(e)}
						spritemap={this.spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={this.state.value}
						disabled={this.state.disabled}
						sizing="md"
					/>
				)}
				{this.dirty &&
					(this.state.error.errorClass === ErrorClass.ERROR ||
						this.state.error.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.state.error.message}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</ClayForm.Group>
		);
	}
}

/****************************************************
 *  06. The type of Parametrer is Select and
 * 		displayStyle property is DualListBox
 * 	viewTypes: dropdown, radio
 ****************************************************/
export class SXSelect extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;
		this.selectedOptionChanged = false;

		this.state = {
			error: "",
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			placeholder: props.placeholder ?? "",
			required: props.required ?? false,
			value:
				props.value ??
				(props.viewType === SelectParameter.ViewTypes.CHECKBOX || props.viewType === SelectParameter.LISTBOX
					? []
					: ""),
			tooltip: props.tooltip ?? "",
			options: props.options ?? [],
			optionsPerRow: props.optionsPerRow ?? 1,
			disabled: props.disabled ?? false,
			viewType: props.viewType ?? SelectParameter.ViewTypes.DROPDOWN,
			validation: props.validation ?? {},
			index: props.index,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};
						newState[dataPacket.property] = dataPacket.value;

						newState.underConstruction = false;
						if (dataPacket.property === ParamProperty.VIEW_TYPE) {
							if (
								dataPacket.value === SelectParameter.ViewTypes.CHECKBOX ||
								dataPacket.value === SelectParameter.ViewTypes.LISTBOX
							) {
								if (!this.isMultiple()) {
									newState.value = Util.isEmpty(this.state.value) ? [] : [this.state.value];
								}
							} else {
								if (this.isMultiple()) {
									newState.value = Util.isEmpty(this.state.value) ? "" : this.state.value[0];
								}
							}
						}

						this.setState(newState);
					});
				}
			});
		}
	}

	isMultiple() {
		return (
			this.state.viewType === SelectParameter.ViewTypes.CHECKBOX ||
			this.state.viewType === SelectParameter.ViewTypes.LISTBOX
		);
	}

	handleRadioClick(val) {
		if (this.state.value === val) {
			this.setState({ value: "" });
			this.dirty = true;
		}
	}

	handleValueChange(val) {
		let newValue = val;
		if (this.isMultiple()) {
			if (this.state.value.includes(val)) {
				newValue = this.state.value.filter((elem) => elem !== val);
			} else {
				newValue = [...this.state.value, val];
			}
		}

		this.setState({ value: newValue });

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, this.namespace, this.namespace, {
						target: event.target,
						value: val,
						paramName: this.state.paramName,
						paramVersion: this.state.paramVersion,
						index: this.state.index
					});
				}
			});
		}

		this.dirty = true;
	}

	render() {
		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		const className = this.className + (this.dirty ? this.state.error.errorClass : "");
		const optionRows = Util.convertArrayToRows(this.state.options, this.state.optionsPerRow);
		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				{this.state.viewType === SelectParameter.ViewTypes.DROPDOWN && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
							spritemap={this.spritemap}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<ClaySelect
							id={tagId}
							name={tagName}
							value={this.state.value}
							disabled={this.state.disabled}
							onChange={(e) => {
								this.handleValueChange(e.target.value);
							}}
						>
							{this.state.options.map((option, index) => {
								return (
									<ClaySelect.Option
										key={option.value}
										label={option.label}
										value={option.value}
									/>
								);
							})}
						</ClaySelect>
					</>
				)}
				{this.state.viewType === SelectParameter.ViewTypes.RADIO && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
							spritemap={this.spritemap}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<ClayRadioGroup
							name={tagName}
							style={{ marginLeft: "10px" }}
						>
							{optionRows.map((row) => (
								<div
									key={Util.randomKey()}
									className="form-group form-group-autofit"
									style={{ marginBottom: "5px" }}
								>
									{row.map((option) => (
										<div
											key={Util.randomKey()}
											className="form-group-item"
											style={{ marginBottom: "0" }}
										>
											<ClayRadio
												key={option.value}
												label={option.label}
												value={option.value}
												checked={this.state.value === option.value}
												onClick={(e) => this.handleRadioClick(e.target.value)}
												onChange={(e) => {
													e.stopPropagation();
													this.handleValueChange(option.value);
												}}
												disabled={this.state.disabled}
											/>
										</div>
									))}
								</div>
							))}
						</ClayRadioGroup>
					</>
				)}
				{this.state.viewType === SelectParameter.ViewTypes.CHECKBOX && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
							spritemap={this.spritemap}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<div
							name={tagName}
							id={tagId}
							style={{ marginLeft: "10px" }}
						>
							{optionRows.map((row, rowIndex) => (
								<div
									key={Util.randomKey()}
									className="form-group form-group-autofit"
									style={{ marginBottom: "5px" }}
								>
									{row.map((option, optionIndex) => {
										const valueIndex = this.state.optionsPerRow * rowIndex + optionIndex;

										return (
											<div
												key={Util.randomKey()}
												className="form-group-item"
												style={{ marginBottom: "0" }}
											>
												<ClayCheckbox
													key={option.value}
													label={option.label}
													checked={this.state.value.includes(option.value)}
													onChange={(e) => {
														e.stopPropagation();
														this.handleValueChange(option.value);
													}}
													disabled={this.state.disabled}
												/>
											</div>
										);
									})}
								</div>
							))}
						</div>
					</>
				)}
				{this.state.viewType === SelectParameter.ViewTypes.LISTBOX && (
					<>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
							spritemap={this.spritemap}
						/>
						{this.state.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.state.definition}</pre>
							</div>
						)}
						<ClaySelectBox
							id={tagId}
							name={tagName}
							value={this.state.value}
							items={this.state.options}
							multiple
							disabled={this.state.disabled}
							onClick={(e) => {
								if (this.selectedOptionChanged) {
									this.selectedOptionChanged = false;
								} else if (this.state.value.includes(e.target.value)) {
									this.setState({
										value: this.state.value.filter((value) => value !== e.target.value)
									});
								}
							}}
							onSelectChange={(val) => {
								this.selectedOptionChanged = true;
								this.setState({ value: val });
							}}
						/>
					</>
				)}
				{this.dirty &&
					(this.state.error.errorClass === ErrorClass.ERROR ||
						this.state.error.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.state.error.message}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</ClayForm.Group>
		);
		/*
		if (this.state.viewType === SelectParameter.ViewTypes.DROPDOWN) {
			return (
				<div
					className={"form-grorp " + className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
					{this.state.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.state.definition}</pre>
						</div>
					)}
					<ClaySelect
						id={tagId}
						name={tagName}
						value={this.state.value}
						disabled={this.state.disabled}
						onChange={(e) => {
							this.handleValueChange(e.target.value);
						}}
					>
						{this.state.options.map((option, index) => {
							return (
								<ClaySelect.Option
									key={option.value}
									label={option.label}
									value={option.value}
								/>
							);
						})}
					</ClaySelect>
				</div>
			);
		} else if (this.state.viewType === SelectParameter.ViewTypes.RADIO) {
			const optionRows = Util.convertArrayToRows(this.state.options, this.state.optionsPerRow);
			return (
				<div
					className={"form-group " + className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
					{this.state.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.state.definition}</pre>
						</div>
					)}
					<ClayRadioGroup
						name={tagName}
						style={{ marginLeft: "10px" }}
					>
						{optionRows.map((row) => (
							<div
								key={Util.randomKey()}
								className="form-group form-group-autofit"
								style={{ marginBottom: "5px" }}
							>
								{row.map((option) => (
									<div
										key={Util.randomKey()}
										className="form-group-item"
										style={{ marginBottom: "0" }}
									>
										<ClayRadio
											key={option.value}
											label={option.label}
											value={option.value}
											checked={this.state.value === option.value}
											onClick={(e) => this.handleRadioClick(e.target.value)}
											onChange={(e) => {
												e.stopPropagation();
												this.handleValueChange(option.value);
											}}
											disabled={this.state.disabled}
										/>
									</div>
								))}
							</div>
						))}
					</ClayRadioGroup>
				</div>
			);
		} else if (this.state.viewType === SelectParameter.ViewTypes.CHECKBOX) {
			const optionRows = Util.convertArrayToRows(this.state.options, this.state.optionsPerRow);
			return (
				<div
					className={"form-group " + className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
					{this.state.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.state.definition}</pre>
						</div>
					)}
					<div
						name={tagName}
						id={tagId}
						style={{ marginLeft: "10px" }}
					>
						{optionRows.map((row, rowIndex) => (
							<div
								key={Util.randomKey()}
								className="form-group form-group-autofit"
								style={{ marginBottom: "5px" }}
							>
								{row.map((option, optionIndex) => {
									const valueIndex = this.state.optionsPerRow * rowIndex + optionIndex;

									return (
										<div
											key={Util.randomKey()}
											className="form-group-item"
											style={{ marginBottom: "0" }}
										>
											<ClayCheckbox
												key={option.value}
												label={option.label}
												checked={this.state.value.includes(option.value)}
												onChange={(e) => {
													e.stopPropagation();
													this.handleValueChange(option.value);
												}}
												disabled={this.state.disabled}
											/>
										</div>
									);
								})}
							</div>
						))}
					</div>
				</div>
			);
		} else if (this.state.viewType === SelectParameter.ViewTypes.LISTBOX) {
			return (
				<div
					className={"form-grorp " + className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
					{this.state.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.state.definition}</pre>
						</div>
					)}
					<ClaySelectBox
						id={tagId}
						name={tagName}
						value={this.state.value}
						items={this.state.options}
						multiple
						disabled={this.state.disabled}
						onClick={(e) => {
							if (this.selectedOptionChanged) {
								this.selectedOptionChanged = false;
							} else if (this.state.value.includes(e.target.value)) {
								this.setState({ value: this.state.value.filter((value) => value !== e.target.value) });
							}
						}}
						onSelectChange={(val) => {
							this.selectedOptionChanged = true;
							this.setState({ value: val });
						}}
					/>
				</div>
			);
		}
			*/
	}
}

/****************************************************
 *  07. The type of Parametrer is Select and
 * 		displayStyle property is DualListBox
 ****************************************************/
// 04.1. when displayStyle is dual list box
export class SXDualListBox extends React.Component {
	constructor(props) {
		super(props);

		console.log("DualListBox props: ", props);
		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.inputStatus = props.inputStatus ?? false;

		this.state = {
			refresh: false,
			leftOptions: this.leftOptionsToListItem(),
			rightOptions: this.rightOptionsToListItem(),
			leftSelected: [],
			rightSelected: []
		};
	}

	componentDidMount() {}

	refresh() {
		this.setState({ refresh: !this.state.refresh });
	}

	leftOptionsToListItem() {
		return this.parameter.leftOptions.map((option) => ({
			label: option.displayName[this.parameter.languageId],
			value: option.id
		}));
	}

	rightOptionsToListItem() {
		return this.parameter.rightOptions.map((option) => ({
			label: option.displayName[this.parameter.languageId],
			value: option.id
		}));
	}

	handleLeftSelectChange(selects, a) {
		this.setState({ leftSelected: selects.map((value) => Number(value)) });
	}

	handleRightSelectChange(selects, a) {
		this.setState({ rightSelected: selects.map((value) => Number(value)) });
	}

	handleRemoveBtnClick(e) {
		const left = this.state.leftOptions.filter((item) => !this.state.leftSelected.includes(item.value));
		const leave = this.state.leftOptions.filter((item) => this.state.leftSelected.includes(item.value));

		this.setState({
			leftOptions: left,
			rightOptions: [...this.state.rightOptions, ...leave]
		});

		this.parameter.setValueByIds(left.map((item) => Number(item.value)));

		this.parameter.error = Parameter.validateValue(
			ParamType.DUALLIST,
			this.parameter.validation,
			left,
			this.parameter.languageId
		);

		this.parameter.fireValueChanged(this.cellIndex);
	}

	handleAddBtnClick(e) {
		const left = this.state.rightOptions.filter((item) => !this.state.rightSelected.includes(item.value));
		const leave = this.state.rightOptions.filter((item) => this.state.rightSelected.includes(item.value));

		console.log("DualListBox.handleAddBtnClick(): ", this.parameter, this.state.rightSelected, left, [
			...this.state.leftOptions,
			...leave
		]);

		this.parameter.error = Parameter.validateValue(
			ParamType.DUALLIST,
			this.parameter.validation,
			left,
			this.parameter.languageId
		);

		this.setState({
			leftOptions: [...this.state.leftOptions, ...leave],
			rightOptions: left
		});

		this.parameter.setValueByIds([...this.state.leftOptions, ...leave].map((item) => Number(item.value)));

		this.parameter.fireValueChanged(this.cellIndex);
	}

	render() {
		console.log("DualListBox.render(): ", this.inputStatus, this.parameter);

		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return (
				<ClayForm.Group
					className={this.className}
					style={this.style}
				>
					{this.parameter.renderLabel({
						forHtml: this.parameter.tagId,
						spritemap: this.spritemap,
						inputStatus: this.inputStatus
					})}
					{this.parameter.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.parameter.getDefinition()}</pre>
						</div>
					)}
					<div className="sx-dual-listbox">
						<div
							className={
								"sx-dual-listbox-item sx-dual-listbox-item-expand listbox-left form-group " +
								this.parameter.errorClass
							}
						>
							<ClaySelectBox
								items={this.state.leftOptions}
								label="In Use"
								multiple
								onSelectChange={(selected) => this.handleLeftSelectChange(selected)}
								spritemap={this.spritemap}
								value={this.state.leftSelected}
								disabled={this.parameter.disabled}
								style={{ marginBottom: "5px" }}
							/>
							{this.parameter.dirty && this.parameter.errorClass !== ErrorClass.SUCCESS && (
								<ClayForm.FeedbackGroup>
									<ClayForm.FeedbackItem>
										<ClayForm.FeedbackIndicator
											spritemap={this.spritemap}
											symbol="exclamation-full"
										/>
										{this.parameter.errorMessage}
									</ClayForm.FeedbackItem>
								</ClayForm.FeedbackGroup>
							)}
						</div>
						<div className="btn-group-vertical sx-dual-listbox-actions sx-dual-listbox-item">
							<ClayButtonWithIcon
								aria-label="Remove"
								spritemap={this.spritemap}
								symbol="caret-right"
								displayType="secondary"
								title="Remove"
								className="transfer-button-ltr btn btn-monospaced btn-sm btn-secondary"
								disabled={this.parameter.disabled}
								onClick={(e) => this.handleRemoveBtnClick(e)}
							/>
							<ClayButtonWithIcon
								aria-label="Add"
								spritemap={this.spritemap}
								symbol="caret-left"
								displayType="secondary"
								title="Add"
								className="transfer-button-ltr btn btn-monospaced btn-sm btn-secondary"
								disabled={this.parameter.disabled}
								onClick={(e) => this.handleAddBtnClick(e)}
							/>
						</div>
						<div className="sx-dual-listbox-item sx-dual-listbox-item-expand listbox-right form-group">
							<ClaySelectBox
								items={this.state.rightOptions}
								label="Availables"
								multiple
								onSelectChange={(selected) => this.handleRightSelectChange(selected)}
								spritemap={this.spritemap}
								value={this.state.rightSelected}
								disabled={this.parameter.disabled}
							/>
						</div>
					</div>
				</ClayForm.Group>
			);
		}
	}
}

/****************************************************
 *  05. Matrix
 ****************************************************/
export const SXMatrix = () => {
	return <></>;
};

/****************************************************
 *  06. File
 ****************************************************/
export class SXFile extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			index: props.index,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false,
			value: props.value ?? [],
			underConstruction: false
		};

		this.inputRef = React.createRef();

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};
						newState[dataPacket.property] = dataPacket.value;

						this.setState(newState);
					});
				}
			});
		}
	}

	handleFileSelectionChanged(files) {
		let value = Util.isEmpty(this.state.value) ? [] : this.state.value.filter((fileInfo) => fileInfo.fileId > 0);

		for (let i = 0; i < files.length; i++) {
			const file = files[i];
			console.log("SXFile info: ", file.name, file.size, file.type);
			value.push({
				fileId: 0,
				name: file.name,
				size: file.size,
				type: file.type,
				file: file
			});
		}

		const error = Parameter.validateValue(ParamType.FILE, this.state.validation, value, this.languageId);
		this.setState({ value: value, error: error });

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: value,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					}
				}
			});
		}
	}

	handleActionClick(action, fileInfo) {
		console.log("handleActionClick: ", action, fileInfo);
		switch (action) {
			case "download":
			case "upload": {
				this.setState({ underConstruction: true });

				break;
			}
			case "delete": {
				console.log("files VALUE: ", this.state.value);
				const dataTransfer = new DataTransfer();

				let files = this.state.value
					.filter((fileItem) => {
						console.log(
							"fileItem: ",
							fileItem,
							fileInfo,
							fileItem.fileId === 0,
							fileItem.name !== fileInfo.name
						);
						return fileItem.fileId === 0 && fileItem.name !== fileInfo.name;
					})
					.map((fileItem) => fileItem.file);

				console.log("mapped files: ", files);
				files.forEach((file) => dataTransfer.items.add(file));

				this.inputRef.current.files = dataTransfer.files;

				this.handleFileSelectionChanged(files);

				break;
			}
		}
	}

	render() {
		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				<SXLabel
					label={this.state.label}
					forHtml={tagId}
					required={this.state.required}
					tooltip={this.state.tooltip}
					spritemap={this.spritemap}
				/>
				{this.state.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.state.definition}</pre>
					</div>
				)}
				<ClayInput
					type="file"
					disabled={this.state.disabled}
					multiple={true}
					ref={this.inputRef}
					onChange={(e) => {
						this.handleFileSelectionChanged(e.target.files);
					}}
				/>
				{Util.isNotEmpty(this.state.value) &&
					this.state.value.map((fileInfo) => (
						<div
							key={fileInfo.name}
							className="autofit-row autofit-row-center autofit-padded-no-gutters-x"
							style={{ fontSize: "0.725rem" }}
						>
							<div
								className="autofit-col"
								style={{ width: "4rem", textAlign: "center" }}
							>
								{fileInfo.id > 0 ? fileInfo.id : "-"}
							</div>
							<div className="autofit-col autofit-col-expand">{fileInfo.name}</div>
							<div className="autofit-col">{fileInfo.size}</div>
							<div className="autofit-col">{fileInfo.type}</div>
							<div className="autofit-col">
								<DropDown
									trigger={
										<ClayButtonWithIcon
											aria-label="Actions"
											symbol="ellipsis-v"
											title="Actions"
											borderless="true"
											displayType="secondary"
											size="xs"
											spritemap={this.spritemap}
										/>
									}
									menuWidth="shrink"
								>
									<DropDown.ItemList
										items={
											fileInfo.fileId > 0
												? [
														{
															id: "delete",
															name: Util.translate("delete"),
															symbol: "times"
														},
														{
															id: "download",
															name: Util.translate("download"),
															symbol: "download"
														}
												  ]
												: [
														{
															id: "delete",
															name: Util.translate("delete"),
															symbol: "times"
														},
														{
															id: "upload",
															name: Util.translate("upload"),
															symbol: "upload"
														}
												  ]
										}
									>
										{(actionItem) => (
											<DropDown.Item
												key={actionItem.name}
												onClick={() => this.handleActionClick(actionItem.id, fileInfo)}
											>
												<Icon
													spritemap={this.spritemap}
													symbol={actionItem.symbol}
													style={{ marginRight: "5px" }}
												/>
												{actionItem.name}
											</DropDown.Item>
										)}
									</DropDown.ItemList>
								</DropDown>
							</div>
						</div>
					))}
				{this.state.underConstruction && (
					<SXModalDialog
						header={Util.translate("sorry")}
						body={<UnderConstruction />}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: () => {
									this.setState({ underConstruction: false });
								}
							}
						]}
					/>
				)}
			</ClayForm.Group>
		);
	}
}

/*09. Address */
export class SXAddress extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;
		this.selectedOptionChanged = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			viewType: props.viewType ?? AddressParameter.ViewTypes.BLOCK,
			index: props.index,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false,
			zipcode: Util.isEmpty(props.value) ? "" : props.value.zipcode,
			street: Util.isEmpty(props.value) ? "" : props.value.street,
			address: Util.isEmpty(props.value) ? "" : props.value.address,
			underConstruction: props.viewType === AddressParameter.ViewTypes.ONE_LINE ? true : false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};
						if (dataPacket.property === ParamType.VALUE) {
							if (Util.isNotEmpty(props.value)) {
								this.setState({
									zipcode: props.value.zipcode,
									street: props.value.street,
									address: props.value.address
								});
							} else {
								this.setState({
									zipcode: "",
									street: "",
									address: ""
								});
							}
						} else {
							newState[dataPacket.property] = dataPacket.value;
						}

						if (
							dataPacket.property === ParamProperty.VIEW_TYPE &&
							dataPacket.value === AddressParameter.ViewTypes.ONE_LINE
						) {
							newState.underConstruction = true;
						}

						this.setState(newState);
					});
				}
			});
		}
	}

	handleAddressSearch() {
		new daum.Postcode({
			width: 500,
			height: 600,
			oncomplete: (data) => {
				console.log("address data: ", data);

				const street =
					data.userSelectionType === "R"
						? this.languageId === "ko-KR"
							? data.address
							: data.addressEnglish
						: this.languageId === "ko-KR"
						? data.roadAddres
						: data.roadAddressEnglish;

				this.dirty = true;
				this.setState({ zipcode: data.zonecode, street: street, address: "" });
			}
		}).open();
	}

	handleAddressChanged(address) {
		const error = Parameter.validateValue(ParamType.ADDRESS, this.state.validation, address, this.languageId);

		this.setState({ address: address, error: error });

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: {
								zipcode: this.state.zipcode,
								street: this.state.street,
								address: address
							},
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					}
				}
			});
		}

		this.dirty = true;
	}

	render() {
		const tagId = this.state.tagId ?? this.namespace + this.state.paramName;
		const tagName = this.state.tagName ?? tagId;

		const className = this.className + (this.dirty ? this.state.error.errorClass : "");
		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				<SXLabel
					label={this.state.label}
					forHtml={tagId}
					required={this.state.required}
					tooltip={this.state.tooltip}
					spritemap={this.spritemap}
				/>
				{this.state.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.state.definition}</pre>
					</div>
				)}
				{!this.dirty && (
					<ClayInput.GroupItem shrink>
						<Button
							onClick={(e) => this.handleAddressSearch()}
							size="sm"
						>
							<span className="inline-item inline-item-before">
								<Icon
									symbol="search"
									spritemap={this.spritemap}
								/>
							</span>
							{Util.translate("search-address")}
						</Button>
					</ClayInput.GroupItem>
				)}
				{this.dirty && this.state.viewType === AddressParameter.ViewTypes.INLINE && (
					<ClayInput.Group style={{ marginLeft: "10px" }}>
						<ClayInput.GroupItem
							shrink
							style={{ alignSelf: "center" }}
						>
							<ClayButtonWithIcon
								aria-label={Util.translate("search-address")}
								symbol="search"
								onClick={(e) => this.handleAddressSearch()}
								size="sm"
								spritemap={this.spritemap}
							/>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem
							prepend
							shrink
							style={{ width: "min-content" }}
						>
							<ClayInput
								style={{ minWidth: "5rem" }}
								defaultValue={this.state.zipcode}
								readOnly={true}
							/>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem
							append
							shrink
						>
							<span style={{ alignContent: "end" }}>,</span>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem
							prepend
							shrink
							style={{ width: "min-content" }}
						>
							<ClayInput
								defaultValue={this.state.street}
								readOnly={true}
								style={{
									minWidth: "15rem",
									width: "70%"
								}}
							/>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem
							append
							shrink
						>
							<span style={{ alignContent: "end" }}>,</span>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem prepend>
							<ClayInput
								aria-label={Util.translate("address")}
								value={this.state.address}
								placeholder={Util.translate("detail-address")}
								disabled={!this.dirty}
								onChange={(e) => this.handleAddressChanged(e.target.value)}
							/>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				)}
				{this.dirty && this.state.viewType === AddressParameter.ViewTypes.BLOCK && (
					<div style={{ marginLeft: "10px" }}>
						<div style={{ display: "block" }}>
							<span>{this.state.zipcode}</span>
							<ClayButtonWithIcon
								aria-label={Util.translate("search-address")}
								symbol="search"
								onClick={(e) => this.handleAddressSearch()}
								size="sm"
								spritemap={this.spritemap}
								className="float-right"
							/>
						</div>
						<div style={{ display: "block", marginTop: "10px", marginBottom: "10px" }}>
							{this.state.street}
						</div>
						<ClayInput
							value={this.state.address}
							placeholder={Util.translate("detail-address")}
							disabled={!this.dirty}
							autoFocus={true}
							onChange={(e) => this.handleAddressChanged(e.target.value)}
						/>
					</div>
				)}
				{this.dirty && this.state.error.errorClass !== ErrorClass.SUCCESS && (
					<SXFormFieldFeedback
						content={this.state.error.message}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
				{this.state.underConstruction && (
					<SXModalDialog
						header={Util.translate("sorry")}
						body={<UnderConstruction />}
						buttons={[
							{
								label: Util.translate("ok"),
								onClick: () => {
									this.setState({ underConstruction: false });
								}
							}
						]}
					/>
				)}
			</ClayForm.Group>
		);
	}
}

/*10. Date */
export class SXDate extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			enableTime: props.enableTime ?? false,
			startYear: props.startYear ?? "1970",
			endYear: props.endYear ?? new Date().getFullYear().toString(),
			index: props.index,
			value: props.value ?? props.enableTime ? "1970-1-1 00:00" : "1970-1-1",
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};

						newState[dataPacket.property] = dataPacket.value;

						this.setState(newState);
					});
				}
			});
		}
	}

	handleDateChanged(date) {
		console.log("SxDate: ", date);

		this.setState({ value: date });
	}

	render() {
		const tagId = this.state.tagId ?? this.namespace + this.state.paramName;
		const tagName = this.state.tagName ?? tagId;

		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		console.log("Date value: ", this.state.enableTime, this.state.value, this.state.startYear, this.state.endYear);

		let picker = (
			<ClayForm.Group className={className}>
				<SXLabel
					label={this.state.label}
					forHtml={tagId}
					required={this.state.required}
					tooltip={this.state.tooltip}
					className={className}
					spritemap={this.spritemap}
				/>
				{this.state.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.state.definition}</pre>
					</div>
				)}
				<DatePicker
					key={Util.randomKey()}
					onChange={(val) => this.handleDateChanged(val)}
					placeholder={this.state.enableTime ? "YYYY-MM-DD HH:mm" : "YYYY-MM-DD"}
					time={this.state.enableTime}
					value={this.state.value}
					disabled={this.state.disabled}
					years={{
						end: Number(this.state.endYear),
						start: Number(this.state.startYear)
					}}
					spritemap={this.spritemap}
				/>
			</ClayForm.Group>
		);

		return picker;
	}
}

/*11. Phone */
export class SXPhone extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			enableCountryNo: props.enableCountryNo ?? false,
			countryNo: Util.isNotEmpty(props.value) ? props.value.countryNo : "",
			areaNo: Util.isNotEmpty(props.value) ? props.value.areaNo : "",
			stationNo: Util.isNotEmpty(props.value) ? props.value.stationNo : "",
			personalNo: Util.isNotEmpty(props.value) ? props.value.personalNo : "",
			index: props.index,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};

						if (dataPacket.property === ParamProperty.VALUE) {
							newState.countryNo = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.countryNo;
							newState.areaNo = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.areaNo;
							newState.stationNo = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.stationNo;
							newState.personalNo = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.personalNo;
						} else {
							newState[dataPacket.property] = dataPacket.value;
						}

						this.setState(newState);
					});
				}
			});
		}
	}

	fireValueChangedEvent(value, error) {
		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: value,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					}
				}
			});
		}
	}

	checkFullNo() {
		return this.state.areaNo && this.state.stationNo && this.state.personalNo;
	}

	handleValueChanged(section, sectionValue) {
		const newValue = {
			countryNo: this.state.countryNo,
			areaNo: this.state.areaNo,
			stationNo: this.state.stationNo,
			personalNo: this.state.personalNo
		};

		newValue[section] = sectionValue;

		const error = Parameter.validateValue(ParamType.PHONE, this.state.validation, newValue, this.languageId);

		this.setState({ ...newValue, error: error });

		if (this.checkFullNo()) {
			this.fireValueChangedEvent(newValue, error);
		}

		this.dirty = true;
	}

	render() {
		const tagId = this.state.tagId ?? this.namespace + this.state.paramName;
		const tagName = this.state.tagName ?? tagId;

		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		return (
			<ClayForm.Group className={className}>
				<SXLabel
					label={this.state.label}
					forHtml={tagId}
					required={this.state.required}
					tooltip={this.state.tooltip}
					className={className}
					spritemap={this.spritemap}
				/>
				{this.state.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.state.definition}</pre>
					</div>
				)}
				<ClayInput.Group style={{ marginLeft: "10px" }}>
					{this.state.enableCountryNo && (
						<>
							<ClayInput.GroupItem shrink>
								<ClayInput
									value={this.state.countryNo}
									disabled={this.state.disabled}
									maxLength={6}
									onChange={(e) => this.handleValueChanged("countryNo", e.target.value)}
									spritemap={this.spritemap}
								/>
							</ClayInput.GroupItem>
							<ClayInput.GroupItem shrink>
								<span style={{ alignContent: "center" }}>-</span>
							</ClayInput.GroupItem>
						</>
					)}
					<ClayInput.GroupItem shrink>
						<ClayInput
							value={this.state.areaNo}
							disabled={this.state.disabled}
							maxLength={4}
							onChange={(e) => this.handleValueChanged("areaNo", e.target.value)}
							style={{ maxWidth: "8ch" }}
							spritemap={this.spritemap}
						/>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<span style={{ alignContent: "center" }}>-</span>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<ClayInput
							value={this.state.stationNo}
							disabled={this.state.disabled}
							maxLength={4}
							style={{ maxWidth: "8ch" }}
							onChange={(e) => this.handleValueChanged("stationNo", e.target.value)}
							spritemap={this.spritemap}
						/>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<span style={{ alignContent: "center" }}>-</span>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<ClayInput
							value={this.state.personalNo}
							disabled={this.state.disabled}
							maxLength={4}
							style={{ maxWidth: "8ch" }}
							onChange={(e) => this.handleValueChanged("personalNo", e.target.value)}
							spritemap={this.spritemap}
						/>
					</ClayInput.GroupItem>
				</ClayInput.Group>
				{this.dirty && this.state.error.errorClass !== ErrorClass.SUCCESS && (
					<SXFormFieldFeedback
						content={this.state.error.message}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</ClayForm.Group>
		);
	}
}

/*12. EMail */
export class SXEMail extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			emailId: Util.isNotEmpty(props.value) ? props.value.emailId : "",
			serverName: Util.isNotEmpty(props.value) ? props.value.serverName : "",
			index: props.index,
			definition: props.definition ?? "",
			showDefinition: props.showDefinition ?? false
		};

		if (Util.isNotEmpty(this.events.on)) {
			this.events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: "", error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let newState = {};

						if (dataPacket.property === ParamProperty.VALUE) {
							newState.emailId = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.emailId;
							newState.serverName = Util.isEmpty(dataPacket.value) ? "" : dataPacket.value.serverName;
						} else {
							newState[dataPacket.property] = dataPacket.value;
						}

						this.setState(newState);
					});
				}
			});
		}
	}

	fireValueChangedEvent(value, error) {
		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (error.errorClass === ErrorClass.ERROR) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: value,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					}
				}
			});
		}
	}

	handleEMailIdChanged(emailId) {
		const error = Parameter.validateValue(ParamType.EMAIL, this.state.validation, emailId, this.languageId);

		this.setState({ emailId: emailId, error: error });

		this.fireValueChangedEvent({ emailId: emailId, serverName: this.state.serverName }, error);
	}

	handleServerChanged(server) {
		const error = Parameter.validateValue(ParamType.EMAIL, this.state.validation, server, this.languageId);

		this.setState({ serverName: server, error: error });

		this.fireValueChangedEvent({ emailId: this.state.emailId, serverName: server }, error);
	}

	render() {
		const tagId = this.state.tagId ?? this.namespace + this.state.paramName;
		const tagName = this.state.tagName ?? tagId;

		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		return (
			<ClayForm.Group className={className}>
				<SXLabel
					label={this.state.label}
					forHtml={tagId}
					required={this.state.required}
					tooltip={this.state.tooltip}
					spritemap={this.spritemap}
				/>
				{this.state.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.state.definition}</pre>
					</div>
				)}
				<ClayInput.Group style={{ marginLeft: "10px" }}>
					<ClayInput.GroupItem>
						<ClayInput
							value={this.state.emailId}
							disabled={this.state.disabled}
							placeholder={Util.translate("email-id")}
							onChange={(e) => this.handleEMailIdChanged(e.target.value)}
							spritemap={this.spritemap}
						/>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<span style={{ alignContent: "center" }}>@</span>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem>
						<Autocomplete
							aria-labelledby={Util.translate("email-server-name")}
							id={tagId}
							defaultItems={EMailParameter.SERVERS}
							placeholder={Util.translate("email-server-name")}
							disabled={this.state.disabled}
							onChange={(val) => this.handleServerChanged(val)}
							value={this.state.serverName}
						>
							{(item) => <Autocomplete.Item key={item}>{item}</Autocomplete.Item>}
						</Autocomplete>
					</ClayInput.GroupItem>
				</ClayInput.Group>
			</ClayForm.Group>
		);
	}
}

/*13. Group */
export class SXGroup extends React.Component {
	constructor(props) {
		super(props);

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.inputStatus = props.inputStatus ?? false;

		this.state = {
			refresh: false
		};
	}

	componentDidMount() {}

	refresh() {
		this.setState({ refresh: !this.state.refresh });
	}

	render() {
		switch (this.parameter.viewType) {
			case GroupParameter.ViewTypes.ARRANGEMENT: {
				const rows = Util.convertArrayToRows(this.parameter.members, this.parameter.membersPerRow);

				return (
					<div
						id={this.parameter.tagId}
						className={this.className}
						style={this.style}
					>
						{rows.map((row, rowIndex) => (
							<div
								key={rowIndex}
								className="form-group form-group-autofit"
								style={{ marginBottom: "5px" }}
							>
								{row.map((param) => (
									<div
										key={param.key}
										className="form-group-item"
										style={{ marginBottom: "0" }}
									>
										{param.render({
											events: this.events,
											className: "",
											style: {},
											spritemap: this.spritemap,
											inputStatus: this.inputStatus
										})}
									</div>
								))}
							</div>
						))}
					</div>
				);
			}
			case GroupParameter.ViewTypes.HORIZONTAL_PANEL: {
				return <Panel></Panel>;
			}
			default: {
				return (
					<Panel
						collapsable
						displayTitle={
							<Panel.Title>
								<h3>{this.state.label}</h3>
							</Panel.Title>
						}
					>
						<Panel.Body>
							{this.state.members.map((member) => (
								<SXFormField
									key={member.paramName}
									namespace={this.namespace}
									properties={member}
									events={this.events}
									spritemap={this.spritemap}
								/>
							))}
						</Panel.Body>
					</Panel>
				);
			}
		}
	}
}

/*14. SelectGroup */
export const SXSelectGroup = () => {
	return <></>;
};

/*15. Grid */
export const SXGrid = () => {
	return <></>;
};

/*16. TableGrid */
export const SXTableGrid = () => {
	return <></>;
};

/*17. Calculator */
export const SXCalculator = () => {
	return <></>;
};

/*18. Reference */
export const SXReference = () => {
	return <></>;
};

/*19. Linker */
export const SXLinker = () => {
	return <></>;
};

export const SXButtonWithIcon = ({
	type,
	id,
	label,
	symbol,
	displayType,
	href,
	style,
	size = "md",
	spritemap,
	onClick
}) => {
	return (
		<Button
			type={type}
			id={id}
			displayType={displayType}
			href={href}
			style={style}
			size={size}
			onClick={onClick}
		>
			<Icon
				spritemap={spritemap}
				symbol={symbol}
				style={{ marginRight: "5px" }}
			/>
			{label}
		</Button>
	);
};

const SXFormField = function ({
	namespace,
	parameter,
	languageId,
	availableLanguageIds,
	className,
	style,
	spritemap,
	inputStatus = false
}) {
	const controlProps = {
		namespace: namespace,
		parameter: parameter,
		languageId: languageId,
		availableLanguageIds: availableLanguageIds,
		className: className,
		style: style,
		spritemap: spritemap,
		inputStatus: inputStatus,
		onChange: onChange,
		onClick: onClick
	};

	switch (parameter.paramType) {
		case ParamType.STRING: {
			return <SXInput {...controlProps} />;
		}
		case ParamType.LOCALIZED_STRING: {
			return <SXLocalizedInput {...controlProps} />;
		}
		case ParamType.NUMERIC: {
			return <SXNumeric {...controlProps} />;
		}
		case ParamType.BOOLEAN: {
			return <SXBoolean {...controlProps} />;
		}
		case ParamType.SELECT: {
			return <SXSelect {...controlProps} />;
		}
		case ParamType.DUALLIST: {
			return <SXDualListBox {...controlProps} />;
		}
		case ParamType.ADDRESS: {
			return <SXAddress {...controlProps} />;
		}
		case ParamType.EMAIL: {
			return <SXEMail {...controlProps} />;
		}
		case ParamType.PHONE: {
			return <SXPhone {...controlProps} />;
		}
		case ParamType.DATE: {
			return <SXDate {...controlProps} />;
		}
		case ParamType.FILE: {
			return <SXFile {...controlProps} />;
		}
		case ParamType.GROUP: {
			return <SXGroup {...controlProps} />;
		}
		default: {
			return <></>;
		}
	}
};

export const SXForm = ({
	namespace,
	formTag = "form",
	formName,
	action,
	method = "post",
	encType = "application/x-www-form-urlencoded",
	formFields,
	className,
	style,
	spritemap
}) => {
	const formId = namespace + formName;
	const formContent = formFields.map((formField) => {
		return (
			<SXFormField
				namespace={namespace}
				properties={formField}
				spritemap
			/>
		);
	});

	if (formTag === "form") {
		return (
			<form
				name={formName}
				action={action}
				method={method}
				encType={encType}
				className={className}
				style={style}
				spritemap={spritemap}
			>
				{formContent}
			</form>
		);
	} else {
		return (
			<div
				id={formId}
				className={className}
				style={style}
				spritemap={spritemap}
			>
				{formContent}
			</div>
		);
	}
};

export const SXMemoizedInput = React.memo(SXInput);

export default SXFormField;
