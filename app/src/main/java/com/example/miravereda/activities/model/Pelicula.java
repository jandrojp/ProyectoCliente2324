package com.example.miravereda.activities.model;

import java.io.Serializable;

import java.io.Serializable;

/**
 * Clase que representa una película.
 */
public class Pelicula implements Serializable {

    // Atributos de la película
    public int id;
    public String tipo;
    public String titulo;
    public String idioma;
    public String genero;
    public String descripcion;
    public String director;
    public String actores;
    public int duracion;
    public double valoracion_media;
    public double preciovisionado;
    public String portada;

    /**
     * Constructor para crear una película con todos sus atributos.
     *
     * @param id Identificador único de la película.
     * @param tipo Tipo de película (película / serie / corto).
     * @param titulo Título de la película.
     * @param idioma Idioma en el que está definida la película.
     * @param genero Género de la película (miedo / acción / suspense, etc.).
     * @param descripcion Sinopsis de la película.
     * @param director Nombre del director de la película.
     * @param actores Actores que participan en la película.
     * @param duracion Duración de la película en horas.
     * @param valoracion_media Valoración media de las votaciones de la película.
     * @param preciovisionado Precio de visualización de la película.
     * @param portada Imagen de portada de la película.
     */
    public Pelicula(int id, String tipo, String titulo, String idioma, String genero, String descripcion, String director, String actores, int duracion, double valoracion_media, double preciovisionado, String portada) {
        this.id = id;
        this.tipo = tipo;
        this.titulo = titulo;
        this.idioma = idioma;
        this.genero = genero;
        this.descripcion = descripcion;
        this.director = director;
        this.actores = actores;
        this.duracion = duracion;
        this.valoracion_media = valoracion_media;
        this.preciovisionado = preciovisionado;
        this.portada = portada;
    }

}
