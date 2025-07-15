import React, { useCallback, useLayoutEffect, useRef, useState } from "react";
import { Util } from "../../common/util";
import { Event, ParamProperty, ParamType, ValidationRule } from "../../common/station-x";
import SXFormField from "../../form/sxform";
import { BooleanParameter, GroupParameter, Parameter, SelectParameter } from "../../parameter/parameter";

class SXDSBuilderOptionPropertiesPanel extends React.Component {
	constructor(props) {
		super(props);

		this.formIds = props.formIds;
		this.namespace = props.workingParam.namespace;
		this.languageId = props.workingParam.languageId;
		this.availableLanguageIds = props.workingParam.availableLanguageIds;
		this.spritemap = props.spritemap;
		this.workingParam = props.workingParam;
		this.dataStructure = props.dataStructure;

		this.toggleFields = {
			abstractKey: new BooleanParameter(
				this.namespace,
				this.formIds.optionsFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.ABSTRACT_KEY,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "abstract-key"),
					tooltip: Util.getTranslationObject(this.languageId, "abstract-key-of-the-parameter-tooltip"),
					value: this.workingParam.abstractKey
				}
			),
			downloadable: new BooleanParameter(
				this.namespace,
				this.formIds.optionsFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.DOWNLOADABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "downloadable"),
					tooltip: Util.getTranslationObject(this.languageId, "downloadable-of-the-parameter-tooltip"),
					value: this.workingParam.downloadable
				}
			),
			searchable: new BooleanParameter(
				this.namespace,
				this.formIds.optionsFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.SEARCHABLE,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "searchable"),
					tooltip: Util.getTranslationObject(this.languageId, "searchable-of-the-parameter-tooltip"),
					value: this.workingParam.searchable
				}
			),
			disabled: new BooleanParameter(
				this.namespace,
				this.formIds.optionsFormId,
				this.languageId,
				this.availableLanguageIds,
				{
					paramName: ParamProperty.DISABLED,
					viewType: BooleanParameter.ViewTypes.TOGGLE,
					displayName: Util.getTranslationObject(this.languageId, "disabled"),
					tooltip: Util.getTranslationObject(this.languageId, "disabled-of-the-parameter-tooltip"),
					value: this.workingParam.disabled
				}
			)
		};

		this.fieldToggleGroup = new GroupParameter(
			this.namespace,
			this.formIds.optionsFormId,
			this.languageId,
			this.availableLanguageIds,
			{
				paramName: "toggleGroup",
				viewType: GroupParameter.ViewTypes.ARRANGEMENT,
				membersPerRow: 1,
				members: Object.values(this.toggleFields)
			}
		);
	}

	componentDidMount() {
		Event.uniqueOn(Event.SX_FIELD_VALUE_CHANGED, (e) => {
			const dataPacket = e.dataPacket;
			if (dataPacket.targetPortlet !== this.namespace || dataPacket.targetFormId !== this.formIds.optionsFormId)
				return;

			console.log(
				"DataStructureBuilder SX_FIELD_VALUE_CHANGED RECEIVED: ",
				dataPacket,
				this.dataStructure,
				this.workingParam
			);

			this.workingParam[dataPacket.paramName] = this.toggleFields[dataPacket.paramName].getValue();

			if (this.workingParam.isRendered()) {
				this.workingParam.fireRefreshPreview();
			}
		});
	}

	render() {
		return (
			<>
				{this.fieldToggleGroup.render({
					spritemap: this.spritemap,
					inputStatus: this.inputStatus
				})}
			</>
		);
	}
}

export default SXDSBuilderOptionPropertiesPanel;
