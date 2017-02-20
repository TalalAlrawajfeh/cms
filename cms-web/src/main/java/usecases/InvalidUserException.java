package usecases;

public class InvalidUserException extends Exception {
    private static final long serialVersionUID = 8106985756540152268L;

    private final InvalidUserCause invalidUserCause;

    public InvalidUserException(InvalidUserCause invalidUserCause) {
        super();
        this.invalidUserCause = invalidUserCause;
    }

    public InvalidUserException() {
        super();
        invalidUserCause = InvalidUserCause.OTHER;
    }

    public InvalidUserException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        invalidUserCause = InvalidUserCause.OTHER;
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
        invalidUserCause = InvalidUserCause.OTHER;
    }

    public InvalidUserException(String message) {
        super(message);
        invalidUserCause = InvalidUserCause.OTHER;
    }

    public InvalidUserException(Throwable cause) {
        super(cause);
        invalidUserCause = InvalidUserCause.OTHER;
    }

    public InvalidUserCause getInvalidUserCause() {
        return invalidUserCause;
    }

    public enum InvalidUserCause {
        USER_NOT_FOUND, INVALID_PASSWORD, OTHER;
    }
}
