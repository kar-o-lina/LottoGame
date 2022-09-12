package org.karolinakaczmarczyk.lotto.application;

import org.karolinakaczmarczyk.lotto.outcome.LottoOutcomeVerifier;
import org.karolinakaczmarczyk.lotto.generator.LottoNumbersGenerator;
import org.karolinakaczmarczyk.lotto.generator.RandomNumbersGenerator;
import org.karolinakaczmarczyk.lotto.input.ConsoleInputReader;
import org.karolinakaczmarczyk.lotto.input.InputReader;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import static org.karolinakaczmarczyk.lotto.config.LottoSettings.*;

public class LottoGame {

    private final InputReader inputReader;
    private final RandomNumbersGenerator randomNumbersGenerator;
    private final LottoOutcomeVerifier gameOutcomeVerifier;

    public LottoGame(InputReader reader, RandomNumbersGenerator generator, LottoOutcomeVerifier verifier) {
        this.inputReader = reader;
        this.randomNumbersGenerator = generator;
        this.gameOutcomeVerifier = verifier;
    }

    public void play() {
        Set<Integer> userGuesses = inputReader.readInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND);
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame(new ConsoleInputReader(new Scanner(System.in)),
                new LottoNumbersGenerator(new Random()),
                new LottoOutcomeVerifier());
        game.play();
    }
}

