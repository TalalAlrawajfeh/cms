package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
	public static String hashString(String password) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(password.getBytes());
			return convertByteArrayToHexString(sha256.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static String convertByteArrayToHexString(byte[] byteArray) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			hexString.append(byteToHexCode(byteArray[i]));
		}
		return hexString.toString();
	}

	private static String byteToHexCode(byte value) {
		String hexCode = Integer.toString(Byte.toUnsignedInt(value), 16);
		if (hexCode.length() == 1) {
			hexCode = "0" + hexCode;
		}
		return hexCode;
	}
}
