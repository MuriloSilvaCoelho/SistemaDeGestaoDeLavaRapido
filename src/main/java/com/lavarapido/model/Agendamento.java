package com.lavarapido.model;

import java.time.LocalDateTime;

/** Liga um veículo a um tipo de serviço em uma data e horário. */
public class Agendamento {
    private final int id;
    private Veiculo veiculo;
    private TipoServico tipoServico;
    private LocalDateTime dataHora;
    private StatusAgendamento status;

    public Agendamento(int id, Veiculo veiculo, TipoServico tipoServico, LocalDateTime dataHora) {
        this.id = id;
        this.veiculo = veiculo;
        this.tipoServico = tipoServico;
        this.dataHora = dataHora;
        this.status = StatusAgendamento.AGENDADO;
    }

    public int getId() { return id; }
    public Veiculo getVeiculo() { return veiculo; }
    public TipoServico getTipoServico() { return tipoServico; }
    public LocalDateTime getDataHora() { return dataHora; }
    public StatusAgendamento getStatus() { return status; }

    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
    public void setTipoServico(TipoServico tipoServico) { this.tipoServico = tipoServico; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setStatus(StatusAgendamento status) { this.status = status; }
}
