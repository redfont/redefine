package com.redefine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redefine.model.User;
import com.redefine.response.AppResponse;
import com.redefine.service.AuthService;

@Controller
@RequestMapping(value="auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public AppResponse auth(@RequestBody User user) {
		AppResponse response = new AppResponse();
		try{
			if(authService.auth(user.getUsername(), user.getPassword())){
				response.setIsSuccess(Boolean.TRUE);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public AppResponse logout() {
		AppResponse response = new AppResponse();
		response.setIsSuccess(Boolean.TRUE);
		try{
			authService.invalidateSession();
		}catch(Exception e) {
			e.printStackTrace();
			response.getMessages().add(e.getMessage());
			response.setIsSuccess(Boolean.FALSE);
		}
		
		return response;
	}
}
