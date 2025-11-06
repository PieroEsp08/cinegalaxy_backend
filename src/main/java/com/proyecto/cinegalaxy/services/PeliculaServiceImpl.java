package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Pelicula;
import com.proyecto.cinegalaxy.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;


    @Override
    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Long id, Pelicula peliculaDetails) {
        return peliculaRepository.findById(id).map(pelicula -> {
            pelicula.setTitulo(peliculaDetails.getTitulo());
            pelicula.setSinopsis(peliculaDetails.getSinopsis());
            pelicula.setDuracion(peliculaDetails.getDuracion());
            pelicula.setGenero(peliculaDetails.getGenero());
            pelicula.setImagen(peliculaDetails.getImagen());
            pelicula.setEstadoEstreno(peliculaDetails.getEstadoEstreno());
            pelicula.setEstado(peliculaDetails.getEstado());
            return peliculaRepository.save(pelicula);
        }).orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id " + id));
    }

    @Override
    public Pelicula deletePelicula(Long id) {
        return peliculaRepository.findById(id).map(pelicula -> {
            pelicula.setEstado(0); // Eliminación lógica
            return peliculaRepository.save(pelicula);
        }).orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id " + id));
    }
}
