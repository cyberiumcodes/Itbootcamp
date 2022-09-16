package controllers.adminController.recipeController;

import model.recipe.WeightIngrediant;

public class WeightIngrediantController {

    public WeightIngrediantController() {
    }

    public void setWeightIngrediant(String name,double price, double neto){
        new WeightIngrediant(name, price, neto);
    }
}
