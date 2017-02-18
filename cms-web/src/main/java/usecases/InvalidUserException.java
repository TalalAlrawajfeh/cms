package usecases;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = 8106985756540152268L;

	private InvalidUserCause invalidUserCause;

	public InvalidUserException(InvalidUserCause invalidUserCause) {
		super();
		this.invalidUserCause = invalidUserCause;
	}

	public InvalidUserException() {
		super();
	}

	public InvalidUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserException(String message) {
		super(message);
	}

	public InvalidUserException(Throwable cause) {
		super(cause);
	}

	public InvalidUserCause getInvalidUserCause() {
		return invalidUserCause;
	}

	public enum InvalidUserCause {
		USER_NOT_FOUND, INVALID_PASSWORD;
	}
}