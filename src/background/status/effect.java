package background.status;

import background.EffectName;
import background.EffectType;

/**
 * A simple abstract class that details any type of ailments possible in a fight.
 *
 * Created by Junnie on 12/10/2014.
 */
public abstract class Effect {
    private EffectName name;
    private EffectType type;

    /**
     * This method exists to describe what should happen to an entity Character upon successful
     * infliction of said status Effect.
     *
     * @param c     The target to whom the affliction is applied.
     */
    public abstract void inflict(Character c);
}
