package com.hrms.hrms.core.verifications.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hrms.hrms.core.verifications.abstracts.EmailVerificationService;

public class EmailVerificationServiceImpl implements EmailVerificationService {
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{3})?$";

	@Override
	public boolean isVerified(String email) {
		System.out.println(email);
		if(!checkEmailFormat(email)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean checkEmailFormat(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}

}
