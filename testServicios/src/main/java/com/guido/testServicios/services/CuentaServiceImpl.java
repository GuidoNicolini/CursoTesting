package com.guido.testServicios.services;

import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.repositories.CuentaRepository;

public class CuentaServiceImpl implements CuentaService{


    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    private CuentaRepository cuentaRepository;
    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id);

    }

    @Override
    public Long consultarSaldo(Long id) {
        return cuentaRepository.findById(id).getSaldo();

    }

    @Override
    public void transeferir(Long origen, Long destino, Long monto) {

       Cuenta ori = cuentaRepository.findById(origen);
       Cuenta des = cuentaRepository.findById(destino);

       ori.debito(monto);
       cuentaRepository.update(ori);

       des.credito(monto);
        cuentaRepository.update(des);
    }
}
