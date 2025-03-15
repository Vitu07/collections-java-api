package set.OperacoesBasicas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> inviteSet;

    public ConjuntoConvidados() {
        this.inviteSet = new HashSet<>();
    }

    public void adcionarConvidado(String nome, int codigoConvite){
        inviteSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;
        for(Convidado c : inviteSet){
            if (c.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = c;
                break;
            }
        }
        inviteSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return inviteSet.size();
    }

    public void exibirConvidados(){
        System.out.println(inviteSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();


        conjuntoConvidados.adcionarConvidado("Maria", 123);
        conjuntoConvidados.adcionarConvidado("luiza", 124);
        conjuntoConvidados.adcionarConvidado("gabriel", 125);
        conjuntoConvidados.adcionarConvidado("laura", 125);


        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do conjunto de convidados");
        conjuntoConvidados.removerConvidadoPorCodigoConvite(125);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do conjunto de convidados");
        conjuntoConvidados.exibirConvidados();

    }

}
