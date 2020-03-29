package bets;

import java.util.Arrays;
import java.util.List;

public class BlackBet implements Bet {

    private static final int RATE = 1;
    private int amount;

    private final List<Integer> betNumbers = Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);

    public int getPaymentRate() {
        return RATE;
    }

    public boolean isWinner(int number) {
        return betNumbers.contains(number);
    }

    public BetName getName() {
        return BetName.BLACK;
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
