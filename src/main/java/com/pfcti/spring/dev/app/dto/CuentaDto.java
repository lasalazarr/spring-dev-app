package com.pfcti.spring.dev.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CuentaDto {
    private int id;

    @NotNull
    @Size(max = 10)
    private String numero;
    private String tipo;
    private Boolean estado;

    private int clienteId;
}
