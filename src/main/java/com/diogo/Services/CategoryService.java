package com.diogo.Services;

import java.util.List;

import com.diogo.DTOS.Category.CreateCategoryDTO;
import com.diogo.DTOS.Category.UpdateCategoryDTO;
import com.diogo.Domain.Categoria;
import com.diogo.Exceptions.ObjectNotFoundException;
import com.diogo.Repositorys.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
  @Autowired
	private CategoryRepository categoryRepository;

	public Categoria findById(long id) {
		return categoryRepository.findById(id)
		.orElseThrow(()->new ObjectNotFoundException(String.format("Categoria com id: '%s' não encontrada",id)));
	}

	public List<Categoria> findAll() {
		return categoryRepository.findAll();
	}

  public Categoria save(CreateCategoryDTO categoryDTO) {
		Categoria save = categoryRepository.save(categoryDTO.toCategory());
		return save;
	}

  public void update(UpdateCategoryDTO updatedCategory) {
		findById(updatedCategory.getId());
		categoryRepository.save(updatedCategory.toCategory());
  }

  public void deleteById(Long id) {
		Categoria categoria = findById(id);
		try{
			categoryRepository.delete(categoria);
		}catch(DataIntegrityViolationException e){
				throw new DataIntegrityViolationException("Category cannot be deleted! Has associated books");
		}
	}
}
