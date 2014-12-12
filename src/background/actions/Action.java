package background.actions;

import background.status.Effect;

import java.util.ArrayList;

/**
 * An abstract class that acts as the template for all Actions in a fight.
 *
 * Created by Junnie on 12/10/2014.
 */
public abstract class Action {
    private Effect effect;

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }


    /**
     * This method, when invoked, will initiate the "Action" towards a target.
     *
     * @param chars         A list of characters that the action may target.
     */
    public abstract void activate(ArrayList<Character> chars);
}
