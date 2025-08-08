import React, { createRef } from "react";
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
	ValidationSectionProperty,
	Constant
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
import { Body, Cell, Head, Table } from "@clayui/core";
import SXDropdown from "../modal/sxdropdown";

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

export const SXTitleBar = ({ title, required = false, tooltip = "", style, spritemap }) => {
	return <></>;
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

export const SXAutoComplete = ({ namespace, items, events, spritemap }) => {
	const inputId = namespace + "input";

	let groupClass = "form-group autofit-row";
	let inputClass = "form-control input-group-inset input-group-inset-after autofit-col autofit-col-expand";
	const labelClass = " autofit-col";

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

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.canvasId) return;

		console.log(
			"SXDataStructurePreviewer SX_FIELD_VALUE_CHANGED RECEIVED: ",
			dataPacket,
			this.dataStructure,
			this.dataStructure.members
		);

		this.forceUpdate();
	};

	componentDidMount() {
		console.log("=== SXDataStatusBar componentDidMount executed ===");
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
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
		const totalFieldsCount = this.dataStructure.totalFieldsCount;
		const valuedFieldsCount = this.dataStructure.valuedFieldsCount;

		return (
			<Toolbar style={{ paddingLeft: "10px", paddingRight: "10px", background: "#d8f2df", marginBottom: "15px" }}>
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
											{valuedFieldsCount +
												"/" +
												totalFieldsCount +
												"(" +
												((valuedFieldsCount / totalFieldsCount) * 100).toFixed(1) +
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
		this.parameter = props.parameter;
		this.languageId = props.parameter.languageId;
		this.availableLanguageIds = props.parameter.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.className = props.className ?? "";
		this.style = props.style ?? {};

		this.state = {
			activeDropdown: false,
			underConstruction: false
		};

		this.events = {};
	}

	refreshPreviewHandler = (e) => {
		let dataPacket = Event.pickUpDataPacket(
			e,
			this.namespace,
			this.parameter.formId,
			this.parameter.paramName,
			this.parameter.paramVersion
		);

		if (!dataPacket && this.parameter.paramType === ParamType.GRID) {
			dataPacket = Event.pickUpDataPacket(
				e,
				this.namespace,
				this.parameter.tagName,
				this.parameter.paramName,
				this.parameter.paramVersion
			);
		}

		if (!dataPacket) {
			//console.log("Rejected SXPreviewRow SX_REFRESH_PREVIEW: ", e.dataPacket, this.parameter);
			return;
		}

		//console.log("SXPreviewRow SX_REFRESH_PREVIEW: ", dataPacket, this.parameter);
		this.forceUpdate();
	};

	componentDidMount() {
		/*
		console.log("=== SXPreviewRow componentDidMount executed ===");
		console.log("* ", this.parameter);
		console.log("\n");
		*/

		Event.on(Event.SX_REFRESH_PREVIEW, this.refreshPreviewHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH_PREVIEW, this.refreshPreviewHandler);
	}

	handleClick(e) {
		e.stopPropagation();

		if (!this.parameter.focused) {
			this.parameter.focused = true;

			this.parameter.fireParameterSelected(this.dsbuilderId);

			this.forceUpdate();
		}
	}

	handleActionClick(actionId) {
		switch (actionId) {
			case "group": {
				this.parameter.fireSelectGroup(this.propertyPanelId);
				break;
			}
			case "copy": {
				this.parameter.fireCopy(this.dsbuilderId);
				break;
			}
			case "delete": {
				this.parameter.fireDelete(this.dsbuilderId);
				break;
			}
			case "moveUp": {
				this.parameter.fireMoveUp(this.previewCanvasId);
				break;
			}
			case "moveDown": {
				this.parameter.fireMoveDown(this.previewCanvasId);
				break;
			}
		}

		this.setState({ activeDropdown: false });
	}

	handleActiveChange(val) {
		if (!this.parameter.focused) {
			this.parameter.focused = true;
			this.parameter.fireParameterSelected(this.dsbuilderId);
		}

		this.setState({ activeDropdown: val });
	}

	render() {
		let className = this.parameter.focused ? "autofit autofit-row sx-focused" : "autofit autofit-row";

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

		let actionItems = [
			{ id: "group", name: Util.translate("change-group"), symbol: "move-folder" },
			{ id: "copy", name: Util.translate("copy"), symbol: "copy" },
			{ id: "delete", name: Util.translate("delete"), symbol: "times" }
		];

		if (this.parameter.position === Constant.Position.START) {
			actionItems.push({ id: "moveDown", name: Util.translate("move-down"), symbol: "order-arrow-down" });
		} else if (this.parameter.position === Constant.Position.END) {
			actionItems.push({ id: "moveUp", name: Util.translate("move-up"), symbol: "order-arrow-up" });
		} else if (this.parameter.position !== Constant.Position.DEAD_END) {
			actionItems.push({ id: "moveDown", name: Util.translate("move-down"), symbol: "order-arrow-down" });
			actionItems.push({ id: "moveUp", name: Util.translate("move-up"), symbol: "order-arrow-up" });
		}

		return (
			<>
				<div
					className={className + " sx-preview-row"}
					onClick={(e) => {
						e.stopPropagation();
						this.handleClick(e);
					}}
				>
					<div
						className="autofit-col autofit-col-expand"
						style={{ marginRight: "10px", width: "100%" }}
					>
						{this.parameter.render({
							style: style,
							spritemap: this.spritemap,
							inputStatus: this.parameter.inputStatus,
							preview: true,
							dsbuilderId: this.dsbuilderId,
							propertyPanelId: this.propertyPanelId,
							previewCanvasId: this.previewCanvasId
						})}
					</div>
					<div
						key={Util.randomKey()}
						className="autofit-col autofit-col-shrink"
						style={{ alignSelf: "center" }}
					>
						<DropDown
							key={Util.randomKey()}
							active={this.state.activeDropdown}
							trigger={
								<ClayButtonWithIcon
									aria-label="Actions"
									symbol="ellipsis-v"
									title="Actions"
									borderless="true"
									className="btn-secondary"
									spritemap={this.spritemap}
									onClick={(e) => {
										e.stopPropagation();
									}}
								/>
							}
							onActiveChange={(val) => this.handleActiveChange(val)}
							menuWidth="shrink"
						>
							<DropDown.ItemList items={actionItems}>
								{(actionItem) => (
									<DropDown.Item
										key={actionItem.id}
										onClick={(e) => {
											e.stopPropagation();
											this.handleActionClick(actionItem.id);
										}}
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
		this.viewType = props.viewType ?? props.parameter.viewType;
		this.cellIndex = props.cellIndex;

		this.state = {
			value: this.parameter.getValue(this.cellIndex)
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	handleChange(value) {
		if (value === this.state.value) {
			return;
		}

		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });
		this.setState({ value: value });
	}

	fireValueChanged(value) {
		this.parameter.fireValueChanged(this.cellIndex);
	}

	renderGridCell() {
		return (
			<div style={{ ...this.parameter.style }}>
				<ClayInput
					component={this.parameter.multipleLine ? "textarea" : "input"}
					id={this.parameter.getTagId(this.cellIndex)}
					name={this.parameter.tagName}
					placeholder={this.parameter.getPlaceholder(this.parameter.languageId)}
					type="text"
					value={this.state.value}
					disabled={this.parameter.disabled}
					onChange={(e) => this.handleChange(e.target.value)}
					onBlur={(e) => this.fireValueChanged(e.target.value)}
					style={{ border: "none" }}
					ref={this.focusRef}
				/>
				{this.parameter.dirty && this.parameter.hasError() && (
					<SXFormFieldFeedback
						content={this.parameter.errorMessage}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</div>
		);
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		const style = { ...this.style, ...this.parameter.style };
		style.marginBottom = this.style.marginBottom ?? "15px";

		return (
			<div
				className={className}
				style={{ ...style, marginBottom: "0" }}
			>
				{this.parameter.renderLabel({
					forHtml: this.parameter.tagId,
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition(this.parameter.languageId)}</pre>
					</div>
				)}
				<ClayInput.Group style={{ paddingLeft: "10px" }}>
					{!!this.parameter.prefix && this.parameter.renderPrefix()}
					<ClayInput.GroupItem>
						<ClayInput
							component={this.parameter.multipleLine ? "textarea" : "input"}
							id={this.parameter.getTagId(this.cellIndex)}
							name={this.parameter.tagName}
							placeholder={this.parameter.getPlaceholder(this.parameter.languageId)}
							type="text"
							value={this.state.value}
							disabled={this.parameter.disabled}
							onChange={(e) => this.handleChange(e.target.value)}
							onBlur={(e) => {
								this.fireValueChanged(e.target.value);
							}}
							ref={this.focusRef}
						/>
					</ClayInput.GroupItem>
					{!!this.parameter.postfix && this.parameter.renderPostfix()}
				</ClayInput.Group>
				{this.parameter.dirty && this.parameter.hasError() && (
					<SXFormFieldFeedback
						content={this.parameter.errorMessage}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
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
		this.cellIndex = this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL ? props.cellIndex : undefined;

		this.state = {
			selectedLang: props.parameter.languageId,
			translation: this.parameter.getTranslation(this.parameter.languageId, this.cellIndex)
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	handleChange(value) {
		if (this.state.translation === value) {
			return;
		}

		this.parameter.setTranslation(this.state.selectedLang, value, this.cellIndex);
		this.parameter.dirty = true;

		this.setState({
			translation: value
		});

		this.parameter.validate(this.cellIndex);
	}

	fireValueChanged() {
		this.parameter.fireValueChanged(this.cellIndex);
	}

	getClayUI(tagId, tagName) {
		return (
			<div style={{ ...this.style, ...this.parameter.style }}>
				<ClayInput.Group>
					{this.parameter.renderPrefix()}
					<ClayInput.GroupItem>
						<ClayInput
							component={this.parameter.multipleLine ? "textarea" : "input"}
							type="text"
							id={tagId}
							name={tagName}
							value={this.state.translation}
							placeholder={this.parameter.getPlaceholder(this.state.selectedLang)}
							disabled={this.parameter.disabled}
							onChange={(e) => this.handleChange(e.target.value)}
							onBlur={(e) => this.fireValueChanged()}
							ref={this.focusRef}
						/>
					</ClayInput.GroupItem>
					{this.parameter.renderPostfix()}
					<ClayInput.GroupItem shrink>
						<DropDown
							trigger={
								<Button
									displayType="secondary"
									className="btn-monospaced btn-md"
									disabled={this.parameter.disabled}
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
				{this.parameter.dirty && this.parameter.hasError() && (
					<SXFormFieldFeedback
						content={this.parameter.errorMessage}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</div>
		);
	}

	renderGridCell() {
		return this.getClayUI(this.parameter.tagId + "_" + this.cellIndex, this.parameter.tagName);
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<ClayForm.Group
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					forHtml: this.parameter.tagId,
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				<div style={{ paddingLeft: "10px" }}>
					{this.getClayUI(this.parameter.tagId, this.parameter.tagName)}
				</div>
			</ClayForm.Group>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
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

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		if (props.parameter.isInteger) {
			this.min = props.parameter.min;
			this.max = props.parameter.max;
		}

		const value = this.parameter.getValue(this.cellIndex) ?? "";
		this.state = {
			value: (this.parameter.uncertainty ? value.value ?? "" : value).toString(),
			uncertainty: (this.parameter.uncertainty ? value.uncertainty ?? "" : "").toString()
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	toNumber(val) {
		return this.parameter.isInteger ? Math.trunc(Number(val)) : Number(val).toFixed(this.parameter.decimalPlaces);
	}

	handleValueChanged(newValue) {
		if (this.state.value === newValue) {
			return;
		}

		const value = this.parameter.uncertainty
			? { value: this.toNumber(newValue), uncertainty: this.toNumber(this.state.uncertainty) }
			: this.toNumber(newValue);

		this.setState({ value: newValue });
		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	handleUncertaintyChanged(newUncertainty) {
		if (newUncertainty === this.state.uncertainty) {
			return;
		}

		const value = { value: this.toNumber(this.state.value), uncertainty: this.toNumber(newUncertainty) };

		this.setState({ uncertainty: newUncertainty });
		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	renderClayUI() {
		return (
			<>
				<ClayInput.Group stacked>
					{this.parameter.validationMin && (
						<>
							<ClayInput.GroupItem
								prepend
								shrink
							>
								<ClayInput.GroupText>
									{this.parameter.getValidationValue(
										ValidationKeys.MIN,
										ValidationSectionProperty.VALUE
									)}
								</ClayInput.GroupText>
							</ClayInput.GroupItem>
							<ClayInput.GroupItem
								append
								shrink
							>
								{this.parameter.getValidationValue(
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
						<ClayInput.Group>
							{this.parameter.renderPrefix()}
							<ClayInput.GroupItem>
								<ClayInput
									type={this.parameter.isInteger ? "number" : "text"}
									defaultValue={this.state.value}
									min={this.min}
									max={this.max}
									ref={this.focusRef}
									onChange={(e) => {
										this.handleValueChanged(e.target.value);
									}}
								/>
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</ClayInput.GroupItem>
					{this.parameter.uncertainty && (
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
								style={{ maxWidth: "10rem", width: "4rem" }}
							>
								<ClayInput
									type={this.parameter.isInteger ? "number" : "text"}
									defaultValue={this.state.uncertainty}
									min={this.min}
									max={this.max}
									onChange={(e) => this.handleUncertaintyChanged(e.target.value)}
								/>
							</ClayInput.GroupItem>
						</>
					)}
					{this.parameter.renderPostfix()}
					{this.parameter.unit && (
						<ClayInput.GroupItem
							append
							shrink
						>
							<ClayInput.GroupText>{this.parameter.unit}</ClayInput.GroupText>
						</ClayInput.GroupItem>
					)}
					{this.parameter.validationMax && (
						<>
							<ClayInput.GroupItem
								append
								shrink
							>
								{this.parameter.getValidationValue(
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
									{this.parameter.getValidationValue(
										ValidationKeys.MAX,
										ValidationSectionProperty.VALUE
									)}
								</ClayInput.GroupText>
							</ClayInput.GroupItem>
						</>
					)}
				</ClayInput.Group>
				{this.parameter.dirty &&
					(this.parameter.errorClass === ErrorClass.ERROR ||
						this.parameter.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</>
		);
	}

	renderGridCell() {
		return <>{this.renderClayUI()}</>;
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		const tagId = this.parameter.tagId;
		const tagName = tagId;

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				<div style={{ paddingLeft: "10px" }}>
					{this.parameter.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.parameter.getDefinition()}</pre>
						</div>
					)}
					{this.renderClayUI()}
				</div>
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else {
			return this.renderGridCell();
		}
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

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		this.focusRef = createRef();

		this.state = {
			value: this.parameter.getValue(this.cellIndex)
		};
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	setValue(value) {
		this.setState({ value: value });
		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	handleRadioClick(val) {
		if (this.state.value === val) {
			this.setValue(null);
		}
	}

	handleValueChange(val) {
		this.setValue(val);
	}

	renderGridCell() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		const tagId = this.parameter.tagId;
		const tagName = tagId;

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
				ref={this.focusRef}
			>
				{this.parameter.viewType === BooleanParameter.ViewTypes.CHECKBOX && (
					<ClayCheckbox
						id={tagId}
						name={tagName}
						label={this.parameter.getTrueLabel()}
						aria-label={this.parameter.label}
						value={this.state.value ?? false}
						onChange={(e) => {
							console.log("checkbox changed: ", e);
							this.handleValueChange(!this.state.value);
						}}
						disabled={this.parameter.disabled}
					/>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.DROPDOWN && (
					<ClaySelect
						id={tagId}
						name={tagName}
						defaultValue={this.state.value}
						onSelect={(val) => {
							console.log("dropdown changed: ", val);
							this.handleValueChange(val);
						}}
						disabled={this.parameter.disabled}
					>
						<ClaySelect.Option
							label={this.parameter.getTrueLabel()}
							value="true"
						/>
						<ClaySelect.Option
							label={this.parameter.getFalseLabel()}
							value="false"
						/>
					</ClaySelect>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.RADIO && (
					<div
						className="form-group"
						style={{ display: "flex", marginBottom: "5px", paddingLeft: "10px" }}
					>
						<div style={{ display: "inline", marginBottom: "0", marginRight: "20px" }}>
							<ClayRadio
								label={this.parameter.getTrueLabel()}
								value={true}
								checked={this.state.value === true}
								disabled={this.parameter.disabled}
								onClick={(e) => this.handleRadioClick(true)}
								onChange={(e) => {
									e.stopPropagation();
									this.handleValueChange(true);
								}}
							/>
						</div>
						<div style={{ display: "inline", marginBottom: "0" }}>
							<ClayRadio
								label={this.parameter.getFalseLabel()}
								value={false}
								checked={this.state.value === false}
								disabled={this.parameter.disabled}
								onClick={(e) => this.handleRadioClick(false)}
								onChange={(e) => {
									e.stopPropagation();
									this.handleValueChange(false);
								}}
							/>
						</div>
					</div>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.TOGGLE && (
					<ClayToggle
						id={tagId}
						name={tagName}
						label={this.parameter.getTrueLabel()}
						onToggle={(e) => this.handleValueChange(!this.state.value)}
						spritemap={this.spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={this.state.value}
						disabled={this.parameter.disabled}
						sizing="md"
					/>
				)}
				{this.parameter.dirty &&
					(this.parameter.errorClass === ErrorClass.ERROR ||
						this.parameter.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</div>
		);
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		const tagId = this.parameter.tagId;
		const tagName = tagId;

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.viewType === BooleanParameter.ViewTypes.CHECKBOX && (
					<ClayCheckbox
						id={tagId}
						name={tagName}
						aria-label={this.parameter.label}
						label={this.parameter.renderLabel({
							spritemap: this.spritemap,
							inputStatus: this.parameter.inputStatus,
							style: {
								paddingLeft: "0",
								fontSize: "0.875rem"
							}
						})}
						checked={this.state.value}
						onChange={(e) => this.handleValueChange(!this.state.value)}
						disabled={this.parameter.disabled}
						ref={this.focusRef}
					/>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.DROPDOWN && (
					<div ref={this.focusRef}>
						{this.parameter.renderLabel({
							spritemap: this.spritemap,
							inputStatus: this.parameter.inputStatus
						})}
						{this.parameter.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.parameter.getDefinition()}</pre>
							</div>
						)}
						<ClaySelect
							id={tagId}
							name={tagName}
							defaultValue={this.state.value}
							onSelect={(val) => this.handleValueChange(val)}
							disabled={this.parameter.disabled}
						>
							<ClaySelect.Option
								label={this.parameter.getTrueLabel()}
								value="true"
							/>
							<ClaySelect.Option
								label={this.parameter.getFalseLabel()}
								value="false"
							/>
						</ClaySelect>
					</div>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.RADIO && (
					<div ref={this.focusRef}>
						{this.parameter.renderLabel({
							spritemap: this.spritemap,
							inputStatus: this.parameter.inputStatus
						})}
						{this.parameter.showDefinition && (
							<div className="sx-param-definition">
								<pre>{this.parameter.definition}</pre>
							</div>
						)}
						<div
							className="form-group"
							style={{ display: "flex", marginBottom: "5px", paddingLeft: "10px" }}
						>
							<div style={{ display: "inline", marginBottom: "0", marginRight: "20px" }}>
								<ClayRadio
									label={this.parameter.getTrueLabel()}
									value={true}
									checked={this.state.value === true}
									disabled={this.parameter.disabled}
									onClick={(e) => this.handleRadioClick(true)}
									onChange={(e) => {
										e.stopPropagation();
										this.handleValueChange(true);
									}}
								/>
							</div>
							<div style={{ display: "inline", marginBottom: "0" }}>
								<ClayRadio
									label={this.parameter.getFalseLabel()}
									value={false}
									checked={this.state.value === false}
									disabled={this.parameter.disabled}
									onClick={(e) => this.handleRadioClick(false)}
									onChange={(e) => {
										e.stopPropagation();
										this.handleValueChange(false);
									}}
								/>
							</div>
						</div>
					</div>
				)}
				{this.parameter.viewType === BooleanParameter.ViewTypes.TOGGLE && (
					<ClayToggle
						id={tagId}
						name={tagName}
						label={this.parameter.renderLabel({
							spritemap: this.spritemap,
							inputStatus: this.parameter.inputStatus
						})}
						onToggle={(e) => this.handleValueChange(!this.state.value)}
						spritemap={this.spritemap}
						symbol={{
							off: "times",
							on: "check"
						}}
						toggled={this.state.value}
						disabled={this.parameter.disabled}
						sizing="md"
						ref={this.focusRef}
					/>
				)}
				{this.parameter.dirty &&
					(this.parameter.errorClass === ErrorClass.ERROR ||
						this.parameter.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else {
			return this.renderGridCell();
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

		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.parameter = props.parameter;
		this.cellIndex = props.cellIndex;

		this.selectedOptionChanged = false;

		this.state = {
			focus: false,
			value: this.parameter.getValue(this.cellIndex) ?? (this.parameter.isMultiple() ? [] : "")
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	setValue(value) {
		this.setState({ value: value });
		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	handleRadioClick(val) {
		if (this.state.value === val) {
			this.setValue("");
		}
	}

	handleValueChange(val) {
		let newValue = val;
		if (this.parameter.isMultiple()) {
			if (this.state.value.includes(val)) {
				newValue = this.state.value.filter((elem) => elem !== val);
			} else {
				newValue = [...this.state.value, val];
			}
		}

		this.setValue(newValue);
	}

	renderListBox(tagId, tagName) {
		return (
			<ClaySelectBox
				id={tagId}
				name={tagName}
				value={this.state.value ? this.state.value : []}
				items={this.parameter.options.map((option) => ({
					key: option.value,
					label: option.label[this.parameter.languageId],
					value: option.value
				}))}
				multiple
				disabled={this.parameter.disabled}
				onClick={(e) => {
					if (this.selectedOptionChanged) {
						this.selectedOptionChanged = false;
					} else if (this.state.value.includes(e.target.value)) {
						this.setValue(this.state.value.filter((value) => value !== e.target.value));
					}
				}}
				onSelectChange={(val) => {
					this.selectedOptionChanged = true;
					this.setValue(val);
				}}
				style={{ paddingLeft: "10px", marginBottom: "0px" }}
			/>
		);
	}

	renderCheckBoxGroup(tagId, tagName) {
		const optionRows = Util.convertArrayToRows(this.parameter.options, this.parameter.optionsPerRow);

		return (
			<div
				id={tagId}
				name={tagName}
				style={{ paddingLeft: "10px" }}
			>
				{this.parameter.optionsPerRow === 0 && (
					<div style={{ display: "flex", overflowX: "auto" }}>
						{optionRows.map((option) => (
							<div
								key={option.value}
								style={{
									display: "inline-block",
									flex: "0 0 auto",
									marginRight: "20px",
									padding: "5px"
								}}
							>
								<ClayCheckbox
									key={option.value}
									label={option.label[this.parameter.languageId]}
									checked={this.state.value.includes(option.value)}
									onChange={(e) => {
										e.stopPropagation();
										this.handleValueChange(option.value);
									}}
									disabled={this.parameter.disabled}
								/>
							</div>
						))}
					</div>
				)}

				{this.parameter.optionsPerRow === 1 &&
					optionRows.map((option) => (
						<ClayCheckbox
							key={option.value}
							label={option.label[this.parameter.languageId]}
							checked={this.state.value.includes(option.value)}
							onChange={(e) => {
								e.stopPropagation();
								this.handleValueChange(option.value);
							}}
							disabled={this.parameter.disabled}
						/>
					))}
				{this.parameter.optionsPerRow > 1 &&
					optionRows.map((row, rowIndex) => (
						<div
							key={rowIndex}
							style={{ display: "inline-flex", width: "100%" }}
						>
							{row.map((option) => {
								return (
									<div
										key={option.value}
										style={{
											display: "inline-block",
											width: 100 / this.parameter.optionsPerRow + "%"
										}}
									>
										<ClayCheckbox
											label={option.label[this.parameter.languageId]}
											checked={this.state.value.includes(option.value)}
											onChange={(e) => {
												e.stopPropagation();
												this.handleValueChange(option.value);
											}}
											disabled={this.parameter.disabled}
										/>
									</div>
								);
							})}
						</div>
					))}
			</div>
		);
	}

	renderRadioGroup(tagId, tagName) {
		const optionRows = Util.convertArrayToRows(this.parameter.options, this.parameter.optionsPerRow);
		console.log(
			"SXSelect.renderRadioGroup: ",
			optionRows,
			this.parameter.optionsPerRow,
			typeof this.parameter.optionsPerRow
		);
		return (
			<>
				{this.parameter.optionsPerRow === 0 && (
					<div style={{ display: "inline-flex", overflowX: "auto", width: "100%" }}>
						{optionRows.map((option) => (
							<div
								key={option.value}
								style={{
									display: "inline",
									width: "fit-content",
									marginRight: "20px",
									flex: "0 0 auto",
									padding: "5px"
								}}
							>
								<ClayRadio
									label={option.label[this.parameter.languageId]}
									value={option.value}
									checked={this.state.value === option.value}
									onClick={(e) => this.handleRadioClick(e.target.value)}
									onChange={(e) => {
										e.stopPropagation();
										this.handleValueChange(option.value);
									}}
									disabled={this.parameter.disabled}
								/>
							</div>
						))}
					</div>
				)}

				{this.parameter.optionsPerRow === 1 &&
					optionRows.map((option) => (
						<ClayRadio
							key={option.value}
							label={option.label[this.parameter.languageId]}
							value={option.value}
							checked={this.state.value === option.value}
							onClick={(e) => this.handleRadioClick(e.target.value)}
							onChange={(e) => {
								e.stopPropagation();
								this.handleValueChange(option.value);
							}}
							disabled={this.parameter.disabled}
						/>
					))}
				{this.parameter.optionsPerRow > 1 &&
					optionRows.map((row, index) => (
						<div
							key={index}
							style={{ display: "inline-flex", width: "100%" }}
						>
							{row.map((option) => (
								<div
									key={option.value}
									style={{
										display: "inline-block",
										width: 100 / this.parameter.optionsPerRow + "%"
									}}
								>
									<ClayRadio
										label={option.label[this.parameter.languageId]}
										value={option.value}
										checked={this.state.value === option.value}
										onClick={(e) => this.handleRadioClick(e.target.value)}
										onChange={(e) => {
											e.stopPropagation();
											this.handleValueChange(option.value);
										}}
										disabled={this.parameter.disabled}
									/>
								</div>
							))}
						</div>
					))}
			</>
		);
	}

	renderDropDown(tagId, tagName) {
		return (
			<ClaySelect
				key={this.parameter.key}
				id={tagId}
				name={tagName}
				value={this.state.value}
				disabled={this.parameter.disabled}
				onChange={(e) => {
					this.handleValueChange(e.target.value);
				}}
			>
				{this.parameter.options.map((option, index) => {
					return (
						<ClaySelect.Option
							key={index}
							label={option.label[this.parameter.languageId]}
							value={option.value}
						/>
					);
				})}
			</ClaySelect>
		);
	}

	renderGridCell() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");
		const tagId = this.parameter.getTagId(this.cellIndex);
		const tagName = this.parameter.tagName;

		return (
			<div style={{ ...this.style, ...this.parameter.style }}>
				{this.parameter.viewType === SelectParameter.ViewTypes.DROPDOWN && this.renderDropDown(tagId, tagName)}
				{this.parameter.viewType === SelectParameter.ViewTypes.RADIO && (
					<div style={{ width: "max-content" }}>{this.renderRadioGroup(tagId, tagName)}</div>
				)}
				{(this.parameter.viewType === SelectParameter.ViewTypes.CHECKBOX ||
					this.parameter.viewType === SelectParameter.ViewTypes.LISTBOX) && (
					<div style={{ width: "max-content" }}>{this.renderCheckBoxGroup(tagId, tagName)}</div>
				)}
				{this.parameter.dirty &&
					(this.parameter.errorClass === ErrorClass.ERROR ||
						this.parameter.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</div>
		);
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");
		const tagId = this.parameter.getTagId(this.cellIndex);
		const tagName = this.parameter.tagName;

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
				ref={this.focusRef}
			>
				{this.parameter.renderLabel({
					forHtml: tagId,
					inputStatus: this.parameter.inputStatus,
					spritemap: this.spritemap
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				<div
					id={tagId}
					name={tagName}
					style={{ paddingLeft: "10px" }}
				>
					{this.parameter.viewType === SelectParameter.ViewTypes.DROPDOWN &&
						this.renderDropDown(tagId, tagName)}
					{this.parameter.viewType === SelectParameter.ViewTypes.RADIO &&
						this.renderRadioGroup(tagId, tagName)}
					{this.parameter.viewType === SelectParameter.ViewTypes.CHECKBOX &&
						this.renderCheckBoxGroup(tagId, tagName)}
					{this.parameter.viewType === SelectParameter.ViewTypes.LISTBOX &&
						this.renderListBox(tagId, tagName)}
					{this.parameter.dirty &&
						(this.parameter.errorClass === ErrorClass.ERROR ||
							this.parameter.errorClass === ErrorClass.WARNING) && (
							<SXFormFieldFeedback
								content={this.parameter.errorMessage}
								spritemap={this.spritemap}
								symbol="exclamation-full"
							/>
						)}
				</div>
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
		} else {
			return <></>;
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

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";

		this.focusRef = createRef();

		this.state = {
			leftOptions: this.parameter.getLeftOptions(this.cellIndex),
			rightOptions: this.parameter.getRightOptions(this.cellIndex),
			leftSelected: [],
			rightSelected: []
		};
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
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

		this.parameter.setValue({ value: left, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged(this.cellIndex);
	}

	handleAddBtnClick(e) {
		const left = this.state.rightOptions.filter((item) => !this.state.rightSelected.includes(item.value));
		const leave = this.state.rightOptions.filter((item) => this.state.rightSelected.includes(item.value));

		this.setState({
			leftOptions: [...this.state.leftOptions, ...leave],
			rightOptions: left
		});

		this.parameter.setValue({
			value: [...this.state.leftOptions, ...leave],
			cellIndex: this.cellIndex,
			validate: true
		});

		this.parameter.fireValueChanged(this.cellIndex);
	}

	renderGridCell() {
		return <></>;
	}

	renderFormField() {
		return (
			<ClayForm.Group
				className={this.className}
				style={{ ...this.style, ...this.parameter.style }}
				ref={this.focusRef}
			>
				{this.parameter.renderLabel({
					forHtml: this.parameter.tagId,
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
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
							(this.parameter.dirty ? " " + this.parameter.errorClass : "")
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
						{this.parameter.dirty && this.parameter.hasError() && (
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

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
		} else {
			return <></>;
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

		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.parameter = props.parameter;
		this.viewType = props.viewType ?? props.parameter.viewType;
		this.cellIndex = props.cellIndex;

		this.state = {
			value: this.parameter.getValue(this.cellIndex),
			underConstruction: false
		};

		this.focusRef = React.createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	handleFileSelectionChanged(files) {
		let fileList = Util.isEmpty(this.state.value) ? [] : this.state.value.filter((fileInfo) => fileInfo.fileId > 0);

		for (let i = 0; i < files.length; i++) {
			const file = files[i];
			fileList.push({
				fileId: 0,
				name: file.name,
				size: file.size,
				type: file.type,
				file: file
			});
		}

		this.setState({ value: fileList });
		this.parameter.setValue({ value: fileList, cellIndex: this.cellIndex, validate: true });
		this.parameter.fireValueChanged(this.cellIndex);
	}

	valueToFiles() {
		const dataTransfer = new DataTransfer();

		let files = this.state.value
			.filter((fileItem) => {
				return fileItem.fileId === 0 && fileItem.name !== fileInfo.name;
			})
			.map((fileItem) => fileItem.file);

		files.forEach((file) => dataTransfer.items.add(file));

		this.focusRef.current.files = dataTransfer.files;
	}

	handleActionClick(action, fileInfo) {
		switch (action) {
			case "download":
			case "upload": {
				this.setState({ underConstruction: true });

				break;
			}
			case "delete": {
				const dataTransfer = new DataTransfer();

				let files = this.state.value
					.filter((fileItem) => {
						return fileItem.fileId === 0 && fileItem.name !== fileInfo.name;
					})
					.map((fileItem) => fileItem.file);

				files.forEach((file) => dataTransfer.items.add(file));

				this.focusRef.current.files = dataTransfer.files;

				this.handleFileSelectionChanged(files);

				break;
			}
		}
	}

	renderFileManager() {
		return (
			<>
				<ClayInput
					type="file"
					disabled={this.parameter.disabled}
					multiple={true}
					ref={this.focusRef}
					onChange={(e) => {
						this.handleFileSelectionChanged(e.target.files);
					}}
					style={{ paddingLeft: "10px" }}
				/>
				{Util.isNotEmpty(this.state.value) &&
					this.state.value.map((fileInfo) => (
						<div
							key={fileInfo.name}
							className="autofit-row autofit-row-center autofit-padded-no-gutters-x"
							style={{ fontSize: "0.725rem", paddingLeft: "10px" }}
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
			</>
		);
	}

	renderGridCell() {
		return <div style={{ ...this.parameter.style }}>{this.renderFileManager()}</div>;
	}

	renderFormField() {
		return (
			<div
				className=""
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				{this.renderFileManager()}
			</div>
		);
	}

	renderUnderConstruction() {
		return (
			<>
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

	render() {
		const className = this.className + (this.dirty ? " " + this.parameter.errorClass : "");

		const tagId = this.parameter.tagId;
		const tagName = tagId;

		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return (
				<>
					{this.renderFormField()}
					{this.renderUnderConstruction()}
				</>
			);
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return (
				<>
					{this.renderGridCell()}
					{this.renderUnderConstruction()}
				</>
			);
		} else {
			return <>{this.renderUnderConstruction()}</>;
		}
	}
}

/*09. Address */
export class SXAddress extends React.Component {
	constructor(props) {
		super(props);

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		this.focusRef = createRef();

		const value = this.parameter.getValue(this.cellIndex);
		this.state = {
			zipcode: value.zipcode ?? "",
			street: value.street ?? "",
			address: value.address ?? "",
			searched: false,
			underConstruction: this.parameter.viewType === AddressParameter.ViewTypes.ONE_LINE ? true : false
		};
	}

	get fullAddress() {
		return this.state.zipcode + ", " + this.state.street + ", " + this.state.address;
	}

	get address() {
		const address = this.fullAddress.replace(this.state.zipcode + ", " + this.state.street + ",", "");

		return address.trim();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	handleAddressSearch() {
		new daum.Postcode({
			width: 500,
			height: 600,
			oncomplete: (data) => {
				const street =
					data.userSelectionType === "R"
						? this.languageId === "ko-KR"
							? data.address
							: data.addressEnglish
						: this.languageId === "ko-KR"
						? data.roadAddres
						: data.roadAddressEnglish;

				this.setState({ zipcode: data.zonecode, street: street, address: "", searched: true });
			}
		}).open();
	}

	handleAddressChanged(address) {
		this.setState({ address: address });

		this.parameter.setValue({
			value: {
				zipcode: this.state.zipcode,
				street: this.state.street,
				address: address
			},
			cellIndex: this.cellIndex,
			validate: true
		});

		this.parameter.fireValueChanged(this.cellIndex);
	}

	renderOneLineUI() {
		return (
			<>
				{this.state.searched ? (
					<ClayInput.Group>
						<ClayInput.GroupItem expand="true">
							<ClayInput
								style={{ minWidth: "5rem", width: "max-content" }}
								value={this.state.zipcode + ", " + this.state.street + ", " + this.state.address}
								disabled={this.parameter.disabled}
								onChange={(e) => {
									const value = e.target.value.replace(
										this.state.zipcode + ", " + this.state.street + ", ",
										""
									);

									this.handleAddressChanged(value);
								}}
								ref={this.focusRef}
							/>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem shrink>
							<Button
								onClick={(e) => this.handleAddressSearch()}
								size="sm"
								disabled={this.parameter.disabled}
							>
								<span className="inline-item inline-item-before">
									<Icon
										symbol="search"
										spritemap={this.spritemap}
									/>
								</span>
							</Button>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				) : (
					<ClayInput.Group style={{ justifyContent: "center" }}>
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
								{Util.translate("search")}
							</Button>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				)}
			</>
		);
	}

	renderGridCell() {
		return <div style={{ ...this.style, ...this.parameter.style }}>{this.renderOneLineUI()}</div>;
	}

	renderFormField() {
		const tagId = this.parameter.tagId;
		const tagName = tagId;

		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				{this.parameter.viewType === AddressParameter.ViewTypes.ONE_LINE && this.renderOneLineUI()}
				{this.parameter.viewType === AddressParameter.ViewTypes.INLINE && (
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
								disabled={this.parameter.disabled}
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
								disabled={true}
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
								disabled={true}
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
								disabled={!this.state.searched}
								onChange={(e) => this.handleAddressChanged(e.target.value)}
								ref={this.focusRef}
							/>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				)}
				{this.parameter.viewType === AddressParameter.ViewTypes.BLOCK && (
					<div style={{ marginLeft: "10px" }}>
						<div style={{ display: "block" }}>
							<span>{this.state.zipcode}</span>
							<ClayButtonWithIcon
								aria-label={Util.translate("search-address")}
								symbol="search"
								onClick={(e) => this.handleAddressSearch()}
								size="sm"
								spritemap={this.spritemap}
								disabled={this.parameter.disabled}
								className="float-right"
							/>
						</div>
						<div style={{ display: "block", marginTop: "10px", marginBottom: "10px" }}>
							{this.state.street}
						</div>
						<ClayInput
							value={this.state.address}
							placeholder={Util.translate("detail-address")}
							disabled={!this.state.searched}
							autoFocus={true}
							onChange={(e) => this.handleAddressChanged(e.target.value)}
							ref={this.focusRef}
						/>
					</div>
				)}
				{this.parameter.dirty &&
					(this.parameter.errorClass === ErrorClass.ERROR ||
						this.parameter.errorClass === ErrorClass.WARNING) && (
						<SXFormFieldFeedback
							content={this.parameter.errorMessage}
							spritemap={this.spritemap}
							symbol="exclamation-full"
						/>
					)}
			</div>
		);
	}

	render() {
		return (
			<>
				{this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD && this.renderFormField()}
				{this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL && this.renderGridCell()}
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

/*10. Date */
export class SXDate extends React.Component {
	constructor(props) {
		super(props);

		super(props);

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	handleDateChanged(value) {
		this.parameter.setValue({ value: value, cellIndex: this.cellIndex, validate: true });

		this.parameter.fireValueChanged();

		this.forceUpdate();
	}

	renderDatePicker() {
		return (
			<DatePicker
				onChange={(val) => this.handleDateChanged(val)}
				placeholder={this.parameter.enableTime ? "YYYY-MM-DD HH:mm" : "YYYY-MM-DD"}
				time={this.parameter.enableTime}
				value={this.parameter.getValue(this.cellIndex) ?? ""}
				disabled={this.parameter.disabled}
				years={{
					end: Number(this.parameter.endYear),
					start: Number(this.parameter.startYear)
				}}
				spritemap={this.spritemap}
			/>
		);
	}

	renderGridCell() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");
		return (
			<div style={{ ...this.style, ...this.parameter.style }}>
				<ClayForm.Group className={className}>{this.renderDatePicker()}</ClayForm.Group>
			</div>
		);
	}

	renderFormField() {
		const tagId = this.parameter.tagId;
		const tagName = tagId;

		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<div style={{ ...this.style, ...this.parameter.style }}>
				<ClayForm.Group className={className}>
					{this.parameter.renderLabel({
						spritemap: this.spritemap,
						inputStatus: this.parameter.inputStatus
					})}
					{this.parameter.showDefinition && (
						<div className="sx-param-definition">
							<pre>{this.parameter.getDefinition()}</pre>
						</div>
					)}
					<div style={{ paddingLeft: "10px" }}>{this.renderDatePicker()}</div>
				</ClayForm.Group>
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
		} else {
			return <></>;
		}
	}
}

/*11. Phone */
export class SXPhone extends React.Component {
	constructor(props) {
		super(props);

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		this.focusRef = createRef();

		this.state = {
			countryNo: this.parameter.enableCountryNo ? this.parameter.getCountryNo(this.cellIndex) : "",
			areaNo: this.parameter.getAreaNo(this.cellIndex) ?? "",
			stationNo: this.parameter.getStationNo(this.cellIndex) ?? "",
			personalNo: this.parameter.getPersonalNo(this.cellIndex) ?? ""
		};
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	checkFullNo() {
		return this.state.areaNo && this.state.stationNo && this.state.personalNo;
	}

	checkNo(val) {
		return /^\d+$/.test(val);
	}

	handleValueChanged(section, sectionValue) {
		this.parameter.dirty = true;

		if (!this.checkNo(sectionValue)) {
			this.parameter.error = {
				message: Util.translate("only-numbers"),
				errorClass: ErrorClass.ERROR
			};

			this.forceUpdate();

			return;
		}

		const newValue = { ...this.state };

		newValue[section] = sectionValue;

		this.setState(newValue);

		if (this.checkFullNo()) {
			this.parameter.setValue({ value: newValue, cellIndex: this.cellIndex, validate: true });
			this.parameter.fireValueChanged();
		}
	}

	renderClayUI() {
		const tagId = this.parameter.tagId;
		const tagName = this.parameter.tagName;

		return (
			<>
				<ClayInput.Group
					id={tagId}
					style={{ marginLeft: "10px" }}
				>
					{this.parameter.enableCountryNo && (
						<>
							<ClayInput.GroupItem shrink>
								<ClayInput
									value={this.state.countryNo}
									disabled={this.parameter.disabled}
									maxLength={6}
									style={{ maxWidth: "10ch" }}
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
							disabled={this.parameter.disabled}
							maxLength={4}
							onChange={(e) => this.handleValueChanged("areaNo", e.target.value)}
							style={{ maxWidth: "8ch" }}
							spritemap={this.spritemap}
							ref={this.focusRef}
						/>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<span style={{ alignContent: "center" }}>-</span>
					</ClayInput.GroupItem>
					<ClayInput.GroupItem shrink>
						<ClayInput
							value={this.state.stationNo}
							disabled={this.parameter.disabled}
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
							disabled={this.parameter.disabled}
							maxLength={4}
							style={{ maxWidth: "8ch" }}
							onChange={(e) => this.handleValueChanged("personalNo", e.target.value)}
							spritemap={this.spritemap}
						/>
					</ClayInput.GroupItem>
				</ClayInput.Group>
				{this.parameter.dirty && this.parameter.hasError(this.cellIndex) && (
					<SXFormFieldFeedback
						content={this.parameter.message}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</>
		);
	}

	renderFormField() {
		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				{this.renderClayUI()}
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else {
			return <></>;
		}
	}
}

/*12. EMail */
export class SXEMail extends React.Component {
	constructor(props) {
		super(props);

		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.cellIndex = props.cellIndex;

		this.focusRef = createRef();

		this.state = {
			emailId: this.parameter.getEmailId(this.cellIndex) ?? "",
			serverName: this.parameter.getServerName(this.cellIndex) ?? ""
		};
	}

	refreshHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.forceUpdate();
				return;
			}
		}
		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		if (this.parameter.isGridCell(this.cellIndex)) {
			if (dataPacket.cellIndex === this.cellIndex) {
				this.focusRef.current.focus();
				return;
			}
		}

		this.focusRef.current.focus();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
	}

	checkFullAddress() {
		return this.state.emailId && this.state.serverName;
	}

	fireValueChanged() {
		if (this.state.emailId && this.state.serverName) {
			this.parameter.setValue({
				value: { emailId: emailId, serverName: this.state.serverName },
				cellIndex: this.cellIndex,
				validate: true
			});
			this.parameter.fireValueChanged();
		}
	}

	handleEMailIdChanged(emailId) {
		this.setState({ emailId: emailId });

		if (!/^[A-Za-z]+[A-Za-z0-9_.]+$/.test(value)) {
			this.parameter.error = {
				message: Util.translate("invalid-email"),
				errorClass: ErrorClass.ERROR
			};

			return;
		}
	}

	handleServerChanged(server) {
		this.setState({ serverName: server });

		if (!/[a-z]+[.][a-z]+$/.test(value)) {
			this.parameter.error = {
				message: Util.translate("invalid-server-name"),
				errorClass: ErrorClass.ERROR
			};
		}
	}

	getClayUI() {
		const tagId = this.parameter.tagId;
		const tagName = tagId;

		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<ClayForm.Group className={className}>
				<ClayInput.Group>
					<ClayInput.GroupItem>
						<ClayInput
							value={this.state.emailId}
							disabled={this.parameter.disabled}
							placeholder={Util.translate("email-id")}
							onChange={(e) => this.handleEMailIdChanged(e.target.value)}
							onBlur={(e) => this.fireValueChanged()}
							spritemap={this.spritemap}
							ref={this.focusRef}
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
							disabled={this.parameter.disabled}
							onChange={(val) => this.handleServerChanged(val)}
							onBlur={(e) => this.fireValueChanged()}
							value={this.state.serverName}
						>
							{(item) => <Autocomplete.Item key={item}>{item}</Autocomplete.Item>}
						</Autocomplete>
					</ClayInput.GroupItem>
				</ClayInput.Group>
				{this.parameter.dirty && this.parameter.hasError() && (
					<SXFormFieldFeedback
						content={this.parameter.errorMessage}
						spritemap={this.spritemap}
						symbol="exclamation-full"
					/>
				)}
			</ClayForm.Group>
		);
	}

	renderGridCell() {
		return <div style={{ ...this.style, ...this.parameter.style }}>{this.getClayUI()}</div>;
	}

	renderFormField() {
		const tagId = this.parameter.tagId;
		const tagName = tagId;

		const className = this.className + (this.parameter.dirty ? " " + this.parameter.errorClass : "");

		return (
			<div
				className={className}
				style={{ ...this.style, ...this.parameter.style }}
			>
				{this.parameter.renderLabel({
					spritemap: this.spritemap,
					inputStatus: this.parameter.inputStatus
				})}
				{this.parameter.showDefinition && (
					<div className="sx-param-definition">
						<pre>{this.parameter.getDefinition()}</pre>
					</div>
				)}
				{this.getClayUI()}
			</div>
		);
	}

	render() {
		if (this.parameter.displayType === Parameter.DisplayTypes.FORM_FIELD) {
			return this.renderFormField();
		} else if (this.parameter.displayType === Parameter.DisplayTypes.GRID_CELL) {
			return this.renderGridCell();
		} else {
			return <></>;
		}
	}
}

/*13. Group */
export class SXGroup extends React.Component {
	constructor(props) {
		super(props);

		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.preview = props.preview ?? false;

		this.state = {
			expanded: this.parameter.expanded
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		this.focusRef.current.focus();
	};

	fieldValueChangedHandler = (event) => {
		const dataPacket = Event.pickUpDataPacket(
			event,
			this.parameter.namespace,
			this.parameter.tagName,
			this.parameter.paramName,
			this.parameter.paramVersion
		);

		if (Util.isEmpty(dataPacket)) {
			return;
		}

		this.parameter.fireValueChanged();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	renderMember(member) {
		member.inputStatus = this.parameter.inputStatus;
		member.position = this.parameter.getMemberPosition(member);

		return this.preview
			? member.renderPreview({
					dsbuilderId: this.dsbuilderId,
					propertyPanelId: this.propertyPanelId,
					previewCanvasId: this.previewCanvasId,
					spritemap: this.spritemap
			  })
			: member.render({
					spritemap: this.spritemap
			  });
	}

	renderArrangeMent() {
		const rows = Util.convertArrayToRows(this.parameter.members, this.parameter.membersPerRow);

		return (
			<div
				id={this.parameter.tagId}
				className={this.className}
				style={this.style}
				ref={this.focusRef}
			>
				{this.parameter.membersPerRow === 0 && (
					<div
						className=""
						style={{ display: "flex", overflowX: "auto" }}
					>
						{rows.map((field, index) => (
							<div
								key={index}
								style={{
									display: "inline-block",
									flex: "0 0 auto",
									marginRight: "20px",
									padding: "5px"
								}}
							>
								{this.renderMember(field)}
							</div>
						))}
					</div>
				)}
				{this.parameter.membersPerRow === 1 && rows.map((field) => this.renderMember(field))}
				{this.parameter.membersPerRow > 1 &&
					rows.map((row, rowIndex) => (
						<div
							key={rowIndex}
							className="autofit-row autofit-padded"
							style={{ marginBottom: "5px" }}
						>
							{row.map((field) => (
								<div
									key={field.key}
									className="autofit-col autofit-col-expand"
									style={{ marginBottom: "0" }}
								>
									{this.renderMember(field)}
								</div>
							))}
						</div>
					))}
			</div>
		);
	}

	renderPanel() {
		return (
			<Panel
				collapsable
				displayTitle={
					<Panel.Title>
						<div className="autofit-row autofit-row-center">
							<div className="autofit-col">
								<h3>{this.parameter.label}</h3>
							</div>
							<div className="autofit-col">
								{this.parameter.inputStatus && (
									<div className="autofit-section">
										<span>
											{"(" +
												this.parameter.valuedFieldsCount +
												"/" +
												this.parameter.totalFieldsCount +
												")"}
										</span>
									</div>
								)}
							</div>
						</div>
						{this.parameter.showDefinition && this.state.expanded && (
							<div
								className="autofit-row"
								style={{ paddingLeft: "10px" }}
							>
								<pre className="autofit-col">{this.parameter.getDefinition()}</pre>
							</div>
						)}
					</Panel.Title>
				}
				displayType="secondary"
				showCollapseIcon={true}
				defaultExpanded={this.state.expanded}
				onExpandedChange={(expanded) => {
					this.parameter.expanded = expanded;
					this.setState({ expanded: expanded });
				}}
				spritemap={this.spritemap}
				style={{
					...this.style,
					...this.parameter.style,
					backgroundColor: "rgba(123, 233, 78, 0.1)",
					marginBottom: "0"
				}}
			>
				<Panel.Body style={{ backgroundColor: "#ffffff" }}>{this.renderArrangeMent()}</Panel.Body>
			</Panel>
		);
	}

	renderTable() {
		return (
			<div
				style={{
					...this.style,
					...this.parameter.style
				}}
			>
				{this.parameter.renderLabel({ spritemap: this.spritemap })}
				<Table
					displayTitle={
						<Panel.Title>
							<div className="autofit-row autofit-row-center">
								<div className="autofit-col">
									<h3>{this.parameter.label}</h3>
								</div>
								<div className="autofit-col">
									{this.parameter.inputStatus && (
										<div className="autofit-section">
											<span>
												{"(" +
													this.parameter.valuedFieldsCount +
													"/" +
													this.parameter.totalFieldsCount +
													")"}
											</span>
										</div>
									)}
								</div>
							</div>
							{this.parameter.showDefinition && this.state.expanded && (
								<div
									className="autofit-row"
									style={{ paddingLeft: "10px" }}
								>
									<pre className="autofit-col">{this.parameter.getDefinition()}</pre>
								</div>
							)}
						</Panel.Title>
					}
					displayType="secondary"
					showCollapseIcon={true}
					defaultExpanded={this.state.expanded}
					onExpandedChange={(expanded) => this.setState({ expanded: expanded })}
					spritemap={this.spritemap}
					style={{
						...this.style,
						...this.parameter.style,
						backgroundColor: "rgba(123, 233, 78, 0.1)",
						marginBottom: "0"
					}}
				>
					<Panel.Body style={{ backgroundColor: "#ffffff" }}>{this.renderArrangeMent()}</Panel.Body>
				</Table>
			</div>
		);
	}

	render() {
		switch (this.parameter.viewType) {
			case GroupParameter.ViewTypes.ARRANGEMENT: {
				return this.renderArrangeMent();
			}
			case GroupParameter.ViewTypes.PANEL: {
				return this.renderPanel();
			}
			case GroupParameter.ViewTypes.TABLE: {
				return this.renderTable();
			}
			default: {
				return this.renderPanel();
			}
		}
	}
}

/*14. Grid */
export class SXGrid extends React.Component {
	constructor(props) {
		super(props);

		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.parameter = props.parameter;
		this.events = props.events ?? {};
		this.className = props.className ?? "";
		this.style = props.style ?? {};
		this.spritemap = props.spritemap ?? "";
		this.preview = props.preview ?? false;

		this.state = {
			activeDropdown: false,
			selectedRow: 0,
			selectedColumn: null
		};

		this.focusRef = createRef();
	}

	refreshHandler = (event) => {
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

		this.forceUpdate();
	};

	focusHandler = (event) => {
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

		this.focusRef.current.focus();
	};

	fieldValueChangedHandler = (event) => {
		const dataPacket = event.dataPacket;
		if (dataPacket.targetPortlet !== this.parameter.namespace || dataPacket.targetFormId !== this.parameter.tagName)
			return;

		console.log("SXGrid SX_FIELD_VALUE_CHANGED RECEIVED: ", dataPacket, this.parameter);

		const value = {};
		this.parameter.columns.map((column) => {
			value[column.paramName] = column.value;
		});
		this.parameter.setValue({ value: value });

		console.log("SXGrid value: ", this.parameter.hasValue());

		this.parameter.fireValueChanged();
		this.forceUpdate();
	};

	componentDidMount() {
		Event.on(Event.SX_REFRESH, this.refreshHandler);
		Event.on(Event.SX_FOCUS, this.focusHandler);
		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_REFRESH, this.refreshHandler);
		Event.detach(Event.SX_FOCUS, this.focusHandler);
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
	}

	handleRowActionClick(event, actionId, rowIndex) {
		switch (actionId) {
			case "insert": {
				this.parameter.insertRow(this.state.selectedRow + 1);
				break;
			}
			case "copy": {
				this.parameter.copyRow(this.state.selectedRow);
				break;
			}
			case "delete": {
				this.parameter.deleteRow(this.state.selectedRow);
				break;
			}
			case "up": {
				this.parameter.moveUpRow(this.state.selectedRow);
				break;
			}
			case "down": {
				this.parameter.moveDownRow(this.state.selectedRow);
				break;
			}
		}

		this.setState({
			activeDropdown: false
		});
	}

	handleColumnActionClick(e, actionId, colIndex) {
		switch (actionId) {
			case "left": {
				this.parameter.moveColumnLeft(colIndex);
				break;
			}
			case "right": {
				this.parameter.moveColumnRight(colIndex);
				break;
			}
			case "delete": {
				this.parameter.deleteColumn(colIndex);
				break;
			}
		}

		this.setState({ selectedColumn: colIndex });
	}

	getHeadItems() {
		return [
			{
				id: "rowIndex",
				name: "No.",
				textValue: "order",
				style: { maxWidth: "5rem" }
			},
			...this.parameter.columns.map((column) => {
				return {
					id: column.paramName,
					name: column.renderLabel({
						forHtml: column.paramName,
						inputStatus: this.parameter.inputStatus,
						spritemap: this.spritemap
					}),
					textValue: column.label,
					style: {
						width: column.style.width ?? "auto"
					},
					focus: column.focused
				};
			})
		];
	}

	getBodyRows() {
		let rows = [];
		let rowCount = this.parameter.rowCount;

		for (let rowIndex = 0; rowIndex <= rowCount; rowIndex++) {
			const actionItems = [
				{ id: "insert", name: Util.translate("insert"), symbol: "add-row" },
				{ id: "copy", name: Util.translate("copy"), symbol: "copy" },
				{ id: "delete", name: Util.translate("delete"), symbol: "times" }
			];

			if (rowIndex > 0) {
				actionItems.push({
					id: "up",
					name: Util.translate("move-up"),
					symbol: "caret-top"
				});
			} else if (rowIndex < rowCount) {
				actionItems.push({
					id: "down",
					name: Util.translate("move-down"),
					symbol: "caret-bottom"
				});
			}

			rows.push(
				<tr key={rowIndex}>
					<td>
						<DropDown
							active={this.state.activeDropdown && this.state.selectedRow === rowIndex}
							trigger={<div>{rowIndex + 1}</div>}
							onActiveChange={(val) => {
								this.setState({ activeDropdown: val, selectedRow: rowIndex });
							}}
							menuWidth="shrink"
						>
							<DropDown.ItemList items={actionItems}>
								{(actionItem) => (
									<DropDown.Item
										key={actionItem.id}
										onClick={(e) => this.handleRowActionClick(e, actionItem.id, rowIndex)}
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
					</td>
					{this.parameter.columns.map((column, colIndex) => (
						<td key={colIndex}>
							{column.render({
								spritemap: this.spritemap,
								inputStatus: this.parameter.inputStatus,
								cellIndex: rowIndex
							})}
						</td>
					))}
				</tr>
			);
		}

		return rows;
	}

	render() {
		return (
			<>
				{this.parameter.renderLabel({ spritemap: this.spritemap, inputStatus: this.parameter.inputStatus })}
				<div style={{ paddingLeft: "10px", overflowX: "auto", width: "100%" }}>
					<table
						className="sx-table"
						style={{ width: "100%" }}
					>
						<thead>
							<tr>
								{this.getHeadItems().map((column, index) => (
									<th
										key={column.id}
										style={column.style}
										onClick={(e) => {
											e.stopPropagation();
											console.log("head clicked: ", column);
											this.parameter.fireColumnSelected(column.id, this.dsbuilderId);
										}}
									>
										<div
											className={column.focus ? "sx-focused" : ""}
											style={{ display: "flex", alignItems: "center", justifyContent: "center" }}
										>
											{this.preview && index > 1 && (
												<ClayButtonWithIcon
													aria-labelledby={Util.translate("move-left")}
													symbol="caret-left"
													spritemap={this.spritemap}
													displayType="secondary"
													borderless="true"
													size="sm"
													onClick={(e) => {
														this.handleColumnActionClick(e, "left", index);
													}}
												/>
											)}
											<span style={{ textAlign: "center" }}>{column.name}</span>
											{this.preview && index > 0 && index < this.parameter.columnCount && (
												<ClayButtonWithIcon
													aria-labelledby={Util.translate("move-right")}
													symbol="caret-right"
													spritemap={this.spritemap}
													displayType="secondary"
													borderless="true"
													size="sm"
													onClick={(e) => {
														this.handleColumnActionClick(e, "right", index);
													}}
												/>
											)}
											{this.preview && index > 0 && (
												<ClayButtonWithIcon
													aria-labelledby={Util.translate("delete")}
													symbol="times"
													spritemap={this.spritemap}
													displayType="secondary"
													borderless="true"
													size="sm"
													onClick={(e) => {
														this.handleColumnActionClick(e, "delete", index);
													}}
												/>
											)}
										</div>
									</th>
								))}
							</tr>
						</thead>
						<tbody>{this.getBodyRows()}</tbody>
					</table>
				</div>
			</>
		);
	}
}

/*14. SelectGroup */
export const SXSelectGroup = () => {
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

class SXFormField extends React.Component {
	constructor(props) {
		super(props);
	}

	handleClick(e) {
		e.stopPropagation();

		if (!this.props.parameter.focused) {
			this.props.parameter.focused = true;

			this.props.parameter.fireParameterSelected(this.props.parameter.formId);

			this.forceUpdate();
		}
	}

	render() {
		return (
			<div
				style={{ marginBottom: "1.0rem" }}
				onClick={(e) => this.handleClick(e)}
			>
				{this.props.parameter.render({
					className: this.props.className,
					style: this.props.style,
					spritemap: this.props.spritemap,
					events: this.props.events,
					displayType: this.props.displayType,
					viewType: this.props.viewType,
					cellIndex: this.props.cellIndex
				})}
			</div>
		);
	}
}

export default SXFormField;
