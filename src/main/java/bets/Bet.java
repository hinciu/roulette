package bets;

public interface Bet {
     int getPaymentRate();

     boolean isWinner(int number);

     BetName getName();

     int getAmount();

     void setAmount(int amount);
}
