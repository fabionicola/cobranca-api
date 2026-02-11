package br.com.fabionicola.cobranca_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TituloUpdateRequest {
    
    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private LocalDate vencimento;

    @NotBlank
    @Size(min = 1, max = 255)
    private String descricao;
}
