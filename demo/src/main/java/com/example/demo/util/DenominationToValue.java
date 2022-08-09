package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class DenominationToValue {

	public static String[] denominations = {"Silver Dollar","Half Dollar","Quarter","Dime","Nickel","Penny"};
	public static int[] value = {100,50,25,10,5,1};
	public static int convert =100;
}