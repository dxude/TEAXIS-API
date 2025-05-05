package com.teaxis.api.controller;

import com.teaxis.api.model.Meta;
import com.teaxis.api.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private MetaService service;

    @GetMapping
    public List<Meta> listar() {
        return service.listar();
    }

    @PostMapping
    public Meta salvar(@RequestBody Meta meta) {
        return service.salvar(meta);
    }

    @GetMapping("/{id}")
    public Meta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/progresso")
    public List<Meta> metasComProgressoMaior(@RequestParam Double valor) {
        return service.buscarComProgressoMaiorQue(valor);
    }
}
