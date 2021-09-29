/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 20 wrz 2021  21:18:33
 *  Author:  RS 		
 */
package pl.rsof.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.rsof.springdemo.entity.Customer;
import pl.rsof.springdemo.service.CustomerService;

/**
 * <p></p><p>20 wrz 2021</p>
 * @author RS
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		model.addAttribute("customers", customerService.getCustomers());
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String addCustomerForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String getCustomerFromId(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
}
