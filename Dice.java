package core;

import java.util.Random;

public class Dice {
    private Random random;
    private int number1,number2;

    public Dice() {
        random = new Random();
    }

    public void roll() {
        number1 = random.nextInt(6) + 1;
        number2 = random.nextInt(6) + 1;
    }

    public int getSum() {
        return number1 + number2;
    }

    public String toString(){
        return "" + number1 + ", " + number2;
    }
}
