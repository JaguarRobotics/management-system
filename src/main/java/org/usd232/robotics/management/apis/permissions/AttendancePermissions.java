package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to attendance records
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class AttendancePermissions
{
    /**
     * If the user can view attendance records
     * 
     * @since 1.0
     */
    public boolean view;
    /**
     * If the user can modify attendance records
     * 
     * @since 1.0
     */
    public boolean modify;
    /**
     * If the user can excuse absences
     * 
     * @since 1.0
     */
    public boolean excuse;
}
