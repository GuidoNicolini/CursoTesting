package com.guido.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest2 {
    Cuenta cuenta;

    @BeforeAll
    static void beforeAllTest() {
        System.out.println("Before All");

    }

    @BeforeEach
    void forEachTestBefore() {
        this.cuenta = new Cuenta("Guido", 1000);
        System.out.println("Before Each");
    }

    @AfterEach
    void forEachTestAfter() {

        System.out.println("After Each");
    }

    @AfterAll
    static void afterAllTest() {

        System.out.println("After All");
    }


    @Test
    void test_nombre() {

        assertEquals("Guido", this.cuenta.getNombre());

        /*  Cambiando el saldo para comprender que la instacia de cuenta es independiente para cada test*/
        this.cuenta.setSaldo(3000);

    }


    @RepeatedTest(10)
    void test_repeticion(RepetitionInfo info){

        System.out.println(info.getCurrentRepetition());

        assertTrue(info.getCurrentRepetition() < 7);
    }

    @Test
    void test_saldo() {

        assertEquals(1000, this.cuenta.getSaldo());
    }
}
