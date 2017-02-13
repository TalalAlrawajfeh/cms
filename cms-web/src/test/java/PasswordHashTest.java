import beans.User;
import entities.UserEntity;
import utils.CopyUtil;

public class PasswordHashTest {
	public static void main(String[] args) {
		User user = new User();
		user.setEnabled(true);
		user.setFullName("talal alrawajfeh");
		user.setUsername("talal");
		user.setHashedPassword("23423423");
		UserEntity userEntity = new UserEntity();
		CopyUtil.CopyFields(userEntity, user);
		System.out.println(userEntity.toString());
	}
}
