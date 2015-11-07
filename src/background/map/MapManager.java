package background.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Meant to be a Singleton class to handle the Locations. May be integrated
 * or completely replaced by JAXB.
 *
 * Created by Junnie on 10/8/2015.
 */
public enum MapManager {
    INSTANCE;

    private MapManager() {}

    public void init() {}
}
