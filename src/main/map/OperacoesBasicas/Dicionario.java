package main.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adcionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        }
    }

    public String pesquisaPorPalavra(String palavra) {
        String definicaoPorPalavra = null;
        if (!dicionarioMap.isEmpty()) {
            definicaoPorPalavra = dicionarioMap.get(palavra);
        }
        return definicaoPorPalavra;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adcionarPalavra("Palavra 1", "Definicao da palavra 1");
        dicionario.adcionarPalavra("Palavra 2", "Definicao da palavra 2");
        dicionario.adcionarPalavra("Palavra 3", "Definicao da palavra 3");
        dicionario.adcionarPalavra("Palavra 4", "Definicao da palavra 4");

        dicionario.exibirPalavras();
        System.out.println(dicionario.pesquisaPorPalavra("Palavra 2"));
        dicionario.removerPalavra("Palavra 4");
        dicionario.exibirPalavras();


    }

}
