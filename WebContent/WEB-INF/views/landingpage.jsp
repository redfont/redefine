<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="redefine">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/ng-material/angular-material.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ng-material-icon.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app-style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app-override.css">
	
	<script type="text/javascript">
		
		var context = '<%=request.getContextPath()%>';
		
		function endsWith(str, suffix) {
		    return str.indexOf(suffix, str.length - suffix.length) !== -1;
		}
		
		if (endsWith(window.location.href, "/redefine")) {
			window.location.href += "/";
		}
		
	</script>
	</head>
	<body>
	 <div ng-controller="RootController as vm">
			<jsp:include page="common/header.jsp"/>
			<jsp:include page="common/menu.jsp"/>
			<div ng-view></div>
			<jsp:include page="common/footer.jsp"/>
		</div>
	</body>
	
	<!-- angular -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng/angular.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng/angular-route.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng/angular-animate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng/angular-aria.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng/angular-messages.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ng-material/angular-material.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/app.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/routing.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/root.controller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/auth.controller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/user.controller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/category.controller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/contactType.controller.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/app/controllers/prospect.controller.js"></script>
</html>