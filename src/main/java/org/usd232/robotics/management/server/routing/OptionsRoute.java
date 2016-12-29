package org.usd232.robotics.management.server.routing;

import spark.Request;
import spark.Route;

/**
 * The default route for OPTIONS requests
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
class OptionsRoute extends BaseRoute implements Route
{
    @Override
    protected Object performRequest(Request req) throws Exception
    {
        return null;
    }

    /**
     * Default constructor
     * 
     * @since 1.0
     */
    public OptionsRoute()
    {
        super(null);
    }
}