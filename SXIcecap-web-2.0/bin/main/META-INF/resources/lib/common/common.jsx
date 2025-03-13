import React from "react";

export const NotFound = ({ message = "Not Found." }) => {
	return (
		<div className="not-found">
			<span className="w-100">{message}</span>
		</div>
	);
};
