package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sedeId;

    private String nombre;

    private String direccion;

    private String distrito;

    private String telefono;

    private String imagen;

    private Integer estado;

    public Long getSedeId() { return sedeId; }

    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDistrito() { return distrito; }

    public void setDistrito(String distrito) { this.distrito = distrito; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getImagen() { return imagen; }

    public void setImagen(String imagen) { this.imagen = imagen; }

    public Integer getEstado() { return estado; }

    public void setEstado(Integer estado) { this.estado = estado; }

}
