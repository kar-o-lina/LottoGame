package org.karolinakaczmarczyk.lotto.configuration;

public final class LottoMessages {

    public static String GAME_STARTING_MESSAGE = "Lotto Game is about to begin. Please enter 6 numbers from 1 to 99 inclusive:";
    public static String INPUT_IS_NOT_NUMBER_MESSAGE = "Invalid user input. Enter numbers only.";
    public static String INPUT_IS_OUT_OF_BOUNDS_MESSAGE = "Number out of bounds.\nValid numbers are in range from 1 to 99 inclusive. Please choose again: ";
    public static String USER_GUESSES_MESSAGE = "\nYour guesses:\n";
    public static String YOU_WON_MESSAGE = "Congratulations! You won! :) ";
    public static String YOU_LOST_MESSAGE = "\nYou didn't win this time :( \nMaybe next time?";

    private LottoMessages() {
    }
}