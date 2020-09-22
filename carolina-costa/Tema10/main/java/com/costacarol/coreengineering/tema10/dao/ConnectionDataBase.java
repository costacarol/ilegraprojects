package com.costacarol.coreengineering.tema10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    private static final String driverClass = "";
    private final static String url = "";
    private final static String user = "";
    private final static String password = "";
    private static Connection connection = null;

    public static Connection createConnection(){
        try{
            if (connection == null || connection.isClosed()){
                Class.forName(driverClass);
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
