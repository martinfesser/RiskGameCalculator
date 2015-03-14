package risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * ordered
 *
 * @author fessermn
 *
 */
public class DicePair {
    private int diceOne;
    private int diceTwo;

    private static final Collection<Integer> ALL_DICE_VALUES = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final Collection<DicePair> ALL_TWO;

    static {
        ALL_TWO = new ArrayList<>();

        for (Integer diceOne : DicePair.ALL_DICE_VALUES) {
            for (Integer diceTwo : DicePair.ALL_DICE_VALUES) {
                DicePair.ALL_TWO.add(new DicePair(diceOne, diceTwo));
            }
        }
    }

    /**
     * @param one
     *            dice value
     * @param two
     *            dice value
     */
    public DicePair(int one, int two) {
        if (one > two) {
            this.diceOne = one;
            this.diceTwo = two;
        } else {
            this.diceOne = two;
            this.diceTwo = one;
        }
    }

    /**
     * this is the attacker
     *
     * @return average loss
     */
    public double resultDefendTwo() {
        double result = 0;
        for (DicePair pair : DicePair.ALL_TWO) {
            result = result + this.fight(pair);
        }
        return result / 36;
    }

    /**
     * this is the attacker
     *
     * @return average loss
     */
    public double resultDefendOne() {
        double result = 0;
        for (Integer defenderDice : DicePair.ALL_DICE_VALUES) {
            int fight = this.fight(defenderDice);
            result = result + fight;
        }
        return result / 6;
    }

    /**
     * @param defenderPair
     *            defender pair
     * @return 0: each lose one, 2 attacker wins 2, -2 attacker loses 2
     */
    public int fight(DicePair defenderPair) {
        return this.fight(this.diceOne, defenderPair.diceOne) + this.fight(this.diceTwo, defenderPair.diceTwo);
    }

    /**
     * @param defender
     *            dice
     * @return 1 attacker wins, -1 attacker loses
     */
    public int fight(int defender) {
        return this.fight(this.diceOne, defender);
    }

    /**
     * @param attacker
     *            dice
     * @param defender
     *            dice
     * @return 1 attacker wins, -1 attacker loses
     */
    private int fight(int attacker, int defender) {
        if (attacker > defender) {
            return 1;
        }
        return -1;
    }

    /**
     * @return the diceOne
     */
    public int getDiceOne() {
        return this.diceOne;
    }

    /**
     * @return the diceTwo
     */
    public int getDiceTwo() {
        return this.diceTwo;
    }

    @Override
    public String toString() {
        return "(" + this.diceOne + ", " + this.diceTwo + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + this.diceOne;
        result = (prime * result) + this.diceTwo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        DicePair other = (DicePair) obj;
        if (this.diceOne != other.diceOne) {
            return false;
        }
        if (this.diceTwo != other.diceTwo) {
            return false;
        }
        return true;
    }

}
