package org.usd232.robotics.management.apis;

import java.sql.Date;

/**
 * How events need to be signed up for
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EventSignup
{
    /**
     * If the signup is required for the event
     * 
     * @since 1.0
     */
    public boolean required;
    /**
     * The date that the members need to sign up before in order to go to the event
     * 
     * @since 1.0
     */
    public Date    deadline;
    /**
     * <code>true</code> if the member has signed up, <code>false</code> if the member has said he/she cannot attend, or
     * <code>null</code> if {@link EventSignup#required} is <code>false</code> or the member has not decided either way
     * yet
     * 
     * @since 1.0
     */
    public Boolean rsvp;
}
