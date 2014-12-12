package background.status;

/**
 * A simple data class that holds all the traits of a character.
 *
 * Created by Junnie on 12/10/2014.
 */
public class Stats {
    public double hP;
    public double energy;
    public int level;
    public double strength;
    public double intel;
    public double agility;
    public double luck;

    // Skeleton Constructor
    public Stats() {
        hP = 0;
        energy = 0;
        level = 1;
        strength = 0;
        intel = 0;
        agility = 0;
        luck = 0;
    }

    /** Getter/Setter **/
    public double gethP() {
        return hP;
    }

    public void sethP(double hP) {
        this.hP = hP;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getIntel() {
        return intel;
    }

    public void setIntel(double intel) {
        this.intel = intel;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }
}
