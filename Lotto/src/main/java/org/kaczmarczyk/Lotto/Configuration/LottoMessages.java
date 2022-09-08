package org.kaczmarczyk.Lotto.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LottoMessages {

    public static String GAME_STARTING_MESSAGE;
    public static String INPUT_IS_NOT_NUMBER_MESSAGE;
    public static String INPUT_IS_OUT_OF_BOUNDS_MESSAGE;
    public static String USER_INPUT_REMINDER_MESSAGE;
    public static String YOU_WON_MESSAGE;
    public static String YOU_LOST_MESSAGE;

    static {
        try {
            GAME_STARTING_MESSAGE = prepareMessage("gameBegins");
            INPUT_IS_NOT_NUMBER_MESSAGE = prepareMessage("inputNotANumber");
            INPUT_IS_OUT_OF_BOUNDS_MESSAGE = prepareMessage("inputOutOfBounds");
            USER_INPUT_REMINDER_MESSAGE = prepareMessage("remindUserGuesses");
            YOU_WON_MESSAGE = prepareMessage("youWon");
            YOU_LOST_MESSAGE = prepareMessage("youLost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LottoMessages() {
    }

    public static void printMessage(String... message) {
        System.out.println(message);
    }

    private static String prepareMessage(String key) throws IOException {

        FileReader reader = new FileReader("src/main/Resources.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return properties.getProperty(key);
    }
}