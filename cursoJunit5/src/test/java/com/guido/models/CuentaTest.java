package com.guido.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void test_probar_nombre(){

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("Guido");
        String actual = cuenta.getNombre();
        String esperado = "Guido";

        assertEquals(esperado,actual);
    }


    @Test
    void test_probar_saldo() {
        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(300);

        assertEquals(300,cuenta.getSaldo());
    }

    @Test
    void test_saldo_mayor_cero() {
        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(300);

        assertTrue(cuenta.getSaldo()>0);

    }

    @Test
    void test_referecia_cuenta() {

        Cuenta cuenta = new Cuenta("Guido",1000);
        Cuenta cuenta2 = new Cuenta("Guido",1000);

        /* Cuando se compara por ubicacion en memoria y sin modificar el metodo equals*/
        // assertNotEquals(cuenta,cuenta2);

        /* Son iguales por que se modifico el metodo equals */
        assertEquals(cuenta,cuenta2);

    }
} 

