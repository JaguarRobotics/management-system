package org.usd232.robotics.management.apis;

/**
 * The model class for a connected device
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Device
{
    /**
     * The host name of the device
     * 
     * @since 1.0
     */
    public String     hostname;
    /**
     * The role the device has
     * 
     * @since 1.0
     */
    public DeviceRole role;
    /**
     * The version of the software the device is running
     * 
     * @since 1.0
     */
    public String     version;
}
