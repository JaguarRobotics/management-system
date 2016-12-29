package org.usd232.robotics.management.apis;

/**
 * The request to set the rsvp status of a user on an event
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class RsvpRequest
{
    /**
     * The id of the event
     * 
     * @since 1.0
     */
    public int     event;
    /**
     * <code>true</code> if the member has signed up, <code>false</code> if the member has said he/she cannot attend, or
     * <code>null</code> if {@link EventSignup#required} is <code>false</code> or the member has not decided either way
     * yet
     * 
     * @since 1.0
     */
    public Boolean rsvp;
}
