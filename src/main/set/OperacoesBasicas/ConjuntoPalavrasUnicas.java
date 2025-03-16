package main.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> uniqueWordSet;

    public ConjuntoPalavrasUnicas() {
        this.uniqueWordSet = new HashSet<>();
    }

    public void adcionarPalavra(String palavra){
        uniqueWordSet.add(palavra);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConjuntoPalavrasUnicas that = (ConjuntoPalavrasUnicas) o;
        return Objects.equals(uniqueWordSet, that.uniqueWordSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueWordSet);
    }

    public void removerPalavra(String palavra){
        String palavrasParaRemover = null;
        for (String p  : uniqueWordSet){
            if (p.equalsIgnoreCase(palavra)){
                palavrasParaRemover = p;
            }
        }
        uniqueWordSet.remove(palavrasParaRemover);
    }

    public String verificarPalavra(String palavra){
        return uniqueWordSet.contains(palavra)
                ? "A palavra está no conjunto"
                : "A palavra não está no conjunto";
    }

    public void exibirPalavrasUnicas(){
        System.out.println(uniqueWordSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();


        conjuntoPalavrasUnicas.adcionarPalavra("Moon");
        conjuntoPalavrasUnicas.adcionarPalavra("Sun");
        conjuntoPalavrasUnicas.adcionarPalavra("Mars");
        conjuntoPalavrasUnicas.adcionarPalavra("Sun");
        conjuntoPalavrasUnicas.adcionarPalavra("Venus");

        conjuntoPalavrasUnicas.removerPalavra("Mars");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Earth"));

    }
}
