package com.formation.dao;

import java.util.List;

import com.formation.entity.Customer;
import com.formation.entity.Item;

public interface StoreManagerDao {
	
	void createCustomer(String country, String name) ;

	void saveOrder(String idCustomer, int price, int quantity, String product);
	
	void saveAdresse(String idCustomer, int num, String rue, String ville,int zip );

	List<Item> findAllItems(String customerId);

	Customer findCustomerByName(String customerName);

	Customer findCustomerById(String id);

	List<Customer> findAllCustomers();

	void saveTelephone(String idCustomer, String lieu, String numero);

	List<Customer> queryNative(String word);
}


