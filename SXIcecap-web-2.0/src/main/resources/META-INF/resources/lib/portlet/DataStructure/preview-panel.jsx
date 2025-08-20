import React from "react";
import { Event } from "../../stationx/station-x";
import { DataStructure } from "./data-structure";
import { SXDataStatusBar } from "../../stationx/form";

class SXDataStructurePreviewer extends React.Component {
	constructor(props) {
		super(props);

		this.dataStructure = props.dataStructure;
		this.namespace = props.dataStructure.namespace;
		this.formIds = props.formIds;
		this.languageId = props.dataStructure.languageId;
		this.availableLanguageIds = props.dataStructure.availableLanguageIds;
		this.spritemap = props.spritemap;
	}

	fieldValueChangedHandler = (e) => {
		const dataPacket = e.dataPacket;
		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.previewCanvasId)
			return;

		console.log(
			"SXDataStructurePreviewer SX_FIELD_VALUE_CHANGED RECEIVED: ",
			dataPacket,
			this.dataStructure,
			this.dataStructure.members
		);
	};

	moveParameterUpHandler = (e) => {
		if (
			e.dataPacket.targetPortlet !== this.namespace ||
			e.dataPacket.targetFormId !== this.formIds.previewCanvasId
		) {
			return;
		}

		const parameter = e.dataPacket.parameter;
		const group = this.dataStructure.findParameter({
			paramName: parameter.parentName,
			paramVersion: parameter.parentVersion,
			descendant: true
		});

		group.moveParameterUp(parameter.order);

		this.forceUpdate();
	};

	moveParameterDownHandler = (e) => {
		if (
			e.dataPacket.targetPortlet !== this.namespace ||
			e.dataPacket.targetFormId !== this.formIds.previewCanvasId
		) {
			return;
		}

		const parameter = e.dataPacket.parameter;
		const group = this.dataStructure.findParameter({
			paramName: parameter.parentName,
			paramVersion: parameter.parentVersion,
			descendant: true
		});

		group.moveParameterDown(parameter.order);

		this.forceUpdate();
	};

	refreshFormHandler = (e) => {
		if (
			e.dataPacket.targetPortlet !== this.namespace ||
			e.dataPacket.targetFormId !== this.formIds.previewCanvasId
		) {
			return;
		}

		this.forceUpdate();
	};

	componentDidMount() {
		console.log("=== SXDataStructurePreviewer componentDidMount executed ===");

		Event.on(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
		Event.on(Event.SX_MOVE_PARAMETER_UP, this.moveParameterUpHandler);
		Event.on(Event.SX_MOVE_PARAMETER_DOWN, this.moveParameterDownHandler);
		Event.on(Event.SX_REFRESH_FORM, this.refreshFormHandler);
	}

	componentWillUnmount() {
		Event.detach(Event.SX_FIELD_VALUE_CHANGED, this.fieldValueChangedHandler);
		Event.detach(Event.SX_MOVE_PARAMETER_UP, this.moveParameterUpHandler);
		Event.detach(Event.SX_MOVE_PARAMETER_DOWN, this.moveParameterDownHandler);
		Event.detach(Event.SX_REFRESH_FORM, this.refreshFormHandler);
	}

	render() {
		return (
			<>
				<SXDataStatusBar
					dataStructure={this.dataStructure}
					namespace={this.namespace}
					canvasId={this.formIds.previewCanvasId}
					spritemap={this.spritemap}
				/>
				<div style={{ maxHeight: "1000px", overflowY: "auto", overflowX: "hidden" }}>
					{this.dataStructure.renderPreview({
						dsbuilderId: this.formIds.dsbuilderId,
						propertyPanelId: this.formIds.propertyPanelId,
						previewCanvasId: this.formIds.previewCanvasId,
						spritemap: this.spritemap
					})}
				</div>
			</>
		);
	}
}

export default SXDataStructurePreviewer;
