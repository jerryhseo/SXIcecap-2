import React, { useState, useEffect, useRef, useLayoutEffect, useContext } from "react";
import { ClayCheckbox } from "@clayui/form";
import { Table, Head, Body, Row, Cell } from "@clayui/core";
import { NotFound } from "../../common/common";
import { DisplayStyle, Event, LoadingStatus, ResourceIds } from "../../common/station-x";
import { namespace, redirectTo, ajax, translate } from "../../common/util";
import { SXButtonWithIcon } from "../../form/sxform";
import ClayIcon from "@clayui/icon";
import ClayButton, { ClayButtonWithIcon } from "@clayui/button";
import { ClayDropDownWithItems } from "@clayui/drop-down";
import { Context } from "@clayui/modal";
import { PortletKeys } from "../../common/station-x";

const DataTypeListTable = ({ portletParameters, searchContainerId }) => {
	const [displayStyle, setDisplayStyle] = useState(portletParameters.params.displayStyle);
	const [checkAll, setCheckAll] = useState(false);
	const dataTypes = useRef([]);
	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);
	const [confirmDialogState, dispatchConfirmDialog] = useContext(Context);
 
	useLayoutEffect(() => {
		Event.on(Event.SX_DISPLAY_STYLE_CHANGED, (e) => {
			if (
				!Event.validateMine(e.dataPacket, {
					namespace: portletParameters.namespace,
					containerId: searchContainerId,
				})
			) {
				return;
			}

			console.log("changeDisplayStyle");

			setDisplayStyle(e.dataPacket.displayStyle);
		});
	}, []);

	useEffect(() => {
		if (loadingStatus !== LoadingStatus.PENDING) {
			return;
		}

		AUI().use("aui-base, portlet-url", function (A) {
			let loadDataTypesURL = Liferay.PortletURL.createURL(portletParameters.baseResourceURL);
			loadDataTypesURL.setPortletId(portletParameters.portletId);
			loadDataTypesURL.setResourceId(ResourceIds.LOAD_DATATYPES);

			console.log("......loadDataTypesURL: " + loadDataTypesURL.toString());

			const fetchData = async () => {
				try {
					const response = await fetch(loadDataTypesURL.toString());
					const result = await response.json();
					console.log("dataTypes: ", result);
					/*
                            const data = [
                                { checked: false, files: 22, id: 1, name: "Games", type: "File folder" },
                                { checked: false, files: 7, id: 2, name: "Program Files", type: "File folder" }
                            ];
                            */

					dataTypes.current = result.dataTypes.map((dataType) => {
						dataType.checked = false;
						return dataType;
					});

					setLoadingStatus(LoadingStatus.COMPLETE);
				} catch (error) {
					console.log(error);
					setLoadingStatus(LoadingStatus.FAIL);
				}
			};

			fetchData();
		});
	}, [loadingStatus]);

	if (loadingStatus === LoadingStatus.PENDING) {
		return <h1>Loading......</h1>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h1>Error While Loading the Page...</h1>;
	}

	if (dataTypes.current.length === 0) {
		return <NotFound message="No Data Type Entry: Empty DB" />;
	} else {
		console.log("init Items: ", dataTypes.current);

		const columns = [
			{
				id: namespace(portletParameters.namespace, "checkAll"),
				name: "Check All",
				width: "50px",
			},
			{
				id: namespace(portletParameters.namespace, "id"),
				name: "ID",
				width: "20%",
			},
			{
				id: namespace(portletParameters.namespace, "displayName"),
				name: "Display Name",
				width: "auto",
			},
			{
				id: namespace(portletParameters.namespace, "name"),
				name: "Name",
				width: "20%",
			},
			{
				id: namespace(portletParameters.namespace, "version"),
				name: "Version",
				width: "20%",
			},
			{
				id: namespace(portletParameters.namespace, "actions"),
				name: "Actions",
				width: "50px",
			},
		];

		const syncCheckAll = () => {
			let allChecked = true;

			dataTypes.current.every((dataType) => {
				if (!dataType.checked) {
					allChecked = false;
					return false;
				}
				return true;
			});

			console.log("syncCheckAll: ", checkAll, allChecked);
			if (checkAll !== allChecked) {
				setCheckAll(allChecked);
			}
		};

		const handleCheckAllChangeEvent = (event) => {
			dataTypes.current = dataTypes.current.map((dataType) => {
				dataType.checked = !checkAll;
				return dataType;
			});

			setCheckAll(!checkAll);
		};

		const handleActionClick = (id) => {
			console.log(`${id} is clicked`);
		};

		const deleteDataType = (dataTypeId) => {
			console.log("deleteDataType: " + dataTypeId);

			dispatchConfirmDialog({
				payload: {
					body: <h4>{translate("if-you-do-this-it-will-be-never-recovered")}</h4>,
					footer: [
						<ClayButton
							key={1}
							onClick={(e) => {
								ajax(
									portletParameters.namespace,
									portletParameters.baseResourceURL,
									ResourceIds.DELETE_DATATYPE,
									"post",
									"json",
									{
										dataTypeId: dataTypeId,
									},
									(result) => {
										console.log("Ajax deleteDataType success: ", result);
										setLoadingStatus(LoadingStatus.PENDING);
									},
									(err, b, c, d) => {
										console.log("Ajax deleteDataType failed: ", err, b, c, d);
									}
								);
								confirmDialogState.onClose(e);
							}}
						>
							{translate("confirm")}
						</ClayButton>,
						<ClayButton key={2} onClick={confirmDialogState.onClose}>
							{translate("cancel")}
						</ClayButton>,
					],
					header: (
						<>
							<ClayIcon
								spritemap={portletParameters.spritemapPath}
								symbol="warning"
								style={{
									display: "inline-block",
									color: "#e4a24c",
									marginRight: "5px",
								}}
							></ClayIcon>
							{translate("warning")}
						</>
					),
					size: "lg",
				},
				type: "OPEN",
			});
		};

		const editDataType = (dataTypeId) => {
			const portletParams = {
				namespace: portletParameters.params.workbenchNamespace,
				portletId: portletParameters.params.workbenchId,
				windowState: "normal",
			};

			const dataParams = {
				workingPortletName: PortletKeys.DATATYPE_EDITOR,
				params: JSON.stringify({
					dataTypeId: dataTypeId,
				}),
			};
			redirectTo(portletParameters.params.workbenchURL, portletParams, dataParams);
		};
		const editDataStructure = (dataTypeId) => {
			const portletParams = {
				namespace: portletParameters.params.workbenchNamespace,
				portletId: portletParameters.params.workbenchId,
				windowState: "normal",
			};

			const dataParams = {
				workingPortletName: PortletKeys.DATA_STRUCTURE_BUILDER,
				params: {
					dataTypeId: dataTypeId,
				},
			};
			redirectTo(portletParameters.params.workbenchURL, portletParams, dataParams);
		};

		if (displayStyle === DisplayStyle.TABLE) {
			return (
				<Table>
					<Head items={columns}>
						{(column, index) => {
							return index > 0 ? (
								<Cell key={column.id} width={column.width}>
									{column.name}
								</Cell>
							) : (
								<Cell
									key={namespace(portletParameters.namespace, "checkAll")}
									textValue="checkAll"
									width={column.width}
								>
									<ClayCheckbox
										id={namespace(portletParameters.namespace, "checkAll")}
										name={namespace(portletParameters.namespace, "checkAll")}
										checked={checkAll}
										onChange={handleCheckAllChangeEvent}
									/>
								</Cell>
							);
						}}
					</Head>
					<Body defaultItems={dataTypes.current}>
						{(row, index) => {
							console.log("row: ", index, row);
							if (!row) {
								return <div>No data type found</div>;
							}

							const itemCheckboxChangeEventHandler = (e) => {
								dataTypes.current = dataTypes.current.map((dataType) => {
									if (dataType.dataTypeId === row.dataTypeId) {
										dataType.checked = !dataType.checked;
									}

									return dataType;
								});

								syncCheckAll();
							};

							return (
								<Row key={row.dataTypeId}>
									<Cell>
										<ClayCheckbox
											id={namespace(portletParameters.namespace, "checkbox_" + row.id)}
											name={namespace(portletParameters.namespace, "selected")}
											checked={row.checked}
											onChange={itemCheckboxChangeEventHandler}
										/>
									</Cell>
									<Cell>{row.dataTypeId}</Cell>
									<Cell>{row.displayName}</Cell>
									<Cell>{row.dataTypeName}</Cell>
									<Cell>{row.dataTypeVersion}</Cell>
									<Cell>
										<ClayDropDownWithItems
											items={[
												{
													onClick: (e) => {
														deleteDataType(row.dataTypeId);
													},
													label: Liferay.Language.get("delete"),
												},
												{
													onClick: (e) => {
														editDataType(row.dataTypeId);
													},
													label: Liferay.Language.get("edit"),
												},
												{
													onClick: (e) => {
														editDataStructure(row.dataTypeId);
													},
													label: Liferay.Language.get("edit-data-structure"),
												},
											]}
											trigger={
												<ClayButtonWithIcon
													aria-label="Actions"
													title="Actions"
													displayType="unstyled"
													small
													spritemap={portletParameters.spritemapPath}
													symbol="ellipsis-v"
												/>
											}
										/>
									</Cell>
								</Row>
							);
						}}
					</Body>
				</Table>
			);
		} else if (displayStyle === DisplayStyle.CARD) {
			return <></>;
		} else {
			return <></>;
		}
	}
};

export default DataTypeListTable;
