package com.guido.testServicios.repositories;

import com.guido.testServicios.models.Cuenta;

import java.util.List;

public interface CuentaRepository {

    List<Cuenta> findAll();
    Cuenta findById(Long id);

    void update(Cuenta cuenta);
}
