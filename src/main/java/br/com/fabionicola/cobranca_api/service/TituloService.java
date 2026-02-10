package br.com.fabionicola.cobranca_api.service;

import org.springframework.stereotype.Service;

import br.com.fabionicola.cobranca_api.dto.TituloCreateRequest;
import br.com.fabionicola.cobranca_api.dto.TituloResponse;
import br.com.fabionicola.cobranca_api.exception.ClienteNaoEncontradoException;
import br.com.fabionicola.cobranca_api.model.Cliente;
import br.com.fabionicola.cobranca_api.model.Titulo;
import br.com.fabionicola.cobranca_api.repository.ClienteRepository;
import br.com.fabionicola.cobranca_api.repository.TituloRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public TituloResponse toResponse(Titulo titulo){
        TituloResponse resp = new TituloResponse();
        resp.setId(titulo.getId());
        resp.setClienteId(titulo.getCliente().getId());
        resp.setValor(titulo.getValor());
        resp.setVencimento(titulo.getVencimento());
        resp.setDescricao(titulo.getDescricao());
        resp.setStatus(titulo.getStatus());
        resp.setCriadoEm(titulo.getCriadoEm());
        resp.setPagoEm(titulo.getPagoEm());
        return resp;
    }
    
    public List<TituloResponse> listarTodos() {
        return tituloRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TituloResponse buscarPorId(Long id) {
        Titulo titulo = tituloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Título com ID " + id + " não encontrado"));
        return toResponse(titulo);
    }

}
