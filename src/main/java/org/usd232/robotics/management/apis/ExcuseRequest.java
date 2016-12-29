package org.usd232.robotics.management.apis;

/**
 * The request to add an excused absence to a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class ExcuseRequest
{
    /**
     * The id of the user to excuse
     * 
     * @since 1.0
     */
    public int     user;
    /**
     * The event to excuse the user from
     * 
     * @since 1.0
     */
    public int     event;
    /**
     * If the absence should be excused
     * 
     * @since 1.0
     */
    public boolean excused;
}
