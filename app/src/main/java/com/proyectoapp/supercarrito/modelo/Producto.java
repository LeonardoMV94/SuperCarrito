package com.proyectoapp.supercarrito.modelo;

public class Producto {

    private String codigoBarras="";
    private String marca="";
    private String nombreo="";
    private int precio=0;
    private int cantidad=0;

    public Producto(){

    }

    public Producto(String codigoBarras, String marca, String nombreo, int precio, int cantidad) {
        this.codigoBarras = codigoBarras;
        this.marca = marca;
        this.nombreo = nombreo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombreo() {
        return nombreo;
    }

    public void setNombreo(String nombreo) {
        this.nombreo = nombreo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", marca='" + marca + '\'' +
                ", nombreo='" + nombreo + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}

