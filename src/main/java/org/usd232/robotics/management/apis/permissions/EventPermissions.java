package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to events
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EventPermissions
{
    /**
     * If the user can view a list of all of the events
     * 
     * @since 1.0
     */
    public boolean              view;
    /**
     * If the user can add new events
     * 
     * @since 1.0
     */
    public boolean              add;
    /**
     * How the user can edit events
     * 
     * @since 1.0
     */
    public EventEditPermissions edit;
    /**
     * If the user can remove events
     * 
     * @since 1.0
     */
    public boolean              remove;
}
