package com.api.main.repositorios;

import com.api.main.entidades.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoCambioRepository extends JpaRepository<TipoCambio, Long> {
}
