package com.pfcti.spring.dev.app.dto;

import lombok.Data;

@Data
public class DirecccionDto {
    private int id;
    private String direccion;
    private String nomenclatura;
    private int clienteId;
}