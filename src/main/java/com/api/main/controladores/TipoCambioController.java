package com.api.main.controladores;

import com.api.main.dto.RequestDTO;
import com.api.main.dto.RequestUpdateDTO;
import com.api.main.entidades.TipoCambio;
import com.api.main.servicios.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipocambio")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    @PostMapping("/registro")
    public ResponseEntity<String> registrarTipoCambio(@RequestBody RequestDTO request) {
        return ResponseEntity.ok(tipoCambioService.save(request));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<String> registrarTipoCambio(@RequestBody RequestUpdateDTO request) {
        return ResponseEntity.ok(tipoCambioService.update(request));
    }

    @GetMapping("/buscar")
        public ResponseEntity<TipoCambio> buscarTipoCambio(@RequestParam("id") Long id) {
        return ResponseEntity.ok(tipoCambioService.buscarPorId(id));
    }


}
