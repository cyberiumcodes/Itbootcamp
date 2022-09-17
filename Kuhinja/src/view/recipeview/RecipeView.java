package view.recipeview;

import model.recipe.Recipe;
import model.users.RegularUser;

public class RecipeView {

    Recipe recipe;

    public RecipeView(Recipe recipe) {
        this.recipe = recipe;
    }

    public void PrintNameOfRecipe(){
        System.out.println("NAZIV JELA: " + recipe.getNameOfRecipe());
    }

    public void PrintLIstOfIngrediants(){
        recipe.getListOfIgrediants().forEach(ingrediant -> System.out.println("" + ingrediant.getName() +
                " kolicina sastojka: " + ingrediant.getWeight() + " price :" + ingrediant.getPrice() + " din"));
    }

    public void printTotalPrice(){
        System.out.println("ukupno cena jela: " + recipe.getPrice());
    }

    public void PrintRecipeDescription(){
        System.out.println(recipe.getDescription());
    }

    public void printRecipe(){
        PrintNameOfRecipe();
        System.out.println("_".repeat(50));
        System.out.println();
        PrintLIstOfIngrediants();
        System.out.println("//".repeat(25));
        PrintRecipeDescription();
        printTotalPrice();
        System.out.println();
        System.out.println("1 - kupi                 2 - nazad na listu jela");

    }

    public void setFavorite(RegularUser regularUser){
        regularUser.setListOfFavoritesRecipies(recipe);
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
