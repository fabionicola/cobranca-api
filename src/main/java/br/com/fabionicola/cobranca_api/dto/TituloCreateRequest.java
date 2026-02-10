package br.com.fabionicola.cobranca_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TituloCreateRequest {
    
    @NotNull
    private Long clienteId;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private LocalDate vencimento;

    @NotNull
    @Size(min = 1, max = 255)
    private String descricao;

}
