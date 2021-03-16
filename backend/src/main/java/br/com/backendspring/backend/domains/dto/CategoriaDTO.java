package br.com.backendspring.backend.domains.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CategoriaDTO {

    private Integer id;

    @NotEmpty(message = "O campo deve ser preenchido")
    @Size(min = 3, max = 80, message = "O campo deve ter entre 3 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
