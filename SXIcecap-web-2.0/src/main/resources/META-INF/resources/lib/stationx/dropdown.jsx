import React, { createRef } from "react";
import { Event } from "./station-x";
import { ClayButtonWithIcon } from "@clayui/button";
import DropDown from "@clayui/drop-down";
import Icon from "@clayui/icon";
import { Util } from "./util";

/**
 *
 */
class SXActionDropdown extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.actionItems = props.actionItems;
		this.formId = props.formId;
		this.symbol = props.symbol;
		this.triggerType = props.triggerType ?? "icon";
		this.spritemap = props.spritemap;
		this.data = props.dataKey;
		this.triggerTitle = props.triggerTitle ?? Util.translate("actions");

		this.state = {
			activeDropdown: false
		};
	}

	handleActionClick = (actionItem) => {
		Event.fire(Event.SX_POP_ACTION_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			actionItem: actionItem.id,
			data: this.data
		});

		this.setState({ activeDropdown: false });
	};

	render() {
		/*
		<ClayButtonWithIcon
			aria-label={this.triggerTitle}
			symbol={this.symbol ?? "ellipsis-v"}
			title={this.triggerTitle}
			displayType="unstyled"
			className="btn-secondary"
			spritemap={this.spritemap}
		/>;
		*/
		return (
			<DropDown
				active={this.state.activeDropdown}
				trigger={
					this.triggerType === "icon" ? (
						<Icon
							aria-label={this.triggerTitle}
							symbol={this.symbol ?? "ellipsis-v"}
							title={this.triggerTitle}
							spritemap={this.spritemap}
						/>
					) : (
						<ClayButtonWithIcon
							aria-label={this.triggerTitle}
							symbol={this.symbol ?? "ellipsis-v"}
							title={this.triggerTitle}
							displayType="unstyled"
							className="btn-secondary"
							spritemap={this.spritemap}
						/>
					)
				}
				onActiveChange={(val) => {
					this.setState({ activeDropdown: val });
				}}
				menuWidth="shrink"
			>
				<DropDown.ItemList items={this.actionItems}>
					{(actionItem) => (
						<DropDown.Item
							key={actionItem.id}
							onClick={(e) => this.handleActionClick(actionItem)}
						>
							<Icon
								spritemap={this.spritemap}
								symbol={actionItem.symbol}
								style={{ marginRight: "5px" }}
							/>
							{actionItem.name}
						</DropDown.Item>
					)}
				</DropDown.ItemList>
			</DropDown>
		);
	}
}

export default SXActionDropdown;
