import React, { useContext, useRef, useState } from "react";
import { Util } from "../../common/util";
import { ErrorClass, Event, ParamType, ValidationKeys } from "../../common/station-x";
import { ClayCheckbox, ClayInput, ClaySelectWithOption, ClayToggle } from "@clayui/form";
import LocalizedInput from "@clayui/localized-input";
import { Context } from "@clayui/modal";
import { openConfirmModal } from "../../modal/sxmodal";

class SXDSBuilderValidationPanel extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.workingParam.namespace;
		this.formIds = props.formIds;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;
		this.spritemap = props.spritemap;

		this.locales = this.availableLanguageIds.map((locale) => ({
			label: locale,
			symbol: locale.toLowerCase()
		}));

		this.errorLevelOptions = Object.keys(ErrorClass)
			.filter((errorClass) => errorClass !== "SUCCESS")
			.map((errorClass) => ({
				label: errorClass,
				value: ErrorClass[errorClass]
			}));

		(this.validation = this.workingParam.validation ?? {}),
			(this.state = {
				selectedLang: {
					required: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					pattern: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					minLength: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					maxLength: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					min: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					max: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					normalMin: { label: this.languageId, symbol: this.languageId.toLowerCase() },
					normalMax: { label: this.languageId, symbol: this.languageId.toLowerCase() }
				},
				waringDlg: false
			});
	}

	getSection(sectionId) {
		return this.validation[sectionId];
	}

	enableSection(sectionId, enable) {
		if (enable) {
			switch (sectionId) {
				case ValidationKeys.REQUIRED: {
					const message = {};

					for (let i = 0; i < this.availableLanguageIds.length; i++) {
						const lang = this.availableLanguageIds[i];
						message[lang] = "This field is required";
					}

					this.validation.required = {
						value: true,
						message: message,
						errorClass: ErrorClass.ERROR
					};

					break;
				}
				case ValidationKeys.CUSTOM: {
					this.validation.custom = {
						value: "(value)=>{\n return true;\n}",
						message: {},
						errorClass: ErrorClass.ERROR
					};
					break;
				}
				default: {
					this.validation[sectionId] = {
						value: "",
						message: {},
						errorClass: ErrorClass.ERROR
					};
				}
			}
		} else {
			delete this.validation[sectionId];
		}

		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	checkSectionEnabled(sectionId) {
		return !!this.getSection(sectionId);
	}

	getSectionValue(sectionId) {
		const section = this.getSection(sectionId);
		return section ? section.value ?? "" : "";
	}

	getSectionBoundary(sectionId) {
		const section = this.getSection(sectionId);
		return section ? section.boundary ?? false : false;
	}

	getSectionMessage(sectionId) {
		const section = this.getSection(sectionId);
		return section ? section.message ?? {} : {};
	}

	getSectionErrorClass(sectionId) {
		const section = this.getSection(sectionId);
		return section ? section.errorClass ?? "" : "";
	}

	setSectionValue(sectionId, value) {
		const prevSection = this.getSection(sectionId);

		if (value) {
			prevSection.value = value;

			if (sectionId === ValidationKeys.REQUIRED) {
				prevSection.value = value;

				if (Util.isEmpty(prevSection.message)) {
					prevSection.message = {};

					for (let i = 0; i < this.availableLanguageIds.length; i++) {
						const lang = this.availableLanguageIds[i];
						this.setSectionMessageTranslation(ValidationKeys.REQUIRED, "This field is required", lang);
					}
				}
			}
		} else {
			if (sectionId === ValidationKeys.REQUIRED) {
				prevSection = {};
			} else {
				prevSection.value = value;
			}
		}

		this.validation[sectionId] = prevSection;

		this.workingParam.validation = this.validation;

		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	setSectionMessage(sectionid, message) {
		const prevSection = this.getSection(sectionid);

		prevSection.message = message;
		this.validation[sectionid] = prevSection;
		this.workingParam.validation = this.validation;

		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	setSectionMessageTranslation(sectionid, translation, languageId) {
		const prevSection = this.getSection(sectionid);
		const prevMsg = prevSection.message ?? {};
		prevMsg[languageId] = translation;
		prevSection.message = prevMsg;

		this.validation[sectionid] = prevSection;

		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	setSectionErrorLevel(sectionid, errorLevel) {
		const prevSection = this.getSection(sectionid);

		prevSection.errorClass = errorLevel;
		this.validation[sectionid] = prevSection;
		this.workingParam.validation = this.validation;
		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	handleToggle(sectionId) {
		this.enableSection(sectionId, !this.checkSectionEnabled(sectionId));
	}

	toggleBoundary(sectionId) {
		const prevSection = this.getSection(sectionId) ?? {};

		prevSection.boundary = !prevSection.boundary;

		this.validation[sectionId] = prevSection;
		this.workingParam.validation = this.validation;
		this.forceUpdate();
		this.workingParam.fireRefreshPreview();
	}

	handleValueChanged(sectionId, value) {
		switch (sectionId) {
			case ValidationKeys.PATTERN:
			case ValidationKeys.CUSTOM:
				//console.log("setSectionValue: ", sectionId, value);
				this.setSectionValue(sectionId, value);
				break;
			case ValidationKeys.MIN_LENGTH:
			case ValidationKeys.MAX_LENGTH:
				if (isNaN(value)) {
					this.setSectionValue(sectionId, "");
				} else {
					this.setSectionValue(sectionId, Util.isNotEmpty(value) ? Math.floor(Number(value)) : "");
				}
				break;
			case "min":
			case ValidationKeys.MIN:
			case ValidationKeys.MAX:
			case ValidationKeys.NORMAL_MIN:
			case ValidationKeys.NORMAL_MAX:
				if (isNaN(value)) {
					this.setSectionValue(sectionId, "");
				} else {
					this.setSectionValue(sectionId, Util.isNotEmpty(value) ? Number(value) : "");
				}

				break;
		}
	}

	handleMessageChanged(sectionId, translations) {
		this.setSectionMessage(sectionId, translations);
	}

	handleErrorLevelChanged(sectionId, errorLevel) {
		this.setSectionErrorLevel(sectionId, errorLevel);
	}

	handleLanguageChanged(sectionId, locale) {
		this.state.selectedLang[sectionId] = locale;

		this.setState({ ...this.state.selectedLang });
	}

	renderToggleBar(sectionId) {
		let titleKey;

		switch (sectionId) {
			case ValidationKeys.REQUIRED: {
				titleKey = "required";
				break;
			}
			case ValidationKeys.PATTERN: {
				titleKey = "pattern";
				break;
			}
			case ValidationKeys.MIN_LENGTH: {
				titleKey = "min-length";
				break;
			}
			case ValidationKeys.MAX_LENGTH: {
				titleKey = "max-length";
				break;
			}
			case ValidationKeys.MIN: {
				titleKey = "min";
				break;
			}
			case ValidationKeys.MAX: {
				titleKey = "max";
				break;
			}
			case ValidationKeys.NORMAL_MIN: {
				titleKey = "normal-min";
				break;
			}
			case ValidationKeys.NORMAL_MAX: {
				titleKey = "normal-max";
				break;
			}
			case ValidationKeys.CUSTOM: {
				titleKey = "custom";
				break;
			}
		}

		return (
			<div className="autofit-row">
				<span className="autifit-col autofit-col-expand">
					<h4>{Util.translate(titleKey)}</h4>
				</span>
				<span className="autofit-col">
					<ClayToggle
						onToggle={() => this.handleToggle(sectionId)}
						spritemap={this.spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={this.checkSectionEnabled(sectionId)}
						className="form-control-sm"
					/>
				</span>
			</div>
		);
	}

	renderSectionBody(sectionId) {
		let valueField;

		if (sectionId === ValidationKeys.CUSTOM) {
			valueField = (
				<>
					<span className="sx-validation-label">{Util.translate("value")}</span>
					<textarea
						defaultValue={this.getSectionValue(sectionId)}
						onBlur={(e) => this.handleValueChanged(sectionId, e.target.value)}
						className="form-control form-control-sm"
					/>
				</>
			);
		} else {
			if (this.hasMinMaxValidation(this.workingParam.paramType)) {
				valueField = (
					<>
						<span className="sx-validation-label">{Util.translate("value")}</span>
						<ClayInput.Group>
							<ClayInput.GroupItem>
								<input
									defaultValue={this.getSectionValue(sectionId)}
									onBlur={(e) => this.handleValueChanged(sectionId, e.target.value)}
									className="form-control form-control-sm"
								/>
							</ClayInput.GroupItem>
							<ClayInput.GroupItem
								prepend
								shrink
							>
								<ClayCheckbox
									aria-label={Util.translate("boundary")}
									checked={this.getSectionBoundary(sectionId)}
									onChange={() => this.toggleBoundary(sectionId)}
									label={Util.translate("boundary")}
								/>
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</>
				);
			} else {
				valueField = (
					<>
						<span className="sx-validation-label">{Util.translate("value")}</span>
						<input
							defaultValue={this.getSectionValue(sectionId)}
							onBlur={(e) => this.handleValueChanged(sectionId, e.target.value)}
							className="form-control form-control-sm"
						/>
					</>
				);
			}
		}

		return (
			<div className="sx-validation-section-enabled">
				{sectionId !== ValidationKeys.REQUIRED && valueField}
				<LocalizedInput
					locales={this.locales}
					label={Util.translate("message")}
					onSelectedLocaleChange={(locale) => this.handleLanguageChanged(sectionId, locale)}
					selectedLocale={this.state.selectedLang.required}
					translations={this.getSectionMessage(sectionId)}
					onTranslationsChange={(translations) => this.handleMessageChanged(sectionId, translations)}
					spritemap={this.spritemap}
				/>
				<span className="sx-validation-label">{Util.translate("error-level")}</span>
				{this.errorLevelSelector(sectionId)}
			</div>
		);
	}

	errorLevelSelector(sectionId) {
		const errorClass = this.getSection(sectionId)
			? this.getSection(sectionId).errorClass ?? ErrorClass.ERROR
			: ErrorClass.ERROR;

		return (
			<ClaySelectWithOption
				aria-label={Util.translate("error-level")}
				options={this.errorLevelOptions}
				value={errorClass}
				onChange={(e) => {
					this.handleErrorLevelChanged(sectionId, e.target.value);
				}}
				spritemap={this.spritemap}
			/>
		);
	}

	hasPatternValidation(paramType) {
		return paramType === ParamType.STRING || paramType === ParamType.LOCALIZED_STRING;
	}

	hasLengthValidation(paramType) {
		return paramType === ParamType.STRING || paramType === ParamType.LOCALIZED_STRING;
	}

	hasMinMaxValidation(paramType) {
		return paramType === ParamType.NUMERIC;
	}

	hasCustomValidation(paramType) {
		return (
			paramType === ParamType.STRING ||
			paramType === ParamType.LOCALIZED_STRING ||
			paramType === ParamType.NUMERIC ||
			paramType === ParamType.INTEGER ||
			paramType === ParamType.MATRIX
		);
	}

	render() {
		return (
			<>
				<div className="border sx-validation-section">
					<div className="autofit-row">{this.renderToggleBar(ValidationKeys.REQUIRED)}</div>
					{this.checkSectionEnabled(ValidationKeys.REQUIRED) &&
						this.renderSectionBody(ValidationKeys.REQUIRED)}
				</div>
				{this.hasPatternValidation(this.workingParam.paramType) && (
					<>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.PATTERN)}</div>
							{this.checkSectionEnabled(ValidationKeys.PATTERN) &&
								this.renderSectionBody(ValidationKeys.PATTERN)}
						</div>
					</>
				)}

				{this.hasLengthValidation(this.workingParam.paramType) && (
					<>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.MIN_LENGTH)}</div>
							{this.checkSectionEnabled(ValidationKeys.MIN_LENGTH) &&
								this.renderSectionBody(ValidationKeys.MIN_LENGTH)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.MAX_LENGTH)}</div>
							{this.checkSectionEnabled(ValidationKeys.MAX_LENGTH) &&
								this.renderSectionBody(ValidationKeys.MAX_LENGTH)}
						</div>
					</>
				)}
				{this.hasMinMaxValidation(this.workingParam.paramType) && (
					<>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.MIN)}</div>
							{this.checkSectionEnabled("min") && this.renderSectionBody(ValidationKeys.MIN)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.MAX)}</div>
							{this.checkSectionEnabled(ValidationKeys.MAX) && this.renderSectionBody(ValidationKeys.MAX)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.NORMAL_MIN)}</div>
							{this.checkSectionEnabled(ValidationKeys.NORMAL_MIN) &&
								this.renderSectionBody(ValidationKeys.NORMAL_MIN)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">{this.renderToggleBar(ValidationKeys.NORMAL_MAX)}</div>
							{this.checkSectionEnabled(ValidationKeys.NORMAL_MAX) &&
								this.renderSectionBody(ValidationKeys.NORMAL_MAX)}
						</div>
					</>
				)}
				{this.hasCustomValidation(this.workingParam.paramType) && (
					<div className="border sx-validation-section">
						<div className="autofit-row">{this.renderToggleBar(ValidationKeys.CUSTOM)}</div>
						{this.checkSectionEnabled(ValidationKeys.CUSTOM) &&
							this.renderSectionBody(ValidationKeys.CUSTOM)}
					</div>
				)}
			</>
		);
	}
}

export default SXDSBuilderValidationPanel;
