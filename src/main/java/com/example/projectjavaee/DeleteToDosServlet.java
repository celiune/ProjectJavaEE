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

@WebServlet(name = "DeleteToDosServlet", value = "/DeleteToDosServlet")
public class DeleteToDosServlet extends HttpServlet {
    private ToDosDBUtil toDosDBUtil;
    @Resource(name="jdbc/projetjavaee")
    private DataSource dataSource;

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
        int id=Integer.parseInt(request.getParameter("toDosId"));
        toDosDBUtil.deleteToDos(id);
        response.sendRedirect("ToDosControllerServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
