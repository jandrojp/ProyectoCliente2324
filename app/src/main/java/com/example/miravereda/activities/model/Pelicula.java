package com.example.miravereda.activities.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Comparator;

public class Pelicula implements Serializable, Comparable<Pelicula> {

    public static Comparator<Pelicula> SORT_BY_TITULO = Comparator.comparing(Pelicula::getTitulo);
    public static Comparator<Pelicula> SORT_BY_VALORACION = Comparator.comparing(Pelicula::getValoracion_media);

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

    public String getTitulo() {
        return titulo;
    }

    public double getValoracion_media() {
        return valoracion_media;
    }

    @Override
    public int compareTo(Pelicula pelicula) {
        return titulo.compareTo(pelicula.getTitulo());
    }
}
