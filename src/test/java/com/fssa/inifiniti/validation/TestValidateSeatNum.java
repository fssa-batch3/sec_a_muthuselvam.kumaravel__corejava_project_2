package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;
import com.fssa.inifiniti.validationexceptions.ValidationException;

 class TestValidateSeatNum {
	Throwable exception;
	@Test
	
	 void testValidSeatnum(){
		
		
			try {
				assertTrue(BookingValidator.validateSeatNum(1));
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	@Test
	
	 void testInvalidSeatNum()  {
		
		
			
			 exception = assertThrows(ValidationException.class, () -> BookingValidator.validateSeatNum(8));
				assertEquals("Seat Num should be greater that or equal to 1 and  less than 7", exception.getMessage());
		
	}

}
