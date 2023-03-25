package org.guido.cursomockito.ejemplos.repositories;

import org.guido.cursomockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepositorio {
    List<Examen> findAll();
}
