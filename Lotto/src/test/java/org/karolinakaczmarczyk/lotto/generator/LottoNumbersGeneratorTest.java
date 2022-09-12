package org.karolinakaczmarczyk.lotto.generator;

import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.karolinakaczmarczyk.lotto.config.LottoSettings.*;

class LottoNumbersGeneratorTest {

    private final RandomNumbersGenerator numbersGenerator = new LottoNumbersGenerator(new Random());

    @Test
    void shouldGenerate6RandomNumbers() {
        //when
        int setSize = numbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND).size();

        //then
        assertThat(setSize, equalTo(6));
    }

    @Test
    void generatedNumbersShouldBeInProperRange() {
        //when
        Set<Integer> generatedNumbers = numbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND);

        int maxGeneratedNumber = generatedNumbers.stream().max(Integer::compareTo).get();
        int minGeneratedNumber = generatedNumbers.stream().min(Integer::compareTo).get();

        //then
        assertAll("Checking that generated numbers are in range 1 to 99 inclusive",
                () -> assertThat(maxGeneratedNumber, lessThan(100)),
                () -> assertThat(minGeneratedNumber, greaterThan(0))
        );
    }
}