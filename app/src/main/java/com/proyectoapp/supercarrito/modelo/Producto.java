package com.proyectoapp.supercarrito.modelo;

public class Producto {

    private String codigoBarras="";
    private String marcaProducto="";
    private String nombreProducto="";
    private int precioProducto=0;
    private int cantidadProducto=0;

    public Producto(){

    }

    public Producto(String codigoBarras, String marcaProducto, String nombreProducto, int precioProducto, int cantidadProducto) {
        this.codigoBarras = codigoBarras;
        this.marcaProducto = marcaProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}
