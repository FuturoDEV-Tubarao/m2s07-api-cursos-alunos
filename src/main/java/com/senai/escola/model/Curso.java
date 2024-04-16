package com.senai.escola.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // Entidade JPA 
@Table(name = "Cursos")  // Nome da Tabela
public class Curso {

    @Id
    private Integer codigo;

    private Float preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "descricao")  // esta anotacao indica qual a coluna da tabela este campo representa
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    // @OneToMany(mappedBy = "curso")
    // private List<Aluno> alunos;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    // public List<Aluno> getAlunos() {
    //     return alunos;
    // }

    // public void setAlunos(List<Aluno> alunos) {
    //     this.alunos = alunos;
    // }

}
