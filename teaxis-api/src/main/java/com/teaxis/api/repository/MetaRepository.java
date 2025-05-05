package com.teaxis.api.repository;

import com.teaxis.api.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Long> {
    List<Meta> findByProgressoGreaterThan(Double progresso);
}
