package br.org.actanalyzer.logic;

import java.util.Random;

public class AuthToken {
	private String authToken;
	
	public AuthToken(int length) {
		StringBuffer tokenString = new StringBuffer();
		
		appendRandomHexChar(tokenString, length);
		
		this.authToken = tokenString.toString();
	}
	
	public String getValue() {
		return this.authToken;
	}
	
	private void appendRandomHexChar(StringBuffer tokenHolder, int length) {
		for (int i = 0; i < length; i++) {
			tokenHolder.append(pickRandomDigit());
		}
	}
	
	private char pickRandomDigit() {
		return getPossibleDigits()[ new Random().nextInt(6*4) ];
	}
	
	private char[] getPossibleDigits() {
		char[] possibleHexDigits = {
			'0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'C', 'Z',
			'c', 'd', 'e', 'f', 'b', 'a',
			'H', 'B', 'F', 'M', 'L', 'R'
		};
		
		return possibleHexDigits;
	}
}
