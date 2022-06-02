package com.example.Login;

import com.example.configuraciones.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    Connection con;
    Conexion conexion = new Conexion();
    private boolean validacion;
    private String password, Email, id;

    public boolean getValidacion() {
        return validacion;
    }
    private void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getEmail() {
        return Email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    private void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public boolean ValidarUser(){
       //String sql = "select * from cliente where Email="+Email+" and Password="+password;
       try {
           con = conexion.getConnection();
           PreparedStatement ps = con.prepareStatement("select * from cliente where Email= ?and Password= ?");
           ps.setString(1, Email);
           ps.setString(2,password);
           ResultSet rs = ps.executeQuery();

           if (rs.next()){
               setValidacion(true);
               setId(rs.getString(1));
           }

       }catch (Exception e){
       }

        return getValidacion();
    }
}
