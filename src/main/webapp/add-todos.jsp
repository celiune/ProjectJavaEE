<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 25/11/2022
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<html>
<head>
    <title>Add a new ToDo</title>
</head>
<body>
<div id="container">

<form name="myForm" action="AddToDosControllerServlet" method="post">
    <h1>Add a new ToDo</h1>
    <div class="row">
        <p>Description: </p>
        <textarea type="text" name="description" value="" size="50"
                  rows="5" cols="30"
                  minlength="10" maxlength="30">
        </textArea>
    </div>


    <input type="reset" value="Cancel" name="cancel">
    <input type="submit" value="Save" name="save">

</form>

<a href="ToDosControllerServlet">Back to list</a>
    </div>
</body>
</html>
