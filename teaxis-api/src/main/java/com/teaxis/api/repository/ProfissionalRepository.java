package com.teaxis.api.repository;

import com.teaxis.api.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findByEspecialidade(String especialidade);
}
