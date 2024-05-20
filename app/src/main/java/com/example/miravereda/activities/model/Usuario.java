package com.example.miravereda.activities.model;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable {
    public String dni;
    public String usuario;
    public String contrasenya;
    public String nombre;
    public String apellidos;
    public String email;
    public String domicilio;
    public String codigo_postal;
    public String fecha_nacimiento;
    public String tarjeta_credito;

    public Usuario(String dni, String usuario, String contrasenya, String nombre, String apellidos, String email, String domicilio, String codigo_postal, String fecha_nacimiento, String tarjeta_credito) {
        this.dni = dni;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.domicilio = domicilio;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tarjeta_credito = tarjeta_credito;
    }
}
