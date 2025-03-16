package main.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> contagemPalavraMap;

    public ContagemPalavras() {
        this.contagemPalavraMap = new HashMap<>();
    }

    public void adcionarPalavra(String palavra, Integer contagem) {
        contagemPalavraMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemPalavraMap.isEmpty()) {
            contagemPalavraMap.remove(palavra);
        }
    }

    public void exibirContagemPalavra() {
        if (!contagemPalavraMap.isEmpty()) {
            System.out.println(contagemPalavraMap);
        }
    }

    public Map<String, Integer> encontrarPalavraMaisFrequente() {
        Map<String, Integer> palavraMaisFrequente = new HashMap<>();
        String palavraMax = null;
        int maxFrequencia = Integer.MIN_VALUE;

        if (!contagemPalavraMap.isEmpty()) {
            for (String palavra : contagemPalavraMap.keySet()) {
                int frequencia = contagemPalavraMap.get(palavra);
                if (frequencia > maxFrequencia) {
                    maxFrequencia = frequencia;
                    palavraMax = palavra;
                }
            }
            palavraMaisFrequente.put(palavraMax, maxFrequencia);
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();


        contagemPalavras.adcionarPalavra("agua", 20);
        contagemPalavras.adcionarPalavra("fogo", 20);
        contagemPalavras.adcionarPalavra("terra", 40);
        contagemPalavras.adcionarPalavra("vento", 33);
        contagemPalavras.adcionarPalavra("raio", 10);

        contagemPalavras.exibirContagemPalavra();

        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
