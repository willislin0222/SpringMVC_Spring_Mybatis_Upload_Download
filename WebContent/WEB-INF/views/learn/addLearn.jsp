<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>員工註冊</title>
</head>
<body>
    <h3>員工註冊</h3>    <br>
    <form method="post" action="${pageContext.request.contextPath}/learn/addLearn">
       <table>
           <tr>
               <td><label>NO：</label></td>
               <td><input type="text" name="no"></td>
           </tr>
           <tr>
               <td><label>NAME：</label></td>
               <td><input type="text" name="name"></td>
           </tr>
           <tr>
               <td><label>URL：</label></td>
               <td><input type="text" name="url"></td>
           </tr>
           <tr>
               <td><input type="submit" value="註冊"></td>
           </tr>
       </table>
    </form>
</body>
</html>