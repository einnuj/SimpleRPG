package background.actions;

import background.status.Effect;

/**
 * An abstract class that details the melee aspect of fights.
 *
 * Created by Junnie on 12/10/2014.
 */
public abstract class MeleeAction extends Action{
    private double multiplier;
    private MeleeName name;

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public MeleeName getName() {
        return name;
    }

    public void setName(MeleeName name) {
        this.name = name;
    }
}