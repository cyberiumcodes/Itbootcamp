package model.recipe;

import controllers.adminController.AdminController;
import databasse.ListOfIgrediants;
import databasse.ListOfRecipes;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Prieceble{
    private String nameOfRecipe;
    private RecipeLevel recipeLevel;
    private String description;
    private List<WeightIngrediant> listOfIgrediants = new ArrayList<>();

    public Recipe(String nameOfRecipe, RecipeLevel recipeLevel, WeightIngrediant ...ingrediants) {
        this.nameOfRecipe = nameOfRecipe;
        this.recipeLevel = recipeLevel;
        for (var el:
             ingrediants) {
            listOfIgrediants.add(el);
        }
        ListOfRecipes.listOfRecipes.put(this.nameOfRecipe, this);
    }

    public Recipe(String nameOfRecipe, WeightIngrediant ...ingrediants) {
        this.nameOfRecipe = nameOfRecipe;
        for (var el:
                ingrediants) {
            listOfIgrediants.add(el);
        }
        ListOfRecipes.listOfRecipes.put(this.nameOfRecipe, this);

    }

    public Recipe(String nameOfRecipe, String description) {
        this.nameOfRecipe = nameOfRecipe;
        this.description = description;
        ListOfRecipes.listOfRecipes.put(this.nameOfRecipe, this);
    }

    public Recipe() {
        ListOfRecipes.listOfRecipes.put(this.nameOfRecipe, this);
    }

    public Recipe(String nameOfRecipe, String description, WeightIngrediant... listOfIgrediants) {
        this.nameOfRecipe = nameOfRecipe;;
        this.description = description;
        for (var el:
             listOfIgrediants) {
            this.listOfIgrediants.add(el);
        }
        ListOfRecipes.listOfRecipes.put(this.nameOfRecipe, this);

    }

    public List<WeightIngrediant> getListOfIgrediants() {
        return listOfIgrediants;
    }

    public void addWeightIngrediant(WeightIngrediant ingrediant){
        if (!listOfIgrediants.contains(ingrediant)) listOfIgrediants.add(ingrediant);
        else System.out.println("Ovaj sastojak ste vec uneli");
    }

    public void removeWeightIngrediant(WeightIngrediant ingrediant){
        try {
            if (listOfIgrediants.contains(ingrediant)) listOfIgrediants.remove(ingrediant);
        } catch (Exception e){
            System.out.println("Trazeni sastojak nije pronadjen u database!");
        }
    }

    public void setRecipeLevel(RecipeLevel recipeLevel) {
        this.recipeLevel = recipeLevel;
    }

    public RecipeLevel getRecipeLevel() {
        return recipeLevel;
    }

    public String getNameOfRecipe(){
        return this.nameOfRecipe;
    }

    public void setListOfIgrediants(List<WeightIngrediant> listOfIgrediants) {
        this.listOfIgrediants = listOfIgrediants;
    }

    public void setNameOfRecipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
    }

    public String getDescription() {
        String descriptionTemp = (!description.isEmpty())? description:"Description is empty";
        return descriptionTemp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void clearDescriptin(){
        this.description = "";
    }

    public boolean isAvailableEnoughIngrediants(){
        boolean isEnough = true;
        for (WeightIngrediant el:
             listOfIgrediants) {
            if (el.isAvailableweightForRecipe() == false) {
                isEnough = el.isAvailableweightForRecipe();
                break;
            }
        }
        return isEnough;
    }

    public void scaleRecipeNeto(int scale){
        for (WeightIngrediant el:
             listOfIgrediants) {
            el.setNeto(el.getNeto() / scale);
        }
    }

    public void byingRecipe(){
        if (isAvailableEnoughIngrediants()){
            listOfIgrediants.stream().forEach(ingrediant -> ingrediant.setNeto(ingrediant.getNeto() - ingrediant.getWeight()));
        } else {
            for (var el:
                 listOfIgrediants) {
                if (!el.isAvailableweightForRecipe()) AdminController.missingWeightIngrediant.add(el);
            }
        }



    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (var el:
             listOfIgrediants) {
            sum += el.getPrice();
        }
        return sum;
    }



}
