<%@page import="com.sx.icecap.constant.WebPortletKey"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.sx.icecap.constant.WebKey"%>
<%@page import="com.sx.constant.StationXWebKeys"%>

<%@ include file="../../init.jsp" %>
<%
	long dataTypeId = ParamUtil.getString(renderRequest, WebKey.DATATYPE_ID, 0);
	
	String workspaceId = ParamUtil.getString(renderRequest, StationXWebKeys.WORKSPACE_ID, StringPool.BLANK);
	String workspaceNamespace = ParamUtil.getString(renderRequest, StationXWebKeys.WORKSPACE_NAMESPACE, StringPool.BLANK);
	
	System.out.println("dataTypeId: " + dataTypeId);
	System.out.println("workspaceId: " + workspaceId);
	System.out.println("workspaceNamespace: " + workspaceNamespace);
%>

<div id="<portlet:namespace />-root"></div>

<portlet:renderURL  var="baseRenderURL">
</portlet:renderURL>

<portlet:actionURL  var="baseActionURL">
</portlet:actionURL>

<portlet:resourceURL  var="baseResourceURL">
</portlet:resourceURL>

<aui:script require="<%=mainRequire%>">
	main.default(
		'<portlet:namespace />-root', 
		'<%=WebPortletKey.STRUCTURED_DATA_VIEWER%>', 
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
			params: { // initial parameters
				backURL: '<%= currentURL %>',
				workbenchURL: '<%= workbenchURL %>',
				workspaceId: '<%= workspaceId %>',
				workspaceNamespace: '<%= workspaceNamespace %>',
				dataTypeId: JSON.parse('<%= String.valueOf(dataTypeId) %>')
			}
		}
	);
</aui:script>