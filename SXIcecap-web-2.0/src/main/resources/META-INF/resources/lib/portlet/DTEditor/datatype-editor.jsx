import React, { useState, useLayoutEffect, useRef, useContext, useMemo } from "react";
import { Text } from "@clayui/core";
import ClayButton from "@clayui/button";
import { ClayIconSpriteContext } from "@clayui/icon";
import ClayForm, { Form } from "@clayui/form";
import { Context } from "@clayui/modal";
import SXFormField, {
	SXRow,
	SXDualListBox,
	SXInput,
	SXLocalizedInput,
	SXButtonWithIcon,
	SXLabeledText,
	validateForm,
	SelectDisplayStyle
} from "../../form/sxform";
import { Util } from "../../common/util";
import {
	EditStatus,
	LoadingStatus,
	Event,
	DataTypeProperty,
	ParamType,
	DisplayType,
	ValidationRule,
	ResourceIds,
	PortletKeys,
	WindowState,
	ViewTypes
} from "../../common/station-x";
import { DataStructure } from "../DSBuilder/data-structure";
import { StringParameter } from "../../parameter/parameter";

export const DataTypeInfo = ({ title, abstract, items, colsPerRow = 1 }) => {
	let sectionContent;

	console.log("DataTypeInfo items: ", items);

	if (colsPerRow === 1) {
		sectionContent = items.map((item, index) => (
			<div
				class="form-group-item"
				key={index}
			>
				<SXLabeledText
					label={item.label}
					text={item.text}
				/>
			</div>
		));
	} else if (colsPerRow > 1) {
		let rows = Util.convertArrayToRows(items, colsPerRow);

		console.log("DataTypeInfo: rows ", rows);

		sectionContent = rows.map((row, rowIndex) => (
			<div
				key={rowIndex}
				className="form-group-autofit"
				style={{ marginBottom: "5px" }}
			>
				{row.map((col, colIndex) => (
					<div
						key={(rowIndex + 1) * (colIndex + 1)}
						className="form-group-item"
						style={{ marginBottom: "0" }}
					>
						<SXLabeledText
							label={col.label}
							text={col.text}
							viewType="INLINE_ATTACH"
						/>
					</div>
				))}
			</div>
		));
	}

	return (
		<div className="form-group sheet sheet-lg">
			<div
				className="sheet-header"
				style={{ marginBottom: "20px" }}
			>
				<h3
					className="sheet-title"
					style={{ marginBottom: "10px" }}
				>
					{title}
				</h3>
				<div
					className="sheet-text"
					style={{ marginBottom: "5px" }}
				>
					{abstract}
				</div>
			</div>
			<div
				className="sheet-section"
				style={{ marginBottom: "1rem" }}
			>
				{sectionContent}
			</div>
		</div>
	);
};

const DataTypeEditor = ({ portletParameters }) => {
	const {
		namespace, //
		baseResourceURL,
		spritemapPath,
		languageId,
		availableLanguageIds
	} = portletParameters;
	const {
		workbenchURL, //
		workbenchId,
		workbenchNamespace,
		dataTypeId
	} = portletParameters.params;

	const [dataTypeIdState, setDataTypeIdState] = useState(dataTypeId);
	const inUseVisualizers = useRef([]);
	const availableVisualizers = useRef([]);

	const [loadingStatus, setLoadingStatus] = useState(LoadingStatus.PENDING);

	const formData = useRef({});
	const formErrors = useRef({});
	const formFields = useRef([]);
	const dataTypeLoaded = useRef(dataTypeIdState > 0 ? LoadingStatus.PENDING : LoadingStatus.COMPLETE);
	const visualizersLoaded = useRef(LoadingStatus.PENDING);

	const [dialogState, dispatchDialog] = useContext(Context);

	const editStatus = useRef(dataTypeIdState > 0 ? EditStatus.UPDATE : EditStatus.ADD);

	const renderCount = useRef(0);
	const parametersRef = useRef({});

	useLayoutEffect(() => {
		Event.on(Event.SX_FORM_FIELD_CHANGED, (e) => {
			console.log("SX_FORM_FIELD_CHANGED RECEIVED: ", e);
			const { dataPacket } = e;
			if (
				!Event.validateMine(dataPacket, {
					namespace: namespace
				})
			) {
				return;
			}

			formData.current[dataPacket.fieldName] = dataPacket.value;

			delete formErrors.current[dataPacket.fieldName];

			console.log("formData: ", formData, formErrors);
		});

		Event.on(Event.SX_FORM_FIELD_FAILED, (e) => {
			console.log("SX_FORM_FIELD_FAILED RECEIVED: ", e);
			const { dataPacket } = e;
			if (
				!Event.validateMine(dataPacket, {
					namespace: namespace
				})
			)
				return;

			formErrors.current[dataPacket.fieldName] = dataPacket.error;

			console.log("formErrors: ", formErrors);
		});

		formFields.current = [
			{
				paramName: "baseGroup",
				paramVersion: "1.0.0",
				paramType: ParamType.GROUP,
				viewType: ViewTypes.HORIZONTAL,
				fieldsPerRow: 3,
				members: [
					{
						paramName: DataTypeProperty.NAME,
						paramVersion: "1.0.0",
						parent: {
							name: "baseGroup",
							version: "1.0.0"
						},
						paramType: ParamType.STRING,
						displayName: Util.translate("datatype-name"),
						required: true,
						localized: false,
						placeholder: Util.translate("code-name-of-the-datatype"),
						tooltip: Util.translate("datatype-name-tooltip"),
						multiLine: false,
						disabled: false,
						events: {
							fire: [Event.SX_FORM_FIELD_CHANGED],
							on: [Event.SX_PARAM_PROPERTY_CHANGED]
						},
						validation: {
							required: {
								value: true,
								message: `${DataTypeProperty.NAME} is required`
							},
							pattern: {
								value: ValidationRule.VARIABLE,
								message: "Invalid data type name"
							},
							min: {
								value: 3,
								message: "Should be at least 3"
							},
							max: {
								value: 32,
								message: "Should be shorter than 33"
							}
						},
						defaultValue: "",
						order: 1
					},
					{
						paramName: DataTypeProperty.VERSION,
						paramVersion: "1.0.0",
						parent: {
							name: "baseGroup",
							version: "1.0.0"
						},
						paramType: ParamType.STRING,
						displayName: Util.translate("datatype-version"),
						required: true,
						localized: false,
						placeholder: Util.translate("version-of-the-datatype"),
						tooltip: Util.translate("datatype-version-tooltip"),
						multiLine: false,
						disabled: false,
						events: {
							fire: [Event.SX_FORM_FIELD_CHANGED],
							on: [Event.SX_PARAM_PROPERTY_CHANGED]
						},

						validation: {
							required: {
								value: true,
								message: `${DataTypeProperty.VERSION} is required`
							},
							pattern: {
								value: ValidationRule.VERSION,
								message: "Invalid data type version"
							}
						},
						defaultValue: "",
						order: 2
					},
					{
						paramName: DataTypeProperty.EXTENSION,
						paramVersion: "1.0.0",
						parent: {
							name: "baseGroup",
							version: "1.0.0"
						},
						paramType: ParamType.STRING,
						displayName: Util.translate("datatype-extension"),
						required: true,
						localized: false,
						placeholder: Util.translate("extension-of-the-datatype"),
						tooltip: Util.translate("datatype-extension-tooltip"),
						multiLine: false,
						disabled: false,
						events: {
							fire: [Event.SX_FORM_FIELD_CHANGED],
							on: [Event.SX_PARAM_PROPERTY_CHANGED]
						},

						validation: {
							required: {
								value: true,
								message: `${DataTypeProperty.EXTENSION}-is-required`
							},
							pattern: {
								value: ValidationRule.EXTENSION,
								message: "Invalid data type extension"
							},
							min: {
								value: 2,
								message: "Should be at least 2"
							},
							max: {
								value: 16,
								message: "Should be shorter than 17"
							}
						},
						defaultValue: "",
						order: 3
					}
				],
				order: 1
			},
			{
				paramName: DataTypeProperty.DISPLAY_NAME,
				paramVersion: "1.0.0",
				paramType: ParamType.STRING,
				displayName: Util.translate("display-name"),
				required: true,
				localized: true,
				languageId: languageId,
				availableLanguageIds: availableLanguageIds.split(","),
				placeholder: Util.translate("display-name-of-the-datatype"),
				tooltip: Util.translate("display-name-tooltip"),
				multiLine: false,
				disabled: false,
				events: {
					fire: [Event.SX_FORM_FIELD_CHANGED],
					on: [Event.SX_PARAM_PROPERTY_CHANGED]
				},

				validation: {
					required: {
						value: true,
						message: `${DataTypeProperty.DISPLAY_NAME}-is-required`
					},
					min: {
						value: 3,
						message: "Must longer than 3"
					},
					max: {
						value: 64,
						message: "Must shorter than 64"
					}
				},
				defaultValue: {},
				order: 2
			},
			{
				paramName: DataTypeProperty.DESCRIPTION,
				paramVersion: "1.0.0",
				paramType: ParamType.STRING,
				displayName: Util.translate("description"),
				required: false,
				localized: true,
				languageId: languageId,
				availableLanguageIds: availableLanguageIds.split(","),
				placeholder: Util.translate("description-of-the-datatype"),
				tooltip: Util.translate("description-tooltip"),
				multiLine: true,
				disabled: false,
				events: {
					fire: [Event.SX_FORM_FIELD_CHANGED],
					on: [Event.SX_PARAM_PROPERTY_CHANGED]
				},

				validation: {},
				defaultValue: {},
				order: 3
			},
			{
				paramName: DataTypeProperty.TOOLTIP,
				paramVersion: "1.0.0",
				paramType: ParamType.STRING,
				displayName: Util.translate("tooltip"),
				required: false,
				localized: true,
				languageId: languageId,
				availableLanguageIds: availableLanguageIds.split(","),
				placeholder: Util.translate("tooltip-of-the-datatype"),
				tooltip: Util.translate("tooltip-tooltip"),
				multiLine: false,
				disabled: false,
				events: {
					fire: [Event.SX_FORM_FIELD_CHANGED],
					on: [Event.SX_PARAM_PROPERTY_CHANGED]
				},

				validation: {
					max: {
						value: 64,
						message: "Should be shorter than 65 bytes"
					}
				},
				defaultValue: {},
				order: 4
			},
			{
				paramName: DataTypeProperty.VISUALIZERS,
				paramVersion: "1.0.0",
				paramType: ParamType.DUALLIST,
				displayName: Util.translate("associated-visualisers"),
				required: true,
				placeholder: Util.translate("tooltip-of-the-datatype"),
				tooltip: Util.translate("tooltip-tooltip"),
				disabled: false,
				viewType: "horizontal",
				events: {
					fire: [Event.SX_FORM_FIELD_CHANGED],
					on: [Event.SX_PARAM_PROPERTY_CHANGED]
				},

				validation: {
					required: {
						value: true,
						message: `${DataTypeProperty.VISUALIZERS}-is-required`
					}
				},
				defaultValue: [],
				leftOptions: inUseVisualizers.current,
				rightOptions: availableVisualizers.current,
				order: 5
			}
		].sort((a, b) => a.order - b.order);

		formFields.current.forEach((field) => {
			if (!Util.isEmpty(field.defaultValue)) {
				field.value = field.defaultValue;
			}

			//parametersRef.current.push(DataStructure.createParameter(field.paramType, field));
		});

		//Loading dataType
		if (dataTypeIdState > 0 && loadingStatus === LoadingStatus.PENDING) {
			Util.ajax({
				namespace: namespace,
				baseResourceURL: baseResourceURL,
				resourceId: ResourceIds.LOAD_DATATYPE,
				type: "post",
				dataType: "json",
				params: {
					dataTypeId: dataTypeIdState
				},
				successFunc: (result) => {
					console.log("Data type: ", result);
					formFields.current.forEach((field) => {
						if (!Util.isEmpty(result[field.paramName])) {
							field.value = result[field.paramName];
						} else {
							field.value = Util.isEmpty(field.defaultValue) ? field.defaultValue : null;
						}
					});

					formData.current = result;

					if (visualizersLoaded.current === LoadingStatus.PENDING) {
						dataTypeLoaded.current = LoadingStatus.COMPLETE;
					} else {
						setLoadingStatus(LoadingStatus.COMPLETE);
					}
				},
				errorFunc: (err) => {
					console.log("Error while loading data type: " + dataTypeIdState);
					setLoadingStatus(LoadingStatus.FAIL);
				}
			});
		}

		//Loading available visualizers
		Util.ajax({
			namespace: namespace,
			baseResourceURL: baseResourceURL,
			resourceId: ResourceIds.LOAD_AVAILABLE_VISUALIZERS,
			type: "post",
			dataType: "json",
			params: {
				dataTypeId: dataTypeIdState
			},
			successFunc: (result) => {
				console.log("available visualizers: ", result);

				let availables = result.map((item) => {
					return {
						label: item.displayName[languageId],
						value: String(item.id),
						id: item.id
					};
				});

				availableVisualizers.current = availables;

				if (dataTypeLoaded.current === LoadingStatus.PENDING) {
					visualizersLoaded.current = LoadingStatus.COMPLETE;
				} else {
					setLoadingStatus(LoadingStatus.COMPLETE);
				}
			},
			errorFunc: (err) => {
				console.log("Error while loading available visualizers for " + dataTypeIdState);
				setLoadingStatus(LoadingStatus.FAIL);
			}
		});
	}, []);

	if (loadingStatus === LoadingStatus.PENDING) {
		return <h1>Loading......</h1>;
	} else if (loadingStatus === LoadingStatus.FAIL) {
		return <h1>Data Loading Failed......</h1>;
	} else if (loadingStatus === LoadingStatus.COMPLETE) {
		console.log("Start rendering: ", formData.current, inUseVisualizers, availableVisualizers);
		const saveButtonLabel = Util.translate(editStatus.current === EditStatus.UPDATE ? "update" : "create");
		const saveResourceId =
			editStatus.current === EditStatus.UPDATE ? ResourceIds.UPDATE_DATATYPE : ResourceIds.ADD_DATATYPE;

		const handleMoveToExplorer = (e) => {
			Event.fire(
				Event.SX_REPLACE_PORTLET,
				Event.createEventDataPacket(namespace, workspaceNamespace, {
					portletName: PortletKeys.DATATYPE_EXPLORER
				})
			);
		};
		const header = (
			<div className="form-group">
				<Text size={6}>
					{editStatus.current === EditStatus.UPDATE
						? Util.translate("edit-datatype")
						: Util.translate("add-datatype")}
				</Text>
				<SXButtonWithIcon
					id={Util.namespace(namespace, "btnMoveToExplorer")}
					label={Util.translate("datatype-list")}
					symbol={"list"}
					displayType={"link"}
					style={{ float: "right" }}
					size="lg"
					onClick={handleMoveToExplorer}
				/>
			</div>
		);

		const showDialog = (dlgHeader, dlgBody, dlgButtons, dlgSize = "sm") => {
			dispatchDialog({
				payload: {
					body: <h3>{dlgBody}</h3>,
					footer: dlgButtons.map((button, index) => {
						return (
							<ClayButton
								key={index}
								onClick={(e) => {
									button.onClick && button.onClick(e);
									dialogState.onClose(e);
								}}
								displayType="secondary"
							>
								{button.label}
							</ClayButton>
						);
					}),
					header: dlgHeader,
					size: dlgSize
				},
				type: "OPEN"
			});
		};

		const handleBtnSaveClick = (e) => {
			const checkError = validateForm(formFields.current, formData.current, formErrors.current);

			if (checkError) {
				Event.fire(
					Event.SX_PARAM_ERROR_FOUND,
					Event.createEventDataPacket(namespace, namespace, {
						formId: formId,
						paramName: checkError.fieldName,
						tagName: checkError.fieldName,
						tagId: checkError.fieldName,
						error: checkError.message
					})
				);
				return;
			}

			console.log("Form Data: ", formData.current, formErrors.current);
			let params = {
				dataTypeId: dataTypeIdState,
				formData: JSON.stringify(formData.current)
			};

			Util.ajax({
				namespace: namespace,
				baseResourceURL: baseResourceURL,
				resourceId: saveResourceId,
				type: "post",
				dataType: "json",
				params: params,
				successFunc: (result) => {
					console.log("data: ", result);

					showDialog(
						Util.translate("datatype-saved"),
						"Saved data type ID is " + result.dataTypeId,
						[
							{
								label: "OK"
							}
						],
						"sm"
					);

					if (!dataTypeIdState) {
						setDataTypeIdState(result.dataTypeId);
					}
					//window.location.href = backURL;
				},
				errorFunc: (a, b, c, d) => {
					console.log("ERROR: ", a, b, c, d);
				}
			});
		};

		const handleBtnEditDataStructureClick = () => {
			console.log("redirectTo: ", workbenchId);
			Util.redirectTo(
				workbenchURL,
				{
					namespace: workbenchNamespace,
					portletId: workbenchId,
					windowState: WindowState.NORMAL
				},
				{
					workingPortletName: PortletKeys.DATA_STRUCTURE_BUILDER,
					params: JSON.stringify({
						dataTypeId: dataTypeIdState
					})
				}
			);
		};

		const handleBtnDeleteClick = (e) => {};

		const buttons = [
			{
				id: Util.namespace(namespace, "btnSave"),
				label: Util.translate(editStatus.current),
				symbol: "disk",
				displayType: "secondary",
				onClick: handleBtnSaveClick
			},
			{
				id: Util.namespace(namespace, "btnDelete"),
				label: Util.translate("delete"),
				symbol: "trash",
				displayType: "secondary",
				onClick: handleBtnDeleteClick
			},
			{
				id: Util.namespace(namespace, "btnEditDataStructure"),
				label: Util.translate("edit-data-structure"),
				symbol: "file-template",
				displayType: "secondary",
				onClick: handleBtnEditDataStructureClick
			}
		];

		renderCount.current++;
		console.log("Render Count of the form: " + renderCount.current);

		const stringParam = new StringParameter({
			paramName: "testString",
			paramVersion: "1.0.0",
			paramType: ParamType.STRING,
			displayName: "Test String",
			required: true,
			localized: false,
			placeholder: "Test string",
			tooltip: "Test String Tooltip",
			multiLine: false,
			disabled: false,
			events: {
				fire: [Event.SX_FORM_FIELD_CHANGED],
				on: [Event.SX_PARAM_PROPERTY_CHANGED]
			},
			validation: {
				required: {
					value: true,
					message: `${DataTypeProperty.NAME} is required`
				},
				pattern: {
					value: ValidationRule.VARIABLE,
					message: "Invalid data type name"
				},
				min: {
					value: 3,
					message: "Should be at least 3"
				},
				max: {
					value: 32,
					message: "Should be shorter than 33"
				}
			},
			defaultValue: "",
			order: 1
		});

		const formId = namespace + "dataTypePropertiesForm";
		return (
			<ClayIconSpriteContext.Provider value={spritemapPath}>
				{stringParam.render(namespace, formId, languageId, null, null, "", {}, spritemapPath)}
				{header}
				{dataTypeIdState > 0 && (
					<div className="form-group">
						<SXLabeledText
							label={Util.translate("datatype-id")}
							text={dataTypeIdState}
							viewType="INLINE_ATTACH"
						/>
					</div>
				)}
				<ClayForm id={formId}>
					{formFields.current.map((field) => {
						if (field.paramName === DataTypeProperty.VISUALIZERS) {
							field.leftOptions = formData.current[field.paramName];
							if (field.leftOptions && field.leftOptions.length > 0) {
								field.rightOptions = availableVisualizers.current.filter((item) => {
									let included = false;
									field.leftOptions.every((option) => {
										if (option.id === item.id) {
											included = true;
											return false;
										}
										return true;
									});

									return !included;
								});
							} else {
								field.rightOptions = availableVisualizers.current;
							}

							console.log("visualizers: ", field.leftOptions, field.rightOptions);
						}

						let value;
						if (field.paramType !== ParamType.GROUP) {
							value = formData.current[field.paramName];
							if (Util.isEmpty(value)) {
								value = field.defaultValue;
							}
						} else {
							const members = field.members;
						}

						return (
							<SXFormField
								key={field.order}
								formId={formId}
								namespace={namespace}
								properties={field}
								value={value}
								spritemap={spritemapPath}
							/>
						);
					})}
				</ClayForm>
				<SXRow>
					<ClayButton.Group spaced>
						<SXButtonWithIcon
							type="button"
							id={Util.namespace(namespace, "btnSave")}
							label={Util.translate("save")}
							symbol={"disk"}
							onClick={handleBtnSaveClick}
							displayType={"secondary"}
						/>
						{dataTypeIdState > 0 ? (
							<>
								<SXButtonWithIcon
									id={Util.namespace(namespace, "btnEditDataStructure")}
									label={Util.translate("edit-data-structure")}
									symbol={"file-template"}
									displayType={"secondary"}
									onClick={handleBtnEditDataStructureClick}
								/>
								<SXButtonWithIcon
									id={Util.namespace(namespace, "btnDelete")}
									label={Util.translate("delete")}
									symbol={"trash"}
									displayType={"warning"}
									onClick={handleBtnDeleteClick}
								/>
							</>
						) : undefined}
					</ClayButton.Group>
				</SXRow>
			</ClayIconSpriteContext.Provider>
		);
	}
};

export default DataTypeEditor;
