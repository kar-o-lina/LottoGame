package org.karolinakaczmarczyk.lotto.configuration;

import java.io.IOException;

import static org.karolinakaczmarczyk.lotto.configuration.PropertiesReader.readProperty;

public final class LottoMessages {

    private final static String messagesPropertiesFilePath = "src/main/java/messages.properties";

    public static String GAME_STARTING_MESSAGE;
    public static String INPUT_IS_NOT_NUMBER_MESSAGE;
    public static String INPUT_IS_OUT_OF_BOUNDS_MESSAGE;
    public static String USER_GUESSES_MESSAGE;
    public static String YOU_WON_MESSAGE;
    public static String YOU_LOST_MESSAGE;

    static {
        try {
            GAME_STARTING_MESSAGE = readProperty("gameBegins", messagesPropertiesFilePath);
            INPUT_IS_NOT_NUMBER_MESSAGE = readProperty("inputNotANumber", messagesPropertiesFilePath);
            INPUT_IS_OUT_OF_BOUNDS_MESSAGE = readProperty("inputOutOfBounds", messagesPropertiesFilePath);
            USER_GUESSES_MESSAGE = readProperty("remindUserGuesses", messagesPropertiesFilePath);
            YOU_WON_MESSAGE = readProperty("youWon", messagesPropertiesFilePath);
            YOU_LOST_MESSAGE = readProperty("youLost", messagesPropertiesFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LottoMessages() {
    }

    public static void print(String... message) {
        System.out.println(message);
    }
}