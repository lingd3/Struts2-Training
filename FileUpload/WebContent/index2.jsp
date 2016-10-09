<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Your Files</title>
</head>
<body>
	<s:form action="multiUpload" method="post" enctype="multipart/form-data">
		<s:file label="select file1" name="uploads" />
		<s:file label="select file2" name="uploads" />
		<s:file label="select file3" name="uploads" />
		<s:submit value="Upload" />
	</s:form>
</body>
</html>


















