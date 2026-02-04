package br.com.fabionicola.cobranca_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handlerValidacao(MethodArgumentNotValidException e){

        var erros = e.getBindingResult().getFieldErrors()
        .stream()
        .map(err -> err.getField() + ":" + err.getDefaultMessage())
        .collect(Collectors.toList());

        Map<String, Object> body = Map.of(
            "timestamp", LocalDateTime.now().toString(),
            "status", 400,
            "error", "Bad Request",
            "message", "Erro Validação",
            "fields", erros
        );
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
