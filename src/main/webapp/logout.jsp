<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 02/12/2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/login.css" media="screen" type="text/css" />

<html>
<META HTTP-EQUIV = "Pragma" CONTENT="no-cache">
<title>Logout Page </title>
<body>
<div id="container">

<FORM METHOD=POST ACTION="LogoutControllerServlet" NAME="logout">
  <h2>Sample Form Logout</h2>
  <p>
    <strong> Click this button to log out: </strong>
    <input type="submit" name="logout" value="Logout">
  </p>
</form>
</div>
</body>
</html>
