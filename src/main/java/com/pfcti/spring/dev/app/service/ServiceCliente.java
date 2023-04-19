package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceCliente {

    private ClienteRepository clienteRepository;
}
