package com.example.projectjavaee;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "AddToDosControllerServlet", value = "/AddToDosControllerServlet")
public class AddToDosControllerServlet extends HttpServlet {
    private ToDosDBUtil toDosDBUtil;
    @Resource(name="jdbc/projetjavaee")
    private DataSource dataSource;
    int id;

    @Override
    public void init() throws ServletException {
        super.init();
        toDosDBUtil = new ToDosDBUtil(dataSource);
    }

    private DataSource getDataSource() throws NamingException {
        String jndi = "java:comp/env/jdbc/projetjavaee";
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup(jndi);
        return dataSource;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        toDosDBUtil.addToDos(description);
        response.sendRedirect("ToDosControllerServlet");

    }
}
