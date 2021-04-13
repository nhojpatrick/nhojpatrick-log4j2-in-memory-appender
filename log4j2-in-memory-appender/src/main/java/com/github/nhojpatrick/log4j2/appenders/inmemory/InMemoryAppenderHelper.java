package com.github.nhojpatrick.log4j2.appenders.inmemory;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

import static com.github.nhojpatrick.log4j2.appenders.inmemory.InMemoryAppender.IN_MEMORY_APPENDER;

public class InMemoryAppenderHelper {

    @SuppressFBWarnings(value = {"USBR_UNNECESSARY_STORE_BEFORE_RETURN"}, justification = "As designed")
    public static InMemoryAppender getAppender() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        final InMemoryAppender inMemoryAppender = (InMemoryAppender) config.getAppenders()
                .get(IN_MEMORY_APPENDER);
        return inMemoryAppender;
    }

}
