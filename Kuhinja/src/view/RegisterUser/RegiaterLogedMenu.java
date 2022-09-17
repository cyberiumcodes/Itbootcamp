package view.RegisterUser;

import databasse.ListOfRecipes;

import model.users.RegularUser;
import view.recipeview.RecipeView;
import view.startApp.StartApp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RegiaterLogedMenu {
    private final String welcomeMessage = "Welcome ";
    private final String listOfFoods = "List Of foods";
    RegularUser regularUser;

    public RegiaterLogedMenu(RegularUser regularUser) {
        this.regularUser = regularUser;
    }

    public void PrintListOfFoods(){
        AtomicInteger count = new AtomicInteger(1);
        ListOfRecipes.listOfRecipes.forEach((name, recipe) -> {
            System.out.println(count.getAndIncrement() + " : " + name + " price: " + recipe.getPrice());
        });
    }

    public void PrintScreen(){
        System.out.println(welcomeMessage);
        System.out.println();
        System.out.println(listOfFoods);
        System.out.println("-".repeat(30));
        PrintListOfFoods();
        ArrayList<String> recipesList = new ArrayList<>();
        ListOfRecipes.listOfRecipes.forEach((s, recipe) -> recipesList.add(s));

        String unos = StartApp.scanner.nextLine();

        RecipeView recipeView = new RecipeView(ListOfRecipes.listOfRecipes.get(recipesList.get(Integer.parseInt(unos) - 1)));
        recipeView.printRecipe();

        System.out.println("3 : add to favorites");
        System.out.println("4 : scalle recipe by double");
        System.out.println("5 : scalle recipe by third");
        System.out.println("0 : exit");

        unos = StartApp.scanner.nextLine();

        switch (unos){
            case "1": recipeView.getRecipe().byingRecipe();break;
            case "2": PrintListOfFoods();break;
            case "3": recipeView.setFavorite(regularUser);break;
            case "4": recipeView.getRecipe().scaleRecipeNeto(2);break;
            case "5": recipeView.getRecipe().scaleRecipeNeto(3);break;
            case "0": new StartApp().startapp();break;
            default:
                System.out.println("NOT VALID INPUT");
        }


    }


}
