//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.entity.Person;
//import com.example.demo.service.PersonService;
//
//@Controller
//public class PersonController {
//
//
//
//	@Autowired
//	
//	@GetMapping
//	public String listPersons(Model model) {
//		model.addAttribute("list", personService.getAllPersons());
//		return "index";
//	}
//
//	@GetMapping("/add")
//	public String showAddForm(Model model) {
//		model.addAttribute("person", new Person());
//		return "add";
//	}
//
//	@PostMapping("/save")
//	public String savePerson(@ModelAttribute Person person) {
//		personService.savePerson(person);
//		return "redirect:/persons";
//	}
//
//	@GetMapping("/edit/{id}")
//	public String showEditForm(@PathVariable Integer id, Model model) {
//		model.addAttribute("person", personService.getPersonById(id));
//		return "edit";
//	}
//
//	@PostMapping("/update")
//	public String updatePerson(@ModelAttribute Person person) {
//		personService.savePerson(person);
//		return "redirect:/persons";
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deletePerson(@PathVariable Integer id) {
//		personService.deletePersonById(id);
//		return "redirect:/persons";
//	}
//}




