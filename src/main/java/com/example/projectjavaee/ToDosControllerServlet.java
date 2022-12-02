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

@WebServlet(name = "ToDosControllerServlet", value = "/ToDosControllerServlet")
public class ToDosControllerServlet extends HttpServlet {

    private ToDosDBUtil ToDosDBUtil;
    private DataSource dataSource;

    public ToDosControllerServlet(){
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
            ToDosDBUtil = new ToDosDBUtil(dataSource);
        }
        catch (NamingException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            listToDoss(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void listToDoss(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        List<ToDos> ToDoss = ToDosDBUtil.getToDoss();
        request.setAttribute("ToDos_LIST", ToDoss);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos-instructor.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
