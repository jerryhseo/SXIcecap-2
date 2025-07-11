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
		Event.on(Event.SX_FIELD_VALUE_CHANGED, (e) => {
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

		/*
		Event.on(Event.SX_FOCUS, (e) => {
			if (
				e.dataPacket.targetPortlet !== this.namespace ||
				e.dataPacket.targetFormId !== this.formIds.previewCanvasId
			) {
				return;
			}

			this.dataStructure.focusParameter(e.dataPacket.paramName, e.dataPacket.paramVersion);
		});
		*/

		Event.on(Event.SX_REFRESH_FORM, (e) => {
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
		console.log("SXDataStructurePreviewer render: ", this.dataStructure, this.formIds);
		return (
			<>
				<SXDataStatusBar
					key={this.dataStructure.key}
					dataStructure={this.dataStructure}
					namespace={this.namespace}
					formIds={this.formIds}
					spritemap={this.spritemap}
				/>
				{this.dataStructure.renderPreview({
					dsbuilderId: this.formIds.dsbuilderId,
					propertyPanelId: this.formIds.propertyPanelId,
					previewCanvasId: this.formIds.previewCanvasId,
					spritemap: this.spritemap
				})}
			</>
		);
	}
}

export default SXDataStructurePreviewer;
