import React from "react";
import ReactDOM from "react-dom";
import { createRoot } from "react-dom/client";
import DataCollectionExplorer from "./portlet/DataCollection/datacollection-explorer";
import DataCollectionEditor from "./portlet/DataCollection/datacollection-editor";
import DataCollectionViewer from "./portlet/DataCollection/datacollection-viewer";
import DataSetExplorer from "./portlet/DataSet/dataset-explorer";
import DataSetEditor from "./portlet/DataSet/dataset-editor";
import DataSetViewer from "./portlet/DataSet/dataset-viewer";
import DataTypeExplorer from "./portlet/DataType/datatype-explorer";
import DataTypeEditor from "./portlet/DataType/datatype-editor";
import DataTypeViewer from "./portlet/DataType/datatype-viewer";
import DataStructureBuilder from "./portlet/DataStructure/datastructure-builder";
import DataStructureExplorer from "./portlet/DataStructure/datastructure-explorer";
import DataStructureViewer from "./portlet/DataStructure/datastructure-viewer";
import ParameterExplorer from "./portlet/Parameter/parameter-explorer";
import ParameterEditor from "./portlet/Parameter/parameter-editor";
import ParameterViewer from "./portlet/Parameter/parameter-viewer";
import StructuredDataExplorer from "./portlet/StructuredData/structured-data-explorer";
import StructuredDataEditor from "./portlet/StructuredData/structured-data-editor";
import StructuredDataViewer from "./portlet/StructuredData/structured-data-viewer";
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
		case PortletKeys.DATACOLLECTION_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataCollectionExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATACOLLECTION_EDITOR: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataCollectionEditor {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATACOLLECTION_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataCollectionViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASET_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataSetExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASET_EDITOR: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataSetEditor {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASET_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataSetViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATATYPE_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataTypeExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATATYPE_EDITOR: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataTypeEditor {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATATYPE_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataTypeViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASTRUCTURE_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataStructureExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASTRUCTURE_BUILDER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataStructureBuilder {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.DATASTRUCTURE_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<DataStructureViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.PARAMETER_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<ParameterExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.PARAMETER_EDITOR: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<ParameterEditor {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.PARAMETER_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<ParameterViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_EXPLORER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<StructuredDataExplorer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_EDITOR: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<StructuredDataEditor {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
		case PortletKeys.STRUCTURED_DATA_VIEWER: {
			root.render(
				<ClayModalProvider spritemap={portletParameters.spritemapPath}>
					<StructuredDataViewer {...portletParameters} />
				</ClayModalProvider>
			);
			break;
		}
	}
}
