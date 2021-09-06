package com.diogo.DTOS.Category;

import javax.validation.constraints.NotEmpty;

import com.diogo.Domain.Categoria;

public class CreateCategoryDTO {
  @NotEmpty(message = "cannot be null or empty")
  private String name;
  @NotEmpty(message = "cannot be null or empty")
  private String description;
  public CreateCategoryDTO(String name, String description) {
    this.name = name;
    this.description = description;
  }
  public CreateCategoryDTO(){}
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
  public Categoria toCategory(){
    Categoria categoria = new Categoria();
    categoria.setDescription(description);
    categoria.setName(name);
    return categoria;
  }
  
}
