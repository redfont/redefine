package com.redefine.response;

import java.util.ArrayList;
import java.util.List;

public class AppResponse {

	public List<?> data;
	public List<String> messages;
	public Boolean isSuccess;
	public Object dataObject;
	
	public AppResponse() {
		
	}
	
	public AppResponse(List<?> data, List<String> messages, Boolean isSuccess, Object dataObject) {
		this.data = data;
		this.messages = messages;
		this.isSuccess = isSuccess;
		this.dataObject = dataObject;
	}
	
	/**
	 * 
	 * @return data
	 */
	@SuppressWarnings("rawtypes")
	public List<?> getData(){
		if(this.data == null) {
			return new ArrayList();
		}
		return this.data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(List<?> data) {
		this.data = data;
	}
	
	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		if(messages == null) {
			messages = new ArrayList<String>();
		}
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the isSuccess
	 */
	public Boolean getIsSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the dataObject
	 */
	public Object getDataObject() {
		return dataObject;
	}

	/**
	 * @param dataObject the dataObject to set
	 */
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
}
