package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class GetSuitableDenominationServiceTest {

	@Autowired
	GetSuitableDenominationService getSuitableDenominationServiceTest;
	
	@Test
	public void getSuitableDenominationServiceCasePossibleTest() {
		
		String actual = getSuitableDenominationServiceTest.getSuitableDenominationService(10.76f);
		assertEquals("10 -- Silver Dollars;1 -- Half Dollars;1 -- Quarters;0 -- Dimes;0 -- Nickels;1 -- Pennys;", actual);
	}
}
