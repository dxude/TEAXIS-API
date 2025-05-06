package com.teaxis.api.repository;

import com.teaxis.api.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByNotaGreaterThan(Integer nota);
}
