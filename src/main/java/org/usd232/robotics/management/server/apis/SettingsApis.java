package org.usd232.robotics.management.server.apis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.usd232.robotics.management.apis.Setting;
import org.usd232.robotics.management.apis.SettingType;
import org.usd232.robotics.management.server.database.Database;
import org.usd232.robotics.management.server.routing.GetApi;
import org.usd232.robotics.management.server.session.RequirePermissions;

/**
 * The apis that relate to settings
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class SettingsApis
{
    /**
     * Gets a list of settings
     * 
     * @return The settings
     * @since 1.0
     * @throws SQLException
     *             If an error occurs while connecting to the database
     */
    @GetApi("/settings")
    @RequirePermissions("settings.view")
    public static Setting[] get() throws SQLException
    {
        try (PreparedStatement st = Database.prepareStatement("SELECT `key`, `type`, `value` FROM `settings`"))
        {
            try (ResultSet res = st.executeQuery())
            {
                List<Setting> settings = new ArrayList<Setting>();
                while (res.next())
                {
                    settings.add(new Setting(res.getString(1), SettingType.valueOf(res.getString(2)),
                                    res.getString(3)));
                }
                return settings.toArray(new Setting[0]);
            }
        }
    }
}
