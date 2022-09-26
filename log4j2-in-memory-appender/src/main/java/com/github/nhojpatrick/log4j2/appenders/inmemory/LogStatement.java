package com.github.nhojpatrick.log4j2.appenders.inmemory;

public class LogStatement {

    private final String level;
    private final String message;

    public LogStatement(final String level,
                        final String message) {
        this.level = level;
        this.message = message;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

}
