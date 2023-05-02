package com.pfcti.spring.dev.app.api;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * advance
 * 25/4/23
 */
@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteApi {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto buscarClienteXml(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto buscarClienteXmlJson(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/parameter")
    public ClienteDto buscarClienteParameter(@RequestParam int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }


    @PostMapping
    public void guardarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }


    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes() {
        return clienteService.obtenerClientes();
    }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteDto clienteDto) {
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.actualizarCliente(clienteDto);
    }


    @DeleteMapping(value = "/{id}")
    public void eliminarCliente(@PathVariable int id){
        log.info("cliente de cliente : {}", id);
        clienteService.eliminarCliente(id);
    }


}
