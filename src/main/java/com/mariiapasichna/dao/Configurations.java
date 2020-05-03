package com.mariiapasichna.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    private static SessionFactory sessionFactory;

    public static SessionFactory getConfigurations() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        Properties properties = getPropertiesFile();
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        configuration.getProperties().setProperty("hibernate.connection.password", password);
        configuration.getProperties().setProperty("hibernate.connection.username", username);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    private static Properties getPropertiesFile() {
        Properties properties = new Properties();
        String userHome = System.getProperty("user.home");
        String config = System.getProperty("config");
        File file = new File(userHome + File.separator + config);
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}