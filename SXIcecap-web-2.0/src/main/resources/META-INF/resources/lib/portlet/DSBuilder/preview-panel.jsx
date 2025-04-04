import React from "react";
import { Event } from "../../common/station-x";
import { DataStructure } from "./data-structure";

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

		this.state = {
			dataStructure: props.dataStructure,
			workingParamOrder: props.workingParamOrder
		};

		console.log("SXDataStructurePreviewer: ", props);
		/*
		Event.on(Event.SX_PARAMETERS_CHANGED, (e) => {
			console.log("SXDataStructurePreviewer SX_PARAMETERS_CHANGED: ", e.dataPacket);
			if (e.dataPacket.targetPortlet !== this.namespace || e.dataPacket.target !== this.previewCanvasId) {
				console.log("Not for SXDataStructurePreviewer: ", e.dataPacket, this.namespace, this.previewCanvasId);
				return;
			}

			this.setState({ dataStructure: new DataStructure(e.dataPacket.dataStructure) });
		});
		*/
	}

	render() {
		console.log("SXDataStructurePreviewer render: ", this.state.DataStructure);
		return (
			<>
				{this.state.dataStructure.renderPreview(
					this.namespace, //
					this.dsbuilderId,
					this.propertyPanelId,
					this.previewCanvasId,
					this.languageId,
					this.availableLanguageIds,
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
