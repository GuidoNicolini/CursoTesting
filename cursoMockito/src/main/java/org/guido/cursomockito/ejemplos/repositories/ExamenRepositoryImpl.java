package org.guido.cursomockito.ejemplos.repositories;

import org.guido.cursomockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepositorio{
    @Override
    public List<Examen> findAll() {
        return Arrays.asList(new Examen(1L,"Lengua"),new Examen(2L,"Biologia"),new Examen(3L,"Matematica"),new Examen(4L,"Fisica"));
    }
}
