package com.formation;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.formation.dao.StoreManagerDao;
import com.formation.dao.StoreManagerDaoJpa;
import com.formation.entity.Adresse;
import com.formation.entity.Customer;
import com.formation.entity.Item;

public class Main {

	public static void main(String[] args) {
		//build the EntityManagerFactory as you would build in in Hibernate ORM
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongo-ogm");

		StoreManagerDao storeDao=new StoreManagerDaoJpa(emf);
//		storeDao.createCustomer("Senegal", "Doum"); //1
		
		
		
		//2
//		storeDao.saveOrder("a35a191d-8442-4e07-88c9-1c53e256dfc3",120 , 2, "Cafe");
//		storeDao.saveOrder("a35a191d-8442-4e07-88c9-1c53e256dfc3",120 , 2, "Chocolat");
		
		//3
//		List<Item> items = storeDao.findAllItems("a35a191d-8442-4e07-88c9-1c53e256dfc3");
//		
//		for (Item item : items) {
//			System.out.println(item);
//		}
		
		//4
//		Customer customer=storeDao.findCustomerByName("Doum");
//		System.out.println(customer);
		
		//5
//		Customer customer=storeDao.findCustomerById("a35a191d-8442-4e07-88c9-1c53e256dfc3");
//		System.out.println(customer);
		
		//6
		//storeDao.saveAdresse("57143394-bfce-423a-aa72-6d7e4b6c6f78",1, "Paris", "Paris", 75019);
		
		//7
//		storeDao.saveTelephone("57143394-bfce-423a-aa72-6d7e4b6c6f78", "Dom", "0612457814");
//		storeDao.saveTelephone("57143394-bfce-423a-aa72-6d7e4b6c6f78", "Bur", "0612457845");
		
		//8
		List<Customer> customers = storeDao.queryNative("Senegal");
		
		for (Customer item : customers) {
			System.out.println(item);
		}
	}

}
