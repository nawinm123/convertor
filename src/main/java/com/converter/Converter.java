package com.converter;

public class Converter {

	public String numberToWord(int number) {
		String words = "";
		if (number == 0) {
			return "zero";
		}
		// add minus before conversion if the number is less than 0
		if (number < 0) { // convert the number to a string 
			String numberStr = "" + number; 
			// remove minus before the number 
			numberStr = numberStr.substring(1); 
			// add minus before the number and convert the rest of number 
			return "minus " + numberToWord(Integer.parseInt(numberStr));
		} 
		// check if number is divisible by 1 million
		if ((number / 1000000) > 0) {
			words += numberToWord(number / 1000000) + " million ";
			number %= 1000000;
		}
		// check if number is divisible by 1 thousand
		if ((number / 1000) > 0) {
			words += numberToWord(number / 1000) + " thousand ";
			number %= 1000;
		}
		// check if number is divisible by 1 hundred
		if ((number / 100) > 0) {
			words += numberToWord(number / 100) + " hundred ";
			number %= 100;
		}

		if (number > 0) {
			// check if number is within teens			if (number < 20) { 
				// fetch the appropriate value from unit array 
				words += Constants.initails[number];
			} else { 
				// fetch the appropriate value from tens array 
				words += Constants.tensNames[number / 10]; 
				if ((number % 10) > 0) {
					words += Constants.initails[number % 10];
				}  
			}
		}

		return words.trim();
	}

	
	public static void main(String[] args) {
		Converter converter = new Converter();
		System.out.println(converter.numberToWord(56945781 ));
	}

}
