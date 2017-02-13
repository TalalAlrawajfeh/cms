import beans.User;

public class PasswordHashTest {
	public static void main(String[] args) {
		User user = new User();
		user.hashPassword("1235345");
		System.out.println(user.getPasswordHashCode());
	}
}
