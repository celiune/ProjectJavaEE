<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 25/11/2022
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new ToDo</title>
</head>
<body>
<h1>Add a new ToDo</h1>
<form name="myForm" action="AddToDosControllerServlet" method="post">
    <table>
        <tbody>
        <tr>
            <td>Description: </td>
            <td><input type="text" name="description" value="" size="50"></td>
        </tr>

        </tbody>
    </table>

    <input type="reset" value="Cancel" name="cancel">
    <input type="submit" value="Save" name="save">

</form>

<a href="ToDosControllerServlet">Back to list</a>
</body>
</html>
