package com.github.nhojpatrick.log4j2.appenders.inmemory2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

import static com.github.nhojpatrick.log4j2.appenders.inmemory2.InMemoryAppender.IN_MEMORY_APPENDER; // NOPMD

public class InMemoryAppenderHelper {

    public static InMemoryAppender getAppender() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        final InMemoryAppender inMemoryAppender = (InMemoryAppender) config.getAppenders()
                .get(IN_MEMORY_APPENDER);
        return inMemoryAppender;
    }

}
