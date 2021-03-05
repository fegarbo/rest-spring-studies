package br.com.garbo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.garbo.converter.NumberConverter;
import br.com.garbo.exception.UnsupportedMathOperationException;
import br.com.garbo.math.SimpleMath;

@RestController
public class MathController {

	private SimpleMath mathOperation = new SimpleMath();
	
	@RequestMapping(value="/sum/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double sum(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		if (!NumberConverter.isNumeric(firstNumber) || !NumberConverter.isNumeric(secondNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
				
		Double sum = mathOperation.sum(NumberConverter.toDouble(firstNumber), NumberConverter.toDouble(secondNumber));
		return sum;
	}
	
	@RequestMapping(value="/subtract/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double subtract(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		if (!NumberConverter.isNumeric(firstNumber) || !NumberConverter.isNumeric(secondNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double subtract = mathOperation.subtract(NumberConverter.toDouble(firstNumber), NumberConverter.toDouble(secondNumber));
		return subtract;
	}
	
	@RequestMapping(value="/multiply/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double multiply(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		if (!NumberConverter.isNumeric(firstNumber) || !NumberConverter.isNumeric(secondNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double multiply = mathOperation.multiply(NumberConverter.toDouble(firstNumber), NumberConverter.toDouble(secondNumber));
		return multiply;
	}
	
	@RequestMapping(value="/divide/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double divide(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		if (!NumberConverter.isNumeric(firstNumber) || !NumberConverter.isNumeric(secondNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double divide = mathOperation.divide(NumberConverter.toDouble(firstNumber), NumberConverter.toDouble(secondNumber));
		return divide;
	}
	
	@RequestMapping(value="/mean/{firstNumber}/{secondNumber}", method=RequestMethod.GET)
	public Double mean(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber ) throws Exception {
		if (!NumberConverter.isNumeric(firstNumber) || !NumberConverter.isNumeric(secondNumber)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double mean = mathOperation.mean(NumberConverter.toDouble(firstNumber), NumberConverter.toDouble(secondNumber));
		return mean;
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number ) throws Exception {
		if (!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		Double squareRoot = mathOperation.squareRoot(NumberConverter.toDouble(number));
		return squareRoot;
	}		
}
