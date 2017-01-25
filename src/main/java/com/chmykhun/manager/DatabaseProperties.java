package com.chmykhun.manager;

import java.util.ResourceBundle;

public class DatabaseProperties {

    private static DatabaseProperties instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "database";

    public static final String DATABASE_TYPE = "databaseType";
    public static final String URL = "url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String AUTO_RECONNECT = "autoReconnect";
    public static final String CHAR_ENCODING = "characterEncoding";
    public static final String USE_UNICODE = "useUnicode";
    public static final String POOL_SIZE = "poolsize";
    public static final String USE_SSL = "useSSL";
    public static final String SERVER_TIMEZONE = "serverTimezone";

    private DatabaseProperties() {
    }

    public static DatabaseProperties getInstance() {
        if (instance == null) {
            instance = new DatabaseProperties();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return resource.getString(key);
    }
}
