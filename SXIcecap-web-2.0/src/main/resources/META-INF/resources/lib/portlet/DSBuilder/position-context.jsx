import React, { useState, createContext, useContext, useMemo } from "react";

// Create Context
export const SXPositionContext = createContext();

export default SXPositionProvider = ({ children }) => {
	const [firstOrder, setFirstOrder] = useState(1);
	const [secondOrder, setSecondOrder] = useState(2);

	const switchPositions = () => {
		setFirstOrder(firstOrder === 1 ? 2 : 1);
		setSecondOrder(secondOrder === 2 ? 1 : 2);
	};

	const value = useMemo(
		() => ({
			firstOrder,
			secondOrder,
			switchPositions
		}),
		[firstOrder, secondOrder]
	);

	return <SXPositionContext.Provider value={value}>{children}</SXPositionContext.Provider>;
};
