package usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class AddUserUseCase {
	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.save(CopyUtil.createAndCopyFields(UserEntity.class, user));
	}

	public boolean userExists(String username) {
		return Objects.nonNull(userRepository.findByUsername(username));
	}
}
