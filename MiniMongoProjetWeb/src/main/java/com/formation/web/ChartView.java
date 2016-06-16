package com.formation.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import com.formation.dto.CategoryMontant;
import com.formation.facade.VenteFacade;
import com.formation.service.ChartService;
 
@ManagedBean
public class ChartView implements Serializable {
	
	ChartService   chartService = VenteFacade.getInstance().getChartService();
	List<CategoryMontant> categories=null;
	
 
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
    	categories=new ArrayList<CategoryMontant>();
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    private void createPieModels() {
        createPieModel1();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        
        categories = chartService.getCategoryMontant();
        
        for (CategoryMontant catMont : categories) {
        	pieModel1.set(catMont.getCategory(), (int)Double.parseDouble(catMont.getMontant())+new Random().nextInt(1000));
		}
        
//        pieModel1.set("Brand 2", new Random().nextInt(325));
//        pieModel1.set("Brand 3", new Random().nextInt(702));
//        pieModel1.set("Brand 4", new Random().nextInt(421));
         
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
    }
}