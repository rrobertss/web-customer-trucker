/*
 *  Company: RS
 *  Project: web-customer-tracker
 *  Created: 20 wrz 2021  21:18:33
 *  Author:  RS 		
 */
package pl.rsof.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p></p><p>20 wrz 2021</p>
 * @author RS
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		return "list-customers";
	}
	
	
	
}
