package org.karolinakaczmarczyk.lotto.generator;

import java.util.Set;

public interface RandomNumbersGenerator {
    Set<Integer> generateRandomNumbers(int numbersToGenerate, int lowerBoundInclusive, int upperBoundInclusive);
}
