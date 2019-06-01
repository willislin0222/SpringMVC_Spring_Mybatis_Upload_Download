<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头像</title>
</head>
<body>
<img src="${learnVO.weburl}">

<h3>檔案下載</h3>
<a href="${pageContext.request.contextPath}/learn/download?no=${learnVO.no}">
   ${filename}
</a>
</body>
</html>
</body>
</html>