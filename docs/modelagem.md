# Cobrança API - Modelagem (rascunho)

## Entidades

- Cliente: id, nome, documento, email, telefone
- Titulo: id, clienteId, valor, vencimento, status, dataPagamento(opcional), descrição

## Status do Título

- Aberto
- Pago
- Atrasado (ou derivado por data)