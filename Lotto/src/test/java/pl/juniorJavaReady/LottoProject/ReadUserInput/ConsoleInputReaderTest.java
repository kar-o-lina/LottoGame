package pl.juniorJavaReady.LottoProject.ReadUserInput;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;

class ConsoleInputReaderTest {

    @Test
    void shouldReturnFalseWhenUserInputIsNotNumber() {
        //given + when
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String fakeInput = "game over";

        //then
        assertFalse(consoleInputReader.validateUserInput(fakeInput));
    }

    @ParameterizedTest
    @ValueSource(ints ={110, -500, 821, 0, 100})
    void shouldReturnFalseWhenUserInputNotInBounds(int fakeInput) {
        //given + when
        ConsoleInputReader consoleInputReader= new ConsoleInputReader();

        //then
        assertFalse(consoleInputReader.validateUserInput(String.valueOf(fakeInput)));
    }

    @ParameterizedTest
    @MethodSource("createFakeInputExamples")
    void shouldReturnSetOf6IntegersInRange(String inputExample) {
        //given +when
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        Scanner scanner = mockScanner(inputExample);
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9, 10));

        //then
        assertThat(consoleInputReader.acquireUserInput(scanner).size(), equalTo(numbers.size()));
    }

    private static Stream<Arguments> createFakeInputExamples() {
        return Stream.of(
                Arguments.of("12 7 22 90 66 1 55"),
                Arguments.of("12 777 22 90 66 1 55"),
                Arguments.of("y 7 22 90 66 55 88")
                );
    }

    private Scanner mockScanner(String input) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }

}