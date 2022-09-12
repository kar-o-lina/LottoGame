package org.karolinakaczmarczyk.lotto.application;

import org.karolinakaczmarczyk.lotto.outcome.LottoOutcomeVerifier;
import org.karolinakaczmarczyk.lotto.generator.LottoNumbersGenerator;
import org.karolinakaczmarczyk.lotto.input.ConsoleInputReader;

import java.util.Random;
import java.util.Set;

public class LottoGame implements Game {

    // TODO: 30.07.2022 should be an interface here (as in previous comment), also programming to interfaces
    //like Game interface..?
    private final ConsoleInputReader userInputReader;
    private final LottoNumbersGenerator randomNumbersGenerator;
    private final LottoOutcomeVerifier gameOutcomeVerifier;

    public LottoGame() {
        this(new ConsoleInputReader());
    }

    public LottoGame(ConsoleInputReader reader) {
        this(reader, new LottoNumbersGenerator(new Random()));
    }

    public LottoGame(ConsoleInputReader reader, LottoNumbersGenerator generator) {
        this(reader, generator, new LottoOutcomeVerifier());
    }
    public LottoGame(ConsoleInputReader reader, LottoNumbersGenerator generator, LottoOutcomeVerifier verifier) {
        this.userInputReader = reader;
        this.randomNumbersGenerator = generator;
        this.gameOutcomeVerifier = verifier;
    }

    @Override
    public void play() {
        Set<Integer> userGuesses = userInputReader.acquireUserInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

