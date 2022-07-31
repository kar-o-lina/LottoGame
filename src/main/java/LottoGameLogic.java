import java.util.Set;

// TODO: 30.07.2022 just LottoGame
public class LottoGameLogic implements Game {

    // TODO: 30.07.2022 should be an interface here (as in previous comment), also programming to interfaces
    private final UserInputReader userInputGetter;
    private final RandomNumbersGenerator randomNumbersGenerator;
    private final GameOutcomeVerifier gameOutcomeVerifier;

    // TODO: 30.07.2022 dependency injection, currently class is not testable
    public LottoGameLogic() {
        this.userInputGetter = new UserInputReader();
        this.randomNumbersGenerator = new RandomNumbersGenerator();
        this.gameOutcomeVerifier = new GameOutcomeVerifier();
    }

    // TODO: 30.07.2022 formatting
@Override
    public void play() {
        Set<Integer> userGuesses = userInputGetter.getUserInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

