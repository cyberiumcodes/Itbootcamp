package view.adminView;

import history.History;
import model.recipe.WeightIngrediant;
import view.startApp.StartApp;

public class AddingIngrediants {
    private final String nameOfIngredinatsMessage = "Please add name of ingrediant: ";
    private final String netoOfINgredianstMwssage = "Add neto weiht of ingrediant: ";
    private final String pricePerWeightMessage = "Add a price for ingredinats to sell: ";

    public AddingIngrediants() {
    }

    public void printAddIngredinatsScreen(){
        System.out.println("You are in adding ingrediant mode: ");
        System.out.println("0 - back to previous menu");
        System.out.println(nameOfIngredinatsMessage);
        String name = StartApp.scanner.nextLine();
        System.out.println(pricePerWeightMessage);
        Double price = StartApp.scanner.nextDouble();
        System.out.println(netoOfINgredianstMwssage);
        Double neto = StartApp.scanner.nextDouble();

        new WeightIngrediant(name,price,neto).setNeto(neto);
        AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
        adminViewMenu.PrintAdminViewPage();

        // need to finish this up!!
    }


}
