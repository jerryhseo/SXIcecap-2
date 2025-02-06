import React from "react";
import { WindowState } from "../../common/station-x";
import { Util } from "../../common/util";

export const loadWorkingPortlet = (args) => {
	const {
		portletSectionId, //
		baseURL,
		namespace,
		windowState,
		workbenchURL,
		workbenchNamespace,
		workbenchId,
		params
	} = args;

	AUI().use("aui-base, portlet-url", function (A) {
		console.log("loadWorkingPortlet: ", args, Liferay.PortletURL);
		let portletURL = Liferay.PortletURL.createURL(baseURL);

		//portletURL.setPortletId(portletId);
		portletURL.setWindowState(windowState ?? WindowState.EXCLUSIVE);

		portletURL.setParameter("workbenchURL", workbenchURL);
		portletURL.setParameter("workbenchNamespace", workbenchNamespace);
		portletURL.setParameter("workbenchId", workbenchId);

		for (const param in params) {
			portletURL.setParameter(param, params[param]);
		}

		console.log("portletURL: ", portletURL.toString());

		$.ajax({
			url: portletURL.toString(),
			type: "post",
			dataType: "text",
			success: (html) => {
				$("#" + portletSectionId).html(html);
			},
			error: (a) => {
				console.log(a);
			}
		});
	});
};
