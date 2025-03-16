package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> productSet;

    public CadastroProdutos() {
        productSet = new HashSet<>();
    }

    public void adcionarPorduto(String nome, long codigo, double preco, int quantidade) {
        productSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    //Para ordenar voce cria um novo Set, mas ao invés de ser HashSet você usar o TreeSet
    //Isso porque com HashSet não é possivel organizar o Set, para organizar utiliza o TreeSet
    //Dentro do TreeSet você pode colocar um Comparator ou uma Collection;
    //Como esta utilizando o Comparable voce coloca productSet
    //Diferente do List não é necessario usar o sort do Collection, o TreeSet já organiza
    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(productSet);
        return produtosPorNome;
    }

    //Parecido com o comparable porém, você cria um novo Set, intancia o Comparator que vccê criou detro TreeSet
    //E adciona no Set produtosPorPreco;
    //
    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(productSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        //Por conta do hashcode produtos que tem o mesmo código não podem estar dentro do mesmo SET
        //Um exemplo disso seria ao tentar adcionar o produto fanta, como ele possui o mesmo codigo da pepesi ele não é adcionado ao SET
        cadastroProdutos.adcionarPorduto("Coca", 123, 10, 2);
        cadastroProdutos.adcionarPorduto("Algodao", 234, 2, 1);
        cadastroProdutos.adcionarPorduto("Pepsi", 345, 12, 1);
        cadastroProdutos.adcionarPorduto("Fanta", 345, 8, 1);
        cadastroProdutos.adcionarPorduto("Bala", 456, 0.50, 10);
        cadastroProdutos.adcionarPorduto("Redbull", 567, 9, 1);
        cadastroProdutos.adcionarPorduto("Cafe, 789",678, 20, 1 );

        System.out.println(cadastroProdutos.productSet);
        System.out.println("ordem alfabética: " + cadastroProdutos.exibirProdutosPorNome());
        System.out.println("ordem por preco: " + cadastroProdutos.exibirProdutosPorPreco());


    }


}
