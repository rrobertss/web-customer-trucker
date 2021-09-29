/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 27 wrz 2021  21:42:10
 *  Author:  RS 		
 */
package pl.rsof.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.rsof.springdemo.dao.CustomerDAO;
import pl.rsof.springdemo.entity.Customer;

/**
 * <p></p><p>27 wrz 2021</p>
 * @author RS
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);	
	}


	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomerById(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

}
