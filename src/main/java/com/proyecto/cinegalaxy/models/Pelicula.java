package com.proyecto.cinegalaxy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")

public class Pelicula {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long peliculaId;

        private String titulo;

        private String sinopsis;

        private Integer duracion;

        private String genero;

        private String imagen;

        @Column(name = "estado_estreno")
        private Integer estadoEstreno = 1;

        private Integer estado = 1;


        public Long getPeliculaId() {
            return peliculaId;
        }

        public void setPeliculaId(Long peliculaId) {
            this.peliculaId = peliculaId;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getSinopsis() {
            return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
            this.sinopsis = sinopsis;
        }

        public Integer getDuracion() {
            return duracion;
        }

        public void setDuracion(Integer duracion) {
            this.duracion = duracion;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public Integer getEstadoEstreno() {
            return estadoEstreno;
        }

        public void setEstadoEstreno(Integer estadoEstreno) {
            this.estadoEstreno = estadoEstreno;
        }

        public Integer getEstado() {
            return estado;
        }

        public void setEstado(Integer estado) {
            this.estado = estado;
        }
}
