<%@ page language="java" import="java.util.*,com.jspsmart.upload.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int count = 0;
	SmartUpload mySmartUpload = new SmartUpload();
	mySmartUpload.initialize(pageContext);
	try{
		//禁止上传的文件
		mySmartUpload.setDeniedFilesList("exe,jsp,asp");
		//拒绝物理路径
		mySmartUpload.setDenyPhysicalPath(true);
		//设置允许上传文件最大为50000bytes
		mySmartUpload.setMaxFileSize(50000);
		//一次上传文件大小最多不超过5000000bytes
		mySmartUpload.setTotalMaxFileSize(5000000);
		
		mySmartUpload.upload();
		for(int i = 0; i < mySmartUpload.getFiles().getCount(); i++){
			File myFile = mySmartUpload.getFiles().getFile(i);
			String fileName = myFile.getFileName();
			System.out.println("文件名："+fileName);
		}
		count = mySmartUpload.save("/upload");
		out.println(count+"文件已上传");
	}catch(Exception e){
		out.print(e.getMessage());
		
	}
%>
</body>
</html>