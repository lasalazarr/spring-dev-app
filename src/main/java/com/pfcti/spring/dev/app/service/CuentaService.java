package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.criteria.CuentaSpecification;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.model.Cuenta;
import com.pfcti.spring.dev.app.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;


    private CuentaDto fromCuentaToDto(Cuenta cuenta) {
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        cuentaDto.setClienteId(cuenta.getCliente().getId());
        return cuentaDto;
    }

    private Cuenta fromDtoToCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta();
        BeanUtils.copyProperties(cuentaDto, cuenta);
        Cliente cliente = new Cliente();
        cliente.setId(cuentaDto.getClienteId());
        cuenta.setCliente(cliente);
        return cuenta;
    }

    public List<Cuenta> busquedaCuentasPorCriterio(CuentaDto cuentaDtoFiltro){
        return cuentaRepository
                .findAll(cuentaSpecification.buildFilter(cuentaDtoFiltro));
    }


    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDto> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                    log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }

    public void creacionDeCuenta(CuentaDto cuentaDto){
        Cuenta cuenta = fromDtoToCuenta(cuentaDto);
        cuentaRepository.save(cuenta);
        log.info("Cuenta: {} ", cuenta);
    }


    public void desactivacion(int id){
        Cuenta cuenta = cuentaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("No existe la cuenta"));
        cuenta.setEstado(false);
        cuentaRepository.save(cuenta);
        log.info("Cuenta: {} ", cuenta);
    }


}
