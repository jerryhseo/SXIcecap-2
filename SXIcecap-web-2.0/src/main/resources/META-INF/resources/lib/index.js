import React, { createContext } from "react";
import { createRoot } from "react-dom/client";
import { ClayModalProvider } from "@clayui/modal";
import DataTypeExplorer from "./portlet/DTExplorer/datatype-explorer";
import DataStructureBuilder from "./portlet/DSBuilder/data-structure-builder";
import DataTypeEditor from "./portlet/DTEditor/datatype-editor";
import DataWorkbench from "./portlet/Workbench/data-workbench";

import { PortletKeys } from "./common/station-x";

export default function (elementId, portletName, portletParameters) {
	console.log("PortletName: " + portletName);
	const root = createRoot(document.getElementById(elementId));

	switch (portletName) {
		case PortletKeys.DATA_WORKBENCH: {
			root.render(<DataWorkbench portletParameters={portletParameters} />);
			break;
		}
		case PortletKeys.DATATYPE_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataTypeExplorer portletParameters={portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATATYPE_EDITOR: {
			root.render(<DataTypeEditor portletParameters={portletParameters} />);
			break;
		}
		case PortletKeys.DATATYPE_VIEWER: {
			root.render(<DataTypeViewer portletParameters={portletParameters} />);
			break;
		}
		case PortletKeys.DATA_STRUCTURE_BUILDER: {
			console.log("PortletKeys.DATA_STRUCTURE_BUILDER rendering");
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataStructureBuilder portletParameters={portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_EXPLORER: {
			root.render(<StructuredDataExplorer portletParameters={portletParameters} />);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_EDITOR: {
			root.render(<StructuredDataEditor portletParameters={portletParameters} />);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_VIEWER: {
			root.render(<StructuredDataViewer portletParameters={portletParameters} />);
			break;
		}
	}
}
