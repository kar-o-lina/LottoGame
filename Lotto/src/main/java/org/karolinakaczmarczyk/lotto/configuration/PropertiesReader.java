package org.karolinakaczmarczyk.lotto.configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private PropertiesReader() {
    }

    public static String readProperty(String key, String filePath) throws IOException {
        Properties properties = new Properties();

        FileReader reader = new FileReader(filePath);
        properties.load(reader);

        return properties.getProperty(key);
    }
}

