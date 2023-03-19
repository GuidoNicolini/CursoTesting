package com.guido.models;

import com.guido.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    @DisplayName("Probando metodo SET")
    void test_probar_nombre() {

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("Guido");
        String actual = cuenta.getNombre();
        String esperado = "Guido";

        assertEquals(esperado, actual);
    }


    @Test
    void test_probar_saldo() {
        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(300);

        assertEquals(300, cuenta.getSaldo());
    }

    @Test
    void test_saldo_mayor_cero() {
        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(300);

        assertTrue(cuenta.getSaldo() > 0);

    }

    @Test
    void test_referecia_cuenta() {

        Cuenta cuenta = new Cuenta("Guido", 1000);
        Cuenta cuenta2 = new Cuenta("Guido", 1000);

        /* Cuando se compara por ubicacion en memoria y sin modificar el metodo equals*/
        // assertNotEquals(cuenta,cuenta2);

        /* Son iguales por que se modifico el metodo equals */
        assertEquals(cuenta, cuenta2);

    }

    @Test
    void test_debito_cuenta() {
        Cuenta cuenta = new Cuenta("Guido", 1000);
        cuenta.debito(100);

        assertEquals(900, cuenta.getSaldo());
    }

    @Test
    void test_credito_cuenta() {
        Cuenta cuenta = new Cuenta("Guido", 1000);
        cuenta.credito(100);

        assertEquals(1100, cuenta.getSaldo());
    }

    @Test
    void test_dinero_insuficiente_exception_cuenta() {
        Cuenta cuenta = new Cuenta("Guido", 1000);

        Exception exception = assertThrows(DineroInsuficienteException.class, () -> cuenta.debito(1500));

        assertEquals("Dinero Insuficiente", exception.getMessage());
    }


    // AssertAll EJEMPLO

    @Test
    void test_assertall() {
        Cuenta cuenta = new Cuenta("Guido", 1000);


        assertAll(

                () -> {
                    assertEquals("Guido", cuenta.getNombre());
                },
                () -> {
                    assertEquals(1000, cuenta.getSaldo());
                },
                () -> {
                    assertTrue(cuenta.getSaldo() >= 0);
                }


        );

    }

    // Disabled = Este test no se ejecutara
    @Test
    @Disabled
    void test_disable() {
    }
}

