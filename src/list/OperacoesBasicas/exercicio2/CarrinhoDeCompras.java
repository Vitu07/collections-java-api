package list.OperacoesBasicas.exercicio2;

import list.OperacoesBasicas.exercicio1.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> shoppingCart;

    public CarrinhoDeCompras() {
        this.shoppingCart = new ArrayList<>();
    }

    public void adcionarItem(String nome, double preco, int quantidade){
        shoppingCart.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemsParaRemover = new ArrayList<>();
        for (Item i: shoppingCart){
            if (i.getNome().equalsIgnoreCase(nome)){
                itemsParaRemover.add(i);
            }
        }
        shoppingCart.removeAll(itemsParaRemover);
    }

    public void exibirItems(){
        System.out.println(shoppingCart);
    }

    public double calcularValorTotal(){
        double totalCarrinho =0;
        for (Item i : shoppingCart){
            double valor = i.getPreco() * i.getQuantidade();
            totalCarrinho += valor;
        }
        return totalCarrinho;
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adcionarItem("prato", 7, 3);
        carrinhoDeCompras.adcionarItem("copo",  5, 4);
        carrinhoDeCompras.adcionarItem("bandeija",  20, 1);

        System.out.println("O valor total do carrinho " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItems();
        carrinhoDeCompras.removerItem("copo");
        carrinhoDeCompras.exibirItems();
        System.out.println("O valor total do carrinho " + carrinhoDeCompras.calcularValorTotal());
    }


}
