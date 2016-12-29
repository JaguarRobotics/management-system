package org.usd232.robotics.management.server.session;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a session for a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Session
{
    /**
     * The id of the session
     * 
     * @since 1.0
     */
    public final UUID  uuid;
    /**
     * The permissions the user has
     * 
     * @since 1.0
     */
    public Set<String> permissions;

    /**
     * Checks if the user of this session has all of the required permissions
     * 
     * @param permissions
     *            The permissions
     * @return If the user has all of the permissions
     * @since 1.0
     */
    public boolean checkPermissions(String[] permissions)
    {
        if (this.permissions == null)
        {
            return false;
        }
        return this.permissions.containsAll(Arrays.asList(permissions));
    }

    /**
     * Checks if the user of this session has all of the required permissions
     * 
     * @param permissions
     *            The permissions
     * @return If the user has all of the permissions
     * @since 1.0
     */
    public boolean checkPermissions(RequirePermissions permissions)
    {
        if (permissions == null)
        {
            return true;
        }
        return checkPermissions(permissions.value());
    }

    /**
     * Checks if the user of this session has all of the required permissions
     * 
     * @param required
     *            The required permissions
     * @param session
     *            The session to check against
     * @return If the user has all of the permissions
     * @since 1.0
     */
    public static boolean checkPermissions(RequirePermissions required, Session session)
    {
        if (session == null)
        {
            return required == null;
        }
        else
        {
            return session.checkPermissions(required);
        }
    }

    /**
     * Default constructor
     * 
     * @param uuid
     *            The id of the session
     * @since 1.0
     */
    Session(UUID uuid)
    {
        this.uuid = uuid;
    }
}
