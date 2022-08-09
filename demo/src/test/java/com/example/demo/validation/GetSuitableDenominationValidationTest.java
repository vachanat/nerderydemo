package com.example.demo.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.GetSuitableDenominationService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


@SpringBootTest
public class GetSuitableDenominationValidationTest {

	@Mock
	GetSuitableDenominationService getSuitableDenominationService;
	
	@Autowired
	GetSuitableDenominationValidationService getSuitableDenominationValidationTest;
	
	@Test
	public void getSuitableDenominationServiceNoCasePossibleTest() {
		
		String actual = getSuitableDenominationValidationTest.getSuitableDenominationService(0.001f);
		assertEquals("No Possible Combinations of denominations for amount less than penny", actual);
	}
	
	@Test
	public void getSuitableDenominationServiceNoCasePossibleTestwithPartial() {
		
		String actual = getSuitableDenominationValidationTest.getSuitableDenominationService(10.789f);
		assertEquals("No Possible Combinations of denominations with some portion less than penny", actual);
	}
	
	@Test
	public void getSuitableDenominationServiceCasePossibleTest() {
		
		String actual = getSuitableDenominationValidationTest.getSuitableDenominationService(10.76f);
		assertEquals("10 -- Silver Dollars;1 -- Half Dollars;1 -- Quarters;0 -- Dimes;0 -- Nickels;1 -- Pennys;", actual);
	}
	
	/*
	 * Just To show how to use Mockito in case of complex sub Layers
	 */
	
	@Test
	public void getSuitableDenominationServiceCasePossibleTestWithMockito() {
		
		Mockito.when(getSuitableDenominationService.getSuitableDenominationService(10.76f)).
		thenReturn("10 -- Silver Dollars;1 -- Half Dollars;1 -- Quarters;0 -- Dimes;0 -- Nickels;1 -- Pennys;");
		String actual = getSuitableDenominationValidationTest.getSuitableDenominationService(10.76f);
		assertEquals("10 -- Silver Dollars;1 -- Half Dollars;1 -- Quarters;0 -- Dimes;0 -- Nickels;1 -- Pennys;", actual);
	}
}
