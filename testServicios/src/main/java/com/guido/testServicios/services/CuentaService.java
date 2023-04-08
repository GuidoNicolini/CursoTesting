package com.guido.testServicios.services;

import com.guido.testServicios.models.Cuenta;

public interface CuentaService {

    Cuenta findById(Long id);

    Long consultarSaldo(Long id);
    void transeferir(Long origen,Long destino,Long monto);
}
