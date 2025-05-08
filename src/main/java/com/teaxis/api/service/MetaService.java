package com.teaxis.api.service;

import com.teaxis.api.model.Meta;
import com.teaxis.api.model.Usuario;
import com.teaxis.api.repository.MetaRepository;
import com.teaxis.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Meta> listar() {
        return repository.findAll();
    }

    public Meta salvar(Meta meta) {
        
        Long usuarioId = meta.getUsuario().getId();
        Usuario usuarioCompleto = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + usuarioId));

        meta.setUsuario(usuarioCompleto); 
        return repository.save(meta);
    }

    public Meta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Meta> buscarComProgressoMaiorQue(Double progresso) {
        return repository.findByProgressoGreaterThan(progresso);
    }

    public Meta atualizar(Long id, Meta metaAtualizada) {
        return repository.findById(id)
            .map(metaExistente -> {
                if (metaAtualizada.getDescricao() != null) {
                    metaExistente.setDescricao(metaAtualizada.getDescricao());
                }
                if (metaAtualizada.getProgresso() != null) {
                    metaExistente.setProgresso(metaAtualizada.getProgresso());
                }
                if (metaAtualizada.getUsuario() != null) {
                    
                    Long usuarioId = metaAtualizada.getUsuario().getId();
                    Usuario usuarioCompleto = usuarioRepository.findById(usuarioId)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + usuarioId));
                    metaExistente.setUsuario(usuarioCompleto);
                }
                return repository.save(metaExistente);
            })
            .orElseThrow(() -> new RuntimeException("Meta não encontrada com o ID: " + id));
    }
}
