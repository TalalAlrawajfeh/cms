package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class AddUserUseCase {
	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		UserEntity userEntity = CopyUtil.createAndCopyFields(UserEntity.class, user);
		userRepository.save(userEntity);
	}
}
