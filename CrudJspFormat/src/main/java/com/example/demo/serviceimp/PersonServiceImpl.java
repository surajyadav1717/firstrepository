package com.example.demo.serviceimp;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PersonServiceImpl implements PersonService {


	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SpringTemplateEngine templateEngine;


	@Override
	public void exportPdf(HttpServletResponse response) {
		try {
			List<Person> personList = personRepository.findAll();

			Context context = new Context();
			context.setVariable("persons", personList);

			String htmlContent = templateEngine.process("persons_pdf", context);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=persons.pdf");

			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(htmlContent);
			renderer.layout();

			OutputStream outputStream = response.getOutputStream();
			renderer.createPDF(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override


	public List<Person> getAllPersons() {

		try {
			return personRepository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		// personRepository.findAll();
		return null;

	}

	@Override
	public void savePerson(Person person) {

		personRepository.save(person);
	}


	@Override
	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}




	@Override
	public void updatePerson(Person person) {


		personRepository.save(person);	
	}

	@Override
	public Person getPersonById(Integer id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Person not found for id: " + id));
	}









	//	@Override
	//	public Person getById(Long id) {
	//		
	//		personRepository.findById(id);
	//	}

}
