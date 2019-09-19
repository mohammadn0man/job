package com.example.dbsample;

import android.util.Log;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class MySQLConnector {

    private static final String  TAG = "MyDB";

    public static Connection getMySqlConnection()    {
        /* Declare and initialize a sql Connection variable. */
        java.sql.Connection ret = null;

        try
        {

            Log.d(TAG, "before com.mysql.jdbc.Driver");
            /* Register for jdbc driver class. */
            Class.forName("com.mysql.jdbc.Driver");

            Log.d(TAG, "after com.....");

            /* Create connection url. */
            String mysqlConnUrl = "jdbc:mysql://10.0.2.2:3306/employee";

            /* db user name. */
            String mysqlUserName = "root";

            /* db password. */
            String mysqlPassword = "admin";

            /* Get the Connection object. */
            ret = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);

            Log.d(TAG, "after getConnection");

            /* Get related meta data for this mysql server to verify db connect successfully.. */
            DatabaseMetaData dbmd = ret.getMetaData();

            String dbName = dbmd.getDatabaseProductName();

            String dbVersion = dbmd.getDatabaseProductVersion();

            String dbUrl = dbmd.getURL();

            String userName = dbmd.getUserName();

            String driverName = dbmd.getDriverName();

            Log.d(TAG, "Database Name is " + dbName);

            Log.d(TAG, "Database Version is " + dbVersion);

            Log.d(TAG, "Database Connection Url is " + dbUrl);

            Log.d(TAG, "Database User Name is " + userName);

            Log.d(TAG, "Database Driver Name is " + driverName);

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            Log.d(TAG, "inside Finally block");
            return ret;
        }
    }
}
