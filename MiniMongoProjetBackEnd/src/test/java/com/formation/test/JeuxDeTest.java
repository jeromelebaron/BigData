package com.formation.test;

import java.util.Random;

import com.formation.entity.Product;

public class JeuxDeTest {

	String[] categories = { "Tablets", "Laptops", "Cell Phones" };

	public Product getProduct() {
		int idCat = new Random().nextInt(categories.length);
		

		String[] manufacturer = new String[10];
		int next = 0;

		switch (idCat) {
		case 0:
			manufacturer[0]="Apple";
			manufacturer[1]="Samsung";
			manufacturer[2]="Google";
			manufacturer[3]="Amazon";
			next=4;
			break;

		case 1:
			manufacturer[0]="Apple";
			manufacturer[1]="Toshiba";
			manufacturer[2]="Acer";
			next=3;
			break;

		case 2:
			manufacturer[0]="HTC";
			manufacturer[1]="Nokia";
			manufacturer[2]="Samsung";
			next=3;
			break;

		default:
			break;
		}
		
		int idManu = new Random().nextInt(next);

		
		String[] names = new String[10];
		double[] price = new double[10];
		
		String num=""+idCat+idManu;

		switch (num) {
		case "00":
			names[0]="IPAD AIR 2";
			
			names[1]="IPAD MINI 3";
			
			names[2]="IPAD AVEC ÉCRAN RETINA";
			price[0]=400.00;
			price[1]=700.00;
			price[2]=800.00;
			next=3;
			break;

		case "01":
			names[0]="SAMSUNG GALAXY TAB A";
			names[1]="SAMSUNG GALAXY TAB S";
			names[2]="SAMSUNG GALAXY NOTE";
			names[3]="SAMSUNG GALAXY TAB 3";
			names[4]="SAMSUNG GALAXY TAB 4";
			price[0]=300.00;
			price[1]=450.00;
			price[2]=250.00;
			price[3]=450.00;
			price[4]=700.00;
			next=5;
			break;

		case "02":
			names[0]="HTC Nexus 9 16 Go";
			names[1]="Tablette HTC Nexus 4 G";
			price[0]=200.00;
			price[1]=245.00;
			next=2;
			break;

		case "03":
			names[0]="Kindle Paperwhite 2014 WiFi";
			price[0]=79.00;
			next=1;
			break;
			
		case "10":
			names[0]="Apple MacBook Pro 13,3";
			names[1]="Apple MacBook Air 11,6";
			names[2]="Apple MacBook Pro 15,4";
			price[0]=1200.00;
			price[1]=1345.00;
			price[2]=1865.00;
			next=3;
			break;

		case "11":
			names[0]="Satellite L70-B-10P";
			names[1]="PC Portable SATELLITE L50-B-16N";
			names[2]="PC Portable Satellite L50-B-1HU";
			names[3]="Satellite Pro R50-B-14U";
			names[4]="PC Portable SATELLITE L50-B-16N";
			names[5]="PC Portable Satellite C50-B-14F";
			price[0]=458.00;
			price[1]=754.00;
			price[2]=895.00;
			price[3]=451.00;
			price[4]=1243.00;
			price[5]=458.00;
			next=6;
			break;
			
		case "12":
			names[0]="Iconia Tab 8 Blanche W1-810-15NY";
			names[1]="Iconia Tab 10 Blanche A3-A20-K79Q";
			names[2]="Iconia Tab 8 + Clavier ACER ANDROID";
			price[0]=458.00;
			price[1]=852.00;
			price[2]=795.00;
			next=3;
			break;	
			
		case "20":
			names[0]="Desire 610 Blanc";
			names[1]="DESIRE 816";
			names[2]="One M8";
			price[0]=458.00;
			price[1]=968.00;
			price[2]=245.00;
			next=3;
			break;

		case "21":
			names[0]="LUMIA 625";
			names[1]="Nokia 220 Double Sim";
			price[0]=456.00;
			price[1]=245.00;
			next=2;
			
		case "22":
			names[0]="REX 60 Bleu";
			names[1]="SGH-C3050 Stratus";
			names[2]="B2100 ROUGE";
			names[3]="GALAXY S5 ACTIVE";
			price[0]=300.00;
			price[1]=785.00;
			price[2]=124.00;
			price[3]=785.00;
			next=4;

			break;
			
		default:
			break;
		}
		int idName = new Random().nextInt(next);
		
		String cateorie = (categories[idCat]);
		String manufacture= manufacturer[idManu];
		String name=names[idName];
		
		Product p =new Product(name, manufacture, cateorie, price[idName]);

		return p;
	}
}
