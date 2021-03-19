package br.com.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.domains.Cidade;
import br.com.backend.domains.Cliente;
import br.com.backend.domains.Endereco;
import br.com.backend.domains.dto.clienteDTO.ClienteBasicDTO;
import br.com.backend.domains.dto.clienteDTO.ClienteNewDTO;
import br.com.backend.repositories.ClienteRepository;
import br.com.backend.repositories.EnderecoRepository;
import br.com.backend.services.exceptions.DataIntegrityException;
import br.com.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<ClienteBasicDTO> findAll() {
        return clienteRepository.findAll().stream().map(c -> new ClienteBasicDTO(c)).collect(Collectors.toList());
    }

    @Transactional
    public Cliente save(ClienteNewDTO obj) {
        Cliente cliente = clienteNew(obj);
        cliente = clienteRepository.save(cliente);
        enderecoRepository.saveAll(cliente.getEnderecos());
        return cliente;
    }

    public Cliente update(ClienteBasicDTO clienteDTO) {
        Cliente cliente = findById(clienteDTO.getId());
        updateData(clienteDTO, cliente);
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel remover um Cliente com pedidos vinculados a ele");
        }
    }

    public Page<ClienteBasicDTO> findPage(Integer page, Integer size, String direction, String properties) {
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), properties);
        return clienteRepository.findAll(pageRequest).map(c -> new ClienteBasicDTO(c));
    }

    private void updateData(ClienteBasicDTO clienteDTO, Cliente cliente) {
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
    }

    private Cliente clienteNew(ClienteNewDTO obj) {
        Cliente cliente = new Cliente(obj);
        Cidade cidade = new Cidade(obj.getCidadeId(), null, null);
        Endereco endereco = new Endereco(obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getBairro(),
                obj.getCep(), cliente, cidade);
        cliente.getEnderecos().add(endereco);
        cliente.getTelefones().add(obj.getTelefone1());

        if (obj.getTelefone2() != null) {
            cliente.getTelefones().add(obj.getTelefone2());
        }
        if (obj.getTelefone3() != null) {
            cliente.getTelefones().add(obj.getTelefone3());
        }
        return cliente;
    }

}
