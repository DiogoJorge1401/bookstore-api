package com.diogo.DTOS.Category;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Categoria;

public class CategoryDTO implements Serializable{
  @NotNull(message = "cannot be null")
  private Long id;
  @NotEmpty(message = "cannot be null or empty")
  private String name;
  @NotEmpty(message = "cannot be null or empty")
  private String description;
  public CategoryDTO(Categoria categoria) {
    this.id = categoria.getId();
    this.name = categoria.getName();
    this.description = categoria.getDescription();
  }
  public CategoryDTO(){}
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
}
