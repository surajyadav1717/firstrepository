package com.example.demo.serviceimp;

import java.util.Optional;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.login.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String register(User user, Model model) {

		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			model.addAttribute("error", "Username already exists!");
			return "register";
		}

		userRepository.save(user);
		return "redirect:/add";
	}

	
	
	@Override
	public String login(User user, HttpSession session, Model model) throws Exception {

	    if (user== null || user.getUsername()== null || user.getPassword()== null) {
	        throw new InvalidAttributesException("Username or Password is missing.");
	    }

	    Optional<User> existing = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

	    if (existing.isPresent()) {
	        session.setAttribute("username", user.getUsername());
	        return "redirect:/list";  
	    } else {
	        model.addAttribute("error", "Invalid username or password.");
	        return "login";  
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    @Override
//    public String login(User user, HttpSession session, Model model) throws Exception {
//    	
//    	if(user==null) {
//    		
//    		throw InvalidAttributesException;
//    	}
//        Optional<User> existing = userRepository.findByUsernameAndPassword(
//            user.getUsername(), user.getPassword()
//        );
//
//        if (existing.isPresent()) {
//            session.setAttribute("username", user.getUsername());
//            return "redirect:/list";
//        } else {
//            model.addAttribute("error", "Invalid credentials!");
//            return "login";
//        }
//    }

}
