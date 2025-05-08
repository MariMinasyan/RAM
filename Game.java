package core;
import Exceptions.BankruptcyException;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Board board;
    private int currentPlayerIndex;
    private Dice dice = new Dice();

    public Game() {
        players = new ArrayList<>();
        board = new Board();
        currentPlayerIndex = 0;
    }

    public void addPlayer(String nameOfPlayer) {
        Player newPlayer = new Player(nameOfPlayer, 1500, "?");
        players.add(newPlayer);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public int rollDice() {
        dice.roll();
        return dice.getSum();
    }

    public void movePlayer(int roll) {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.move(roll);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void rollDiceAction() throws BankruptcyException {
        int roll = rollDice();
        movePlayer(roll);
        landOnSquare();
        nextTurn();
    }

    public void landOnSquare() throws BankruptcyException {
        Player currentPlayer = getCurrentPlayer();
        Square landedSquare = board.getSquare(currentPlayer.getPosition());

        if (currentPlayer.getPreviousPosition() > currentPlayer.getPosition()) {
            currentPlayer.receiveMoney(100);
        }

        if (landedSquare instanceof Property) {
            Property property = (Property) landedSquare;
            if (property.getOwner() == null) {
                property.buy(currentPlayer);
            } else {
                currentPlayer.payRent(property);
            }
        }else{
            switch (landedSquare.getName()) {
                case "Start": currentPlayer.receiveMoney(300); // vrov trnel
                    break;
                case "Go To Prison":
                    currentPlayer.goToJail();
                    break;
                case "Income Tax":
                    currentPlayer.deductMoney(100);
                    break;
                case "WinOrLose":
                    if (rollDice() > 3) {
                        currentPlayer.winOrLose(true, rollDice());
                    } else {
                        currentPlayer.winOrLose(false, rollDice());
                    }
                    break;
                case "Surprise":
                    if (rollDice() < 4) {
                        new ChanceCard("Surprise", ChanceCard.descriptions[rollDice()], rollDice());
                    } else {
                        new ChanceCard("Surprise", ChanceCard.descriptions[rollDice() - 4], rollDice());
                        break;
                    }
                case "Treasure":
                    currentPlayer.receiveMoney(rollDice() * 5);
                    break;

                case "Luxury Tax":
                    currentPlayer.deductMoney((currentPlayer.getMoney() /15));
                    break;
            }

        }

    }

    public boolean isGameOver() {
        return players.size() == 1;
    }

    public String getWinner() {
        return players.get(0).getName();
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        Player[] copy = new Player[players.size()];
        for (int i = 0; i < players.size(); i++) {
            copy[i] = new Player(players.get(i));
        }
        return copy;
    }

}
