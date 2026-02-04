package br.com.fabionicola.cobranca_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;;
import org.springframework.web.bind.annotation.ExceptionHandler;;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiExceptionHandler {
    
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<?>handleClienteNaoEncontradoException(ClienteNaoEncontradoException e){

        Map<String, Object> body = Map.of(
            "timestamp", LocalDateTime.now().toString(),
            "status", 404,
            "error", "Not Found",
            "message", e.getMessage()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
