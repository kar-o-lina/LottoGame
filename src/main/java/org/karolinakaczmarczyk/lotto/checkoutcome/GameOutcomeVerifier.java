package org.karolinakaczmarczyk.lotto.checkoutcome;

import java.util.Set;

public interface GameOutcomeVerifier {
    void checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses);
}
