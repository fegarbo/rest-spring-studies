package br.com.garbo.converter;

import org.springframework.stereotype.Service;

@Service
public class NumberConverter {
	
	public boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}	
	
	public Double toDouble(String strNumber) {
		if (strNumber == null) return 0d;
		
		String number = strNumber.replaceAll(",", ".");
		return Double.parseDouble(number);
	}
}
