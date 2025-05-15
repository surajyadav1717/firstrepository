//package com.example.demo.controller;
//
//import java.util.List;
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
//import com.example.demo.login.User;
//import com.example.demo.service.PersonService;
//import com.example.demo.service.UserService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class AuthController {
//
//
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private PersonService personService;
//
//	
////	@GetMapping("/")
////	public String redirectToLogin() {
////
////	    return "redirect:/";
////	}
//
//
//	@GetMapping("/register")
//	public String registerPage(Model model) {
//		model.addAttribute("user", new User());
//		return "register";
//	}
//
//	@PostMapping("/register")
//	public String register(@ModelAttribute User user, Model model) {
//		return userService.register(user, model);
//	}
//
//	@GetMapping("/login")
//	public String loginPage(Model model) {
//		model.addAttribute("user", new User());
//		return "login";
//	}
//
//	@PostMapping("/login")
//	public String login(@ModelAttribute User user, HttpSession session, Model model) {
//		return userService.login(user, session, model);
//	}
//
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/login";
//	}
//	
//	@GetMapping
//	public String listPersons(Model model) {
//		model.addAttribute("list", personService.getAllPersons());
//		return "index";
//	}
//
//	@GetMapping("/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("person", new Person());
//        return "add";
//    }
//
//	@PostMapping("/save")
//    public String savePerson(@ModelAttribute Person person) {
//        personService.savePerson(person);
//        return "redirect:/login";
//    }
//	
//
////    @GetMapping("/edit/{id}")
////    public String showEditForm(@PathVariable("id") Long id, Model model) {
////        model.addAttribute("person", personService.getPersonById(id);
////        return "edit"; // edit.html
////    }
//    
//	
//    
//	@PostMapping("/update")
//	public String updatePerson(@ModelAttribute Person person) {
//		personService.savePerson(person);
//		return "redirect:/list";
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deletePerson(@PathVariable Integer id) {
//		personService.deletePersonById(id);
//		return "redirect:/list";
//	}
//	
//	@GetMapping("/list")
//	public String viewHomePage(Model model) {
//	    List<Person> persons = personService.getAllPersons();
//	    model.addAttribute("persons", persons);
//	    return "list"; // Renders list.html
//	}
//
//
//}

package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Person;
import com.example.demo.login.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        return userService.register(user, model);
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session, Model model) throws Exception {
        return userService.login(user, session, model);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/list";
    }
    
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Person person = personService.getPersonById(id); // must not be 
        if (person == null) {
            throw new RuntimeException("Person not found for id :: " + id);
        }

        model.addAttribute("person", person);
        return "edit";
    }
    @PostMapping("/update")
    public String updatePerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.deletePersonById(id);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String viewHomePage(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "list";
    }
    
    @GetMapping("/persons/pdf")
    public void downloadPdf(HttpServletResponse response) throws IOException {
        personService.exportPdf(response);
    }
}
