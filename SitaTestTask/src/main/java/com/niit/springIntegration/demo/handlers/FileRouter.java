package com.niit.springIntegration.demo.handlers;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * Router class to send requests to appropriate channel.
 *
 * @author Om Prakash Sharma.
 *
 */
public class FileRouter {

    /**
     * LOGGER to use.
     */
    private static final Logger LOGGER = Logger.getLogger(FileRouter.class);
    /**
     * HEADER_FILE_NAME.
     */
    private static final String HEADER_FILE_NAME = "file_name";
    /**
     * MSG_RECEIVED.
     */
    private static final String MSG_RECEIVED = "%s received. Content: %s";
    /**
     * MSG_SENT.
     */
    private static final String MSG_SENT
        = "File %s is sending to Chanel: %s";

    /**
     * Method to receive and process the incoming payload and send to the right
     * channel.
     *
     * @param msg , not null.
     * @return String , never null.
     */
    public final String handleFile(final Message<String> msg) {
        String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
        String content = msg.getPayload();
        LOGGER.debug(String.format(MSG_RECEIVED, fileName, content));
        String channel = validateContent(content, fileName);
        LOGGER.info(String.format(MSG_SENT, fileName, channel));
        return channel;
    }

    /**
     * Check if file content is valid or not.
     *
     * @param content , not null.
     * @param fileName , not null.
     * @return the channel
     */

    private String validateContent(final String content,
            final String fileName) {
        String[] lines = content.split("\n");
        boolean isValid = true;
        isValid = checkFileValidity(lines, isValid, fileName);
        if (isValid) {
            return "outputChannel";
        }
        return "errorChannel";
    }

    /**
     * This method will used for validating the file content using regular
     * expression.
     *
     * @param lines
     *            , not null.
     * @param isValid
     *            , not null.
     * @param fileName , not null.
     * @return boolean , never null.
     */
    private boolean checkFileValidity(final String[] lines, boolean isValid,
            final String fileName) {
        try {
            for (String line : lines) {
                if (!line.trim().matches("\\-?\\d+")) {
                    isValid = false;
                    break;
                }
            }
        } catch (NullPointerException e) {
            LOGGER.error("Error in processing file with filename"
                  + " : " + fileName);
            isValid = false;
        } catch (Exception e) {
            LOGGER.error("Error in processing file with filename : " + fileName
                    + ":" + e.getMessage());
            isValid = false;
        }
        return isValid;
    }
}
