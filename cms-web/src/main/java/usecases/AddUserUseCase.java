package usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import beans.UserBuilder;
import entities.UserEntity;
import persistence.UserRepository;
import usecases.exceptions.UserValidationException;
import usecases.exceptions.UserValidationException.UserValidationExceptionCause;
import utils.CopyUtil;

public class AddUserUseCase {
	private static final String FULLNAME_VALIDATION_REGEX = "[a-zA-Z\\s]{3,50}";
	private static final String USERNAME_VALIDATION_REGEX = "[a-zA-Z0-9\\.\\-_]{3,50}";

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(CopyUtil.createAndCopyFields(UserEntity.class, user));
	}

	public boolean userExists(String username) {
		return Objects.nonNull(userRepository.findByUsername(username));
	}

	public User validateUser(String fullName, String username) throws UserValidationException {
		if (!username.matches(USERNAME_VALIDATION_REGEX)) {
			throw new UserValidationException(UserValidationExceptionCause.INVALID_USERNAME);
		}

		if (!fullName.matches(FULLNAME_VALIDATION_REGEX)) {
			throw new UserValidationException(UserValidationExceptionCause.INVALID_FULLNAME);
		}

		return new UserBuilder().setFullName(fullName).setUsername(username).build();
	}
}
