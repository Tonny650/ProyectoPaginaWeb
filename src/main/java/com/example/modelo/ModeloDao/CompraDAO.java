package com.example.modelo.ModeloDao;

import com.example.configuraciones.Conexion;
import com.example.modelo.Carrito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {
    Connection con;
    Conexion conexion = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public  int GenerarComra(Compra compra){
        int idcompras;
        String sql = "insert into compras(idCliente,FechaCompras,Monto,Estado,idPago) values (?,?,?,?,?)";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,compra.getCliente().getId());
            ps.setString(2, compra.getFecha());
            ps .setDouble(3,compra.getMonto());
            ps.setString(4,compra.getEstado());
            ps.setInt(5,compra.getIdpago());
            r = ps.executeUpdate();

            sql="select @@IDENTITY AS idCompras";
            rs=ps.executeQuery(sql);
            rs.next();
            idcompras = rs.getInt("idCompras");
            rs.close();

            for (Carrito detalle : compra.getDetallecmpras()){
                sql = "insert into detalle_compras(idProducto, idCompras, Cantidad, PrecioCompra) value ('?,?,?,?')";
                ps= con.prepareStatement(sql);
                ps.setInt(1,detalle.getIdProducto());
                ps.setInt(2, idcompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4,detalle.getPrecioCompra());
                r = ps.executeUpdate();
            }


        }catch (Exception e){

        }
        return r;
    }
}
