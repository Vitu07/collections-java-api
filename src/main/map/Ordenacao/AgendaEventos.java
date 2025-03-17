package main.map.Ordenacao;

import main.map.OperacoesBasicas.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    Map<LocalDate, Evento> agendaEventoMap;

    public AgendaEventos() {
        this.agendaEventoMap = new HashMap<>();
    }

    public void adcionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventoMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventoMap);

        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adcionarEvento(LocalDate.of(2025, Month.MARCH, 16), "Evento 1", "Atracao 1");
        agendaEventos.adcionarEvento(LocalDate.of(2025, 3, 17), "Evento 2", "Atracao 2");
        agendaEventos.adcionarEvento(LocalDate.of(2025, Month.FEBRUARY, 25), "Evento 3", "Atracao 3");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }

}
