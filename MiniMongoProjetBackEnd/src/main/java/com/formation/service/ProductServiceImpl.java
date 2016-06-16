package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.mongo.ProductDao;
import com.formation.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductByNum(Long numProduct) {
		return productDao.findById(numProduct);
	}

	@Override
	public Product createProduct(Product product) {
		return productDao.create(product);
	}

}
