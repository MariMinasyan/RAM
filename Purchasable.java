package core;

public interface Purchasable {

    void buy(Player player);

    void sell(Player player);

    boolean isAvailable();
}


