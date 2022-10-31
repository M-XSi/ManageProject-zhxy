<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <form method="post" action="<%=basePath %>teacher?req=t_login" >
       <table border="1" width="400px" herght="300px" align="center">
         <tr height="100px" align="center">
          <td width="100px">登录名</td>
          <td width="300px">
           <input type="text" name="t_login"/>
          </td>
         </tr>
         <tr height="100px" align="center">
          <td width="100px">密码</td>
          <td width="300px">
           <input type="text" name="t_pwd"/>
          </td>
         </tr>
         <tr height="100px" align="center">
          <td colspan="2">
           <input type="submit" value="登录"/>
          </td>
         </tr>
        
       </table>
      </form>
  </body>
</html>
