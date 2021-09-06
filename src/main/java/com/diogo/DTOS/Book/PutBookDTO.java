package com.diogo.DTOS.Book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Livro;

public class PutBookDTO {
  @NotNull(message = "cannot be null")
  private Long id;
  @NotEmpty(message = "cannot be null or empty")
  private String title;
  @NotEmpty(message = "cannot be null or empty")
  private String authorName;
  @NotEmpty(message = "cannot be null or empty")
  private String text;

  public PutBookDTO(Long id, String title, String authorName, String text) {
    this.id = id;
    this.title = title;
    this.authorName = authorName;
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public PutBookDTO() {
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
    livro.setAuthorName(authorName);
    livro.setText(text);
    return livro;
  }

}
