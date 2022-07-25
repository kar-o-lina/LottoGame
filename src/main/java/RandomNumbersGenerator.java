import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    private final Random random = new Random();
    private final Set<Integer> generatedNumbers;

    public RandomNumbersGenerator() {
        this.generatedNumbers = new HashSet<>();
    }

    public Set<Integer> generateRandomNumbers() {
        while (generatedNumbers.size() < LottoGameSettings.NUMBERS_TO_GENERATE) {
            generatedNumbers.add(getRandomNumber());
        }
        printGeneratedNumbers();
        return generatedNumbers;
    }

    private int getRandomNumber() {
        return random.nextInt(LottoGameSettings.LOWER_BOUND, LottoGameSettings.UPPER_BOUND);
    }

    private void printGeneratedNumbers() {
        System.out.println("\nGenerating numbers.\n" +
                "\nNumbers generated are:\n" +
                generatedNumbers);
    }
}
