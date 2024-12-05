package com.belmicro.zebra.api.exception;

public class NotFoundException extends Exception {
	
	public NotFoundException(String message) { 
		super(message); 
	}
	
	public NotFoundException(String message, Throwable thr) { 
		super(message, thr); 
	}
	

}