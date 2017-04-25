package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512 {
	
	private MessageDigest md;
	private String salt;
	
	public String hash(String message, String salt) {
		
		String ret = null;
		
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			this.salt = salt;
			md.update(this.salt.getBytes());
			byte[] b = md.digest(message.getBytes());
			
			StringBuffer buff = new StringBuffer();
			for(int i=0; i<b.length; ++i) {
				buff.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
			}
			ret = buff.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public String hash(String message) {
		
		String ret = null;
		
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			md.update(this.salt.getBytes());
			byte[] b = md.digest(message.getBytes());
			
			StringBuffer buff = new StringBuffer();
			for(int i=0; i<b.length; ++i) {
				buff.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
			}
			ret = buff.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
