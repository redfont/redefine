package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.Purchase;
import com.redefine.response.AppResponse;
import com.redefine.service.PurchaseService;

@Controller
@RequestMapping(value="purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	public PurchaseController(){}
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public AppResponse add(@RequestBody Purchase purchase) {
		AppResponse response = new AppResponse();
		try{
			purchaseService.addPurchase(purchase);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e) {
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getPurchase() {
		AppResponse response = new AppResponse();
		try{
			response.setData(purchaseService.getPurchases());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/single",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getPurchase(int id) {
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(purchaseService.getPurchase(id));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e) {
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST, consumes="application/json" ,produces="application/json")
	@ResponseBody
	public AppResponse update(@RequestBody Purchase purchase) {
		AppResponse response = new AppResponse();
		try{
			purchaseService.updatePurchase(purchase);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e) {
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
