package com.belmicro.zebra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belmicro.zebra.api.services.ZebraService;
import com.zebra.sdk.comm.ConnectionException;
import com.belmicro.zebra.api.exception.NotFoundException;
import com.belmicro.zebra.api.exception.TokenException;
import com.belmicro.zebra.api.model.ZplBelmicroObject;

@RestController
@RequestMapping("/v1/impressoes")
public class ZebraController {	
	
	@Autowired
	private ZebraService zebraService; 
	
	@PostMapping("/")
	public ResponseEntity<Void> imprimirZpl(@RequestBody ZplBelmicroObject zplObj) throws ConnectionException, NotFoundException {
		zebraService.sendZplOverTcp(zplObj);
		return ResponseEntity.ok().build();
	}
}
