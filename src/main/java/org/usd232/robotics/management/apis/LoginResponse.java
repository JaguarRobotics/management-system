package org.usd232.robotics.management.apis;

import org.usd232.robotics.management.apis.permissions.Permissions;

/**
 * The response to the {@link LoginRequest}
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class LoginResponse
{
    /**
     * The status of the authentication
     * 
     * @since 1.0
     */
    public String      authentication;
    /**
     * The permissions of the user
     * 
     * @since 1.0
     */
    public Permissions permissions;
    /**
     * The profile of the user
     * 
     * @since 1.0
     */
    public UserProfile profile;
}
