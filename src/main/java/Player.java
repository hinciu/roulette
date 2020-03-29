import bets.Bet;
import bets.GameBetFactory;

public class Player {
    private String name;
    private int totalAmount;

    public Player(String name, int totalAmount) {
        this.name = name;
        this.totalAmount = totalAmount;
    }

    Bet makeBet(String betName, int betAmount) {
        Bet gameBet = GameBetFactory.createBet(betName);
        decreaseTotalAmount(betAmount);
        gameBet.setAmount(betAmount);
        return gameBet;
    }


    private void decreaseTotalAmount(int amount) {
        totalAmount = totalAmount - amount;
    }

    public void payPrize(int amount) {
        totalAmount = totalAmount + amount;
    }

    public String getName() {
        return name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
