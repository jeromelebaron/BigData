package com.formation.dao.mongo;

import java.util.List;

import com.formation.dto.CategoryMontant;
import com.formation.entity.Product;

public interface ProductDao {
	
	   public Product create(Product product);
	   public Product findById(Long id);
	   public Product updaProducte(Product product);
	   public void delete(Product t);
	   public List<CategoryMontant> getCategoryMontant();
}

