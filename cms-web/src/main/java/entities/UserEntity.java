package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -7042201838132762382L;

	@Id
	private String username;
	private String passwordHashCode;
	private String fullName;
	private Boolean enabled;

	public UserEntity() {
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", password=" + passwordHashCode + ", fullName=" + fullName
				+ ", enabled=" + enabled + "]";
	}
}
