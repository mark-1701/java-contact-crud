package config;

import java.sql.*;

public class Access {
    java.sql.Connection con;
    String url="jdbc:mysql://localhost:3306/agenda";
    String user="root";
    String pass="12345";
    public java.sql.Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("err: " + e);
        }      
        return con;   
    }
}
