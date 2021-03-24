package br.com.backend.services.validation.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.backend.domains.Cliente;
import br.com.backend.domains.dto.clienteDTO.ClienteBasicDTO;
import br.com.backend.repositories.ClienteRepository;
import br.com.backend.resources.exceptions.FieldMessage;
import br.com.backend.services.validation.annotations.ClienteUpdate;

// classe utilizada para implementar as valições da anotação @ClienteUpdate

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteBasicDTO> {

    // acessa os parametros inseridos na requisição
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteBasicDTO objDto, ConstraintValidatorContext context) {

        // pega e converte os parametros da requisição
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        // pega o valor do campo id inserido na requisição
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        // busca um usuario pelo email no banco
        Cliente cliente = repository.findByEmail(objDto.getEmail());

        // verifica se o email ja esta no banco
        // caso o email ja esteja cadastrado verifica se o id do usuario atualizado é o
        // mesmo do encontrado no banco
        if (cliente != null && !cliente.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "Email já cadastrado"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
