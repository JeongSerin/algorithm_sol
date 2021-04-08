package test;

import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		String patternNumber = "^[0-9]*$";
		String valueNumber = "1234567890";
		boolean check = Pattern.matches(patternNumber, valueNumber);
		System.out.println(check);
		System.out.println(Pattern.compile(patternNumber));
		System.out.println("aaa10Iaaii".toLowerCase());
	}

}
