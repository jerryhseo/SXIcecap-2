import React, { useState, createContext, useMemo } from "react";

// Create Context
export const SXParameterContext = createContext();

export default SXParameterProvider = ({ children }) => {
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

	return <SXParameterContext.Provider value={value}>{children}</SXParameterContext.Provider>;
};
