import React, { useState, useLayoutEffect, useContext, useRef, useCallback } from "react";

import {
	ActionKeys,
	LoadingStatus,
	PortletKeys,
	ResourceIds,
	WindowState,
	ViewTypes,
	DisplayType,
	DisplayStyles,
	Event,
	Constant
} from "../../stationx/station-x";
import { Util } from "../../stationx/util";
import { Context } from "@clayui/modal";
import { openConfirmModal, SXErrorModal, SXLoadingModal } from "../../stationx/modal";
import ClayManagementToolbar from "@clayui/management-toolbar";
import ClayPaginationBar, { ClayPaginationBarWithBasicItems } from "@clayui/pagination-bar";
import { Body, Cell, Head, Row, Table } from "@clayui/core";
import { ClayCheckbox, ClayInput } from "@clayui/form";
import { ClayDropDownWithItems } from "@clayui/drop-down";
import Button, { ClayButtonWithIcon } from "@clayui/button";
import { NotFound } from "../../stationx/common";
import Icon from "@clayui/icon";
import Toolbar from "@clayui/toolbar";
import SXSearchContainer from "../../stationx/search-container";
import { SXManagementToolbar, SXSearchResultConainer } from "../../stationx/search-container";
import { FilterOptions } from "../../stationx/search-container";
import SXActionDropdown from "../../stationx/dropdown";

class DataTypeExplorer extends React.Component {
	constructor(props) {
		super(props);

		console.log("DataTypeExplorer constructor: ", props);
		this.namespace = props.namespace;
		this.baseRenderURL = props.baseRenderURL;
		this.baseResourceURL = props.baseResourceURL;
		this.permissions = props.permissions;
		this.spritemap = props.spritemapPath;
		this.imagePath = props.imagePath;
		this.groupId = props.groupId;
		this.userId = props.userId;

		this.redirectURLs = props.redirectURLs;
		this.workbench = props.workbench;
		this.params = props.params;

		this.checkboxEnabled =
			this.permissions.includes(ActionKeys.UPDATE) || this.permissions.includes(ActionKeys.DELETE);

		this.displayStyles = [
			{
				name: "Table",
				id: "table",
				symbol: "table"
			},
			{
				name: "List",
				id: "list",
				symbol: "list"
			},
			{
				name: "Card",
				id: "card",
				symbol: "cards2"
			}
		];

		this.filterOptions = [
			{
				name: Util.translate("group"),
				id: "groupId"
			},
			{
				name: Util.translate("user"),
				id: "userId"
			},
			{
				name: Util.translate("mine"),
				id: "mine"
			},
			{
				name: Util.translate("status"),
				id: "status"
			}
		];

		this.actionButtons = [];
		if (this.checkboxEnabled) {
			this.actionButtons.push({
				id: "deleteSelected",
				name: Util.translate("delete-selected"),
				symbol: "trash"
			});
		}

		this.actionMenus = [];

		this.searchResults = [];
		this.selectedResults = [];

		this.state = {
			displayStyle: this.params.displayStyle ?? this.displayStyles[0].value, //table
			filterBy: this.params.filterBy ?? this.filterOptions[0], //groupId
			loadingStatus: LoadingStatus.PENDING,
			confirmDialog: false,
			errorMessage: "",
			progressDialog: false,
			start: this.params.start ?? 0,
			delta: this.params.delta ?? 10,
			keywords: this.params.keywords ?? "",
			searchContainerKey: Util.randomKey()
		};

		this.formId = this.namespace + "dataTypeExplorer";

		this.contentActionMenus = [];

		if (this.permissions.includes(ActionKeys.UPDATE)) {
			this.contentActionMenus.push({
				id: "update",
				name: Util.translate("update"),
				symbol: "pencil"
			});
			this.contentActionMenus.push({
				id: "delete",
				name: Util.translate("delete"),
				symbol: "trash"
			});
			this.contentActionMenus.push({
				id: "editStructure",
				name: Util.translate("edit-structure"),
				symbol: "edit-layout"
			});
		}

		this.contentActionMenus.push({
			name: Util.translate("advanced-search"),
			id: "advancedSearch",
			symbol: "search-experiences"
		});

		this.tableColumns = [
			{ id: "index", name: Util.translate("index"), width: "5rem" },
			{
				id: "id",
				name: Util.translate("id"),
				width: "8rem"
			},
			{
				id: "datatype",
				name: Util.translate("datatype"),
				width: "auto"
			},
			{
				id: "version",
				name: Util.translate("version"),
				width: "8rem"
			},
			{
				id: "datatype-code",
				name: Util.translate("datatype-code"),
				width: "15rem"
			},
			{
				id: "actions",
				name: "actions",
				width: "3.5rem"
			}
		];
		if (this.permissions.includes(ActionKeys.UPDATE)) {
			this.tableColumns.unshift({ id: "checkbox", name: "", width: "2.5rem" });
		}
	}

	/***************************************************
	 * Listeners for events from ManagementToolbar and SearchResultsContainer.
	 ****************************************************/
	listenerSelectAll = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerSelectAll event rejected: ", dataPacket);
			return;
		}

		console.log("listenerSelectAll: ", dataPacket);

		this.selectedResults = dataPacket.selectAll ? [...this.searchResults] : [];

		this.setState({ searchContainerKey: Util.randomKey() });
	};

	listenerSearchKeywordsChanged = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerSearchKeywordsChanged event rejected: ", dataPacket);
			return;
		}
		console.log("listenerSearchKeywordsChanged: ", dataPacket);

		this.setState({ keywords: dataPacket.keywords, loadingStatus: LoadingStatus.PENDING });

		// perform search here with ajax
	};

	listenerFilterMenuClicked = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerFilterMenuClicked event rejected: ", dataPacket);
			return;
		}
		console.log("listenerFilterMenuClicked: ", dataPacket);

		const isFilterMenu = this.filterOptions.map((option) => option.value).includes(dataPacket.menuItem.value);

		this.setState({ filterBy: dataPacket.menuItem.value });
	};

	listenerAdvancedSearchButtonClicked = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerAdvancedSearchButtonClicked event rejected: ", dataPacket);
			return;
		}
		console.log("listenerAdvancedSearchButtonClicked: ", dataPacket);
	};

	listenerPopActionClicked = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerPopActionClicked event rejected: ", dataPacket);
			return;
		}
		console.log("listenerPopActionClicked: ", dataPacket);

		const dataType = this.searchResults[dataPacket.data];

		switch (dataPacket.actionItem) {
			case "update": {
				Util.redirectTo(
					this.workbench.url,
					{
						namespace: this.workbench.namespace,
						portletId: this.workbench.portletId,
						windowState: WindowState.NORMAL
					},
					{
						workingPortletName: PortletKeys.DATATYPE_EDITOR,
						workingPortletParams: JSON.stringify({
							dataTypeId: dataType[0].value
						})
					}
				);
			}
		}
	};

	listenerAddButtonClicked = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerAddButtonClicked event rejected: ", dataPacket);
			return;
		}
		console.log("listenerAddButtonClicked: ", dataPacket);

		Util.redirectTo(
			this.workbench.url,
			{
				namespace: this.workbench.namespace,
				portletId: this.workbench.portletId,
				windowState: WindowState.NORMAL
			},
			{
				workingPortletName: PortletKeys.DATATYPE_EDITOR
			}
		);
	};

	listenerSelectedResultsChanged = (event) => {
		const dataPacket = event.dataPacket;

		if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formId) {
			console.log("listenerSelectedResultsChanged event rejected: ", dataPacket);
			return;
		}
		console.log("listenerSelectedResultsChanged: ", dataPacket);
		this.selectedResults = dataPacket.selectedResults;

		this.setState({ searchContainerKey: Util.randomKey() });
	};

	componentDidMount() {
		Event.on(Event.SX_SEARCH_KEYWORDS_CHANGED, this.listenerSearchKeywordsChanged);
		Event.on(Event.SX_FILTER_MENU_CLICKED, this.listenerFilterMenuClicked);
		Event.on(Event.SX_ADVANCED_SEARCH_BUTTON_CLICKED, this.listenerAdvancedSearchButtonClicked);
		Event.on(Event.SX_SELECT_ALL, this.listenerSelectAll);
		Event.on(Event.SX_POP_ACTION_CLICKED, this.listenerPopActionClicked);
		Event.on(Event.SX_SELECTED_RESULTS_CHANGED, this.listenerSelectedResultsChanged);
		Event.on(Event.SX_ADD_BUTTON_CLICKED, this.listenerAddButtonClicked);

		this.search();
	}

	componentWillUnmount() {
		Event.off(Event.SX_SEARCH_KEYWORDS_CHANGED, this.listenerSearchKeywordsChanged);
		Event.off(Event.SX_FILTER_MENU_CLICKED, this.listenerFilterMenuClicked);
		Event.off(Event.SX_ADVANCED_SEARCH_BUTTON_CLICKED, this.listenerAdvancedSearchButtonClicked);
		Event.off(Event.SX_SELECT_ALL, this.listenerSelectAll);
		Event.off(Event.SX_POP_ACTION_CLICKED, this.listenerPopActionClicked);
		Event.off(Event.SX_SELECTED_RESULTS_CHANGED, this.listenerSelectedResultsChanged);
		Event.off(Event.SX_ADD_BUTTON_CLICKED, this.listenerAddButtonClicked);
	}

	search() {
		Util.ajax({
			namespace: this.namespace,
			baseResourceURL: this.baseResourceURL,
			resourceId: ResourceIds.SEARCH_DATATYPES,
			params: {
				filterBy: this.state.filterBy,
				keywords: this.state.keywords,
				start: this.state.start,
				delta: this.state.delta
			},
			successFunc: (result) => {
				this.convertSearchResultsToContent(result);

				console.log("search results: ", result);
				this.setState({
					loadingStatus: LoadingStatus.COMPLETE,
					searchContainerKey: Util.randomKey()
				});
			},
			errorFunc: (e) => {
				this.setState({
					errorMessage: "Something wrong while searching data types",
					loadingStatus: LoadingStatus.FAIL
				});
			}
		});
	}

	convertSearchResultsToContent(results) {
		this.searchResults = results.map((dataType, index) => {
			let row = [
				{
					id: "dataTypeId",
					value: dataType.dataTypeId
				},
				{
					id: "displayName",
					value: dataType.displayName
				},
				{
					id: "dataTypeVersion",
					value: dataType.dataTypeVersion
				},
				{
					id: "dataTypeName",
					value: dataType.dataTypeName
				}
			];

			return row;
		});

		this.selectedResults = [];
	}

	checkAllResultsSelected() {
		return this.searchResults.length === this.selectedResults.length;
	}

	render() {
		console.log("DataTypeExplorer render: " + this.state.loadingStatus, this.state.keywords);
		if (this.state.loadingStatus === LoadingStatus.PENDING) {
			return <SXLoadingModal imageURL={this.imagePath + "/searching.gif"} />;
		} else if (this.state.loadingStatus === LoadingStatus.FAIL) {
			return <SXErrorModal imageURL={this.imagePath + "/ajax-error.gif"} />;
		} else {
			return (
				<div>
					<SXManagementToolbar
						key={this.checkAllResultsSelected()}
						namespace={this.namespace}
						formId={this.formId}
						searchBar={true}
						addButton={true}
						displayStyleOptions={this.displayStyles}
						displayStyle={this.state.displayStyle}
						filterOptions={this.filterOptions}
						filterBy={this.state.filterBy}
						actionButtons={this.actionButtons}
						actionMenus={this.actionMenus}
						checkbox={this.checkboxEnabled}
						checkboxChecked={this.checkAllResultsSelected()}
						start={this.state.start}
						delta={this.state.delta}
						keywords={this.state.keywords}
						spritemap={this.spritemap}
					/>
					<SXSearchResultConainer
						key={this.state.searchContainerKey}
						namespace={this.namespace}
						formId={this.formId}
						checkbox={this.checkboxEnabled}
						checkAll={this.checkAllResultsSelected()}
						index={true}
						columns={this.tableColumns}
						searchResults={this.searchResults}
						selectedResults={this.selectedResults}
						actionItems={this.contentActionMenus}
						spritemap={this.spritemap}
					/>
				</div>
			);
		}
	}
}

/*
const DataTypeExplorer = ({ portletParameters }) => {
	console.log("DataTypeExplorer: ", portletParameters);
	const { namespace, baseRenderURL, baseResourceURL, permissions, spritemapPath } = portletParameters;
	const {
		groupId,
		userId,
		keywords,
		start,
		delta,
		sortCol,
		sortType,
		viewType,
		workbenchURL,
		workbenchId,
		workbenchNamespace
	} = portletParameters.params;
	const [viewTypeState, setViewTypeState] = useState(viewType ?? ViewTypes.TABLE);
	const [checkAllState, setCheckAllState] = useState(false);
	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);
	const [confirmDialogState, dispatchConfirmDialog] = useContext(Context);

	const startRef = useRef(start);
	const deltaRef = useRef(delta);
	const sortTypeRef = useRef(sortType);
	const keywordsRef = useRef(keywords);
	const dataTypesRef = useRef([]);

	let dropdownItems = new Array();
	useLayoutEffect(() => {
		if (permissions.includes(ActionKeys.DELETE_DATATYPE)) {
			dropdownItems.push({
				label: Util.translate("delete"),
				symbol: "trach",
				onClick: deleteDataType
			});
		}
	}, []);

	useLayoutEffect(() => {
		console.log("DataTypeExplorer: useLayoutEffect[LoadingStatus] running...");

		if (loadingStatus !== LoadingStatus.PENDING) {
			return;
		}

		searchAction();
	}, [loadingStatus]);

	const getSelectedDataTypeIds = () => {
		return dataTypesRef.current.filter((dataType) => dataType.checked).map((selected) => selected.dataTypeId);
	};

	const searchAction = () => {
		Util.ajax({
			namesapce: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.LOAD_DATATYPES,
			type: "post",
			dataType: "json",
			params: {
				groupId,
				userId,
				keywords: keywordsRef.current,
				start: startRef.current,
				delta: deltaRef.current,
				sortCol,
				sortType: sortTypeRef.current
			},
			successFunc: (result) => {
				dataTypesRef.current = result.dataTypes.map((dataType) => {
					dataType.checked = false;
					dataType.id = dataType.dataTypeId;

					const permissions = dataType.permissions;
					console.log("DataType Permissions: " + dataType.dataTypeId + "-", permissions);
					let itemDropdownItems = new Array();
					if (permissions.includes("DELETE")) {
						itemDropdownItems.push({
							onClick: () => {
								deleteDataType(dataType.dataTypeId);
							},
							label: Util.translate("delete"),
							symbolLeft: "trash"
						});
					}
					if (permissions.includes("UPDATE")) {
						itemDropdownItems.push({
							onClick: () => {
								editDataType(dataType.dataTypeId);
							},
							label: Util.translate("edit"),
							symbolLeft: "pencil"
						});
						itemDropdownItems.push({
							onClick: () => {
								editDataStructure(dataType.dataTypeId);
							},
							label: Util.translate("edit-data-structure"),
							symbolLeft: "forms"
						});
					}

					dataType.dropdownItems = itemDropdownItems;

					return dataType;
				});

				setLoadingStatus(LoadingStatus.COMPLETE);
			},
			errorFunc: (e) => {
				console.log("Loading aata types failed: ", e);
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	};

	const handleDeltaChange = (newDelta) => {
		console.log("Changed Delta: " + newDelta);
		deltaRef.current = newDelta;

		setLoadingStatus(LoadingStatus.PENDING);
	};

	const handleDeleteSelectedAll = () => {
		const selectedDataTypes = getSelectedDataTypeIds();

		if (selectedDataTypes.length === 0) {
			console.log("No selected data types.");
			return;
		}

		const data = {
			dataTypeIds: selectedDataTypes
		};

		console.log("baseResourceURL: " + baseResourceURL);

		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.DELETE_DATATYPES,
			type: "post",
			dataType: "json",
			params: data,
			successFunc: (result) => {
				if (result.deleted.length > 0) {
					setLoadingStatus(LoadingStatus.PENDING);
				}
			},
			errorFunc: (err) => {
				console.log(err);
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	};

	const handleItemClick = (dataTypeId) => {
		dataTypesRef.current = dataTypesRef.current.map((dataType) => {
			if (dataType.dataTypeId === dataTypeId) {
				dataType.checked = !dataType.checked;
			}

			return dataType;
		});

		let allItemsChecked = true;
		dataTypesRef.current.every((dataType) => {
			if (!dataType.checked) {
				allItemsChecked = false;
				return false;
			}

			return true;
		});

		if (checkAllState !== allItemsChecked) {
			setCheckAllState(allItemsChecked);
		}
	};

	const handleViewTypeChanged = (viewType) => {
		console.log("handleViewTypeChanged: " + viewTypeState + " to " + viewType);
		setViewTypeState(viewType);
	};

	const handleCheckAllChange = () => {
		dataTypesRef.current = dataTypesRef.current.map((dataType) => {
			dataType.checked = !checkAllState;

			return dataType;
		});

		setCheckAllState(!checkAllState);
	};

	const handleFilter = (filter) => {
		console.log("handleFilter: " + filter);
	};

	const deleteDataType = (dataTypeId) => {
		console.log("deleteDataType: " + dataTypeId);

		dispatchConfirmDialog(
			openConfirmModal({
				title: Util.translate("warning"),
				modalType: "warning",
				content: Util.translate("if-you-do-this-it-will-be-never-recovered"),
				buttons: [
					{
						label: Util.translate("confirm"),
						onClick: (e) => {
							Util.ajax({
								namespace: namespace,
								baseResourceURL: baseResourceURL,
								resourceId: ResourceIds.DELETE_DATATYPE,
								type: "post",
								dataType: "json",
								params: {
									dataTypeId: dataTypeId
								},
								successFunc: (result) => {
									console.log("Ajax deleteDataType success: ", result);
									setLoadingStatus(LoadingStatus.PENDING);
								},
								errorFunc: (err) => {
									console.log("Ajax deleteDataType failed: ", err);
								}
							});
							confirmDialogState.onClose(e);
						}
					},
					{
						label: Util.translate("cancel"),
						onClick: confirmDialogState.onClose
					}
				],
				size: "sm",
				spritemap: portletParameters.spritemapPath
			})
		);
	};

	const editDataType = (dataTypeId) => {
		Util.redirectTo(
			workbenchURL,
			{
				namespace: workbenchNamespace,
				portletId: workbenchId,
				windowState: WindowState.NORMAL
			},
			{
				workingPortletName: PortletKeys.DATATYPE_EDITOR,
				params: JSON.stringify({
					dataTypeId: dataTypeId
				})
			}
		);
	};

	const editDataStructure = (dataTypeId) => {
		Util.redirectTo(
			workbenchURL,
			{
				namespace: workbenchNamespace,
				portletId: workbenchId,
				windowState: WindowState.NORMAL
			},
			{
				workingPortletName: PortletKeys.DATA_STRUCTURE_BUILDER,
				params: JSON.stringify({
					dataTypeId: dataTypeId
				})
			}
		);
	};

	let dataTable;
	if (loadingStatus === LoadingStatus.PENDING) {
		return <h2>Loading.......</h2>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h2>Loading Data types Failed....</h2>;
	}

	if (dataTypesRef.current.length === 0) {
		dataTable = <NotFound message={Util.translate("datatypes-were-not-found")}></NotFound>;
	} else if (viewTypeState === ViewTypes.TABLE) {
		const columns = [
			{
				id: namespace + "checkAll",
				type: "checkbox",
				label: "Check All",
				sortable: false,
				width: "50px"
			},
			{
				id: namespace + "id",
				type: "text",
				label: "ID",
				sortable: true,
				property: "dataTypeId",
				width: "20%"
			},
			{
				id: namespace + "displayName",
				sortable: false,
				type: "text",
				label: "Display Name",
				property: "displayName",
				width: "auto"
			},
			{
				id: namespace + "name",
				sortable: false,
				type: "text",
				label: "Name",
				property: "dataTypeName",
				width: "20%"
			},
			{
				id: namespace + "version",
				sortable: false,
				type: "text",
				label: "Version",
				property: "dataTypeVersion",
				width: "20%"
			},
			{
				id: namespace + "actions",
				sortable: false,
				type: "action",
				label: "Actions",
				width: "100px"
			}
		];

		dataTable = (
			<Table columnsVisibility={false}>
				<Head items={columns}>
					{(column, index) => {
						if (column.type === "checkbox") {
							return (
								<Cell
									key={column.id}
									textValue="checkAll"
									width={column.width}
								>
									<ClayCheckbox
										id={column.id}
										checked={checkAllState}
										onChange={() => {
											handleCheckAllChange();
										}}
									/>
								</Cell>
							);
						} else {
							return (
								<Cell
									key={column.id}
									width={column.width}
								>
									{column.label}
								</Cell>
							);
						}
					}}
				</Head>
				<Body defaultItems={dataTypesRef.current}>
					{(row, index) => {
						console.log("Explorer row: ", row);
						return (
							<Row key={row.id}>
								{columns.map((column, index) => {
									if (column.type === "checkbox") {
										return (
											<Cell key={index}>
												<ClayCheckbox
													id={row.id}
													checked={row.checked}
													onChange={() => {
														handleItemClick(row.dataTypeId);
													}}
												/>
											</Cell>
										);
									} else if (column.type === "action") {
										return (
											<Cell key={index}>
												<ClayDropDownWithItems
													items={row.dropdownItems.map((item) => {
														return {
															label: item.label,
															icon: item.symbol,
															onClick: () => {
																item.onClick(row.id);
															}
														};
													})}
													trigger={
														<ClayButtonWithIcon
															aria-label="Actions"
															title="Actions"
															displayType="unstyled"
															small
															spritemap={spritemapPath}
															symbol="ellipsis-v"
														/>
													}
												/>
											</Cell>
										);
									} else {
										return <Cell key={index}>{row[column.property]}</Cell>;
									}
								})}
							</Row>
						);
					}}
				</Body>
			</Table>
		);
	} else if (viewTypeState === ViewTypes.CARD) {
		dataTable = <></>;
	} else {
		dataTable = <></>;
	}

	let pagination;
	if (dataTypesRef.current.length > deltaRef.current) {
		pagination = (
			<ClayPaginationBarWithBasicItems
				defaultActive={1}
				activeDelta={deltaRef.current}
				deltas={[
					{
						label: 10
					},
					{
						label: 20
					},
					{
						label: 30
					},
					{
						label: 50
					}
				]}
				ellipsisBuffer={3}
				ellipsisProps={{ "aria-label": "More", title: "More" }}
				onDeltaChange={handleDeltaChange}
				spritemap={spritemapPath}
				totalItems={21}
			/>
		);
	}

	const filterItems = [
		{
			label: <h4>{Util.translate("site")}</h4>,
			onClick: () => {
				handleFilter("site");
			}
		},
		{
			label: <h4>{Util.translate("user")}</h4>,
			onClick: () => {
				handleFilter("user");
			}
		},
		{
			label: Util.translate("mine"),
			onClick: () => {
				handleFilter("mine");
			}
		}
	];

	const viewTypeItems = [
		{
			label: "List",
			onClick: () => handleViewTypeChanged(ViewTypes.LIST),
			symbolLeft: "list"
		},
		{
			active: true,
			label: "Table",
			onClick: () => handleViewTypeChanged(ViewTypes.TABLE),
			symbolLeft: "table"
		},
		{
			label: "Card",
			onClick: () => handleViewTypeChanged(ViewTypes.CARD),
			symbolLeft: "cards2"
		}
	];

	return (
		<>
			<ClayManagementToolbar>
				<ClayManagementToolbar.ItemList>
					<ClayManagementToolbar.Item>
						<ClayDropDownWithItems
							items={filterItems}
							spritemap={spritemapPath}
							trigger={
								<ClayButton
									className="nav-link"
									displayType="unstyled"
								>
									<span className="navbar-breakpoint-down-d-none">
										<span className="navbar-text-truncate">{"Filter and Order"}</span>
									</span>
									<span className="navbar-breakpoint-down-d-none">
										<ClayIcon
											spritemap={spritemapPath}
											symbol="caret-bottom"
										/>
									</span>
								</ClayButton>
							}
							triggerIcon="caret-bottom"
						/>
					</ClayManagementToolbar.Item>
				</ClayManagementToolbar.ItemList>
				<ClayManagementToolbar.Search>
					<ClayInput.Group>
						<ClayInput.GroupItem>
							<ClayInput
								aria-label="Search"
								className="form-control input-group-inset input-group-inset-after"
								defaultValue={keywordsRef.current}
								type="text"
								onBlur={(e) => {
									keywordsRef.current = e.target.value;

									setLoadingStatus(LoadingStatus.PENDING);
								}}
							/>
							<ClayInput.GroupInsetItem
								after
								tag="span"
							>
								<ClayButtonWithIcon
									aria-label="Close search"
									className="navbar-breakpoint-d-none"
									displayType="unstyled"
									onClick={searchAction}
									spritemap={spritemapPath}
									symbol="times"
								/>
								<ClayButtonWithIcon
									aria-label="Search"
									displayType="unstyled"
									spritemap={spritemapPath}
									symbol="search"
									onClick={() => {
										console.log("keywords: " + keywordsRef.current);
									}}
								/>
							</ClayInput.GroupInsetItem>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				</ClayManagementToolbar.Search>

				<ClayManagementToolbar.ItemList>
					{permissions.includes(ActionKeys.UPDATE_DATATYPE) ? (
						<ClayManagementToolbar.Item>
							<ClayButtonWithIcon
								aria-label={Util.translate("delete-selected")}
								className="nav-link nav-link-monospaced"
								displayType="unstyled"
								onClick={() => {
									handleDeleteSelectedAll();
								}}
								spritemap={spritemapPath}
								symbol="trash"
								title={Util.translate("delete-selected-datatypes")}
							/>
						</ClayManagementToolbar.Item>
					) : null}

					<ClayManagementToolbar.Item>
						<ClayDropDownWithItems
							items={viewTypeItems}
							spritemap={spritemapPath}
							trigger={
								<ClayButtonWithIcon
									aria-label={Util.translate("view-types")}
									className="nav-link"
									displayType="unstyled"
									spritemap={spritemapPath}
									symbol="display"
								/>
							}
						/>
					</ClayManagementToolbar.Item>
					{permissions.includes(ActionKeys.ADD_DATATYPE) ? (
						<ClayManagementToolbar.Item>
							<ClayButtonWithIcon
								aria-label="Add"
								monospaced={true}
								spritemap={spritemapPath}
								symbol="plus"
								title={Util.translate("new-datatype")}
								onClick={() => {
									Util.redirectTo(
										workbenchURL,
										{
											namespace: workbenchNamespace,
											portletId: workbenchId,
											windowState: WindowState.NORMAL
										},
										{
											workingPortletName: PortletKeys.DATATYPE_EDITOR
										}
									);
								}}
							/>
						</ClayManagementToolbar.Item>
					) : null}
				</ClayManagementToolbar.ItemList>
			</ClayManagementToolbar>
			{dataTable}
			{pagination}
		</>
	);
};
*/

export default DataTypeExplorer;
