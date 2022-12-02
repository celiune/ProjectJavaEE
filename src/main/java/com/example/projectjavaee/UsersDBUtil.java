package com.example.projectjavaee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDBUtil {

    private DataSource dataSource;

    public UsersDBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Users> getUsers() throws Exception{
        List<Users> users = new ArrayList<Users>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM USERS ORDER BY username";
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                String username = myRs.getString("username");
                String password= myRs.getString("password");
                Users tempUser = new Users(username,password);
                users.add(tempUser);
            }
            return users;
        }
        finally {
            close(myConn,myStmt,myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs){
        try{
            if (myStmt!=null){
                myStmt.close();
            }
            if (myRs!=null){
                myRs.close();
            }
            if (myConn!=null){
                myConn.close();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}