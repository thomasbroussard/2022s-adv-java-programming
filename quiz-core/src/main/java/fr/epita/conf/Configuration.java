package fr.epita.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {


    private final Properties properties;

    public Configuration(){
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/conf.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getValue(String key){
       return properties.getProperty(key);
    }
}
