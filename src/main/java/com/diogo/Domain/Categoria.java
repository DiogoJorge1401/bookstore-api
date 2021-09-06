package com.diogo.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categoria implements Serializable {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "category")
  private List<Livro> books = new ArrayList<>(); 
  public Categoria() {
  }

  public Categoria(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public List<Livro> getBooks() {
    return books;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBooks(List<Livro> books) {
    this.books = books;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Categoria other = (Categoria) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
