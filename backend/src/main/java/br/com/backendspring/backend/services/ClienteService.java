package br.com.backendspring.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Cliente;
import br.com.backendspring.backend.domains.dto.ClienteDTO;
import br.com.backendspring.backend.repositories.ClienteRepository;
import br.com.backendspring.backend.services.exceptions.DataIntegrityException;
import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<ClienteDTO> findAll() {
        return repository.findAll().stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(ClienteDTO clienteDTO) {
        Cliente cliente = findById(clienteDTO.getId());
        updateData(clienteDTO, cliente);
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel remover um Cliente com pedidos vinculados a ele");
        }
    }

    public Page<ClienteDTO> findPage(Integer page, Integer size, String direction, String properties) {
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), properties);
        return repository.findAll(pageRequest).map(c -> new ClienteDTO(c));
    }

    private void updateData(ClienteDTO clienteDTO, Cliente cliente) {
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
    }

}
