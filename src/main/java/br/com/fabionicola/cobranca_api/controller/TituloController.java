package br.com.fabionicola.cobranca_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fabionicola.cobranca_api.dto.TituloCreateRequest;
import br.com.fabionicola.cobranca_api.dto.TituloResponse;
import br.com.fabionicola.cobranca_api.dto.TituloUpdateRequest;
import br.com.fabionicola.cobranca_api.model.Titulo;
import br.com.fabionicola.cobranca_api.service.TituloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/titulos")
public class TituloController {
    
    private final TituloService tituloService;
    
    public TituloController(TituloService tituloService){
        this.tituloService = tituloService;
    }

    @PostMapping
    public ResponseEntity<TituloResponse> criar(@Valid @RequestBody TituloCreateRequest request){
        Titulo salvo = tituloService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(salvo));
    }

    
    @GetMapping
    public List<TituloResponse> listar() {
        return tituloService.listar()
            .stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TituloResponse buscarPorId(@PathVariable Long id) {
        return toResponse(tituloService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public TituloResponse atualizar(@PathVariable Long id, @Valid @RequestBody TituloUpdateRequest request) {
        return toResponse(tituloService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        tituloService.deletar(id);
    }

    private TituloResponse toResponse(Titulo t){
        TituloResponse dto = new TituloResponse();
        dto.setId(t.getId());
        dto.setClienteId(t.getCliente().getId());
        dto.setValor(t.getValor());
        dto.setVencimento(t.getVencimento());
        dto.setDescricao(t.getDescricao());
        dto.setStatus(t.getStatus());
        dto.setCriadoEm(t.getCriadoEm());
        dto.setPagoEm(t.getPagoEm());
        return dto;
    }
}
