package uz.m_m;

import java.io.FileReader;
import java.util.Properties;

public class MyProperty {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/resources/application.properties");
            Properties properties = new Properties();
            properties.load(reader);
            String lang = (String) properties.get("sys.language");
            String username = properties.getProperty("sys.username");
            String password = properties.getProperty("sys.password");
            System.out.println(lang);
            System.out.println(username);
            System.out.println(password);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
