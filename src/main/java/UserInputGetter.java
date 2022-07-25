import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputGetter {

    private final Set<Integer> userGuesses;
    Scanner scanner = new Scanner(System.in);

    public UserInputGetter() {
        this.userGuesses = new HashSet<>();
    }

    public Set<Integer> getUserInput() {

        System.out.println(MessageProvider.PROMPT);
        int userInput = -1;

        while (userGuesses.size() < LottoGameSettings.NUMBERS_TO_GUESS) {
            if (isInputNumber()) {
                userInput = scanner.nextInt();
            }
            addInputToGuesses(userInput);
        }
        return userGuesses;
    }

    private void addInputToGuesses(int userInput) {
        if (!isNumberInBounds(userInput)) {
            System.out.println(MessageProvider.OUT_OF_BOUNDS);
        } else {
            userGuesses.add(userInput);
        }
    }

    private boolean isInputNumber() {
        if(!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(MessageProvider.NOT_NUMBER);
            return false;
        }
        return true;
    }

    private boolean isNumberInBounds(int guess) {
        return guess < 100 && guess > 0;
    }
}
