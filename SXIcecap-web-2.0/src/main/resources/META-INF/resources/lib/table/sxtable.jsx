import React, { useState } from "react";
import { ClayButtonWithIcon } from "@clayui/button";
import { ClayDropDownWithItems } from "@clayui/drop-down";
import { DisplayStyle } from "../common/station-x";
import { Body, Cell, Head, Row, Table } from "@clayui/core";
import { ClayCheckbox } from "@clayui/form";
import { NotFound } from "../common/common";

const SXTable = ({ columns, items, onSelect, displayStyle, spritemap }) => {
	const [checkAll, setCheckAll] = useState(false);

	console.log("SXTable: ", items);
	if (items.length < 1) {
		return <NotFound></NotFound>;
	}

	if (displayStyle === DisplayStyle.TABLE) {
		return (
			<Table>
				<Head items={columns}>
					{(column, index) => {
						console.log("head column: ", column, index);
						if (column.type === "checkbox") {
							return (
								<Cell
									key={column.id}
									textValue="checkAll"
									width={column.width}
								>
									<ClayCheckbox
										id={column.id}
										checked={checkAll}
										onChange={() => {
											setCheckAll(!checkAll);
											items.forEach((item) => {
												item.checked = !checkAll;
											});
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
				<Body defaultItems={items}>
					{(row, index) => {
						if (!row) {
							return <h2>Not Found</h2>;
						}
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
														onSelect(row.id);
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
															symbol: item.symbol,
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
															spritemap={spritemap}
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
	} else if (displayStyle === DisplayStyle.CARD) {
		return <></>;
	} else {
		return <></>;
	}
};

export default SXTable;
