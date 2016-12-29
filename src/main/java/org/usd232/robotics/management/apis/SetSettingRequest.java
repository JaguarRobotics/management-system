package org.usd232.robotics.management.apis;

/**
 * The request to set a setting
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class SetSettingRequest
{
    /**
     * The key of the setting
     * 
     * @since 1.0
     */
    public String key;
    /**
     * The new value for the setting
     * 
     * @since 1.0
     */
    public String value;
}
