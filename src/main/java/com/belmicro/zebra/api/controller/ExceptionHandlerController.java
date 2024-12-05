package com.belmicro.zebra.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.belmicro.zebra.api.model.Error;
import com.zebra.sdk.comm.ConnectionException;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
	
	private Logger logger = Logger.getLogger(ExceptionHandlerController.class.getName()); 
	
	public ResponseEntity<Error> zebraConnection(ConnectionException ex, HttpServletRequest req) { 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new Error(
							LocalDateTime.now(), 
							ex.getMessage(), 
							HttpStatus.INTERNAL_SERVER_ERROR.value(),
							req.getRequestURI()
						)); 
	}
	
}
