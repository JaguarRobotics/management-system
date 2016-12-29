package org.usd232.robotics.management.apis;

import java.sql.Date;

/**
 * The model class for an event
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Event
{
    /**
     * The id of the event
     * 
     * @since 1.0
     */
    public int         id;
    /**
     * The type of the event
     * 
     * @since 1.0
     */
    public EventType   type;
    /**
     * The name of the event
     * 
     * @since 1.0
     */
    public String      name;
    /**
     * The location the event occurs at
     * 
     * @since 1.0
     */
    public String      location;
    /**
     * The date the event occurs on
     * 
     * @since 1.0
     */
    public Date        date;
    /**
     * The time the event occurs
     * 
     * @since 1.0
     */
    public EventTime   time;
    /**
     * How the event should be signed up for
     * 
     * @since 1.0
     */
    public EventSignup signup;
    /**
     * <code>true</code> if the member attended the event, <code>false</code> if the member did not attend the event,
     * and <code>null</code> if the event has not yet occurred.
     * 
     * @since 1.0
     */
    public Boolean     attended;
}
