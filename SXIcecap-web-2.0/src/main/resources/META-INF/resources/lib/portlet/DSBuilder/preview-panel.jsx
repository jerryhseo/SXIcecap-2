import React from "react";
import { Event } from "../../common/station-x";
import { DataStructure } from "./data-structure";
import { SXDataStatusBar } from "../../form/sxform";

class SXDataStructurePreviewer extends React.Component {
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

		this.state = {
			workingParamOrder: props.workingParamOrder,
			refresh: false
		};

		console.log("SXDataStructurePreviewer: ", props);

		Event.on(Event.SX_FOCUS, (e) => {
			console.log("SXDataStructurePreviewer SX_FOCUS: ", e.dataPacket);
			if (e.dataPacket.targetPortlet !== this.namespace || e.dataPacket.target !== this.previewCanvasId) {
				console.log("Not for SXDataStructurePreviewer: ", e.dataPacket, this.namespace, this.previewCanvasId);
				return;
			}

			this.dataStructure.focusParameter(e.dataPacket.paramName, e.dataPacket.paramVersion);
		});
	}

	render() {
		console.log("SXDataStructurePreviewer render: ", this.state.dataStructure);
		return (
			<>
				<SXDataStatusBar
					key={this.dataStructure.key}
					dataStructure={this.dataStructure}
					namespace={this.namespace}
					canvasId={this.previewCanvasId}
					spritemap={this.spritemap}
				/>
				{this.dataStructure.renderPreview(
					this.dsbuilderId,
					this.propertyPanelId,
					this.previewCanvasId,
					"",
					{},
					this.spritemap,
					this.state.workingParamOrder
				)}
			</>
		);
	}
}

export default SXDataStructurePreviewer;
