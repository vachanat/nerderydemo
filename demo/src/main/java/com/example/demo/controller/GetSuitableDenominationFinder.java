package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.validation.GetSuitableDenominationValidationService;

@RestController
public class GetSuitableDenominationFinder {

	@Autowired
	private GetSuitableDenominationValidationService getSuitableDenominationValidationService;
	
	@GetMapping({"/getSuitableDenomination"})
	public String getSuitableDenomination(@RequestParam(value = "amount", defaultValue= "-1",required=true)float amount,ModelMap model) {
		
		return getSuitableDenominationValidationService.getSuitableDenominationService(amount);
		
		
	}
}
