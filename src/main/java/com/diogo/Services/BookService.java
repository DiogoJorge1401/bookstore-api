package com.diogo.Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.diogo.DTOS.Book.BookDTO;
import com.diogo.DTOS.Book.PatchBookDTO;
import com.diogo.DTOS.Book.PutBookDTO;
import com.diogo.DTOS.Book.SaveBookDTO;
import com.diogo.Domain.Categoria;
import com.diogo.Domain.Livro;
import com.diogo.Exceptions.ObjectNotFoundException;
import com.diogo.Repositorys.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CategoryService categoryService;

  public Livro findById(long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new ObjectNotFoundException(String.format("Livro com id: '%s' não encontrado", id)));
  }

  public List<BookDTO> findAll() {
    return bookRepository.findAll()
    .stream()
    .map(l->new BookDTO(l))
    .collect(Collectors.toList());
  }
  public List<BookDTO> findAllByCategoory(long id){
    categoryService.findById(id);
    return bookRepository.findAllByCategory_IdOrderByTitle(id)
    .stream()
    .filter(l -> l.getCategory().getId() == id)
    .map(l->new BookDTO(l))
    .collect(Collectors.toList());
  }

  public void patchBook(PatchBookDTO bookDTO) {
    Livro book = findById(bookDTO.getId());
    Livro patchBook = bookDTO.toBook();
    setAttributes(book, patchBook);
    bookRepository.save(patchBook);
  }
  public void putBook(@Valid PutBookDTO bookDTO) {
    Livro book = findById(bookDTO.getId());
    Livro putBook = bookDTO.toBook();
    putBook.setCategory(book.getCategory());
    bookRepository.save(putBook);
  }

  public Livro saveBook(SaveBookDTO bookDTO){
    Categoria category = categoryService.findById(bookDTO.getCategory_id());
    Livro book = bookDTO.toBook();
    book.setCategory(category);
    return bookRepository.save(book);
  }

  public void deleteById(long id){
    Livro book = findById(id);
    bookRepository.delete(book);
  }

  private void setAttributes(Livro book, Livro patchBook) {
    patchBook.setAuthorName(book.getAuthorName());
    patchBook.setCategory(book.getCategory());
    patchBook.setText(book.getText());
  }
}
