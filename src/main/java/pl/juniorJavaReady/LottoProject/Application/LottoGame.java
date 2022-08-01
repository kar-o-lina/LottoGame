package pl.juniorJavaReady.LottoProject.Application;

import pl.juniorJavaReady.LottoProject.GameOutcomeVerifier;
import pl.juniorJavaReady.LottoProject.GenerateRandomNumbers.LottoNumbersGenerator;
import pl.juniorJavaReady.LottoProject.ReadUserInput.ConsoleInputReader;

import java.util.Set;

public class LottoGame implements Game {

    // TODO: 30.07.2022 should be an interface here (as in previous comment), also programming to interfaces
    //like Game interface?
    private final ConsoleInputReader userInputGetter;
    private final LottoNumbersGenerator randomNumbersGenerator;
    private final GameOutcomeVerifier gameOutcomeVerifier;

    // TODO: 30.07.2022 dependency injection, currently class is not testable
    public LottoGame() {
        this.userInputGetter = new ConsoleInputReader();
        this.randomNumbersGenerator = new LottoNumbersGenerator();
        this.gameOutcomeVerifier = new GameOutcomeVerifier();
    }

    @Override
    public void play() {
        Set<Integer> userGuesses = userInputGetter.acquireUserInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

