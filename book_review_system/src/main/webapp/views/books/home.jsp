<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<!--start resource  -->
<spring:url value="/" var="urlHome" />
<spring:url value="/home.jsp" var="homeUrl" />
<spring:url value="/listAllBook.jsp" var="bookUrl" />
<spring:url value="/assets/img/slider/s1.jpg" var="imgSliderS1"></spring:url>
<spring:url value="/assets/img/slider/s2.png" var="imgSliderS2"></spring:url>
<spring:url value="/assets/img/slider/s3.png" var="imgSliderS3"></spring:url>
<spring:url value="/listAllBook.jsp" var="bookUrl" />
<!--end resource  -->
<!--start bootstrap  -->
<spring:url value="/assets/lib/css/nivo-slider.css" var="nivoSlider" />
<spring:url value="/assets/css/owl.carousel.css" var="owlCarousel" />
<spring:url value="/assets/css/font-awesome.min.css" var="frontAwesome" />
<spring:url value="/assets/mycss/style.css" var="style" />
<spring:url value="/assets/css/font-awesome.min.css" var="fontAwesome" />
<spring:url value="/assets/css/responsive.css" var="responsive" />

<spring:url value="/assets/lib/js/jquery.nivo.slider.pack.js"
	var="jqueryNivo" />
<spring:url value="/assets/lib/js/nivo-active.js" var="NivoActive" />
<link rel="stylesheet" href="${nivoSlider}" />
<link rel="stylesheet" href="${owlCarousel}" />
<%-- <link rel="stylesheet" href="${style}" /> --%>
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${fontAwesome}" />
<link rel="stylesheet" href="${responsive}" />
<!--end bootstrap  -->
</head>
<body>
	<div class="slider-container">
		<!-- Slider Image -->
		<div id="mainSlider" class="nivoSlider slider-image">
			<img src="${imgSliderS1 }" alt="main slider" title="#htmlcaption1" />
			<img src="${imgSliderS2 }" alt="main slider" title="#htmlcaption2" />
			<img src="${imgSliderS3 }" alt="main slider" title="#htmlcaption2" />
		</div>
		<!-- Slider Caption 1 -->
		<div id="htmlcaption1" class="nivo-html-caption slider-caption-1">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceInDown" data-wow-duration="0.9s"
						data-wow-delay="0s">
						<h3>beverage collection in 2018</h3>
					</div>
					<div class="cap-title wow bounceInRight" data-wow-duration="1.2s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceInUp" data-wow-duration="1.3s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Slider Caption 2 -->
		<div id="htmlcaption2" class="nivo-html-caption slider-caption-2">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceIn" data-wow-duration="0.7s"
						data-wow-delay="0s">
						<h3>trendy summer collection 2016</h3>
					</div>
					<div class="cap-title wow bounceIn" data-wow-duration="1s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceIn" data-wow-duration="1.1s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
		<div id="htmlcaption3" class="nivo-html-caption slider-caption-1">
			<div class="slider-progress"></div>
			<div class="slide1-text">
				<div class="middle-text">
					<div class="cap-dec wow bounceInDown" data-wow-duration="0.9s"
						data-wow-delay="0s">
						<h3>trendy summer collection 2016</h3>
					</div>
					<div class="cap-title wow bounceInRight" data-wow-duration="1.2s"
						data-wow-delay="0.2s">
						<h1>Top Book Review</h1>
					</div>
					<div class="cap-readmore wow bounceInUp" data-wow-duration="1.3s"
						data-wow-delay=".5s">
						<a href="#">Home</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<security:authorize access="isAuthenticated()">
		<div class="container">
			<div class="row">
				<h2 class="text-center">Your Activities</h2>
				<c:if test="${activityMsg != null}">
					<div class="alert alert-danger" role="alert">
						<span class="text-center">${activityMsg}</span>
					</div>
				</c:if>
				<c:if test="${activityMsg == null}">
					<table class="table">
						<thead>
							<tr>
								<th width="30%"></th>
								<th width="50%">Description</th>
								<th width="20%">Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${activities}" var="activity">
								<tr>
									<td></td>
									<td>${activity.note}</td>
									<td><time class="timeago" datetime="${activity.createdAt}">${activity.createdAt}</time></td>

								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<h2 class="text-center">Follower Activities</h2>
				<c:if test="${followerActivitiesMsg != null}">
					<div class="alert alert-danger" role="alert">
						<span class="text-center">${followerActivitiesMsg}</span>
					</div>
				</c:if>
				<c:if test="${followerActivitiesMsg == null}">
					<table class="table">
						<thead>
							<tr>

								<th width="30%">Follower Name</th>
								<th width="50%">Description</th>
								<th width="20%">Time</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${followerActivities}" var="followerActivity">
								<tr>
									<td>${followerActivity.user.fullName}</td>

									<td>${followerActivity.note}</td>
									<td><time class="timeago"
											datetime="${followerActivity.createdAt}">${activity.createdAt}</time></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</security:authorize>
</body>
<script src="${jquerymin }" type="text/javascript"></script>
<script src="${jqueryNivo }" type="text/javascript"></script>
<script src="${NivoActive }" type="text/javascript"></script>
<script>
	jQuery(document).ready(function() {
		jQuery("time.timeago").timeago();
	});
</script>
</html>
