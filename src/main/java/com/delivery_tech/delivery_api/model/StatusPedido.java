package com.delivery_tech.delivery_api.model;

public enum StatusPedido {

    // O momento em que o pedido foi criado pelo cliente, mas ainda não foi confirmado pelo restaurante.
    CRIADO("Criado"),
    // Aguardando ser confirmado pelo restaurante - Restaurante
    PENDENTE("Pendente"),
    // O restaurante confirmou que recebeu o pedido e que vai prepará-lo - Restaurante
    CONFIRMADO("Confirmado"),
    // O restaurante preparando o pedido - Restaurante
    PREPARANDO("Preparando"),
    // Saiu o pedido para entrega - Moto entregador
    SAIU_PARA_ENTREGA("Saiu Para Entrega"),
    // Entegue o pedido - Moto entregador
    ENTREGUE("Entregue"),
    // O Usuário realizou o cancelamento
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
