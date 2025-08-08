<%@page import="com.liferay.portal.kernel.portlet.PortletIdCodec"%>
<%@page import="com.sx.icecap.constant.MVCCommand"%>
<%@page import="com.sx.util.portlet.SXPortletURLUtil"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.sx.icecap.constant.WebPortletKey"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../../init.jsp" %>
 
<%
	String workingPortletName = ParamUtil.getString(
						renderRequest, 
						StationXWebKeys.WORKING_PORTLET_NAME, 
						WebPortletKey.DATATYPE_EXPLORER);
	String workingPortletId = PortletIdCodec.encode(workingPortletName);
	String workingPortletNamespace = "_" + workingPortletId + "_";
	
	String params = ParamUtil.getString(renderRequest, StationXWebKeys.PARAMS, "{}");
	
	String portalURL = PortalUtil.getPortalURL(renderRequest);
	
	
	
	System.out.println("workingPortletId: " + workingPortletId );
	System.out.println("workingPortletNamespace: " + workingPortletNamespace );
	System.out.println("workbenchId: " + portletDisplay.getId() );
	
	System.out.println("params: " + params );
%>

<div id="<portlet:namespace/>-root"></div>

<portlet:renderURL  var="baseRenderURL">
</portlet:renderURL>

<portlet:actionURL  var="baseActionURL">
</portlet:actionURL>

<portlet:resourceURL  var="baseResourceURL">
</portlet:resourceURL>

<liferay-portlet:renderURL portletName="<%=workingPortletName%>" var="workingPortletURL"  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
</liferay-portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommand.RESOURCE_CREATE_PORTLET_INSTANCE%>" var="createPortletURL" >
</portlet:resourceURL>

<aui:script require="<%=mainRequire%>">
	console.log('Data Workbench: ', '<%=workingPortletURL%>');
	
	main.default(
		'<portlet:namespace />-root', 
		'<%=WebPortletKey.DATA_WORKBENCH%>',
		{
			namespace: '<portlet:namespace/>',
			groupId: themeDisplay.getScopeGroupId(),
			userId: themeDisplay.getUserId(),
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
				workingPortletName: '<%= workingPortletName %>',
				workingPortletId: '<%= workingPortletId %>',
				workingPortletNamespace: '<%= workingPortletNamespace %>',
				workingPortletURL:'<%= workingPortletURL %>',
				workbenchNamespace: '<portlet:namespace/>',
				workbenchPortletId: '<%= portletDisplay.getId() %>',
				workingPortletParams: JSON.parse('<%= params %>')
			}
		});
</aui:script>