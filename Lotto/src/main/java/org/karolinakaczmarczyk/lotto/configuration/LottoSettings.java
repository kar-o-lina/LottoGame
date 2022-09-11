package org.karolinakaczmarczyk.lotto.configuration;

import java.io.IOException;
import static org.karolinakaczmarczyk.lotto.configuration.PropertiesReader.readProperty;

public final class LottoSettings {

    private final static String settingsPropertiesFilePath = "src/main/java/settings.properties";

    public static int NUMBERS_FOR_LOTTO_GAME;
    public static int LOWER_BOUND;
    public static int UPPER_BOUND;

    static {
        try {
            NUMBERS_FOR_LOTTO_GAME = Integer.parseInt(readProperty("howManyNumbers", settingsPropertiesFilePath));
            LOWER_BOUND = Integer.parseInt(readProperty("lowerBound", settingsPropertiesFilePath));
            UPPER_BOUND = Integer.parseInt(readProperty("upperBound", settingsPropertiesFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LottoSettings() {
    }
}

