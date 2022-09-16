package controllers.adminController.recipeController;

import controllers.adminController.AdminController;
import databasse.ListOfIgrediants;
import model.recipe.Recipe;
import model.recipe.RecipeLevel;
import view.adminView.AddingRecipeView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeController {


    AddingRecipeView recipeConstructView = new AddingRecipeView();
    AdminController adminController = new AdminController();
    private String nameOfRecipe;
    String descriptionOfRecipe;
   ArrayList<String> ingreidants ;
   Recipe recipe;

    public RecipeController(String nameOfRecipe, String description, ArrayList<String> ingrediants ) {
        this.nameOfRecipe = nameOfRecipe;
        this.descriptionOfRecipe = description;
        this.ingreidants = ingrediants;
        recipe = new Recipe(nameOfRecipe, descriptionOfRecipe);
    }



    private void SetWeigthINgrediantsFromSet(){
       for (String el:
            ingreidants) {
           if (ListOfIgrediants.listOfWIngrediants.containsKey(el)){
               recipe.addWeightIngrediant(ListOfIgrediants.listOfWIngrediants.get(el));
           } else {
               adminController.setMissingWeightIngrediant(ListOfIgrediants.listOfWIngrediants.get(el));
           }
       }
   }

   public void setRecipeLevel(){
       if (recipeConstructView.getRecipeLevel() != null) {
           recipe.setRecipeLevel(recipeConstructView.getRecipeLevel());
       } else automaticSetRecepiLevel(ingreidants);
   }

   public void automaticSetRecepiLevel(ArrayList<String> ingreidants){
       if (ingreidants.size() < 2) recipe.setRecipeLevel(RecipeLevel.BEGINNER);
       if (ingreidants.size() >= 2 && ingreidants.size() < 4) recipe.setRecipeLevel(RecipeLevel.EASY);
       if (ingreidants.size() >= 4 && ingreidants.size() < 6) recipe.setRecipeLevel(RecipeLevel.MEDIUM);
       if (ingreidants.size() >= 6 && ingreidants.size() < 8) recipe.setRecipeLevel(RecipeLevel.HARD);
       if (ingreidants.size() >= 8) recipe.setRecipeLevel(RecipeLevel.PRO);
   }

   public void setRecipeName(){
       recipe.setNameOfRecipe(recipeConstructView.getName());
    }
   public void setRecipeDescription(){
       recipe.setDescription(recipeConstructView.getDescription());

   }

   public void setWeightForIngrediants(HashMap<String, Double> list){
        list.forEach((k, v) -> ListOfIgrediants.listOfWIngrediants.get(k).setWeight(v));
   }

   public  void setupRecep(HashMap<String, Double> list){
        SetWeigthINgrediantsFromSet();
        setWeightForIngrediants(list);
        setRecipeLevel();
   }
}
