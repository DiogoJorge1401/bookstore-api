package com.diogo.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.diogo.DTOS.Category.CategoryDTO;
import com.diogo.DTOS.Category.CreateCategoryDTO;
import com.diogo.DTOS.Category.UpdateCategoryDTO;
import com.diogo.Domain.Categoria;
import com.diogo.Services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = {"http://localhost:4200/**", "*"})
@RequestMapping("categorys")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping("{id}")
  public ResponseEntity<Categoria> findById(@PathVariable long id){
    return ResponseEntity.ok(categoryService.findById(id));
  }
  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll(){
    List<Categoria> findAll = categoryService.findAll();
    List<CategoryDTO> list = findAll.stream().map(e->new CategoryDTO(e)).collect(Collectors.toList());
    return ResponseEntity.ok(list);
  }
  @PostMapping("save")
  public ResponseEntity<Categoria> create(@RequestBody @Valid CreateCategoryDTO categoryDTO){
    return ResponseEntity.ok(categoryService.save(categoryDTO));
  }
  @PutMapping("update")
  public void save(@RequestBody @Valid UpdateCategoryDTO updatedCategory){
    categoryService.update(updatedCategory);
  }
  @DeleteMapping("delete/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    categoryService.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
