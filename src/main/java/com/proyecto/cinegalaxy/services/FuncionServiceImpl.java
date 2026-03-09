package com.proyecto.cinegalaxy.services;

import com.proyecto.cinegalaxy.models.Funcion;
import com.proyecto.cinegalaxy.repositories.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    @Override
    public List<Funcion> getFunciones() {
        return funcionRepository.findAll();
    }

    @Override
    public Optional<Funcion> getFuncionById(Long id) {
        return funcionRepository.findById(id);
    }

    @Override
    public Funcion createFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Funcion updateFuncion(Long id, Funcion funcion) {
        return funcionRepository.findById(id).map(f -> {
            f.setPelicula(funcion.getPelicula());
            f.setSala(funcion.getSala());
            f.setFecha(funcion.getFecha());
            f.setHoraInicio(funcion.getHoraInicio());
            f.setHoraFin(funcion.getHoraFin());
            f.setIdioma(funcion.getIdioma());
            f.setPrecioBase(funcion.getPrecioBase());
            f.setEstado(funcion.getEstado());
            return funcionRepository.save(f);
        }).orElseThrow(() -> new RuntimeException("Funcion no encontrada con id: " + id));
    }

    @Override
    public Funcion deleteFuncion(Long id) {
        return funcionRepository.findById(id).map(funcion -> {
            funcion.setEstado(0); // Eliminación lógica
            return funcionRepository.save(funcion);
        }).orElseThrow(() -> new RuntimeException("Funcion no encontrada con id: " + id));
    }

    @Override
    public List<Funcion> getFuncionesByPelicula(Long peliculaId) {
        return funcionRepository.findByPelicula_PeliculaIdAndEstado(peliculaId, 1);
    }

    @Override
    public List<Funcion> getFuncionesByPeliculaAndFecha(Long peliculaId, LocalDate fecha) {
        return funcionRepository.findByPelicula_PeliculaIdAndFecha(peliculaId, fecha);
    }

    @Override
    public List<Funcion> getFuncionesByPeliculaAndSede(Long peliculaId, Long sedeId) {
        return funcionRepository.findByPeliculaAndSede(peliculaId, sedeId);
    }

    @Override
    public List<Funcion> getFuncionesByPeliculaAndSedeAndFecha(Long peliculaId, Long sedeId, LocalDate fecha) {
        return funcionRepository.findByPeliculaAndSedeAndFecha(peliculaId, sedeId, fecha);
    }
}
