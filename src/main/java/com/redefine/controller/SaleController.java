package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.Sale;
import com.redefine.response.AppResponse;
import com.redefine.service.SaleService;

@Controller
@RequestMapping(value="sale")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	public SaleController() {
	}

	@RequestMapping(value="/add", 
			method=RequestMethod.POST, 
			produces="application/json", 
			consumes="application/json")
	@ResponseBody
	public AppResponse addSale(@RequestBody Sale sale) {
		AppResponse response = new AppResponse();
		try{
			saleService.addSale(sale);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list", 
			method=RequestMethod.GET, 
			produces="application/json")
	@ResponseBody
	public AppResponse getSales() {
		AppResponse response = new AppResponse();
		try{
			response.setData(saleService.getSales());
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
	public AppResponse getSale(@PathVariable("id") int id) {
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(saleService.getSale(id));
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
	public AppResponse updateSale(@RequestBody Sale sale) {
		AppResponse response = new AppResponse();
		try{
			saleService.update(sale);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
