<%--
  Created by IntelliJ IDEA.
  User: celin
  Date: 02/12/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
    <title>Edit a ToDo</title>
</head>
<body>
<div id="container">
    <form action="EditToDosServlet" method = "post">
        <h1>Edit a ToDo</h1>
        <div class="row">
            <p>Description: </p>
            <input type="text" name="description" size="50"
                      rows="5" cols="30" value="${ToDos.description}">
        </textArea>
        </div>
        <input type="submit" value="Save" name="save">
    </form>
    <div style="clear:both;"></div>
    <a href="ToDosControllerServlet">Back to List</a>
</div>
</body>
</html>