package risk;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * @author fessermn
 *
 */
public class DiceCollection extends ArrayList<Integer> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ");
        for (final Integer i : this) {
            sj.add(Integer.toString(i));
        }

        return "(" + sj.toString() + ")";
    }
}
