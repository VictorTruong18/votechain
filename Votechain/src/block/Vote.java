package block;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Vote {
	private String hash;
	private String last_hash;
	private String data;

	
	
	public Vote(String voteur,String data) {
		this.data = data;
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String hashing_content = data + voteur + timestamp;
		try {
			this.hash = toHexString(getSHA(hashing_content));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//genesis block constructor
	public Vote(String data,String hash,String last_hash) {
		this.data = data;
		this.hash = hash;
		this.last_hash = last_hash;
	}
	
	 public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	    {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input  
	        // and return array of byte 
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	
	 public static String toHexString(byte[] hash) 
	    { 
	        // Convert byte array into signum representation  
	        BigInteger number = new BigInteger(1, hash);  
	  
	        // Convert message digest into hex value  
	        StringBuilder hexString = new StringBuilder(number.toString(16));  
	  
	        // Pad with leading zeros 
	        while (hexString.length() < 32)  
	        {  
	            hexString.insert(0, '0');  
	        }  
	  
	        return hexString.toString();  
	    }

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getLast_hash() {
		return last_hash;
	}

	public void setLast_hash(String last_hash) {
		this.last_hash = last_hash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	 

	
}
