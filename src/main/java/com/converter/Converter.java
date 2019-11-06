package com.converter;

public class Converter {

	public String numberToWord(long number) {
		String words = "";
		try {
			//If number is larger than given limit
			if (number > 999999999 || number < -999999999 ) {
				return "Number exeeded maximum conversion limit";
			}
			if (number == 0) {
				return AppConstants.zero;
			}
			// add minus before conversion if the number is less than 0
			if (number < 0) { // convert the number to a string 
				String numberStr = "" + number; 
				// remove minus before the number 
				numberStr = numberStr.substring(1); 
				// add minus before the number and convert the rest of number 
				return AppConstants.minus + numberToWord(-number);
			} 
			// check if number is divisible by 1 billion
			if ((number / 1000000000) > 0) {
				words += numberToWord(number / 1000000000) + AppConstants.billion;
				number %= 1000000000;
			}
			// check if number is divisible by 1 million
			if ((number / 1000000) > 0) {
				words += numberToWord(number / 1000000) + AppConstants.million;
				number %= 1000000;
			}
			// check if number is divisible by 1 thousand
			if ((number / 1000) > 0) {
				words += numberToWord(number / 1000) + AppConstants.thousand;
				number %= 1000;
			}
			// check if number is divisible by 1 hundred
			if ((number / 100) > 0) {
				words += numberToWord(number / 100) + AppConstants.hundred;
				number %= 100;
			}

			if (number > 0) {
				// check if number is within teens			
				if (number < 20) { 
					// fetch the appropriate value from unit array 
					words += AppConstants.initails[(int) number];
				} else { 
					// fetch the appropriate value from tens array 
					words += AppConstants.tensNames[(int) (number / 10)]; 
					if ((number % 10) > 0) {
						words += AppConstants.initails[(int) (number % 10)];
					}  
				}
			}
		} catch (NumberFormatException exception) {
			// Output expected NumberFormatException.
			exception.printStackTrace();
		} catch (Exception exception) {
			// Output unexpected Exceptions.
			exception.printStackTrace();
		}
		return words.trim();
	}


	public static void main(String[] args) {
		Converter converter = new Converter();
		System.out.println(converter.numberToWord(456789456));
	}

}
