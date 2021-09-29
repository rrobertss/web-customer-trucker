/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 22 wrz 2021  22:05:30
 *  Author:  RS 		
 */
package pl.rsof.springdemo.dao;

import java.util.List;

import pl.rsof.springdemo.entity.Customer;

/**
 * <p></p><p>22 wrz 2021</p>
 * @author RS
 *
 */
public interface CustomerDAO {

	public List<Customer>getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);
	
}
