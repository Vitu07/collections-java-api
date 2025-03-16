package main.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> taskList;

    public ListaTarefas() {
        this.taskList = new HashSet<>();
    }

    public void adcionarTarefa(String descricao){
        taskList.add(new Tarefa(descricao));
    }

    public void  removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for (Tarefa t : taskList){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaRemover = t;
                break;
            }
        }
        taskList.remove(tarefaParaRemover);
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa>  tarefasConcluidas = new HashSet<>();
        for (Tarefa t : taskList){
            if (t.isTarefaConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : taskList){
            if (!t.isTarefaConcluida()){
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public Tarefa marcarTarefaConcluida(String descricao){
        Tarefa tarefaConcluida = null;
        for (Tarefa t : taskList){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                t.setTarefaConcluida(true);
                tarefaConcluida = t;
                break;
            }
        }
        return tarefaConcluida;
    }

    public Tarefa marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for (Tarefa t : taskList){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaPendente = t;
                break;
            }
        }
        return tarefaPendente;
    }

    public void limparTarefas(){
        Set<Tarefa> tarefasParaRemover = new HashSet<>(taskList);
        taskList.removeAll(tarefasParaRemover);
        System.out.println("Todas tarefas removidas!");
    }

    public void exibirTarefas(){
        System.out.println("Lista de tarefas :" + taskList);
    }

    public void contarTarefas(){
        System.out.println("Numero total de tarefas: " + taskList.size());
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();


        listaTarefas.adcionarTarefa("Beber agua");
        listaTarefas.adcionarTarefa("Jantar");
        listaTarefas.adcionarTarefa("Limpar o quarto");
        listaTarefas.adcionarTarefa("Ir para academia");
        listaTarefas.adcionarTarefa("Correr");
        listaTarefas.adcionarTarefa("Estudar Java");

        listaTarefas.exibirTarefas();
        listaTarefas.contarTarefas();

        listaTarefas.marcarTarefaConcluida("Estudar Java");
        listaTarefas.marcarTarefaConcluida("Correr");
        listaTarefas.marcarTarefaConcluida("Limpar o quarto");
        listaTarefas.marcarTarefaPendente("Beber agua");
        listaTarefas.marcarTarefaPendente("Ir para academia");
        listaTarefas.removerTarefa("Jantar");

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.limparTarefas();
        listaTarefas.exibirTarefas();
    }
}
