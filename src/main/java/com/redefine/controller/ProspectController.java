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
import com.redefine.service.ProspectService;

@Controller
@RequestMapping(value="prospect")
public class ProspectController {

	@Autowired
	private ProspectService prospectService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, 
			produces="application/json",
			consumes="application/json")
	@ResponseBody
	public AppResponse addProspect(@RequestBody Person person) {
		
		AppResponse response = new AppResponse();
		try{
			prospectService.addProspect(person);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getProspects", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getProspects(){
		AppResponse response = new AppResponse();
		try{
			response.setData(prospectService.getProspects());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getProspect", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getProspect(@PathVariable("id") int id){
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(prospectService.getProspect(id));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updateProspect(@RequestBody Person person){
		AppResponse response = new AppResponse();
		try{
			prospectService.updateProspect(person);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
