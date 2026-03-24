package com.fumagalli.gerenciamento_livros.controller;

import com.fumagalli.gerenciamento_livros.models.LivroModel;
import com.fumagalli.gerenciamento_livros.services.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> requeste = livroService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel novo = livroService.criarLivro(livroModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro (@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorIdLivro(@PathVariable Long id){
        Optional<LivroModel> livro = livroService.buscarPorId(id);

        if(livro.isPresent()){
            return ResponseEntity.ok(livro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel atualizado = livroService.atualizar(id, livroModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
