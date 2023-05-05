package com.guido.testServicios.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guido.testServicios.Datos;
import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.models.TransaccionDto;
import com.guido.testServicios.services.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CuentaService cuentaService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void detalle() throws Exception {
        when(cuentaService.findById(1L)).thenReturn(Datos.CUENTA_001.orElseThrow());

        mvc.perform(MockMvcRequestBuilders.get("/api/cuentas/1").contentType(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Guido"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.saldo").value("1000"));


        verify(cuentaService).findById(1L);
    }

    @Test
    void name() throws Exception {
        TransaccionDto dto = new TransaccionDto();

        dto.setCuentaOringenId(1L);
        dto.setCuentaDestinoId(2l);
        dto.setMonto(5L);


        mvc.perform(MockMvcRequestBuilders.post("/api/cuentas/transferir").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Mensaje").value("Transferencia realizada con exito"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Transaccion.cuentaDestinoId").value("2"));


    }

    @Test
    void listar() throws Exception {
        List<Cuenta> lista = Arrays.asList(Datos.CUENTA_001.orElseThrow(),Datos.CUENTA_002.orElseThrow(),Datos.CUENTA_003.orElseThrow(),Datos.CUENTA_004.orElseThrow());
        when(cuentaService.findAll()).thenReturn(lista);


        mvc.perform(MockMvcRequestBuilders.get("/api/cuentas").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Guido"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombre").value("Pepe"))


    }
}