package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.packt.webstore.domain.Address;
import com.packt.webstore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.packt.webstore.domain.Employee;
  

 
@Controller
@RequestMapping({"/employees"})
//@SessionAttributes("address")
public class EmployeeController {
	@Autowired
 	private EmployeeService employeeService;
	
 	@RequestMapping(value={"","/list"}, method = RequestMethod.GET)
	public String listEmployees(Model model) {

 		model.addAttribute("employees", employeeService.findAll());
 		
 		return "employees";
	}
	
  	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeByNumber(Model model, @RequestParam("id") long employeeId) {
  		
  		model.addAttribute("employee", employeeService.findOne(employeeId));
		return "employee";
	}


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
 		//model.addAttribute("address", newEmployee.getAddress());
 		return "addEmployee";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployee(@ModelAttribute("newEmployee") Employee employeeToBeAdded, Model model) {

		Address address =employeeToBeAdded.getAddress();
		employeeToBeAdded.setAddress(address);
		employeeToBeAdded = employeeService.save(employeeToBeAdded);
 		model.addAttribute("employee", employeeToBeAdded);
	   	return "redirect:/employees/list";
	}
	
 
}
