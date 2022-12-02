package com.example.projectjavaee;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "EditToDosServlet", value = "/EditToDosServlet")
public class EditToDosServlet extends HttpServlet {
    private ToDosDBUtil toDosDBUtil;
    @Resource(name="jdbc/projetjavaee")
    private DataSource dataSource;
    int id;
    @Override
    public void init() throws ServletException {
        super.init();
        toDosDBUtil = new ToDosDBUtil(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id=Integer.parseInt(request.getParameter("toDosId"));
        ToDos toDos= toDosDBUtil.fetchToDos(id);
        request.setAttribute("ToDos", toDos);
        request.getRequestDispatcher("edit-todos.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description= request.getParameter("description");
        ToDos toDos = new ToDos(id,description);
        toDosDBUtil.updateToDos(toDos);
        response.sendRedirect("ToDosControllerServlet");
    }
}
