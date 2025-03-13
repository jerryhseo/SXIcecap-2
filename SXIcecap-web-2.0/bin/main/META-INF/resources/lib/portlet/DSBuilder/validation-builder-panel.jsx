import React, { useContext, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event } from "../../common/station-x";
import { ClayToggle } from "@clayui/form";
import LocalizedInput from "@clayui/localized-input";
import { Context } from "@clayui/modal";
import { openConfirmModal } from "../../modal/sxmodal";

const SXDSBuilderValidationPanel = ({
	namespace,
	dsbuilderId,
	propertyPanelId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	parameter,
	spritemap
}) => {
	const [validationState, setValidationState] = useState(parameter.validation);

	const locales = availableLanguageIds.map((locale) => ({
		label: locale,
		symbol: locale.toLowerCase()
	}));

	const [selectedLang, setSelectedLang] = useState({
		required: { label: languageId, symbol: languageId.toLowerCase() },
		pattern: { label: languageId, symbol: languageId.toLowerCase() },
		min: { label: languageId, symbol: languageId.toLowerCase() },
		max: { label: languageId, symbol: languageId.toLowerCase() }
	});

	const [warningDialogContext, dispatchWarningDialog] = useContext(Context);

	const validationEnabled = (section) => {
		return !!validationState[section];
	};

	const getTranslations = (section) => {
		return validationEnabled(section) ? validationState[section].message ?? {} : {};
	};

	const getValue = (section) => {
		if (section === "validate") {
			return validationEnabled(section) ? validationState[section] : "";
		}

		return validationEnabled(section) ? validationState[section].value ?? "" : "";
	};
	const setValue = (section, value) => {
		if (section === "validate") {
			if (Util.isEmpty(value)) {
				delete validationState.validate;
			} else {
				validationState.validate = value;
			}
		} else {
			if (Util.isEmpty(value)) {
				delete validationState[section].value;
			} else {
				validationState[section].value = value;
			}
		}

		setValidationState({ ...validationState });

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: dsbuilderId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationState
		});
	};
	const setTranslations = (section, translations) => {
		if (Util.isEmpty(translations)) {
			delete validationState[section].message;
		} else {
			validationState[section].message = translations;
		}

		setValidationState({ ...validationState });

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: dsbuilderId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationState
		});
	};

	const handleToggle = (section) => {
		switch (section) {
			case "required": {
				if (validationEnabled("required")) {
					delete validationState.required;
				} else {
					validationState.required = { value: true, message: {} };
				}

				handleValueChanged("required", Util.isNotEmpty(validationState.required));
				setValidationState({ ...validationState });
				break;
			}
			case "pattern": {
				if (validationEnabled("pattern")) {
					delete validationState.pattern;
				} else {
					validationState.pattern = {};
				}

				setValidationState({ ...validationState });
				break;
			}
			case "min": {
				if (validationEnabled("min")) {
					delete validationState.min;
				} else {
					validationState.min = {};
				}

				setValidationState({ ...validationState });
				break;
			}
			case "max": {
				if (validationEnabled("max")) {
					delete validationState.max;
				} else {
					validationState.max = {};
				}

				setValidationState({ ...validationState });
				break;
			}
			case "validate": {
				if (validationEnabled("validate")) {
					delete validationState.validate;
				} else {
					validationState.validate = "function(value){\n}";
				}

				setValidationState({ ...validationState });
				break;
			}
		}
	};

	const handleValueChanged = (section, value) => {
		switch (section) {
			case "required":
			case "pattern":
			case "validate":
				setValue(section, value);
				break;
			case "min":
			case "max":
				if (isNaN(value)) {
					dispatchWarningDialog(
						openConfirmModal({
							title: Util.translate("warning"),
							modalType: "warning",
							content: Util.translate("the-value-of-the-field-requires-only-numbers"),
							buttons: [
								{
									label: Util.translate("ok"),
									onClick: warningDialogContext.onClose
								}
							],
							size: "sm",
							spritemap: spritemap
						})
					);

					setValue(section, "");
				} else {
					setValue(section, Number(value));
				}

				break;
		}
	};

	const handleMessageChanged = (section, translations) => {
		setTranslations(section, translations);

		setValidationState({ ...validationState });
	};

	const handleLanguageChanged = (section, locale) => {
		console.log("handleLanguageChanged locale: ", locale);
		selectedLang[section] = locale;

		setSelectedLang({ ...selectedLang });
	};

	const requiredMessageId = namespace + "requiredMessage";
	const patternValueId = namespace + "patternValue";
	const patternMessageId = namespace + "patternMessage";
	const minValueId = namespace + "minValue";
	const minMessageId = namespace + "minMessage";
	const maxValueId = namespace + "maxValue";
	const maxMessageId = namespace + "maxMessage";
	const validateId = namespace + "validate";

	return (
		<>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<h4>{"Required"}</h4>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={() => handleToggle("required")}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validationEnabled("required")}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validationEnabled("required") ? "block" : "none",
						marginLeft: "2rem"
					}}
				>
					<LocalizedInput
						id={requiredMessageId}
						locales={locales}
						label={Util.translate("message")}
						onSelectedLocaleChange={(locale) => handleLanguageChanged("required", locale)}
						selectedLocale={selectedLang.required}
						translations={getTranslations("required")}
						onTranslationsChange={(translations) => handleMessageChanged("required", translations)}
						spritemap={spritemap}
					/>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<h4>{"Pattern"}</h4>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={() => handleToggle("pattern")}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validationEnabled("pattern")}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validationEnabled("pattern") ? "block" : "none",
						marginLeft: "2rem"
					}}
				>
					<span
						style={{
							fontSize: "0.875rem",
							fontWeight: "600",
							marginRight: "10px",
							marginBottom: "5px"
						}}
					>
						{Util.translate("value")}
					</span>
					<input
						id={patternValueId}
						defaultValue={getValue("pattern")}
						onBlur={(e) => handleValueChanged("pattern", e.target.value)}
						className="form-control form-control-sm"
					/>

					<LocalizedInput
						id={patternMessageId}
						locales={locales}
						label={Util.translate("message")}
						onSelectedLocaleChange={(locale) => handleLanguageChanged("pattern", locale)}
						selectedLocale={selectedLang.pattern}
						translations={getTranslations("pattern")}
						onTranslationsChange={(translations) => handleMessageChanged("pattern", translations)}
						spritemap={spritemap}
					/>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<h4>{"Min"}</h4>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={() => handleToggle("min")}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validationEnabled("min")}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validationEnabled("min") ? "block" : "none",
						marginLeft: "2rem"
					}}
				>
					<span
						style={{
							fontSize: "0.875rem",
							fontWeight: "600",
							marginRight: "10px",
							marginBottom: "5px"
						}}
					>
						{Util.translate("value")}
					</span>
					<input
						id={minValueId}
						defaultValue={getValue("min")}
						onBlur={(e) => handleValueChanged("min", e.target.value)}
						className="form-control form-control-sm"
					/>
					<LocalizedInput
						id={minMessageId}
						locales={locales}
						label={Util.translate("message")}
						onSelectedLocaleChange={(locale) => handleLanguageChanged("min", locale)}
						selectedLocale={selectedLang.min}
						translations={getTranslations("min")}
						onTranslationsChange={(translations) => handleMessageChanged("min", translations)}
						spritemap={spritemap}
					/>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<h4>{"Max"}</h4>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={() => handleToggle("max")}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validationEnabled("max")}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validationEnabled("max") ? "block" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
				>
					<span
						style={{
							fontSize: "0.875rem",
							fontWeight: "600",
							marginRight: "10px",
							marginBottom: "5px"
						}}
					>
						{Util.translate("value")}
					</span>
					<input
						id={maxValueId}
						defaultValue={getValue("max")}
						onBlur={(e) => handleValueChanged("max", e.target.value)}
						className="form-control form-control-sm"
					/>
					<LocalizedInput
						id={maxMessageId}
						locales={locales}
						label={Util.translate("message")}
						onSelectedLocaleChange={(locale) => handleLanguageChanged("max", locale)}
						selectedLocale={selectedLang.max}
						translations={getTranslations("max")}
						onTranslationsChange={(translations) => handleMessageChanged("max", translations)}
						spritemap={spritemap}
					/>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<h4>{"Validate"}</h4>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={() => handleToggle("validate")}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validationEnabled("validate")}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validationEnabled("validate") ? "block" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
				>
					<span style={{ fontSize: "0.875rem", fontWeight: "600", marginRight: "10px", width: "60px" }}>
						{Util.translate("function")}
					</span>
					<textarea
						id={validateId}
						defaultValue={getValue("validate")}
						onBlur={(e) => handleValueChanged("validate", e.target.value)}
						className="form-control form-control-sm"
					/>
				</div>
			</div>
		</>
	);
};

export default SXDSBuilderValidationPanel;
