<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 25/11/2022
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Web ToDos Tracker</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- ${ToDos_LIST}-->
<div id="wrapper">
    <div id="header">
        <h2>ESILV Engineer School</h2>
        <h2 name> Welcome ${username}</h2>
        <h2 work> ${role}'s page</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th> Id </th>
                <th> Description </th>
            </tr>
            <c:forEach var="tempToDos" items="${ToDos_LIST }" >
            <tr>
                <td> ${tempToDos.id}</td>
                <td> ${tempToDos.description}</td>
                </c:forEach>
        </table>
    </div>
    <form action="LogoutControllerServlet" method="get">
        <input class="add-student-button" type="submit" value="Logout"/>
    </form>

</div>
</body>
</html>