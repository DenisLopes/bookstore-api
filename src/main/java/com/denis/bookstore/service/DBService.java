package com.denis.bookstore.service;

import com.denis.bookstore.domain.Categoria;
import com.denis.bookstore.domain.Livro;
import com.denis.bookstore.repositories.CategoriaRepository;
import com.denis.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instaciaBaseDeDados(){
        Categoria categoriaTi = new Categoria(null, "Informatica", "Livro de TI");
        Categoria categoriaReceitas = new Categoria(null, "Churrasco", "Livro de Churrasco");
        Categoria categoriaEsportes = new Categoria(null, "Futebol", "Livro de Futebol");

        Livro livroTi = new Livro(null, "Clean Code", "Robert Martin", "Lorem Inpsum", categoriaTi);
        Livro livroTi2 = new Livro(null, "Java OOP", "Maria Otton", "Lorem Inpsum", categoriaTi);
        Livro livroReceitas = new Livro(null, "O melhor do churrasco", "Paulo Silva", "Lorem Inpsum", categoriaReceitas);
        Livro livroReceitas2 = new Livro(null, "Feijoada Mineira", "Silvana Andarde", "Lorem Inpsum", categoriaReceitas);
        Livro livroEsportes = new Livro(null, "Futebol Arte", "Mauro Grover", "Lorem Inpsum", categoriaEsportes);
        Livro livroEsportes2 = new Livro(null, "Volei", "Grover", "Lorem Inpsum", categoriaEsportes);


        categoriaTi.getLivros().addAll(Arrays.asList(livroTi, livroTi2));
        categoriaReceitas.getLivros().addAll(Arrays.asList(livroReceitas, livroReceitas2));
        categoriaEsportes.getLivros().addAll(Arrays.asList(livroEsportes, livroEsportes2));

        this.categoriaRepository.saveAll(Arrays.asList(categoriaTi, categoriaReceitas, categoriaEsportes));
        this.livroRepository.saveAll(Arrays.asList(livroTi, livroTi2, livroReceitas, livroReceitas2, livroEsportes, livroEsportes2));
    }
}
