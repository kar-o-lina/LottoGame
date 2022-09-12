package org.karolinakaczmarczyk.lotto.readinput;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class ConsoleInputReaderTest {

    private final Scanner scanner = mock(Scanner.class);
    private final InputReader consoleInputReader = new ConsoleInputReader(scanner);

    @Test
    void shouldReturnSetOf6IntegersInRange() {
        //given
        given(scanner.nextInt()).willReturn(100, 1, 2, 3, 4, 5, 6);

        //when
        var result = consoleInputReader.readInput();

        //then
        then(scanner)
                .should(times(6))
                .nextInt();

        then(scanner).shouldHaveNoMoreInteractions();

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}

