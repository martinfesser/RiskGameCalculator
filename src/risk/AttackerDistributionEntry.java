package risk;

import java.math.BigDecimal;
import java.util.Collection;

public class AttackerDistributionEntry {
    private int occurences;// of 6*6*6 = 216
    private BigDecimal probability;
    private int usedDiceOne;
    private int usedDiceTwo;
    private Collection<DiceCollection> dice;

    @Override
    public String toString() {
        return "(" + this.usedDiceOne + ", " + this.usedDiceTwo + ": "
                + this.probability + " " + this.occurences + ")";
    }

    /**
     * @return pretty form with all origin combinations
     */
    public String prettyPrint() {
        return this.dice.toString();
    }
}
