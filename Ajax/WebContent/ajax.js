/**
 * 
 */

function testAjax(method,url,data,deal200,deal404,deal500,async){
    //创建ajax引擎对象
    var  ajax;
    if(window.XMLHttpRequest){
    	ajax=new XMLHttpRequest();
    }else if(window.ActiveXObject){
    	ajax=new ActiveXObject("Msxml2.XMLHTTP");
    }
    //复写onreadystatechange函数
    ajax.onreadystatechange=function(){
       //判断ajax状态码
       if(ajax.readyState==4){
          //判断响应状态码
          if(ajax.status==200){
             //获取响应信息
             var dd=ajax.responseText;
             //处理响应信息
             if(deal200){
               deal200(dd);
             }

          }else if(ajax.status==404){
             if(deal404){
               deal404();
             } 
          }else if(ajax.status==500){
             if(deal500){
               deal500();
             } 
          }else{
             alert("未知错误，无效的ajax响应数据");
          } 
       }
    } 
    if("get"==method.toLowerCase()){
    	//toLowerCase()转换为小写
    	           //创建请求
            ajax.open(method, url+(data==null?"":"?"+data), async);
            //发送请求
            ajax.send(null);
        }else if("post"==method.toLowerCase()){
           ajax.open("post", url, async);
           ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
           ajax.send(data);
        } 
     }