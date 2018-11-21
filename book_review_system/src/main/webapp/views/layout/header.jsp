<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--parameter url  -->
<spring:url value="/books" var="bookUrl"></spring:url>
<spring:url value="/" var="homeUrl"></spring:url>
<spring:url value="/login" var="loginUrl"></spring:url>
<spring:url value="/requestBook" var="requestUrl"></spring:url>
<spring:url value="/assets/img/bookstor_compact.png" var="icon" />
<header class="header-pos sticky-top">
	<!-- header-bottom-area start -->
	<div class="header-bottom-area">
		<div class="container-fluid">
			<div class="inner-container">
				<div class="row">
					<div class="col-md-2 col-sm-4 col-xs-5">
						<div class="logo">
							<a href="${homeUrl}"><img src="${icon}" /></a>
						</div>
					</div>
					<div class="col-md-5 hidden-xs hidden-sm">
						<div class="main-menu">
							<nav>
								<ul>
									<li><a href="${homeUrl}">home</a></li>
									<li><a href="${bookUrl}">Book</a></li>
									<security:authorize access="isAnonymous()">
										<li><a id="alert">Request</a></li>
									</security:authorize>
									<security:authorize access="isAuthenticated()">
										<li><a href="${requestUrl }">Request</a></li>
									</security:authorize>
								</ul>
							</nav>
						</div>
					</div>
					<div class="col-md-3 hidden-xs hidden-sm">
						<div data-list-title="${titles }" id="list-title"></div>
						<spring:url value="Search" var="searchActionUrl" />
						<div data-list-category="${categories }" id="list-category"></div>
						<form class="navbar-form navbar-left" action="${searchActionUrl }"
							method="get">
							<div class="input-search">
								<ul>
									<li><input id="search" type="text" name="search"
										class="form-control" placeholder="Search"></li>
									<li>
										<button class="btn btn-search" type="submit">
											<i class="fa fa-search"></i>
										</button>
									</li>
								</ul>
							</div>
						</form>
					</div>
					<div class="col-md-2 col-sm-8 col-xs-7 header-right">
						<div class="user-meta">
							<security:authorize access="isAuthenticated()">
								<h4 class="text-primary">
									Welcome:
									<security:authentication property="principal.username" />
								</h4>
								<ul>
									<spring:url value="/profile" var="profile" />
									<li class="eborder-top"><a href="${profile}"><i
											class="icon_profile"></i> My Profile</a></li>
									<li>
										<form action="<c:url value='/j_spring_security_logout' />"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
											<button class="btn btn-primary btn-xs btn-block"
												type="submit">Log out</button>
										</form>
									</li>
								</ul>
							</security:authorize>
							<security:authorize access="isAnonymous()">
								<a href="${loginUrl}">Login Here</a>
							</security:authorize>
						</div>
						<security:authorize access="isAuthenticated()">
							<div class="row col-md-6 noti ">
								<a href="#" class="item-notification"> <i class="fa fa-bell"
									aria-hidden="true"></i> Notifications <i
									class="notification-size">${currentUser.getUnWatchedNotifications()}</i>
									<input type="text" class="currentUser" hidden
									value="${currentUser.getId() }" />
								</a>
								<ul role="menu" class="sub-menu notifications-body">
								</ul>
							</div>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>
</header>