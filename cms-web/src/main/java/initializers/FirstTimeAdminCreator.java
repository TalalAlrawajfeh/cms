package initializers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import entities.UserEntity;
import persistence.UserRepository;
import utils.HashUtil;

public class FirstTimeAdminCreator {
	private static final String COMPLEX_PASSWORD = "P@ssw0rd";
	private static final String ADMIN_USERNAME = "admin";

	@Autowired
	private UserRepository userRepository;

	public void createAdminIfNotExists() {
		UserEntity admin = userRepository.findByUsername(ADMIN_USERNAME);

		if (Objects.isNull(admin)) {
			UserEntity userEntity = new UserEntity();
			userEntity.setEnabled(true);
			userEntity.setFullName(ADMIN_USERNAME);
			userEntity.setUsername(ADMIN_USERNAME);
			userEntity.setPasswordHashCode(HashUtil.hashString(COMPLEX_PASSWORD));

			userRepository.save(userEntity);
		}
	}
}