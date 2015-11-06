package background.map;

import background.Trigger;

import java.util.List;
import java.util.Map;

/**
 * A class that encapsulates a Location in the game.
 *
 * Created by Junnie on 11/6/2015.
 */
public class Location {

    // Names are unique.
    private String name;

    // Keys are cardinal values, values are unique names of other Locations
    private Map<String, String> connections;

    // Every entry of 'perception' is another, deeper level of prose. Must be
    // ordered because each successive level has to be 'unlocked' by a
    // greater or equal 'perception skill level'.
    // @TODO: consider making a Perception class (can apply to others)
    private List<String> perceptions;

    private List<Trigger> triggers;
}
