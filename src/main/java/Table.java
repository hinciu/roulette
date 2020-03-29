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
                // log(bet.getName() + " WON. number is " + number);
                int amountToPay = bet.getAmount() * bet.getPaymentRate();
                player.payPrize(amountToPay);
            } else {
                tableAmount += bet.getAmount();
            }
            //ывод на экран цвет и номер победителя
            if ((number == 1) || (number == 3) || (number == 5) || (number ==  7) || (number ==  9) || (number ==  12)
                    || (number ==  14) || (number ==  16)|| (number ==  18) || (number == 19) || (number == 21) || (number == 23)
                    || (number == 25) || (number == 27) || (number == 30) || (number == 32) || (number == 34) || (number == 36)){
                log( "RED WON. number is " + number);
            }
            else if ( number == 0){
                log( "Zero WON. number is " + number);
            }
            else {
                log("BLACK WON. number is " + number);
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
