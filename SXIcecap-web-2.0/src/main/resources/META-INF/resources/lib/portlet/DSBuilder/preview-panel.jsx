import React from "react";
import { Event } from "../../common/station-x";
import { DataStructure } from "./data-structure";
import { SXDataStatusBar } from "../../form/sxform";

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

	componentDidMount() {
		console.log("=== SXDataStructurePreviewer componentDidMount executed ===");
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.previewCanvasId)
				return;

			console.log(
				"SXDataStructurePreviewer SX_FIELD_VALUE_CHANGED RECEIVED: ",
				dataPacket,
				this.dataStructure,
				this.dataStructure.members
			);
		});

		Event.uniqueOn(Event.SX_MOVE_PARAMETER_UP, (e) => {
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
		});

		Event.uniqueOn(Event.SX_MOVE_PARAMETER_DOWN, (e) => {
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
		});

		Event.uniqueOn(Event.SX_REFRESH_FORM, (e) => {
			if (
				e.dataPacket.targetPortlet !== this.namespace ||
				e.dataPacket.targetFormId !== this.formIds.previewCanvasId
			) {
				return;
			}

			this.forceUpdate();
		});
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
