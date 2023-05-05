package com.guido.testServicios;

import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.repositories.CuentaRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
public class IntegracionTest {

    @Autowired
    CuentaRepository cuentaRepository;


    @Test
    void test_find_by_id() {

        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);

        assertTrue(cuenta.isPresent());
        assertEquals("Guido",cuenta.orElseThrow().getNombre());

    }

    @Test
    void test_find_by_name() {
        Optional<Cuenta> cuenta = cuentaRepository.FindByNombre("Romeo");


        assertEquals(5000,cuenta.orElseThrow().getSaldo());
    }

    @Test
    void testFindByPersonaThrowException() {
        Optional<Cuenta> cuenta = cuentaRepository.FindByNombre("Rod");
        assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
        assertFalse(cuenta.isPresent());
    }

    @Test
    void testFindAll() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        assertFalse(cuentas.isEmpty());
        assertEquals(6, cuentas.size());
    }

    @Test
    void testSave() {
        // Given
        Cuenta nuevaCuenta = new Cuenta(100L,"Marcelo",650L);

        // When
        Cuenta cuenta = cuentaRepository.save(nuevaCuenta);

        // Then
        assertEquals("Marcelo", cuenta.getNombre());
        assertEquals(650L, cuenta.getSaldo());
        assertEquals(7L,cuenta.getId());
    }

    @Test
    void testUpdate() {
        // Given
        Cuenta nuevaCuenta = new Cuenta(100L,"Marcelo",650L);

        // When
        Cuenta cuenta = cuentaRepository.save(nuevaCuenta);


        // Then
        assertEquals("Marcelo", cuenta.getNombre());
        assertEquals(650L, cuenta.getSaldo());
        assertEquals(7L,cuenta.getId());


        // When
        cuenta.setSaldo(10000L);
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);

        // Then
        assertEquals("Marcelo", cuentaActualizada.getNombre());
        assertEquals(10000L, cuentaActualizada.getSaldo());
        assertEquals(7L,cuenta.getId());

    }

    @Test
    void testDelete() {
        Cuenta cuenta = cuentaRepository.findById(2L).orElseThrow();
        assertEquals("Pepe", cuenta.getNombre());

        cuentaRepository.delete(cuenta);

        assertThrows(NoSuchElementException.class, () -> {
            cuentaRepository.findById(2L).orElseThrow();
        });
        assertEquals(5, cuentaRepository.findAll().size());
    }

}


