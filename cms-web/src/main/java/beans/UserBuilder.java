package beans;

public class UserBuilder {
	private User user = new User();

	public UserBuilder setEnabled(Boolean enabled) {
		user.setEnabled(enabled);
		return this;
	}

	public UserBuilder setUsername(String username) {
		user.setUsername(username);
		return this;
	}

	public UserBuilder setPasswordHashCode(String passwordHashCode) {
		user.setPasswordHashCode(passwordHashCode);
		return this;
	}

	public UserBuilder setHashedPassword(String password) {
		user.setHashedPassword(password);
		return this;
	}

	public UserBuilder setFullName(String fullName) {
		user.setFullName(fullName);
		return this;
	}

	public User build() {
		return user;
	}
}
