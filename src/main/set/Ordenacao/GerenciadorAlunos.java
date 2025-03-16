package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    Set<Aluno> studentSet;

    public GerenciadorAlunos() {
        this.studentSet = new HashSet<>();
    }

    public void adcionarAluno(String nome, long matricula, double media) {
        studentSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        for (Aluno a : studentSet) {
            if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
                studentSet.remove(alunoParaRemover);
                break;
            }
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosOrdemAlfabetica = new TreeSet<>(studentSet);
        return alunosOrdemAlfabetica;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorOrdemNota = new TreeSet<>(new ComparatoPorNota());
        alunosPorOrdemNota.addAll(studentSet);
        return alunosPorOrdemNota;
    }

    public void exibirAlunos() {
        System.out.println(studentSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adcionarAluno("Aluno 1", 123, 9.7);
        gerenciadorAlunos.adcionarAluno("Aluno 2", 234, 6.9);
        gerenciadorAlunos.adcionarAluno("Aluno 3", 345, 8.5);
        gerenciadorAlunos.adcionarAluno("Aluno 4", 456, 10);
        gerenciadorAlunos.adcionarAluno("Aluno 5", 123, 6.3);

        gerenciadorAlunos.exibirAlunos();
        System.out.println("Alunos em ordem alfabética " + gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println("Alunos por nota " + gerenciadorAlunos.exibirAlunosPorNota());
        gerenciadorAlunos.removerAluno(456);
        gerenciadorAlunos.exibirAlunos();
    }
}
