package com.springboot.dto.response;

public class ResponseMessage {
	private String message;
	private Object data;

	public ResponseMessage() {
	}

	public ResponseMessage(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
