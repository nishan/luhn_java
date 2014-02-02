package org.luhn;

public class Luhn {

	/**
	 * Validate a number string using Luhn algorithm
	 * 
	 * @param numberString
	 * @return
	 */
	public static boolean validate(String numberString) {
		return checkSum(numberString) == 0;
	}

	/**
	 * Generate check digit for a number string. Assumes check digit or a place
	 * holder is already appended at end of the string.
	 * 
	 * @param numberString
	 * @return
	 */
	public static int checkSum(String numberString) {
		return checkSum(numberString, false);
	}

	/**
	 * Generate check digit for a number string.
	 * 
	 * @param numberString
	 * @param noCheckDigit
	 *            Whether check digit is present or not. True if no check Digit
	 *            is appended.
	 * @return
	 */
	public static int checkSum(String numberString, boolean noCheckDigit) {
		int sum = 0, checkDigit = 0;
		boolean isDouble = noCheckDigit;
		for (int i = numberString.length() - 1; i >= 0; i--) {
			int k = Integer.parseInt(String.valueOf(numberString.charAt(i)));
			sum += sumToSingleDigit((k * (isDouble ? 2 : 1)));
			isDouble = !isDouble;
		}

		if ((sum % 10) > 0)
			checkDigit = (10 - (sum % 10));

		return checkDigit;
	}

	private static int sumToSingleDigit(int k) {
		if (k < 10)
			return k;
		return sumToSingleDigit(k / 10) + (k % 10);
	}

}