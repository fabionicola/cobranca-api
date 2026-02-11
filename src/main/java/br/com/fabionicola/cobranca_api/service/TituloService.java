package br.com.fabionicola.cobranca_api.service;

import org.springframework.stereotype.Service;

import br.com.fabionicola.cobranca_api.dto.TituloCreateRequest;
import br.com.fabionicola.cobranca_api.dto.TituloResponse;
import br.com.fabionicola.cobranca_api.dto.TituloUpdateRequest;
import br.com.fabionicola.cobranca_api.exception.ClienteNaoEncontradoException;
import br.com.fabionicola.cobranca_api.exception.TituloNaoEncontradoException;
import br.com.fabionicola.cobranca_api.model.Cliente;
import br.com.fabionicola.cobranca_api.model.StatusTitulo;
import br.com.fabionicola.cobranca_api.model.Titulo;
import br.com.fabionicola.cobranca_api.repository.ClienteRepository;
import br.com.fabionicola.cobranca_api.repository.TituloRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TituloService {
    private final TituloRepository tituloRepository;
    private final ClienteService clienteService;
    
    public TituloService(TituloRepository tituloRepository, ClienteService clienteService){
        this.tituloRepository = tituloRepository;
        this.clienteService = clienteService;
    }

    public Titulo criar(TituloCreateRequest request){
        Cliente cliente = clienteService.buscarPorId(request.getClienteId());

        Titulo titulo = new Titulo();
        titulo.setCliente(cliente);
        titulo.setValor(request.getValor());
        titulo.setVencimento(request.getVencimento());
        titulo.setDescricao(request.getDescricao());
        titulo.setStatus(StatusTitulo.ABERTO);
        //status ja nasce ABERTO na entidade (default)
        //criadoEm via @Prepersist

        return tituloRepository.save(titulo);
    }

    
    public List<Titulo> listar() {
        return tituloRepository.findAll();
    }

    public Titulo buscarPorId(Long id) {
        return tituloRepository.findById(id)
        .orElseThrow(() -> new TituloNaoEncontradoException(id));
    }

    public Titulo atualizar(Long id, TituloUpdateRequest request){
        Titulo existente = buscarPorId(id);
        existente.setValor(request.getValor());
        existente.setVencimento(request.getVencimento());
        existente.setDescricao(request.getDescricao());
        return tituloRepository.save(existente);
    }

    public void deletar(Long id){
        buscarPorId(id);
        tituloRepository.deleteById(id);
    }

}
