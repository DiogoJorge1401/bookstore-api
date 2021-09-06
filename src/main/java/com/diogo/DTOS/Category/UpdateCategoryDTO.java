package com.diogo.DTOS.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.diogo.Domain.Categoria;

public class UpdateCategoryDTO {
  @NotNull(message = "cannot be null")
  private Long id;
  @NotEmpty(message = "cannot be null or empty")
  private String name;
  @NotEmpty(message = "cannot be null or empty")
  private String description;
  public UpdateCategoryDTO(String name, String description, Long id) {
    this.name = name;
    this.description = description;
    this.id = id;
  }
  public UpdateCategoryDTO(){}
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
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Categoria toCategory(){
    Categoria categoria = new Categoria();
    categoria.setDescription(description);
    categoria.setName(name);
    categoria.setId(id);
    return categoria;
  }
  
}
