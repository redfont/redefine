package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.ContactType;
import com.redefine.response.AppResponse;
import com.redefine.service.ContactTypeService;

@Controller
@RequestMapping(value="contactType")
public class ContactTypeController {

	@Autowired
	private ContactTypeService contactTypeService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse addContactType(@RequestBody ContactType contactType) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try{
			contactTypeService.addContactType(contactType);
		}catch(Exception e){
			response.setIsSuccess(Boolean.FALSE);
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getContactTypes", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getContactTypes() {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try{
			response.setData(contactTypeService.getContactTypes());
		}catch(Exception e){
			response.setIsSuccess(Boolean.FALSE);
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getContactType/{code}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getContactType(@PathVariable("code") String code) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try{
			response.setDataObject(contactTypeService.getContactType(code));
		}catch(Exception e){
			response.setIsSuccess(Boolean.FALSE);
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updateContactType(@RequestBody ContactType contactType) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try{
			contactTypeService.updateContactType(contactType);
		}catch(Exception e){
			response.setIsSuccess(Boolean.FALSE);
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
