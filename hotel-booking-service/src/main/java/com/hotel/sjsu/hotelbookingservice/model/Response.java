package com.hotel.sjsu.hotelbookingservice.model;

public class Response {
	
	Object object;
	String message;
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Response(Object object, String message) {
		super();
		this.object = object;
		this.message = message;
	}
	public Response() {
		super();
	}
	@Override
	public String toString() {
		return "Response [object=" + object + ", message=" + message + "]";
	}
}
