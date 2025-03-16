package main.set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

//Para utilizar o Comparable é necessário implementalo com o tipo de classe no generics(<>)

public class Produto implements Comparable<Produto>{
    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;


    public Produto(String nome, long codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "\nProduto{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    //Após isso você implementa sobrescrevendo o metodo compareTo
    //Em seu parametros você coloca o tipo classe
    //Nesse caso como é em uma String você coloca o atributo depois chama o compareToIgnoreCase dentro chama o produto e pega seu nome para comparacao
    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }
}
//Já o Comparator você tem que crio-lo fora da classe, implemetar com o tipo da classe
class ComparatorPorPreco implements Comparator<Produto>{

    //Metodo do comparator, recebe dois parametros produtos
    //Como é para comparar preco, você usa o Wrapper Double e chama o metodo compare
    //Dentro do compare, você usa o getter para pegar o preco de cada objeto;
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
