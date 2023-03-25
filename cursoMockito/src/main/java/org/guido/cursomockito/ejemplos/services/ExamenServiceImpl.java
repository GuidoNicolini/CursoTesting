package org.guido.cursomockito.ejemplos.services;

import org.guido.cursomockito.ejemplos.models.Examen;
import org.guido.cursomockito.ejemplos.repositories.ExamenRepositorio;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{

    private ExamenRepositorio examenRepositorio;

    public ExamenServiceImpl(ExamenRepositorio examenRepositorio) {
        this.examenRepositorio = examenRepositorio;
    }

    @Override
    public Examen findExamenPorNombre(String nombre) {
       Optional<Examen> examenOptional = examenRepositorio.findAll()
               .stream()
               .filter(e-> e.getNombre().contains(nombre))
               .findFirst();

       Examen examen = null;
       if (examenOptional.isPresent()){
           examen = examenOptional.orElseThrow();
       }
        return examen;
    }
}
