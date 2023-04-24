package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.criteria.CuentaSpecification;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.model.Cuenta;
import com.pfcti.spring.dev.app.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    public List<Cuenta> busquedaCuentasPorCriterio(CuentaDto cuentaDtoFiltro){
        return cuentaRepository
                .findAll(cuentaSpecification.buildFilter(cuentaDtoFiltro));
    }
}