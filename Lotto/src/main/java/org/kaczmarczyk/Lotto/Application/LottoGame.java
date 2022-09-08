package org.kaczmarczyk.Lotto.Application;

import org.kaczmarczyk.Lotto.CheckGameOutcome.LottoOutcomeVerifier;
import org.kaczmarczyk.Lotto.GenerateRandomNumbers.LottoNumbersGenerator;
import org.kaczmarczyk.Lotto.ReadUserInput.ConsoleInputReader;

import static org.kaczmarczyk.Lotto.Configuration.LottoGameSettings.*;

import java.util.Scanner;
import java.util.Set;

public class LottoGame {

    private final ConsoleInputReader userInputReader;
    private final LottoNumbersGenerator randomNumbersGenerator;
    private final LottoOutcomeVerifier gameOutcomeVerifier;

    public LottoGame() {
        this(new ConsoleInputReader(new Scanner(System.in)));
    }

    public LottoGame(ConsoleInputReader reader) {
        this(reader, new LottoNumbersGenerator());
    }

    public LottoGame(ConsoleInputReader reader, LottoNumbersGenerator generator) {
        this(reader, generator, new LottoOutcomeVerifier());
    }

    public LottoGame(ConsoleInputReader reader, LottoNumbersGenerator generator, LottoOutcomeVerifier verifier) {
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

