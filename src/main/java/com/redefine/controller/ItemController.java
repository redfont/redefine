package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.Item;
import com.redefine.response.AppResponse;
import com.redefine.service.ItemService;

@Controller
@RequestMapping(value="item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value="/add", 
			method=RequestMethod.POST, 
			produces="application/json", 
			consumes="application/json")
	@ResponseBody
	public AppResponse add(@RequestBody Item item){
		AppResponse response = new AppResponse();
		try{
			itemService.add(item);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list", 
			method=RequestMethod.GET, 
			produces="application/json")
	@ResponseBody
	public AppResponse getItems(){
		AppResponse response = new AppResponse();
		try{
			response.setData(itemService.getList());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/single/{id}", 
			method=RequestMethod.GET, 
			produces="application/json")
	@ResponseBody
	public AppResponse getItem(@PathVariable("id") int id){
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(itemService.getItem(id));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", 
			method=RequestMethod.POST, 
			produces="application/json", 
			consumes="application/json")
	@ResponseBody
	public AppResponse updateItem(@RequestBody Item item){
		AppResponse response = new AppResponse();
		try{
			itemService.update(item);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
