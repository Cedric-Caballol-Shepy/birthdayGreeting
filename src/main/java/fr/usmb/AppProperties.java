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

    public static void initProperties(String CSV_File_Path, String properties_File) throws IOException {
        if (properties == null) {
            properties = new Properties();
            InputStream input = new FileInputStream(properties_File);
            properties.load(input);
            properties.setProperty("CSV_FILE_PATH",CSV_File_Path);
        }
    }
    private static String getProperty(String propertyName) throws IOException {
        return properties.getProperty(propertyName);
    }

    public static String getCSVFilePath() throws IOException {
        return getProperty(CSV_FILE_PATH);
    }

    public static String getSeparator() throws IOException {
        return getProperty(CSV_SEPARATOR);
    }

    public static String getPort() throws IOException {
        return getProperty(PORT);
    }

    public static String getFrom() throws IOException {
        return getProperty(FROM);
    }

    public static String getFromName() throws IOException {
        return getProperty(FROM_NAME);
    }

    public static String getHost() throws IOException {
        return getProperty(HOST);
    }

    public static String getSmtp_Username() throws IOException {
        return getProperty(SMTP_USERNAME);
    }

    public static String getSmtp_Password() throws IOException {
        return getProperty(SMTP_PASSWORD);
    }
}