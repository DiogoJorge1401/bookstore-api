package com.diogo.Services;

import java.util.List;

import com.diogo.Domain.Categoria;
import com.diogo.Domain.Livro;
import com.diogo.Repositorys.BookRepository;
import com.diogo.Repositorys.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbServicesTest {
  @Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

  public void instanceDatabase(){
    // Categoria cat1 = new Categoria(1l, "c1", "d1");
		// Categoria cat2 = new Categoria(2l, "c2", "d2");
		// categoryRepository.saveAll(List.of(cat1,cat2));
		// Livro liv1 = new Livro(1l, "t1", "a1", "t1", cat1);
		// Livro liv2 = new Livro(2l, "t2", "a2", "t2", cat2);
		// Livro liv3 = new Livro(3l, "t3", "a3", "t3", cat1);
		// Livro liv4 = new Livro(4l, "t4", "a4", "t4", cat2);
		// bookRepository.saveAll(List.of(liv1,liv2,liv3,liv4));

  }
}
