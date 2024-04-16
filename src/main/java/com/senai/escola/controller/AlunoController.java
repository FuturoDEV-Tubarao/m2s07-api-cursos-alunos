package com.senai.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.escola.model.Aluno;
import com.senai.escola.model.Curso;
import com.senai.escola.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        var alunos = alunoService.consultar();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<Aluno> consultarPeloCodigo(@PathVariable Long cpf) {
        var aluno = alunoService.consultar(cpf);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        alunoService.inserir(aluno);
        return ResponseEntity.created(URI.create(aluno.getCpf().toString())).body(aluno);
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity<Curso> excluir(@PathVariable Long cpf) {
        alunoService.excluirPorCodigo(cpf);
        return ResponseEntity.noContent().build();
    }

}
