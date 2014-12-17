package simulator;

import background.actions.Action;
import background.actions.MagicAction;
import background.entities.Character;

import java.util.ArrayList;

/**
 * The main interface for controlling "fights" between entities.
 *
 * Created by Junnie on 12/10/2014.
 */
public class Fight {
    private ArrayList<Character> controlled;
    private ArrayList<Character> computer;
    private ArrayList<Character> targets;
    private Character self;
    private boolean turn;
    private int defeatedControlled = 0;
    private int defeatedComputer = 0;


    /** Getters & Setters **/

    public ArrayList<Character> getControlled() {
        return controlled;
    }

    public void setControlled(ArrayList<Character> controlled) {
        this.controlled = controlled;
    }

    public ArrayList<Character> getComputer() {
        return computer;
    }

    public void setComputer(ArrayList<Character> computer) {
        this.computer = computer;
    }

    public ArrayList<Character> getTargets() {
        return targets;
    }

    public void setTargets(ArrayList<Character> targets) {
        this.targets = targets;
    }

    public void addTarget(Character c) {
        targets.add(c);
    }

    public Character getSelf() {
        return self;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void switchTurn() {
        turn = !turn;
    }

    public int getDefeatedControlled() {
        return defeatedControlled;
    }

    public int getDefeatedComputer() {
        return defeatedComputer;
    }

    // Constructor

    public Fight(ArrayList<Character> newControlled, ArrayList<Character> newComputers) {
        controlled = newControlled;
        computer = newComputers;
        turn = false;
    }

    // Menu Methods

    /**
     * This method returns a String array populated with the names of possible Melee Options
     *
     * @param c     The Character from which to generate melee options
     * @return      A String populated array representing melee options
     */
    public ArrayList<String> generateMeleeOptions(Character c) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < c.getMeleeActions().size(); i++) {
            list.add(c.getMeleeActions().get(i).getName().toString());
        }

        return list;
    }

    /**
     * This method returns a String array populated with the names of possible Magic Options
     *
     * @param c     The Character from which to generate magic options
     * @return      A String populated array representing magic options
     */
    public ArrayList<String> generateMagicOptions(Character c) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < c.getMagicActions().size(); i++) {
            list.add(c.getMagicActions().get(i).getName().toString());
        }

        return list;
    }

    /**
     * Prints the default battle menu
     */
    public void printBattleMenu() {
        System.out.printf("Choose an option:\nFight\tItems\tEvade\tRun\n");
    }

    /**
     * Prints the Fight Options in a fight
     */
    public void printFightMenu() {
        System.out.printf("Fight:\nMelee\tMagic\n");
    }

    /**
     * Prints the Melee Options available to a Character
     *
     * @param c     Character's Melee Options to print
     */
    public void printMeleeMenu(Character c) {
        int i = 0;

        for(String s : generateMeleeOptions(c)) {
            if(i % 3 == 0) {
                System.out.printf("\n");
                i = 0;
            }
            System.out.printf("%s\t", s);
            i++;
        }
    }

    /**
     * Prints the Magic Options available to a Character
     *
     * @param c     Character's Magic Options to print
     */
    public void printMagicMenu(Character c) {
        int i = 0;

        for(String s : generateMagicOptions(c)) {
            if(i % 3 == 0) {
                System.out.printf("\n");
                i = 0;
            }
            System.out.printf("%s\t", s);
            i++;
        }
    }

    /**
     * A method that calculates whether or not either party is completely dead.
     *
     * @return      -1 if Player loses, 1 if Computer is defeated, 0 otherwise.
     */
    public int isFightOver() {

        for (Character c : controlled) {
            if (c.getStats().gethP() == 0) {
                defeatedControlled++;
            }
        }

        if (defeatedControlled == controlled.size()) {
            return -1;
        }

        for (Character c : computer) {
            if (c.getStats().gethP() == 0) {
                defeatedComputer++;
            }
        }

        if (defeatedComputer == computer.size()) {
            return 1;
        }

        defeatedControlled = 0;
        defeatedComputer = 0;

        return 0;
    }

    public void processFightAction(Action a) {
        if (a instanceof MagicAction) {
            updateEnergy(self, (MagicAction) a);
        }

        for (Character c : targets) {
            updateHP(c, a);

            if (c.getStats().gethP() <= 0) {
                System.out.printf("%s has fallen!!\n", c.getName());
            }

            //@TODO: Implement Status Infliction
        }
    }

    public void updateHP(Character c, Action a) {
        c.getStats().sethP(c.getStats().gethP() - a.getDamage());
    }

    public void updateEnergy(Character c, MagicAction magicAction) {
        c.getStats().setEnergy(c.getStats().getEnergy() - magicAction.getCost());
    }
}
