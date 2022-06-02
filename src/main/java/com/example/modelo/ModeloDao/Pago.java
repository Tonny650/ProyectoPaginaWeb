package com.example.modelo.ModeloDao;

public class Pago {
    private int id;
    private  double monto;


    public Pago(){

    }
    public Pago(int id, double monto ){
        this.id = id;
        this.monto = monto;
    }

    //--------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public double getMonto() {
        return monto;
    }
}
