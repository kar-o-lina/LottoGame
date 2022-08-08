package pl.juniorJavaReady.LottoProject.GenerateRandomNumbers;

import pl.juniorJavaReady.LottoProject.Configuration.LottoGameSettings;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumbersGenerator implements RandomNumbersGenerator {
    private final Random random;

    public LottoNumbersGenerator(Random random) {
        this.random = random;
    }

    // TODO: 30.07.2022 without checking the implementation idk how many numbers will be generated and in what range. its also not extendable: what if i wanted to generate 3 numbers? or 20? what if i wanted a different range of numbers?
    // Answer: added an interface, so method's implementation could differ in another type of game;
    // as to extention possibilities, why is changing value of numbers_for_lotto_game a bad thing?
    // i'm guessing there's s'where a better solution? s'thing like generics?
    @Override
    public Set<Integer> generateRandomNumbers() {
        final Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < LottoGameSettings.NUMBERS_FOR_LOTTO_GAME) {
            generatedNumbers.add(getRandomNumber());
        }
        printGeneratedNumbers(generatedNumbers);
        return generatedNumbers;
    }

    private int getRandomNumber() {
        return random.nextInt(LottoGameSettings.LOWER_BOUND, LottoGameSettings.UPPER_BOUND + 1);
    }

    private void printGeneratedNumbers(Set<Integer> numbers) {
        // TODO: 30.07.2022 Generated numbers are:
        // Answer: I like the suspense ;)
        System.out.println("\nGenerating numbers.\n" +
                "\nGenerated numbers are:\n" +
                numbers);
    }
}
