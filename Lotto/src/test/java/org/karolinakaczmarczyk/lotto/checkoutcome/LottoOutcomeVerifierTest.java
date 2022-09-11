package org.karolinakaczmarczyk.lotto.checkoutcome;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LottoOutcomeVerifierTest {

    private final LottoOutcomeVerifier lottoOutcomeVerifier = new LottoOutcomeVerifier();

    @Test
    void shouldReturnTrueWhenUserLost() {
        //given
        Set<Integer> userGuessesForTesting = Set.of(2, 17, 64, 62, 90, 10);
        Set<Integer> generatedNumbersForTesting = Set.of(62, 90, 10, 2, 17, 64);

        //when
        boolean outcome = lottoOutcomeVerifier.checkGameOutcome(generatedNumbersForTesting, userGuessesForTesting);

        //then
        assertTrue(outcome);
    }

    @Test
    void shouldReturnFalseWhenUserLost() {
        //given
        Set<Integer> userGuessesForTesting = Set.of(2, 17, 64, 62, 90, 10);
        Set<Integer> generatedNumbersForTesting = Set.of(62, 90, 11, 2, 17, 64);

        //when
        boolean outcome = lottoOutcomeVerifier.checkGameOutcome(generatedNumbersForTesting, userGuessesForTesting);

        //then
        assertFalse(outcome);
    }
}