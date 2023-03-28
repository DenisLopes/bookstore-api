package com.denis.bookstore;

import com.denis.bookstore.domain.Categoria;
import com.denis.bookstore.domain.Livro;
import com.denis.bookstore.repositories.CategoriaRepository;
import com.denis.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria categoriaTi = new Categoria(null, "Informatica", "Livro de TI");
        Livro livroTi = new Livro(null, "Clean Code", "Robert Martin", "Lorem Inpsum", categoriaTi);

        categoriaTi.getLivros().addAll(Arrays.asList(livroTi));

        this.categoriaRepository.saveAll(Arrays.asList(categoriaTi));
        this.livroRepository.saveAll(Arrays.asList(livroTi));
    }
}
