package br.com.fabionicola.cobranca_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.fabionicola.cobranca_api.dto.TituloCreateRequest;
import br.com.fabionicola.cobranca_api.dto.TituloResponse;
import br.com.fabionicola.cobranca_api.model.Titulo;
import br.com.fabionicola.cobranca_api.service.TituloService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/titulos")
public class TituloController {
    
    private final TituloService tituloService;
    
    public TituloController(TituloService tituloService){
        this.tituloService = tituloService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Titulo criar(@RequestBody @Valid TituloCreateRequest request){
        return tituloService.criar(request);
    }

    
    @GetMapping
    public List<TituloResponse> listar() {
        return tituloService.listarTodos();
    }

    @GetMapping("/{id}")
    public TituloResponse buscarPorId(@PathVariable Long id) {
        return tituloService.buscarPorId(id);
    }

}
