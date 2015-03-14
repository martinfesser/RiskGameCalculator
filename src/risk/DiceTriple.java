package risk;

/**
 * unordered dices
 *
 * @author fessermn
 *
 */
public class DiceTriple {
    private int diceOne;
    private int diceTwo;
    private int diceThree;

    /**
     * @param one
     *            dice value
     * @param two
     *            dice value
     * @param three
     *            dice value
     */
    public DiceTriple(int one, int two, int three) {
        this.diceOne = one;
        this.diceTwo = two;
        this.diceThree = three;
    }

    public DicePair bestTwo() {
        if ((this.diceOne <= this.diceTwo) && (this.diceOne <= this.diceThree)) {
            return new DicePair(this.diceTwo, this.diceThree);
        } else if ((this.diceTwo <= this.diceOne)
                && (this.diceTwo <= this.diceThree)) {
            return new DicePair(this.diceOne, this.diceThree);
        } else {
            return new DicePair(this.diceOne, this.diceTwo);
        }
    }

    @Override
    public String toString() {
        return "(" + this.diceOne + ", " + this.diceTwo + ", " + this.diceThree
                + ")";
    }
}
