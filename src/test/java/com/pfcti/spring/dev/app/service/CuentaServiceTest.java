package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.model.Cuenta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;

    @Test
    void busquedaCuentasPorCriterio() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(true);
        List<Cuenta> cuentas = cuentaService.busquedaCuentasPorCriterio(cuentaDto);
        cuentas.forEach(
                cuentaDtoResultado -> {
                    System.out.println("Cuenta Resultado-"
                            + "Tipo-" + cuentaDtoResultado.getTipo()
                            + "Numero-" + cuentaDtoResultado.getNumero()
                            + "Estado-" + cuentaDtoResultado.getEstado());
                });
        assertEquals(3, cuentas.size());
    }
}