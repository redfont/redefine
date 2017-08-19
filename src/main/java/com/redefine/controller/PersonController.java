package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.Person;
import com.redefine.response.AppResponse;
import com.redefine.service.PersonService;

@Controller
@RequestMapping(value="person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
			produces="application/json",
			consumes="application/json")
	@ResponseBody
	public AppResponse addPerson(@RequestBody Person person) {
		
		AppResponse response = new AppResponse();
		try{
			personService.addProspect(person);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list/{contactType}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getPersons(@PathVariable("contactType") String contactType){
		AppResponse response = new AppResponse();
		try{
			response.setData(personService.getPersons(contactType));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/single/{id}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getPerson(@PathVariable("id") int id){
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(personService.getProspect(id));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updatePerson(@RequestBody Person person){
		AppResponse response = new AppResponse();
		try{
			personService.updateProspect(person);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
