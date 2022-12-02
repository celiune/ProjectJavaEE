<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 02/12/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Edit a ToDo</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>SG ToDos</h2>
    </div>
</div>
<div id="container">
    <h3> Edit a ToDo</h3>
    <form action="EditToDosServlet" method = "post">
        <table>
            <tbody>
            <tr>
                <td><label>Description: </label> </td>
                <td><input type="text" name = "description" value="${ToDos.description}"/></td>
            </tr>
            <tr>
                <td><label></label> </td>
                <td><input type="submit" value = "Save"/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear:both;"></div>
    <a href="ToDosControllerServlet">Back to List</a>
</div>
</body>
</html>