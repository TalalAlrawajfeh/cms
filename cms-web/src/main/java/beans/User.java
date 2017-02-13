package beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements Serializable {
	private static final long serialVersionUID = 2561036855901068794L;

	private String username;
	private String passwordHashCode;
	private String fullName;
	private Boolean enabled;

	public User() {
		/* default constructor */
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHashCode() {
		return passwordHashCode;
	}

	public void setPasswordHashCode(String passwordHashCode) {
		this.passwordHashCode = passwordHashCode;
	}

	public void hashPassword(String password) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(password.getBytes());
			passwordHashCode = convertByteArrayToHexString(sha256.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String convertByteArrayToHexString(byte[] byteArray) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			hexString.append(byteToHexCode(byteArray[i]));
		}
		return hexString.toString();
	}

	public String byteToHexCode(byte value) {
		String hexCode = Integer.toString(Byte.toUnsignedInt(value), 16);
		if (hexCode.length() == 1) {
			hexCode = "0" + hexCode;
		}
		return hexCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
