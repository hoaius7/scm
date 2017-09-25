package edu.mum.scm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.scm.dao.CustomerDao;
import edu.mum.scm.domain.Customer;
import edu.mum.scm.service.CustomerService;

@Controller
@RequestMapping("/customer")
@SessionAttributes({ "cart", "customer" })
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@RequestMapping("/addCustomer")
	public String addnewCustomer(@ModelAttribute("newCustomer") Customer customer) {
		return "addCustomer";
	}

	@RequestMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("inside binding result error");
			return "addCustomer";
		}
		customerservice.saveCustomer(customer);
		return "redirect:/";
	}

}
