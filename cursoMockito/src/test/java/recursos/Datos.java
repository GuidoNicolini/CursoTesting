package recursos;

import org.guido.cursomockito.ejemplos.models.Examen;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(1L, "Lengua"), new Examen(2L, "Fisica"), new Examen(3L, "Matematica"));
}
