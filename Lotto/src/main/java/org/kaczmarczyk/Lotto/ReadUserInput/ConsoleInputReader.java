package org.kaczmarczyk.Lotto.ReadUserInput;

import org.kaczmarczyk.Lotto.Configuration.LottoGameSettings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.kaczmarczyk.Lotto.Configuration.LottoMessages.*;

public class ConsoleInputReader implements InputReader {

    private final Scanner scanner;

    public ConsoleInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public <T> Set<T> readInput() {
        Set<Integer> userGuesses = new HashSet<>();
            printMessage(GAME_STARTING_MESSAGE);

        while (userGuesses.size() < LottoGameSettings.NUMBERS_FOR_LOTTO_GAME) {
            String userInput = scanner.next();

            if (validateUserInput(userInput)) {
                userGuesses.add(Integer.valueOf(userInput));
            }
        }
        return (Set<T>) userGuesses;
    }

    boolean validateUserInput(String userInput) {
        if (!isNumber(userInput)) {
            printMessage(INPUT_IS_NOT_NUMBER_MESSAGE);
            return false;
        }
        if (!isInBounds(userInput)) {
            printMessage(INPUT_IS_OUT_OF_BOUNDS_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isNumber(String userInput) {
        return userInput.matches("[0-9]+");
    }

    private boolean isInBounds(String guess) {
        final int number = Integer.valueOf(guess);
        return number < 100 && number > 0;
    }
}
