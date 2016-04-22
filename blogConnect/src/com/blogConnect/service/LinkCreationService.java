package com.blogConnect.service;



import org.apache.tomcat.util.codec.binary.Base64;


import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;



public class LinkCreationService
{
  // some random salt
  private static final byte[]	SALT			= { (byte) 0x21, (byte) 0x21, (byte) 0xF0, (byte) 0x55, (byte) 0xC3, (byte) 0x9F, (byte) 0x5A, (byte) 0x75						};

	private final static int	ITERATION_COUNT	= 31;


	public String encodeEmail(String input)
	{
		if (input == null)
		{
			throw new IllegalArgumentException();
		}
		try
		{

			KeySpec keySpec = new PBEKeySpec(null, SALT, ITERATION_COUNT);
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT, ITERATION_COUNT);

			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

			Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

			byte[] enc = ecipher.doFinal(input.getBytes());

			String res = new String(Base64.encodeBase64(enc));
			// escapes for url
			res = res.replace('+', '-').replace('/', '_').replace("%", "%25").replace("\n", "%0A");

			return res;

		}
		catch (Exception e)
		{
		}

		return "";

	}

	public String decodeEmail(String token)
	{
		if (token == null)
		{
			return null;
		}
		try
		{

			String input = token.replace("%0A", "\n").replace("%25", "%").replace('_', '/').replace('-', '+');

			byte[] dec = Base64.decodeBase64(input.getBytes());

			KeySpec keySpec = new PBEKeySpec(null, SALT, ITERATION_COUNT);
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT, ITERATION_COUNT);

			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

			Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			byte[] decoded = dcipher.doFinal(dec);

			String result = new String(decoded);
			return result;

		}
		catch (Exception e)
		{
      // use logger in production code
			e.printStackTrace();
		}

		return null;
	}
	
	   public String createLink(String email)
	    {
	    	String encodedEmail=encodeEmail(email);
	   
	    	return "http://localhost:8080/blogConnect/passwordReset/email/"+encodedEmail;
	    	
	    	
	    }
	
	
	
/*	public static void main(String[] args) {
		String email="s@iu.edu";
		String encodeEmail=encode(email);
		System.out.println(encodeEmail);
		String decodeEmail=decode(encodeEmail);
		System.out.println(decodeEmail);
		
	}*/

}



/*


public class LinkCreationService
{
    public static String encodeEmail(String email) 
    {
       
            String keyString = "adkj@#$02#@adflkj)(*jlj@#$#@LKjasdjlkj<.,mo@#$@#kljlkdsu343"; // 128 bit key
            MessageDigest digest;
            String urlEncodedData="";
			try {
				digest = MessageDigest.getInstance("SHA-256");
				   digest.update(keyString.getBytes());
				   byte[] key = new byte[16];
			        System.arraycopy(digest.digest(), 0, key, 0, key.length);
			        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			        // encrypt
			        
			        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			        IvParameterSpec ivspec = new IvParameterSpec(iv);
			        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivspec);
			       
			        // Encrypt & Encode the input
			        byte[] encrypted = cipher.doFinal(email.getBytes());
			        
			        byte[] base64Encoded = Base64.encodeBase64(encrypted);
			        String base64String = new String(base64Encoded);
			        urlEncodedData = URLEncoder.encode(base64String,"UTF-8");
			         
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     

	        return urlEncodedData;
		  
	      
    }
    
    public static String decodeEmail(String encodedEmail){
    	String emailDecodedData = "";
    	try {
			emailDecodedData = URLDecoder.decode(encodedEmail, "UTF-8");
			System.out.println(emailDecodedData);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	byte[] encryptedData = Base64.decodeBase64(emailDecodedData.getBytes()); 
		
		// Decode the Init Vector
		//byte[] rawIV = Base64.decodeBase64(base64IV.getBytes()); 
		
		// Configure the Cipher
    	String keyString = "adkj@#$02#@adflkj)(*jlj@#$#@LKjasdjlkj<.,mo@#$@#kljlkdsu343";
		//Cipher cipher;
		//MessageDigest digest;
		byte[] decrypted = null;
		String email = "";
		// Decrypt the data..
		
		
	
				try {
					Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
					//IvParameterSpec ivSpec = new IvParameterSpec(rawIV);
					MessageDigest digest = MessageDigest.getInstance("SHA-256");
					digest.update(keyString.getBytes());
					byte[] key = new byte[16];
					System.arraycopy(digest.digest(), 0, key, 0, key.length);
					SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
					
					//String base64IV = "    ";
					//String ivDecodedData = URLDecoder.decode(base64IV, "UTF-8");
					//byte[] rawIV = Base64.decodeBase64(ivDecodedData.getBytes());
					//IvParameterSpec ivSpec = new IvParameterSpec(rawIV);
					 byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
					    IvParameterSpec ivspec = new IvParameterSpec(iv);
					cipher.init(Cipher.DECRYPT_MODE, keySpec, ivspec);
					decrypted = cipher.doFinal(encryptedData);
					email = new String(decrypted);
					System.out.println("DECRYPTED: "+email);
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| IllegalBlockSizeException | BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidAlgorithmParameterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		return email;
    }
    
    public String createLink(String email)
    {
    	String encodedEmail=encodeEmail(email);
   
    	return "http://localhost:8080/blogConnect/passswordReset/email/"+encodedEmail;
    	
    	
    }
    
    public static void main(String[] args) 
    {
       //LinkCreationService app = new LinkCreationService();
        //app.createLink("/k@indianvmvmm");
    	String email = "/karan@indianvmvmm";
        String encoded = "4kOrOcynrxWFA79T2yDVlQ%3D%3D";
        //System.out.println(encodeEmail(email));
        //System.out.println(decodeEmail(encoded));
        try {
			System.out.println(URLEncoder.encode(email,  "UTF-8"));
			//System.out.println(x);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    
}  
*/