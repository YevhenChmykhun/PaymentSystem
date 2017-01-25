package com.chmykhun.jdbc.dao.factory;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.manager.DatabaseProperties;

/**
 * Created by Evgenii on 1/18/2017.
 */
public class DaoFactory {

    public static AbstractDaoFactory getDaoFactory(ConnectionWrapper connection) {
        String type = DatabaseProperties.getInstance().getProperty(DatabaseProperties.DATABASE_TYPE);
        AbstractDaoFactory daoFactory = null;
        switch (type.toLowerCase()) {
            case "mysql":
                daoFactory = new MySQLDaoFactory(connection);
                break;
            case "postgresql":
                break;
            default:
                daoFactory = new MySQLDaoFactory(connection);
                break;
        }

        return daoFactory;
    }
}
