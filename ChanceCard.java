package core;

import Exceptions.BankruptcyException;

public class ChanceCard {
    private String description;
    private String type;
    private int amount;
    public static String[] descriptions = new String[]{"MOVE", "PAY", "GO_TO_JAIL", "GET_OUT_OF_JAIL"};


    public ChanceCard(String description, String type, int amount) {
        this.description = description;
        this.type = type;
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void applyEffect(Player p) throws BankruptcyException {
        if (p == null) {
            throw new NullPointerException("The player is null");
        }
        switch (type) {
            case "MOVE":
                p.move(amount);
                break;
            case "PAY":
                p.payTax(amount);
                break;
            case "GO_TO_JAIL":
                p.goToJail();
                break;
            case "GET_OUT_OF_JAIL":
                p.outOfJail(true);
                break;
        }
    }
}
