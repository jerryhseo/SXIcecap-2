import React from "react";
import ClayModal, { Modal, useModal } from "@clayui/modal";
import ClayButton from "@clayui/button";
import ClayIcon from "@clayui/icon";
import Button from "@clayui/button";

export const SXModalDialog = ({
	size,
	status = "secondary",
	spritemap,
	header = "",
	body,
	buttons,
	withTitle = false,
	disableAutoClose = "false"
}) => {
	const { observer, onOpenChange, open } = useModal();
	return (
		<Modal
			observer={observer}
			size={size}
			spritemap={spritemap}
			status={status}
			disableAutoClose={disableAutoClose}
			center
		>
			<Modal.Header withTitle={withTitle}>{header}</Modal.Header>
			<Modal.Body style={{ justifyItems: "center" }}>{body}</Modal.Body>
			<Modal.Footer
				last={
					<Button.Group spaced>
						{buttons.map((button, index) => {
							return (
								<Button
									key={index + 1}
									displayType={button.displayType}
									onClick={() => {
										button.onClick();
										onOpenChange(false);
									}}
								>
									{button.label}
								</Button>
							);
						})}
					</Button.Group>
				}
			/>
		</Modal>
	);
};

export const SXNoticeDialog = ({ size, spritemap, header, body }) => {
	const { observer, onOpenChange, open } = useModal();
	onOpenChange(true);

	return (
		<ClayModal
			observer={observer}
			size={size}
			spritemap={spritemap}
			status="info"
		>
			<ClayModal.Header>{header}</ClayModal.Header>
			<ClayModal.Body>
				<p>{body}</p>
			</ClayModal.Body>
			<ClayModal.Footer
				last={
					<ClayButton.Group spaced>
						<ClayButton
							displayType="secondary"
							onClick={() => {
								onOpenChange(false);
							}}
						>
							{Liferay.Language.get("ok")}
						</ClayButton>
					</ClayButton.Group>
				}
			/>
		</ClayModal>
	);
};

export const openConfirmModal = ({ title, modalType, content, buttons, size, spritemap }) => {
	return {
		payload: {
			body: <div>{content}</div>,
			footer: buttons.map((button, index) => {
				return (
					<ClayButton
						key={index}
						onClick={button.onClick}
					>
						{button.label}
					</ClayButton>
				);
			}),
			header: (
				<>
					<ClayIcon
						spritemap={spritemap}
						symbol={modalType}
						style={{
							display: "inline-block",
							color: "#e4a24c",
							marginRight: "5px"
						}}
					></ClayIcon>
					{title}
				</>
			),
			size: size
		},
		type: "OPEN"
	};
};

export const SXErrorModal = ({ imageURL }) => {
	const { observer, onOpenChange, open } = useModal();

	return (
		<Modal
			observer={observer}
			disableAutoClose={true}
			center
		>
			<Modal.Body style={{ justifyItems: "center" }}>
				<img src={imageURL} />
			</Modal.Body>
		</Modal>
	);
};

export const SXLoadingModal = ({ imageURL }) => {
	const { observer, onOpenChange, open } = useModal();

	return (
		<Modal
			observer={observer}
			disableAutoClose={true}
			center
		>
			<Modal.Body style={{ justifyItems: "center" }}>
				<img src={imageURL} />
			</Modal.Body>
		</Modal>
	);
};
