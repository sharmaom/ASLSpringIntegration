package com.niit.springIntegration.demo.handlers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.niit.springIntegration.demo.handlers.FileNameProcessor;

/**
 * Test class to check ProcessedFileNameGenerator.
 * 
 * @author Om Prakash Sharma.
 * 
 */
public class FileNameProcessorTest {

	private FileNameProcessor generator;

	/**
	 * Setup the required resources.
	 */
	@Before
	public void setUp() {
		generator = new FileNameProcessor();
	}

	/**
	 * Tidying up resources
	 */
	@After
	public void tearDown() {
		generator = null;
	}

	/**
	 * Test to verify the file name after the generator process. This is
	 * negative case
	 */
	@Test
	public void fileNameVerifyNegativeCase() {
		Message<?> message = MessageBuilder.withPayload("Sample")
				.setHeader("file_name", "XYZ.txt").build();
		generator.setSuffix("OUTPUT");
		String generatedFileName = generator.generateFileName(message);
		Assert.assertNotSame("The generated file name is wrong ",
				"XYZ.txt.PROCESSED", generatedFileName);
	}

	/**
	 * Test to verify the file name after the generator process. This is
	 * negative case
	 */
	@Test
	public void fileNameVerifyPositiveCase() {
		Message<?> message = MessageBuilder.withPayload("Sample")
				.setHeader("file_name", "XYZ.txt").build();
		generator.setSuffix("PROCESSED");
		String generatedFileName = generator.generateFileName(message);
		Assert.assertEquals("The generated file name is right ",
				"XYZ.txt.PROCESSED", generatedFileName);
	}
}
