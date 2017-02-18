package usecases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class UserManagementUseCase {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		Iterator<UserEntity> iterator = userRepository.findAll().iterator();
		List<User> users = new ArrayList<>();
		while (iterator.hasNext()) {
			users.add(CopyUtil.createAndCopyFields(User.class, iterator.next()));
		}
		return users;
	}
}
