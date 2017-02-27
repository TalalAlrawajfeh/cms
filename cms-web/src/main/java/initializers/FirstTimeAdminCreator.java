package initializers;

import java.util.Objects;

import beans.UserBuilder;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class FirstTimeAdminCreator extends AbstractInitializer<UserRepository> {
	private static final String ADMIN_USERNAME = "admin";
	private static final String COMPLEX = "P@ssw0rd";

	@Override
	public void initialize() {
		if (Objects.isNull(repository.findByUsername(ADMIN_USERNAME))) {
			repository.save(CopyUtil.createAndCopyFields(UserEntity.class,
					new UserBuilder().setEnabled(true).setFullName(ADMIN_USERNAME).setUsername(ADMIN_USERNAME)
							.setHashedPassword(COMPLEX).build()));
		}
	}
}
