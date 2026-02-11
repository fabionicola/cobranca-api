package br.com.fabionicola.cobranca_api.exception;

public class TituloNaoEncontradoException extends RuntimeException{
    public TituloNaoEncontradoException(Long id){
        super("Titulo não encontrado: id = " + id);
    }
    
}
