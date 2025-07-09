import React, { useContext, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamType, ValidationKeys } from "../../common/station-x";
import { ClayCheckbox, ClayInput, ClayToggle } from "@clayui/form";
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

		this.state = {
			validation: this.workingParam.validation ?? {},
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
		};
	}

	validationEnabled(section) {
		return this.workingParam.checkValidationEnabled(section);
	}

	getTranslations(section) {
		return this.workingParam.getValidationValue(section, "message") ?? {};
	}

	getValue(section) {
		return this.workingParam.getValidationValue(section, section === ValidationKeys.CUSTOM ? null : "value");
	}

	setValue(section, value) {
		this.workingParam.setValidationValue(section, "value", value);

		if (section === ValidationKeys.REQUIRED) {
			if (value) {
				for (let i = 0; i < this.availableLanguageIds.length; i++) {
					const lang = this.availableLanguageIds[i];
					this.workingParam.setValidationValue(
						ValidationKeys.REQUIRED,
						"message",
						"This field is required",
						lang
					);
				}
			}
		}

		this.setState({ validation: { ...this.workingParam.validation } });

		this.workingParam.fireRefreshPreview();
	}

	setTranslations(section, translations) {
		this.workingParam.setValidationValue(section, "message", translations);
		this.setState({ validation: { ...this.workingParam.validation } });

		this.workingParam.fireRefreshPreview();
	}

	handleToggle(section) {
		this.workingParam.toggleValidationSection(section);

		if (section === ValidationKeys.REQUIRED) {
			this.setValue(section, this.workingParam.checkValidationEnabled(section));
		} else {
			this.setState({ validation: { ...this.workingParam.validation } });

			this.workingParam.fireRefreshPreview();
		}
	}

	toggleBoundary(section) {
		this.workingParam.setValidationValue(section, "boundary", !this.state.validation[section].boundary);

		this.setState({ validation: { ...this.workingParam.validation } });

		this.workingParam.fireRefreshPreview();
	}

	handleValueChanged(section, value) {
		switch (section) {
			case ValidationKeys.PATTERN:
			case ValidationKeys.CUSTOM:
				this.setValue(section, value);
				break;
			case ValidationKeys.MIN_LENGTH:
			case ValidationKeys.MAX_LENGTH:
				if (isNaN(value)) {
					this.setValue(section, "");
				} else {
					this.setValue(section, Util.isNotEmpty(value) ? Math.floor(Number(value)) : "");
				}
				break;
			case "min":
			case ValidationKeys.MIN:
			case ValidationKeys.MAX:
			case ValidationKeys.NORMAL_MIN:
			case ValidationKeys.NORMAL_MAX:
				if (isNaN(value)) {
					this.setValue(section, "");
				} else {
					this.setValue(section, Util.isNotEmpty(value) ? Number(value) : "");
				}

				break;
		}
	}

	handleMessageChanged(section, translations) {
		this.setTranslations(section, translations);
	}

	handleLanguageChanged(section, locale) {
		this.state.selectedLang[section] = locale;

		this.setState({ ...this.state.selectedLang });
	}

	render() {
		return (
			<>
				<div className="border sx-validation-section">
					<div className="autofit-row">
						<span className="autifit-col autofit-col-expand">
							<h4>{"Required"}</h4>
						</span>
						<span className="autofit-col">
							<ClayToggle
								onToggle={() => this.handleToggle(ValidationKeys.REQUIRED)}
								spritemap={this.spritemap}
								symbol={{
									off: "times",
									on: "check"
								}}
								toggled={this.validationEnabled(ValidationKeys.REQUIRED)}
								className="form-control-sm"
							/>
						</span>
					</div>
					{this.validationEnabled(ValidationKeys.REQUIRED) && (
						<div className="sx-validation-section-enabled">
							<LocalizedInput
								id={this.namespace + "requiredMessage"}
								locales={this.locales}
								label={Util.translate("message")}
								onSelectedLocaleChange={(locale) =>
									this.handleLanguageChanged(ValidationKeys.REQUIRED, locale)
								}
								selectedLocale={this.state.selectedLang.required}
								translations={this.getTranslations(ValidationKeys.REQUIRED)}
								onTranslationsChange={(translations) =>
									this.handleMessageChanged(ValidationKeys.REQUIRED, translations)
								}
								spritemap={this.spritemap}
							/>
						</div>
					)}
				</div>
				{(this.workingParam.paramType === ParamType.STRING ||
					this.workingParam.paramType === ParamType.LOCALIZED_STRING) && (
					<>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{"Pattern"}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.PATTERN)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.PATTERN)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.PATTERN) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<input
										id={this.namespace + "patternValue"}
										defaultValue={this.getValue(ValidationKeys.PATTERN)}
										onBlur={(e) => this.handleValueChanged(ValidationKeys.PATTERN, e.target.value)}
										className="form-control form-control-sm"
									/>

									<LocalizedInput
										id={this.namespace + "patternMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.PATTERN, locale)
										}
										selectedLocale={this.state.selectedLang.pattern}
										translations={this.getTranslations(ValidationKeys.PATTERN)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.PATTERN, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{Util.translate("min-length")}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.MIN_LENGTH)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.MIN_LENGTH)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.MIN_LENGTH) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<input
										id={this.namespace + "minLengthValue"}
										defaultValue={this.getValue(ValidationKeys.MIN_LENGTH)}
										onBlur={(e) =>
											this.handleValueChanged(ValidationKeys.MIN_LENGTH, e.target.value)
										}
										className="form-control form-control-sm"
									/>
									<LocalizedInput
										id={this.namespace + "minLengthMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.MIN_LENGTH, locale)
										}
										selectedLocale={this.state.selectedLang.minLength}
										translations={this.getTranslations(ValidationKeys.MIN_LENGTH)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.MIN_LENGTH, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{Util.translate("max-length")}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.MAX_LENGTH)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.MAX_LENGTH)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.MAX_LENGTH) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<input
										id={this.namespace + "maxLengthValue"}
										defaultValue={this.getValue(ValidationKeys.MAX_LENGTH)}
										onBlur={(e) =>
											this.handleValueChanged(ValidationKeys.MAX_LENGTH, e.target.value)
										}
										className="form-control form-control-sm"
									/>
									<LocalizedInput
										id={this.namespace + "maxLengthMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.MAX_LENGTH, locale)
										}
										selectedLocale={this.state.selectedLang.maxLength}
										translations={this.getTranslations(ValidationKeys.MAX_LENGTH)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.MAX_LENGTH, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
					</>
				)}
				{(this.workingParam.paramType === ParamType.NUMERIC ||
					this.workingParam.paramType === ParamType.INTEGER) && (
					<>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{"Min"}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle("min")}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled("min")}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled("min") && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<ClayInput.Group>
										<ClayInput.GroupItem>
											<input
												id={this.namespace + "minValue"}
												defaultValue={this.getValue("min")}
												onBlur={(e) => this.handleValueChanged("min", e.target.value)}
												className="form-control form-control-sm"
											/>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											prepend
											shrink
										>
											<ClayCheckbox
												aria-label={Util.translate("min-boundary")}
												checked={this.state.validation.min.boundary ?? false}
												onChange={() => this.toggleBoundary("min")}
												label={Util.translate("boundary")}
											/>
										</ClayInput.GroupItem>
									</ClayInput.Group>
									<LocalizedInput
										id={this.namespace + "minMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) => this.handleLanguageChanged("min", locale)}
										selectedLocale={this.state.selectedLang.min}
										translations={this.getTranslations("min")}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged("min", translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{"Max"}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.MAX)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.MAX)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.MAX) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<ClayInput.Group>
										<ClayInput.GroupItem>
											<input
												id={this.namespace + "maxValue"}
												defaultValue={this.getValue(ValidationKeys.MAX)}
												onBlur={(e) =>
													this.handleValueChanged(ValidationKeys.MAX, e.target.value)
												}
												className="form-control form-control-sm"
											/>
										</ClayInput.GroupItem>
										<ClayInput.GroupItem
											prepend
											shrink
										>
											<ClayCheckbox
												aria-label={Util.translate("max-boundary")}
												checked={this.state.validation.max.boundary ?? false}
												onChange={() => this.toggleBoundary(ValidationKeys.MAX)}
												label={Util.translate("boundary")}
											/>
										</ClayInput.GroupItem>
									</ClayInput.Group>
									<LocalizedInput
										id={this.namespace + "maxMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.MAX, locale)
										}
										selectedLocale={this.state.selectedLang.max}
										translations={this.getTranslations(ValidationKeys.MAX)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.MAX, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{Util.translate("normal-min")}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.NORMAL_MIN)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.NORMAL_MIN)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.NORMAL_MIN) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<input
										id={this.namespace + ValidationKeys.NORMAL_MIN}
										defaultValue={this.getValue(ValidationKeys.NORMAL_MIN)}
										onBlur={(e) =>
											this.handleValueChanged(ValidationKeys.NORMAL_MIN, e.target.value)
										}
										className="form-control form-control-sm"
									/>
									<ClayCheckbox
										aria-label={Util.translate("normal-min-boundary")}
										checked={this.state.validation.normalMin.boundary}
										onChange={() => this.toggleBoundary(ValidationKeys.NORMAL_MIN)}
										label={Util.translate("boundary")}
									/>
									<LocalizedInput
										id={this.namespace + "normalMinMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.NORMAL_MIN, locale)
										}
										selectedLocale={this.state.selectedLang.normalMin}
										translations={this.getTranslations(ValidationKeys.NORMAL_MIN)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.NORMAL_MIN, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
						<div className="border sx-validation-section">
							<div className="autofit-row">
								<span className="autifit-col autofit-col-expand">
									<h4>{Util.translate("normal-max")}</h4>
								</span>
								<span className="autofit-col">
									<ClayToggle
										onToggle={() => this.handleToggle(ValidationKeys.NORMAL_MAX)}
										spritemap={this.spritemap}
										symbol={{
											off: "times",
											on: "check"
										}}
										toggled={this.validationEnabled(ValidationKeys.NORMAL_MAX)}
										className="form-control-sm"
									/>
								</span>
							</div>
							{this.validationEnabled(ValidationKeys.NORMAL_MAX) && (
								<div className="sx-validation-section-enabled">
									<span className="sx-validation-label">{Util.translate("value")}</span>
									<input
										id={this.namespace + ValidationKeys.NORMAL_MAX}
										defaultValue={this.getValue(ValidationKeys.NORMAL_MAX)}
										onBlur={(e) =>
											this.handleValueChanged(ValidationKeys.NORMAL_MAX, e.target.value)
										}
										className="form-control form-control-sm"
									/>
									<ClayCheckbox
										aria-label={Util.translate("normal-max-boundary")}
										checked={this.state.validation.normalMax.boundary}
										onChange={() => this.toggleBoundary(ValidationKeys.NORMAL_MAX)}
										label={Util.translate("boundary")}
									/>
									<LocalizedInput
										id={this.namespace + "normalMaxMessage"}
										locales={this.locales}
										label={Util.translate("message")}
										onSelectedLocaleChange={(locale) =>
											this.handleLanguageChanged(ValidationKeys.NORMAL_MAX, locale)
										}
										selectedLocale={this.state.selectedLang.normalMax}
										translations={this.getTranslations(ValidationKeys.NORMAL_MAX)}
										onTranslationsChange={(translations) =>
											this.handleMessageChanged(ValidationKeys.NORMAL_MAX, translations)
										}
										spritemap={this.spritemap}
									/>
								</div>
							)}
						</div>
					</>
				)}
				{(this.workingParam.paramType === ParamType.STRING ||
					this.workingParam.paramType === ParamType.LOCALIZED_STRING ||
					this.workingParam.paramType === ParamType.NUMERIC ||
					this.workingParam.paramType === ParamType.INTEGER ||
					this.workingParam.paramType === ParamType.MATRIX) && (
					<div className="border sx-validation-section">
						<div className="autofit-row">
							<span className="autifit-col autofit-col-expand">
								<h4>{"Custom"}</h4>
							</span>
							<span className="autofit-col">
								<ClayToggle
									onToggle={() => this.handleToggle(ValidationKeys.CUSTOM)}
									spritemap={this.spritemap}
									symbol={{
										off: "times",
										on: "check"
									}}
									toggled={this.validationEnabled(ValidationKeys.CUSTOM)}
									className="form-control-sm"
								/>
							</span>
						</div>
						{this.validationEnabled(ValidationKeys.CUSTOM) && (
							<div className="sx-validation-section-enabled">
								<span className="sx-validation-label">{Util.translate("function")}</span>
								<textarea
									id={this.namespace + ValidationKeys.CUSTOM}
									defaultValue={this.getValue(ValidationKeys.CUSTOM)}
									onBlur={(e) => this.handleValueChanged(ValidationKeys.CUSTOM, e.target.value)}
									className="form-control form-control-sm"
								/>
							</div>
						)}
					</div>
				)}
			</>
		);
	}
}

export default SXDSBuilderValidationPanel;
