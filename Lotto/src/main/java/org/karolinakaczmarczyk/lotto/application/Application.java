package org.karolinakaczmarczyk.lotto.application;

import org.karolinakaczmarczyk.lotto.checkoutcome.LottoOutcomeVerifier;
import org.karolinakaczmarczyk.lotto.generatenumbers.LottoNumbersGenerator;
import org.karolinakaczmarczyk.lotto.readinput.ConsoleInputReader;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        LottoGame game = new LottoGame(new ConsoleInputReader(new Scanner(System.in)), new LottoNumbersGenerator(new Random()), new LottoOutcomeVerifier());
        game.play();
    }
}
