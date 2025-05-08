package core;

public class Property extends Square implements Purchasable {
    private int price;
    private int rent;
    private Player owner;

    public Property(String name, int position, String color, int price, int rent) {
        super(name, position, color);
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setRent(int rent){
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public int calculateRent() {
        return rent;
    }

    public Player getOwner() {
        return new Player(owner);
    }
    public Property clone(){
        Property copy = (Property) super.clone();
        if(copy.owner != null)
            copy.owner = new Player(copy.owner);
        return copy;
    }

    public void buy(Player player) {
        if (owner == null && player.getMoney() >= price) {
            owner = player;
            player.deductMoney(this.price);
            System.out.println(player.getName() + " bought " + getName());
        } else if (owner != null) {
            System.out.println(getName() + " is already owned by " + owner.getName());
        } else {
            System.out.println(player.getName() + " doesn't have enough money to buy " + getName());
        }
    }

    public void sell(Player player) {
        if (owner == player) {
            player.receiveMoney(this.price);
            owner = null;
            System.out.println(player.getName() + " sold " + getName());
        } else {
            System.out.println(player.getName() + " cannot sell a property ");
        }
    }

    public boolean isAvailable() {
        return owner == null;
    }
}
