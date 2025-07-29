import React, { createRef } from "react";
import { Event } from "../common/station-x";
import { ClayButtonWithIcon } from "@clayui/button";
import DropDown from "@clayui/drop-down";
import Icon from "@clayui/icon";

/**
 *
 */
class SXDropdown extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.items = props.items;
		this.formId = props.formId;
		this.symbol = props.symbol;
		this.spritemap = props.spritemap;
		this.targetData = props.targetData;

		this.state = {
			activeDropdown: props.activeDropdown ?? false
		};
	}

	handleActionClick(e, actionId) {
		e.stopPropagation();

		Event.fire(Event.SX_POP_ACTION_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			targetData: this.targetData,
			actionId: actionId
		});

		this.setState({ activeDropdown: false });
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

					Event.fire(Event.SX_POP_BUTTON_CLICKED, this.namespace, this.namespace, {
						targetFormId: this.formId,
						targetData: this.targetData,
						activeDropdown: val
					});
				}}
				menuWidth="shrink"
			>
				<DropDown.ItemList items={this.items}>
					{(actionItem) => (
						<DropDown.Item
							key={actionItem.id}
							onClick={(e) => this.handleActionClick(e, actionItem.id)}
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

export default SXDropdown;
