package com.lavarapido.model;

/**
 * Situações possíveis de um agendamento.
 */
public enum StatusAgendamento {
    AGENDADO("Agendado"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluído");

    private final String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
