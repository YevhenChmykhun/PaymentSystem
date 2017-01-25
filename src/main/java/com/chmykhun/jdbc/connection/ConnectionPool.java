package com.chmykhun.jdbc.connection;

import com.chmykhun.manager.DatabaseProperties;
import com.mysql.jdbc.Driver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger log = LogManager.getLogger(ConnectionPool.class);

    private static ReentrantLock lock = new ReentrantLock();
    private BlockingQueue<ConnectionWrapper> connections;

    private ConnectionPool() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            DatabaseProperties db = DatabaseProperties.getInstance();
            int poolSize = Integer.parseInt(db.getProperty(db.POOL_SIZE));

            Properties properties = new Properties();
            properties.put(db.USER, db.getProperty(db.USER));
            properties.put(db.PASSWORD, db.getProperty(db.PASSWORD));
            properties.put(db.AUTO_RECONNECT, db.getProperty(db.AUTO_RECONNECT));
            properties.put(db.CHAR_ENCODING, db.getProperty(db.CHAR_ENCODING));
            properties.put(db.USE_UNICODE, db.getProperty(db.USE_UNICODE));
            properties.put(db.USE_SSL, db.getProperty(db.USE_SSL));
            properties.put(db.SERVER_TIMEZONE, db.getProperty(db.SERVER_TIMEZONE));

            connections = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                connections.add(new ConnectionWrapper(properties, db.getProperty(db.URL)));
            }
            log.log(Level.DEBUG, "Connection pool initialized. Pool size = " + poolSize);
        } catch (SQLException e) {
            log.log(Level.FATAL, "Register Driver error:", e);
            throw new RuntimeException(e);
        }
    }

    public static ConnectionPool getInstance() {
        return PoolHolder.pool;
    }

    /**
     * @return ConnectionWrapper wrapped in Optional if the pool is not empty, Optional.empty() otherwise
     */
    public Optional<ConnectionWrapper> takeConnection() {
        ConnectionWrapper connection = null;
        try {
            connection = connections.poll(5, TimeUnit.SECONDS);
            if (connection != null) {
                log.log(Level.DEBUG, "Connection taken. Pool size = " + connections.size());
            } else {
                log.log(Level.DEBUG, "Connection not taken. Pool size = " + connections.size());
            }
        } catch (InterruptedException e) {
            log.log(Level.ERROR, e);
        }
        return Optional.ofNullable(connection);
    }

    public boolean returnConnection(ConnectionWrapper connection) {
        boolean isReturned = false;
        isReturned = connections.add(connection);
        if (isReturned) {
            log.log(Level.DEBUG, "Connection returned. Pool size = " + connections.size());
        }
        return isReturned;
    }

    public void closePool() {
        while (!connections.isEmpty()) {
            ConnectionWrapper connection = connections.poll();
            connection.closeConnection();
        }

        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = (com.mysql.jdbc.Driver) drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                log.log(Level.DEBUG, "Driver deregistered.", driver);
            } catch (SQLException e) {
                log.log(Level.ERROR, "Error while deregistering driver.", e);
            }
        }
        log.log(Level.DEBUG, "Connection pool closed.");
    }

    /**
     * Nested class for lazy pool initialization.
     */
    private static class PoolHolder {
        private static ConnectionPool pool;
        private static AtomicBoolean init = new AtomicBoolean(false);

        static {
            lock.lock();
            try {
                if (!init.get()) {
                    pool = new ConnectionPool();
                    init.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
