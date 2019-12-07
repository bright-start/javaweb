/**
 * Ajax的封装
 */
function ajax(options){
	
	var ajax = null;
	
	var params = formsParams(options.data);
	
	//创建对象
	if(window.XMLHttpRequest){
		ajax = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		ajax = new ActionXObject("Msxm12.XMLHTTP");
	}
	//连接
	if(option.type == "GET"){
		ajax.open(options.type,options.uri==null?"":+"?"+params,options.async)
		ajax.send(null);
	}else if(option.type == "POST"){
		ajax.open(option.type,uri,async);
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded" );
		ajax.send(params);
	}
	ajax.onreadystatechange = function(){
		if(ajax.readyState == 4){
			if(ajax.status == 200){
				options.success(ajax.responseText);
			}else if(ajax.status == 404){
				
			}else if(ajax.status == 500){
				
			}
		}else{
			
		}
	}
	function formsParams(data){
		var arr = [];
		for(var prop in data){
			arr.push(prop +"="+data[prop]);
		}
		return arr.join("&");
	}
}
ajax({
	url : "",
	type : "",
	async : "",
	data : {
		name : "",
		age : ""	
	},
	success : function(data){  //返回接受信息
		
	}
})