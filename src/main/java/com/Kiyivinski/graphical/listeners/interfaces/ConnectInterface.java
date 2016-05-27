package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Connect interface.
 */
public interface ConnectInterface {
    /**
     * Sets connection.
     *
     * @param database the database
     * @param user     the user
     * @param password the password
     */
    void setConnect(String database, String user, String password);

    /**
     * Connect.
     */
    void connect();
}
