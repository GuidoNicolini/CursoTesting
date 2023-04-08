package com.guido.testServicios.models;

import com.guido.testServicios.exceptions.DineroInsuficienteException;

import java.util.Objects;

public class Cuenta {

    private Long id;
    private String nombre  ;
    private  Long saldo  ;

    public Cuenta() {
    }

    public Cuenta(Long id, String nombre, Long saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public void debito(Long retiro){
        if(this.saldo < retiro){
            throw new DineroInsuficienteException("Saldo Insuficiente");
        }else{
            this.saldo -= retiro;
        }
    }

    public void credito(Long deposito){
        this.saldo += deposito;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id) && Objects.equals(nombre, cuenta.nombre) && Objects.equals(saldo, cuenta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, saldo);
    }
}
