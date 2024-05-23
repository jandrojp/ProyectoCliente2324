package com.example.miravereda.activities.model;

import java.io.Serializable;

/**
 * Clase la cual contiene los atributos de una pelicula con su constructor
 */
public class Pelicula implements Serializable {

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
     * Creamos una pelicula con todos sus atributos
     * @param id identificador único
     * @param tipo pelicula / serie / corto
     * @param titulo nombre de la pelicula
     * @param idioma en la que está definida
     * @param genero miedo / accion / suspense...
     * @param descripcion sinopsis de lo que va
     * @param director nombre del que ha dirigido
     * @param actores participan en ella
     * @param duracion medido en h
     * @param valoracion_media de las votaciones
     * @param preciovisionado de cada título
     * @param portada imagen
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
