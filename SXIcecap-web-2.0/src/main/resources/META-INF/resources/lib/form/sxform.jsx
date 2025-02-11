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
import ClayIcon, { ClayIconSpriteContext } from "@clayui/icon";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import ClayLabel from "@clayui/label";
import { Util } from "../common/util";

import { ParamType, DisplayType, Event, ViewTypes } from "../common/station-x";

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

export const SXCheckbox = ({ namespace, id, name, label, checked, disabled, style, handleClick }) => {
	const [value, setValue] = useState(checked);

	const handleOnClick = (e) => {
		setValue(!value);

		Event.fire();
	};

	useLayoutEffect(() => {}, []);

	return (
		<ClayCheckbox
			id={namespace + id}
			name={namespace + name}
			checked={value}
			onChange={handleClick}
		/>
	);
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
		<div style={style}>
			<label
				htmlFor={forHtml}
				className="control-label"
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
		</div>
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

export const SXFileInput = ({ id, name, value, placeholder, disabled = false }) => {
	return (
		<ClayInput
			id={id}
			name={name}
			placeholder={placeholder}
			value={value}
			type="file"
			disabled={disabled}
		/>
	);
};

const valueChangedEvent = "SX_PARAM_PROPERTY_CHANGED";

const getDisplayClassNames = (errorState) => {
	let errorClass = errorState ? " has-error" : " has-success";

	switch (displayType) {
		case DisplayType.INLINE: {
			return {
				group: "sx-inline" + errorClass
			};
		}
		case DisplayType.INLINE_NO_SPACE: {
			return {
				group: "sx-inline nonspace" + errorClass
			};
		}
		case DisplayType.INLINE_FLAT: {
			return {
				group: "sx-inline" + errorClass,
				label: "sx-inline",
				control: "sx-inline"
			};
		}
		case DisplayType.INLINE_NONSPACE_FLAT: {
			return {
				group: "sx-inline nonspace" + errorClass,
				label: "sx-inline",
				control: "sx-inline"
			};
		}
		case DisplayType.INLINE_NONSPACE_FLAT_NONSPACE: {
			return {
				group: "sx-inline nonspace" + errorClass,
				label: "sx-inline nonspace",
				control: "sx-inline nonspace"
			};
		}
		case DisplayType.INLINE_NONSPACE_FLAT_NONSPACE: {
			return {
				group: "sx-inline nonspace" + errorClass,
				label: "sx-inline nonspace",
				control: "sx-inline nonspace"
			};
		}
	}

	return {
		group: errorClass
	};
};

export const SXRow = ({ children }) => {
	return <div className="sx-row">{children}</div>;
};

/****************************************************
 *  01. The type of Parametrer is String and
 * 		localized property is false
 ****************************************************/
export const SXInput = ({ namespace = "", formId = "", properties, className = "", style = {}, spritemap }) => {
	const [errorState, setErrorState] = useState("");
	const [propertiesState, setPropertiesState] = useState(properties);

	const {
		paramName,
		paramVersion,
		parentId,
		tagId = namespace + properties.paramName,
		tagName = namespace + properties.paramName,
		label = "",
		required = false,
		tooltip = "",
		initValue = properties.defaultValue ? properties.defaultValue : "",
		placeholder = "",
		multiLine = false,
		disabled = false,
		validation = {},
		events = {},
		viewType = ViewTypes.NORMAL
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

		/*
		 * Default on event
		 */
		Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
			const { dataPacket } = e;

			if (
				!Event.validateMine(dataPacket, {
					namespace: namespace,
					formId: formId,
					paramName: paramName,
					tagId: tagId,
					tagName: tagName
				})
			) {
				return;
			}

			setTextState("");
			setErrorState(dataPacket.error);
		});

		if (events.on) {
			if (events.on.includes(Event.SX_PARAM_PROPERTY_CHANGED)) {
				Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
					const dataPacket = e.dataPacket;
					if (
						!Event.validateMine(dataPacket, {
							namespace: namespace,
							formId: formId,
							paramName: paramName,
							tagId: tagId,
							tagName: tagName
						})
					) {
						return;
					}

					propertiesState[dataPacket.property] = dataPacket.value;
					setPropertiesState(propertiesState);
				});
			}
		}
	}, []);

	useEffect(() => {
		inputRef.current.value = initValue;
	}, []);

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	const sxLabel =
		viewType === ViewTypes.NORMAL ? (
			<SXLabel
				label={label}
				forHtml={id}
				required={required}
				tooltip={tooltip}
				spritemap={spritemap}
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

		if (events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
			if (errorMsg) {
				Event.fire(
					Event.SX_FORM_FIELD_FAILED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						error: errorMsg,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			} else {
				Event.fire(
					Event.SX_FORM_FIELD_CHANGED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						value: value,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
		}
	};

	const errorClass = initializedRef.current ? (errorState ? " has-error" : " has-success") : "";

	return (
		<ClayForm.Group
			className={className + errorClass}
			style={{ style }}
		>
			{sxLabel}
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
		</ClayForm.Group>
	);
};

/****************************************************
 *  02. The type of Parametrer is String and
 * 		localized property is true
 ****************************************************/
export const SXLocalizedInput = ({
	namespace = "",
	formId = "",
	properties,
	className = "",
	style = {},
	spritemap
}) => {
	const [propertiesState, setPropertiesState] = useState(properties);

	const {
		paramName,
		paramVersion,
		parentId,
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = "",
		multiLine = false,
		tooltip = {},
		required = false,
		placeholder = {},
		initValue = {},
		disabled = false,
		languageId,
		availableLanguageIds,
		displayType = DisplayType.NORMAL,
		validation = {},
		events = {}
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
		Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
			const { dataPacket } = e;
			if (dataPacket.isNotMine(namespace) || dataPacket.paramName !== tagId) {
				return;
			}

			setTextState("");
			setErrorState(dataPacket.error);
		});

		Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (
				!Event.validateMine(dataPacket, {
					namespace: namespace,
					formId: formId,
					paramName: paramName,
					tagId: tagId,
					tagName: tagName
				})
			) {
				return;
			}

			propertiesState[dataPacket.property] = dataPacket.value;
			setPropertiesState(propertiesState);
		});

		if (initializedRef.current) {
			setErrorState(validateFormField(ParamType.STRING, translationsRef.current, validation));
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

		if (errorMsg) {
			if (events.fire && events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
				Event.fire(
					Event.SX_FORM_FIELD_FAILED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						error: errorMsg,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
		} else {
			translationsRef.current[selectedLangState] = value;

			if (events.fire && events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
				Event.fire(
					Event.SX_FORM_FIELD_CHANGED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						value: translationsRef.current,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
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
		displayType === DisplayType.COLUMN ? null : (
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
			{sxLabel}
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
					<ClayDropDown
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
						active={dropDownActiveState}
						closeOnClick={true}
						onActiveChange={dropDownActiveState}
					>
						<ClayDropDown.ItemList items={dropDownFlags}>
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
									<ClayDropDown.Item
										key={flag.name}
										onClick={() => setSelectedLangState(flag.name)}
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
									</ClayDropDown.Item>
								);
							}}
						</ClayDropDown.ItemList>
					</ClayDropDown>
				</ClayInput.GroupItem>
			</ClayInput.Group>
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
export const SXBoolean = ({ namespace = "", formId, properties, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName,
		paramVersion,
		parentId,
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = propertiesState.label,
		truelabel = Util.translate("true"),
		falselabel = Util.translate("false"),
		tooltip = "",
		required = false,
		placeholder = false,
		initValue = "",
		disabled = false,
		viewType = "radio",
		validation = {},
		events = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const [valueState, setValueState] = useState(initValue);
	const [errorState, setErrorState] = useState("");

	useLayoutEffect(() => {
		if (events.on) {
			if (events.on.includes(Event.SX_PARAM_ERROR_FOUND)) {
				Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
					const { dataPacket } = e;

					if (
						!Event.validateMine(dataPacket, {
							namespace,
							formId,
							paramName: propertiesState.paramName,
							tagId: propertiesState.tagId,
							tagName: propertiesState.tagName
						})
					) {
						return;
					}

					setErrorState(dataPacket.error);
				});
			}

			if (events.on.includes(Event.SX_PARAM_PROPERTY_CHANGED)) {
				Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
					const dataPacket = e.dataPacket;
					if (
						!Event.validateMine(dataPacket, {
							namespace: namespace,
							formId: formId,
							paramName: paramName,
							tagId: tagId,
							tagName: tagName
						})
					) {
						return;
					}

					propertiesState[dataPacket.property] = dataPacket.value;
					setPropertiesState(propertiesState);
				});
			}
		}
	});

	const handleSelect = (e) => {
		if (events.fire && events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
			if (errorState) {
				Event.fire(
					Event.SX_FORM_FIELD_FAILED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						error: errorState,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			} else {
				Event.fire(
					Event.SX_FORM_FIELD_CHANGED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						value: valueState,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
		}
	};

	switch (viewType) {
		case ViewTypes.DROPDOWN: {
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
					<ClaySelect
						id={id}
						name={name}
						defaultValue={valueState}
						onSelect={handleSelect}
					>
						<ClalySelect.Option
							label={truelabel}
							value={true}
						/>
						<ClalySelect.Option
							label={falselabel}
							value={false}
						/>
					</ClaySelect>
				</div>
			);
		}
		case ViewTypes.RADIO: {
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
					>
						<ClayRadio
							label={truelabel}
							value={true}
						/>
						<ClayRadio
							label={falselabel}
							value={false}
						/>
					</ClayRadioGroup>
				</div>
			);
		}
		case ViewTypes.TOGGLE: {
			return (
				<div
					className={className}
					style={style}
				>
					<ClayToggle
						id={id}
						name={name}
						label={label}
						onToggle={handleSelect}
						spritemap={spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={valueState}
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
export const SXSelect = ({ namespace = "", formId, properties, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName,
		paramVersion,
		parentId,
		tagId = propertiesState.paramName,
		tagName = propertiesState.paramName,
		label = "",
		tooltip = "",
		required = false,
		placeholder = "",
		initValue = "",
		disabled = false,
		viewType = "dropdown",
		options = [],
		validation = {},
		events = {}
	} = propertiesState ?? {};

	const id = namespace + tagId;
	const name = namespace + tagName;

	const initializedRef = useRef(initValue ? true : false);
	const [selectedState, setSelectedState] = useState(initValue);
	const [errorState, setErrorState] = useState("");
	const [viewTypeState, setViewTypeState] = useState(viewType);

	useLayoutEffect(() => {
		/*
		 * Default on event
		 */

		if (events.on) {
			if (events.on.includes(Event.SX_PARAM_ERROR_FOUND)) {
				Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
					const { dataPacket } = e;

					if (
						!Event.validateMine(dataPacket, {
							namespace,
							formId,
							paramName: propertiesState.paramName,
							tagId: propertiesState.tagId,
							tagName: propertiesState.tagName
						})
					) {
						return;
					}

					setSelectedState("");
					setErrorState(dataPacket.error);
				});
			}

			if (events.on.includes(Event.SX_PARAM_PROPERTY_CHANGED)) {
				Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
					const dataPacket = e.dataPacket;
					if (
						!Event.validateMine(dataPacket, {
							namespace: namespace,
							formId: formId,
							paramName: paramName,
							tagId: tagId,
							tagName: tagName
						})
					) {
						return;
					}

					propertiesState[dataPacket.property] = dataPacket.value;
					setPropertiesState(propertiesState);
				});
			}
		}

		if (placeholder) {
			options.unshift({
				label: placeholder,
				value: undefined
			});
		}
	}, []);

	useEffect(() => {
		//inputRef.current.value = selectedState;
		console.log("SXSelect: ", inputRef.current.querySelector("select"), propertiesState);
	}, []);

	const handleChange = (e) => {
		console.log("SXSelect handleChange: ", e, events);
		setSelectedState(e.target.value);

		if (events.fire && events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
			Event.fire(
				Event.SX_FORM_FIELD_CHANGED,
				Event.createEventDataPacket(namespace, namespace, {
					formId: formId,
					value: e.target.value,
					parentId: parentId,
					paramId: {
						name: paramName,
						version: paramVersion
					}
				})
			);
		}
	};

	const handleBlur = (e) => {
		console.log("SXSelect handleBlur: ", e);
	};

	const handdleClick = (e) => {
		console.log("SXSelect clicked: " + e.target.value);
	};

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

	if (viewType === "dropdown") {
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
	} else {
		return <></>;
	}
};

/****************************************************
 *  07. The type of Parametrer is Select and
 * 		displayStyle property is DualListBox
 ****************************************************/
// 04.1. when displayStyle is dual list box
export const SXDualListBox = ({ namespace = "", formId, properties, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);

	const {
		paramName,
		paramVersion,
		parentId,
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
		validation = {},
		events = {}
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
		Event.on(Event.SX_PARAM_ERROR_FOUND, (e) => {
			const { dataPacket } = e;
			console.log(
				"SX_PARAM_ERROR_FOUND RECEIVED: ",
				dataPacket,
				namespace,
				paramName,
				dataPacket.isNotMine(namespace)
			);
			if (dataPacket.isNotMine(namespace) || dataPacket.paramName !== tagId) {
				return;
			}

			setTextState("");
			setErrorState(dataPacket.error);
		});

		if (events.on) {
			if (events.on.includes(Event.SX_PARAM_PROPERTY_CHANGED)) {
				Event.on(Event.SX_PARAM_PROPERTY_CHANGED, (e) => {
					const dataPacket = e.dataPacket;
					if (
						!Event.validateMine(dataPacket, {
							namespace: namespace,
							formId: formId,
							paramName: paramName,
							tagId: tagId,
							tagName: tagName
						})
					) {
						return;
					}

					propertiesState[dataPacket.property] = dataPacket.value;
					setPropertiesState(propertiesState);
				});
			}
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

		if (events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
			if (errorMsg) {
				Event.fire(
					Event.SX_FORM_FIELD_FAILED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						error: errorMsg,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			} else {
				Event.fire(
					Event.SX_FORM_FIELD_CHANGED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						value: left,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
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

		if (events.fire.includes(Event.SX_FORM_FIELD_CHANGED)) {
			if (errorMsg) {
				Event.fire(
					Event.SX_FORM_FIELD_FAILED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						error: errorMsg,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			} else {
				Event.fire(
					Event.SX_FORM_FIELD_CHANGED,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						value: newItems,
						parentId: parentId,
						paramId: {
							name: paramName,
							version: paramVersion
						}
					})
				);
			}
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
export const SXGroup = ({ namespace = "", formId, properties, className = "", style = {}, spritemap }) => {
	const [propertiesState, setPropertiesState] = useState(properties);
	const {
		paramName, //
		paramVersion,
		parentId,
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

	const renderCount = useRef(0);
	renderCount.current++;
	console.log(`${tagId} renderCount: ${renderCount.current}`);

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
			const rows = Util.convertArrayToRows(
				members.sort((a, b) => a.order - b.order),
				fieldsPerRow
			);

			content = (
				<div
					id={id}
					className={"form-group form-group-autofit" + className}
					style={style}
				>
					{rows.map((row, rowIndex) =>
						row.map((col) => (
							<span
								key={col.paramName}
								className="form-group-item"
								style={{ marginBottom: "5px" }}
							>
								<SXFormField
									namespace={namespace}
									formId={formId}
									properties={col}
									formData={initValues[col.paramName]}
									spritemap={spritemap}
								/>
							</span>
						))
					)}
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

const SXFormField = ({ namespace, formId, properties, className, style, spritemap }) => {
	switch (properties.paramType) {
		case ParamType.STRING: {
			if (properties.localized) {
				return (
					<SXLocalizedInput
						namespace={namespace}
						formId={formId}
						properties={properties}
						className={className}
						style={style}
						spritemap={spritemap}
					/>
				);
			} else {
				return (
					<SXInput
						namespace={namespace}
						formId={formId}
						properties={properties}
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
					formId={formId}
					properties={properties}
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
					formId={formId}
					properties={properties}
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
					formId={formId}
					properties={properties}
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
					formId={formId}
					properties={properties}
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
	formTag = "div",
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
				formId={formId}
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
