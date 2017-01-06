package org.usd232.robotics.management.server.apis;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.usd232.robotics.management.apis.Event;
import org.usd232.robotics.management.apis.EventSignup;
import org.usd232.robotics.management.apis.EventType;
import org.usd232.robotics.management.apis.User;
import org.usd232.robotics.management.server.database.Database;
import org.usd232.robotics.management.server.routing.GetApi;
import org.usd232.robotics.management.server.session.RequirePermissions;

/**
 * Apis relating to user management
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class UserApis
{
    /**
     * Gets a list of users who are registered on the server
     * 
     * @return The list of users
     * @since 1.0
     * @throws SQLException
     *             If an error occurs while connecting to the database
     */
    @GetApi("/users")
    @RequirePermissions("user.view")
    public static User[] getUsers() throws SQLException
    {
        List<User> users = new ArrayList<User>();
        try (Statement st = Database.createStatement())
        {
            try (ResultSet res = st.executeQuery("SELECT `id`, `name`, `verified` FROM `users`"))
            {
                while (res.next())
                {
                    users.add(new User(res.getInt(1), res.getString(2), null, res.getBoolean(3), 0, 0));
                }
            }
        }
        try (PreparedStatement st = Database.prepareStatement(
                        "SELECT COUNT(`events`.`id`) FROM `events` LEFT JOIN `attendance` ON `attendance`.`eventid` = `events`.`id` AND `attendance`.`userid` = ? WHERE `events`.`date` < NOW() AND `attendance`.`signin` IS NULL AND (`attendance`.`excused` IS NULL OR `attendance`.`excused` != 1)"))
        {
            for (User user : users)
            {
                st.setInt(1, user.id);
                try (ResultSet res = st.executeQuery())
                {
                    res.next();
                    user.unexcused = res.getInt(1);
                }
            }
        }
        try (PreparedStatement st = Database.prepareStatement(
                        "SELECT COUNT(`events`.`id`) FROM `events` INNER JOIN `attendance` ON `attendance`.`eventid` = `events`.`id` AND `attendance`.`userid` = ? WHERE `events`.`date` < NOW() AND `attendance`.`signin` IS NOT NULL AND TIME(`attendance`.`signin`) > `events`.`start`"))
        {
            for (User user : users)
            {
                st.setInt(1, user.id);
                try (ResultSet res = st.executeQuery())
                {
                    res.next();
                    user.late = res.getInt(1);
                }
            }
        }
        return users.toArray(new User[0]);
    }

    /**
     * Gets the attendance records for a user
     * 
     * @param url
     *            The request url
     * @return The list of events
     * @since 1.0
     * @throws SQLException
     *             If an error occurs while connecting to the database
     */
    @GetApi("/attendance/*")
    @RequirePermissions("attendance.view")
    public static Event[] getUserAttendance(String url) throws SQLException
    {
        int userId = Integer.parseInt(url.substring(12, url.length() - 5));
        try (PreparedStatement st = Database.prepareStatement(
                        "SELECT `events`.`id`, `events`.`type`, `events`.`name`, `events`.`location`, `events`.`date`, `events`.`signup`, `attendance`.`rsvp`,  IF(`events`.`date` < NOW(), `attendance`.`signin` IS NOT NULL, -1) FROM `events` LEFT JOIN `attendance` ON `events`.`id` = `attendance`.`eventid` AND `attendance`.`userid` = ?"))
        {
            st.setInt(1, userId);
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
}
