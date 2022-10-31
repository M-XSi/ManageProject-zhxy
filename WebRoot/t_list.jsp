<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 't_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript">
       function delTeacher(id){
           window.location="<%=basePath%>teacher?req=delTeacher&t_id="+id;
       }
   </script>
  </head>
  
  <body>
    <table border="1" align="center" width="800px ">
      <tr height="50px" align="center"<x:if test="${vs.count%2==0}"> bgcolor="#73FBFD"</x:if>>
        <td width="100px">序号</td>
        <td width="100px">姓名</td>
        <td width="100px">登录名</td>
        <td width="100px">地址</td>
        <td width="100px">电话</td>
        <td width="100px">性别</td>
        <td width="100px">邮箱</td>
        <td width="100px">操作</td>
     </tr>
     <x:forEach var="t" items="${requestScope.t_list}" varStatus="vs">
     <tr height="50px" align="center" >
        <td width="100px"><x:out value="${vs.count}"></x:out></td>
        <td width="100px"><x:out value="${t.t_name}"></x:out></td>
        <td width="100px"><x:out value="${t.t_login}"></x:out></td>
        <td width="100px"><x:out value="${t.t_address}"></x:out></td>
        <td width="100px"><x:out value="${t.t_tel}"></x:out></td>
        <td width="100px"><x:out value="${t.t_sex}"></x:out></td>
        <td width="100px"><x:out value="${t.t_email}"></x:out></td>
        <td>
          <input type="button" value="删除" onclick="delTeacher(${t.t_id})"/>        
        </td>
     </tr>
     </x:forEach>
    </table>
  </body>
</html>
