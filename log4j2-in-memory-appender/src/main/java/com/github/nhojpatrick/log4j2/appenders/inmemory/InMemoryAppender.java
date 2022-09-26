package com.github.nhojpatrick.log4j2.appenders.inmemory;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Plugin(name = InMemoryAppender.IN_MEMORY_APPENDER,
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE
)
public class InMemoryAppender
        extends AbstractAppender {

    private static final long serialVersionUID = 8047713135100613186L;

    public static final String IN_MEMORY_APPENDER = "InMemoryAppender";

    private List<LogStatement> messages = new ArrayList<>();

    protected InMemoryAppender(String name,
                               Filter filter,
                               Layout<? extends Serializable> layout) {
        super(name, filter, layout, false, Property.EMPTY_ARRAY);
    }

    @Override
    public void append(final LogEvent event) {
        final String level = event.getLevel()
                .toString();
        final String message = event.getMessage()
                .getFormattedMessage();
        final long timeMillis = event.getTimeMillis();
        final LogStatement logStatement = new LogStatement(level, message, timeMillis);
        getMessages()
                .add(logStatement);
    }

    @SuppressFBWarnings(value = {"UP_UNUSED_PARAMETER"}, justification = "As designed")
    @PluginFactory
    public static InMemoryAppender createAppender(@PluginAttribute("name") String name,
                                                  @PluginElement("Layout") Layout<? extends Serializable> layout,
                                                  @PluginElement("Filter") final Filter filter,
                                                  @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            name = IN_MEMORY_APPENDER;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new InMemoryAppender(name, filter, layout);
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Accepted will look at changing 'return messages;'")
    public List<LogStatement> getMessages() {
        return this.messages;
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
            justification = "Accepted will look at changing 'this.messages = messages;'")
    public void setMessages(List<LogStatement> messages) {
        this.messages = messages;
    }

}
