package main.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    //A interface Map é usada para mapear dados na forma de chave-valor
    //O map por padrão não pode conter chaves duplicadas, então não necessário o uso do equal e hashcode
    //Cada chave possui no máximo um valor
    //Para usar você chama interface Map e coloca o tipo da chave e o tipo do valor dentro do generics <>
    //ex: Map<String, Integer>;
    private Map<String, Integer> agendaContatoMap;

    //O map possui 3 implementacoes: HashMap(nao mantem uma ordem especifica dos elementos), TreeMap(permite organizar os elementos em uma ordem especifica
    //E o linkedHashMap que preserva a ordem de insercao de elementos, todos permitem chaves e valores nulos;
    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }


    //As operacçoes basicas do map são put(inserir ou atualizar), get(obter), containsKey(verificar se contem uma chave),
    //contaisValue(verificar se contem um valor)
    //As operacoes de obter tamanho(size) e verificar se está vazio(isEmpty) continua igual
    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContato() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisaPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos  agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Contato 1", 1234);
        agendaContatos.adicionarContato("Contato 2", 2345);
        agendaContatos.adicionarContato("Contato 1", 3456);
        agendaContatos.adicionarContato("Contato 3", 1234);
        agendaContatos.adicionarContato("Contato 4", 4567);

        agendaContatos.exibirContato();
        System.out.println("numero: " + agendaContatos.pesquisaPorNome("Contato 4"));
        agendaContatos.removerContato("Contato 3");
        agendaContatos.exibirContato();
    }
}
