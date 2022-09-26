package com.github.nhojpatrick.log4j2.appenders.inmemory;

public class LogStatement {

    private final String level;
    private final String message;
    private final long timeMillis;

    public LogStatement(final String level,
                        final String message,
                        final long timeMillis) {
        this.level = level;
        this.message = message;
        this.timeMillis = timeMillis;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public long getTimeMillis() {
        return this.timeMillis;
    }

}
