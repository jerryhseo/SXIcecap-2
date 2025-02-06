import React, { useState, createContext, useContext, useMemo } from "react";
import "./App.css";
import SXPositionProvider, { SXPositionContext } from "./position-context";

const Component = React.memo(({ order, label }) => {
	return (
		<div
			className="component"
			style={{ order }}
		>
			{label}
		</div>
	);
});

const SXPreviewPanel = () => {
	const { firstOrder, secondOrder, switchPositions } = useContext(SXPositionContext);

	return (
		<SXPositionProvider>
			<div className="App">
				<button onClick={switchPositions}>Switch Positions</button>
				<div className="container">
					<Component
						order={firstOrder}
						label="Component 1"
					/>
					<Component
						order={secondOrder}
						label="Component 2"
					/>
				</div>
			</div>
		</SXPositionProvider>
	);
};

export default SXPreviewPanel;
