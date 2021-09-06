package com.diogo.DTOS.Book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Livro;

public class PatchBookDTO {
  @NotNull(message = "cannot be null")
  private Long id;
  @NotEmpty(message = "cannot be null or empty")
  private String title;

  public PatchBookDTO(Long id, String title) {
    this.id = id;
    this.title = title;
  }

  public PatchBookDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
  public Livro toBook() {
    Livro livro = new Livro();
    livro.setId(id);
    livro.setTitle(title);
    return livro;
  }

}
