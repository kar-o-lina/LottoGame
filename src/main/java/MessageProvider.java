public class MessageProvider {
    public static final String PROMPT = "Lotto Game is about to begin. Please enter 6 numbers greater than 1 and less than 99:";
    public static final String NOT_NUMBER = "Invalid user input. Enter numbers only.";
    public static final String OUT_OF_BOUNDS = "Number out of bounds. Valid numbers are in range 1 to 99 inclusive.\nPlease choose again: ";
    public static final String ENTERED_NUMBERS = "\nYour guesses: ";
    public static final String WIN = "Congratulations! You won! :) ";
    public static final String LOST = "\nYou didn't win this time :( \nMaybe next time?";

    private MessageProvider() {
    }
}
