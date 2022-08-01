package pl.juniorJavaReady.LottoProject;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    // TODO: 30.07.2022 should be injected in constructor, this way its not testable
    private final Random random = new Random();
    // TODO: 30.07.2022 should be a part of a method, if it is here object is not reusable
    private final Set<Integer> generatedNumbers;

    public RandomNumbersGenerator() {
        this.generatedNumbers = new HashSet<>();
    }

    // TODO: 30.07.2022 without checking the implementation idk how many numbers will be generated and in what range. its also not extendable: what if i wanted to generate 3 numbers? or 20? what if i wanted a different range of numbers?
    public Set<Integer> generateRandomNumbers() {
        while (generatedNumbers.size() < LottoGameSettings.NUMBERS_TO_GENERATE_AND_GUESS) {
            generatedNumbers.add(getRandomNumber());
        }
        printGeneratedNumbers();
        return generatedNumbers;
    }

    private int getRandomNumber() {
        // TODO: 30.07.2022 this will generate you numbers from 1 to 98, but based on messages i guess it should be up to 99
        return random.nextInt(LottoGameSettings.LOWER_BOUND, LottoGameSettings.UPPER_BOUND);
    }

    private void printGeneratedNumbers() {
        // TODO: 30.07.2022 Generated numbers are:
        System.out.println("\nGenerating numbers.\n" +
                "\nNumbers generated are:\n" +
                generatedNumbers);
    }
}
