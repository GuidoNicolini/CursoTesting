package org.guido.cursomockito.ejemplos.services;

import org.guido.cursomockito.ejemplos.models.Examen;

public interface ExamenService {

    Examen findExamenPorNombre(String nombre);

}
