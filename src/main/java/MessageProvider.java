// TODO: 30.07.2022 final
// TODO: 30.07.2022 also this class is not really a provider (provider suggests there is some logic here), it just holds some constants. something like LottoMessages would be enough
// TODO: 30.07.2022 another thing is you can extract these messages to resources, thanks to this you gain some flexibility
public class MessageProvider {
    // TODO: 30.07.2022 prompt... of what? unclear naming
    // TODO: 30.07.2022 names to be changed, they are not descriptive enough
    public static final String PROMPT = "Lotto Game is about to begin. Please enter 6 numbers greater than 1 and less than 99:";
    public static final String NOT_NUMBER = "Invalid user input. Enter numbers only.";
    public static final String OUT_OF_BOUNDS = "Number out of bounds. Valid numbers are in range from 1 to 99 inclusive.\nPlease choose again: ";
    public static final String ENTERED_NUMBERS = "\nYour guesses: ";
    public static final String WIN = "Congratulations! You won! :) ";
    public static final String LOST = "\nYou didn't win this time :( \nMaybe next time?";

    private MessageProvider() {
    }
}
