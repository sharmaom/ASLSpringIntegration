package com.niit.springIntegration.demo.handlers;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Prepare content for the output message and build message with new content.
 *
 * @author Om Prakash Sharma.
 *
 */
public class ServiceActivatorProcessMsg {
    /**
     * NEWLINE constant.
     */
    private static final String NEWLINE = "\n";

    /**
     * Processing of payload.
     * @param message , not null.
     * @return Object , never null.
     */
    public final Object processMessage(final Message<?> message) {
        String content = generateContent(message.getPayload()
                .toString());
        Message<String> output = MessageBuilder.withPayload(content)
                .copyHeaders(message.getHeaders()).build();
        return output;
    }

    /**
     * Calculate sum of all the integers in a file.
     *
     * @param payload
     *            , not null.
     * @return the sum of the lines , not null.
     */
    private String generateContent(final String payload) {
        long sum = 0;
        String[] lines = payload.split(NEWLINE);
        for (String line : lines) {
            sum = sum + Long.valueOf(line.trim());
        }
        return String.valueOf(sum);
    }
}
