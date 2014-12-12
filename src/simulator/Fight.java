package simulator;

import background.entities.Character;

import java.util.ArrayList;

/**
 * The main interface for controlling "fights" between entities.
 *
 * Created by Junnie on 12/10/2014.
 */
public class Fight {
    private Character[] controlled;
    private Character[] computer;
    private boolean turn;


    /** Getters & Setters **/

    public Character[] getControlled() {
        return controlled;
    }

    public void setControlled(Character[] controlled) {
        this.controlled = controlled;
    }

    public Character[] getComputer() {
        return computer;
    }

    public void setComputer(Character[] computer) {
        this.computer = computer;
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

    // Constructor

    public Fight(Character[] newControlled, Character[] newComputers) {
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
        return;
    }

    /**
     * Prints the Fight Options in a fight
     */
    public void printFightMenu() {
        System.out.printf("Fight:\nMelee\tMagic\n");
        return;
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

        return;
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

        return;
    }

    /**
     * A method that calculated whether or not a Fight's combatants on either side is wholly
     * defeated.
     *
     * @return      -1 if Player loses, 1 if Computer is defeated, 0 otherwise.
     */
    public int isFightOver() {
        boolean computerDefeated = false;
        int i = 0;

        /*
        Loops through the Player's team and increments per Character defeated
         */
        for(Character c : controlled) {
            if(c.getStats().gethP() == 0) {
                i++;
            }
        }

        /*
        Returns -1 if all Player's Characters are defeated
         */
        if (i == controlled.length) {
            return -1;
        }

        // Resets the defeated counter
        i = 0;

        /*
        Loops through the Computer's team and increments per Character defeated
         */
        for(Character c : computer) {
            if(c.getStats().gethP() == 0) {
                i++;
            }
        }

        /*
        Returns 1 if all Computer's Characters are defeated
         */
        if (i == computer.length) {
            return 1;
        }

        /*
        Returns 0 if not all of one team is defeated
         */
        return 0;
    }
}
