import java.net.PortUnreachableException;

// TODO: 30.07.2022 unused import
// TODO: 30.07.2022 final
// TODO: 30.07.2022 it would be good to have it in properties
public class LottoGameSettings {
    // TODO: 30.07.2022 since you shouldnt ever have a situation where these 2 values are different, whats the point of having separate constants?
    public static final int NUMBERS_TO_GENERATE = 6;
    public static final int NUMBERS_TO_GUESS = 6;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 99;

    private LottoGameSettings() {
    }
}
