package controllers.regularUserController;

import databasse.ListOfRecipes;
import history.History;
import view.recipeview.RecipeView;
import view.startApp.StartApp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RegularUserMenuCotroller {
    ArrayList<String> recipes = new ArrayList<>();
    public RegularUserMenuCotroller() {
    }

    public void PrintListOfFoods(){
        AtomicInteger counter = new AtomicInteger(1);
        ListOfRecipes.listOfRecipes.forEach((s, recipe) -> {
            System.out.println(
                    counter + " : " + s + " price: " + recipe.getPrice()
            );
            counter.addAndGet(1);
            recipes.add(s);
        }
        );
    }

    public void PrintFoodRecipe(String unos){
        if (!unos.equals("0")){
            try {
                RecipeView recipeView = new RecipeView(ListOfRecipes.listOfRecipes.get(recipes.get(Integer.parseInt(unos) - 1)));
                recipeView.printRecipe();
            }catch (Exception e){
                System.out.println("Nije validan unos");
            }
        } else HistoryBack();

    }

    public void buyOrBack(String unos){
        switch (unos){
            case "1":
                System.out.println("buyiinh"); break;
            case "2":
                System.out.println("go back"); break;
            default:
                System.out.println("NIje validan unos");
                break;
        }
    }

    public void HistoryBack(){
        StartApp startApp = (StartApp) History.history.pop();
        startApp.startapp();

    }
}
