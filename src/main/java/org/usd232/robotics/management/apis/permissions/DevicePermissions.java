package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to server devices
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class DevicePermissions
{
    /**
     * If the user can add new devices
     * 
     * @since 1.0
     */
    public boolean add;
    /**
     * If the user can update the software on devices
     * 
     * @since 1.0
     */
    public boolean update;
    /**
     * If the user can remove devices
     * 
     * @since 1.0
     */
    public boolean remove;
}
