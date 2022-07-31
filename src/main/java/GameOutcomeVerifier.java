import java.util.HashSet;
import java.util.Set;

// TODO: 30.07.2022 formatting
// TODO: 30.07.2022 unused imports
public class GameOutcomeVerifier  {

    // TODO: 30.07.2022 not needed, java will generate it for you
    public GameOutcomeVerifier() {
    }

    // TODO: 30.07.2022 formatting
    public void checkGameOutcome(Set<Integer> generatedNumbers,Set<Integer> userGuesses) {
        System.out.println(MessageProvider.ENTERED_NUMBERS + "\n" + userGuesses);

        // TODO: 30.07.2022 generatedNumbers.equals(userGuesses) is sufficient
        if (generatedNumbers.containsAll(userGuesses) && userGuesses.containsAll(generatedNumbers)) {
            System.out.println(MessageProvider.WIN);
        } else {
            System.out.println(MessageProvider.LOST);
        }
    }
}


