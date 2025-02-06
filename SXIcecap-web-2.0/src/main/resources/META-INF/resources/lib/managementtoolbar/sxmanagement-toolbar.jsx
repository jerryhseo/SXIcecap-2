import React, { useState, useEffect, useContext, useRef } from "react";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import { ClayInput } from "@clayui/form";
import { ClayDropDownWithItems } from "@clayui/drop-down";
import ClayToolbar from "@clayui/toolbar";
import { DisplayStyle, PortletKeys } from "../common/station-x";
import { namespace, redirectTo, translate } from "../common/util";

const SXManagementToolbar = (props) => {
	const {
		searchBar, //
		newButton,
		displayStyles,
		actionButtons,
		dropdownItems,
		spritemap
	} = props;

	const keywords = useRef(searchBar.keywords);

	const newButtonItem = newButton ? (
		<ClayToolbar.Item>
			<ClayButtonWithIcon
				spritemap={spritemap}
				symbol={newButton.symbol}
				displayType="beta"
				onClick={newButton.onClick}
				title={newButton.label}
			/>
		</ClayToolbar.Item>
	) : undefined;

	const searchItem = searchBar ? (
		<ClayToolbar.Item expand>
			<ClayInput.Group>
				<ClayInput.GroupItem>
					<ClayInput
						className="form-control-inline"
						placeholder="search keywords"
						onBlur={(e) => (keywords.current = e.target.value)}
						type="text"
					/>
				</ClayInput.GroupItem>
				<ClayInput.GroupItem>
					<ClayButtonWithIcon
						aria-label={translate("search")}
						title={translate("search")}
						className="form-control-inline"
						displayType="secondary"
						onClick={searchBar.action(keywords.current)}
						small
						id={namespace(namespace, "dataTypeSearch")}
						spritemap={spritemap}
						symbol="search"
					/>
				</ClayInput.GroupItem>
			</ClayInput.Group>
		</ClayToolbar.Item>
	) : undefined;

	const actionButtonsItem = actionButtons ? (
		<ClayToolbar.Item>
			<ClayToolbar.Section>
				<ClayButton.Group>
					{actionButtons.map((button, index) => {
						return (
							<ClayButtonWithIcon
								key={index}
								aria-label={button.label}
								title={button.label}
								displayType="unstyled"
								onClick={button.onClick}
								small
								spritemap={spritemap}
								symbol={button.symbol}
							/>
						);
					})}
				</ClayButton.Group>
			</ClayToolbar.Section>
		</ClayToolbar.Item>
	) : undefined;

	const displayStylesItem = displayStyles ? (
		<ClayToolbar.Item>
			<ClayDropDownWithItems
				items={displayStyles.items.map((displayStyle) => {
					return {
						label: displayStyle,
						onClick: () => {
							displayStyles.onChange(displayStyle);
						}
					};
				})}
				trigger={
					<ClayButtonWithIcon
						aria-label="Display"
						title="Display"
						displayType="unstyled"
						small
						spritemap={spritemap}
						symbol="display"
					/>
				}
			/>
		</ClayToolbar.Item>
	) : undefined;

	const dropdownItem = dropdownItems ? (
		<ClayToolbar.Item>
			<ClayDropDownWithItems
				items={dropdownItems}
				trigger={
					<ClayButtonWithIcon
						aria-label="More Actions"
						title="More Actions"
						displayType="unstyled"
						small
						spritemap={spritemap}
						symbol="ellipsis-v"
					/>
				}
			/>
		</ClayToolbar.Item>
	) : undefined;

	return (
		<ClayToolbar>
			<ClayToolbar.Nav wrap={true}>
				{newButtonItem}
				{searchItem}
				{actionButtonsItem}
				{displayStylesItem}
				{dropdownItem}
			</ClayToolbar.Nav>
		</ClayToolbar>
	);
};

export default SXManagementToolbar;
