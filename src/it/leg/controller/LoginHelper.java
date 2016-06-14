package it.leg.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginHelper {
	private MessageDigest md;
	
	public LoginHelper() {
		try {
			this.md = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}

	public String md5(String txt){
		md.update(txt.getBytes());
		
		byte[] bytes = md.digest();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < bytes.length; i++)
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		
		String encoded = sb.toString();

		return encoded;
	}
	
	public boolean validatePassword(String password, String crypted) {
		return this.md5(password).equals(crypted);
	}
}
