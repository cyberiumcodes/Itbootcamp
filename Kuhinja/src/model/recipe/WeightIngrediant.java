package model.recipe;

import databasse.ListOfIgrediants;

public class WeightIngrediant extends Ingrediant{
    private double weight;
    double pricePerUnit;
    private double neto;

    public WeightIngrediant(String name, double pricePerUnit, double neto) {
        super(name);
        this.pricePerUnit = pricePerUnit;
        this.neto = neto;
        ListOfIgrediants.listOfWIngrediants.put(this.getName(), this);
    }

    public WeightIngrediant(String name, double weight) {
        super(name);
        this.weight = weight;
        ListOfIgrediants.listOfWIngrediants.put(this.getName(), this);
    }

    public WeightIngrediant(String name) {
        super(name);
        ListOfIgrediants.listOfWIngrediants.put(this.getName(), this);

    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return weight * pricePerUnit;
    }

    public double getNeto() {
        return neto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public boolean isAvailableweightForRecipe(){
        return neto < weight;
    }
}
