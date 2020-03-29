import bets.Bet;
import bets.BetName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static loggert.Logger.log;


public class Game {
    public void runGame() throws IOException {
        List<Player> players = createPlayers();
        Table table = new Table();
        while (!players.isEmpty()) {
            for (Player player : players) {
                log(player.getName() + " please make a bet");
                String betName;
                int amount;
                log("Specify bet type. Available bets: " + Arrays.toString(BetName.values()));
                betName = readLine();
                log("Specify bet amount. Available amount: " + player.getTotalAmount());
                amount = Integer.parseInt(readLine());
                Bet playerBet = player.makeBet(betName, amount);
                table.placePlayerBet(playerBet, player);
            }

            log("Game begins");
            table.runCircle();
            log("Results: ");
            log("Casino: " + table.getTableAmount());

            for (Player player : players) {
                log("Player: " + player.getName() + " amout: " + player.getTotalAmount());
                if (player.getTotalAmount() <= 0){
                    players.remove(player);
                    log("Player " + player.getName() + " left the game due no money");
                }
            }
        }

        log("Game ended Casino won" + table.getTableAmount());

    }

    private int definePlayersAmount() throws IOException {
       log("Define number of players: ");
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
        String amount  = reader.readLine();
        return  Integer.parseInt(amount);
    }

    private List<Player> createPlayers() throws IOException {
        int numberOfPlayers = definePlayersAmount();
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++){
           log("Define player nr." + i);
           log("Define name: ");
            String name = readLine();
            log("Define amount: ");
            int amount = Integer.parseInt(readLine());
            Player player = new Player(name,amount);
            players.add(player);
            log("player created");
        }
        return players;
    }
    
    private String readLine() throws IOException {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
