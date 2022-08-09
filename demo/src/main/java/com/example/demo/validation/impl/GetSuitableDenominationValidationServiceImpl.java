package com.example.demo.validation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.GetSuitableDenominationService;
import com.example.demo.util.DenominationToValue;
import com.example.demo.validation.GetSuitableDenominationValidationService;

@Controller
public class GetSuitableDenominationValidationServiceImpl implements GetSuitableDenominationValidationService{

	@Autowired
	private GetSuitableDenominationService getSuitableDenominationService;
	
	@Override
	public String getSuitableDenominationService(float value) {
		
		int numberOfDenominations = DenominationToValue.value.length-1;
		if((DenominationToValue.convert*value)<DenominationToValue.value[numberOfDenominations])
			return "No Possible Combinations of denominations for amount less than penny";
		else if((DenominationToValue.convert*value)%DenominationToValue.value[numberOfDenominations]!=0)
			return "No Possible Combinations of denominations with some portion less than penny";
		return getSuitableDenominationService.getSuitableDenominationService( value);
	}

}
