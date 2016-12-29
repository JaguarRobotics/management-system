package org.usd232.robotics.management.apis.permissions;

/**
 * The permissions relating to signing in
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class SignInPermissions
{
    /**
     * If the user can sign in using the kiosk
     * 
     * @since 1.0
     */
    public boolean kisok;
    /**
     * If the user can sign in with a 2D code using the kiosk
     * 
     * @since 1.0
     */
    public boolean code;
    /**
     * If the user can use automatic sign ins
     * 
     * @since 1.0
     */
    public boolean auto;
}
