package org.example.org.itstep;

public class NumberNegativeException extends Exception{
    public NumberNegativeException() {
    }

    public NumberNegativeException(String message) {
        super(message);
    }

    public NumberNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberNegativeException(Throwable cause) {
        super(cause);
    }

    public NumberNegativeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
