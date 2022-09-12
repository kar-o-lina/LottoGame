package org.karolinakaczmarczyk.lotto.checkoutcome;

import java.util.Set;
import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.USER_GUESSES_MESSAGE;
import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.YOU_LOST_MESSAGE;
import static org.karolinakaczmarczyk.lotto.configuration.LottoMessages.YOU_WON_MESSAGE;

public class LottoOutcomeVerifier {

    public boolean checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {

        System.out.println(USER_GUESSES_MESSAGE + userGuesses.toString());

        if (hasWon(generatedNumbers, userGuesses)) {
            System.out.println(YOU_WON_MESSAGE);
            return true;
        } else {
            System.out.println(YOU_LOST_MESSAGE);
        }
        return false;
    }

    private boolean hasWon(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {
        return generatedNumbers.equals(userGuesses);
    }
}


