import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { DataStructure } from "./data-structure";
import { Util } from "../../common/util";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import {
	DataStructureProperty,
	DataTypeProperty,
	Event,
	ParamProperty,
	ParamType,
	ValidationRule,
	ViewTypes
} from "../../common/station-x";
import SXFormField from "../../form/sxform";
import { ClayToggle } from "@clayui/form";

const BasicParameterProperties = ({
	namespace,
	formId,
	languageId,
	availableLanguageIds,
	parameters,
	parameter,
	style,
	spritemap
}) => {
	const fields = useRef([
		{
			paramName: "group_01",
			paramVersion: "1.0.0",
			paramType: ParamType.GROUP,
			displayName: "",
			viewType: ViewTypes.HORIZONTAL,
			collapsable: false,
			fieldsPerRow: 2,
			members: [
				{
					paramName: ParamProperty.NAME,
					paramType: ParamType.STRING,
					paramVersion: "1.0.0",
					parent: {
						name: "group_01",
						version: "1.0.0"
					},
					displayName: Util.translate("parameter-name"),
					required: true,
					placeholder: Util.translate("code-name-of-the-parameter"),
					tooltip: Util.translate("parameter-name-tooltip"),
					validation: {
						required: {
							value: true,
							message: `${ParamProperty.NAME} is required`
						},
						pattern: {
							value: ValidationRule.VARIABLE,
							message: "Invalid parameter name"
						},
						min: {
							value: 3,
							message: "Should be at least 3"
						},
						max: {
							value: 32,
							message: "Should be shorter than 33"
						}
					},
					order: 1
				},
				{
					paramName: ParamProperty.VERSION,
					paramType: ParamType.STRING,
					paramVersion: "1.0.0",
					parent: {
						name: "group_01",
						version: "1.0.0"
					},
					displayName: Util.translate("version"),
					required: true,
					placeholder: Util.translate("version-of-the-parameter"),
					tooltip: Util.translate("parameter-version-tooltip"),
					validation: {
						required: {
							value: true,
							message: `${ParamProperty.VERSION} is required`
						},
						pattern: {
							value: ValidationRule.VERSION,
							message: "Invalid parameter version"
						}
					},
					defaultValue: "1.0.0",
					order: 2
				}
			],
			order: 1
		},
		{
			paramName: ParamProperty.DISPLAY_NAME,
			paramType: ParamType.STRING,
			paramVersion: "1.0.0",
			displayName: Util.translate("display-name"),
			required: true,
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			placeholder: Util.translate("display-name-of-the-parameter"),
			tooltip: Util.translate("display-name-tooltip"),
			validation: {
				required: {
					value: true,
					message: `${ParamProperty.DISPLAY_NAME} is required`
				},
				min: {
					value: 3,
					message: "Should be at least 3"
				},
				max: {
					value: 72,
					message: "Should be shorter than 72"
				}
			},
			order: 2
		},
		{
			paramName: ParamProperty.DEFINITION,
			paramType: ParamType.STRING,
			paramVersion: "1.0.0",
			displayName: Util.translate("definition"),
			multiLine: true,
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			placeholder: Util.translate("definition-of-the-parameter"),
			tooltip: Util.translate("definition-tooltip"),
			order: 3
		},
		{
			paramName: ParamProperty.TOOLTIP,
			paramType: ParamType.STRING,
			paramVersion: "1.0.0",
			displayName: Util.translate("tooltip"),
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			placeholder: Util.translate("tooltip-of-the-parameter"),
			tooltip: Util.translate("tooltip-tooltip"),
			order: 4
		},
		{
			paramName: ParamProperty.SYNONYMS,
			paramType: ParamType.STRING,
			paramVersion: "1.0.0",
			displayName: Util.translate("synonims"),
			placeholder: Util.translate("synonims-of-the-parameter"),
			tooltip: Util.translate("synonyms-tooltip"),
			order: 5
		}
	]);

	return (
		<>
			{fields.current.map((field) => (
				<SXFormField
					key={field.paramName}
					namespace={namespace}
					formId={formId}
					properties={field}
					style={style}
					spritemap={spritemap}
				/>
			))}
		</>
	);
};

const ParameterTypeProperties = ({
	namespace,
	formId,
	languageId,
	availableLanguageIds,
	parameters,
	parameter,
	style,
	spritemap
}) => {
	return (
		<>
			<div class="sheet sheet-md">
				<div class="sheet-header">
					<h3 class="sheet-title">{Util.translate("validation")}</h3>
				</div>
				<div class="sheet-section">
					<h4 class="sheet-subtitle">{Util.translate("required")}</h4>
					<h3 class="autofit-row sheet-subtitle">
						<span class="autofit-col autofit-col-expand">
							<span class="heading-text">
								<ClayToggle
									label="with symbol"
									onToggle={setToggle2}
									spritemap={spritemap}
									symbol={{
										off: "times",
										on: "check"
									}}
									toggled={toggled2}
								/>
							</span>
						</span>
						<span class="autofit-col">
							<span class="heading-end">
								<button
									class="btn btn-secondary btn-sm"
									type="button"
								>
									Add
								</button>
							</span>
						</span>
					</h3>
					<h4 class="sheet-tertiary-title">Sheet Tertiary Title</h4>
					<div class="sheet-text">
						Sheet Subtitle and Sheet Tertiary Title are contained inside a sheet-section.
					</div>
				</div>
				<div
					aria-orientation="vertical"
					class="panel-group panel-group-flush"
					role="tablist"
				>
					<div class="panel">
						<a
							aria-controls="accordion03CollapseTwo"
							aria-expanded="true"
							class="collapse-icon sheet-subtitle"
							data-toggle="collapse"
							href="#accordion03CollapseTwo"
							id="accordion03HeadingTwo"
							role="tab"
						>
							<span>First Level Collapse 1</span>
							<span class="collapse-icon-closed">
								<svg
									class="lexicon-icon lexicon-icon-angle-right"
									focusable="false"
									role="presentation"
								>
									<use href="/images/icons/icons.svg#angle-right"></use>
								</svg>
							</span>
							<span class="collapse-icon-open">
								<svg
									class="lexicon-icon lexicon-icon-angle-down"
									focusable="false"
									role="presentation"
								>
									<use href="/images/icons/icons.svg#angle-down"></use>
								</svg>
							</span>
						</a>
						<div
							aria-labelledby="accordion03HeadingTwo"
							class="panel-collapse collapse show"
							id="accordion03CollapseTwo"
							role="tabpanel"
							style=""
						>
							<div class="panel-body">
								<div class="sheet-text">This is an example of explanatory text.</div>
							</div>
						</div>
					</div>
				</div>
				<div class="sheet-footer">
					<div class="btn-group-item">
						<div class="btn-group-item">
							<button
								class="btn btn-primary"
								type="button"
							>
								Primary
							</button>
						</div>
						<div class="btn-group-item">
							<button
								class="btn btn-secondary"
								type="button"
							>
								Secondary
							</button>
						</div>
					</div>
				</div>
			</div>
		</>
	);
};

export const ParameterTypeDedicatedProperties = ({ spritemap, style }) => {};

export const ParameterOptionProperties = ({ spritemap, style }) => {};

const SXDSBuilderPropertiesPanel = ({
	namespace, //
	formId,
	languageId,
	availableLanguageIds,
	parameters,
	parameter,
	spritemap
}) => {
	const [panelStepState, setPanelStepState] = useState(0);
	const [activeTabState, setActiveTabState] = useState(0);
	const paramTypeOptions = Object.keys(ParamType).map((key) => ({ label: ParamType[key], value: ParamType[key] }));

	const stepsRef = useRef([
		{
			subTitle: Util.translate("basic"),
			title: Util.translate("step-one")
		},
		{
			subTitle: Util.translate("type-properties"),
			title: Util.translate("step-two")
		},
		{
			subTitle: Util.translate("options"),
			title: Util.translate("step-three")
		}
	]);

	const panelContentRef = useRef(null);

	const panelContentCallback = useCallback(() => {
		switch (panelStepState) {
			case 0: {
				return (
					<BasicParameterProperties
						namespace={namespace}
						formId={formId}
						languageId={languageId}
						availableLanguageIds={availableLanguageIds}
						parameters={parameters}
						parameter={parameter}
						spritemap={spritemap}
					/>
				);
			}
			case 1: {
				return <div>Step 2</div>;
			}
			case 2: {
				return <div>Step 3</div>;
			}
		}
	}, [panelStepState]);

	panelContentRef.current = panelContentCallback();

	const renderCount = useRef(0);
	renderCount.current++;
	console.log("SXDSBuilderPropertiesPanel renderCount: " + renderCount.current);

	return (
		<>
			<SXFormField
				namespace={namespace}
				formId={formId}
				properties={{
					paramType: ParamType.SELECT,
					paramName: "parameterType",
					tagId: "parameterType",
					tagName: "parameterType",
					required: true,
					displayName: Util.translate("parameter-type"),
					options: paramTypeOptions,
					viewType: "dropdown",
					placeholder: "Select a type",
					tooltip: Util.translate("select-param-type-tooltip"),
					ariaLabel: "Select Parameter Type",
					initValue: parameter.value ?? parameter.defaultValue
				}}
				events={{
					fire: [Event.SX_FORM_FIELD_CHANGED],
					on: [Event.SX_PARAM_ERROR_FOUND]
				}}
				style={{
					marginBottom: "20px"
				}}
				spritemap={spritemap}
			/>
			<ClayMultiStepNav>
				{stepsRef.current.map(({ subTitle, title }, i) => {
					console.log("current step: " + i);
					const complete = i < panelStepState;

					return (
						<ClayMultiStepNav.Item
							active={panelStepState === i}
							expand={i + 1 !== stepsRef.current.length}
							key={i}
							state={complete ? "complete" : undefined}
						>
							<ClayMultiStepNav.Title>{title}</ClayMultiStepNav.Title>
							<ClayMultiStepNav.Divider />
							<ClayMultiStepNav.Indicator
								complete={complete}
								label={i + 1}
								onClick={() => setPanelStepState(i)}
								subTitle={subTitle}
							/>
						</ClayMultiStepNav.Item>
					);
				})}
			</ClayMultiStepNav>
			{panelContentRef.current}
		</>
	);
};

export default SXDSBuilderPropertiesPanel;
