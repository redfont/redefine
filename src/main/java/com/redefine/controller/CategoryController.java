package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.Category;
import com.redefine.response.AppResponse;
import com.redefine.service.CategoryService;

@Controller
@RequestMapping(value="/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse addCategory(@RequestBody Category category) {
		AppResponse response = new AppResponse();
		try{
			categoryService.addCategory(category);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getCategories() {
		AppResponse response = new AppResponse();
		try{
			response.setData(categoryService.getCategories());
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value="/single/{code}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getCategory(@PathVariable("code")String code) {
		AppResponse response = new AppResponse();
		try{
			response.setDataObject(categoryService.getCategory(code));
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updateCategory(@RequestBody Category category) {
		AppResponse response = new AppResponse();
		try{
			categoryService.updateCategory(category);
			response.setIsSuccess(Boolean.TRUE);
		}catch(Exception e){
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
}
