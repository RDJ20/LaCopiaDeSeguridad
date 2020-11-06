package com.example.cartera;

public class ListElement {
    public float cantidad;
    public String metodo;
    public String fecha;
    public String hora;
    public String categoria;
    public String descripcion;

    public ListElement(float cantidad, String metodo, String fecha, String hora, String categoria, String descripcion) {
        this.cantidad = cantidad;
        this.metodo = metodo;
        this.fecha = fecha;
        this.hora = hora;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
