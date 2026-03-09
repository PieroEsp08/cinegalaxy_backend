package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaId;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    private String nombre;

    private String formato;

    private Integer filas;

    private Integer columnas;

    private Integer estado;

    public Long getSalaId() { return salaId; }

    public void setSalaId(Long salaId) { this.salaId = salaId; }

    public Sede getSede() { return sede; }

    public void setSede(Sede sede) { this.sede = sede; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFormato() { return formato; }

    public void setFormato(String formato) { this.formato = formato; }

    public Integer getFilas() { return filas; }

    public void setFilas(Integer filas) { this.filas = filas; }

    public Integer getColumnas() { return columnas; }

    public void setColumnas(Integer columnas) { this.columnas = columnas; }

    public Integer getEstado() { return estado; }

    public void setEstado(Integer estado) { this.estado = estado; }
}
