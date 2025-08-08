import React, { createRef } from "react";
import { Event } from "../common/station-x";
import { ClayButtonWithIcon } from "@clayui/button";
import DropDown from "@clayui/drop-down";
import Icon from "@clayui/icon";

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
		this.spritemap = props.spritemap;
		this.dataKey = props.dataKey;

		this.state = {
			activeDropdown: false
		};
	}

	render() {
		return (
			<DropDown
				active={this.state.activeDropdown}
				trigger={
					<ClayButtonWithIcon
						aria-label="Actions"
						symbol="ellipsis-v"
						title="Actions"
						borderless="true"
						className="btn-secondary"
						spritemap={this.spritemap}
					/>
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
							onClick={(e) => actionItem.action(this.dataKey)}
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
