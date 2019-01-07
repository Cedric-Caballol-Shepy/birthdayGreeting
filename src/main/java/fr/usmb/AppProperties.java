package fr.usmb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppProperties {

    private final static String CSV_FILE_PATH = "CSV_FILE_PATH";
    private static final String FROM = "from";
    private static final String PORT = "port";
    private static final String CSV_SEPARATOR = "CSVSeparator";
    private static final String FROM_NAME = "fromName";
    private static final String HOST = "host";
    private static final String SMTP_USERNAME = "smtp_Username";
    private static final String SMTP_PASSWORD = "smtp_Password";
    private static Properties properties = null;

    public static void initProperties(String CSV_File_Path, String properties_File) {
        if (properties == null) {
            properties = new Properties();
            try {
                InputStream input = new FileInputStream(properties_File);
                properties.load(input);

            } catch (IOException e) {
                System.out.println("Properties file not loaded.");
                System.out.println("Error message: " + e.getMessage());
            }
            properties.setProperty("CSV_FILE_PATH",CSV_File_Path);
        }
    }

    private static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public static String getCSVFilePath() {
        return getProperty(CSV_FILE_PATH);
    }

    public static String getSeparator() {
        return getProperty(CSV_SEPARATOR);
    }

    public static String getPort() {
        return getProperty(PORT);
    }

    public static String getFrom() {
        return getProperty(FROM);
    }

    public static String getFromName() {
        return getProperty(FROM_NAME);
    }

    public static String getHost() {
        return getProperty(HOST);
    }

    public static String getSmtp_Username() {
        return getProperty(SMTP_USERNAME);
    }

    public static String getSmtp_Password() {
        return getProperty(SMTP_PASSWORD);
    }
}