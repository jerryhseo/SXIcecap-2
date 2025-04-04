import React from "react";
import Button from "@clayui/button";
import Icon from "@clayui/icon";

export const NotFound = ({ message = "Not Found." }) => {
	return (
		<div className="not-found">
			<span className="w-100">{message}</span>
		</div>
	);
};

export const UnderConstruction = () => {
	return <div className="under-construction"></div>;
};
