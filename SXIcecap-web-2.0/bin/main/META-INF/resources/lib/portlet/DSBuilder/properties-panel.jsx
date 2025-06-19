import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import Form, { ClaySelectWithOption } from "@clayui/form";
import ClayMultiStepNav from "@clayui/multi-step-nav";
import SXDSBuilderBasicPropertiesPanel from "./basic-properties-panel";
import SXDSBuilderTypeSpecificPanel from "./type-specific-properties-panel";
import SXDSBuilderOptionPropertiesPanel from "./option-properties-panel";
import SXDSBuilderValidationPanel from "./validation-builder-panel";
import { Event, ParamProperty, ParamType } from "../../common/station-x";
import { SXLabel } from "../../form/sxform";

class SXDSBuilderPropertiesPanel extends React.Component {
	panelSteps = [
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
	];

	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.dsbuilderId = props.dsbuilderId;
		this.propertyPanelId = props.propertyPanelId;
		this.previewCanvasId = props.previewCanvasId;
		this.languageId = props.languageId;
		this.availableLanguageIds = props.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.dataStructure = props.dataStructure;
		this.workingParam = props.workingParam;

		this.state = {
			panelStep: 0
		};
	}

	componentDidMount() {}

	handlePanelStepChange(step) {
		this.setState({ panelStep: step });
	}

	handleParamTypeSelect(e) {
		Event.fire(Event.SX_PARAM_TYPE_CHANGED, this.namespace, this.namespace, {
			target: this.dsbuilderId,
			paramType: e.target.value
		});
	}

	renderPanelContent() {
		console.log("SXDSBuilderPropertiesPanel workingParam: ", this.workingParam);
		switch (this.state.panelStep) {
			case 0: {
				return (
					<SXDSBuilderBasicPropertiesPanel
						dsbuilderId={this.dsbuilderId}
						propertyPanelId={this.propertyPanelId}
						previewCanvasId={this.previewCanvasId}
						workingParam={this.workingParam}
						dataStructure={this.dataStructure}
						spritemap={this.spritemap}
					/>
				);
			}
			/*
			case 1: {
				return (
					<SXDSBuilderTypeSpecificPanel
						dsbuilderId={this.dsbuilderId}
						propertyPanelId={this.propertyPanelId}
						previewCanvasId={this.previewCanvasId}
						workingParam={this.workingParam}
						dataStructure={this.dataStructure}
						spritemap={this.spritemap}
					/>
				);
			}
			case 2: {
				return (
					<SXDSBuilderOptionPropertiesPanel
						dsbuilderId={this.dsbuilderId}
						propertyPanelId={this.propertyPanelId}
						previewCanvasId={this.previewCanvasId}
						workingParam={this.workingParam}
						dataStructure={this.dataStructure}
						spritemap={this.spritemap}
					/>
				);
			}
			case 3: {
				return (
					<SXDSBuilderValidationPanel
						dsbuilderId={this.dsbuilderId}
						propertyPanelId={this.propertyPanelId}
						previewCanvasId={this.previewCanvasId}
						workingParam={this.workingParam}
						dataStructure={this.dataStructure}
						spritemap={this.spritemap}
					/>
				);
			}
				*/
		}
	}

	render() {
		console.log("Render Parameter: ", this.state.parameter);

		return (
			<>
				<Form.Group className="form-group-sm">
					<SXLabel
						label={Util.translate("parameter-type")}
						forHtml={this.namespace + ParamProperty.PARAM_TYPE}
						required={true}
						tooltip={Util.translate("parameter-type-tooltip")}
						spritemap={this.spritemap}
						style={{ marginRight: "20px" }}
					/>
					<ClaySelectWithOption
						aria-label={Util.translate("parameter-type")}
						id={this.namespace + ParamProperty.PARAM_TYPE}
						options={Object.keys(ParamType).map((key) => ({
							label: ParamType[key],
							value: ParamType[key]
						}))}
						value={this.workingParam.paramType}
						onChange={(e) => {
							this.handleParamTypeSelect(e);
						}}
						disabled={this.workingParam.order > 0}
						spritemap={this.spritemap}
					/>
				</Form.Group>
				<ClayMultiStepNav>
					{this.panelSteps.map(({ subTitle, title }, i) => {
						let panelStep = this.state.panelStep < 0 ? 0 : this.state.panelStep;
						const complete = i < this.state.panelStep;

						return (
							<ClayMultiStepNav.Item
								active={panelStep === i}
								expand={i + 1 !== this.panelSteps.length}
								key={i}
								state={complete ? "complete" : undefined}
							>
								<ClayMultiStepNav.Title>{title}</ClayMultiStepNav.Title>
								<ClayMultiStepNav.Divider />
								<ClayMultiStepNav.Indicator
									complete={complete}
									label={i + 1}
									onClick={() => this.handlePanelStepChange(i)}
									subTitle={subTitle}
								/>
							</ClayMultiStepNav.Item>
						);
					})}
				</ClayMultiStepNav>
				{this.renderPanelContent()}
			</>
		);
	}
}

export default SXDSBuilderPropertiesPanel;
