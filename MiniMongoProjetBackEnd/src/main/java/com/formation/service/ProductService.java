package com.formation.service;

import com.formation.entity.Product;

public interface ProductService {
	
	public Product getProductByNum(Long numProduct);
	
	public Product createProduct(Product product);

}
