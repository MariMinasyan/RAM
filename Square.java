package core;

public class Square implements Cloneable {
    private String name;
    private int position;
    private String color;

    public Square(String name, int position, String color) {
        this.name = name;
        this.position = position;
        this.color = color;
    }

    public Square clone(){
        try{
            return (Square) super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }

    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    public String getColor(){
        return color;
    }
}
