package core;

import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public ArrayList<Square> getSquares(){
        ArrayList<Square> copy = new ArrayList<>();
        for(int i = 0; i < squares.size(); i++){
            copy.add(squares.get(i).clone());
        }
        return copy;
    }

    public Board() {
        squares = new ArrayList<>();
        squares.add(new Square("Start", 0, "White"));
        squares.add(new Property("Salvador", 1, "Green",60,2));
        squares.add(new Square("Treasure", 2, "Gray"));
        squares.add(new Property("Rio", 3, "Green",60,4));
        squares.add(new Square("Income Tax", 4, "Gray"));
        squares.add(new Property("Electric Company", 5, "Gray",200,15));
        squares.add(new Square("In Prison", 6, "Gray"));
        squares.add(new Square("Go To Prison", 7, "Gray"));
        squares.add(new Square("Treasure", 8, "Gray"));
        squares.add(new Property("Munich", 9, "Purple",180,14));
        squares.add(new Square("Surprise", 11, "Gray"));
        squares.add(new Property("Berlin", 12, "Purple",200, 16));
        squares.add(new Square("WinOrLose", 13, "Gray"));
        squares.add(new Property("Shenzhen", 14, "Pink",220,18));
        squares.add(new Square("Surprise", 15, "Gray"));
        squares.add(new Property("Beijing", 16, "Pink",220,18));
        squares.add(new Property("Airport", 17, "Gray", 150, 11));
        squares.add(new Property("Shanghai", 18, "Pink",240,20));
        squares.add(new Property("Manchester", 19, "Teal",300,26));
        squares.add(new Property("Toulouse", 20, "Yellow",260,22));
        squares.add(new Property("Water Company", 21, "Gray", 100, 8));
        squares.add(new Property("Paris", 22, "Yellow",280,24));
        squares.add(new Property("Frankfurt", 23, "Purple",180,14));
        squares.add(new Property("Liverpool", 24, "Teal",300,26));
        squares.add(new Square("Surprise", 25, "Yellow"));
        squares.add(new Property("Lyon", 26, "Gray",260,22));
        squares.add(new Property("London", 27, "Teal",320,28));
        squares.add(new Square("Luxury Tax", 28, "Gray"));


    }

    public Square getSquare(int position) {
        return squares.get(position);
    }

}
