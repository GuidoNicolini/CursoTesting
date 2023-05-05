package com.guido.testServicios.controllers;

import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.models.TransaccionDto;
import com.guido.testServicios.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cuenta detalle(@PathVariable Long id){

        return cuentaService.findById(id);
    }

    @PostMapping("/transferir")
    public ResponseEntity<?> transferir(@RequestBody TransaccionDto dto){

        cuentaService.transeferir(dto.getCuentaOringenId(), dto.getCuentaDestinoId(),dto.getMonto());

        Map<String,Object> response = new HashMap<>();


        response.put("Date", LocalDate.now().toString());
        response.put("Status", "Ok");
        response.put("Mensaje","Transferencia realizada con exito");
        response.put("Transaccion",dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cuenta> lista(){
        return cuentaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta guardar(@RequestBody Cuenta cuenta){
        return cuentaService.save(cuenta);
    }
}


