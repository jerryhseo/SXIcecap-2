<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sx.util.SXPortalUtil"%>
<%@page import="com.sx.constant.StationXPortletKeys"%>
<%@page import="com.sx.icecap.constant.WebPortletKey"%>
<%@page import="com.sx.icecap.constant.WebKey"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@ include file="../../init.jsp" %>

<%
	String dataType = (String)GetterUtil.getObject(renderRequest.getAttribute(WebKey.DATATYPE), StringPool.BLANK);

	long dataTypeId = ParamUtil.getLong(renderRequest, WebKey.DATATYPE_ID, 0);

	String dataTypeEditorPortletId = WebPortletKey.DATATYPE_EDITOR + "_INSTANCE_" + SXPortalUtil.generatePortletInstanceId();
%>

<div id="<portlet:namespace/>-root"></div>

<liferay-portlet:renderURL portletName="<%=dataTypeEditorPortletId%>" var="dataTypeEditorURL"  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<liferay-portlet:param name="<%=WebKey.DATATYPE_ID%>" value="<%= String.valueOf(dataTypeId) %>"/>
	<liferay-portlet:param name="<%= StationXWebKeys.BACK_URL %>" value="<%= backURL %>"/>
</liferay-portlet:renderURL>

<aui:script>
	$.ajax({
		url: '<%= dataTypeEditorURL %>',
		success: function(data) {
			$('#<portlet:namespace/>-root').html(data);
		},
		error: function(jqXHR, a, b){
			console.log('Loading Visualizer FAILED: ', a, b);
		}
	});
	
</aui:script>