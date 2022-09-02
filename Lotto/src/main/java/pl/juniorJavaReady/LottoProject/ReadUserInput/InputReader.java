package pl.juniorJavaReady.LottoProject.ReadUserInput;

import java.util.Scanner;
import java.util.Set;

public interface InputReader {
    Set<Integer> acquireUserInput(Scanner scanner);
}
