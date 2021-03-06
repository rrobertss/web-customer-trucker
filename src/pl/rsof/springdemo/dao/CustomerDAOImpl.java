/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 22 wrz 2021  22:06:47
 *  Author:  RS 		
 */
package pl.rsof.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.rsof.springdemo.entity.Customer;

/**
 * <p></p><p>22 wrz 2021</p>
 * @author RS
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer>query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer>customers = query.getResultList();
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		// hibernate sprawdza id, jesli istnieje to robi update, jesli brak - insert 
		session.saveOrUpdate(customer);
		
//		session.save(customer);
	}


	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
		
	}


	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
		
	}

}
