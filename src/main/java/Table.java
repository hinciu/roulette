import bets.Bet;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import static loggert.Logger.log;

public class Table {
    private int tableAmount = 0;
    private List<Pair<Bet,Player>> availableBets = new ArrayList<>();
    private Wheel wheel = new Wheel();

    public void runCircle() {
        log("Wheel is spinning");
        int wonNumber = wheel.spinWheel();
        checkWinnersAndPay(wonNumber);
        availableBets.clear();
    }

    private void checkWinnersAndPay(int number) {
        for (Pair<Bet,Player> currentBet: availableBets ) {
            Bet bet = currentBet.getKey();
            Player player = currentBet.getValue();
            if (bet.isWinner(number)) {
               log(bet.getName() + " WON. number is " + number);
                int amountToPay = bet.getAmount() * bet.getPaymentRate();
                player.payPrize(amountToPay);
            } else {
                tableAmount += bet.getAmount();
            }
        }
    }

    public void placePlayerBet(Bet bet, Player player) {
        availableBets.add(new Pair<>(bet,player));
    }

    public int getTableAmount() {
        return tableAmount;
    }
}
