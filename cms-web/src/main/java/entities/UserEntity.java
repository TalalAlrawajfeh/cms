package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
	@Id
	private String username;

	private String password;

	private String fullName;

	private Boolean enabled;
}
