<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sx.icecap.constant.WebPortletKey"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.sx.icecap.constant.WebKey"%>
<%@page import="com.sx.constant.StationXWebKeys"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@clayui/css/lib/css/atlas.css">
<%@ include file="../../init.jsp" %>
<%
	long dataTypeId = ParamUtil.getLong(renderRequest, WebKey.DATATYPE_ID, 0);
	
	String workbenchNamespace = ParamUtil.getString(renderRequest, StationXWebKeys.WORKBENCH_NAMESPACE, StringPool.BLANK);
	String workbenchId = ParamUtil.getString(renderRequest, StationXWebKeys.WORKBENCH_ID, StringPool.BLANK);
	
	String portalURL = PortalUtil.getPortalURL(renderRequest);
	
	System.out.println("workbenchNamespace: " + workbenchNamespace);
	System.out.println("workbenchId: " + workbenchId);
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

<aui:script require="<%=mainRequire%>">
	main.default(
		'<portlet:namespace />-root', 
		'<%=WebPortletKey.DATA_STRUCTURE_VIEWER%>', 
		{
			namespace: '<portlet:namespace/>',
			dafaultLanguageId: '<%= defaultLocale.toLanguageTag() %>',
			languageId: '<%= locale.toLanguageTag() %>',
			availableLanguageIds: '<%= String.join( ",", locales.toArray(new String[0]) ) %>'.split(','), 
			portalURL: '<%= portalURL %>', 
			contextPath: '<%= contextPath %>',
			spritemapPath: '<%= contextPath %>/asset/images/icons.svg',
			portletId: '<%= portletDisplay.getId() %>',
			imagePath: '<%= contextPath %>/asset/images/',
			plid: '<%= themeDisplay.getPlid() %>',
			baseRenderURL: '<%=  baseRenderURL %>',
			baseActionURL: '<%=  baseActionURL %>',
			baseResourceURL: '<%=  baseResourceURL %>',
			params: { // initial parameters
				backURL: '<%= currentURL %>',
				workbenchURL: '<%= workbenchURL %>',
				workbenchId: '<%= workbenchId %>',
				workbenchNamespace: '<%= workbenchNamespace %>',
				dataTypeId: JSON.parse('<%= String.valueOf(dataTypeId) %>')
			}
		}
	);
</aui:script>