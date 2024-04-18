package com.api.main.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "monto_inicial")
    private BigDecimal montoInicial;

    @Column(name = "monto_final")
    private BigDecimal montoFinal;

    @Column(name = "tipo_cambio")
    private String tipoCambio;

    @Column(name = "fecha_proceso")
    private LocalDateTime fechaProceso;
}
