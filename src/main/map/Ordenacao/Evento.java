package main.map.Ordenacao;

public class Evento {
    private String evento;
    private String atracao;

    public Evento(String evento, String atracao) {
        this.evento = evento;
        this.atracao = atracao;
    }

    public String getNomeEvento() {
        return evento;
    }

    public String getNomeAtracao() {
        return atracao;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "evento='" + evento + '\'' +
                ", atracao='" + atracao + '\'' +
                '}';
    }
}
