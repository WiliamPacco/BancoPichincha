package com.api.main.servicios;

import com.api.main.dto.RequestDTO;
import com.api.main.dto.RequestUpdateDTO;
import com.api.main.dto.UsuarioDTO;
import com.api.main.entidades.TipoCambio;
import com.api.main.repositorios.ITipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final RestTemplate restTemplate;
    private final ITipoCambioRepository tipoCambioRepository;

    public Optional<UsuarioDTO> getUserData(String id) {
        String url = String.format("https://gorest.co.in/public/v2/users/%s", id);

        try {
            UsuarioDTO usuario = restTemplate.getForObject(url, UsuarioDTO.class);
            return Optional.of(usuario);
        } catch (HttpClientErrorException.NotFound ex) {
            return Optional.empty();
        }
    }

    public String save(RequestDTO request) {
        Optional<UsuarioDTO> usuario = this.getUserData(request.getUsuario());
        if (usuario.isEmpty()) {
            return "Usuario no encontrado";
        }

        TipoCambio tipoCambio = TipoCambio.builder()
                .nombreUsuario(usuario.get().getName())
                .montoInicial(request.getMontoInicial())
                .montoFinal(request.getMontoFinal())
                .tipoCambio(request.getTipoCambio())
                .fechaProceso(LocalDateTime.now())
                .build();

        tipoCambioRepository.save(tipoCambio);

        return "Tipo de cambio registrado";
    }

    public String update(RequestUpdateDTO request) {
        Optional<TipoCambio> existe = tipoCambioRepository.findById(request.getId());

        if (existe.isEmpty()) {
            return "Registro no encontrado";
        }

        Optional<UsuarioDTO> usuario = this.getUserData(request.getUsuario());
        if (usuario.isEmpty()) {
            return "Usuario no encontrado";
        }

        TipoCambio tipoCambio = TipoCambio.builder()
                .id(request.getId())
                .nombreUsuario(usuario.get().getName())
                .montoInicial(request.getMontoInicial())
                .montoFinal(request.getMontoFinal())
                .tipoCambio(request.getTipoCambio())
                .fechaProceso(LocalDateTime.now())
                .build();

        tipoCambioRepository.save(tipoCambio);

        return "Tipo de cambio actualizado";
    }

    public TipoCambio buscarPorId(Long id) {
        return tipoCambioRepository.findById(id).orElse(null);
    }
}
