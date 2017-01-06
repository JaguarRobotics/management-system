package org.usd232.robotics.management.server.apis;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.usd232.robotics.management.apis.Event;
import org.usd232.robotics.management.apis.EventSignup;
import org.usd232.robotics.management.apis.EventTime;
import org.usd232.robotics.management.apis.EventType;
import org.usd232.robotics.management.server.database.Database;
import org.usd232.robotics.management.server.routing.GetApi;
import org.usd232.robotics.management.server.session.RequirePermissions;
import org.usd232.robotics.management.server.session.Session;

/**
 * Apis that have to do with events
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EventApis
{
    /**
     * Gets a list of events
     * 
     * @param session
     *            The session
     * @return The list of events
     * @since 1.0
     * @throws SQLException
     *             If an error occurs while connecting to the database
     */
    @GetApi("/events")
    public static Event[] getEvents(Session session) throws SQLException
    {
        try (PreparedStatement st = Database.prepareStatement(
                        "SELECT `events`.`id`, `events`.`type`, `events`.`name`, `events`.`location`, `events`.`date`, `events`.`signup`, `attendance`.`rsvp`,  IF(`events`.`date` < NOW(), `attendance`.`signin` IS NOT NULL, -1) FROM `events` LEFT JOIN `attendance` ON `events`.`id` = `attendance`.`eventid` AND `attendance`.`userid` = ?"))
        {
            st.setInt(1, session.userId);
            try (ResultSet res = st.executeQuery())
            {
                List<Event> events = new ArrayList<Event>();
                while (res.next())
                {
                    Date signupDeadline = res.getDate(6);
                    Date rsvp = res.getDate(7);
                    int attended = res.getInt(8);
                    events.add(new Event(res.getInt(1), EventType.valueOf(res.getString(2)), res.getString(3),
                                    res.getString(4), res.getDate(5), null,
                                    new EventSignup(signupDeadline != null, signupDeadline, rsvp == null ? null : true),
                                    attended == -1 ? null : attended == 1));
                }
                return events.toArray(new Event[0]);
            }
        }
    }

    /**
     * Gets the information about a single event
     * 
     * @param url
     *            The request url
     * @return The event object
     * @since 1.0
     * @throws SQLException
     *             If an error occurs while connecting to the database
     */
    @GetApi("/events/*")
    @RequirePermissions("event.view")
    public static Event getEvent(String url) throws SQLException
    {
        int eventId = Integer.parseInt(url.substring(8, url.length() - 5));
        try (PreparedStatement st = Database.prepareStatement(
                        "SELECT `type`, `name`, `location`, `date`, `start`, `end`, `signup` FROM `events` WHERE `id` = ?"))
        {
            st.setInt(1, eventId);
            try (ResultSet res = st.executeQuery())
            {
                if (!res.next())
                {
                    return null;
                }
                Time start = res.getTime(5);
                Time end = res.getTime(6);
                Date deadline = res.getDate(7);
                return new Event(eventId, EventType.valueOf(res.getString(1)), res.getString(2), res.getString(3),
                                res.getDate(4), new EventTime(start == null && end == null, start, end),
                                new EventSignup(deadline != null, deadline, null), null);
            }
        }
    }
}
