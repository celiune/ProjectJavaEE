package com.example.projectjavaee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersControllerServlet", value = "/UsersControllerServlet")
public class UsersControllerServlet extends HttpServlet {

    private UsersDBUtil usersDBUtil;
    private DataSource dataSource;

    public UsersControllerServlet(){
        super();
    }

    private DataSource getDataSource() throws NamingException{
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
            usersDBUtil = new UsersDBUtil(dataSource);
        }
        catch (NamingException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            listUsers(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        List<Users> users = usersDBUtil.getUsers();
        request.setAttribute("USER_LIST", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
