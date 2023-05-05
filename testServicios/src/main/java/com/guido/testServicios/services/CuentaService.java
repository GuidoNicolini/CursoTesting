package com.guido.testServicios.services;

import com.guido.testServicios.models.Cuenta;

import java.util.List;

public interface CuentaService {


    List<Cuenta> findAll();

    Cuenta save(Cuenta cuenta);



    Cuenta findById(Long id);

    Long consultarSaldo(Long id);
    void transeferir(Long origen,Long destino,Long monto);
}
