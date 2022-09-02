package pl.juniorJavaReady.LottoProject.GenerateRandomNumbers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

class LottoNumbersGeneratorTest {

    @Test
    void shouldGenerate6RandomNumbers() {
        //given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

        //when
        int setSize = lottoNumbersGenerator.generateRandomNumbers().size();

        //then
        assertThat(setSize, equalTo(6));
    }

    @Test
    void generatedNumbersShouldBeInProperRange() {
        //given
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        Set<Integer> generatedNumbers = lottoNumbersGenerator.generateRandomNumbers();

        //when
        Integer maxGeneratedNumber = generatedNumbers.stream().max(Integer::compareTo).get();
        Integer minGeneratedNumber = generatedNumbers.stream().min(Integer::compareTo).get();

        //then
        assertAll("Checking that generated numbers are in range 1 to 99 inclusive",
                () -> assertThat(maxGeneratedNumber, lessThan(100)),
                () -> assertThat(minGeneratedNumber, greaterThan(0))
        );
    }
}