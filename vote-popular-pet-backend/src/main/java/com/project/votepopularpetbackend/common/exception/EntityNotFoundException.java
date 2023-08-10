package com.project.votepopularpetbackend.common.exception;

/**
 * EntityNotFoundException.java
 *
 * @author suna.park
 * @createdDate 2023-05-26.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
