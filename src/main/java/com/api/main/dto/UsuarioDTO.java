package com.api.main.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO {

    private Long id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
