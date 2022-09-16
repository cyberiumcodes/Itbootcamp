package model.recipe;

public class Ingrediant implements Prieceble{
    public static int nextId = 0;
    private int id;
    private String name;

    public Ingrediant(String name) {
        this.name = name;
        this.id = nextId++;
    }


    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
