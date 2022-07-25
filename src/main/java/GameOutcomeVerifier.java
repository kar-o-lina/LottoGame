import java.util.HashSet;
import java.util.Set;

public class GameOutcomeVerifier  {

    public GameOutcomeVerifier() {
    }

    public void checkGameOutcome(Set<Integer> generatedNumbers,Set<Integer> userGuesses) {
        System.out.println(MessageProvider.ENTERED_NUMBERS + "\n" + userGuesses);

        if (generatedNumbers.containsAll(userGuesses) && userGuesses.containsAll(generatedNumbers)) {
            System.out.println(MessageProvider.WIN);
        } else {
            System.out.println(MessageProvider.LOST);
        }
    }
}


