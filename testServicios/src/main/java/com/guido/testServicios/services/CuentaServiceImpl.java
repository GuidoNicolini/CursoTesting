package com.guido.testServicios.services;

import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService{


    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Autowired
    private CuentaRepository cuentaRepository;
    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElseThrow();

    }

    @Override
    public Long consultarSaldo(Long id) {
        return cuentaRepository.findById(id).orElseThrow().getSaldo();

    }

    @Override
    public void transeferir(Long origen, Long destino, Long monto) {

       Cuenta ori = cuentaRepository.findById(origen).orElseThrow();
       Cuenta des = cuentaRepository.findById(destino).orElseThrow();

       ori.debito(monto);
       cuentaRepository.save(ori);

       des.credito(monto);
        cuentaRepository.save(des);
    }
}
