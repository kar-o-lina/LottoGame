package pl.juniorJavaReady.LottoProject.Application;

import pl.juniorJavaReady.LottoProject.CheckGameOutcome.LottoOutcomeVerifier;
import pl.juniorJavaReady.LottoProject.GenerateRandomNumbers.LottoNumbersGenerator;
import pl.juniorJavaReady.LottoProject.ReadUserInput.ConsoleInputReader;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoGame {

    private final ConsoleInputReader userInputReader;
    private final LottoNumbersGenerator randomNumbersGenerator;
    private final LottoOutcomeVerifier gameOutcomeVerifier;

    public LottoGame() {
        this(new ConsoleInputReader());
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
        Scanner scanner = new Scanner(System.in);
        Set<Integer> userGuesses = userInputReader.acquireUserInput(scanner);
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

