package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserValidator {
	
	public static boolean ValidateLoginUser(String email, String password) throws InvalidUserException {
		if( email!=null&& password!=null&&validateEmail(email)&&validatePassword(password)) {	
			return true;
		} else {
			
			throw new InvalidUserException("Login details are invalid");
		}
	}
	
	
	
	
	public static boolean validateUser(User user) throws InvalidUserException {
		
		if( user!=null&&validateName(user.getUserName())&&validateEmail(user.getEmail())&&validatePassword(user.getPassword())) {
			
			return true;
		} else {
			
			throw new InvalidUserException("User details are invalid");
		}
		
	}
	
	

	public static  boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				throw new InvalidUserException("Invalid Username");
			}
		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);


			if (match) {
				System.out.println("Valid password.");
			} else {
				throw new InvalidUserException("Invalid Password");
			}
		return match;
	}

	public static  boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				throw new InvalidUserException("Invalid Email");
			}
			return isMatch;
		
	}

}
