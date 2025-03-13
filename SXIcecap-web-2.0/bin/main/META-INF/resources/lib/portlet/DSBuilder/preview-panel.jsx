import React, { useState, useLayoutEffect, useRef } from "react";
import { Event } from "../../common/station-x";
import { DataStructure } from "./data-structure";

const SXDataStructurePreviewer = ({
	namespace,
	dsbuilderId,
	propertyPanelId,
	previewCanvasId,
	languageId,
	availableLanguageIds,
	dataStructure,
	spritemap
}) => {
	const [render, forceRender] = useState(true);

	const [dataStructureState, setDataStructureState] = useState(dataStructure);

	useLayoutEffect(() => {
		Event.on(Event.SX_PARAMETERS_CHANGED, (e) => {
			console.log("SXDataStructurePreviewer SX_PARAMETERS_CHANGED: ", e.dataPacket);
			if (e.dataPacket.targetPortlet !== namespace || e.dataPacket.target !== previewCanvasId) {
				console.log("Not for SXDataStructurePreviewer: ", e.dataPacket, namespace, previewCanvasId);
				return;
			}

			setDataStructureState(new DataStructure(e.dataPacket.dataStructure));
		});
	}, []);

	return (
		<>
			{dataStructureState.renderPreview(
				namespace, //
				dsbuilderId,
				propertyPanelId,
				previewCanvasId,
				languageId,
				availableLanguageIds,
				"",
				{},
				spritemap
			)}
		</>
	);
};

export default SXDataStructurePreviewer;
