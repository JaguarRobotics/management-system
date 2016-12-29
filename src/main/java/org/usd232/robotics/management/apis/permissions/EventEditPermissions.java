package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to editing events
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EventEditPermissions
{
    /**
     * If the user can modify the type of an event
     * 
     * @since 1.0
     */
    public boolean type;
    /**
     * If the user can modify the name of an event
     * 
     * @since 1.0
     */
    public boolean name;
    /**
     * If the user can modify the date or time an event takes place
     * 
     * @since 1.0
     */
    public boolean datetime;
}
