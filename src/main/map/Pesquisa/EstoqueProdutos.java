package main.map.Pesquisa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueMap;

    public EstoqueProdutos() {
        this.estoqueMap = new HashMap<>();
    }

    public void adcionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(estoqueMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0;
        if (!estoqueMap.isEmpty()) {
            for (Produto p : estoqueMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueMap.isEmpty()) {
            for (Produto p : estoqueMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoqueMap.isEmpty()){
            for (Produto p : estoqueMap.values()){
                if (p.getPreco() < menorPreco){
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalEstoque(){
        Produto produtoMaiorQuantidadeEstoque = null;
        double valorTotalProduto = Double.MIN_VALUE;
        if (!estoqueMap.isEmpty()){
            for (Produto p : estoqueMap.values()){
                if (valorTotalProduto < p.getPreco() * p.getQuantidade()){
                    produtoMaiorQuantidadeEstoque = p;
                    valorTotalProduto = p.getPreco() * p.getQuantidade();
                }
            }
        }
        return produtoMaiorQuantidadeEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adcionarProduto(1234, "celular", 100, 2500);
        estoqueProdutos.adcionarProduto(2345, "bicicleta", 200, 1800);
        estoqueProdutos.adcionarProduto(3456, "pneu",10000 , 300);
        estoqueProdutos.adcionarProduto(4567, "Televisão", 450, 3000);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total do estoque " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("Produto mais caro " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato : " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalEstoque());
    }
}
