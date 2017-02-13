import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;

public class Test {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		UserRepository userRepository = appContext.getBean(UserRepository.class);
		User user = new User();
		user.setEnabled(true);
		user.setFullName("Talal Alrawajfeh");
		user.setHashedPassword("P@ssw0rd");
		user.setUsername("admin");
		userRepository.save(CopyUtil.createAndCopyFields(UserEntity.class, user));
	}
}
