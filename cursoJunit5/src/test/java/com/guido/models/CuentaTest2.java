package com.guido.models;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    @Test
    void test_saldo() {

        assertEquals(1000, this.cuenta.getSaldo());
    }
    @RepeatedTest(10)
    void test_repeticion(RepetitionInfo info){

        System.out.println(info.getCurrentRepetition());

        assertTrue(info.getCurrentRepetition() < 7);
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @ValueSource(ints = {100,200,300,400,500,1000,2000,5000,10000})
    void parametrizado_valueSourse(Integer monto) {

        assertTrue(cuenta.getSaldo() > monto);
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @CsvSource({"1,100","1,500","1,1000","1,3000"})
    void parametrizado_valueSourse(String index,Integer monto) {

        assertTrue(cuenta.getSaldo() > monto);
    }


    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @CsvFileSource(resources = "/data.csv")
    void parametrizado_CsvFileSource(Integer monto) {

        assertTrue(cuenta.getSaldo() > monto);
    }


    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @MethodSource("montoList")
    void parametrizado_methodSourse(Integer monto) {

        assertTrue(cuenta.getSaldo() > monto);
    }

    private static List<Integer> montoList(){
        return Arrays.asList(100,500,800,1000,5000,10000);
    }


    @Test
    void test_info_e_reporter(TestInfo testInfo,TestReporter testReporter) {

        System.out.println(testInfo.getDisplayName());

        System.out.println("-------------------------");

        testReporter.publishEntry("Esto es un poco distinto");
    }

    @Test
    @Timeout(5)
    void test_timeOut() throws InterruptedException{
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    @Timeout(value= 500,unit = TimeUnit.MILLISECONDS)
    void test_timeOut2() throws InterruptedException{
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    void test_timeOut3() throws InterruptedException{
       assertTimeout(Duration.ofSeconds(5), ()->{
           TimeUnit.SECONDS.sleep(6);
       });
    }
}
