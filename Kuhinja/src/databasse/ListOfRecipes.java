package databasse;

import model.recipe.Recipe;

import java.util.HashMap;
import java.util.Map;

public class ListOfRecipes {
    public static Map<String, Recipe> listOfRecipes = new HashMap<>();


    public void setListOfRecipes( Recipe recipe){
        listOfRecipes.put(recipe.getNameOfRecipe(), recipe);
    }
}
