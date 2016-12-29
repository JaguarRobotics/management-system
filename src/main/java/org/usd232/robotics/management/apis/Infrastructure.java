package org.usd232.robotics.management.apis;

import java.util.List;

/**
 * The model class representing all of the servers connected
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Infrastructure
{
    /**
     * The latest version of the software
     * 
     * @since 1.0
     */
    public String       latestVersion;
    /**
     * The list of devices connected
     * 
     * @since 1.0
     */
    public List<Device> devices;
}
