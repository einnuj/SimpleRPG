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
    private TargetType targetType;
    private double damage;

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
