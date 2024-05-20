package com.example.miravereda.activities.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

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
}
