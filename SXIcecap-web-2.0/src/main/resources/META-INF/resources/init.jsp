<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<!-- link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@clayui/css/lib/css/atlas.css" -->

<%
/*
	--- StationX reserved parameter definitions ---
	
	String contextPath: context path of the module
	String currentURL: the url for the current page
	String backURL: the previous page url
	Locale defaultLocale: default locale of the portal instance
	Locale locale: current locale of the site
	JSONArray locales: available locale of the portal instance
*/
String mainRequire = (String)renderRequest.getAttribute("mainRequire");
String contextPath = request.getContextPath();

String currentURL = themeDisplay.getURLCurrent();
String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL, "/");

Locale defaultLocale = PortalUtil.getSiteDefaultLocale(themeDisplay.getScopeGroupId());

Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();
List<String> locales = new ArrayList<>();
availableLocales.forEach( (loc) -> locales.add( loc.toLanguageTag()));
%>

