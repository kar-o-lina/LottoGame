package org.karolinakaczmarczyk.lotto.readinput;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.GAME_STARTING_MESSAGE;
import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.INPUT_IS_OUT_OF_BOUNDS_MESSAGE;
import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.INPUT_IS_NOT_NUMBER_MESSAGE;
import static org.karolinakaczmarczyk.lotto.configuration.LottoSettings.NUMBERS_FOR_LOTTO_GAME;

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
            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();
                if (validateUserInput(userInput)) {
                    userGuesses.add(userInput);
                }
            } else {
                scanner.next();
                System.out.println(INPUT_IS_NOT_NUMBER_MESSAGE);
            }
        }
        scanner.close();
        return userGuesses;
    }

    private boolean validateUserInput(int userInput) {
        if (!isInBounds(userInput)) {
            System.out.println(INPUT_IS_OUT_OF_BOUNDS_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isInBounds(int guess) {
        return guess < 100 && guess > 0;
    }
}
