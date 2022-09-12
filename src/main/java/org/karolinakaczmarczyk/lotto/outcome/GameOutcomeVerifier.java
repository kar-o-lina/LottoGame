package org.karolinakaczmarczyk.lotto.outcome;

import java.util.Set;

public interface GameOutcomeVerifier {
    void checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses);
}
