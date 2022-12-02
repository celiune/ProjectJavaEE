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
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
