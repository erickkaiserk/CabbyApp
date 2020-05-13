package com.example.cabbyapp.Modelo;

public class Conductor {

    String id;
    String nombre;
    String correo;
    String marcaVehiculo;
    String patenteVehiculo;
    String lineaVehiculo;

    public Conductor(String id, String nombre, String correo, String marcaVehiculo, String patenteVehiculo, String lineaVehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.marcaVehiculo = marcaVehiculo;
        this.patenteVehiculo = patenteVehiculo;
        this.lineaVehiculo = lineaVehiculo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public String getLineaVehiculo() {
        return lineaVehiculo;
    }

    public void setLineaVehiculo(String lineaVehiculo) {
        this.lineaVehiculo = lineaVehiculo;
    }
}
