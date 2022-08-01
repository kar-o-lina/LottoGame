package pl.juniorJavaReady.LottoProject;

import java.util.Set;

public class GameOutcomeVerifier {

    public void checkGameOutcome(Set<Integer> generatedNumbers, Set<Integer> userGuesses) {
        System.out.println(MessageProvider.ENTERED_NUMBERS + "\n" + userGuesses);

        // TODO: 30.07.2022 generatedNumbers.equals(userGuesses) is sufficient
        // Answer to above comment: it is not sufficient, as collections would be equal (equals() method)
        // only when items take the same position in compared objects (items must be the same and in same positions for objects to be equal
        //thats not the point here
        if (generatedNumbers.containsAll(userGuesses) && userGuesses.containsAll(generatedNumbers)) {
            System.out.println(MessageProvider.WIN);
        } else {
            System.out.println(MessageProvider.LOST);
        }
    }
}


