package pl.juniorJavaReady.LottoProject;

import java.util.HashMap;
import java.util.Map;

//Answer to above: google says properties are String to String values
//soo I made simple hashmap
public class LottoGameSettings {


    //todo change other classes so they can use hashmap instead of previous static
    public LottoGameSettings() {
        Map<String, Integer> configurationSetupValues = new HashMap<>();
        configurationSetupValues.put("NUMBERS_TO_GENERATE_AND_GUESS", 6);
        configurationSetupValues.put("LOWER_BOUND", 1);
        configurationSetupValues.put("UPPER_BOUND", 99);
    }
}
