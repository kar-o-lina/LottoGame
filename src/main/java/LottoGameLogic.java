import java.util.Set;

public class LottoGameLogic implements Game {

    private final UserInputGetter userInputGetter;
    private final RandomNumbersGenerator randomNumbersGenerator;
    private final GameOutcomeVerifier gameOutcomeVerifier;

    public LottoGameLogic() {
        this.userInputGetter = new UserInputGetter();
        this.randomNumbersGenerator = new RandomNumbersGenerator();
        this.gameOutcomeVerifier = new GameOutcomeVerifier();
    }
@Override
    public void play() {
        Set<Integer> userGuesses = userInputGetter.getUserInput();
        Set<Integer> randomNumbers = randomNumbersGenerator.generateRandomNumbers();
        gameOutcomeVerifier.checkGameOutcome(randomNumbers, userGuesses);
    }
}

