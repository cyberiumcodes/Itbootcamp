package view.regularUser;

import controllers.adminController.AdminController;
import controllers.regularUserController.RegularUserMenuCotroller;
import history.History;
import view.startApp.StartApp;

public class RegularMenuView {
private final String welcomeRegularUserScreen = "Welcome guest";
private final String backButtonMessage = "0 - to go back";
private final String listOfFoods = "You can choose your food order!";

    public RegularMenuView() {
    }

    public void printRegularUserScreen(){
        System.out.println(welcomeRegularUserScreen);
        System.out.println();
        System.out.println(backButtonMessage);
        System.out.println();
        System.out.println(listOfFoods);
        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println();
        History.history.add(this);
        RegularUserMenuCotroller regularUserMenuCotroller = new RegularUserMenuCotroller();
        regularUserMenuCotroller.PrintListOfFoods();
        String unos = StartApp.scanner.nextLine();
        regularUserMenuCotroller.PrintFoodRecipe(unos);
        String choice = StartApp.scanner.nextLine();
        switch (choice){
            case "1":
                System.out.println("buying");
                regularUserMenuCotroller.buyRecipe(unos);
                System.out.println(AdminController.missingWeightIngrediant);
                StartApp startApp = (StartApp) History.history.pop();

                break;
            case "2":
                this.printRegularUserScreen();
                break;
            default:
                System.out.println("not valid");
            break;
        }
    }
}
