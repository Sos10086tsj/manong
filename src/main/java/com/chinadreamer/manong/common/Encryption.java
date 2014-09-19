package com.chinadreamer.manong.common;

import java.security.MessageDigest;

import org.springframework.util.StringUtils;

public class Encryption {
	public static String md5L32(String clearText){
		if (StringUtils.isEmpty(clearText)) {
			return clearText;
		}
		
		String ciphertext = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(clearText.getBytes("UTF-8"));
			StringBuffer buffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					buffer.append(0);
				}
				buffer.append(Integer.toHexString(bt));
				ciphertext = buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ciphertext;
	}
}
