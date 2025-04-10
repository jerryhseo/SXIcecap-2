import React, { useState, useEffect, useLayoutEffect, useCallback, useContext, useRef, forwardRef } from "react";
import { Text } from "@clayui/core";
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClayRadio,
	ClayRadioGroup,
	ClaySelectWithOption,
	ClaySelect,
	ClayToggle,
	ClayPanel,
	ClaySelectBox
} from "@clayui/form";
import ClayTooltip, { ClayTooltipProvider } from "@clayui/tooltip";
import ClayIcon from "@clayui/icon";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import DropDown from "@clayui/drop-down";
import ClayLabel from "@clayui/label";
import { Util } from "../common/util";

import {
	ParamType,
	DisplayType,
	Event,
	ViewTypes,
	ParamProperty,
	ErrorClass,
	ValidationKeys,
	ValidationSectionProperty
} from "../common/station-x";
import {
	BooleanParameter,
	DualListParameter,
	GroupParameter,
	Parameter,
	SelectParameter,
	StringParameter
} from "../parameter/parameter";
import { UnderConstruction } from "../common/common";
import { SXModalDialog } from "../modal/sxmodal";

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
			<ClayIcon
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
				<ClayIcon
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
								<ClayIcon
									spritemap={spritemap}
									symbol="search"
								/>
							</button>
							<button
								className="btn btn-unstyled"
								type="button"
							>
								<ClayIcon
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

export class SXPreviewRow extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.languageId;
		this.availableLanguageIds = props.availableLanguageIds;
		this.parameter = props.parameter;
		this.spritemap = props.spritemap;

		this.state = {
			focus: props.focus,
			rendered: false,
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
				console.log("SX_DISTRACT_ALL rejected: ", dataPacket);
				return;
			}
			console.log("SX_DISTRACT_ALL received: ", dataPacket);

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
				console.log("SX_FOCUS rejected: ", dataPacket);
				return;
			}
			console.log("SX_FOCUS received: ", dataPacket);

			this.setState({ focus: true });
		});
	}

	handleClick(e) {
		Event.fire(Event.SX_DISTRACT_ALL, this.namespace, this.namespace, { target: this.previewCanvasId });

		this.setState({ focus: true });

		Event.fire(Event.SX_PARAMETER_SELECTED, this.namespace, this.namespace, {
			target: this.dsbuilderId,
			paramName: this.parameter.paramName,
			paramVersion: this.parameter.paramVersion
		});
	}

	render() {
		let className = this.state.focus ? "autofit autofit-row sx-focused" : "autofit autofit-row";
		if (!this.state.rendered) {
			className += " sx-glore-border";

			let gloringTimer = setTimeout(() => {
				className = this.state.focus ? "autofit autofit-row sx-focused" : "autofit autofit-row";

				clearTimeout(gloringTimer);

				this.setState({ rendered: true });
			}, 2000);
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
						{this.parameter.render(
							this.namespace,
							this.languageId,
							this.availableLanguageIds,
							null,
							null,
							this.events,
							"",
							{},
							this.spritemap
						)}
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
										<ClayIcon
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

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.languageId = props.languageId;
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			component: props.multipleLine ? "textarea" : "input",
			tooltip: props.tooltip ?? "",
			required: props.required ?? false,
			placeholder: props.placeholder ?? "",
			disabled: props.disabled ?? false,
			validation: props.validation ?? {},
			viewType: props.viewType ?? StringParameter.ViewTypes.REGULAR,
			index: props.index,
			value: props.value ?? ""
		};

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

						this.dirty = true;
						this.setState({ error: dataPacket.error });
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let stateObj = {};
						if (dataPacket.property === ParamProperty.MULTIPLE_LINE) {
							stateObj.component = dataPacket.value ? "textarea" : "input";
						} else {
							stateObj[dataPacket.property] = dataPacket.value;
						}

						this.setState(stateObj);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: dataPacket.value });
						if (!this.dirty) {
							this.dirty = true;
						}
					});
				}
			});
		}
	}

	renderLabel(forHtml) {
		return this.state.labelPosition !== Parameter.LabelPosition.NONE ? (
			<SXLabel
				label={this.state.label}
				forHtml={forHtml}
				required={this.state.required}
				tooltip={this.state.tooltip}
				spritemap={this.spritemap}
				style={
					this.state.labelPosition === Parameter.LabelPosition.INLINE_LEFT
						? { width: this.state.labelWidth, alignContent: "center" }
						: null
				}
			/>
		) : undefined;
	}

	handleBlur(e) {
		const value = e.target.value;
		if (value === this.state.value) {
			return;
		}

		if (!this.dirty) {
			this.dirty = true;
		}

		const error = Parameter.validateValue(ParamType.STRING, this.state.validation, value, this.languageId);
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

	render() {
		const className = this.className + (this.dirty ? this.state.error.errorClass : "");

		const style = { ...this.style };
		style.marginBottom = this.style.marginBottom ?? "15px";

		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		if (this.state.viewType === StringParameter.ViewTypes.REGULAR) {
			return (
				<ClayForm.Group
					className={className}
					style={style}
				>
					<SXControlWrapper
						labelPosition={this.state.labelPosition}
						label={this.renderLabel(tagId)}
						control={
							<ClayInput
								component={this.state.component}
								id={tagId}
								name={tagName}
								placeholder={this.state.placeholder}
								type="text"
								defaultValue={this.state.value}
								disabled={this.state.disabled}
								onBlur={(e) => this.handleBlur(e)}
							/>
						}
					/>
					{this.dirty && this.state.error.message && (
						<SXFormFieldFeedback
							content={this.state.error.message}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
				</ClayForm.Group>
			);
		} else {
			return <h3>{`Underconstruction: SXInput View Type: ${this.state.viewType}`}</h3>;
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

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.availableLanguageIds = props.availableLanguageIds;
		this.dirty = false;

		this.state = {
			error: {},
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			component: props.multipleLine ? "textarea" : "input",
			tooltip: props.tooltip ?? "",
			required: props.required ?? false,
			placeholder: props.placeholder ?? "",
			disabled: props.disabled ?? false,
			selectedLang: props.languageId,
			validation: props.validation ?? {},
			selectedLang: props.languageId,
			index: props.index ?? 0,
			translations: Util.isNotEmpty(props.value) ? props.value : {},
			translation: Util.isNotEmpty(props.value) ? props.value[props.languageId] : ""
		};

		this.languageFlags = this.availableLanguageIds.map((lang) => ({
			id: lang,
			name: lang,
			symbol: lang.toLowerCase()
		}));

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
					console.log("SXLocalizedInput event register: SX_PARAM_PROPERTY_CHANGED");
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						let stateObj = {};
						if (dataPacket.property === ParamProperty.MULTIPLE_LINE) {
							stateObj.component = dataPacket.value ? "textarea" : "input";
						} else {
							stateObj[dataPacket.property] = dataPacket.value;
						}

						this.setState(stateObj);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({
							translations: dataPacket.value,
							translation: dataPacket.value[this.state.selectedLang]
						});
					});
				}
			});
		}
	}

	handleBlur(e) {
		const newValue = e.target.value;

		const translation = this.state.translations[this.state.selectedLang];
		if (translation === newValue) {
			return;
		}

		let newTranslations = { ...this.state.translations };
		newTranslations[this.state.selectedLang] = newValue;

		this.dirty = true;

		const error = Parameter.validateValue(
			ParamType.LOCALIZED_STRING,
			this.state.validation,
			newTranslations,
			this.languageId
		);

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (error.errorClass === ErrorClass.ERROR) {
					if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: error.message,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					}
				} else {
					if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
						Event.fire(Event.SX_FIELD_VALUE_CHANGED, this.namespace, this.namespace, {
							target: event.target,
							value: newTranslations,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion,
							index: this.state.index
						});
					}
				}
			});
		}

		this.setState({
			translations: newTranslations,
			translation: newValue,
			error: error
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

	get translation() {
		return this.state.translations[this.state.selectedLang];
	}

	render() {
		const className = this.dirty ? this.state.error.errorClass : "";

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
						<ClayInput.Group>
							<ClayInput.GroupItem>
								<ClayInput
									component={this.state.component}
									type="text"
									id={tagId}
									name={tagName}
									defaultValue={this.state.translation}
									placeholder={this.state.placeholder}
									disabled={this.state.disabled}
									onBlur={(e) => this.handleBlur(e)}
								/>
							</ClayInput.GroupItem>
							<ClayInput.GroupItem shrink>
								<DropDown
									trigger={
										<ClayButton
											displayType="secondary"
											className="btn-monospaced btn-md"
										>
											<ClayIcon
												symbol={this.state.selectedLang.toLowerCase()}
												spritemap={this.spritemap}
											/>
											<span className="btn-section">{this.state.selectedLang}</span>
										</ClayButton>
									}
									closeOnClick={true}
								>
									<DropDown.ItemList items={this.languageFlags}>
										{(flag) => {
											let displayType, label;
											if (this.state.translations[flag.name]) {
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
															translation: this.state.translations[flag.name]
														});
													}}
													active={this.state.selectedLang === flag.name}
												>
													<ClayIcon
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
					}
				/>
				{this.dirty && this.state.error.message && (
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
			decimalPlaces: props.decimalPlaces ?? 1,
			value: props.value ?? (props.uncertainty ? {} : undefined)
		};

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

						let stateObj = {};
						stateObj[dataPacket.property] = dataPacket.value;

						this.setState(stateObj);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: dataPacket.value });
					});
				}
			});
		}
	}

	handleValueChanged(val) {
		const error = Parameter.validateValue(ParamType.NUMERIC, this.state.validation, val, this.languageId);

		if (this.state.error.message === error.message) {
			return;
		}

		const fixedVal = this.state.isInteger ? val : val.toFixed(this.state.decimalPlaces);
		let value = this.state.uncertainty ? { ...this.state.value, value: fixedVal } : fixedVal;

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

		this.setState({ value: value });
	}

	handleUncertaintyChanged(val) {
		const error = Parameter.validateValue(ParamType.NUMERIC, this.state.validation, val, this.languageId);

		if (this.state.error.message === error.message) {
			return;
		}

		const fixedVal = this.state.isInteger ? val : val.toFixed(this.state.decimalPlaces + 1);
		let value = { ...this.state.value, uncertainty: fixedVal };

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

		this.setState({ value: value });
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
									type="text"
									defaultValue={this.state.uncertainty ? this.state.value.value : this.state.value}
									onBlur={(e) => this.handleValueChanged(Number(e.target.value))}
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
											type="text"
											defaultValue={
												this.state.uncertainty ? this.state.value.uncertainty : this.state.value
											}
											onBlur={(e) => this.handleUncertaintyChanged(Number(e.target.value))}
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
					}
				/>
				{this.dirty && this.state.error.message && (
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
			viewType: props.viewType
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
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: dataPacket.value });
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
		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		switch (this.state.viewType) {
			case BooleanParameter.ViewTypes.CHECKBOX: {
				return (
					<div
						className={this.className}
						style={{ ...this.style, marginBottom: "15px" }}
					>
						<ClayCheckbox
							id={tagId}
							name={tagName}
							label={this.state.label}
							aria-label={this.state.label}
							checked={this.state.value}
							onChange={(e) => this.handleOnChange(e)}
							disabled={this.state.disabled}
						/>
					</div>
				);
			}
			case BooleanParameter.ViewTypes.DROPDOWN: {
				console.log("SXBoolean: ", this.state.trueLabel, this.state.falseLabel);
				return (
					<div
						className={this.className}
						style={this.style}
					>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
						/>
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
					</div>
				);
			}
			case BooleanParameter.ViewTypes.RADIO: {
				console.log("SXBoolean: ", this.state.value);
				return (
					<div
						className={this.className}
						style={this.style}
					>
						<SXLabel
							label={this.state.label}
							forHtml={tagId}
							required={this.state.required}
							tooltip={this.state.tooltip}
						/>
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
					</div>
				);
			}
			case BooleanParameter.ViewTypes.TOGGLE: {
				return (
					<div
						className={this.className}
						style={this.style}
					>
						<ClayToggle
							id={tagId}
							name={tagName}
							label={this.state.label}
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
					</div>
				);
			}
			default: {
				return <></>;
			}
		}
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

		let options = [...props.options];
		if (props.placeholder && props.viewType === SelectParameter.ViewTypes.DROPDOWN) {
			options.unshift({
				label: props.placeholder,
				value: undefined
			});
		}

		console.log("prop.value: ", props.value);

		this.state = {
			error: "",
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			placeholder: props.placeholder ?? "",
			required: props.required ?? false,
			value: props.value ?? "",
			tooltip: props.tooltip ?? "",
			options: options,
			optionsPerRow: props.optionsPerRow ?? 1,
			disabled: props.disabled ?? false,
			viewType: props.viewType ?? SelectParameter.ViewTypes.DROPDOWN,
			validation: props.validation ?? {}
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

						this.state[dataPacket.property] = dataPacket.value;
						this.setState({ ...this.state });
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.paramName,
							this.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						this.setState({ value: dataPacket.value });
					});
				}
			});
		}
	}

	handleChange(e) {
		console.log("SXSelect handleChange: ", e, events);
		this.setState({ value: e.target.value });

		if (Util.isNotEmpty(this.state.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, this.namespace, this.namespace, {
						target: event.target,
						value: e.target.value,
						paramName: this.state.paramName,
						paramVersion: this.state.paramVersion
					});
				}
			});
		}
	}

	handleValueChange(val) {
		console.log("handleValueChange: ", val);
		this.setState({ value: val });

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

	render() {
		let componentLabel;

		let componentBody;

		const component = null;
		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		if (this.state.viewType === SelectParameter.ViewTypes.DROPDOWN) {
			return (
				<div
					className={"form-grorp " + this.className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
					<ClaySelect
						id={tagId}
						name={tagName}
						value={this.state.value}
						disabled={this.state.disabled}
						onChange={(e) => handleChange(e)}
						onBlur={(e) => handleBlur(e)}
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
			console.log("Select value: ", this.state.value);
			return (
				<div
					className={"form-group " + this.className}
					style={this.style}
				>
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
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
											onChange={(e) => this.handleValueChange(option.value)}
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
			return <UnderConstruction />;
		} else if (this.state.viewType === SelectParameter.ViewTypes.LISTBOX) {
			return <UnderConstruction />;
		}
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

		console.log("SXDualListBox: ", props);
		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: "",
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			labelPosition: props.LabelPosition ?? Parameter.LabelPosition.UPPER_LEFT,
			required: props.required ?? false,
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			viewType: props.viewType ?? DualListParameter.ViewTypes.HORIZONTAL,
			validation: props.validation ?? {},
			leftOptions: props.leftOptions ?? [],
			leftSelected: [],
			rightOptions: props.rightOptions ?? [],
			rightSelected: []
		};

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
					Event.on(event.event, (e) => {
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
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(
							e,
							this.namespace,
							event.target,
							this.state.paramName,
							this.state.paramVersion
						);
						if (Util.isEmpty(dataPacket)) return;

						const allItems = this.state.leftOptions.concat(this.state.rightOptions);
						const rightOptions = allItems.filter(
							(item) => !dataPacket.value.some((val) => val.value === item.value)
						);
						this.setState({ leftOptions: dataPacket.value, rightOptions: rightOptions });

						this.dirty = true;
					});
				}
			});
		}
	}

	handleLeftOptionsChange(options, a) {
		this.setState({ leftOptions: options });
		this.dirty = true;
	}

	handleLeftSelectChange(selects, a) {
		this.setState({ leftSelected: selects });
	}

	handleRightOptionsChange = (options, a) => {
		this.setState({ rightOptions: options });
		this.dirty = true;
	};

	handleRightSelectChange(selects, a) {
		this.setState({ rightSelected: selects });
	}

	handleRemoveBtnClick(e) {
		const left = this.state.leftOptions.filter((item) => !this.state.leftSelected.includes(item.value));
		const leave = this.state.leftOptions.filter((item) => this.state.leftSelected.includes(item.value));

		this.setState({
			leftOptions: left,
			rightOptions: [...this.state.rightOptions, ...leave]
		});

		const errorMsg = validateFormField(ParamType.DUALLIST, left, this.state.validation, this.languageId);
		if (this.state.error !== errorMsg) {
			this.setState({ error: errorMsg });
		}

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (errorMsg) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: errorMsg,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: left,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					}
				}
			});
		}

		this.dirty = true;
	}

	handleAddBtnClick(e) {
		const left = this.state.rightOptions.filter((item) => !this.state.rightSelected.includes(item.value));
		const leave = this.state.rightOptions.filter((item) => this.state.rightSelected.includes(item.value));

		const newItems = [...this.state.leftOptions, ...leave];
		this.setState({
			leftOptions: newItems,
			rightOptions: left
		});

		const errorMsg = validateFormField(ParamType.DUALLIST, left, this.state.validation, this.languageId);
		if (this.state.error !== errorMsg) {
			this.setState({ error: errorMsg });
		}

		if (Util.isNotEmpty(this.events.fire)) {
			this.events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (errorMsg) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, this.namespace, this.namespace, {
							target: event.target,
							error: errorMsg,
							paramName: this.state.paramName,
							paramVersion: this.state.paramVersion
						});
					} else {
						Event.fire(event.event, this.namespace, this.namespace, {
							target: event.target,
							value: newItems,
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
		const className = this.className + (this.dirty ? (this.state.error ? " has-error" : " has-success") : "");

		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		console.log("+++++ ", this.state.leftOptions, this.state.rightOptions);
		return (
			<ClayForm.Group
				className={className}
				style={this.style}
			>
				{this.state.labelPosition === Parameter.LabelPosition.NONE ? null : (
					<SXLabel
						label={this.state.label}
						forHtml={tagId}
						required={this.state.required}
						tooltip={this.state.tooltip}
						spritemap={this.spritemap}
					/>
				)}
				<div className="sx-dual-listbox">
					<div
						className={
							"sx-dual-listbox-item sx-dual-listbox-item-expand listbox-left form-group " + className
						}
					>
						<ClaySelectBox
							key={Util.randomKey()}
							items={this.state.leftOptions}
							label="In Use"
							multiple
							onItemsChange={(e) => this.handleLeftOptionsChange(e)}
							onSelectChange={(selected) => this.handleLeftSelectChange(selected)}
							spritemap={this.spritemap}
							value={this.state.leftSelected}
							disabled={this.state.disabled}
							style={{ marginBottom: "5px" }}
						/>
						{this.dirty && this.state.error && (
							<ClayForm.FeedbackGroup>
								<ClayForm.FeedbackItem>
									<ClayForm.FeedbackIndicator
										spritemap={this.spritemap}
										symbol="exclamation-full"
									/>
									{this.state.error}
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
							disabled={this.state.disabled}
							onClick={(e) => this.handleRemoveBtnClick(e)}
						/>
						<ClayButtonWithIcon
							aria-label="Add"
							spritemap={this.spritemap}
							symbol="caret-left"
							displayType="secondary"
							title="Add"
							className="transfer-button-ltr btn btn-monospaced btn-sm btn-secondary"
							disabled={this.state.disabled}
							onClick={(e) => this.handleAddBtnClick(e)}
						/>
					</div>
					<div className="sx-dual-listbox-item sx-dual-listbox-item-expand listbox-right form-group">
						<ClaySelectBox
							key={Util.randomKey()}
							items={this.state.rightOptions}
							label="Availables"
							multiple
							onItemsChange={(e) => this.handleRightOptionsChange(e)}
							onSelectChange={(selected) => this.handleRightSelectChange(selected)}
							spritemap={this.spritemap}
							value={this.state.rightSelected}
							disabled={this.state.disabled}
						/>
					</div>
				</div>
			</ClayForm.Group>
		);
	}
}

// 04.3. when displayStyle is multi list
export const SXDropMultiSelect = () => {
	return <></>;
};

// 04.4. when displayStyle is checkbox
export const SXCheckboxGroup = () => {
	return <></>;
};

// 04.5. when displayStyle is radio
export const SXRadioButtonGroup = () => {
	return <></>;
};

/****************************************************
 *  05. Matrix
 ****************************************************/
export const SXMatrix = () => {
	return <></>;
};

/****************************************************
 *  06. File
 ****************************************************/
export const SXFile = () => {
	return <></>;
};

/*09. Address */
export const SXAddress = () => {
	return <></>;
};

/*10. Date */
export const SXDate = () => {
	return <></>;
};

/*11. Phone */
export const SXPhone = () => {
	return <></>;
};

/*12. EMail */
export const SXEMail = () => {
	return <></>;
};

/*13. Group */
export class SXGroup extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace ?? "";
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.dirty = false;

		this.state = {
			error: "",
			paramName: props.paramName ?? "",
			paramVersion: props.paramVersion ?? "1.0.0",
			label: props.label ?? "",
			tooltip: props.tooltip ?? "",
			disabled: props.disabled ?? false,
			viewType: props.viewType ?? GroupParameter.ViewTypes.HORIZONTAL,
			members: props.members ?? [],
			membersPerRow: props.membersPerRow ?? 1
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

						let newState = {};
						newState[dataPacket.property] = dataPacket.value;

						this.setState(newState);
					});
				}
			});
		}
	}

	render() {
		const tagId = this.namespace + this.state.paramName;
		const tagName = tagId;

		let content;
		switch (this.state.viewType) {
			case GroupParameter.ViewTypes.HORIZONTAL: {
				const rows = Util.convertArrayToRows(this.state.members, this.state.membersPerRow);

				content = (
					<div
						id={tagId}
						className={this.className}
						style={this.style}
					>
						{rows.map((row, rowIndex) => (
							<div
								key={Util.randomKey()}
								className="form-group form-group-autofit"
								style={{ marginBottom: "5px" }}
							>
								{row.map((col) => (
									<div
										key={Util.randomKey()}
										className="form-group-item"
										style={{ marginBottom: "0" }}
									>
										<SXFormField
											namespace={this.namespace}
											properties={col}
											events={this.events}
											spritemap={this.spritemap}
										/>
									</div>
								))}
							</div>
						))}
					</div>
				);

				break;
			}
			default: {
				content = <></>;
			}
		}

		return content;
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
		<ClayButton
			type={type}
			id={id}
			displayType={displayType}
			href={href}
			style={style}
			size={size}
			onClick={onClick}
		>
			<ClayIcon
				spritemap={spritemap}
				symbol={symbol}
				style={{ marginRight: "5px" }}
			/>
			{label}
		</ClayButton>
	);
};

export const SXInlineInputGroup = ({ items, displayStyle = "justify" }) => {
	return (
		<div className="sx-inline-input-group">
			{items.map((item) => {
				switch (item.paramType) {
					case /*01.*/ ParamType.String: {
						return <SXInput></SXInput>;
					}
					case /*02.*/ ParamType.LocalizedString: {
						return <SXLocalizedInput />;
					}
					case /*03.*/ ParamType.NUMERIC: {
						return <SXNumeric />;
					}
					case /*04.*/ ParamType.INTEGER: {
						return <SXInteger />;
					}
					case /*05.*/ ParamType.BOOLEAN: {
						return <SXBoolean />;
					}
					case /*06.*/ ParamType.SELECT: {
						return <SXSelect />;
					}
					case /*07.*/ ParamType.MATRIX: {
						return <SXMatrix />;
					}
					case /*08.*/ ParamType.FILE: {
						return <SXFile />;
					}
					case /*09.*/ ParamType.ADDRESS: {
						return <SXAddress />;
					}
					case /*10.*/ ParamType.DATE: {
						return <SXDate />;
					}
					case /*11.*/ ParamType.PHONE: {
						return <SXPhone />;
					}
					case /*12.*/ ParamType.EMAIL: {
						return <SXEMail />;
					}
					case /*13.*/ ParamType.GROUP: {
						return <SXGroup />;
					}
					case /*14.*/ ParamType.SELECT_GROUP: {
						return <SXSelectGrooup />;
					}
					case /*15.*/ ParamType.GRID: {
						return <SXGrid />;
					}
					case /*16.*/ ParamType.TABLE_GRID: {
						return <SXTableGrid />;
					}
					case /*17.*/ ParamType.CALCULATOR: {
						return <SXCalculator />;
					}
					case /*18.*/ ParamType.REFERENCE: {
						return <SXReference />;
					}
					case /*19.*/ ParamType.LINKER: {
						return <SXLinker />;
					}
				}
			})}
		</div>
	);
};

class SXFormField extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.properties = props.properties;
		this.events = props.events;
		this.className = props.className;
		this.style = props.style;
		this.spritemap = props.spritemap;
	}

	render() {
		switch (this.properties.paramType) {
			case ParamType.STRING: {
				return (
					<SXInput
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.LOCALIZED_STRING: {
				return (
					<SXLocalizedInput
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.NUMERIC: {
				return (
					<SXNumeric
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.BOOLEAN: {
				return (
					<SXBoolean
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.SELECT: {
				console.log("SXFormField Properties: ", this.properties);

				return (
					<SXSelect
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.DUALLIST: {
				return (
					<SXDualListBox
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
			case ParamType.GROUP: {
				return (
					<SXGroup
						namespace={this.namespace}
						{...this.properties}
						events={this.events}
						className={this.className}
						style={this.style}
						spritemap={this.spritemap}
					/>
				);
			}
		}

		return <></>;
	}
}

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
