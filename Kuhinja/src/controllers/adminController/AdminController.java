package controllers.adminController;

import model.recipe.WeightIngrediant;
import model.users.Administrator;
import model.users.User;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

     public static List<WeightIngrediant> missingWeightIngrediant = new ArrayList<>();

    public  List<WeightIngrediant> getMissingWeightIngrediant() {
        return missingWeightIngrediant;
    }

    public void setMissingWeightIngrediant(WeightIngrediant weightIngrediant){
        this.missingWeightIngrediant.add(weightIngrediant);
    }

    public boolean isLoginSucsesfull(String password, Administrator administrator){
        return password.equals(administrator.getPassword());
    }

    public void changePassword(Administrator administrator, String password){
        administrator.setPassword(password);
    }


}
