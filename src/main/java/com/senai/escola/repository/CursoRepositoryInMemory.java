package com.senai.escola.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.senai.escola.exception.RegistroNaoExistenteException;
import com.senai.escola.model.Curso;

@Repository
public class CursoRepositoryInMemory {
    
    private List<Curso> lista = new ArrayList<>();


    public List<Curso> consultar() {
        return lista;
    }

    public Optional<Curso> consultar(Integer codigo) {
        for(var curso : lista) {
            if (curso.getCodigo().intValue() == codigo.intValue())
                return Optional.of(curso);
        }
        return Optional.empty();
    }

    public void salvar(Curso curso) {
        lista.add(curso);
    }

    public void atualizar(Curso atualizado) {
        List<Curso> nova = new ArrayList<>();
        for(var curso : lista) {
            if (curso.getCodigo().intValue() == atualizado.getCodigo().intValue())
                nova.add(atualizado);
            else
                nova.add(curso);
        }
        this.lista = nova;
    }

    public void excluir(Curso cursoExclusao) {
        var cursoOpt = this.consultar(cursoExclusao.getCodigo());
        if (cursoOpt.isEmpty())
            throw new RegistroNaoExistenteException();
        List<Curso> nova = new ArrayList<>();
        for(var curso : lista) {
            if (curso.getCodigo().intValue() == cursoExclusao.getCodigo().intValue())
                continue;
            nova.add(curso);
            }
        this.lista = nova;
    }

}
