package pages;

import java.io.*;
import java.util.Properties;


public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(System.getProperty("environment", "application") + ".properties");
            InputStreamReader inR = new InputStreamReader(in, "windows-1251");
            properties.load(inR);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}