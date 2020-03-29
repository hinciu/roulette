package bets;

import java.util.Arrays;
import java.util.List;

public class ZeroBet implements Bet {

    private final int RATE = 1;
    private int amount;

    private final List<Integer> betNumbers = Arrays.asList(0);

    public int getPaymentRate() {
        return RATE;
    }

    public boolean isWinner(int number) {
        return betNumbers.contains(number);
    }

    public BetName getName() {
        return BetName.ZERO;
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
