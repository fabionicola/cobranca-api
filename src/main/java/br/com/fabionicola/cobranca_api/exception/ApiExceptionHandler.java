package br.com.fabionicola.cobranca_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ApiError> handleClienteNaoEncontrado(
            ClienteNaoEncontradoException e,
            HttpServletRequest request
    ) {
        ApiError body = new ApiError(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI(),
                request.getMethod(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    
        @ExceptionHandler(TituloNaoEncontradoException.class)
        public ResponseEntity<ApiError> handleTituloNaoEncontrado(
                TituloNaoEncontradoException e,
                HttpServletRequest request
        ) {
        ApiError body = new ApiError(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                "Título não encontrado",
                e.getMessage(),
                request.getRequestURI(),
                request.getMethod(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidacao(
            MethodArgumentNotValidException e,
            HttpServletRequest request
    ) {
        Map<String, String> fields = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors().forEach(err ->
                fields.put(err.getField(), err.getDefaultMessage())
        );

        ApiError body = new ApiError(
                LocalDateTime.now().toString(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Erro de validação",
                request.getRequestURI(),
                request.getMethod(),
                fields
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<ApiError> handleConstraintViolation(
                ConstraintViolationException e,
                HttpServletRequest request
        ) {
        ApiError body = new ApiError(
                LocalDateTime.now().toString(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI(),
                request.getMethod(),
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

}