package org.kaczmarczyk.Lotto.ReadUserInput;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertFalse;

class ConsoleInputReaderTest {

    private final Scanner scanner = mock(Scanner.class);
    private final ConsoleInputReader consoleInputReader = new ConsoleInputReader(scanner);

    @Test
    void shouldReturnFalseWhenUserInputIsNotNumber() {
        //given
        String inputForTesting = "game over";

        //when
        boolean outcome = consoleInputReader.validateUserInput(inputForTesting);

        //then
        assertFalse(outcome);
    }

    @ParameterizedTest
    @ValueSource(ints = {110, -500, 821, 0, 100})
    void shouldReturnFalseWhenUserInputNotInBounds(int inputForTesting) {
        //when
        boolean outcome = consoleInputReader.validateUserInput(String.valueOf(inputForTesting));

        //then
        assertFalse(outcome);
    }

    @Test
    void shouldReturnSetOf6IntegersInRange() {
        //given
        given(scanner.next()).willReturn("1", "2", "y", "3", "4", "105", "5", "6");

        //when
        var result = consoleInputReader.readInput();

        //then
        then(scanner)
                .should(times(8))
                .next();

        then(scanner).shouldHaveNoMoreInteractions();

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}