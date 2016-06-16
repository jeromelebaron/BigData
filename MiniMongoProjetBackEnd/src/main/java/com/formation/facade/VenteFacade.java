package com.formation.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.service.ChartService;
import com.formation.service.ProductService;

public class VenteFacade {
	
	private static VenteFacade uniqueInstance;
	
	
	public static synchronized VenteFacade getInstance(){
		if(uniqueInstance==null) uniqueInstance = new VenteFacade();
		return uniqueInstance;
	}

	private ApplicationContext springContext;
	
	//declaration des services
	private ProductService productService;
	private ChartService   chartService;
	
	private VenteFacade() {
		springContext = new 
				ClassPathXmlApplicationContext("mongo-context.xml");
		
		//chargement des services
		productService = springContext.getBean(ProductService.class);
		chartService   = springContext.getBean(ChartService.class);

	}

	public ProductService getProductService() {
		return productService;
	}

	public ChartService getChartService() {
		return chartService;
	}
}
