<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta property="og:type" content="website" />
<meta property="og:title" content="Your Website Title" />
<meta property="og:description" content="Your description" />
<meta property="og:image"
	content="https://www.your-domain.com/path/image.jpg" />
<spring:url value="/" var="urlHome" />
<spring:url value="/home.jsp" var="homeUrl" />
<spring:url value="/books" var="bookUrl" />
<!--Bootstrap  -->
<spring:url
	value="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	var="jquery112" />
<spring:url value="/assets/lib/js/jquery-ui.js" var="jqueryUi" />
<spring:url value="/assets/css/font-awesome.min.css" var="frontAwesome" />
<spring:url value="/assets/mycss/style.css" var="style" />
<spring:url value="/assets/mycss/style1.css" var="style1" />
<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/js/autocomplete/autocomplete.js" var="myjs" />
<spring:url value="/assets/js/header/request.js" var="requestJs" />
<spring:url value="/assets/ckeditor/ckeditor.js" var="CkeditorJs" />
<spring:url value="/assets/ckeditor/displayCkeditor.js"
	var="displayCkeditorJs" />
<spring:url value="/assets/js/comment_facebook/jquery.comment.js"
	var="commentFacebookJs" />
<spring:url value="/assets/lib/js/jquery.timeago.js" var="timeagoJs" />
<spring:url value="/assets/lib/js/sockjs.min.js" var="sockjs" />
<spring:url value="/assets/lib/js/stomp.js" var="stompJs" />
<spring:url value="/assets/lib/js/stomp.min.js" var="stompMinJs" />
<spring:url value="/assets/lib/js/jquery-1.12.4.js" var="jqueryJs" />
<spring:url value="/assets/js/notification.js" var="notificationJs" />

<script src="https://apis.google.com/js/platform.js" async='async'
	defer='defer'> </script>
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${frontAwesome}" />
<link rel="stylesheet" href="${style}" />
<link rel="stylesheet" href="${style1}" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />
<script> {"parsetags": "explicit"}</script>
<script src="${jqueryJs }" type="text/javascript"></script>
<script src="${jquery112 }" type="text/javascript"></script>
<script src="${jqueryUi }" type="text/javascript"></script>
<script src="${myjs }" type="text/javascript"></script>
<script src="${requestJs }" type="text/javascript"></script>
<script src="${CkeditorJs }" type="text/javascript"></script>
<script src="${displayCkeditorJs }" type="text/javascript"></script>
<script src="${commentFacebookJs }" type="text/javascript"></script>
<script src="${timeagoJs }" type="text/javascript"></script>
<script src="${sockjs }" type="text/javascript"></script>
<script src="${stompJs }" type="text/javascript"></script>
<script src="${stompMinJs }" type="text/javascript"></script>
<script src="${notificationJs }" type="text/javascript"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/mycss/style.css" var="style" />
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${style}" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div id="fb-root"></div>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />

</body>
</html>