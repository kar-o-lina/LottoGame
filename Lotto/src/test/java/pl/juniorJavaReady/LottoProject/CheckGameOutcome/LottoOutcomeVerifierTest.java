package pl.juniorJavaReady.LottoProject.CheckGameOutcome;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LottoOutcomeVerifierTest {

    @Test
    void shouldReturnTrueWhenUserWon() {
        //given
        LottoOutcomeVerifier lottoOutcomeVerifier = new LottoOutcomeVerifier();
        //when
        Set<Integer> fakeUserGuesses = new HashSet<>(Arrays.asList(2, 17, 64, 62, 90, 10));
        Set<Integer> fakeGeneratedNumbers = new HashSet<>(Arrays.asList(62, 90, 10, 2, 17, 64));
        //then
        assertTrue(lottoOutcomeVerifier.hasUserWon(fakeGeneratedNumbers, fakeUserGuesses));
    }

    @Test
    void shouldReturnFalseWhenUserLost() {
        //given
        LottoOutcomeVerifier lottoOutcomeVerifier = new LottoOutcomeVerifier();
        //when
        Set<Integer> fakeUserGuesses = new HashSet<>(Arrays.asList(2, 17, 64, 62, 90, 10));
        Set<Integer> fakeGeneratedNumbers = new HashSet<>(Arrays.asList(62, 90, 11, 2, 17, 64));
        //then
        assertFalse(lottoOutcomeVerifier.hasUserWon(fakeGeneratedNumbers, fakeUserGuesses));
    }
}