package br.com.fabionicola.cobranca_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public Long getClienteId(){
        return clienteId;
    }

    public void setClienteId(Long clienteId){
        this.clienteId = clienteId;
    }

    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
