package com.diogo.Repositorys;

import java.util.List;

import com.diogo.Domain.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Livro,Long> {
  List<Livro> findAllByCategory_IdOrderByTitle(Long id_cat);
}
