package com.pfcti.spring.dev.app.jms;

import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * advance
 * 28/4/23
 */
@SpringBootTest
@Slf4j
public class NotificationSenderTest {

    @Autowired
    private CuentaService cuentaService;

    @Test
    void crearCuentaYNotificar() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("4788987255");
        cuentaDto.setTipo("AHO");
        cuentaDto.setClienteId(1);
        cuentaService.creacionDeCuentaYNotificacion(cuentaDto);
    }


    @Test
    void crearCuentaPubSub() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("4788987255");
        cuentaDto.setTipo("AHO");
        cuentaDto.setClienteId(1);
        cuentaService.creacionDeCuentaPublishSub(cuentaDto);
    }
}
