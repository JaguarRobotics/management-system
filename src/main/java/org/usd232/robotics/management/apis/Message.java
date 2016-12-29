package org.usd232.robotics.management.apis;

import java.sql.Date;
import java.sql.Time;

/**
 * A model class representing a message sent to a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Message
{
    /**
     * The date the message was sent on
     * 
     * @since 1.0
     */
    public Date   date;
    /**
     * The time the message was sent at
     * 
     * @since 1.0
     */
    public Time   time;
    /**
     * The name of the member who sent the message
     * 
     * @since 1.0
     */
    public String from;
    /**
     * The content of the message
     * 
     * @since 1.0
     */
    public String message;
}
