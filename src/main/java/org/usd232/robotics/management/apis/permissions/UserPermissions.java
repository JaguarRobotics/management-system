package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to users
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class UserPermissions
{
    /**
     * If the user can view a list of users
     * 
     * @since 1.0
     */
    public boolean view;
    /**
     * If the user can verify users
     * 
     * @since 1.0
     */
    public boolean verify;
    /**
     * If the user can kick members
     * 
     * @since 1.0
     */
    public boolean unverify;
}
