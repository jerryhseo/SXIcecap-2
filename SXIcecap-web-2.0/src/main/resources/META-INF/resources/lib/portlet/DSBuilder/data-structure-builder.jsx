import React, { createContext, useCallback, useContext, useState, useRef, useLayoutEffect } from "react";
import Form, { ClayInput, ClaySelect, ClaySelectWithOption, ClayToggle } from "@clayui/form";
import ClayIcon from "@clayui/icon";
import ClayLayout from "@clayui/layout";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import Tabs from "@clayui/tabs";
import {
	DataStructureProperty,
	DataTypeProperty,
	Event,
	LoadingStatus,
	ParamProperty,
	ParamType,
	ResourceIds,
	ValidationRule
} from "../../common/station-x";
import ClayButtonGroup from "@clayui/button/lib/Group";
import { Util } from "../../common/util";
import { DataStructure } from "./data-structure";
import { DataTypeInfo } from "../DTEditor/datatype-editor";
import {
	BooleanParameter,
	GroupParameter,
	Parameter,
	SelectParameter,
	StringParameter
} from "../../parameter/parameter";
import SXFormField, { SXInput, SXLabel, SXLocalizedInput } from "../../form/sxform";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import ClayPanel from "@clayui/panel";
import Label from "@clayui/label";
import { Body, Button, Cell, Head, Row, Table } from "@clayui/core";
import DropDown from "@clayui/drop-down";
import LocalizedInput from "@clayui/localized-input";

const ValidationBuilder = ({ namespace, formId, validation = {}, spritemap }) => {
	const [requiredState, setRequiredState] = useState(
		Util.isNotEmpty(validation) && Util.isNotEmpty(validation.required) && validation.required.value
	);
	const [patternState, setPatternState] = useState(
		Util.isNotEmpty(validation) && Util.isNotEmpty(validation.pattern) && Util.isNotEmpty(validation.pattern.value)
	);
	const [minState, setMinState] = useState(
		Util.isNotEmpty(validation) && Util.isNotEmpty(validation.min) && Util.isNotEmpty(validation.min.value)
	);
	const [maxState, setMaxState] = useState(
		Util.isNotEmpty(validation) && Util.isNotEmpty(validation.max) && Util.isNotEmpty(validation.max.value)
	);
	const [validateState, setValidateState] = useState(
		Util.isNotEmpty(validation) && Util.isNotEmpty(validation.validate)
	);

	const validationRef = useRef(validation);

	const handleRequiredToggle = () => {
		const value = !requiredState;

		if (value) {
			validationRef.current.required = {
				value: value,
				message: Util.isNotEmpty(validationRef.current.required) ? validationRef.current.required.message : ""
			};
		} else {
			delete validationRef.current.required;
		}

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});

		setRequiredState(value);
	};

	const handleRequiredMsgChanged = (e) => {
		const message = e.target.value;

		validationRef.current.required = {
			value: validationRef.current.required.value,
			message: message
		};

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handlePatternToggle = () => {
		if (!patternState) {
			validationRef.current.pattern = {
				value: Util.isNotEmpty(validationRef.current.pattern) ? validationRef.current.pattern.value : "",
				message: Util.isNotEmpty(validationRef.current.pattern) ? validationRef.current.pattern.message : ""
			};
		} else {
			delete validationRef.current.pattern;
		}

		setPatternState(!patternState);
	};

	const handlePatternValueChanged = (e) => {
		validationRef.current.pattern.value = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handlePatternMsgChanged = (e) => {
		validationRef.current.pattern.message = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handleMinToggle = () => {
		if (!minState) {
			validationRef.current.min = {
				value: Util.isNotEmpty(validationRef.current.min) ? validationRef.current.min.value : "",
				message: Util.isNotEmpty(validationRef.current.min) ? validationRef.current.min.message : ""
			};
		} else {
			delete validationRef.current.min;
		}

		setMinState(!minState);
	};

	const handleMinValueChanged = (e) => {
		validationRef.current.min.value = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handleMinMsgChanged = (e) => {
		validationRef.current.min.message = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handleMaxToggle = () => {
		if (!maxState) {
			validationRef.current.max = {
				value: Util.isNotEmpty(validationRef.current.max) ? validationRef.current.max.value : "",
				message: Util.isNotEmpty(validationRef.current.max) ? validationRef.current.max.message : ""
			};
		} else {
			delete validationRef.current.max;
		}

		setMaxState(!maxState);
	};

	const handleMaxValueChanged = (e) => {
		validationRef.current.max.value = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handleMaxMsgChanged = (e) => {
		validationRef.current.max.message = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const handleValidateToggle = () => {
		if (!validateState) {
			validationRef.current.validate = Util.isNotEmpty(validationRef.current.validate)
				? validationRef.current.validate
				: "";
		} else {
			delete validationRef.current.validate;
		}

		setValidateState(!validateState);
	};

	const handleValidateChanged = (e) => {
		validationRef.current.validate = e.target.value;

		Event.fire(Event.SX_FIELD_VALUE_CHANGED, namespace, namespace, {
			target: formId,
			paramName: "validation",
			paramVersion: "1.0.0",
			value: validationRef.current
		});
	};

	const requiredMessageId = namespace + "requiredMessage";
	const patternValueId = namespace + "patternValue";
	const patternMessageId = namespace + "patternMessage";
	const minValueId = namespace + "minValue";
	const minMessageId = namespace + "minMessage";
	const maxValueId = namespace + "maxValue";
	const maxMessageId = namespace + "maxMessage";
	const validateId = namespace + "validate";

	const requiredMsg =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.required) &&
		Util.isNotEmpty(validationRef.current.required.message)
			? validationRef.current.required.message
			: "";
	const patternValue =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.pattern) &&
		Util.isNotEmpty(validationRef.current.pattern.value)
			? validationRef.current.pattern.value
			: "";
	const patternMsg =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.pattern) &&
		Util.isNotEmpty(validationRef.current.pattern.message)
			? validationRef.current.pattern.message
			: "";
	const minValue =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.min) &&
		Util.isNotEmpty(validationRef.current.min.value)
			? validationRef.current.min.value
			: "";
	const minMsg =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.min) &&
		Util.isNotEmpty(validationRef.current.min.message)
			? validationRef.current.min.message
			: "";
	const maxValue =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.max) &&
		Util.isNotEmpty(validationRef.current.max.value)
			? validationRef.current.max.value
			: "";
	const maxMsg =
		Util.isNotEmpty(validationRef.current) &&
		Util.isNotEmpty(validationRef.current.max) &&
		Util.isNotEmpty(validationRef.current.max.message)
			? validationRef.current.max.message
			: "";
	const validateFunc =
		Util.isNotEmpty(validationRef.current) && Util.isNotEmpty(validationRef.current.validate)
			? validationRef.current.validate
			: "function(value){\n}";

	return (
		<>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<span>{"Required"}</span>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={handleRequiredToggle}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={requiredState}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: requiredState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "20px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{ fontSize: "0.875rem", fontWeight: "400", marginRight: "10px", width: "60px" }}
					>
						{Util.translate("message")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={requiredMessageId}
							defaultValue={requiredMsg}
							onBlur={handleRequiredMsgChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<span>{"Pattern"}</span>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={handlePatternToggle}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={patternState}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: patternState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{
							fontSize: "0.875rem",
							fontWeight: "400",
							marginRight: "10px",
							marginBottom: "5px",
							width: "60px"
						}}
					>
						{Util.translate("value")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={patternValueId}
							defaultValue={patternValue}
							onBlur={handlePatternValueChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: patternState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{ fontSize: "0.875rem", fontWeight: "400", marginRight: "10px", width: "60px" }}
					>
						{Util.translate("message")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={patternMessageId}
							defaultValue={patternMsg}
							onBlur={handlePatternMsgChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<span>{"Min"}</span>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={handleMinToggle}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={minState}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: minState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{
							fontSize: "0.875rem",
							fontWeight: "400",
							marginRight: "10px",
							marginBottom: "5px",
							width: "60px"
						}}
					>
						{Util.translate("value")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={minValueId}
							defaultValue={minValue}
							onBlur={handleMinValueChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: minState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{ fontSize: "0.875rem", fontWeight: "400", marginRight: "10px", width: "60px" }}
					>
						{Util.translate("message")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={minMessageId}
							defaultValue={minMsg}
							onBlur={handleMinMsgChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<span>{"Max"}</span>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={handleMaxToggle}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={maxState}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: maxState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{
							fontSize: "0.875rem",
							fontWeight: "400",
							marginRight: "10px",
							marginBottom: "5px",
							width: "60px"
						}}
					>
						{Util.translate("value")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={maxValueId}
							defaultValue={maxValue}
							onBlur={handleMaxValueChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: maxState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{ fontSize: "0.875rem", fontWeight: "400", marginRight: "10px", width: "60px" }}
					>
						{Util.translate("message")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<input
							id={maxMessageId}
							defaultValue={maxMsg}
							onBlur={handleMaxMsgChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
			</div>
			<div
				className="border"
				style={{ padding: "10px", marginBottom: "10px" }}
			>
				<div className="autofit-row">
					<span className="autifit-col autofit-col-expand">
						<span>{"Validate"}</span>
					</span>
					<span className="autofit-col">
						<ClayToggle
							onToggle={handleValidateToggle}
							spritemap={spritemap}
							symbol={{
								off: "times",
								on: "check"
							}}
							toggled={validateState}
							className="form-control-sm"
						/>
					</span>
				</div>
				<div
					style={{
						display: validateState ? "flex" : "none",
						marginLeft: "2rem",
						marginTop: "10px"
					}}
					className="auotit-row"
				>
					<span
						className="autofit-col"
						style={{ fontSize: "0.875rem", fontWeight: "400", marginRight: "10px", width: "60px" }}
					>
						{Util.translate("function")}
					</span>
					<span className="autofit-col autofit-col-expand">
						<textarea
							id={validateId}
							defaultValue={validateFunc}
							onBlur={handleValidateChanged}
							className="form-control form-control-sm"
						/>
					</span>
				</div>
			</div>
		</>
	);
};

const SelectOptionBuilder = ({ namespace, formId, options = [], languageId, availableLanguageIds, spritemap }) => {
	const [optionsState, setOptionsState] = useState(options);
	const builderFormId = namespace + "optionBuilder";

	useLayoutEffect(() => {}, []);

	return (
		<>
			<Table>
				<Head
					items={[
						{
							id: "1",
							name: Util.translate("label")
						},
						{
							id: "2",
							name: Util.translate("value")
						},
						{
							id: "3",
							name: Util.translate("actions")
						}
					]}
				>
					{(column) => <Cell key={column.id}>{column.name}</Cell>}
				</Head>
				<Body
					items={optionsState}
					onItemsChange={(e) => {
						console.log("onItemsChange: ", e);
					}}
				>
					{(row) => (
						<Row>
							<Cell>{row.label[languageId]}</Cell>
							<Cell>{row.value}</Cell>
							<Cell>
								<DropDown
									trigger={
										<ClayButtonWithIcon
											aria-label="Actions"
											symbol="ellipsis-v"
											title="Actions"
										/>
									}
								>
									<DropDown.ItemList
										items={[
											{ name: Util.translate("delete") },
											{ name: Util.translate("moveUp") },
											{ name: Util.translate("moveDown") }
										]}
									>
										{(action) => <DropDown.Item key={action.name}>{action.name}</DropDown.Item>}
									</DropDown.ItemList>
								</DropDown>
							</Cell>
						</Row>
					)}
				</Body>
			</Table>

			<div>{Util.translate("label")}</div>
			<LocalizedInput
				id={namespace + "label"}
				locales={availableLanguageIds.map((locale) => ({ label: locale, symbol: locale.toLowerCase() }))}
			/>
		</>
	);
};

const DataStructureBuilder = ({ portletParameters }) => {
	const { namespace, baseRenderURL, baseResourceURL, languageId, availableLanguageIds, permissions, spritemapPath } =
		portletParameters;
	const { workbenchURL, workbenchId, workbenchNamespace, dataTypeId } = portletParameters.params;
	const [paramTypeState, setParamTypeState] = useState(ParamType.STRING);

	const workingParamRef = useRef(Parameter.createParameter(ParamType.STRING));
	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);
	const [panelStepState, setPanelStepState] = useState(0);

	const dataTypeRef = useRef(null);
	const dataStructureRef = useRef(null);

	const rerenderProperties = [
		ParamProperty.DISPLAY_NAME,
		ParamProperty.TOOLTIP,
		ParamProperty.LABEL_POSITION,
		ParamProperty.DISABLED,
		ParamProperty.READ_ONLY,
		ParamProperty.VALIDATION,
		ParamProperty.TRUE_LABEL,
		ParamProperty.FALSE_LABEL
	];

	const propertyPanelId = namespace + "propertyPanel";
	const previewCanvasId = namespace + "previewCanvas";

	const basePanelFields = [
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.PARAM_NAME,
			required: true,
			label: Util.translate("parameter-name"),
			placeholder: Util.translate("code-name-of-the-parameter"),
			tooltip: Util.translate("code-name-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("parameter-name"),
			initValue: workingParamRef.current.paramName ?? "",
			validation: {
				required: {
					value: true,
					message: Util.translate("Parameter name is required")
				},
				pattern: {
					value: ValidationRule.VARIABLE,
					message: Util.translate("invalid-parameter-name")
				},
				min: {
					value: 8,
					message: Util.translate("too-short")
				},
				max: {
					value: 32,
					message: Util.translate("too-long")
				}
			}
		},
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.VERSION,
			required: true,
			label: Util.translate("version"),
			placeholder: Util.translate("version-of-the-parameter"),
			tooltip: Util.translate("version-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("version"),
			initValue: workingParamRef.current.paramVersion ?? "1.0.0",
			validation: {
				required: {
					value: true,
					message: Util.translate("Parameter version is required")
				},
				pattern: {
					value: ValidationRule.VERSION,
					message: Util.translate("invalid-parameter-version")
				}
			}
		},
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.DISPLAY_NAME,
			required: true,
			label: Util.translate("display-name"),
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			placeholder: Util.translate("display-name-of-the-parameter"),
			tooltip: Util.translate("display-name-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("display-name"),
			initValue: workingParamRef.current.displayName ?? {},
			validation: {
				required: {
					value: true,
					message: Util.translate("display-name-is-required")
				},
				min: {
					value: 2,
					message: Util.translate("too-short")
				},
				max: {
					value: 32,
					message: Util.translate("too-long")
				}
			}
		},
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.DEFINITION,
			label: Util.translate("definition"),
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			multiLine: true,
			placeholder: Util.translate("definition-of-the-parameter"),
			tooltip: Util.translate("definition-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("definition"),
			initValue: workingParamRef.current.definition ?? {}
		},
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.TOOLTIP,
			label: Util.translate("tooltip"),
			localized: true,
			languageId: languageId,
			availableLanguageIds: availableLanguageIds,
			placeholder: Util.translate("tooltip-of-the-parameter"),
			tooltip: Util.translate("tooltip-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("tooltip"),
			initValue: workingParamRef.current.tooltip ?? {}
		},
		{
			paramType: ParamType.STRING,
			paramName: ParamProperty.SYNONYMS,
			label: Util.translate("synonyms"),
			placeholder: Util.translate("synonyms-of-the-parameter"),
			tooltip: Util.translate("synonyms-of-the-parameter-tooltip"),
			ariaLabel: Util.translate("synonyms"),
			initValue: workingParamRef.current.synonyms ?? ""
		}
	];
	const optionFields = useRef([
		{
			paramType: ParamType.GROUP,
			paramName: "groupOptions",
			viewType: GroupParameter.ViewTypes.HORIZONTAL,
			fieldsPerRow: 2,
			members: [
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.ABSTRACT_KEY,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					labelPosition: Parameter.LabelPosition.INLINE_LEFT,
					trueLabel: Util.translate("abstract-key"),
					tooltip: Util.translate("abstract-key-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("abstract-key"),
					initValue: false
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.DOWNLOADABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					trueLabel: Util.translate("downloadable"),
					tooltip: Util.translate("downloadable-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("downloadable"),
					initValue: true
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.SEARCHABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					trueLabel: Util.translate("searchable"),
					tooltip: Util.translate("searchable-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("searchable"),
					initValue: true
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.DISABLED,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					trueLabel: Util.translate("disabled"),
					tooltip: Util.translate("disabled-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("disabled"),
					initValue: false
				},
				{
					paramType: ParamType.BOOLEAN,
					paramName: ParamProperty.READ_ONLY,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					trueLabel: Util.translate("read-only"),
					tooltip: Util.translate("read-only-of-the-parameter-tooltip"),
					ariaLabel: Util.translate("read-only"),
					initValue: false
				}
			]
		}
	]);

	const stepsRef = useRef([
		{
			title: Util.translate("basic")
		},
		{
			title: Util.translate("type-specific")
		},
		{
			title: Util.translate("options")
		},
		{
			title: Util.translate("validation")
		}
	]);

	/*!SECTION
		Attach event handlers only once when the conponent is rendered.
	*/
	useLayoutEffect(() => {
		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = Event.pickUpNamesapceDataPacket(e, namespace);
			if (Util.isEmpty(dataPacket)) return;

			if (dataPacket.paramName === ParamProperty.DISABLED && dataPacket.value === true) {
				workingParamRef.current.readOnly = false;
				Event.fire(Event.SX_PARAM_VALUE_CHANGED, namespace, namespace, {
					target: propertyPanelId,
					paramName: ParamProperty.READ_ONLY,
					paramVersion: "1.0.0",
					property: ParamProperty.VALUE,
					value: workingParamRef.current.readOnly
				});
			} else if (dataPacket.paramName === ParamProperty.READ_ONLY && dataPacket.value === true) {
				workingParamRef.current.disabled = false;
				Event.fire(Event.SX_PARAM_VALUE_CHANGED, namespace, namespace, {
					target: propertyPanelId,
					paramName: ParamProperty.DISABLED,
					paramVersion: "1.0.0",
					property: ParamProperty.VALUE,
					value: workingParamRef.current.disabled
				});
			}

			workingParamRef.current[dataPacket.paramName] = dataPacket.value;
			workingParamRef.current.clearError();

			console.log("DataStructureBuilder SX_FIELD_VALUE_CHANGED RECEIVED: ", e, workingParamRef.current);
			if (rerenderProperties.includes(dataPacket.paramName)) {
				let property;
				let value;
				switch (dataPacket.paramName) {
					case ParamProperty.DISPLAY_NAME: {
						property = ParamProperty.LABEL;
						value = workingParamRef.current[dataPacket.paramName][languageId];
					}
				}

				Event.fire(Event.SX_PARAM_PROPERTY_CHANGED, namespace, namespace, {
					target: previewCanvasId,
					paramName: workingParamRef.current.paramName,
					paramVersion: workingParamRef.current.paramVersion,
					property: property,
					value: value
				});
			}
		});

		Event.on(Event.SX_FORM_FIELD_FAILED, (e) => {
			const dataPacket = Event.pickUpNamesapceDataPacket(e, namespace);
			if (Util.isEmpty(dataPacket)) return;

			workingParamRef.current.setError(dataPacket.error);
			console.log("DataStructureBuilder SX_FORM_FIELD_FAILED RECEIVED: ", e, workingParamRef.current);
		});
	}, []);

	useLayoutEffect(() => {
		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.LOAD_DATA_STRUCTURE,
			params: {
				dataTypeId: dataTypeId
			},
			successFunc: (result) => {
				console.log("result: ", result);
				dataTypeRef.current = result.dataType;
				dataStructureRef.current = result.dataStructure ? result.dataStructure : new DataStructure();

				console.log("DataStructureBuilder dataType: ", dataTypeRef.current);
				console.log("DataStructureBuilder dataStructure: ", dataStructureRef.current);

				setLoadingStatus(LoadingStatus.COMPLETE);
			},
			errorFunc: (err) => {
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	}, [dataTypeId]);

	const panelContentCallback = useCallback(
		(panelStep) => {
			console.log("panelContentCallback: ", workingParamRef.current);
			switch (panelStep) {
				case 0: {
					return (
						<div>
							{basePanelFields.map((field) => {
								console.log("+++++", field, workingParamRef.current);
								return (
									<SXFormField
										key={field.paramName + "_" + field.paramVersion}
										namespace={namespace}
										properties={field}
										events={{
											fire: [
												{
													target: propertyPanelId,
													event: Event.SX_FIELD_VALUE_CHANGED
												}
											]
										}}
										spritemap={spritemapPath}
									/>
								);
							})}
						</div>
					);
				}
				case 1: {
					switch (workingParamRef.current.paramType) {
						case ParamType.STRING: {
							return (
								<SXFormField
									namespace={namespace}
									properties={{
										paramType: ParamType.BOOLEAN,
										paramName: ParamProperty.LOCALIZED,
										paramVersion: "1.0.0",
										viewType: SelectParameter.ViewTypes.CHECKBOX,
										label: Util.translate("localized"),
										tooltip: Util.translate("localized-tooltip"),
										trueLabel: Util.translate("localized")
									}}
									events={{
										fire: [
											{
												target: propertyPanelId,
												event: Event.SX_FIELD_VALUE_CHANGED
											}
										]
									}}
									spritemap={spritemapPath}
								/>
							);
						}
						case ParamType.SELECT: {
							return (
								<>
									<SXFormField
										namespace={namespace}
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
											initValue: SelectParameter.ViewTypes.DROPDOWN
										}}
										events={{
											fire: [
												{
													target: propertyPanelId,
													event: Event.SX_FIELD_VALUE_CHANGED
												}
											]
										}}
										spritemap={spritemapPath}
									/>
								</>
							);
						}
						case ParamType.BOOLEAN: {
							const fields = [
								{
									paramType: ParamType.STRING,
									paramName: ParamProperty.TRUE_LABEL,
									label: Util.translate("true-label"),
									paramVersion: "1.0.0",
									localized: true,
									languageId: languageId,
									availableLanguageIds: availableLanguageIds,
									placeholder: Util.translate("label-for-true-option"),
									tooltip: Util.translate("label-for-true-option-tooltip")
								},
								{
									paramType: ParamType.STRING,
									paramName: ParamProperty.FALSE_LABEL,
									label: Util.translate("false-label"),
									paramVersion: "1.0.0",
									localized: true,
									languageId: languageId,
									availableLanguageIds: availableLanguageIds,
									placeholder: Util.translate("label-for-false-option"),
									tooltip: Util.translate("label-for-false-option-tooltip")
								}
							];

							return (
								<div>
									{fields.map((field) => {
										return (
											<SXFormField
												key={field.paramName + "_" + field.paramVersion}
												namespace={namespace}
												properties={field}
												events={{
													fire: [
														{
															target: propertyPanelId,
															event: Event.SX_FIELD_VALUE_CHANGED
														}
													]
												}}
												spritemap={spritemapPath}
											/>
										);
									})}
								</div>
							);
						}
					}
					return <div>{"Step 2 to define a parameter."}</div>;
				}
				case 2: {
					return (
						<>
							<div className="sheet-section">
								<div className="sheet-subtitle">{Util.translate("label-position")}</div>
								<SXFormField
									namespace={namespace}
									properties={{
										paramType: ParamType.SELECT,
										paramName: ParamProperty.LABEL_POSITION,
										paramVersion: "1.0.0",
										viewType: SelectParameter.ViewTypes.RADIO,
										label: Util.translate("label-position"),
										tooltip: Util.translate("label-position-tooltip"),
										options: [
											{
												label: Util.translate("upper-left"),
												value: Parameter.LabelPosition.UPPER_LEFT
											},
											{
												label: Util.translate("inline-left"),
												value: Parameter.LabelPosition.INLINE_LEFT
											}
											/*
											{
												label: Util.translate("upper-right"),
												value: Parameter.LabelPosition.UPPER_RIGHT
											},
											{
												label: Util.translate("inline-right"),
												value: Parameter.LabelPosition.INLINE_RIGHT
											},
											{
												label: Util.translate("bottom-left"),
												value: Parameter.LabelPosition.BOTTOM_LEFT
											},
											{
												label: Util.translate("bottom-right"),
												value: Parameter.LabelPosition.BOTTOM_RIGHT
											}
											*/
										],
										initValue: SelectParameter.LabelPosition.UPPER_LEFT
									}}
									events={{
										fire: [
											{
												target: propertyPanelId,
												event: Event.SX_FIELD_VALUE_CHANGED
											},
											{
												target: previewCanvasId,
												event: Event.SX_PARAM_PROPERTY_CHANGED
											}
										],
										on: [
											{
												target: propertyPanelId,
												event: Event.SX_PARAM_VALUE_CHANGED
											}
										]
									}}
									spritemap={spritemapPath}
								/>
							</div>
							{optionFields.current.map((field) => {
								return (
									<SXFormField
										key={field.paramName + "_" + field.paramVersion}
										namespace={namespace}
										properties={field}
										events={{
											fire: [
												{
													target: propertyPanelId,
													event: Event.SX_FIELD_VALUE_CHANGED
												},
												{
													target: previewCanvasId,
													event: Event.SX_PARAM_PROPERTY_CHANGED
												}
											],
											on: [
												{
													target: propertyPanelId,
													event: Event.SX_PARAM_VALUE_CHANGED
												}
											]
										}}
										spritemap={spritemapPath}
									/>
								);
							})}
						</>
					);
				}
				case 3: {
					return (
						<ValidationBuilder
							namespace={namespace}
							formId={propertyPanelId}
							spritemap={spritemapPath}
						/>
					);
				}
			}
		},
		[paramTypeState, panelStepState]
	);

	const propertyPanelStyles = {
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px",
		width: "40%"
	};
	const buttonPanelStyles = {
		backgroundColor: "#f2f7c6",
		borderTop: "2px solid #CDCED9",
		borderBottom: "2px solid #CDCED9",
		borderLeft: "none",
		borderRight: "none",
		padding: ".75rem 5px",
		justifyContent: "center"
	};
	const previewPanelStyles = {
		backgroundColor: "#FFFFFF",
		border: "2px solid #CDCED9",
		padding: ".75rem 5px"
	};

	const handleEnableInputStatusChange = (e) => {
		dataStructureRef.current.enableInputStatus = e.target.checked;
	};
	const handleEnableGotoChange = (e) => {
		dataStructureRef.current.enableInputStatus = e.target.checked;
	};

	const handleParamTypeSelect = (e) => {
		console.log("handleParamTypeSelect: ", e);
		workingParamRef.current = Parameter.createParameter(e.target.value);
		setParamTypeState(e.target.value);
		setPanelStepState(0);
	};

	function validateParameter() {
		if (Util.isEmpty(workingParamRef.current.paramName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, namespace, namespace, {
				target: propertyPanelId,
				paramName: "paramName",
				paramVersion: "1.0.0",
				error: "Parameter name is required"
			});
			alert("Error: Parameter name is required");
			return false;
		}

		if (Util.isEmpty(workingParamRef.current.displayName)) {
			Event.fire(Event.SX_PARAM_ERROR_FOUND, namespace, namespace, {
				target: propertyPanelId,
				paramName: "displayName",
				paramVersion: "1.0.0",
				error: "Display name is required"
			});
			alert("Error: Display name is required");
			return false;
		}

		if (workingParamRef.current.hasError()) {
			alert("Error: " + workingParamRef.getError());
			return false;
		}

		return true;
	}

	const handlePanelStepChange = (step) => {
		setPanelStepState(step);
	};

	const handleAddParameter = () => {
		const noError = validateParameter();

		if (noError) {
			dataStructureRef.current.addParameter(workingParamRef.current);
			dataStructureRef.current.appendPreview(
				workingParamRef.current,
				previewCanvasId,
				namespace,
				languageId,
				availableLanguageIds,
				"",
				"",
				{
					on: [
						{
							target: previewCanvasId,
							event: Event.SX_PARAM_PROPERTY_CHANGED
						}
					]
				},
				"",
				{},
				spritemapPath
			);
		}
	};

	const renderCount = useRef(0);
	renderCount.current++;
	console.log("DataStructureBuilder renderCount: " + renderCount.current);

	if (loadingStatus === LoadingStatus.PENDING) {
		return <h3>Loading....</h3>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h3>Loading data structure failed...</h3>;
	}

	console.log("workingParamRef.current: ", workingParamRef.current);
	return (
		<>
			<DataTypeInfo
				title={dataTypeRef.current.displayName}
				abstract={dataTypeRef.current.description}
				items={[
					{
						label: Util.translate("id"),
						text: dataTypeRef.current[DataTypeProperty.ID]
					},
					{
						label: Util.translate("name"),
						text: dataTypeRef.current[DataTypeProperty.NAME]
					},
					{
						label: Util.translate("version"),
						text: dataTypeRef.current[DataTypeProperty.VERSION]
					},
					{
						label: Util.translate("extension"),
						text: dataTypeRef.current[DataTypeProperty.EXTENSION]
					}
				]}
				colsPerRow={2}
			/>
			<div style={{ display: "flex", justifyContent: "left" }}>
				<ClayToggle
					label={Util.translate("enable-input-status")}
					value={false}
					onChange={handleEnableInputStatusChange}
					sizing="sm"
				/>
				<ClayToggle
					label={Util.translate("enable-goto")}
					value={false}
					onChange={handleEnableGotoChange}
					sizing="sm"
				/>
			</div>

			<ClayLayout.Container
				fluid={true}
				view
				style={{
					paddingLeft: "0",
					paddingRight: "0"
				}}
			>
				<ClayLayout.Row justify="start">
					<ClayLayout.ContentCol
						size={5}
						style={propertyPanelStyles}
					>
						<Button.Group
							spaced
							style={{
								backgroundColor: "#f7edab",
								background: "rgba(247, 237, 171, 0.8)",
								padding: "10px 5px",
								justifyContent: "center",
								marginBottom: "20px"
							}}
						>
							<ClayButtonWithIcon
								aria-label={Util.translate("new")}
								symbol="plus"
								title={Util.translate("new")}
								spritemap={spritemapPath}
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("duplicate")}
								symbol="copy"
								title={Util.translate("duplicate")}
								spritemap={spritemapPath}
								displayType="secondary"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("delete")}
								symbol="trash"
								title={Util.translate("delete")}
								spritemap={spritemapPath}
								displayType="danger"
								size="sm"
							/>
							<ClayButtonWithIcon
								aria-label={Util.translate("import")}
								symbol="import"
								title={Util.translate("import")}
								spritemap={spritemapPath}
								displayType="secondary"
								size="sm"
								className="float-right"
							/>
						</Button.Group>
						<Form>
							<Form.Group className="form-group-sm">
								<SXLabel
									label={Util.translate("parameter-type")}
									forHtml={namespace + ParamProperty.PARAM_TYPE}
									required={true}
									tooltip={Util.translate("parameter-type-tooltip")}
									spritemap={spritemapPath}
									style={{ marginRight: "20px" }}
								/>
								<ClaySelectWithOption
									aria-label={Util.translate("parameter-type")}
									id={namespace + ParamProperty.PARAM_TYPE}
									options={Object.keys(ParamType).map((key) => ({
										label: ParamType[key],
										value: ParamType[key]
									}))}
									value={paramTypeState}
									onChange={handleParamTypeSelect}
								/>
							</Form.Group>

							<hr style={{ borderWidth: "3px" }}></hr>

							<ClayMultiStepNav>
								{stepsRef.current.map(({ subTitle, title }, i) => {
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
												onClick={() => handlePanelStepChange(i)}
												subTitle={subTitle}
											/>
										</ClayMultiStepNav.Item>
									);
								})}
							</ClayMultiStepNav>
							{panelContentCallback(panelStepState)}
						</Form>
					</ClayLayout.ContentCol>
					<ClayLayout.ContentCol style={buttonPanelStyles}>
						<ClayButtonGroup
							spaced={true}
							vertical={true}
						>
							<ClayButtonWithIcon
								aria-label="Move up"
								title="Move up"
								symbol="caret-top"
								onClick={() => {}}
								borderless
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Add"
								title="Add"
								symbol="caret-right"
								onClick={handleAddParameter}
								displayType="secondary"
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
							<ClayButtonWithIcon
								aria-label="Move down"
								title="Move down"
								symbol="caret-bottom"
								onClick={() => {}}
								borderless
								size="md"
								spritemap={spritemapPath}
							></ClayButtonWithIcon>
						</ClayButtonGroup>
					</ClayLayout.ContentCol>
					<ClayLayout.ContentCol
						expand={true}
						style={previewPanelStyles}
					>
						{dataStructureRef.current.render(
							namespace,
							previewCanvasId,
							languageId,
							availableLanguageIds,
							{
								fire: [
									{
										target: propertyPanelId,
										event: Event.SX_FIELD_VALUE_CHANGED
									}
								],
								on: [
									{
										target: previewCanvasId,
										event: Event.SX_PARAM_PROPERTY_CHANGED
									},
									{
										target: previewCanvasId,
										event: Event.SX_PARAM_ERROR_FOUND
									},
									{
										target: previewCanvasId,
										event: Event.SX_PARAM_VALUE_CHANGED
									}
								]
							},
							"",
							{},
							spritemapPath
						)}
					</ClayLayout.ContentCol>
				</ClayLayout.Row>
			</ClayLayout.Container>
		</>
	);
};

export default DataStructureBuilder;
