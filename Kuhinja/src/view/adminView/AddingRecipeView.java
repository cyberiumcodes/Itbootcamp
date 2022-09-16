package view.adminView;

import controllers.adminController.recipeController.RecipeController;
import history.History;
import model.recipe.RecipeLevel;
import view.startApp.StartApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddingRecipeView {
    final  String nameMessage = "Unesite ime recepta: ";
    final String ingrediantsMessage = "Unesite sastojak: ";
    final String ingrediantsNetoMessage = "Unesite potrebnu kolicinu";
    final String descriptionMessage = "Unesite opis recepta";

    private String name;
    private RecipeLevel recipeLevel;
    private String description;

    public HashMap<String , Double> ingrediansForRecipe = new HashMap<>();

    public AddingRecipeView() {
    }

    public AddingRecipeView(String name, RecipeLevel recipeLevel, String description) {
        this.name = name;
        this.recipeLevel = recipeLevel;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void setName() {
        System.out.println(nameMessage);
        this.name = StartApp.scanner.nextLine();
    }

    public HashMap<String, Double> getIngrediansForRecipe() {
        return ingrediansForRecipe;
    }

    public RecipeLevel getRecipeLevel() {
        return recipeLevel;
    }

    public void setRecipeLevel() {
        System.out.println("Unesite tezinu recepata:");
        System.out.println("1 - begginer, 2 - easy, 3 - medium, 4 - hard, 5 - pro ");
        String unos = StartApp.scanner.nextLine();

        switch (unos){
            case "1": this.recipeLevel = RecipeLevel.BEGINNER; break;
            case "2": this.recipeLevel = RecipeLevel.EASY; break;
            case "3": this.recipeLevel = RecipeLevel.MEDIUM; break;
            case "4": this.recipeLevel = RecipeLevel.HARD; break;
            case "5": this.recipeLevel = RecipeLevel.PRO; break;
            default:
                System.out.println("Nije unet ispravan unos");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        System.out.println(descriptionMessage);
        this.description = StartApp.scanner.nextLine();
    }



    public void addIngrediants(){
        System.out.println("Unesite sastojke za recept i njihovu kolicinu, za kraj upisite exit!");

        while (true){
            System.out.println(ingrediantsMessage);
            String tempName = StartApp.scanner.nextLine();
            if (tempName.equals("exit")) break;
            System.out.println(ingrediantsNetoMessage);
            try {
                Double tempNeto = Double.valueOf(StartApp.scanner.nextLine());
                ingrediansForRecipe.put(tempName, tempNeto);
            } catch (Exception e){
                System.out.println("Unos nije validan");
            }


        }
    }

    public ArrayList<String> keysToList(HashMap<String, Double> ingrediansForRecipe){
        ArrayList<String> temp = new ArrayList<>();
        int index = 0;
        ingrediansForRecipe.forEach((k , d) -> temp.add(k));
        return temp;
    }

    public void printRecepiview(){
        setName();
        setRecipeLevel();
        addIngrediants();
        setDescription();
        RecipeController recipeController = new RecipeController(name, description, keysToList(ingrediansForRecipe));
        recipeController.setupRecep(ingrediansForRecipe);
        AdminViewMenu adminViewMenu = (AdminViewMenu) History.history.pop();
        adminViewMenu.PrintAdminViewPage();
    }

}
