package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,  
			@PathVariable(value = "numberTwo")String numberTwo ) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return this.simpleMath.sum(NumberConverter.convertToDouble(numberOne), 
				NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/anyless/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double anyLess(
			@PathVariable(value = "numberOne")String numberOne,  
			@PathVariable(value = "numberTwo")String numberTwo ) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return this.simpleMath.anyLess(NumberConverter.convertToDouble(numberOne),
				NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne")String numberOne,  
			@PathVariable(value = "numberTwo")String numberTwo ) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		return this.simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), 
				NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne")String numberOne,  
			@PathVariable(value = "numberTwo")String numberTwo ) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
	
		return this.simpleMath.division(NumberConverter.convertToDouble(numberOne), 
				NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(
			@PathVariable(value = "numberOne")String numberOne,  
			@PathVariable(value = "numberTwo")String numberTwo ) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
	
		return this.simpleMath.average(NumberConverter.convertToDouble(numberOne),
				NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/squareroot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne")String numberOne) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
	
		return this.simpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
	}
	
}