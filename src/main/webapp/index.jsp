<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Test Page</title>
</head>
<body>
	<h2>Hello World!</h2>

	<!-- 监听器：操作域属性  -->
	<a href="<c:url value='/ListenerServlet?method=contextOperation'/>">SevletContext操作属性</a>
	<br />
	<a href="<c:url value='/ListenerServlet?method=sessionOperation'/>">HttpSession操作属性</a>
	<br />
	<a href="<c:url value='/ListenerServlet?method=requestOperation'/>">ServletRequest操作属性</a>
	<br />

	<a href="<c:url value='/ListenerServlet?method=addPerson'/>">addPerson</a>
	<br />
	<a href="<c:url value='/ListenerServlet?method=removePerson'/>">removePerson</a>
	<br />

</body>
</html>
