package com.example.projectjavaee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToDosDBUtil {

    private DataSource dataSource;

    public ToDosDBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ToDos> getToDoss() throws Exception{
        List<ToDos> ToDoss = new ArrayList<ToDos>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM ToDos";
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()){
                int id = myRs.getInt("id");
                String description = myRs.getString("description");
                ToDos tempToDos = new ToDos(id,description);
                ToDoss.add(tempToDos);
            }
            return ToDoss;
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
