package org.karolinakaczmarczyk.lotto.input;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.karolinakaczmarczyk.lotto.config.LottoMessages.GAME_STARTING_MESSAGE;
import static org.karolinakaczmarczyk.lotto.config.LottoMessages.INPUT_IS_OUT_OF_BOUNDS_MESSAGE;
import static org.karolinakaczmarczyk.lotto.config.LottoMessages.INPUT_IS_NOT_NUMBER_MESSAGE;
import static org.karolinakaczmarczyk.lotto.config.LottoSettings.NUMBERS_FOR_LOTTO_GAME;

public class ConsoleInputReader implements InputReader {

    private final Scanner scanner;

    public ConsoleInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Set<Integer> readInput() {
        Set<Integer> userGuesses = new HashSet<>();
        System.out.println(GAME_STARTING_MESSAGE);

        while (userGuesses.size() < NUMBERS_FOR_LOTTO_GAME) {
            String userInput = scanner.next();

            if (validateUserInput(userInput)) {
                userGuesses.add(Integer.valueOf(userInput));
            }
        }
        return userGuesses;
    }

    private boolean validateUserInput(String userInput) {
        if (!isNumber(userInput)) {
            System.out.println(INPUT_IS_NOT_NUMBER_MESSAGE);
            return false;
        }
        if (!isInBounds(userInput)) {
            System.out.println(INPUT_IS_OUT_OF_BOUNDS_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isInBounds(String guess) {
        final int number = Integer.valueOf(guess);
        return number < 100 && number > 0;
    }

    private boolean isNumber(String userInput) {
        return userInput.matches("[0-9]+");
    }
}