import React, { useState, useEffect, useContext, useRef } from "react";
import SXManagementToolbar from "../managementtoolbar/sxmanagement-toolbar";
import SXTable from "../table/sxtable";
import SXPagination from "../pagination/sxpagination";

/**
 *
 *
 */
const SXSearchContainer = ({
	containerId,
	searchBar,
	newButton,
	actionButtons,
	displayStyleDropdownItems,
	displayStyle,
	dropdownItems,
	columns,
	items,
	onSelect,
	pagination,
	spritemap
}) => {
	const selectredItems = useRef([]);

	return (
		<div id={containerId}>
			<SXManagementToolbar
				searchBar={searchBar}
				newButten={newButton}
				displayStyles={displayStyleDropdownItems}
				actionButtons={actionButtons}
				dropdownItems={dropdownItems}
				spritemap={spritemap}
			></SXManagementToolbar>
			<SXTable
				columns={columns}
				items={items}
				onSelect={onSelect}
				displayStyle={displayStyle}
				spritemap={spritemap}
			></SXTable>
			<SXPagination
				start={pagination.start}
				delta={pagination.delta}
				totalCount={pagination.totalCount}
				onDeltaChange={pagination.onDeltaChange}
				spritemap={spritemap}
			/>
		</div>
	);
};

export default SXSearchContainer;
