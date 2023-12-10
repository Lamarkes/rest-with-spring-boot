package br.com.lamarkes.restwithspringboot.math;

import br.com.lamarkes.restwithspringboot.converters.NumberConverter;
import br.com.lamarkes.restwithspringboot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {

        return numberOne + numberTwo;
    }


    public Double subtraction(Double numberOne,Double  numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo){

        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo){

        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo){

        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double numberOne){

        return Math.sqrt(numberOne);
    }
}
