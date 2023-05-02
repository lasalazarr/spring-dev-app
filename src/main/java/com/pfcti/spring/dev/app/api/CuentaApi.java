package com.pfcti.spring.dev.app.api;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.service.CuentaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * advance
 * 25/4/23
 */
@Slf4j
@RestController
@RequestMapping("/v1/api/cuenta")
public class CuentaApi {

    @Autowired
    private CuentaService cuentaService;


    @PostMapping
    public void guardarCuenta(@Valid @RequestBody CuentaDto cuentaDto) {
        log.info("cuentaDto de cuentaDto : {}", cuentaDto);
        cuentaService.creacionDeCuenta(cuentaDto);
    }


    @DeleteMapping("/{id}")
    public void desactivarCuenta(@PathVariable int id) {
        log.info("cuentaDto de id : {}", id);
        cuentaService.desactivacion(id);
    }

    @GetMapping("/cliente/{id}")
    public List<CuentaDto> obtenerCuentasCliente(@PathVariable int id){
        log.info("cuentaDto de id : {}", id);
        return cuentaService.buscarCuentasPorCliente(id);
    }




}
