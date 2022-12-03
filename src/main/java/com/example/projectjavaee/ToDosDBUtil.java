package com.example.projectjavaee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


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
            out.println(e.getMessage());
        }
    }

    public ToDos fetchToDos(int id) {
        Connection myConn=null;
        Statement myStmt = null;
        ResultSet myRs= null;
        ToDos toDos=null;
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= "select * from todos where id="+id;
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()){
                String description=myRs.getString("description");
                toDos = new ToDos(id,description);
            }
            return toDos;
        }catch(Exception e){
            out.println(e.getMessage());
            return null;
        } finally{
            close(myConn,myStmt,myRs);
        }
    }

    public void addToDos(String description){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        try {
            myConn = dataSource.getConnection();
            String sql = "INSERT INTO todos (description) VALUES (?)";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, description);
            myStmt.execute();
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,null);
        }
    }

    public void updateToDos(ToDos toDos) {
        Connection myConn=null;
        PreparedStatement myStmt = null;
        try {
            myConn = dataSource.getConnection();
            String sql = "update todos set description=? where id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, toDos.getDescription());
            myStmt.setInt(2, toDos.getId());
            myStmt.execute();
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,null);
        }
    }

    public void deleteToDos(int id) {
        Connection myConn=null;
        Statement myStmt = null;
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql = "delete from todos where id=" + id;
            myStmt.execute(sql);
            out.println("Successfully deleted " + id );
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,null);
        }
    }

    public String getRole(String name) throws Exception{
        String role="";

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT role FROM roles where username='"+name+"';";
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()){
                role = myRs.getString("role");
            }
            return role;
        }
        finally {
            close(myConn,myStmt,myRs);
        }
    }

}
