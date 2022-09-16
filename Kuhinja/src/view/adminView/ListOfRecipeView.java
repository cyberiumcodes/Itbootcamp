package view.adminView;

import databasse.ListOfRecipes;
import history.History;
import view.startApp.StartApp;

public class ListOfRecipeView {

    public ListOfRecipeView() {
    }

    public void printListOfRecipies(){
        System.out.println("0 - back to previous menu");
        System.out.println("List of recepies: ");
        int count = 1;

        for (var el:
                ListOfRecipes.listOfRecipes.keySet()) {
            System.out.println(count + " : " + el);
            count++;
        }

        String input = StartApp.scanner.nextLine();
        if (input.equals("0")){
            AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
            adminViewMenu.PrintAdminViewPage();
        } else {
            System.out.println("Type 0 for go to admin menu!");
        }
        AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
        adminViewMenu.PrintAdminViewPage();
    }
}
