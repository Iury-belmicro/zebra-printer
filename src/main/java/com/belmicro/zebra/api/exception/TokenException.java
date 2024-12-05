package com.belmicro.zebra.api.exception;

public class TokenException extends Exception {
	
	public TokenException(String message) { 
		super(message); 
	}
	
	public TokenException(String message, Throwable thr) { 
		super(message, thr); 
	}

}
