package br.com.backend.domains.dto.clienteDTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.backend.domains.Cliente;
import br.com.backend.services.validation.annotations.ClienteUpdate;

@ClienteUpdate
public class ClienteBasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo deve ser preenchido")
    @Length(min = 3, max = 120, message = "O campo deve ter entre 3 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "O campo deve ser preenchido")
    @Email(message = "Email invalido")
    private String email;

    public ClienteBasicDTO() {

    }

    public ClienteBasicDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
