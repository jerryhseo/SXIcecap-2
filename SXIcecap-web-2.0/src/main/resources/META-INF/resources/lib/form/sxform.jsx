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

import { ParamType, DisplayType, Event, ViewTypes, ParamProperty } from "../common/station-x";
import { BooleanParameter, Parameter, SelectParameter, StringParameter } from "../parameter/parameter";

export const SelectDisplayStyle = {
	DUAL_LISTBOX: "DUAL_LISTBOX",
	DROP_LIST: "DROP_LIST",
	CHECKBOX: "CHECKBOX",
	RADIO_BUTTON: "RADIO_BUTTON",
	MULTI_SELECT: "MULTI_SELECT"
};

export const validateFormField = (fieldType, value, validation) => {
	let errorMsg = "";

	for (const validationType in validation) {
		if (validationType === "required") {
			if (validation.required.value && Util.isEmptyObject(value)) {
				return validation.required.message;
			}
		}

		if (validationType === "pattern") {
			const regExpr = new RegExp(validation.pattern.value);
			switch (fieldType) {
				case ParamType.LOCALIZED_STRING: {
					for (const key in value) {
						if (value[key] && !regExpr.test(value)) {
							return validation.pattern.message;
						}
					}
					break;
				}
				case ParamType.STRING: {
					if (!regExpr.test(value)) {
						return validation.pattern.message;
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
						return validation.min.message;
					}
				}
				case ParamType.NUMERIC:
				case ParamType.INTEGER: {
					if (value < validation.min.value) {
						return validation.min.message;
					}
				}
			}
		}

		if (validationType === "max") {
			switch (fieldType) {
				case ParamType.LOCALIZED_STRING:
				case ParamType.STRING: {
					if (value.length > validation.max.value) {
						return validation.max.message;
					}
				}
				case ParamType.NUMERIC:
				case ParamType.INTEGER: {
					if (value > validation.max.value) {
						return validation.max.message;
					}
				}
			}
		}

		if (validationType === "validate") {
			return validation.validate(value);
		}
	}

	return errorMsg;
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

export const SXPreview = ({ content, spritemap }) => {
	const preview = (
		<div
			className="autofit autofit-row"
			style={{ alignItems: "center" }}
		>
			<div
				className="autofit-col autofit-col-expand"
				style={{ marginRight: "10px" }}
			>
				{content}
			</div>
			<div className="autofit-col autofit-col-shrink">
				<DropDown
					trigger={
						<ClayButtonWithIcon
							aria-label="Actions"
							symbol="ellipsis-v"
							title="Actions"
							className="btn-secondary"
							spritemap={spritemap}
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
						{(action) => (
							<DropDown.Item key={action.name}>
								<ClayIcon
									spritemap={spritemap}
									symbol={action.symbol}
									style={{ marginRight: "5px" }}
								/>
								{action.name}
							</DropDown.Item>
						)}
					</DropDown.ItemList>
				</DropDown>
			</div>
		</div>
	);

	return preview;
};

export const SXControlWrapper = ({ labelPosition, label, control }) => {
	switch (labelPosition) {
		case Parameter.LabelPosition.INLINE_LEFT: {
			return (
				<div style={{ display: "inline-flex", width: "100%" }}>
					{label}
					{control}
				</div>
			);
		}
		case Parameter.LabelPosition.INLINE_RIGHT: {
			return (
				<div style={{ display: "inline-flex", width: "100%" }}>
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
export const SXInput = ({ namespace = "", properties, events = {}, className = "", style = {}, spritemap }) => {
	const [errorState, setErrorState] = useState("");
	const [propertiesState, setPropertiesState] = useState(properties);

	console.log("SXInput: ", properties);

	const {
		paramName,
		paramVersion = "1.0.0",
		tagId = namespace + properties.paramName,
		tagName = namespace + properties.paramName,
		label = "",
		labelPosition = Parameter.LabelPosition.UPPER_LEFT,
		labelWidth = "30%",
		required = false,
		tooltip = "",
		initValue = properties.defaultValue ? properties.defaultValue : "",
		placeholder = "",
		multiLine = false,
		disabled = false,
		validation = {},
		viewType = StringParameter.ViewTypes.REGULAR
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const initializedRef = useRef(initValue ? true : false);
	const [textState, setTextState] = useState(initValue);

	const inputRef = useRef(null);

	useLayoutEffect(() => {
		if (initializedRef.current) {
			const checkedError = validateFormField(ParamType.STRING, textState, validation);
			setErrorState(checkedError);
		}

		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						initializedRef.current = true;
						setErrorState(dataPacket.error);
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						console.log("SXInput Event.SX_PARAM_PROPERTY_CHANGED: ", e, event.target);
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;
						console.log("SXInput Event.SX_PARAM_PROPERTY_CHANGED dataPacket: ", dataPacket);

						propertiesState[dataPacket.property] = dataPacket.value;
						setPropertiesState({ ...propertiesState });
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						setTextState(dataPacket.value);
					});
				}
			});
		}
	}, []);

	useEffect(() => {
		inputRef.current.value = initValue;
	}, []);

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	const sxLabel =
		labelPosition !== Parameter.LabelPosition.NONE ? (
			<SXLabel
				label={label}
				forHtml={id}
				required={required}
				tooltip={tooltip}
				spritemap={spritemap}
				style={labelPosition === Parameter.LabelPosition.INLINE_LEFT ? { width: labelWidth } : null}
			/>
		) : undefined;

	const handleBlur = (e) => {
		const value = e.target.value;
		setTextState(value);
		initializedRef.current = true;

		const errorMsg = validateFormField(ParamType.STRING, value, validation);

		if (errorState !== errorMsg) {
			setErrorState(errorMsg);
		}

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (errorMsg) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, namespace, namespace, {
							traget: event.target,
							error: errorMsg,
							paramName: paramName,
							paramVersion: paramVersion
						});
					} else {
						Event.fire(event.event, namespace, namespace, {
							traget: event.target,
							value: value,
							paramName: paramName,
							paramVersion: paramVersion
						});
					}
				}
			});
		}
	};

	const errorClass = initializedRef.current ? (errorState ? " has-error" : " has-success") : "";

	if (viewType === StringParameter.ViewTypes.REGULAR) {
		return (
			<ClayForm.Group
				className={className + errorClass}
				style={{ style }}
			>
				<SXControlWrapper
					labelPosition={labelPosition}
					label={sxLabel}
					control={
						<ClayInput
							component={multiLine ? "textarea" : "input"}
							key={id}
							id={id}
							name={name}
							placeholder={placeholder}
							type="text"
							disabled={disabled}
							onBlur={handleBlur}
							ref={inputRef}
						/>
					}
				/>
				{initializedRef.current && errorState && (
					<SXFormFieldFeedback
						content={errorState}
						spritemap={spritemap}
						symbol="exclamation-full"
					/>
				)}
			</ClayForm.Group>
		);
	} else {
		return <h3>{`SXInput View Type: ${viewType}`}</h3>;
	}
};

/****************************************************
 *  02. The type of Parametrer is String and
 * 		localized property is true
 ****************************************************/
export const SXLocalizedInput = ({
	namespace = "",
	properties,
	events = {},
	className = "",
	style = {},
	spritemap
}) => {
	const [propertiesState, setPropertiesState] = useState(properties);

	const {
		paramName,
		paramVersion = "1.0.0",
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = "",
		labelPosition = Parameter.LabelPosition.UPPER_LEFT,
		multiLine = false,
		tooltip = {},
		required = false,
		placeholder = {},
		initValue = {},
		disabled = false,
		languageId,
		availableLanguageIds,
		validation = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const [errorState, setErrorState] = useState("");

	const [selectedLangState, setSelectedLangState] = useState(languageId);
	const [translationState, setTranslationState] = useState(initValue[languageId] ?? "");
	const initializedRef = useRef(Util.isEmptyObject(initValue) ? false : true);

	const translationsRef = useRef(initValue);
	const [dropDownActiveState, setDropDownActiveState] = useState(false);

	const inputRef = useRef(null);

	useLayoutEffect(() => {
		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						initializedRef.current = true;
						setErrorState(dataPacket.error);
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						propertiesState[dataPacket.property] = dataPacket.value;
						setPropertiesState(propertiesState);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						translationsRef.current = dataPacket.value;
						setTranslationState(translationsRef.current[selectedLangState]);
					});
				}
			});
		}
	}, []);

	useEffect(() => {
		inputRef.current.value = translationsRef.current[selectedLangState] ?? "";
	}, [selectedLangState]);

	const handleBlur = (e) => {
		const value = e.target.value;

		setTranslationState(value);
		translationsRef.current[selectedLangState] = value;
		initializedRef.current = true;

		const errorMsg = validateFormField(ParamType.LOCALIZED_STRING, translationsRef.current, validation);

		if (errorState !== errorMsg) {
			setErrorState(errorMsg);
		}

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (errorMsg) {
					if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, namespace, namespace, {
							traget: event.target,
							error: errorMsg,
							paramName: paramName,
							paramVersion: paramVersion
						});
					}
				} else {
					translationsRef.current[selectedLangState] = value;

					if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
						Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
							traget: event.target,
							value: translationsRef.current,
							paramName: paramName,
							paramVersion: paramVersion
						});
					}
				}
			});
		}
	};

	let dropDownFlags = availableLanguageIds.map((lang) => {
		return {
			id: lang,
			name: lang,
			symbol: lang.toLowerCase()
		};
	});

	const errorClass = initializedRef.current ? (errorState ? " has-error" : " has-success") : "";

	const sxLabel =
		labelPosition === Parameter.LabelPosition.NONE ? null : (
			<SXLabel
				label={label}
				forHtml={id}
				required={required}
				tooltip={tooltip}
				spritemap={spritemap}
			/>
		);

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	return (
		<ClayForm.Group
			className={className + errorClass}
			style={style}
		>
			<SXControlWrapper
				labelPosition={labelPosition}
				label={sxLabel}
				control={
					<ClayInput.Group>
						<ClayInput.GroupItem>
							<ClayInput
								component={multiLine ? "textarea" : "input"}
								type="text"
								id={id}
								name={name}
								placeholder={placeholder}
								disabled={disabled}
								onBlur={handleBlur}
								ref={inputRef}
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
											symbol={selectedLangState.toLowerCase()}
											spritemap={spritemap}
										/>
										<span className="btn-section">{selectedLangState}</span>
									</ClayButton>
								}
								closeOnClick={true}
							>
								<DropDown.ItemList items={dropDownFlags}>
									{(flag) => {
										let displayType, label;
										if (translationsRef.current[flag.name]) {
											displayType = "success";
											label = Liferay.Language.get("translated");
										} else {
											displayType = "warning";
											label = Liferay.Language.get("not-translated");
										}

										return (
											<DropDown.Item
												key={flag.name}
												onClick={() => {
													setSelectedLangState(flag.name);
												}}
												active={selectedLangState === flag.name}
											>
												<ClayIcon
													spritemap={spritemap}
													symbol={flag.symbol}
													style={{
														marginRight: "5px"
													}}
												/>
												{flag.name}
												<ClayLabel
													displayType={displayType}
													spritemap={spritemap}
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
			{initializedRef.current && errorState && (
				<SXFormFieldFeedback
					content={errorState}
					spritemap={spritemap}
					symbol="exclamation-full"
				/>
			)}
		</ClayForm.Group>
	);
};

/****************************************************
 *  03. The type of Parametrer is Numeric and
 * 		integer property is false
 ****************************************************/
export const SXNumeric = () => {
	return <></>;
};

/****************************************************
 *  04. The type of Parametrer is Numeric and
 * 		integer property is true
 ****************************************************/
export const SXInteger = () => {
	return <></>;
};

/****************************************************
 *  05. Boolean
 *
 * - viewTypes: dropdown, radio, toogle
 ****************************************************/
export const SXBoolean = ({
	namespace = "", //
	properties,
	events = {},
	className = "",
	style = {},
	spritemap
}) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName,
		paramVersion = "1.0.0",
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = propertiesState.label,
		labelPosition = Parameter.LabelPosition.INLINE_RIGHT,
		trueLabel = Util.translate("true"),
		falseLabel = Util.translate("false"),
		tooltip = "",
		required = false,
		placeholder = false,
		initValue = false,
		disabled = false,
		readOnly = false,
		viewType = BooleanParameter.CHECKBOX,
		validation = {}
	} = propertiesState ?? {};

	console.log("SXBoolean: ", propertiesState);

	const id = namespace + tagId;
	const name = namespace + tagName;

	const [valueState, setValueState] = useState(initValue);
	const [errorState, setErrorState] = useState("");

	useLayoutEffect(() => {
		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						setErrorState(dataPacket.error);
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						console.log(
							"SXBoolean Event.SX_PARAM_PROPERTY_CHANGED: ",
							paramName,
							paramVersion,
							e.dataPacket,
							event
						);
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						console.log("SXBoolean datapacket: ", dataPacket);
						const props = { ...propertiesState };
						props[dataPacket.property] = dataPacket.value;
						setPropertiesState({ ...propertiesState });
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						setValueState(dataPacket.value);
					});
				}
			});
		}
	}, []);

	const handleSelect = (val) => {
		console.log("SXBoolean handleSelect: ", val);
		setValueState(val);

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, namespace, namespace, {
						traget: event.target,
						value: val,
						paramName: paramName,
						paramVersion: paramVersion
					});
				}
			});
		}
	};

	const handleOnChange = (e) => {
		setValueState(!valueState);

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, namespace, namespace, {
						traget: event.target,
						value: !valueState,
						paramName: paramName,
						paramVersion: paramVersion
					});
				}
			});
		}
	};

	console.log("======= value: " + valueState);

	switch (viewType) {
		case BooleanParameter.ViewTypes.CHECKBOX: {
			return (
				<div
					className={className}
					style={style}
				>
					<ClayCheckbox
						id={id}
						name={name}
						label={trueLabel}
						aria-label={trueLabel}
						checked={valueState}
						onChange={handleOnChange}
						disabled={disabled}
						readOnly={readOnly}
					/>
				</div>
			);
		}
		case BooleanParameter.ViewTypes.DROPDOWN: {
			return (
				<div
					className={className}
					style={style}
				>
					<SXLabel
						label={label}
						forHtml={id}
						required={required}
						tooltip={tooltip}
					/>
					<ClaySelectWithOption
						id={id}
						name={name}
						defaultValue={valueState}
						onSelect={handleSelect}
						disabled={disabled}
						readOnly={readOnly}
					>
						<ClaySelect.Option
							label={trueLabel}
							value={true}
						/>
						<ClaySelect.Option
							label={falseLabel}
							value={false}
						/>
					</ClaySelectWithOption>
				</div>
			);
		}
		case BooleanParameter.ViewTypes.RADIO: {
			return (
				<div
					className={className}
					style={style}
				>
					<SXLabel
						label={label}
						forHtml={id}
						required={required}
						tooltip={tooltip}
					/>
					<ClayRadioGroup
						id={id}
						name={name}
						value={valueState}
						onChange={handleSelect}
						inline
						disabled={disabled}
						readOnly={readOnly}
					>
						<ClayRadio
							label={trueLabel}
							value={true}
						/>
						<ClayRadio
							label={falseLabel}
							value={false}
						/>
					</ClayRadioGroup>
				</div>
			);
		}
		case BooleanParameter.ViewTypes.TOGGLE: {
			return (
				<div
					className={className}
					style={style}
				>
					<ClayToggle
						id={id}
						name={name}
						label={trueLabel}
						onToggle={handleOnChange}
						spritemap={spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={valueState}
						disabled={disabled}
						readOnly={readOnly}
					/>
				</div>
			);
		}
		default: {
			return <></>;
		}
	}
};

/****************************************************
 *  06. The type of Parametrer is Select and
 * 		displayStyle property is DualListBox
 * 	viewTypes: dropdown, radio
 ****************************************************/
export const SXSelect = ({ namespace = "", properties, events = {}, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName,
		paramVersion,
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = "",
		labelPosition = Parameter.LabelPosition.UPPER_LEFT,
		tooltip = "",
		required = false,
		placeholder = "",
		initValue = "",
		disabled = false,
		viewType = "dropdown",
		options = [],
		optionsPerRow = 0,
		validation = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const initializedRef = useRef(initValue ? true : false);
	const [selectedState, setSelectedState] = useState(initValue);
	const [errorState, setErrorState] = useState("");
	const [viewTypeState, setViewTypeState] = useState(viewType);

	useLayoutEffect(() => {
		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						setSelectedState("");
						setErrorState(dataPacket.error);
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						propertiesState[dataPacket.property] = dataPacket.value;
						setPropertiesState(propertiesState);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						setSelectedState(dataPacket.value);
					});
				}
			});
		}

		if (placeholder && this.viewType === SelectParameter.ViewTypes.DROPDOWN) {
			options.unshift({
				label: placeholder,
				value: undefined
			});
		}
	}, []);

	useEffect(() => {
		//inputRef.current.value = selectedState;
	}, []);

	const handleChange = (e) => {
		console.log("SXSelect handleChange: ", e, events);
		setSelectedState(e.target.value);

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, namespace, namespace, {
						traget: event.target,
						value: e.target.value,
						paramName: paramName,
						paramVersion: paramVersion
					});
				}
			});
		}
	};

	const handleValueChange = (val) => {
		setSelectedState(val);

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					Event.fire(event.event, namespace, namespace, {
						traget: event.target,
						value: val,
						paramName: paramName,
						paramVersion: paramVersion
					});
				}
			});
		}
	};

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	let componentLabel;

	let componentBody;

	const component = null;

	if (viewType === SelectParameter.ViewTypes.DROPDOWN) {
		return (
			<div
				className={className}
				style={style}
			>
				<SXLabel
					label={label}
					forHtml={id}
					required={required}
					tooltip={tooltip}
					spritemap={spritemap}
				/>
				<ClaySelect
					id={id}
					name={name}
					value={selectedState}
					disabled={disabled}
					onChange={handleChange}
					onBlur={handleBlur}
				>
					{options.map((option, index) => {
						return (
							<ClaySelect.Option
								key={index}
								label={option.label}
								value={option.value}
							/>
						);
					})}
				</ClaySelect>
			</div>
		);
	} else if (viewType === SelectParameter.ViewTypes.RADIO) {
		const optionRows = Util.convertArrayToRows(options, optionsPerRow);
		return (
			<div
				className={className}
				style={{ style }}
			>
				<SXLabel
					label={label}
					forHtml={id}
					required={required}
					tooltip={tooltip}
					spritemap={spritemap}
				/>
				<ClayRadioGroup
					inline
					name={tagName}
					value={selectedState}
					onChange={handleValueChange}
					style={{ marginLeft: "10px" }}
				>
					{options.map((option) => (
						<ClayRadio
							key={option.value}
							label={option.label}
							value={option.value}
						/>
					))}
				</ClayRadioGroup>
			</div>
		);
	} else {
		return <h3>SXSelect viewType: {viewType}</h3>;
	}
};

/****************************************************
 *  07. The type of Parametrer is Select and
 * 		displayStyle property is DualListBox
 ****************************************************/
// 04.1. when displayStyle is dual list box
export const SXDualListBox = ({ namespace = "", properties, events = {}, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);

	const {
		paramName,
		paramVersion,
		tagId = namespace + propertiesState.paramName,
		tagName = namespace + propertiesState.paramName,
		label = "",
		leftOptions = [],
		rightOptions = [],
		tooltip = "",
		required = false,
		disabled = false,
		displayType = "",
		viewType = "horizontal",
		validation = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const [errorState, setErrorState] = useState("");
	const [leftItems, setLeftItems] = useState(leftOptions);
	const [rightItems, setRightItems] = useState(rightOptions);
	const initializedRef = useRef(leftOptions.length > 0);

	const [leftSelected, setLeftSelected] = useState([]);
	const [rightSelected, setRightSelected] = useState([]);

	useLayoutEffect(() => {
		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_ERROR_FOUND) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						initializedRef.current = true;
						setErrorState(dataPacket.error);
					});
				} else if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						propertiesState[dataPacket.property] = dataPacket.value;
						setPropertiesState(propertiesState);
					});
				} else if (event.event === Event.SX_PARAM_VALUE_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						const allItems = leftItems.concat(rightItems);
						setLeftItems(dataPacket.value);
						setRightItems(
							allItems.filter((item) => !dataPacket.value.some((val) => val.value === item.value))
						);
					});
				}
			});
		}

		if (initializedRef.current) {
			setErrorState(validateFormField(ParamType.DUALLIST, leftOptions, validation));
		}
	}, []);

	const handleLeftItemsChange = (items, a) => {
		setLeftItems(items);
	};

	const handleLeftSelectChange = (selects, a) => {
		setLeftSelected(selects);
	};

	const handleRightItemsChange = (items, a) => {
		setRightItems(items);
	};

	const handleRightSelectChange = (selects, a) => {
		setRightSelected(selects);
	};

	const handleRemoveBtnClick = (e) => {
		const left = leftItems.filter((item) => !leftSelected.includes(item.value));
		const leave = leftItems.filter((item) => leftSelected.includes(item.value));

		setLeftItems(left);
		setRightItems([...rightItems, ...leave]);

		const errorMsg = validateFormField(ParamType.DUAL_LISTBOX, left, validation);
		if (errorState !== errorMsg) {
			setErrorState(errorMsg);
		}

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (errorMsg) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, namespace, namespace, {
							traget: event.target,
							error: errorMsg,
							paramName: paramName,
							paramVersion: paramVersion
						});
					} else {
						Event.fire(event.event, namespace, namespace, {
							traget: event.target,
							value: left,
							paramName: paramName,
							paramVersion: paramVersion
						});
					}
				}
			});
		}
	};

	const handleAddBtnClick = (e) => {
		const left = rightItems.filter((item) => !rightSelected.includes(item.value));
		const leave = rightItems.filter((item) => rightSelected.includes(item.value));

		setRightItems(left);

		const newItems = [...leftItems, ...leave];
		setLeftItems(newItems);

		initializedRef.current = true;

		const errorMsg = validateFormField(ParamType.DUAL_LISTBOX, left, validation);
		if (errorState !== errorMsg) {
			setErrorState(errorMsg);
		}

		if (Util.isNotEmpty(events.fire)) {
			events.fire.forEach((event) => {
				if (event.event === Event.SX_FIELD_VALUE_CHANGED) {
					if (errorMsg) {
						Event.fire(Event.SX_FORM_FIELD_FAILED, namespace, namespace, {
							traget: event.target,
							error: errorMsg,
							paramName: paramName,
							paramVersion: paramVersion
						});
					} else {
						Event.fire(event.event, namespace, namespace, {
							traget: event.target,
							value: newItems,
							paramName: paramName,
							paramVersion: paramVersion
						});
					}
				}
			});
		}
	};

	const errorClass = initializedRef.current ? (errorState ? " has-error" : " has-success") : "";

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	return (
		<ClayForm.Group
			className={className}
			style={style}
		>
			{displayType === DisplayType.COLUMN ? null : (
				<SXLabel
					label={label}
					forHtml={id}
					required={required}
					tooltip={tooltip}
					spritemap={spritemap}
				/>
			)}
			<div className="sx-dual-listbox">
				<div
					className={"sx-dual-listbox-item sx-dual-listbox-item-expand listbox-left form-group " + errorClass}
				>
					<ClaySelectBox
						items={leftItems}
						label="In Use"
						multiple
						onItemsChange={handleLeftItemsChange}
						onSelectChange={handleLeftSelectChange}
						spritemap={spritemap}
						value={leftSelected}
						disabled={disabled}
						style={{ marginBottom: "5px" }}
					/>
					{initializedRef.current && errorState && (
						<ClayForm.FeedbackGroup>
							<ClayForm.FeedbackItem>
								<ClayForm.FeedbackIndicator
									spritemap={spritemap}
									symbol="exclamation-full"
								/>
								{errorState}
							</ClayForm.FeedbackItem>
						</ClayForm.FeedbackGroup>
					)}
				</div>
				<div className="btn-group-vertical sx-dual-listbox-actions sx-dual-listbox-item">
					<ClayButtonWithIcon
						aria-label="Remove"
						spritemap={spritemap}
						symbol="caret-right"
						displayType="secondary"
						title="Remove"
						className="transfer-button-ltr btn btn-monospaced btn-sm btn-secondary"
						disabled={disabled}
						onClick={handleRemoveBtnClick}
					/>
					<ClayButtonWithIcon
						aria-label="Add"
						spritemap={spritemap}
						symbol="caret-left"
						displayType="secondary"
						title="Add"
						className="transfer-button-ltr btn btn-monospaced btn-sm btn-secondary"
						disabled={disabled}
						onClick={handleAddBtnClick}
					/>
				</div>
				<div className="sx-dual-listbox-item sx-dual-listbox-item-expand listbox-right form-group">
					<ClaySelectBox
						items={rightItems}
						label="Availables"
						multiple
						onItemsChange={handleRightItemsChange}
						onSelectChange={handleRightSelectChange}
						spritemap={spritemap}
						value={rightSelected}
						disabled={disabled}
					/>
				</div>
			</div>
		</ClayForm.Group>
	);
};

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
export const SXGroup = ({ namespace = "", properties, events = {}, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName, //
		paramVersion,
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = "",
		viewType = ViewTypes.VERTICAL,
		members = [],
		fieldsPerRow = 1,
		initValues = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	className = className ? className : "";

	useLayoutEffect(() => {
		if (Util.isNotEmpty(events.on)) {
			events.on.forEach((event) => {
				if (event.event === Event.SX_PARAM_PROPERTY_CHANGED) {
					Event.on(event.event, (e) => {
						const dataPacket = Event.pickUpDataPacket(e, namespace, event.target, paramName, paramVersion);
						if (Util.isEmpty(dataPacket)) return;

						propertiesState[dataPacket.property] = dataPacket.value;
						setPropertiesState(propertiesState);
					});
				}
			});
		}
	}, []);

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`, propertiesState);

	let content;
	if (viewType === ViewTypes.HORIZONTAL) {
		if (label) {
			content = (
				<ClayPanel
					id={id}
					className={className}
					style={style}
				></ClayPanel>
			);
		} else {
			console.log("SXGroup fieldsPerGroup: " + fieldsPerRow);
			const rows = Util.convertArrayToRows(
				members.sort((a, b) => a.order - b.order),
				fieldsPerRow
			);

			console.log("SXGroup: ", rows);

			content = (
				<div
					id={id}
					className={className}
					style={style}
				>
					{rows.map((row, rowIndex) => (
						<div
							key={rowIndex}
							className="form-group form-group-autofit"
							style={{ marginBottom: "5px" }}
						>
							{row.map((col) => (
								<div
									key={col.paramName}
									className="form-group-item"
									style={{ marginBottom: "0" }}
								>
									<SXFormField
										namespace={namespace}
										properties={col}
										events={events}
										formData={initValues[col.paramName]}
										spritemap={spritemap}
									/>
								</div>
							))}
						</div>
					))}
				</div>
			);
		}
	} else {
		content = <></>;
	}

	return content;
};

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

const SXFormField = ({ namespace, properties, events, className, style, spritemap }) => {
	switch (properties.paramType) {
		case ParamType.STRING: {
			if (properties.localized) {
				return (
					<SXLocalizedInput
						namespace={namespace}
						properties={properties}
						events={events}
						className={className}
						style={style}
						spritemap={spritemap}
					/>
				);
			} else {
				return (
					<SXInput
						namespace={namespace}
						properties={properties}
						events={events}
						className={className}
						style={style}
						spritemap={spritemap}
					/>
				);
			}
		}
		case ParamType.BOOLEAN: {
			return (
				<SXBoolean
					namespace={namespace}
					properties={properties}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}
		case ParamType.SELECT: {
			return (
				<SXSelect
					namespace={namespace}
					properties={properties}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}
		case ParamType.DUALLIST: {
			return (
				<SXDualListBox
					namespace={namespace}
					properties={properties}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}
		case ParamType.GROUP: {
			return (
				<SXGroup
					namespace={namespace}
					properties={properties}
					events={events}
					className={className}
					style={style}
					spritemap={spritemap}
				/>
			);
		}
	}

	return <></>;
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
