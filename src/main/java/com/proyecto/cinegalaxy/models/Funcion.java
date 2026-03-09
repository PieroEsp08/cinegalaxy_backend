package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "funcion")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionId;

    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    private LocalDate fecha;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private String idioma;

    private Double precioBase;

    private Integer estado;

    public Long getFuncionId() { return funcionId; }

    public void setFuncionId(Long funcionId) { this.funcionId = funcionId; }

    public Pelicula getPelicula() { return pelicula; }

    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public Sala getSala() { return sala; }

    public void setSala(Sala sala) { this.sala = sala; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraInicio() { return horaInicio; }

    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }

    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public String getIdioma() { return idioma; }

    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Double getPrecioBase() { return precioBase; }

    public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }

    public Integer getEstado() { return estado; }

    public void setEstado(Integer estado) { this.estado = estado; }

}
