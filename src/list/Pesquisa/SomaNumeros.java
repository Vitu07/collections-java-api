package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numberList;

    public SomaNumeros() {
        this.numberList = new ArrayList<>();
    }

    public void adcionarNumeros(int numero){
        numberList.add(numero);
    }
    public double calcularSoma(){
        double soma =0;
        if (!numberList.isEmpty()){
            for (int i : numberList){
                soma += i;
            }
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        if (numberList.isEmpty()){
            throw new IllegalStateException("A lista está vazia");
        }
        int maiorNumero = numberList.get(0);
            for (int i : numberList){
                if (i > maiorNumero){
                    maiorNumero = i;
                }
            }

        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        if (numberList.isEmpty()){
            throw new IllegalStateException("A lista está vazia");
        }
        int menorNumero = numberList.get(0);
            for (int i : numberList){
                if (i <= menorNumero) {
                    menorNumero = i;
                }
            }
        return menorNumero;
    }

    @Override
    public String toString() {
        return "{" +
                "numberList " + numberList +
                '}';
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adcionarNumeros(7);
        somaNumeros.adcionarNumeros(-3);
        somaNumeros.adcionarNumeros(57);
        somaNumeros.adcionarNumeros(1);

        System.out.println(somaNumeros);
        System.out.println("O maior número da lista é " + somaNumeros.encontrarMaiorNumero());
        System.out.println("O menor número da lista é " + somaNumeros.encontrarMenorNumero());
        System.out.println("O valor da soma de todos os números é " + somaNumeros.calcularSoma());

    }
}
