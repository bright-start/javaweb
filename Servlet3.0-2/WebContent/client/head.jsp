<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
//退出确认框
function confirm_logout() {   
    var msg = "您确定要退出登录吗？";   
    if (confirm(msg)==true){   
    return true;   
    }else{   
    return false;   
    }   
} 
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/autoplay.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" />
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath }/index.jsp">
					<img src="${pageContext.request.contextPath}/client/images/logo.png" width="200" height="60" border="0" /> 
				</a>
			</td>
			<td style="text-align:right">
				<img src="${pageContext.request.contextPath}/client/images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />
				   &nbsp;
				  <a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a> 
				| <a href="#">帮助中心</a> 
				| <a href="${pageContext.request.contextPath}/myAccount">我的帐户</a>
				| <c:if test="${empty user }">
					<a href="${pageContext.request.contextPath}/client/register.jsp">新用户注册</a>		
				|	<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>		
				</c:if>				
				<c:if test="${!empty user }">
				<a href="${pageContext.request.contextPath}/ExitServlet" onclick="javascript:return confirm_logout()">用户退出</a>
				<br><br><br>欢迎您： ${user.username}&nbsp&nbsp 当前在线人数：${applicationScope.count }
				</c:if>	
			</td>		
		</tr>
	</table>
</div>