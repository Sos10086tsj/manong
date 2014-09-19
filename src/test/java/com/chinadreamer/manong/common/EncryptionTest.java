package com.chinadreamer.manong.common;

import org.junit.Test;

public class EncryptionTest {

	@Test
	public void testMd5L32() {
		String clearText = "test";
		System.out.println(Encryption.md5L32(clearText));
	}

}
