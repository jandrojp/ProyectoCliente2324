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
    public Date fecha_nacimiento;
    public String tarjeta_credito;
}
