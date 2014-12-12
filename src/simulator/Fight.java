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

    public ArrayList<String> generateMeleeOptions(Character c) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < c.getMeleeActions().size(); i++) {
            list.add(c.getMeleeActions().get(i).getName().toString());
        }

        return list;
    }

    public ArrayList<String> generateMagicOptions(Character c) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < c.getMagicActions().size(); i++) {
            list.add(c.getMagicActions().get(i).getName().toString());
        }

        return list;
    }
}
