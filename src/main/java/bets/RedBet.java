package bets;

import java.util.Arrays;
import java.util.List;

public class RedBet implements Bet {

    private final int RATE = 1;
    private int amount;

    private final List<Integer> betNumbers = Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);

    public int getPaymentRate() {
        return RATE;
    }

    public boolean isWinner(int number) {
        return betNumbers.contains(number);
    }

    public BetName getName() {
        return BetName.RED;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
