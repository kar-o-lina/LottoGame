package pl.juniorJavaReady.LottoProject;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// TODO: 30.07.2022 no packages
// TODO: 30.07.2022 add interface eg InputReader, the first implementation would be ie ConsoleInputReader
public class UserInputReader {

    // TODO: 30.07.2022 should be a part of a method, if it is here object is not reusable
    private final Set<Integer> userGuesses;

    // TODO: 30.07.2022 should be initialized in constructor, taken as a param. this way its not testable at all, you cant mock scanner to implement unit tests
    Scanner scanner = new Scanner(System.in);

    public UserInputReader() {
        this.userGuesses = new HashSet<>();
    }

    // TODO: 30.07.2022 in general naming methods like getXXX is a code smell, because it suggests its just a getter
    public Set<Integer> getUserInput() {

        System.out.println(MessageProvider.PROMPT);
        int userInput = -1; // TODO: 30.07.2022 can be just inside of a loop without this strange initialization

        while (userGuesses.size() < LottoGameSettings.NUMBERS_TO_GENERATE_AND_GUESS) {
            if (isInputNumber()) {
                userInput = scanner.nextInt();
            }
            addInputToGuesses(userInput);
        }
        return userGuesses;
    }

    // TODO: 30.07.2022 name doesnt reflect what the method is doing
    private void addInputToGuesses(int userInput) {
        if (!isNumberInBounds(userInput)) {
            System.out.println(MessageProvider.OUT_OF_BOUNDS);
        } else {
            userGuesses.add(userInput);
        }
    }

    // TODO: 30.07.2022 this method name is misleading: from a method named like this i would expect it to only perform input validation, but reading input is also here
    private boolean isInputNumber() {
        // TODO: 30.07.2022 formatting
        if(!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(MessageProvider.NOT_NUMBER);
            return false;
        }
        return true;
    }

    // TODO: 30.07.2022 just isInBounds or isInRange
    private boolean isNumberInBounds(int guess) {
        return guess < 100 && guess > 0;
    }
}
