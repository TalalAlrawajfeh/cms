
package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class EditUserUseCase {
	@Autowired
	private UserRepository userRepository;

	public User getUserFromUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		return CopyUtil.createAndCopyFields(User.class, userEntity);
	}
}
