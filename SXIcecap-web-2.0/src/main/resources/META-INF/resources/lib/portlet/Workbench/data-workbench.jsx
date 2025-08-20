import React from "react";
import { WindowState, Workbench } from "../../stationx/station-x";

class DataWorkbench extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.redirectURLs = props.redirectURLs;
		this.workbench = props.workbench;
		this.workingPortlet = props.workingPortlet;
		this.params = props.params;

		this.workingPortletSectionId = this.namespace + "workingPortletSection";
	}

	componentDidMount() {
		/*
		Workbench.loadWorkingPortlet({
			portletSectionId: this.workingPortletSectionId,
			WindowState: WindowState.EXCLUSIVE,
			workingPortlet: this.workingPortlet,
			workbench: this.workbench
		});
		*/
	}

	render() {
		return <div id={this.workingPortletSectionId}></div>;
	}
}

export default DataWorkbench;
