import javax.swing.*;
import java.util.Random;

public class CoinFlip {
    private static final Random random = new Random();

    public static boolean flip() {
        boolean isHeads = random.nextBoolean();
        String result = isHeads ? "Heads" : "Tails";

        JOptionPane.showMessageDialog(null, "Coin Flip Result: " + result, "Coin Flip", JOptionPane.INFORMATION_MESSAGE);
        return isHeads;
    }
}
