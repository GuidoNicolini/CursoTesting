package org.guido.cursomockito.ejemplos.repositories;

import org.guido.cursomockito.ejemplos.models.Examen;
import org.guido.cursomockito.ejemplos.services.ExamenService;
import org.guido.cursomockito.ejemplos.services.ExamenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import recursos.Datos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenRepositoryImplTest {

    @Mock
    private ExamenRepositorio examenRepositorio;

    @InjectMocks
    private ExamenServiceImpl examenService;


    /******************
     * Se utiliza para capturar parametros
     * *******************************

    @Captor
    ArgumentCaptor<Long> captor;*/

    /******************
     *  Se utiliza para hacer llamada a metodos reales. Se utiliza para librerias de terceros
     * ***************
    @Spy
    ExamenRepositoryImpl repository;


     ***********/

    @BeforeEach
    void setUp() {
       // examenRepositorio = mock(ExamenRepositorio.class);
       // examenService = new ExamenServiceImpl(examenRepositorio);


      //  MockitoAnnotations.openMocks(this);
    }

    @Test
    void find_examen_por_nombre_test() {

        when(examenRepositorio.findAll()).thenReturn(Datos.EXAMENES);

        Examen exam = examenService.findExamenPorNombre("Fisica");

        assertEquals("Fisica", exam.getNombre());
        assertEquals(2L, exam.getId());

    }

    @Test
    void find_examen_por_nombre_caso_vacio_test() {
        List<Examen> listaVacia = Collections.EMPTY_LIST;
        when(examenRepositorio.findAll()).thenReturn(listaVacia);

        Examen exam = examenService.findExamenPorNombre("Fisica");

        assertNull(exam);
    }

    @Test
    void find_examen_por_nombre_verify_test() {
        List<Examen> listaVacia = Collections.EMPTY_LIST;
        when(examenRepositorio.findAll()).thenReturn(listaVacia);

        Examen exam = examenService.findExamenPorNombre("Fisica");

        assertNull(exam);
        verify(examenRepositorio).findAll();
    }

    @Test
    void manejo_excepciones_test() {

        when(examenRepositorio.findAll()).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class,()->{
            examenService.findExamenPorNombre("Martha");
        });
    }


    /****************************************
     * *************  NOTAS  ****************
     * **************************************
     *
     *  doCallRealMethod()  -----> Se utiliza para llamar a un metodo real y no al Mock
     *
     *
     *  *********************************
     *
     *         verifyNoInteractions(mock);
     *         verify(mock).findAll();
     *         verify(mock), times(1)).findAll();
     *         verify(mock), atLeast(1)).findAll();
     *         verify(mock), atLeastOnce()).findAll();
     *         verify(mock), atMost(10)).findAll();
     *         verify(mock), atMostOnce()).findAll();
     *
     *
     *         Se utilizan para confirmar una cantidad de llamadas a un metodo del Mock
     *
     *
     * **************************************
     *
     *
     *
     *
     *
     */


}