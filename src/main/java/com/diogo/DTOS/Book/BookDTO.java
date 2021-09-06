package com.diogo.DTOS.Book;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Livro;

public class BookDTO implements Serializable {
  @NotNull(message = "cannot be null")
  private Long id;
  @NotEmpty(message = "cannot be null or empty")
  private String title;
  @NotEmpty(message = "cannot be null or empty")
  private String authorName;
  public BookDTO(Livro livro){
    this.id = livro.getId();
    this.title = livro.getTitle();
    this.authorName = livro.getAuthorName();
  }
  public BookDTO(){}
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
  public String getAuthorName() {
    return authorName;
  }
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
}
