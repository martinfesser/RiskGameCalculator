package risk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringJoiner;

public class AttackerDistributionEntry {
    private int occurences;// of 6*6*6 = 216
    private DicePair usedPair = null;
    private Collection<DiceTriple> diceTriples = new ArrayList<>();

    public void addTriple(DiceTriple dices) {
        if ((this.usedPair == null) || this.usedPair.equals(dices.bestTwo())) {
            this.diceTriples.add(dices);
            this.occurences++;
            this.usedPair = dices.bestTwo();
        } else {
            throw new IllegalArgumentException("need to be the same best two");
        }
    }

    @Override
    public String toString() {
        return this.usedPair.getDiceOne() + ", " + this.usedPair.getDiceTwo() + ", " + (100 * this.probability())
                + "%, " + this.occurences;
    }

    /**
     * @return pretty form with all origin combinations
     */
    public String prettyPrint() {
        final StringJoiner sj = new StringJoiner(", ");
        for (DiceTriple element : this.diceTriples) {
            sj.add(element.toString());
        }

        return "{" + sj.toString() + "}";
    }

    /**
     * @return the occurences
     */
    public int getOccurences() {
        return this.occurences;
    }

    /**
     * @return the usedPair
     */
    public DicePair getUsedPair() {
        return this.usedPair;
    }

    public double probability() {
        return this.occurences / 216.0;
    }

}
