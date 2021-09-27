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
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
}
