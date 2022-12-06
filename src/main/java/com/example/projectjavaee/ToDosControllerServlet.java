package com.example.projectjavaee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import static java.lang.System.out;

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
        Principal principal = request.getUserPrincipal();
        request.setAttribute("username", principal.getName());
        String role = ToDosDBUtil.getRole(principal.getName());
        List<ToDos> ToDoss = ToDosDBUtil.getToDoss();
        request.setAttribute("ToDos_LIST", ToDoss);
        out.println(role);
        //Cookies
        Cookie [] cookies = request.getCookies();
        if(cookies!= null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("name"))
                    request.setAttribute("name", cookie.getValue()) ;
            }
        }
        else {
            Cookie cookieName = new Cookie("name", principal.getName());
            cookieName.setMaxAge(60*60*24) ; // in seconds, here for 24 hours
            response.addCookie(cookieName) ;
            /*Cookie cookieWork = new Cookie("role", role);
            cookieName.setMaxAge(60*60*24) ; // in seconds, here for 24 hours
            response.addCookie(cookieWork) ;*/
        }
        //Session
        HttpSession session = request.getSession();
        session.setAttribute("username", principal.getName());
        session.setAttribute("role", role);
        RequestDispatcher dispatcher;
        if(role.equals("instructor")) {
            dispatcher = request.getRequestDispatcher("/list-todos-instructor.jsp");
        }
        else{
            dispatcher = request.getRequestDispatcher("/list-todos.jsp");
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
