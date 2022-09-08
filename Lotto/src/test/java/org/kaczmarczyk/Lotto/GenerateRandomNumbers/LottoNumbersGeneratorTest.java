package org.kaczmarczyk.Lotto.GenerateRandomNumbers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.kaczmarczyk.Lotto.Configuration.LottoGameSettings.*;


class LottoNumbersGeneratorTest {

    LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

    @Test
    void shouldGenerate6RandomNumbers() {
        //when
        int setSize = lottoNumbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND).size();

        //then
        assertThat(setSize, equalTo(6));
    }

    @Test
    void generatedNumbersShouldBeInProperRange() {
        //when
        Set<Integer> generatedNumbers = lottoNumbersGenerator.generateRandomNumbers(NUMBERS_FOR_LOTTO_GAME, LOWER_BOUND, UPPER_BOUND);

        Integer maxGeneratedNumber = generatedNumbers.stream().max(Integer::compareTo).get();
        Integer minGeneratedNumber = generatedNumbers.stream().min(Integer::compareTo).get();

        //then
        assertAll("Checking that generated numbers are in range 1 to 99 inclusive",
                () -> assertThat(maxGeneratedNumber, lessThan(100)),
                () -> assertThat(minGeneratedNumber, greaterThan(0))
        );
    }
}