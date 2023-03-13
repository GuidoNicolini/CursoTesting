package com.guido.models;

public class Cuenta {

    private String nombre;
    private Integer saldo;

    public Cuenta() {
    }

    public Cuenta(String nombre, Integer saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta)obj;

        if (this.nombre == null || this.saldo == null){
            return false;
        }
        return this.nombre.equals(c.getNombre()) && this.saldo.equals(c.getSaldo());
    }
}
