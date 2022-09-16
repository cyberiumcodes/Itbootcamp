package view.RegisterUser;

import databasse.ListOfRecipes;
import model.users.RegularUser;

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

    }


}
