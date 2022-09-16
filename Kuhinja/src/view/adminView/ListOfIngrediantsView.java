package view.adminView;

import databasse.ListOfIgrediants;
import history.History;

import java.util.concurrent.atomic.AtomicInteger;

public class ListOfIngrediantsView {

    public ListOfIngrediantsView() {
    }

    public void printListOfINgredianst(){
        System.out.println("List og ingredinats: ");
        System.out.println();

        AtomicInteger counter = new AtomicInteger(1);

        ListOfIgrediants.listOfWIngrediants.forEach((k, v) -> System.out.println(counter.getAndIncrement() + ": " + k));
        AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
        adminViewMenu.PrintAdminViewPage();
    }
}
