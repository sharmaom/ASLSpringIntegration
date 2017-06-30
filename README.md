Test task scenario:

There will be a series of files placed into the directory (D:\SITA_TEST_TASK\IN) with a number on each line. Attached are some example files (invalid and valid).The application will poll the input folder(D:\SITA_TEST_TASK\OUT).Will summ all the integers present in the file. The out put file will then be placed at the given location:(D:\SITA_TEST_TASK\OUT).Those files which are processed will go in the PROCESSED folder with extension .PROCESSED to the file(D:\SITA_TEST_TASK\PROCESSED).Similarly output file should have the same name as the input file with .OUTPUT appended to the end of the filename and the same goes for ERROR file(D:\SITA_TEST_TASK\ERROR).

Dependencies

• spring integration framework 4.1.2.RELEASE
• spring framework 4.1.4.RELEASE
• log4j 1.2.17
• junit 4.10
• apache commons 1.3

Maven repository to download dependencies

https://repo.maven.apache.org/maven2/

Build the application

1. From the command prompt run mvn clean install

To Test checkstyle

1. From the command promptmvn:checkstyle:checkstyle

Note1. It is assumed that the input files will be placed under D:\SITA_TEST_TASK\IN, however we can configure this value in application.properties which is available at src/main/resources


Testing the application.

1. Before running the application, place the input files under D:\SITA_TEST_TASK\IN.
2. To run the application put the project from target in the director \webapps of tomcat.
3. Verify the results in D:\SITA_TEST_TASK\OUT,D:\SITA_TEST_TASK\PROCESSED and D:\SITA_TEST_TASK\ERROR.

Process Flow

1) 'inbound-channel-adapter' is defined which will poll every 5 seconds for the files in the input directory.
2) There is a file-to-string-transformer which converts the file to string and places the samein the output channel.
3) From the output channel the file is sent to a router which checks for the validity of the file. If the file is valid is transports the   same to the output channel otherwise to error channel.
4) The output channel is a publish subscribe channel.
5) A service activator listens to the output channel and receiving the file is sums all the integer present in the file and place the processed     output file to the desired output folder.
6) There  is also a outbound-channel-adapter which listens to the same output channel. On receiving the file it appends the .PROCESSED extension to the file and saves the same to the desired location.
