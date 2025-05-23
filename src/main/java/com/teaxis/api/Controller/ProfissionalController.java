package com.teaxis.api.Controller;

import com.teaxis.api.model.Profissional;
import com.teaxis.api.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @GetMapping
    public List<Profissional> listar() {
        return service.listar();
    }

    @PostMapping
    public Profissional salvar(@RequestBody Profissional profissional) {
        return service.salvar(profissional);
    }

    @GetMapping("/{id}")
    public Profissional buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")  // Método para atualização
    public ResponseEntity<Profissional> atualizar(
            @PathVariable Long id,
            @RequestBody Profissional profissionalAtualizado) {
        Profissional profissional = service.atualizar(id, profissionalAtualizado);
        return ResponseEntity.ok(profissional);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/especialidade")
    public List<Profissional> buscarPorEspecialidade(@RequestParam String especialidade) {
        return service.buscarPorEspecialidade(especialidade);
    }
}
