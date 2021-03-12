package br.com.garbo.math;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double subtract(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double divide(Double firstNumber, Double secondNumber) {
        return firstNumber / secondNumber;
    }

    public Double mean(Double firstNumber, Double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }
    
    public Double squareRoot(Double number) {
        return (Double) Math.sqrt(number);
    }
}
