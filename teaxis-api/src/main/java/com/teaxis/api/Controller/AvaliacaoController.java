package com.teaxis.api.Controller;

import com.teaxis.api.model.Avaliacao;
import com.teaxis.api.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @GetMapping
    public List<Avaliacao> listar() {
        return service.listar();
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
        return service.salvar(avaliacao);
    }

    @GetMapping("/{id}")
    public Avaliacao buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/nota")
    public List<Avaliacao> buscarNotasMaiores(@RequestParam Integer nota) {
        return service.buscarNotasAltas(nota);
    }
}
