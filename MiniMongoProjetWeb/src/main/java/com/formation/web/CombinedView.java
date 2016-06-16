package com.formation.web;

import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;

@ManagedBean
public class CombinedView implements Serializable {

	 private CartesianChartModel combinedModel;
	 
	    @PostConstruct
	    public void init() {
	        createCombinedModel();
	    }
	 
	    public CartesianChartModel getCombinedModel() {
	        return combinedModel;
	    }
	     
	    private void createCombinedModel() {
	        combinedModel = new BarChartModel();
	 
	        BarChartSeries boys = new BarChartSeries();
	        boys.setLabel("Boys");
	 
	        boys.set("2004", 120);
	        boys.set("2005", 100);
	        boys.set("2006", 44);
	        boys.set("2007", 150);
	        boys.set("2008", 25);
	 
	        LineChartSeries girls = new LineChartSeries();
	        girls.setLabel("Girls");
	 
	        girls.set("2004", 52);
	        girls.set("2005", 60);
	        girls.set("2006", 110);
	        girls.set("2007", 135);
	        girls.set("2008", 120);
	        
	        LineChartSeries enfants = new LineChartSeries();
	        enfants.setLabel("Enfants");
	        enfants.setXaxis(AxisType.X2);
	        enfants.setYaxis(AxisType.Y2);
	        enfants.set("2004", 45);
	        enfants.set("2005", 86);
	        enfants.set("2006", 130);
	        enfants.set("2007", 14);
	        enfants.set("2008", 78);
	 
	        combinedModel.addSeries(boys);
	        combinedModel.addSeries(girls);
	        combinedModel.addSeries(enfants);
	         
	        combinedModel.setTitle("Bar and Line");
	        combinedModel.setLegendPosition("ne");
	        combinedModel.setMouseoverHighlight(false);
	        combinedModel.setShowDatatip(false);
	        combinedModel.setShowPointLabels(true);
	        Axis yAxis = combinedModel.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(200);
	    }
	     

}

