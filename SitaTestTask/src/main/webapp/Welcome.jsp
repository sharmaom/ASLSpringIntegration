<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
 body {background-color: yellow;}
h1   {color: ;}
p    {color: blue;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Integration Project></title>
</head>
<body>
<h1>
<table>
<tr>
<td>Spring Integration process has been triggered</td>
</tr>
<tr>
<td><h5>Input file location is ->> <spring:eval expression="@propertyConfigurer.getProperty('INPUT.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Output file location is ->> <spring:eval expression="@propertyConfigurer.getProperty('OUTPUT.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Process file location is ->> <spring:eval expression="@propertyConfigurer.getProperty('PROCESS.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Error file location is ->> <spring:eval expression="@propertyConfigurer.getProperty('ERROR.DIRECTORY')" /></h5></td>
</tr>
</table>

</h1>
</body>
</html>