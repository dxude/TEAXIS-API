package com.teaxis.api.service;

import com.teaxis.api.model.Avaliacao;
import com.teaxis.api.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    public Avaliacao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Avaliacao> buscarNotasAltas(Integer nota) {
        return repository.findByNotaGreaterThan(nota);
    }

    public Avaliacao atualizar(Long id, Avaliacao avaliacaoAtualizada) {
        return repository.findById(id)
            .map(avaliacaoExistente -> {
                if (avaliacaoAtualizada.getComentario() != null) {
                    avaliacaoExistente.setComentario(avaliacaoAtualizada.getComentario());
                }
                if (avaliacaoAtualizada.getNota() != 0) { 
                    avaliacaoExistente.setNota(avaliacaoAtualizada.getNota());
                }
                return repository.save(avaliacaoExistente);
            })
            .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    
}
