<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/Servlet3.0-2/login" method="post">
		<!-- <input type="submit" value="提交"> -->
		<div>
			<p>账户<input type="text" name="username" placeholder="请输入用户名"></p><br>
			<p>密码<input type="password" name="password" placeholder="请输入密码"></p><br> 
			<table >
				<tr>自动登录</tr>
				<tr>
					<input type="radio" name="autologin" value="1" />一分钟
					<input type="radio" name="autologin" value="2"/>三分钟
					<input type="radio" name="autologin" value="3"/>五分钟
					<input type="radio" name="autologin" value="4"/>十分钟
				</tr>
			</table>
			<input type="reset" value="重置"/>
			<input type="submit" value="登录"/>
		</div>
		
	</form>
</body>
</html>