package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contactAgenda;

    public AgendaContatos() {
        this.contactAgenda = new HashSet<>();
    }

    public void adcionarContato(String nome, String numero){
        contactAgenda.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contactAgenda);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for(Contato c : contactAgenda){
            if (c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, String novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contactAgenda){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adcionarContato("Vitor", "1234");
        agendaContatos.adcionarContato("Vitor M", "2345");
        agendaContatos.adcionarContato("Vitor F", "3456");
        agendaContatos.adcionarContato("Maria", "4567");

        agendaContatos.exibirContatos();
        System.out.println(agendaContatos.pesquisarPorNome("Vitor"));
        System.out.println("O novo numero de contato atualizado é " + agendaContatos.atualizarNumeroContato("Vitor", "0123"));



    }
}
