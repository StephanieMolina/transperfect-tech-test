package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties properties;
    private final String configFilePath = "config.properties";

    public Config() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at: " + configFilePath);
        }
    }

    //returns main site URL
    public String getMainURL(){
        String url = properties.getProperty("MainURL");
        if(url != null){
            System.out.println("URL: " + url);
            return url;
        } else {
            throw new RuntimeException("Property mainURL not found in config.properties file");
        }
    }

    public String getEmail(){
        String property = properties.getProperty("Email");
        if(property != null)
            return property;
        throw new RuntimeException("Email property not found in config.properties");
    }

    public String getName(){
        String property = properties.getProperty("Name");
        if(property != null)
            return property;
        throw new RuntimeException("Name property not found in config.properties");
    }

    public String getAddress(){
        String property = properties.getProperty("Address");
        if(property != null)
            return property;
        throw new RuntimeException("Address property not found in config.properties");
    }

    public String getPhone(){
        String property = properties.getProperty("Phone");
        if(property != null)
            return property;
        throw new RuntimeException("Phone property not found in config.properties");
    }

    public String getCreditCard(){
        String property = properties.getProperty("CreditCardNumber");
        if(property != null)
            return property;
        throw new RuntimeException("CreditCardNumber property not found in config.properties");
    }

    public String getExpiration(){
        String property = properties.getProperty("Expiration");
        if(property != null)
            return property;
        throw new RuntimeException("Expiration property not found in config.properties");
    }

    public String getCVV(){
        String property = properties.getProperty("CVV");
        if(property != null)
            return property;
        throw new RuntimeException("CVV property not found in config.properties");
    }

}
