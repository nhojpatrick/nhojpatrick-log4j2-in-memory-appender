package com.github.nhojpatrick.log4j2.appenders.inmemory;

public class LogStatement {

    private final String message;

    public LogStatement(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
