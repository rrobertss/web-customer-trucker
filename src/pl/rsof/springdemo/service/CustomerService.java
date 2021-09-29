/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 27 wrz 2021  21:40:41
 *  Author:  RS 		
 */
package pl.rsof.springdemo.service;

import java.util.List;

import pl.rsof.springdemo.entity.Customer;

/**
 * <p></p><p>27 wrz 2021</p>
 * @author RS
 *
 */
public interface CustomerService {

	public List<Customer>getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);
	
}
