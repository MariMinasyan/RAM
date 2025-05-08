package core;

import Exceptions.BankruptcyException;

import javax.swing.*;

public class Player {
    private String name;
    private int money;
    private int position;
    private int previousPosition;
    private boolean inJail;
    private ImageIcon playerImage;

    public int getPreviousPosition() {
        return previousPosition;
    }

    public Player(String name, int startingMoney, String imagePath) {
        this.name = name;
        this.money = startingMoney;
        this.position = 0;
        this.inJail = false;
        this.playerImage = new ImageIcon(imagePath);
    }
    public Player(Player other){
        this.name = other.name;
        this.money = other.money;
        this.position = other.position;
        this.inJail = other.inJail;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public void goToJail() {
        inJail = true;
        position = 6;
        System.out.println(name + " Go to jail.");
    }

    public void receiveMoney(int amount) {
        money += amount;
        System.out.println(name + "'s received money is " + amount);
    }
    public void deductMoney(int amount) {
        money -= amount;
        System.out.println(name + "'s deducted money is " + amount);
    }

    public void move(int roll) {
        previousPosition = position;
        position = (position + roll) % 28;
        System.out.println(name + " went to " + position);
    }

    public ImageIcon getPlayerImage() {
        return playerImage;
    }

    public void payRent(Property property) throws BankruptcyException {
        int rentAmount = property.calculateRent();
        if (money >= rentAmount) {
            money -= rentAmount;
            property.getOwner().receiveMoney(rentAmount);
            System.out.println(name + " paid $" + rentAmount + " to " + property.getOwner().getName());
        } else {
            throw new BankruptcyException();
        }
    }

    public void payTax(int amount) throws BankruptcyException {
        if(money >= amount){
            money -= amount;
        }else{
            throw new BankruptcyException();
        }
    }

    public void outOfJail(boolean b) {
        inJail = false;

    }
    public void winOrLose(boolean b, int numbersOfDice){
        if(b){
            money += (numbersOfDice * 5);
        }else{
            money -= (numbersOfDice * 5);
        }
    }
}
