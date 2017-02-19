package initializers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import entities.UserEntity;
import persistence.UserRepository;
import utils.HashUtil;

public class FirstTimeAdminCreator {
	@Autowired
	private UserRepository userRepository;

	public void createAdminIfNotExists() {
		UserEntity admin = userRepository.findByUsername("admin");
		if (Objects.isNull(admin)) {
			UserEntity userEntity = new UserEntity();
			userEntity.setEnabled(true);
			userEntity.setFullName("admin");
			userEntity.setUsername("user");
			userEntity.setPasswordHashCode(HashUtil.hashString("P@ssw0rd"));
			userRepository.save(userEntity);
		}
	}
}
