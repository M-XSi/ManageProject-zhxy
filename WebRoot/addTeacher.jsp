<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addTeacher.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript">
   function t_name1(){
       var t_name=document.getElementById("t_name");
       if(t_name.value=="请输入姓名"){
           t_name.value="";
           t_name.style.color="#000000";
       }
   }
   function t_name2(){
       var t_name=document.getElementById("t_name");
       if(t_name.value=="请输入姓名"){
           t_name.value="";
           t_name.style.color="#999999";
       }
   }
      function t_login1(){
       var t_login=document.getElementById("t_login");
       if(t_login.value=="请输入登录名"){
           t_login.value="";
           t_login.style.color="#000000";
       }
   }
    function t_login2() {
	    var sbmt = document.getElementById("sbmt");
		var t_login = document.getElementById("t_login");
		if(t_login.value == "") {
			t_login.value="请输入用户名";
			t_login.style.color="#999999";
		} else {
				var i = checkLogin();
				var j = checkPwd();
				if(i==1&&j==1) {
					sbmt.disabled = false;
				}else{
				    sbmt.disabled = true;
				}
			}
		}
		function t_pwd1() {
			var sbmt = document.getElementById("sbmt");
			var i = checkLogin();
			var j = checkPwd();
			if(i==1&&j==1) {
			    sbmt.disabled = false;
			}else{
				sbmt.disabled = true;
			}
		}
		function pwd2(){
		    var t_pwd=document.getElementById("t_pwd");
		    if(t_pwd.value==""){
		        t_pwd.type="text";
		        t_pwd.value="请输入密码";
		        p_pwd.style.color="#999999";
		    }
		}
		function pwd3(){
		    var t_pwd=document.getElementById("t_pwd");
		    var btn=document.getElementById("btn");
		    if(btn.value=="显示"){
		        t_pwd.type="text";
		        btn.value="隐藏";
		        
		    }else if(btn.value=="隐藏"){
		        t_pwd.type="passsword";
		        btn.value="显示";
		    }
		}   
   		function checkLogin() {
			var sbmt = document.getElementById("sbmt");
			var t_login=document.getElementById("t_login");
			var i = 0;
			if(t_login.value.length > 5 && t_login.value.length < 17) {
				t_login.style.borderColor = "#00ff00";
				i = 1;
			} else {
				t_login.style.borderColor = "#ff0000";
			}
			return i;
		}
		function checkPwd() {
			var sbmt = document.getElementById("sbmt");
			var t_pwd=document.getElementById("t_pwd");
			var i = 0;
			if(t_pwd.value.length > 5 && t_pwd.value.length < 17) {
				t_pwd.style.borderColor = "#00ff00";
				i = 1;
			} else {
				t_pwd.style.borderColor = "#ff0000";
			}
			return i;
		}
		function changeType(){
		    var changeBtn = document.getElementById("changeBtn");
		    var t_pwd = document.getElementById("t_pwd");
		    if (changeBtn.value=="显示"){
		        t_pwd.type="text";
		        changeBtn.value="隐藏";
		    }else{
		        t_pwd.type="password";
		        changeBtn.value="显示";
		    }
		}


  </script>
  </head>
  
  <body>
  <form method="post" action="<%=basePath %>teacher" >
  <input type="hidden"name="req" value="addTeacher"/>
    <table border="1" width="400px" height="400px" align="center"> 
        <tr height="50px" align="center">
            <td width="100px">姓名</td>
            <td width="300px">
             <input type="text" name="t_name" id="t_name" value="请输入姓名" style="color:#999999;"onfocus="t_name1()" onblur="t_name2()"/>
            </td>
            
        </tr>
        <tr height="50px" align="center">
            <td width="100px">登录名</td>
            <td width="300px">
            <input type="text" name="t_login" id="t_login"value="请输入登录名" onkeyup="checkLogin()"style="color:#999999;" onfocus="t_login1()" onblur="t_login2()"/>
            </td>
        </tr>
        <tr height="50px" align="center">
            <td width="100px">登录密码</td>
            <td width="300px">
             <input type="text" name="t_pwd" id="t_pwd"onkeyup="checkPwd()" onblur="t_pwd1()" />
             <input type="button" id="changeBtn" onclick="changeType()"value="显示"/>
            </td>
        </tr>
        <tr height="50px" align="center">
            <td width="100px">地址</td>
            <td width="300px">
            <input type="text" name="t_address" id="t_address"/>
            </td>
            
        </tr>
        <tr height="50px" align="center">
            <td width="100px">电话</td>
            <td width="300px">
             <input type="text" name="t_tel" id="t_tel"/>
            </td>
        </tr>
        <tr height="50px" align="center">
            <td width="100px">性别</td>
            <td width="300px">
             <input type="radio" name="t_sex" value="男" />男
             <input type="radio" name="t_sex" value="女" checked="checked"/>女
            </td>
        </tr>
        <tr height="50px" align="center">
            <td width="100px">邮箱</td>
            <td width="300px">
             <input type="text" name="t_email" id="t_email"/>
            </td>
        </tr>
        <tr height="50px" align="center">
            <td width="400px" colspan="2">
            <input type="submit" value="提交" disabled="disabled" id="sbmt"/>
            <input type="reset" value="重置"/>
            </td>
        </tr>
        

      
    </table>
    </form>
  </body>
</html>
