package background.entities;

import background.actions.MeleeAction;
import background.actions.MagicAction;
import background.status.Stats;

import java.util.ArrayList;
import java.util.Random;

/**
 * The template for all entities that are able to interact in the world. Manipulates Stats
 *
 * Created by Junnie on 12/10/2014.
 */
public abstract class Character {
    private CharacterType type;
    private String name;
    private Stats stats;
    private ArrayList<MeleeAction> meleeActions;
    private ArrayList<MagicAction> magicActions;

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public ArrayList<MeleeAction> getMeleeActions() {
        return meleeActions;
    }

    public void setMeleeActions(ArrayList<MeleeAction> meleeActions) {
        this.meleeActions = meleeActions;
    }

    public void addMeleeAction(MeleeAction meleeAction) {
        this.meleeActions.add(meleeAction);
    }

    public ArrayList<MagicAction> getMagicActions() {
        return magicActions;
    }

    public void setMagicActions(ArrayList<MagicAction> magicActions) {
        this.magicActions = magicActions;
    }

    public void addMagicAction(MagicAction magicAction) { this.magicActions.add(magicAction); }

    /** Stat Calculator **/
    public Stats initBaseStats(double initStrength, double initIntel, double initAgility, double initLuck) {
        Stats newStats = new Stats();

        newStats.setLevel(1);

        newStats.setStrength(initStrength);
        newStats.setIntel(initIntel);
        newStats.setAgility(initAgility);

        newStats.setLuck(initLuck);

        newStats.sethP(initStrength * 2.5);
        newStats.setEnergy(initIntel * 2.0);

        return newStats;
    }

    /** Initializer **/
    public Stats genBaseRandomStats() {

        Random rand = new Random();
        double randStr = (double) rand.nextInt(((15 - 5) + 1) + 5);
        double randInt = (double) rand.nextInt(((15 - 5) + 1) + 5);
        double randAgi = (double) rand.nextInt(((15 - 5) + 1) + 5);
        double randLuck = (double) rand.nextInt(((5 - 1) + 1) + 1);

        return initBaseStats(randStr, randInt, randAgi, randLuck);
    }

    public Stats genBaseOgreStats() {
        return initBaseStats(25.0, 5.0, 5.0, 3.0);
    }

    public Stats genBaseHumanStats() {
        return initBaseStats(5.0, 25.0, 5.0, 3.0);
    }

    public Stats genBaseElfStats() {
        return initBaseStats(5.0, 5.0, 25.0, 3.0);
    }
}
