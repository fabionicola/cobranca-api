package br.com.fabionicola.cobranca_api.service;

import org.springframework.stereotype.Service;

import br.com.fabionicola.cobranca_api.dto.TituloCreateRequest;
import br.com.fabionicola.cobranca_api.exception.ClienteNaoEncontradoException;
import br.com.fabionicola.cobranca_api.model.Cliente;
import br.com.fabionicola.cobranca_api.model.Titulo;
import br.com.fabionicola.cobranca_api.repository.ClienteRepository;
import br.com.fabionicola.cobranca_api.repository.TituloRepository;

@Service
public class TituloService {
    private final TituloRepository tituloRepository;
    private final ClienteRepository clienteRepository;
    
    public TituloService(TituloRepository tituloRepository, ClienteRepository clienteRepository){
        this.tituloRepository = tituloRepository;
        this.clienteRepository = clienteRepository;
    }

    public Titulo criar(TituloCreateRequest request){
        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow(() -> new ClienteNaoEncontradoException(request.getClienteId()));

        Titulo titulo = new Titulo();
        titulo.setCliente(cliente);
        titulo.setValor(request.getValor());
        titulo.setVencimento(request.getVencimento());
        titulo.setDescricao(request.getDescricao());
        //status ja nasce ABERTO na entidade (default)
        //criadoEm via @Prepersist

        return tituloRepository.save(titulo);
    }
}
