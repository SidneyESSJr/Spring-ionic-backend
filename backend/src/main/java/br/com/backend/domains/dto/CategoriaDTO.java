package br.com.backend.domains.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.backend.domains.Categoria;

public class CategoriaDTO {

    private Integer id;

    @NotEmpty(message = "O campo deve ser preenchido")
    @Length(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
