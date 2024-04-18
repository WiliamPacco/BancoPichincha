package com.api.main.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RequestUpdateDTO {
    private Long id;
    private String usuario;
    private BigDecimal montoInicial;
    private BigDecimal montoFinal;
    private String tipoCambio;
}
