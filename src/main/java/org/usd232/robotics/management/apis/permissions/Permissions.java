package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions the user has
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Permissions
{
    /**
     * The permissions relating to the kiosk
     * 
     * @since 1.0
     */
    public KioskPermissions      kiosk;
    /**
     * The permissions relating to messages
     * 
     * @since 1.0
     */
    public MessagePermissions    message;
    /**
     * The permissions relating to events
     * 
     * @since 1.0
     */
    public EventPermissions      events;
    /**
     * The permissions relating to attendance records
     * 
     * @since 1.0
     */
    public AttendancePermissions attendance;
    /**
     * The permissions relating to users
     * 
     * @since 1.0
     */
    public UserPermissions       users;
    /**
     * The permissions relating to devices
     * 
     * @since 1.0
     */
    public DevicePermissions     devices;
    /**
     * The permissions relating to settings
     * 
     * @since 1.0
     */
    public SettingsPermissions   settings;
    /**
     * The permissions relating to signing in
     * 
     * @since 1.0
     */
    public SignInPermissions     signIn;
}
