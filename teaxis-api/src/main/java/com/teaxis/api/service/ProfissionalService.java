package com.teaxis.api.service;

import com.teaxis.api.model.Profissional;
import com.teaxis.api.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public List<Profissional> listar() {
        return repository.findAll();
    }

    public Profissional salvar(Profissional profissional) {
        return repository.save(profissional);
    }

    public Profissional buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Profissional> buscarPorEspecialidade(String especialidade) {
        return repository.findByEspecialidade(especialidade);
    }
}
