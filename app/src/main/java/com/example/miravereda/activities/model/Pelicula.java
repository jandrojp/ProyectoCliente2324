package com.example.miravereda.activities.model;

import java.io.Serializable;
import java.sql.Date;

public class Pelicula implements Serializable {

    public int id;
    public String tipo;
    public String titulo;
    public String idioma;
    public String genero;
    public Date fecha_estreno;
    public String descripcion;
    public String director;
    public String actores;
    public int duracion;
    public double valoracion_media;
}
