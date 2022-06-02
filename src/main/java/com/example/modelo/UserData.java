package com.example.modelo;

import com.example.configuraciones.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserData {
    private String userName,noTelefono,direccion,nameIcon;
    private Connection connectionSql;
    private Conexion conexion = new Conexion();



    public void ValidarUser(String id){
        try {
            connectionSql = conexion.getConnection();
            PreparedStatement ps = connectionSql.prepareStatement("select * from cliente where idCliente = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                noTelefono = rs.getString(2);
                userName = rs.getString(3);
                direccion = rs.getString(4);
            }

        }catch (Exception e){}
    }

    public String getNameIcon(String id) {
        ValidarUser(id);
        String[] lista = userName.split(" ");
        String[] leta = lista[0].split("");
        String name = "";
        for (int i = 0; i < leta.length; i++) {
            if (i == 0){
                name += leta[i].toUpperCase();
            }else {
                name += leta[i];
            }
        }
        nameIcon = name;

        return nameIcon;
    }

    public String getUserName() {
        return userName;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public String getDireccion() {

        return direccion;
    }
}
