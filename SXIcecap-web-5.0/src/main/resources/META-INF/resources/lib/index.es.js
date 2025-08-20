import React from "react";
import { createRoot } from "react-dom/client";
import DataWorkbench from "./portlet/Workbench/data-workbench";

import { PortletKeys } from "./stationx/station-x";
import { ClayModalProvider } from "@clayui/modal";

export default function (elementId, portletId, portletParameters) {
	console.log("PortletName: " + portletId);
	const root = createRoot(document.getElementById(elementId));

	switch (portletId) {
		case PortletKeys.DATA_WORKBENCH: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataWorkbench {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
	}
}
