package com.diogo.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.diogo.DTOS.Book.BookDTO;
import com.diogo.DTOS.Book.PatchBookDTO;
import com.diogo.DTOS.Book.PutBookDTO;
import com.diogo.DTOS.Book.SaveBookDTO;
import com.diogo.Domain.Livro;
import com.diogo.Services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("books")
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping("{id}")
  public Livro findById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  @GetMapping("all")
  public List<BookDTO> findAll(){
    return bookService.findAll();
  }

  @GetMapping
  public ResponseEntity<List<BookDTO>> findAllByCategory(@RequestParam(defaultValue = "0") long category_id) {
    List<BookDTO> findAllByCategoory = bookService.findAllByCategoory(category_id);
    return ResponseEntity.ok(findAllByCategoory);
  }
  @PatchMapping
  public ResponseEntity<Void> patchBook(@RequestBody @Valid PatchBookDTO bookDTO){
    bookService.patchBook(bookDTO);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PutMapping
  public ResponseEntity<Void> putBook(@RequestBody @Valid PutBookDTO bookDTO){
    bookService.putBook(bookDTO);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<Livro> saveBook(@RequestBody @Valid SaveBookDTO bookDTO){
    return ResponseEntity.ok(bookService.saveBook(bookDTO));
  }
  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteById(@PathVariable long id){
    bookService.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
