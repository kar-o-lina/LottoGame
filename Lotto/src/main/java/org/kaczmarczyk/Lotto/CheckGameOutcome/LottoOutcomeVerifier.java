package org.kaczmarczyk.Lotto.CheckGameOutcome;

import java.util.Set;

import static org.kaczmarczyk.Lotto.Configuration.LottoMessages.*;

public class LottoOutcomeVerifier {

    public void checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {
        printMessage(USER_INPUT_REMINDER_MESSAGE, userGuesses.toString());

        if (hasUserWon(generatedNumbers, userGuesses)) {
            printMessage(YOU_WON_MESSAGE);
        } else {
            printMessage(YOU_LOST_MESSAGE);
        }
    }

    boolean hasUserWon(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {
        return generatedNumbers.equals(userGuesses);
    }

}


