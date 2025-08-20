import React from "react";

import Button, { ClayButtonWithIcon } from "@clayui/button";
import { ClayCheckbox, ClayInput } from "@clayui/form";
import DropDown from "@clayui/drop-down";
import Toolbar from "@clayui/toolbar";
import { DisplayStyles, Event } from "./station-x";
import { Util } from "./util";
import SXActionDropdown from "./dropdown";
import Icon from "@clayui/icon";
import { NotFound } from "./common";
import { Body, Cell, Head, Row, Table } from "@clayui/core";

export const FilterOptions = {
	NONE: "none",
	GROUP_ID: "groupId",
	USER_ID: "userId",
	STATUS: "status"
};

export const GroupByOptions = {
	GROUP_ID: "groupId",
	USER_ID: "userId",
	COLLECTION_ID: "collectionId"
};

export class SXManagementToolbar extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.spritemap = props.spritemap;
		this.formId = props.formId;

		this.searchBar = props.searchBar ?? true;
		this.addButton = props.addButton ?? true;
		this.displayStyleOptions = props.displayStyleOptions ?? [];
		this.actionButtons = props.actionButtons ?? [];
		this.actionMenus = props.actionMenus ?? [];
		this.checkbox = props.checkbox ?? true;
		this.checkboxChecked = props.checkboxChecked ?? false;
		this.filterOptions = props.filterOptions ?? [];
		this.groupByOptions = props.groupByOptions ?? [];
		this.advancedSearch = props.advancedSearch ?? false;

		this.groupId = props.groupId;
		this.userId = props.userId;

		this.filterItems = [
			{
				name: Util.translate("filter"),
				id: "filterGroup",
				children: this.filterOptions
			}
		];

		if (this.groupByOptions.length > 0) {
			this.filterItems.push({
				name: Util.translate("group-by"),
				id: "groupByGroup",
				children: this.groupByOptions
			});
		}

		this.state = {
			selectAll: this.checkboxChecked,
			filterBy: props.groupId ?? FilterOptions.GROUP_ID,
			groupBy: props.groupId ?? GroupByOptions.COLLECTION_ID,
			keywords: props.keywords ?? {},
			start: props.start ?? 0,
			delta: props.delta ?? 10
		};
	}

	handleFilterMenuClick = (menuItem) => {
		Event.fire(Event.SX_FILTER_MENU_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			menuItem: menuItem
		});
	};

	handleActionButtonClick = (actionId) => {
		Event.fire(Event.SX_FILTER_MENU_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			action: actionId
		});
	};

	handleAddButtonClick = () => {
		Event.fire(Event.SX_ADD_BUTTON_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId
		});
	};

	handleSearchKeywordsChanged = (keywords) => {
		this.setState({ keywords: keywords });
	};

	handleSearchButtonClick = () => {
		Event.fire(Event.SX_SEARCH_KEYWORDS_CHANGED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			keywords: this.state.keywords
		});
	};

	handleAdvancedSearchButtonClicked = () => {
		Event.fire(Event.SX_ADVANCED_SEARCH_BUTTON_CLICKED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			keywords: this.state.keywords
		});
	};

	handleSelectAll = () => {
		Event.fire(Event.SX_SELECT_ALL, this.namespace, this.namespace, {
			targetFormId: this.formId,
			selectAll: !this.state.selectAll
		});

		this.setState({ selectAll: !this.state.selectAll });
	};

	renderFilterAndGroupBySection = () => {
		let triggerButtonTitle;

		if (this.filterOptions.length > 0 && this.groupByOptions.length > 0) {
			triggerButtonTitle = Util.translate("filter-and-groupby");
		} else if (this.filterOptions.length > 0) {
			triggerButtonTitle = Util.translate("filter");
		} else if (this.groupByOptions.length > 0) {
			triggerButtonTitle = Util.translate("groupby");
		}

		console.log(
			"renderFilterAndGroupBySection: ",
			triggerButtonTitle,
			this.filterOptions.length,
			this.groupByOptions.length > 0
		);

		return (
			<>
				{this.checkbox && (
					<Toolbar.Item>
						<ClayCheckbox
							aria-label={Util.translate("select-all")}
							checked={this.state.selectAll ?? false}
							onChange={() => this.handleSelectAll()}
						/>
					</Toolbar.Item>
				)}
				{!!triggerButtonTitle && (
					<Toolbar.Item>
						<DropDown
							filterKey="id"
							trigger={
								<Button
									aria-label={triggerButtonTitle}
									title={triggerButtonTitle}
									displayType="unstyled"
								>
									{triggerButtonTitle}
									<Icon
										symbol="caret-bottom"
										spritemap={this.spritemap}
									/>
								</Button>
							}
							menuWidth="shrink"
						>
							<DropDown.ItemList items={this.filterItems}>
								{(item) => (
									<DropDown.Group
										header={item.name}
										items={item.children}
										key={item.id}
									>
										{(item) => (
											<DropDown.Item
												key={item.id}
												onClick={() => this.handleFilterMenuClick(item)}
											>
												{item.name}
											</DropDown.Item>
										)}
									</DropDown.Group>
								)}
							</DropDown.ItemList>
						</DropDown>
					</Toolbar.Item>
				)}
			</>
		);
	};

	renderActionButtonSection = () => {
		return (
			<>
				{this.actionButtons.length > 0 && (
					<Toolbar.Item>
						<Button.Group>
							{this.actionButtons.map((button, index) => {
								return (
									<ClayButtonWithIcon
										key={index}
										aria-label={button.name}
										title={button.name}
										displayType="unstyled"
										onClick={(e) => this.handleAactionButtonClick(button.id)}
										spritemap={this.spritemap}
										symbol={button.symbol}
									/>
								);
							})}
							<SXActionDropdown
								namespace={this.namespace}
								formId={this.formId}
								spritemap={this.spritemap}
								actionItems={this.displayStyleOptions}
								triggerType="button"
								triggerTitle={Util.translate("display")}
								symbol="display"
							/>
							{this.actionMenus.length > 0 && (
								<SXActionDropdown
									namespace={this.namespace}
									formId={this.formId}
									actionItems={this.actionMenus}
									triggerType="button"
									spritemap={this.spritemap}
								/>
							)}
						</Button.Group>
					</Toolbar.Item>
				)}
			</>
		);
	};

	renderSearchbarSection = () => {
		return (
			<>
				{this.searchBar && (
					<Toolbar.Item expand>
						<ClayInput.Group>
							<ClayInput.GroupItem prepend>
								<ClayInput
									aria-label={Util.translate("search-keywords")}
									value={this.state.keywords}
									placeholder={Util.translate("search-keywords")}
									onChange={(e) => this.handleSearchKeywordsChanged(e.target.value)}
									type="text"
								/>
							</ClayInput.GroupItem>
							<ClayInput.GroupItem
								shrink
								append
							>
								<ClayButtonWithIcon
									aria-label={Util.translate("search")}
									title={Util.translate("search")}
									displayType="unstyled"
									onClick={this.handleSearchButtonClick}
									spritemap={this.spritemap}
									symbol="search"
									className="form-control"
								/>
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</Toolbar.Item>
				)}
			</>
		);
	};

	renderAddButtonSection = () => {
		return (
			<Toolbar.Item>
				<ClayButtonWithIcon
					aria-label={Util.translate("add")}
					spritemap={this.spritemap}
					symbol="plus"
					displayType="primary"
					onClick={this.handleAddButtonClick}
					title={Util.translate("add")}
				/>
			</Toolbar.Item>
		);
	};

	render() {
		return (
			<Toolbar>
				<Toolbar.Nav wrap={true}>
					{this.renderFilterAndGroupBySection()}
					{this.renderSearchbarSection()}
					{this.renderActionButtonSection()}
					{this.renderAddButtonSection()}
				</Toolbar.Nav>
			</Toolbar>
		);
	}
}

export class SXSearchResultConainer extends React.Component {
	constructor(props) {
		super(props);

		this.namespace = props.namespace;
		this.formId = props.formId;
		this.columns = props.columns ?? [];
		this.searchResults = props.searchResults ?? [];
		this.selectedResults = props.selectedResults ?? [];
		this.displayStyle = props.displayStyle ?? DisplayStyles.TABLE;
		this.checkbox = props.checkbox ?? true;
		this.checkAll = props.checkAll ?? false;
		this.index = props.index ?? true;
		this.actionItems = props.actionItems ?? [];
		this.spritemap = props.spritemap;

		this.rows = [];

		this.searchResults.forEach((result, index) => {
			let row = [];

			if (this.checkbox) {
				row.push({
					id: "checkbox",
					value: (
						<ClayCheckbox
							aria-label=""
							checked={this.checkAll || this.checkResultSelected(result)}
							onChange={(e) => {
								const checked = e.target.checked;

								if (checked) {
									this.addSelectedResult(result);
								} else {
									this.removeSelectedResult(result);
								}
							}}
						/>
					)
				});
			}

			if (this.index) {
				row.push({ id: "index", value: index + 1 });
			}

			row = [...row, ...result];

			row.push({
				id: "actions",
				value: (
					<SXActionDropdown
						namespace={this.namespace}
						formId={this.formId}
						actionItems={this.actionItems}
						dataKey={index}
						spritemap={this.spritemap}
					/>
				)
			});

			this.rows.push(row);
		});
	}

	checkResultSelected(result) {
		return this.selectedResults.includes(result);
	}

	addSelectedResult(result) {
		this.selectedResults.push(result);

		Event.fire(Event.SX_SELECTED_RESULTS_CHANGED, this.namespace, this.namespace, {
			targetFormId: this.formId,
			selectedResults: this.selectedResults
		});
	}

	removeSelectedResult(result) {
		let matchedIndex = this.selectedResults.indexOf(result);

		if (matchedIndex !== -1) {
			this.selectedResults.splice(matchedIndex, 1);

			Event.fire(Event.SX_SELECTED_RESULTS_CHANGED, this.namespace, this.namespace, {
				targetFormId: this.formId,
				selectedResults: this.selectedResults
			});
		}
	}

	renderTable() {
		return (
			<Table
				columnsVisibility={false}
				borderedColumns="true"
				size="sm"
				hover="true"
			>
				<Head items={this.columns}>
					{(column) => {
						if (column.id === "actions") {
							return (
								<Cell
									key={column.id}
									textValue="actions"
									textAlign="center"
									width={column.width}
								>
									<Icon
										symbol="ellipsis-v"
										spritemap={this.spritemap}
									/>
								</Cell>
							);
						} else {
							return (
								<Cell
									key={column.id}
									textAlign="center"
									width={column.width}
								>
									{column.name}
								</Cell>
							);
						}
					}}
				</Head>
				<Body defaultItems={this.rows}>
					{(row, index) => {
						return (
							<Row key={index}>
								{row.map((column) => (
									<Cell
										key={column.id}
										textAlign="center"
									>
										{column.value}
									</Cell>
								))}
							</Row>
						);
					}}
				</Body>
			</Table>
		);
	}

	renderNotFound() {}

	render() {
		if (this.searchResults.length < 1) {
			<NotFound message={Util.translate("no-datatype-found")} />;
		} else if (this.displayStyle === DisplayStyles.TABLE) {
			return this.renderTable();
		} else if (this.displayStyle === DisplayStyles.LIST) {
			return <></>;
		} else if (this.displayStyle === DisplayStyles.CARD) {
			return <></>;
		}
	}
}
