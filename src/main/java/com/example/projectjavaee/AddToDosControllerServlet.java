package com.example.projectjavaee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.System.out;

@WebServlet(name = "AddToDosControllerServlet", value = "/AddToDosControllerServlet")
public class AddToDosControllerServlet extends HttpServlet {

    private ToDosDBUtil todosDBUtil;

    private DataSource dataSource;

    public AddToDosControllerServlet(){
        super();
    }

    private DataSource getDataSource() throws NamingException {
        String jndi = "java:comp/env/jdbc/projetjavaee";
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup(jndi);
        return dataSource;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try{
            dataSource = getDataSource();
            todosDBUtil = new ToDosDBUtil(dataSource);
        }
        catch (NamingException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try{
            dataSource = getDataSource();
            myConn = dataSource.getConnection();
            String sql = "INSERT INTO todos (description) VALUES (?)";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, description);
            myStmt.execute();
            out.println("New ToDo added");
            response.sendRedirect("ToDosControllerServlet");
        }
        catch (Exception e){
            out.println(e.getMessage());
        }

    }
}
