package org.karolinakaczmarczyk.lotto.application;

import org.karolinakaczmarczyk.lotto.checkoutcome.LottoOutcomeVerifier;
import org.karolinakaczmarczyk.lotto.generatenumbers.RandomNumbersGenerator;
import org.karolinakaczmarczyk.lotto.readinput.InputReader;

import static org.karolinakaczmarczyk.lotto.configuration.LottoSettings.*;

import java.util.Set;

public class LottoGame {

    private final InputReader userInputReader;
    private final RandomNumbersGenerator randomNumbersGenerator;
    private final LottoOutcomeVerifier gameOutcomeVerifier;

    public LottoGame(InputReader reader, RandomNumbersGenerator generator, LottoOutcomeVerifier verifier) {
        this.userInputReader = reader;
        this.randomNumbersGenerator = generator;
        this.gameOutcomeVerifier = verifier;
    }

    public void play() {
        Set<Integer> userGuesses = userInputReader.readInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND);
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

