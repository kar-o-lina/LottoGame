package org.karolinakaczmarczyk.lotto.outcome;

import org.karolinakaczmarczyk.lotto.config.LottoMessages;

import java.util.Set;

public class LottoOutcomeVerifier implements GameOutcomeVerifier {

    @Override
    public void checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses){
        remindUserGuesses(userGuesses);

        if (hasUserWon(generatedNumbers, userGuesses)) {
            informUserHeWon();
        } else {
            informUserHeLost();
        }
    }

    private void remindUserGuesses(Set<Integer> userGuesses) {
        System.out.println(LottoMessages.USER_INPUT_REMINDER + "\n" + userGuesses);
    }

    private void informUserHeLost() {
        System.out.println(LottoMessages.YOU_LOST_LOST);
    }

    private boolean hasUserWon(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {
        return generatedNumbers.containsAll(userGuesses);
    }

    private void informUserHeWon() {
        System.out.println(LottoMessages.YOU_WIN_MESSAGE);
    }
}


// TODO: 30.07.2022 generatedNumbers.equals(userGuesses) is sufficient
// Answer to above: it is not sufficient, as collections would be equal (equals() method)
// only when items take the same position in compared objects (items must be the same and in same positions for objects to be equal)
//thats not the point here

