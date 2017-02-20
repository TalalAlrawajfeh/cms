package initializers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.UserBuilder;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class FirstTimeAdminCreator {
	private static final String COMPLEX_PASSWORD = "P@ssw0rd";
	private static final String ADMIN_USERNAME = "admin";

	@Autowired
	private UserRepository userRepository;

	public void createAdminIfNotExists() {
		UserEntity admin = userRepository.findByUsername(ADMIN_USERNAME);

		if (Objects.isNull(admin)) {
			userRepository.save(CopyUtil.createAndCopyFields(UserEntity.class,
					new UserBuilder().setEnabled(true).setFullName(ADMIN_USERNAME).setUsername(ADMIN_USERNAME)
							.setHashedPassword(COMPLEX_PASSWORD).build()));
		}
	}
}
