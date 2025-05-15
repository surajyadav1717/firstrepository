package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.entity.Person;

import jakarta.servlet.http.HttpServletResponse;

public interface PersonService {
	//
	//	List<Person> getAllPersons();
	////	Person getPersonById(Long id);
	//	void savePerson(Person person);
	//	void deletePersonById(Integer id);
	//	 void updatePerson(Person person);
	//	// Person getById(Long id);
	//	// Person getById(Long id)
	//
	//	 public Person getById(Long id);
	//	Person getById(Iterable<Integer> id);
	//	Person getPersonById(Integer id);}


	List<Person> getAllPersons();
	void savePerson(Person person);
	void deletePersonById(Integer id);
	void updatePerson(Person person);
	Person getPersonById(Integer id); 
	
    void exportPdf(HttpServletResponse response) throws IOException;

}




