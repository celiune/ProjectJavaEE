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
                <th> Action </th>
            </tr>
            <c:forEach var="tempToDos" items="${ToDos_LIST }" >
            <c:url var="EditLink" value= "EditToDosServlet">
                <c:param name="toDosId" value="${tempToDos.id}"/>
            </c:url>
            <c:url var="DeleteLink" value= "DeleteToDosServlet" >
                <c:param name="toDosId" value="${tempToDos.id}"/>
            </c:url>
            <tr>
                <td> ${tempToDos.id}</td>
                <td> ${tempToDos.description}</td>
                <td> <a href="${EditLink}"> Edit </a>
                    <a href="${DeleteLink}"> Delete </a></td>
                </c:forEach>
        </table>
    </div>

    <form name = "BtnForm" action = "add-todos.jsp" method="post" >
        <button class="add-student-button">Add a ToDo</button>
    </form>
    <form action="LogoutControllerServlet" method="get">
        <input class="add-student-button" type="submit" value="Logout"/>
    </form>
</div>
</body>
</html>