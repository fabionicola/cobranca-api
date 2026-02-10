package br.com.fabionicola.cobranca_api.dto;

import br.com.fabionicola.cobranca_api.model.StatusTitulo;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TituloResponse {
    private Long id;
    private Long clienteId;
    private BigDecimal valor;
    private LocalDate vencimento;
    private String descricao;
    private StatusTitulo status;
    private LocalDateTime criadoEm;
    private LocalDateTime pagoEm;
    
}
