package background;

/**
 * This class represents an event that will occur upon a certain event.
 *
 * Created by Junnie on 11/6/2015.
 */
public abstract class Trigger {

    // @TODO: this should be an enum with an outer selector
    private String type;

    // Essentially just a counter. Is this all that's necessary?
    private int action_potential;

    // A description of what happens
    private String prose;

    /**
     * Defines the reaction once this class has been 'triggered'
     */
    public abstract void reaction();
}
