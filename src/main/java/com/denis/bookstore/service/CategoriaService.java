package com.denis.bookstore.service;

import com.denis.bookstore.domain.Categoria;
import com.denis.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElse(null);
    }

}
