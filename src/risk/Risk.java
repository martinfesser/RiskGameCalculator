package risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author fessermn
 *
 */
public class Risk {
    /**
     * @param args
     *            arguments
     */
    public static void main(String[] args) {
        new Risk().calculateDistribution();
    }

    private void calculateDistribution() {
        HashMap<DicePair, AttackerDistributionEntry> distribution = new HashMap<>();
        Collection<Integer> allDiceValues = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (Integer diceOne : allDiceValues) {
            for (Integer diceTwo : allDiceValues) {
                for (Integer diceThree : allDiceValues) {
                    DiceTriple diceTriple = new DiceTriple(diceOne, diceTwo, diceThree);
                    DicePair bestTwo = diceTriple.bestTwo();
                    AttackerDistributionEntry distributionEntry = distribution.get(bestTwo);
                    if (distributionEntry == null) {
                        distributionEntry = new AttackerDistributionEntry();
                        distribution.put(bestTwo, distributionEntry);
                    }
                    distributionEntry.addTriple(diceTriple);
                }
            }
        }

        ArrayList<AttackerDistributionEntry> values = new ArrayList<>(distribution.values());

        Collections.sort(values, new Comparator<AttackerDistributionEntry>() {

            @Override
            public int compare(AttackerDistributionEntry o1, AttackerDistributionEntry o2) {
                int result = o1.getOccurences() - o2.getOccurences();
                if (result == 0) {
                    result = o1.getUsedPair().getDiceOne() - o2.getUsedPair().getDiceOne();
                }
                if (result == 0) {
                    result = o1.getUsedPair().getDiceTwo() - o2.getUsedPair().getDiceTwo();
                }
                return result;
            }
        });

        double overallResult = 0;
        System.out.println("dice one, dice two, probability, occurences, defend with two, defend with one, " + //
                "best defend with one?, best defend, overall influence");
        for (AttackerDistributionEntry entry : values) {
            double defendOne = entry.getUsedPair().resultDefendOne();
            double defendTwo = entry.getUsedPair().resultDefendTwo();
            double bestDef = 0;
            boolean doDefendWithOne = false;
            if (defendOne < defendTwo) {
                bestDef = defendOne;
                doDefendWithOne = true;
            } else {
                bestDef = defendTwo;
            }
            double overallInfluence = entry.probability() * bestDef;
            overallResult = overallResult + overallInfluence;
            System.out.println(entry + ", " + defendTwo + ", " + defendOne + ", " + doDefendWithOne + ", " + bestDef
                    + ", " + overallInfluence);
        }
        System.out.println("Overall: " + overallResult);
    }
}
