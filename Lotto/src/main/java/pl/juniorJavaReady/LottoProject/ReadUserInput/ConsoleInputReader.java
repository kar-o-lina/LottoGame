package pl.juniorJavaReady.LottoProject.ReadUserInput;

import pl.juniorJavaReady.LottoProject.Configuration.LottoGameSettings;
import pl.juniorJavaReady.LottoProject.Configuration.LottoMessages;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInputReader implements InputReader {

    @Override
    public Set<Integer> acquireUserInput(Scanner scanner) {
        Set<Integer> userGuesses = new HashSet<>();
        System.out.println(LottoMessages.GAME_STARTING_MESSAGE);

        while (userGuesses.size() < LottoGameSettings.NUMBERS_FOR_LOTTO_GAME) {
            String userInput = scanner.next();

            if(validateUserInput(userInput)) {
                userGuesses.add(Integer.valueOf(userInput));
            }
        }
        return userGuesses;
    }

    public boolean validateUserInput(String userInput) {
        if(!isInputNumber(userInput)) {
            informUserInputIsNotNumber();
            return false;
        }
        if (!isInBounds(userInput)) {
            informUserInputOutOfBounds();
            return false;
        }
        return true;
    }

    private boolean isInputNumber(String userInput) {
        return userInput.matches("[0-9]+");
    }

   private void informUserInputIsNotNumber() {
        System.out.println(LottoMessages.INPUT_IS_NOT_NUMBER);
    }

    private boolean isInBounds(String guess) {
        final int number = Integer.valueOf(guess);
        return number < 100 && number > 0;
    }

   private void informUserInputOutOfBounds() {
        System.out.println(LottoMessages.INPUT_IS_OUT_OF_BOUNDS);
    }
}
