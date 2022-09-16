package databasse;

import model.recipe.WeightIngrediant;

import java.util.HashMap;

public class ListOfIgrediants {
    public static HashMap<String, WeightIngrediant> listOfWIngrediants = new HashMap<>();

    public ListOfIgrediants(String name, WeightIngrediant weightIngrediant) {
        listOfWIngrediants.put(name, weightIngrediant);
    }
}
