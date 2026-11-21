package com.lavarapido.service;

import com.lavarapido.model.Agendamento;
import com.lavarapido.model.StatusAgendamento;
import com.lavarapido.model.TipoServico;
import com.lavarapido.model.Veiculo;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Regras de negócio da agenda. Não permite dois agendamentos ativos no mesmo horário. */
public class ServicoAgendamento {
    private final List<Agendamento> agendamentos = new ArrayList<>();
    private int proximoId = 1;

    public List<Agendamento> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(agendamentos));
    }

    public Agendamento buscarPorId(int id) {
        return agendamentos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Agendamento agendar(Veiculo veiculo, TipoServico servico, LocalDateTime dataHora) {
        validarEntrada(veiculo, servico, dataHora);
        verificarConflito(dataHora, -1);
        Agendamento agendamento = new Agendamento(proximoId++, veiculo, servico, dataHora);
        agendamentos.add(agendamento);
        return agendamento;
    }

    public void atualizar(int id, Veiculo veiculo, TipoServico servico, LocalDateTime dataHora) {
        Agendamento agendamento = buscarPorId(id);
        if (agendamento == null) throw new IllegalArgumentException("Agendamento não encontrado.");
        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("Não é possível editar um agendamento cancelado.");
        }
        validarEntrada(veiculo, servico, dataHora);
        verificarConflito(dataHora, id);
        agendamento.setVeiculo(veiculo);
        agendamento.setTipoServico(servico);
        agendamento.setDataHora(dataHora);
    }

    public void cancelar(int id) {
        Agendamento agendamento = buscarPorId(id);
        if (agendamento == null) throw new IllegalArgumentException("Agendamento não encontrado.");
        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("Esse agendamento já está cancelado.");
        }
        agendamento.setStatus(StatusAgendamento.CANCELADO);
    }

    public void concluir(int id) {
        Agendamento agendamento = buscarPorId(id);
        if (agendamento == null) throw new IllegalArgumentException("Agendamento não encontrado.");
        if (agendamento.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("Um agendamento cancelado não pode ser concluído.");
        }
        agendamento.setStatus(StatusAgendamento.CONCLUIDO);
    }

    public List<Agendamento> listarPorDia(LocalDate dia) {
        List<Agendamento> resultado = new ArrayList<>();
        for (Agendamento a : agendamentos) {
            if (a.getDataHora().toLocalDate().equals(dia)) resultado.add(a);
        }
        return resultado;
    }

    public List<Agendamento> listarPorSemana(LocalDate dataReferencia) {
        LocalDate inicio = dataReferencia.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate fim = inicio.plusDays(6);
        List<Agendamento> resultado = new ArrayList<>();
        for (Agendamento a : agendamentos) {
            LocalDate dia = a.getDataHora().toLocalDate();
            if (!dia.isBefore(inicio) && !dia.isAfter(fim)) resultado.add(a);
        }
        return resultado;
    }

    public boolean temAgendamentoAtivoParaServico(int servicoId) {
        return agendamentos.stream().anyMatch(a ->
                a.getTipoServico().getId() == servicoId
                && a.getStatus() == StatusAgendamento.AGENDADO);
    }

    public boolean temAgendamentoAtivoParaVeiculo(int veiculoId) {
        return agendamentos.stream().anyMatch(a ->
                a.getVeiculo().getId() == veiculoId
                && a.getStatus() == StatusAgendamento.AGENDADO);
    }

    private void validarEntrada(Veiculo veiculo, TipoServico servico, LocalDateTime dataHora) {
        if (veiculo == null || servico == null || dataHora == null) {
            throw new IllegalArgumentException("Selecione um veículo, um serviço e uma data/hora.");
        }
    }

    private void verificarConflito(LocalDateTime dataHora, int idIgnorado) {
        boolean conflito = agendamentos.stream().anyMatch(a ->
                a.getId() != idIgnorado
                && a.getStatus() == StatusAgendamento.AGENDADO
                && a.getDataHora().equals(dataHora));
        if (conflito) {
            throw new IllegalArgumentException(
                    "Já existe um serviço agendado nesse dia e horário. Escolha outro horário.");
        }
    }
}
