package com.api.main.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RequestDTO {
    private String usuario;
    private BigDecimal montoInicial;
    private BigDecimal montoFinal;
    private String tipoCambio;
}
