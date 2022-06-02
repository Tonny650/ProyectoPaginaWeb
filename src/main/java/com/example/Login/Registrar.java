package com.example.Login;

import com.example.configuraciones.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registrar {
    private String userName,email,password,phoneNumber,address;
    private Connection connection;
    private Conexion conexion = new Conexion();
    private boolean validacion; private String id;



    public boolean verificar(String mail){
        String sql = "select * from cliente where Email = ?";
        connection = conexion.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,mail);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                setValidacion(true);
                setId(rs.getString(1));
            }else {
                setValidacion(false);
            }

        }catch (Exception e){
            setValidacion(false);
        }
        return getValidacion();
    }
    public void Registrar(){
        connection = conexion.getConnection();
        String sql = "INSERT INTO cliente(Telefono,Nombres,Direccion,Email,Password) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,this.phoneNumber);
            ps.setString(2,this.userName);
            ps.setString(2,this.address);
            ps.setString(2,this.email);
            ps.setString(2,this.password);
            ps.executeUpdate();
            verificar(this.email);
        }catch (Exception e){}

    }



    /*___Metodos Setters y Getters_____*/
    private void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }
    private boolean getValidacion() {
        return validacion;
    }
    private void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
