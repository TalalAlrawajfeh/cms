package usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import usecases.InvalidUserException.InvalidUserCause;
import utils.CopyUtil;
import utils.HashUtil;

public class LoginUseCase {
	@Autowired
	private UserRepository userRepository;

	public User validateUser(String username, String password) throws InvalidUserException {
		UserEntity userEntity = userRepository.findByUsername(username);
		if (Objects.nonNull(userEntity)) {
			if (userEntity.getPasswordHashCode().equalsIgnoreCase(HashUtil.hashString(password))) {
				return CopyUtil.createAndCopyFields(User.class, userEntity);
			} else {
				throw new InvalidUserException(InvalidUserCause.INVALID_PASSWORD);
			}
		} else {
			throw new InvalidUserException(InvalidUserCause.USER_NOT_FOUND);
		}
	}
}