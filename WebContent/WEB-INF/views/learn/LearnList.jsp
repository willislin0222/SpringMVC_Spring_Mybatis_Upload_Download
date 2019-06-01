<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>檔案列表 </title>
</head>
<body>
   <table border="1">
   	  <tr>
          <td>NO</td>
          <td>NAME</td>
          <td>顯示圖片</td>
          <td>下載檔案</td>
        </tr>   
      <c:forEach var="learnList"   items="${requestScope.learnList}">
        <tr>
          <td>${learnList.no}</a></td>
          <td>${learnList.name}</td>
          <td><img src=${learnList.weburl} width="300px"></td>
          <td><a href="${pageContext.request.contextPath}/learn/download?no=${learnList.no}">${filename}</td>
        </tr>                         
      </c:forEach>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}">返回首页</a>
</body>
</html>