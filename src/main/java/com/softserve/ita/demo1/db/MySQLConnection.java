package com.softserve.ita.demo1.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.TimeZone;


public class MySQLConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger("DaoLogger");

    private static final String CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "softserve66";


    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName(CLASS);
                TimeZone timeZone = TimeZone.getTimeZone("Etc/GMT+3"); // e.g. "Europe/Rome"
                TimeZone.setDefault(timeZone);
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                return connection;
            } catch (Exception e) {
                System.err.println("Connection to MySQL DB failed.");
                e.printStackTrace();
                LOGGER.error("Connection",e);
                return null;
            }
        }
    }

}
