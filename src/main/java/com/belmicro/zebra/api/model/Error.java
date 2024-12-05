package com.belmicro.zebra.api.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Error {
	private LocalDateTime timestamp; 
	private String error; 
	private Integer status; 
	private String path; 
	
}
