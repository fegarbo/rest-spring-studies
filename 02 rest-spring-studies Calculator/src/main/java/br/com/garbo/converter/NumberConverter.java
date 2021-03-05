package br.com.garbo.converter;

public class NumberConverter {

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}	
	
	public static Double toDouble(String strNumber) {
		String number = strNumber.replaceAll(",", ".");
		return Double.parseDouble(number);
	}
}
