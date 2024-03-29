package com.github.nhojpatrick.log4j2.appenders.inmemory2.tests;

import com.github.nhojpatrick.log4j2.appenders.inmemory2.InMemoryAppender;
import com.github.nhojpatrick.log4j2.appenders.inmemory2.InMemoryAppenderHelper;
import com.github.nhojpatrick.log4j2.appenders.inmemory2.LogStatement;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InMemoryAppenderTest {

    @Test
    public void inMemoryAppender() {

        final Logger logger = LoggerFactory.getLogger(InMemoryAppenderTest.class);

        logger.info("Qwerty 1234567890");

        final InMemoryAppender inMemoryAppender = InMemoryAppenderHelper.getAppender();
        final List<LogStatement> messages = inMemoryAppender.getMessages();
        System.out.println(messages);
        final Optional<String> message = messages
                .stream()
                .map(p -> p.getMessage())
                .filter(p -> p.contains("Qwerty"))
                .findFirst();

        assertAll(
                () -> assertThat("Expected message", message.isPresent(), is(equalTo(true))),
                () -> assertThat(message.get(), is(equalTo("Qwerty 1234567890")))
        );
    }

}
