import ClayPanel from "@clayui/panel";
import ClayLayout from "@clayui/layout";
import { SXText } from "../../form/sxform";

export const SXDataTypeHeader = ({ id, name, displayName, version, spritemap }) => {
	const panelStyle = {
		padding: "10px 15px 5px 15px"
	};

	const panelBodyStyle = {
		padding: "0px 5px"
	};

	const containerStyle = {
		padding: "0.3rem"
	};

	const colStyles = {
		//backgroundColor: "#E7E7ED",
		//border: "1px solid #CDCED9",
		padding: "0"
	};

	const displayTitle = displayName ? (
		<ClayPanel.Title>
			<h3>{displayName}</h3>
		</ClayPanel.Title>
	) : (
		""
	);
	return (
		<ClayPanel
			collapsable={false}
			defaultExpanded={true}
			displayTitle={displayName}
			displayType="secondary"
			showCollapseIcon={false}
			spritemap={spritemap}
			style={panelStyle}
		>
			<ClayPanel.Body style={panelBodyStyle}>
				<ClayLayout.ContainerFluid
					view
					style={containerStyle}
				>
					<ClayLayout.Row justify="around">
						<ClayLayout.Col
							size={3}
							style={colStyles}
						>
							<SXText
								label="Id"
								text={id}
								type="INLINE_ATTACH"
							/>
						</ClayLayout.Col>
						<ClayLayout.Col
							size={3}
							style={colStyles}
						>
							<SXText
								label="Name"
								text={name}
								type="INLINE_ATTACH"
							/>
						</ClayLayout.Col>
						<ClayLayout.Col
							size={3}
							style={colStyles}
						>
							<SXText
								label="Version"
								text={version}
								type="INLINE_ATTACH"
							/>
						</ClayLayout.Col>
					</ClayLayout.Row>
				</ClayLayout.ContainerFluid>
			</ClayPanel.Body>
		</ClayPanel>
	);
};

const SXHeader = ({ type, ...props }) => {
	const { id, name, displayName, version, spritemap } = props;
	if (type === "dataType") {
		return (
			<SXDataTypeHeader
				id={id}
				name={name}
				displayName={displayName}
				version={version}
				spritemap={spritemap}
			/>
		);
	} else {
		return <></>;
	}
};

export default SXHeader;
