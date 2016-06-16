package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.mongo.ProductDao;
import com.formation.dto.CategoryMontant;

@Service
public class ChartServiceImpl implements ChartService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<CategoryMontant> getCategoryMontant() {
		return productDao.getCategoryMontant();
	}

}
