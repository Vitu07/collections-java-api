package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {

    private List<Pessoa> personList;

    public OrdenacaoPessoa() {
        this.personList = new ArrayList<>();
    }

    private void adcionarPessoa(String nome, int idade, double altura){
        personList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(personList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(personList);
        Collections.sort(pessoasPorAltura, new ComparatorPorALtura() );
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adcionarPessoa("Nome 1", 15, 1.84);
        ordenacaoPessoa.adcionarPessoa("Nome 2", 50, 1.92);
        ordenacaoPessoa.adcionarPessoa("Nome 3", 44, 1.55);
        ordenacaoPessoa.adcionarPessoa("Nome 4", 21, 1.71);

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());


    }
}
