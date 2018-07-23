package by.tarelko.projectmaneger.service.exception;

public class CreateEntityException extends RuntimeException {
    public CreateEntityException() {
    }

    public CreateEntityException(String message) {
        super(message);
    }

    public CreateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateEntityException(Throwable cause) {
        super(cause);
    }

    public CreateEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
