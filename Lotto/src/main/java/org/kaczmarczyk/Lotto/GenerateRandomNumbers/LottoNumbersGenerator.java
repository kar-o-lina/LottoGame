package org.kaczmarczyk.Lotto.GenerateRandomNumbers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumbersGenerator implements RandomNumbersGenerator {

    @Override
    public Set<Integer> generateRandomNumbers(int numbersToGenerate, int lowerBoundInclusive, int upperBoundInclusive) {
        final Set<Integer> generatedNumbers = new HashSet<>();

        while (generatedNumbers.size() < numbersToGenerate) {
            generatedNumbers.add(getRandomNumber(lowerBoundInclusive, upperBoundInclusive));
        }
        printGeneratedNumbers(generatedNumbers);
        return generatedNumbers;
    }

    private int getRandomNumber(int lowerBoundInclusive, int upperBoundInclusive) {
        Random random = new Random();
        return random.nextInt(lowerBoundInclusive, upperBoundInclusive);
    }

    private void printGeneratedNumbers(Set<Integer> numbers) {
        System.out.println("\nGenerating numbers.\n" +
                "\nGenerated numbers are:\n" +
                numbers);
    }
}
