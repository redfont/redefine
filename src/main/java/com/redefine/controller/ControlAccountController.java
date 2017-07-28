package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.ControlAccount;
import com.redefine.response.AppResponse;
import com.redefine.service.ControlAccountService;

@Controller
@RequestMapping(value="controlacct")
public class ControlAccountController {

	@Autowired
	private ControlAccountService controlAccountService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	@ResponseBody
	public AppResponse addControlAccount(@RequestBody ControlAccount controlAccount) {
		AppResponse response = new AppResponse();
		try{
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public AppResponse getControlAccounts() {
		AppResponse response = new AppResponse();
		
		try{
			response.setData(controlAccountService.getControlAccounts());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/single/{id}", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public AppResponse getControlAccount(@PathVariable("id") int id) {
		AppResponse response = new AppResponse();
		
		try{
			response.setDataObject(controlAccountService.getControlAccount(id));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	@ResponseBody
	public AppResponse updateControlAccount(@RequestBody ControlAccount controlAccount) {
		AppResponse response = new AppResponse();
		try{
			controlAccountService.updateControlAccount(controlAccount);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
