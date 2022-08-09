package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.GetSuitableDenominationService;
import com.example.demo.util.DenominationToValue;

@Component
public class GetSuitableDenominationServiceImpl implements GetSuitableDenominationService {

	@Override
	public String getSuitableDenominationService(float value) {
		
		int newVal = (int) (DenominationToValue.convert*value);
		int[] denominationCount = new int[DenominationToValue.denominations.length];
		for(int i=0;i<DenominationToValue.denominations.length;i++) {
			denominationCount[i]=(int) (newVal/DenominationToValue.value[i]);
			newVal = newVal%DenominationToValue.value[i];
		}
		
		return denominationStringCreator(denominationCount,DenominationToValue.denominations);
	}

	private String denominationStringCreator(int[] denominationCount, String[] denominations) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<denominations.length;i++) {
			sb.append(denominationCount[i]);
			sb.append(" -- ");
			sb.append(denominations[i]+"s");
			sb.append(";");
		}
		return sb.toString();
	}

}
