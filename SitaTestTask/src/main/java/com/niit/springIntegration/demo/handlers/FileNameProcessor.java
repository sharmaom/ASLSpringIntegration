package com.niit.springIntegration.demo.handlers;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * Custom Generator class used to update the name of the file.
 *  @author Om Prakash Sharma.
 *
 */
public class FileNameProcessor implements FileNameGenerator {
  /**
   * variable declaration.
   */
    private String suffix;
/**
 * getSuffix.
 * @return String , never null.
 */
    public final String getSuffix() {
        return suffix;
    }
/**
 * setSuffix.
 * @param suffx , not null.
 */
    public final void setSuffix(final String suffx) {
        this.suffix = suffx;
    }
    /**
     * generateFileName.
     * Method to update the filename by FileWritingMessageHandler
     *
     * @param message , not null.
     * @return the updated file name
     */
    public final String generateFileName(final Message<?> message) {
        return message.getHeaders().get("file_name").toString() + "." + suffix;
    }

}
