package org.karolinakaczmarczyk.lotto.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumbersGenerator implements RandomNumbersGenerator {

    private final Random random;

    public LottoNumbersGenerator(Random random) {
        this.random = random;
    }

    @Override
    public Set<Integer> generateRandomNumbers(int numbersToGenerate, int lowerBoundInclusive, int upperBoundInclusive) {

        if ((numbersToGenerate > 0) && (lowerBoundInclusive < upperBoundInclusive)) {
            final Set<Integer> generatedNumbers = new HashSet<>();

            while (generatedNumbers.size() < numbersToGenerate) {
                generatedNumbers.add(getRandomNumber(lowerBoundInclusive, upperBoundInclusive));
            }
            printGeneratedNumbers(generatedNumbers);
            return generatedNumbers;
        } else {
            System.out.println("Wrong game settings");
        }
        return null;
    }

    private int getRandomNumber(int lowerBoundInclusive, int upperBoundInclusive) {
        return lowerBoundInclusive + random.nextInt(upperBoundInclusive - lowerBoundInclusive + 1);

    }

    private void printGeneratedNumbers(Set<Integer> numbers) {
        System.out.println("\nGenerating numbers.\n" +
                "\nGenerated numbers are:\n" +
                numbers);
    }
}
