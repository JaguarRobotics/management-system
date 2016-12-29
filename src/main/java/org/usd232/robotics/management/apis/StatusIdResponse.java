package org.usd232.robotics.management.apis;

/**
 * A response that includes a status as well as an id
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class StatusIdResponse
{
    /**
     * If the request was successful
     * 
     * @since 1.0
     */
    public boolean success;
    /**
     * The id to respond with
     * 
     * @since 1.0
     */
    public int     id;
}
