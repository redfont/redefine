package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.User;
import com.redefine.response.AppResponse;
import com.redefine.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController() {
		
	}

	@RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse addUser(@RequestBody User user) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try {
			userService.addUser(user);
		} catch (Exception e) {
			response.getMessages().add(e.getMessage());
			response.setIsSuccess(Boolean.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getUsers() {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		
		try {
			response.setData(userService.getUsers());
		} catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
			response.setIsSuccess(Boolean.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/getUser/{id}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse getUser(@PathVariable("id") Integer id) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		
		try {
			response.setDataObject(userService.getUser(id));
		} catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
			response.setIsSuccess(Boolean.FALSE);
		}
		return response;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse updateUser(@RequestBody User user) {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			response.getMessages().add(e.getMessage());
			response.setIsSuccess(Boolean.FALSE);
		}
		return response;
	}
}
