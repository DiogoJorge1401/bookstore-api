package com.diogo.DTOS.Book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Livro;

public class SaveBookDTO {
  @NotEmpty(message = "cannot be null or empty")
  private String title;
  @NotEmpty(message = "cannot be null or empty")
  private String authorName;
  @NotEmpty(message = "cannot be null or empty")
  private String text;
  @NotNull(message = "cannot be null")
  private Long category_id;
  public SaveBookDTO(String title, String authorName, String text, Long category_id) {
    this.title = title;
    this.authorName = authorName;
    this.text = text;
    this.setCategory_id(category_id);
  }

  public Long getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Long category_id) {
    this.category_id = category_id;
  }

  public SaveBookDTO() {
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Livro toBook() {
    Livro livro = new Livro();
    livro.setAuthorName(authorName);
    livro.setText(text);
    livro.setTitle(title);
    return livro;
  }

}
