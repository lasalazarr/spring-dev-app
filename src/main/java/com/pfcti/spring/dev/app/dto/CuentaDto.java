package com.pfcti.spring.dev.app.dto;

import lombok.Data;

@Data
public class CuentaDto {
    private int id;
    private String numero;
    private String tipo;
    private boolean estado;
    private int clienteId;
}
