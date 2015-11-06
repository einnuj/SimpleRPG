package background.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Meant to be a Singleton class to handle the Locations. May be integrated
 * or completely replaced by JAXB.
 *
 * Created by Junnie on 10/8/2015.
 */
public class MapManager {
    private static MapManager ourInstance = new MapManager();

    public static MapManager getInstance() {
        return ourInstance;
    }

    private Map<String, Object> map;

    private MapManager() {
        map = new HashMap<>(0);
    }


}
