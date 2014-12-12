package background.actions;

import background.status.Effect;

/**
 * A class represent the possible Actions in Magic are possible for characters
 *
 * Created by Junnie on 12/10/2014.
 */
public abstract class MagicAction extends Action{
    private MagicName name;
    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public MagicName getName() {
        return name;
    }

    public void setName(MagicName name) {
        this.name = name;
    }
}
