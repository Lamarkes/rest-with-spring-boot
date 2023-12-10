package br.com.lamarkes.restwithspringboot;

import br.com.lamarkes.restwithspringboot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;



@RestController
public class MathController {
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
        public Double multiplication(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo){

            if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        }
        @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
        public Double division(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo){

            if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }

        @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
        public Double mean(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo){

            if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        }
        @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
        public Double squareRoot(
                @PathVariable(value = "numberOne") String numberOne){

            if (!isNumeric(numberOne)){
                throw new UnsupportedMathOperationException("Please set a numeric value");
            }
            return Math.sqrt(convertToDouble(numberOne));
        }

    private Double convertToDouble(String strNum) {
        if (strNum == null) return 0D;
        String number = strNum.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        String number = strNum.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
