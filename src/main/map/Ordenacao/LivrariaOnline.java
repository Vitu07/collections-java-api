package main.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    Map<String, Livro> livrariaMap;

    public LivrariaOnline() {
        this.livrariaMap = new HashMap<>();
    }

    public void adcionarLivro(String link, String nome, String autor, double preco){
        livrariaMap.put(link, new Livro(nome, autor, preco));
    }

    public void removerLivro(String titulo){
        if (!livrariaMap.isEmpty()){
            livrariaMap.remove(titulo);
        }
    }

    public Map<String, Livro> exibirLivros(){
        Map<String, Livro> livrosPorPreco = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                Livro livro1 = livrariaMap.get(k1);
                Livro livro2 = livrariaMap.get(k2);
                return Double.compare(livro1.getPreco(), livro2.getPreco());
            }
        });
        livrosPorPreco.putAll(livrariaMap);
        return livrosPorPreco;
    }

    public Map<String, Livro> pesquisarPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new TreeMap<>();
        for (var entry: livrariaMap.entrySet()){
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for (Livro l : livrariaMap.values()){
            if (l.getPreco() > maiorPreco){
                livroMaisCaro = l;
                maiorPreco = l.getPreco();
            }
        }
        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato(){
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Livro l : livrariaMap.values()){
            if (l.getPreco() < menorPreco){
                livroMaisBarato = l;
                menorPreco = l.getPreco();
            }
        }
        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adcionarLivro("link do livro 1", "livro 1", "autor do livro 1", 25);
        livrariaOnline.adcionarLivro("link do livro 2", "livro 2", "autor do livro 2", 15);
        livrariaOnline.adcionarLivro("link do livro 3", "livro 3", "autor do livro 2", 15);
        livrariaOnline.adcionarLivro("link do livro 4", "livro 4", "autor do livro 3", 20);
        livrariaOnline.adcionarLivro("link do livro 5", "livro 5", "autor do livro 4", 50);

        System.out.println(livrariaOnline.exibirLivros());
        System.out.println(livrariaOnline.pesquisarPorAutor("autor do livro 2"));
        System.out.println(livrariaOnline.obterLivroMaisCaro());
        System.out.println(livrariaOnline.obterLivroMaisBarato());
    }

}
