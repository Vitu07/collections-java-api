package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> bookCatalog;

    public CatalogoLivros() {
        this.bookCatalog = new ArrayList<>();
    }

    public void acionarLivro(String titulo, String autor, int anoPublicacao){
        bookCatalog.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisaPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!bookCatalog.isEmpty()){
            for (Livro l : bookCatalog){
                if (l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorAno = new ArrayList<>();
        if (!bookCatalog.isEmpty()){
            for (Livro l : bookCatalog){
                if (l.getAnoDePublicacao() >= anoInicial &&  l.getAnoDePublicacao() <= anoFinal){
                    livrosPorAno.add(l);
                }
            }
        }
        return livrosPorAno;
    }

    public Livro pesquisaPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!bookCatalog.isEmpty()){
            for(Livro  l : bookCatalog){
                if (l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                }
            }
        }
        return  livroPorTitulo;
    }

    public void exibirCatalogo(){
        System.out.println(bookCatalog);
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();


        catalogoLivros.acionarLivro("Harry potter 1", "JK R", 1999);
        catalogoLivros.acionarLivro("Harry potter 2", "JK R", 2001);
        catalogoLivros.acionarLivro("Harry potter 3", "JK R", 2003);
        catalogoLivros.acionarLivro("Codigo limpo", "Robert Cecil", 2004);
        catalogoLivros.acionarLivro("Codigo limpo", "Robert Cecil", 2004);

        catalogoLivros.acionarLivro("UML: guia do usuário", "Booch", 2008);


        System.out.println(catalogoLivros.pesquisaPorTitulo("UML: guia do usuário"));
        System.out.println(catalogoLivros.pesquisaPorAutor("JK R"));
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2000, 2002));
        catalogoLivros.exibirCatalogo();
    }
}
