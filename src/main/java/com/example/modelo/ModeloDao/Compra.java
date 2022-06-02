package com.example.modelo.ModeloDao;

import com.example.modelo.Carrito;

import java.util.List;

public class Compra {
    private int id, idpago;
    private String fecha, estado;
    private double monto;
    private Cliente cliente;

    private List<Carrito>detallecmpras;

    public Compra() {
    }

    public Compra(Cliente cliente, int idpago, String fecha, double monto, String estado, List<Carrito> detallecmpras) {
        this.cliente = cliente;
        this.idpago = idpago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.detallecmpras = detallecmpras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public List<Carrito> getDetallecmpras() {
        return detallecmpras;
    }

    public void setDetallecmpras(List<Carrito> detallecmpras) {
        this.detallecmpras = detallecmpras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
