package com.example.ck_so;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionP {
    private String Msj;
    private Connection connection;
    private String url = "jdbc:mysql//localhost:3306/cookies";
    private String user = "root";
    private String pass = "";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/cookies", "root", "");
            Msj = "exitoso";
        }catch (Exception e){
            Msj = e.toString();
        }
        return connection;
    }

    public String getMsj() {
        return Msj;
    }
}
