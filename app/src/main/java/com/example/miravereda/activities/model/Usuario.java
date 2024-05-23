package com.example.miravereda.activities.model;

import java.io.Serializable;

import java.io.Serializable;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario implements Serializable {

    // Atributos del usuario
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

    /**
     * Constructor para crear un usuario con todos sus atributos.
     *
     * @param dni Identificador único del usuario.
     * @param usuario Nombre de usuario que se utilizará para acceder al sistema.
     * @param contrasenya Contraseña del usuario.
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email Correo electrónico del usuario.
     * @param domicilio Dirección de domicilio del usuario.
     * @param codigo_postal Código postal de la dirección del usuario.
     * @param fecha_nacimiento Fecha de nacimiento del usuario.
     * @param tarjeta_credito Número de tarjeta de crédito asociada al usuario.
     */
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
