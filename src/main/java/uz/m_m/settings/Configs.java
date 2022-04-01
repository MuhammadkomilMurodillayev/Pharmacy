package uz.m_m.settings;

import java.io.FileReader;
import java.util.Properties;

public class Configs {
    private static final Properties property = new Properties();


    static {
        load();
    }

    public static String getConfig(String key) {
        return property.getProperty(key);
    }


    private static void load() {
        try {
            FileReader reader = new FileReader("src/main/resources/application.properties");
            property.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
