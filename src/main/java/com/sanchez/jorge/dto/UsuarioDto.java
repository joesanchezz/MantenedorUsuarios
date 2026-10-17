package com.sanchez.jorge.dto;

public class UsuarioDto {

    private String nombre;
    private String contrasena;
    private int edad;
    private String rut;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public UsuarioDto() {
    }

    public UsuarioDto(String nombre, String contrasena, int edad, String rut, String correo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.rut = rut;
        this.correo = correo;
    }
}
