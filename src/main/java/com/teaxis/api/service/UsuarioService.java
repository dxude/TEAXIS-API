package com.teaxis.api.service;

import com.teaxis.api.model.Avaliacao;
import com.teaxis.api.model.Usuario;
import com.teaxis.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teaxis.api.model.Meta;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Meta> getMetasByUsuarioId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow();
        return usuario.getMetas();
    }

    public List<Avaliacao> getAvaliacoesByUsuarioId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow();
        return usuario.getAvaliacoesFeitas();
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return repository.findById(id)
            .map(usuarioExistente -> {
                if (usuarioAtualizado.getNome() != null) {
                    usuarioExistente.setNome(usuarioAtualizado.getNome());
                }
                if (usuarioAtualizado.getEmail() != null) {
                    usuarioExistente.setEmail(usuarioAtualizado.getEmail());
                }
        
                
                return repository.save(usuarioExistente);
            })
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }
}
