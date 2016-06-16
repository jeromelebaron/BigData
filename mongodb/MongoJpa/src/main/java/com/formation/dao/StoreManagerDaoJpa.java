package com.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.formation.entity.Adresse;
import com.formation.entity.Customer;
import com.formation.entity.Item;
import com.formation.entity.Telephone;

public class StoreManagerDaoJpa implements StoreManagerDao {

	EntityManager em = null;

	public StoreManagerDaoJpa(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}

	@Override
	public void createCustomer(String country, String name) {

		em.getTransaction().begin();
		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setName(name);
		em.persist(customer);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void saveOrder(String idCustomer, int price, int quantity, String product) {
		em.getTransaction().begin();
		Customer customer = findCustomerById(idCustomer);
		Item order = new Item();
		order.setCustomerFK(customer);
		order.setPrice(price);
		order.setQuantity(quantity);
		order.setProduct(product);
		em.persist(order);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Item> findAllItems(String customerId) {
		Query query = em.createQuery("FROM Customer where id=:id");
		query.setParameter("id", customerId);
		Customer customer = (Customer) query.getSingleResult();
		List<Item> customerOrders = customer.getItems();
		return customerOrders;
	}

	@Override
	public Customer findCustomerByName(String customerName) {
		Query query = em.createQuery("FROM Customer where name=:name");
		query.setParameter("name", customerName);
		Customer customer = (Customer) query.getSingleResult();

		return customer;
	}

	@Override
	public Customer findCustomerById(String id) {
		Query query = em.createQuery("FROM Customer where id=:id");
		query.setParameter("id", id);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("FROM Customer");
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	@Override
	public void saveAdresse(String idCustomer, int num, String rue, String ville, int zip) {
		em.getTransaction().begin();
		Customer customer = findCustomerById(idCustomer);

		Adresse adresse = new Adresse(num, rue, ville, zip);

		customer.setAdresses(adresse);
		em.merge(customer);
		em.flush();
		em.getTransaction().commit();
		em.close();

	}

	
	@Override
	public void saveTelephone(String idCustomer, String lieu, String numero) {
		em.getTransaction().begin();
		Customer customer = findCustomerById(idCustomer);

		Telephone telephone = new Telephone(lieu, numero);

		customer.getTelephones().add(telephone);
		em.merge(customer);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Customer> queryNative(String word) {
		String query1 = "db.Customer.find({'country': '"+word+"'})";
		Query query = em.createNativeQuery(query1, Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}
	
}
