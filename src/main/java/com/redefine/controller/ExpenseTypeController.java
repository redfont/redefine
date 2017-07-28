package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.ExpenseType;
import com.redefine.response.AppResponse;
import com.redefine.service.ExpenseTypeService;

@Controller
@RequestMapping(value="expenseType")
public class ExpenseTypeController {

	@Autowired
	private ExpenseTypeService expenseTypeService;
	
	public ExpenseTypeController(){}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse addExpenseType(@RequestBody ExpenseType expenseType){
		AppResponse response = new AppResponse();
		
		try{
			expenseTypeService.addExpenseType(expenseType);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getExpenseTypes(){
		AppResponse response = new AppResponse();
		try{
			response.setData(expenseTypeService.getExpenseTypes());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/single/{code}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getExpenseType(@PathVariable("code") String code){
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(expenseTypeService.getExpenseType(code));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updateExpenseType(@RequestBody ExpenseType expenseType){
		AppResponse response = new AppResponse();
		try{
			expenseTypeService.updateExpenseType(expenseType);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}