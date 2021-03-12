package br.com.garbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.garbo.converter.NumberConverter;
import br.com.garbo.exception.UnsupportedMathOperationException;
import br.com.garbo.math.SimpleMath;

@RestController
public class MathController {

	@Autowired
	private SimpleMath mathOperation;
	@Autowired
	private NumberConverter numberConverter;
	
	@RequestMapping(value="/sum/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double sum(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		validateInput(firstNumber, secondNumber);
				
		return mathOperation.sum(numberConverter.toDouble(firstNumber), numberConverter.toDouble(secondNumber));
	}
	
	@RequestMapping(value="/subtract/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double subtract(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		validateInput(firstNumber, secondNumber);		
		return mathOperation.subtract(numberConverter.toDouble(firstNumber), numberConverter.toDouble(secondNumber));
	}
	
	@RequestMapping(value="/multiply/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double multiply(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		validateInput(firstNumber, secondNumber);		
		return mathOperation.multiply(numberConverter.toDouble(firstNumber), numberConverter.toDouble(secondNumber));
	}
	
	@RequestMapping(value="/divide/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double divide(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		validateInput(firstNumber, secondNumber);		
		return mathOperation.divide(numberConverter.toDouble(firstNumber), numberConverter.toDouble(secondNumber));
	}
	
	@RequestMapping(value="/mean/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double mean(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		validateInput(firstNumber, secondNumber);
		return mathOperation.mean(numberConverter.toDouble(firstNumber), numberConverter.toDouble(secondNumber));
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number ) throws Exception {
		validateInput(number);		
		return mathOperation.squareRoot(numberConverter.toDouble(number));
	}	
	
	private void validateInput(String number) {
		if (!numberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	}	
	
	private void validateInput(String numberOne, String numberTwo) {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	}		
}
