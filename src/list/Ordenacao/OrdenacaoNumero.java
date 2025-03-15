package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumero implements Comparable<Integer> {

    private List<Integer> numberOrder;
    private int number;

    public OrdenacaoNumero() {
        this.numberOrder = new ArrayList<>();
    }

    public void adcionarNumero(int numero){
        numberOrder.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> listaAscendente = new ArrayList<>(numberOrder);
        Collections.sort(listaAscendente);
        return listaAscendente;
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> listaDescendente = new ArrayList<>(numberOrder);
        Collections.sort(listaDescendente, Collections.reverseOrder());
        return listaDescendente;
    }

    @Override
    public int compareTo(Integer p) {
        return Integer.compare(p, number);
    }

    public static void main(String[] args) {
        OrdenacaoNumero ordenacaoNumero = new OrdenacaoNumero();

        ordenacaoNumero.adcionarNumero(5);
        ordenacaoNumero.adcionarNumero(1);
        ordenacaoNumero.adcionarNumero(7);
        ordenacaoNumero.adcionarNumero(-3);

        System.out.println(ordenacaoNumero.ordenarAscendente());
        System.out.println(ordenacaoNumero.ordenarDescendente());
    }
}
