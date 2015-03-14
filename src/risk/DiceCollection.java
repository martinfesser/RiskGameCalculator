package risk;

import java.util.ArrayList;

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
        final StringBuilder sb = new StringBuilder("(");
        for (final Integer i : this) {
            sb.append(i + " ");
        }
        sb.append(")");
        return sb.toString();
    }
}
