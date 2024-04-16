package com.senai.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
