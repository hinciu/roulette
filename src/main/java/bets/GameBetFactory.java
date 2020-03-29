package bets;

public class GameBetFactory {

    private GameBetFactory() {
    }

    public static Bet createBet(String betName) {
        BetName name = BetName.valueOf(betName);

        if (name.equals(BetName.BLACK)) {
            return new BlackBet();
        } else {
            return new RedBet();
        }
    }
}
