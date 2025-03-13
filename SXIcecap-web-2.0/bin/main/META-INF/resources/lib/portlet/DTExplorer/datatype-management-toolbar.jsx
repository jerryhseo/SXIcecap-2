import React, {useState, useEffect, useContext} from 'react';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import {ClayInput} from '@clayui/form';
import {ClayDropDownWithItems} from '@clayui/drop-down';
import ClayToolbar from '@clayui/toolbar';
import {DisplayStyle, PortletKeys} from '../../common/station-x';
import {namespace, redirectTo} from '../../common/util';

const DataTypeManagementToolbar = ({portletParameters, searchContainerId}) => {
	const [selectedDataTypeId, setSelectedDataTypeId] = useState(0);

	const handleNewButtonClick = (e) => {
		const portletParams = {
			namespace: portletParameters.params.workbenchNamespace,
			portletId: portletParameters.params.workbenchId,
			windowState: 'normal'
		};

		const dataParams = {
			workingPortletName: PortletKeys.DATATYPE_EDITOR,
			params: JSON.stringify({
				dataTypeId: selectedDataTypeId
			})
		};
		redirectTo(
			portletParameters.params.workbenchURL,
			portletParams,
			dataParams
		);
	};

	const deleteAllCheckedClickEventHandler = (event) => {};

	const changeDisplayStyle = (displayStyle) => {
		Event.fire(
			Event.SX_DISPLAY_STYLE_CHANGED,
			Event.createEventDataPacket(
				portletParameters.namespace,
				portletParameters.namespace,
				{
					displayStyle: displayStyle,
					containerId: searchContainerId
				}
			)
		);
	};

	return (
		<ClayToolbar>
			<ClayToolbar.Nav wrap={true}>
				<ClayToolbar.Item>
					<ClayButtonWithIcon
						aria-label="new data type"
						spritemap={portletParameters.spritemapPath}
						symbol="plus"
						displayType="beta"
						onClick={handleNewButtonClick}
						id={namespace(portletParameters.namespace, 'btnNew')}
						title={Liferay.Language.get('new-datatype')}
					/>
				</ClayToolbar.Item>
				<ClayToolbar.Item expand>
					<ClayInput.Group>
						<ClayInput.GroupItem>
							<ClayInput
								className="form-control-inline"
								placeholder="Search..."
								id={namespace(
									portletParameters.namespace,
									'dataTypeSearchTerm'
								)}
								type="text"
							/>
						</ClayInput.GroupItem>
						<ClayInput.GroupItem>
							<ClayButtonWithIcon
								aria-label="search"
								title="Search"
								className="form-control-inline"
								displayType="secondary"
								onClick={() => {}}
								small
								id={namespace(
									portletParameters.namespace,
									'dataTypeSearch'
								)}
								spritemap={portletParameters.spritemapPath}
								symbol="search"
							/>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				</ClayToolbar.Item>

				<ClayToolbar.Item>
					<ClayToolbar.Section>
						<ClayButton.Group>
							<ClayButtonWithIcon
								aria-label="delete all checked data type"
								title="Delete All Checked Data Type"
								displayType="unstyled"
								onClick={() => {}}
								small
								spritemap={portletParameters.spritemapPath}
								symbol="trash"
							/>
						</ClayButton.Group>
					</ClayToolbar.Section>
				</ClayToolbar.Item>
				<ClayToolbar.Item>
					<ClayDropDownWithItems
						items={[
							{
								label: Liferay.Language.get('table'),
								onClick: (e) => {
									changeDisplayStyle(DisplayStyle.TABLE);
								}
							},
							{
								label: 'list',
								onClick: (e) => {
									changeDisplayStyle(DisplayStyle.LIST);
								}
							},
							{
								label: 'card',
								onClick: (e) => {
									changeDisplayStyle(DisplayStyle.CARD);
								}
							}
						]}
						trigger={
							<ClayButtonWithIcon
								aria-label="Display"
								title="Display"
								displayType="unstyled"
								small
								spritemap={portletParameters.spritemapPath}
								symbol="display"
							/>
						}
					/>
				</ClayToolbar.Item>

				<ClayToolbar.Item>
					<ClayDropDownWithItems
						items={[
							{
								href: '#one',
								label: Liferay.Language.get('start')
							},
							{href: '#two', label: 'two'},
							{disabled: true, href: '#three', label: 'three'},
							{href: '#four', label: 'four'}
						]}
						trigger={
							<ClayButtonWithIcon
								aria-label="More Actions"
								title="More Actions"
								displayType="unstyled"
								small
								spritemap={portletParameters.spritemapPath}
								symbol="ellipsis-v"
							/>
						}
					/>
				</ClayToolbar.Item>
			</ClayToolbar.Nav>
		</ClayToolbar>
	);
};

export default DataTypeManagementToolbar;
