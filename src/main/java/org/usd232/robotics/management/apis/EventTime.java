package org.usd232.robotics.management.apis;

import java.sql.Time;

/**
 * The time an event or meeting is
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EventTime
{
    /**
     * If the event takes up the entire day
     * 
     * @since 1.0
     */
    public boolean allDay;
    /**
     * The time the event starts
     * 
     * @since 1.0
     */
    public Time    start;
    /**
     * The time the event ends
     * 
     * @since 1.0
     */
    public Time    end;
}
