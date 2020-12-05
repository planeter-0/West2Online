package com.assessment2;

public class OverdraftBalanceException extends RuntimeException {
    public OverdraftBalanceException() {
    }

    public OverdraftBalanceException(String message) {
        super(message);
    }
}
