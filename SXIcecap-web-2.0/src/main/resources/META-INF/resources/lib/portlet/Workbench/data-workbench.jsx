import React, { useContext, useState, useEffect, useRef } from "react";
import { Util } from "../../common/util";
import { loadWorkingPortlet } from "./workbench-util";
import { WindowState } from "../../common/station-x";

const DataWorkbench = ({ portletParameters }) => {
	console.log("DataWorkbench: ", portletParameters);
	const { baseRenderURL, namespace, portletId } = portletParameters;
	const { workingPortletNamespace, workingPortletURL, workingPortletParams } = portletParameters.params;

	const workingPortletSectionId = Util.namespace(portletParameters.namespace, "portletParametersPortletCanvas");

	console.log("workingPortletParams: ", workingPortletParams);
	useEffect(() => {
		console.log("DataWorkbench: useEffect running....");
		loadWorkingPortlet({
			portletSectionId: workingPortletSectionId,
			baseURL: workingPortletURL,
			namespace: workingPortletNamespace,
			WindowState: WindowState.EXCLUSIVE,
			workbenchURL: baseRenderURL,
			workbenchNamespace: namespace,
			workbenchId: portletId,
			params: workingPortletParams
		});
	}, []);

	return (
		<div id={workingPortletSectionId}>
			<h3>Loading......</h3>
		</div>
	);
};

export default DataWorkbench;
