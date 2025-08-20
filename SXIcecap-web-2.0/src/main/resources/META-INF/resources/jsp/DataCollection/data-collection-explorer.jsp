<%@page import="com.sx.icecap.constant.DisplayStyle"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.sx.util.SXPortalUtil"%>
<%@page import="com.sx.icecap.constant.WebKey"%>
<%@page import="com.sx.icecap.constant.WebPortletKey"%>
<%@page import="com.sx.icecap.constant.MVCCommand"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@page import="java.util.List"%>
<%@ include file="../../init.jsp" %>

<%
	JSONArray permissions = (JSONArray)renderRequest.getAttribute("permissions");
	int start = GetterUtil.getInteger(renderRequest.getAttribute(StationXWebKeys.START), StationXConstants.DEFAULT_START);
	int end = GetterUtil.getInteger(renderRequest.getAttribute(StationXWebKeys.END), StationXConstants.DEFAULT_END);
	int delta = GetterUtil.getInteger(renderRequest.getAttribute(StationXWebKeys.DELTA), StationXConstants.DEFAULT_DELTA);
	int status = GetterUtil.getInteger(renderRequest.getAttribute(StationXWebKeys.STATUS), WorkflowConstants.STATUS_APPROVED);
	String orderCol = GetterUtil.getString(renderRequest.getAttribute(StationXWebKeys.ORDER_BY_COL), Field.MODIFIED_DATE);
	String orderType = GetterUtil.getString(renderRequest.getAttribute(StationXWebKeys.ORDER_BY_TYPE), StationXConstants.ASC);
	String navigation = GetterUtil.getString(renderRequest.getAttribute(StationXWebKeys.NAVIGATION), StationXConstants.NAVIGATION_MINE);
	String  keywords = GetterUtil.getString(renderRequest.getAttribute(StationXWebKeys.KEYWORDS), StringPool.BLANK);
	
	String workbenchNamespace = ParamUtil.getString(renderRequest, StationXWebKeys.WORKBENCH_NAMESPACE, StringPool.BLANK);
	String workbenchId = ParamUtil.getString(renderRequest, StationXWebKeys.WORKBENCH_ID, StringPool.BLANK);
	
	String portalURL = PortalUtil.getPortalURL(renderRequest);
	
	System.out.println("workbenchNamespace: " + workbenchNamespace);
	System.out.println("workbenchId: " + workbenchId);
	System.out.println("permissions: " + permissions.toString());
%>

<div id="<portlet:namespace />-root"></div>

<portlet:renderURL  var="baseRenderURL">
</portlet:renderURL>

<portlet:actionURL  var="baseActionURL">
</portlet:actionURL>

<portlet:resourceURL  var="baseResourceURL">
</portlet:resourceURL>

<liferay-portlet:renderURL portletName="<%=workbenchId%>"  var="workbenchURL"  windowState="<%=LiferayWindowState.NORMAL.toString()%>">
</liferay-portlet:renderURL>

<aui:script require="<%=mainRequire%>" >
	console.log('explorer excuted...');

	main.default(
		'<portlet:namespace />-root', 
		'<%=WebPortletKey.DATA_COLLECTION_EXPLORER%>', 
		{
			namespace: '<portlet:namespace/>',
			dafaultLanguageId: '<%= defaultLocale.toLanguageTag() %>',
			currentLanguageId: '<%= locale.toLanguageTag() %>',
			availableLanguageIds: '<%= String.join( ",", locales.toArray(new String[0]) ) %>', 
			portalURL: '<%= portalURL %>', 
			contextPath: '<%= contextPath %>',
			spritemapPath: '<%= contextPath %>/asset/images/icons.svg',
			portletId: '<%= portletDisplay.getId() %>',
			imagePath: '<%= contextPath %>/asset/images/',
			plid: '<%= themeDisplay.getPlid() %>',
			baseRenderURL: '<%=  baseRenderURL %>',
			baseActionURL: '<%=  baseActionURL %>',
			baseResourceURL: '<%=  baseResourceURL %>',
			permissions: JSON.parse('<%= permissions.toJSONString() %>'),
			params: { // initial parameters
				start: Number('<%= start %>'),
				delta: Number('<%= delta %>'),
				groupId: themeDisplay.getScopeGroupId(),
				userId: themeDisplay.getUserId(),
				status: Number('<%= status %>'),
				navigation: '<%= navigation %>',
				sortCol: '<%= orderCol %>',
				sortType: '<%= orderType %>',
				keywords: '<%= keywords %>',
				viewType: '<%= DisplayStyle.TABLE %>',
				notFoundImgSrc: '<%= contextPath %>/asset/images/not-found.png',
				backURL: '<%= currentURL %>',
				workbenchURL: '<%= workbenchURL %>',
				workbenchNamespace: '<%= workbenchNamespace %>',
				workbenchId: '<%= workbenchId %>',
			}
		}
	);
	
</aui:script>