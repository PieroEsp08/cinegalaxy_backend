package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "asiento")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asientoId;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    private String fila;

    private Integer numero;

    private String tipo;

    private Integer estado;

    public Asiento() {}

    public Asiento(Sala sala, String fila, Integer numero, String tipo, Integer estado) {
        this.sala = sala;
        this.fila = fila;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Long getAsientoId() { return asientoId; }
    public void setAsientoId(Long asientoId) { this.asientoId = asientoId; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }

}
