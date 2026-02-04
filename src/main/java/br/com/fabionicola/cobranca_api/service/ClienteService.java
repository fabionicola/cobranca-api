package br.com.fabionicola.cobranca_api.service;

import br.com.fabionicola.cobranca_api.exception.ClienteNaoEncontradoException;
import br.com.fabionicola.cobranca_api.model.Cliente;
import br.com.fabionicola.cobranca_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ClienteService {
    
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public Cliente criar (Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listar(){
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    public Cliente atualizar(Long id, Cliente dados){
        Cliente existente = buscarPorId(id);

        existente.setNome(dados.getNome());
        existente.setDocumento(dados.getDocumento());
        existente.setEmail(dados.getEmail());
        existente.setTelefone(dados.getTelefone());

        return repository.save(existente);
    }

    public void deletar(Long id){
        //garente erro se não existir
        buscarPorId(id);
        repository.deleteById(id);
    }

}
