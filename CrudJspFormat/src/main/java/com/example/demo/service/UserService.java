package com.example.demo.service;

import org.springframework.ui.Model;

import com.example.demo.login.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	String register(User user, Model model);
	String login(User user, HttpSession session, Model model) throws Exception;

}



