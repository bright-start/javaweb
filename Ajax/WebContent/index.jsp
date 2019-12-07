<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<input type="text" value="" id="name" /> 
	<input type="button" onclick="getData()" value="搜索" />
	<br/>
<!-- 	<div id="showdiv" style="width:140px;height:80px; border:1px solid black;">
	</div> --> 
	<table border="1px" id="ta">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>位置</td>
			<td>描述</td>
		</tr>
		<tbody id="tb"></tbody>
	</table>
	

<script type="text/javascript">
	function getData(){
		//创建ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest){//火狐
			ajax = new XMLHttpRequest();
		}else if(window.ActiveXObject){//ie
			ajax = new ActiveXObject("Msxm12.XMLHTTP")
		}
		//复写onreadstatement
		ajax.onreadystatechange=function(){
			//判断ajax状态码
 			if(ajax.readyState== 4){
 				//判断http状态码
				if(ajax.status == 200){ 
					//获取响应内容
					var result = ajax.responseText;
					eval("var hero="+result);
				 	alert(result); 
				 	var tb = document.getElementById("tb");
				 	tb.innerHTML = "";
				 	var tr = tb.insertRow(0);
				 	var cell0 = tr.insertCell(0);
				 	cell0.innerHTML = hero.id;
				 	var cell1 = tr.insertCell(1);
				 	cell1.innerHTML = hero.name;
				 	var cell2 = tr.insertCell(2);
				 	cell2.innerHTML = hero.price;
				 	var cell3 = tr.insertCell(3);
				 	cell3.innerHTML = hero.position;
				 	var cell4 = tr.insertCell(4);
				 	cell4.innerHTML = hero.h_desc;
				 	

				 	
					//获取元素对象
					var showdiv = document.getElementById("showdiv");
					showdiv.innerHTML=result;
 				}else if(ajax.status == 404){
					//获取元素对象
					var showdiv = document.getElementById("showdiv");
					showdiv.innerHTML="请求资源不存在";
				}else if(ajax.status == 500){
					//获取元素对象
					var showdiv = document.getElementById("showdiv");
					showdiv.innerHTML="服务器繁忙";
				} 
 			}else{
 				var showdiv = document.getElementById("showdiv");
 				showdiv.innerHTML="<img src='images/loading.gif' style='width:120px;height:80px' />"
 			}	 
		}
		
  		var uname = document.getElementById("name").value;
  		alert(uname);
		//发送请求 get
		var url = "AjaxServlet?name="+encodeURI(encodeURI(uname));
    	ajax.open("get",url);
		ajax.send(null);  
		//发送请求 post
/*    		ajax.open("post","AjaxServlet");
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		ajax.send("name='站点'&pwd=1234");    */
	}

</script>
</body>
</html>