package com.company;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
    String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql:localhost:3306";
    String USER = "root";
    String PASSWORD = "root";
    String sql = "INSERT into ndroid.login (username,password) VALUE (?,?)";

    int i;

    public int registerUser(UserBeam userBeam) {
        String u = userBeam.getUserName();
        String p = userBeam.getPassword();

        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preS = connection.prepareStatement(sql);
            preS.setString(1,u);
            preS.setString(2,p);
            i = preS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }
}
